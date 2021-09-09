package com.facebook.drawee.generic;

public class ExtendGenericDraweeHierarchy extends GenericDraweeHierarchy {
    private boolean mInitializing;

    public ExtendGenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        super(genericDraweeHierarchyBuilder);
    }

    public void reset() {
        if (!this.mInitializing) {
            super.reset();
        }
    }

    public void setInitializing(boolean z) {
        this.mInitializing = z;
    }
}
