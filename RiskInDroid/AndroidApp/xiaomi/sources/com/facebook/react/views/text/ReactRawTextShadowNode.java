package com.facebook.react.views.text;

import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    private String mText = null;

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String getText() {
        return this.mText;
    }

    public String toString() {
        return getViewClass() + " [text: " + this.mText + "]";
    }
}
