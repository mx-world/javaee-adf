package org.mxworld.hra.view.backing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.util.Map;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.DBSequence;

import org.apache.myfaces.trinidad.model.UploadedFile;

import org.mxworld.hra.view.framework.HraBackingBean;

public class ImageUploadBean extends HraBackingBean implements Serializable {
    private String _uploadedImageName = "/images/uploadPlaceholder.png";
    private UploadedFile _uploadedImageFile;

    public ImageUploadBean() {
        super();
    }

    public void setUploadedImageName(String _uploadedImageName) {
        this._uploadedImageName = _uploadedImageName;
    }

    public String getUploadedImageName() {
        return _uploadedImageName;
    }

    public void setUploadedImageFile(UploadedFile _uploadedImageFile) {
        this._uploadedImageFile = _uploadedImageFile;
    }

    public UploadedFile getUploadedImageFile() {
        return _uploadedImageFile;
    }

    public void fileUploadedListener(ValueChangeEvent valueChangeEvent) {
        UploadedFile file = (UploadedFile) valueChangeEvent.getNewValue();
        if (file != null) {
            String fileName = file.getFilename();
            setUploadedImageName("/images/" + fileName);
            System.out.println("fileName = " + fileName);
            copyFileToImagesDir(file);
            System.out.println("copyFileToImagesDir() DONE");
            insertRows();
            System.out.println("insertRows() DONE");
        }
    }

    private void copyFileToImagesDir(UploadedFile file) {
        ServletContext servletCtx =
            (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String imageDirPath = servletCtx.getRealPath("/images");
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(imageDirPath + "/" + file.getFilename());
            int readData;
            while ((readData = is.read()) != -1) {
                os.write(readData);
            }
            is.close();
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRows() {
        AdfFacesContext afctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfParams = afctx.getPageFlowScope();
        DBSequence empId0 = (DBSequence) pfParams.get("currentEmpId");
        Integer empId = empId0.getSequenceNumber().intValue();
        System.out.println("In insertRows(): empId="+empId);        
        OperationBinding insImage = getBindings().getOperationBinding("createNewImageForEmployee");
        Map args = insImage.getParamsMap();
        args.put("employeeId", empId);
        //args.put("employeeId", new Integer( empId));
        args.put("imageName", _uploadedImageName);
        insImage.execute();
    }
}
