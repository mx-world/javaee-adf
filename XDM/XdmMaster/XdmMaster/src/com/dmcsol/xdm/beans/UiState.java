package com.dmcsol.xdm.beans;


public class UiState {
    private String currentTF = "/WEB-INF/task-overview-edit-flow.xml#task-overview-edit-flow";

    public void setCurrentTF(String s) {
        currentTF = s;
    }

    public String getCurrentTF() {
        return currentTF;
    }
}
