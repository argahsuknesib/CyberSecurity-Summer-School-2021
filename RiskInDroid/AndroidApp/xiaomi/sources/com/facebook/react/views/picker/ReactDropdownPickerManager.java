package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name = "AndroidDropdownPicker")
public class ReactDropdownPickerManager extends ReactPickerManager {
    public String getName() {
        return "AndroidDropdownPicker";
    }

    /* access modifiers changed from: protected */
    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker(themedReactContext, 1);
    }
}
