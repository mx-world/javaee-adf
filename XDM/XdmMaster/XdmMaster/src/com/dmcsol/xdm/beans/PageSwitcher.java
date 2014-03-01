package com.dmcsol.xdm.beans;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class PageSwitcher implements Serializable {    
    private UiState uiState;

    public void setUiState(UiState state) {
        uiState = state;
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(uiState.getCurrentTF());
    }

}
