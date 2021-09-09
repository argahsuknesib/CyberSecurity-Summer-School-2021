package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;

public class CameraResetStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CameraResetStep f11655O000000o;

    public CameraResetStep_ViewBinding(CameraResetStep cameraResetStep, View view) {
        this.f11655O000000o = cameraResetStep;
        cameraResetStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        cameraResetStep.mWebView = (SmartHomeWebView) Utils.findRequiredViewAsType(view, R.id.kuailian_reset_web_view, "field 'mWebView'", SmartHomeWebView.class);
        cameraResetStep.mButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mButton'", Button.class);
        cameraResetStep.mCheck = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCheck'", CheckBox.class);
        cameraResetStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        cameraResetStep.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        cameraResetStep.mCheckBoxRootView = Utils.findRequiredView(view, R.id.check_box_root, "field 'mCheckBoxRootView'");
        cameraResetStep.mDeviceDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.device_detail, "field 'mDeviceDetail'", TextView.class);
    }

    public void unbind() {
        CameraResetStep cameraResetStep = this.f11655O000000o;
        if (cameraResetStep != null) {
            this.f11655O000000o = null;
            cameraResetStep.mTitleBar = null;
            cameraResetStep.mWebView = null;
            cameraResetStep.mButton = null;
            cameraResetStep.mCheck = null;
            cameraResetStep.mReturnBtn = null;
            cameraResetStep.mTitle = null;
            cameraResetStep.mCheckBoxRootView = null;
            cameraResetStep.mDeviceDetail = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
