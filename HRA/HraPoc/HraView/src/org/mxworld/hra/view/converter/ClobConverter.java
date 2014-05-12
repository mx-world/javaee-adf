package org.mxworld.hra.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import oracle.jbo.domain.ClobDomain;

public class ClobConverter implements Converter {
    public ClobConverter() {
        super();
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        return new ClobDomain(string);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return ((ClobDomain) object).toString();
    }
}
