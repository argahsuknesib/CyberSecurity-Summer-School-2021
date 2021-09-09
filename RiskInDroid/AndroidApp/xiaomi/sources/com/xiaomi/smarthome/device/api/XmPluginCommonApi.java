package com.xiaomi.smarthome.device.api;

import android.app.Dialog;
import android.view.Window;

public abstract class XmPluginCommonApi {
    protected static XmPluginCommonApi sXmPluginHostApi;

    public abstract void setMenuDialogWindowAnimations(Window window);

    public abstract void setWindowAnimations(Dialog dialog);

    public static XmPluginCommonApi instance() {
        return sXmPluginHostApi;
    }
}
