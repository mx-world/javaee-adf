package org.mxworld.dra.returndvd.view.beans;

import java.util.Iterator;
import java.util.List;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.RowSetIterator;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.mxworld.dra.returndvd.model.view.common.RentalVORow;

public class ReturnBean {
    private RichTable filmRentalTable;

    public ReturnBean() {
    }

    public String returnDvd() {
        // find selected row (the table iterator)
        RowKeySet sel = getFilmRentalTable().getSelectedRowKeys();
        Iterator selIter = sel.iterator();
        // get iterator for all data records
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCBindingContainer dcb = (DCBindingContainer) bc;
        DCIteratorBinding rentalIter = dcb.findIteratorBinding("RentalUnreturnedIterator");
        RowSetIterator rsi = rentalIter.getRowSetIterator();
        // find the selected record in the data iterator
        Key key = (Key) ((List) selIter.next()).get(0);
        RentalVORow r = (RentalVORow) rsi.getRow(key);
        r.registerReturn();
        OperationBinding ob = bc.getOperationBinding("Commit");
        ob.execute();
        return null;
    }

    public void setFilmRentalTable(RichTable filmRentalTable) {
        this.filmRentalTable = filmRentalTable;
    }

    public RichTable getFilmRentalTable() {
        return filmRentalTable;
    }
}
