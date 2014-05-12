package org.mxworld.hra.view.framework;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;

public abstract class HraBackingBean {
    /**
     * Provide standardized access to the binding context for all backing
     * beans
     * @return bindings
     */
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
