package org.mxworld.hra.view;

import java.io.Serializable;

/**
 * Class which manages persistent UI state
 * for the application.
 * Defined in the adfc-config.xml file as the
 * managed bean uiManager in session scope.
 */
public class UIManager implements Serializable {
    //This list could grow as we add more Pages / Screens

    public enum Screen {
        EMPLOYEE_SEARCH,
        DEPARTMENT_TREE
    }

    //Store the current screen state
    private Screen _searchScreenFocus = Screen.EMPLOYEE_SEARCH;
    
    // parameter for the editEmp-flow 
    private int _editEmpId;

    public void setEditEmpId(int _editEmpId) {
        this._editEmpId = _editEmpId;
    }

    public int getEditEmpId() {
        return _editEmpId;
    }

    /**
     * Set the searchScreenFocus flag from a text
     * version of the screen name
     * @param focus String matching the enumeration value
     */
    public void setSearchScreenFocus(String focus) {
        this._searchScreenFocus = Screen.valueOf(focus);
    }

    /**
     * Set the searchScreenFocus flag from the enum value
     * @param focus
     */
    public void setSearchScreenFocus(UIManager.Screen focus) {
        this._searchScreenFocus = focus;
    }

    /**
     * Return the searchScreenFocus as the enum constant
     * @return
     */
    public UIManager.Screen getSearchScreenFocus() {
        return _searchScreenFocus;
    }
}
