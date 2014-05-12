package org.mxworld.hra.view.backing;

import java.util.HashMap;

import oracle.adf.controller.TaskFlowId;

import org.mxworld.hra.view.UIManager;

/**
 * Backing bean class for the main search screen used to
 * manage which view is shown on that screen.
 * Defined in the adfc-config.xml file as the managed bean
 * searchScreenBean in backingBean scope.
 * References the UI manager for a longer running state.
 * @see org.mxworld.hra.view.UIManager
 */
public class SearchScreenBean {

    // The following Map and static block defines the mapping
    // between the focus flag held in the UIManager
    // and a particular pageflow definition to
    // swap into the region when that state is selected

    private static final HashMap<UIManager.Screen, String> _REGION_MAP;
    static {
        _REGION_MAP = new HashMap<UIManager.Screen, String>(2);
        _REGION_MAP.put(UIManager.Screen.EMPLOYEE_SEARCH, "/WEB-INF/searchEmp-flow.xml#searchEmp-flow");
        _REGION_MAP.put(UIManager.Screen.DEPARTMENT_TREE, "/WEB-INF/deptTree-flow.xml#deptTree-flow");
    }

    // Store a reference to the state holder (this will be injected)
    private UIManager _uiManager;

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(_REGION_MAP.get(_uiManager.getSearchScreenFocus()));
    }

    /**
     * Used to inject the UI Manager during the creation of this bean
     * @see adfc-config.xml
     * @param _uiManager
     */
    public void setUiManager(UIManager _uiManager) {
        this._uiManager = _uiManager;
    }
}
