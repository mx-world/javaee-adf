package org.mxworld.hra.view.backing;

import java.io.Serializable;

import java.util.Map;

import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;

import oracle.adf.view.rich.event.DropEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.mxworld.hra.view.framework.HraBackingBean;

public class DefaultImageSelectionBean extends HraBackingBean implements Serializable {
    private String _selectedImage = "/images/newDefaultPlaceholder.png";

    public void setSelectedImage(String _selectedImage) {
        this._selectedImage = _selectedImage;
    }

    public String getSelectedImage() {
        return _selectedImage;
    }

    public DnDAction dragAndDropHandler(DropEvent dropEvent) {
        FacesCtrlHierNodeBinding draggedNode = findDraggedNode(dropEvent);
        if (draggedNode != null) {
            String imageName = (String) draggedNode.getAttribute("Image");
            Integer imageId = (Integer) draggedNode.getAttribute("ImageId");
            System.out.println("In dragAndDropHandler(): imageName =" + imageName + "; imageId =" + imageId );
            if (imageId != null) {
                _selectedImage = imageName;
                defineDefaultImage(imageId);
                return DnDAction.COPY;
            }
        }
        return DnDAction.NONE;
    }

    private FacesCtrlHierNodeBinding findDraggedNode(DropEvent dropEvent) {
        FacesCtrlHierNodeBinding node = null;
        Transferable transferable = dropEvent.getTransferable();
        DataFlavor<RowKeySet> rowKeySetFlavor = DataFlavor.getDataFlavor(RowKeySet.class, "empImagesModel");
        RowKeySet rowKeySet = transferable.getData(rowKeySetFlavor);
        if (rowKeySet != null) {
            CollectionModel dragModel = transferable.getData(CollectionModel.class);
            if (dragModel != null) {
                Object currKey = rowKeySet.iterator().next();
                dragModel.setRowKey(currKey);
                node = (FacesCtrlHierNodeBinding) dragModel.getRowData();
            }
        }
        return node;
    }

    private void defineDefaultImage(Integer imageId) {
        OperationBinding setDefault = getBindings().getOperationBinding("defineDefaultImage");
        Map args = setDefault.getParamsMap();
        args.put("newDefaultImageId", imageId);
        setDefault.execute();
    }
}
