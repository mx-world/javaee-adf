package org.mxworld.hra.model.vo;

import org.mxworld.hra.common.framework.HraViewObjectImpl;
import org.mxworld.hra.model.vo.common.AllEmployees;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Apr 29 21:30:32 EDT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AllEmployeesImpl extends HraViewObjectImpl implements AllEmployees {
    private static final String EMPLOYEE_BY_ID_CRITERIA = "EmpByIdCriteria";

    /**
     * This is the default constructor (do not remove).
     */
    public AllEmployeesImpl() {
    }

    public void queryEmployeeById(Integer id) {
        if (id != null) {
            setApplyViewCriteriaName(EMPLOYEE_BY_ID_CRITERIA);
            setempId(id);
            executeQuery();
        }
    }

    /**
     * Returns the variable value for empId.
     * @return variable value for empId
     */
    public Integer getempId() {
        return (Integer) ensureVariableManager().getVariableValue("empId");
    }

    /**
     * Sets <code>value</code> for variable empId.
     * @param value value to bind as empId
     */
    public void setempId(Integer value) {
        ensureVariableManager().setVariableValue("empId", value);
    }
}

