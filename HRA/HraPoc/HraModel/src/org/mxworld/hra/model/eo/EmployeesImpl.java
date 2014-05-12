package org.mxworld.hra.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;

import oracle.jbo.server.TransactionEvent;

import org.mxworld.hra.common.framework.HraEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 23 16:58:35 EDT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeesImpl extends HraEntityImpl {
    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        if (operation == DML_UPDATE) {
            String oldJobId = (String) getPostedAttribute(JOBID);
            if (!getJobId().equals(oldJobId)) {
                //Get the set of JobHistory rows
                RowIterator pastJobs = this.getJobHistory();
                Timestamp histStartDate;
                if (pastJobs.hasNext()) {
                    JobHistoryImpl row = (JobHistoryImpl) pastJobs.next();
                    histStartDate = row.getEndDate();
                } else {
                    //No history rows - fall back to the hiredate
                    histStartDate = getHireDate();
                }
                //You now have everything to create the JobHistory row
                JobHistoryImpl newRow = (JobHistoryImpl) pastJobs.createRow();
                newRow.setJobId(oldJobId);
                // the department may have been changed as part
                //of the same transaction so use the old version
                newRow.setDepartmentId((Integer) getPostedAttribute(DEPARTMENTID));
                newRow.setStartDate(histStartDate);
                newRow.setEndDate(new Timestamp(System.currentTimeMillis()));
                //And add the new row to the history rowset
                pastJobs.insertRow(newRow);
            }
        }
        super.doDML(operation, e);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        EmployeeId,
        FirstName,
        LastName,
        Email,
        PhoneNumber,
        HireDate,
        JobId,
        Salary,
        CommissionPct,
        ManagerId,
        DepartmentId,
        CreatedBy,
        CreatedDate,
        ModifiedBy,
        ModifiedDate,
        Employees,
        ManagerIdEmployees,
        Departments,
        Departments1,
        Jobs,
        JobHistory,
        Biographies,
        EmpImageUsages,
        SalaryValidatorAccessor;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int FIRSTNAME = AttributesEnum.FirstName.index();
    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int PHONENUMBER = AttributesEnum.PhoneNumber.index();
    public static final int HIREDATE = AttributesEnum.HireDate.index();
    public static final int JOBID = AttributesEnum.JobId.index();
    public static final int SALARY = AttributesEnum.Salary.index();
    public static final int COMMISSIONPCT = AttributesEnum.CommissionPct.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int EMPLOYEES = AttributesEnum.Employees.index();
    public static final int MANAGERIDEMPLOYEES = AttributesEnum.ManagerIdEmployees.index();
    public static final int DEPARTMENTS = AttributesEnum.Departments.index();
    public static final int DEPARTMENTS1 = AttributesEnum.Departments1.index();
    public static final int JOBS = AttributesEnum.Jobs.index();
    public static final int JOBHISTORY = AttributesEnum.JobHistory.index();
    public static final int BIOGRAPHIES = AttributesEnum.Biographies.index();
    public static final int EMPIMAGEUSAGES = AttributesEnum.EmpImageUsages.index();
    public static final int SALARYVALIDATORACCESSOR = AttributesEnum.SalaryValidatorAccessor.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmployeesImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("org.mxworld.hra.model.eo.Employees");
    }


    /**
     * Gets the attribute value for EmployeeId, using the alias name EmployeeId.
     * @return the value of EmployeeId
     */
    public DBSequence getEmployeeId() {
        return (DBSequence) getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeId.
     * @param value value to set the EmployeeId
     */
    public void setEmployeeId(DBSequence value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for FirstName, using the alias name FirstName.
     * @return the value of FirstName
     */
    public String getFirstName() {
        return (String) getAttributeInternal(FIRSTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FirstName.
     * @param value value to set the FirstName
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**
     * Gets the attribute value for LastName, using the alias name LastName.
     * @return the value of LastName
     */
    public String getLastName() {
        return (String) getAttributeInternal(LASTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastName.
     * @param value value to set the LastName
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**
     * Gets the attribute value for Email, using the alias name Email.
     * @return the value of Email
     */
    public String getEmail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Email.
     * @param value value to set the Email
     */
    public void setEmail(String value) {
        setAttributeInternal(EMAIL, value);
    }

    /**
     * Gets the attribute value for PhoneNumber, using the alias name PhoneNumber.
     * @return the value of PhoneNumber
     */
    public String getPhoneNumber() {
        return (String) getAttributeInternal(PHONENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for PhoneNumber.
     * @param value value to set the PhoneNumber
     */
    public void setPhoneNumber(String value) {
        setAttributeInternal(PHONENUMBER, value);
    }

    /**
     * Gets the attribute value for HireDate, using the alias name HireDate.
     * @return the value of HireDate
     */
    public Timestamp getHireDate() {
        return (Timestamp) getAttributeInternal(HIREDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for HireDate.
     * @param value value to set the HireDate
     */
    public void setHireDate(Timestamp value) {
        setAttributeInternal(HIREDATE, value);
    }

    /**
     * Gets the attribute value for JobId, using the alias name JobId.
     * @return the value of JobId
     */
    public String getJobId() {
        return (String) getAttributeInternal(JOBID);
    }

    /**
     * Sets <code>value</code> as the attribute value for JobId.
     * @param value value to set the JobId
     */
    public void setJobId(String value) {
        setAttributeInternal(JOBID, value);
    }

    /**
     * Gets the attribute value for Salary, using the alias name Salary.
     * @return the value of Salary
     */
    public BigDecimal getSalary() {
        return (BigDecimal) getAttributeInternal(SALARY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salary.
     * @param value value to set the Salary
     */
    public void setSalary(BigDecimal value) {
        setAttributeInternal(SALARY, value);
    }

    /**
     * Gets the attribute value for CommissionPct, using the alias name CommissionPct.
     * @return the value of CommissionPct
     */
    public BigDecimal getCommissionPct() {
        return (BigDecimal) getAttributeInternal(COMMISSIONPCT);
    }

    /**
     * Sets <code>value</code> as the attribute value for CommissionPct.
     * @param value value to set the CommissionPct
     */
    public void setCommissionPct(BigDecimal value) {
        setAttributeInternal(COMMISSIONPCT, value);
    }

    /**
     * Gets the attribute value for ManagerId, using the alias name ManagerId.
     * @return the value of ManagerId
     */
    public Integer getManagerId() {
        return (Integer) getAttributeInternal(MANAGERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ManagerId.
     * @param value value to set the ManagerId
     */
    public void setManagerId(Integer value) {
        setAttributeInternal(MANAGERID, value);
    }

    /**
     * Gets the attribute value for DepartmentId, using the alias name DepartmentId.
     * @return the value of DepartmentId
     */
    public Integer getDepartmentId() {
        return (Integer) getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentId.
     * @param value value to set the DepartmentId
     */
    public void setDepartmentId(Integer value) {
        // Define some variable names to make the code more readable
        final Integer changeToDepartment = value;
        final Integer sales = new Integer(80);

        // First get the current value of the department so we can
        // do something only if this value *was* Sales.
        Integer changeFromDepartment = getDepartmentId();

        // Set the DepartmentId as usual.
        setAttributeInternal(DEPARTMENTID, value);

        // If changing from Sales to something else then
        // null out Commission. Check for null first to avoid an exception.
        if (!(changeFromDepartment == null)) {
            if (changeFromDepartment.equals(sales) && !changeToDepartment.equals(sales)) {
                setCommissionPct(null);
            } else {
                if (!changeFromDepartment.equals(sales) && changeToDepartment.equals(sales)) {
                    BigDecimal originalCommission = (BigDecimal) this.getPostedAttribute(COMMISSIONPCT);
                    if (originalCommission == null) {
                        originalCommission = new BigDecimal(0);
                    }
                    setCommissionPct(originalCommission);
                }
            }
        }
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Gets the attribute value for ModifiedBy, using the alias name ModifiedBy.
     * @return the value of ModifiedBy
     */
    public String getModifiedBy() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
     * @return the value of ModifiedDate
     */
    public Timestamp getModifiedDate() {
        return (Timestamp) getAttributeInternal(MODIFIEDDATE);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmployees() {
        return (RowIterator) getAttributeInternal(EMPLOYEES);
    }

    /**
     * @return the associated entity EmployeesImpl.
     */
    public EmployeesImpl getManagerIdEmployees() {
        return (EmployeesImpl) getAttributeInternal(MANAGERIDEMPLOYEES);
    }

    /**
     * Sets <code>value</code> as the associated entity EmployeesImpl.
     */
    public void setManagerIdEmployees(EmployeesImpl value) {
        setAttributeInternal(MANAGERIDEMPLOYEES, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getDepartments() {
        return (RowIterator) getAttributeInternal(DEPARTMENTS);
    }

    /**
     * @return the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public HraEntityImpl getDepartments1() {
        return (HraEntityImpl) getAttributeInternal(DEPARTMENTS1);
    }

    /**
     * Sets <code>value</code> as the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public void setDepartments1(HraEntityImpl value) {
        setAttributeInternal(DEPARTMENTS1, value);
    }

    /**
     * @return the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public HraEntityImpl getJobs() {
        return (HraEntityImpl) getAttributeInternal(JOBS);
    }

    /**
     * Sets <code>value</code> as the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public void setJobs(HraEntityImpl value) {
        setAttributeInternal(JOBS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getJobHistory() {
        return (RowIterator) getAttributeInternal(JOBHISTORY);
    }

    /**
     * @return the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public HraEntityImpl getBiographies() {
        return (HraEntityImpl) getAttributeInternal(BIOGRAPHIES);
    }

    /**
     * Sets <code>value</code> as the associated entity org.mxworld.hra.common.framework.HraEntityImpl.
     */
    public void setBiographies(HraEntityImpl value) {
        setAttributeInternal(BIOGRAPHIES, value);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmpImageUsages() {
        return (RowIterator) getAttributeInternal(EMPIMAGEUSAGES);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SalaryValidatorAccessor.
     */
    public RowSet getSalaryValidatorAccessor() {
        return (RowSet) getAttributeInternal(SALARYVALIDATORACCESSOR);
    }

    /**
     * @param employeeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence employeeId) {
        return new Key(new Object[] { employeeId });
    }


}

