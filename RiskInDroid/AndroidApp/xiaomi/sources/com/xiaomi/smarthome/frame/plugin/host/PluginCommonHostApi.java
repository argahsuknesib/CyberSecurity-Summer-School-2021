package com.xiaomi.smarthome.frame.plugin.host;

import android.app.Dialog;
import android.view.Window;
import com.xiaomi.smarthome.device.api.XmPluginCommonApi;

public abstract class PluginCommonHostApi extends XmPluginCommonApi {
    public PluginCommonHostApi() {
        XmPluginCommonApi.sXmPluginHostApi = this;
    }

    public void setWindowAnimations(Dialog dialog) {
        dialog.getWindow().setWindowAnimations(2132739285);
    }

    public void setMenuDialogWindowAnimations(Window window) {
        window.setWindowAnimations(2132739286);
    }
}
