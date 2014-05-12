package org.mxworld.hra.view.backing;

import javax.el.BeanELResolver;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import oracle.adf.controller.TaskFlowId;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.event.RegionNavigationEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.AttributeBinding;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import org.mxworld.hra.view.framework.HraBackingBean;

public class EmpEditBean extends HraBackingBean {
    private String _imageTaskFlowId = "/WEB-INF/imageLov-flow.xml#imageLov-flow";
    private String _selectedTaskFlowId = _imageTaskFlowId;
    
    //private String taskFlowId = "/WEB-INF/imageLov-flow.xml#imageLov-flow";

    public String getImageTaskFlowId() {
        System.out.println("getImageTaskFlowId(): _imageTaskFlowId = " + _imageTaskFlowId);
        return _imageTaskFlowId;
    }

    public void setSelectedTaskFlowId(String _selectedTaskFlowId) {
        System.out.println("setSelectedTaskFlowId: _selectedTaskFlowId = " + _selectedTaskFlowId);
        this._selectedTaskFlowId = _selectedTaskFlowId;
    }

    // this method never gets called!
    public String getSelectedTaskFlowId() {
        System.out.println("inside getSelectedTaskFlowId()");
        return _selectedTaskFlowId;
    }

    public String lockIcon_action() {
        // Access the Locked attribute binding
        AttributeBinding lockedBinding = (AttributeBinding) getBindings().getControlBinding("Locked");
        Boolean locked = false;
        if (lockedBinding != null) {
            //Get the current value of the transient attr
            locked = (Boolean) lockedBinding.getInputValue();
        }
        //The attribute may be null if no detail record exists yet
        if (locked == null) {
            // Set a default value
            locked = true;
            // Create a Biographies record
            OperationBinding createBio = getBindings().getOperationBinding("CreateBio");
            if (createBio != null) {
                createBio.execute();
            }
        }
        //Toggle the locked state
        lockedBinding.setInputValue(!locked);
        return null;
    }

    //public TaskFlowId getDynamicTaskFlowId() {
    public String getDynamicTaskFlowId() {
        System.out.println("inside getDynamicTaskFlowId()");
        return _selectedTaskFlowId;
        //return TaskFlowId.parse(_selectedTaskFlowId);
    }

    // this method never gets called!
    public void setDynamicTaskFlowId(String taskFlowId) {
        System.out.println("inside setDynamicTaskFlowId()");
        //this.taskFlowId = taskFlowId;
        this._imageTaskFlowId = taskFlowId;
    }

    public void navigationListener(RegionNavigationEvent regionNavigationEvent) {
        String newViewId = regionNavigationEvent.getNewViewId();
        if (newViewId == null) {
            RichRegion region = (RichRegion) regionNavigationEvent.getSource();
            RichPopup popup = findParentPopup(region);
            if (popup != null) {
                hidePopup(popup);
            }
        }
    }

    private RichPopup findParentPopup(UIComponent source) {
        UIComponent parent = source.getParent();
        while (parent != null && !(parent instanceof RichPopup)) {
            parent = parent.getParent();
        }
        return (RichPopup) parent;
    }

    private void hidePopup(RichPopup popup) {
        FacesContext context = FacesContext.getCurrentInstance();
        String popupId = popup.getClientId(context);
        Service.getRenderKitService(context, ExtendedRenderKitService.class).addScript(context,
                                "var popup = AdfPage.PAGE.findComponent('" + popupId + "'); popup.hide();");
    }

    public void swapEmptyTaskFlow(ClientEvent event) {
        System.out.println("inside swapEmptyTaskFlow() ");
        setSelectedTaskFlowId("");  
        // If event delivery set to immediate="true",
        // short-circuit to renderResponse.
        // Forcing an empty taskflow releases the bindings and view port.
        Boolean immediate = (Boolean) event.getParameters().get("immediate");
        if (immediate != null && immediate) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.renderResponse();
        }
    }
/*
    public TaskFlowId getDynamicTaskFlowId1() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId1(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }
*/
}
