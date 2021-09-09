package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class PasswdSendFinalFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private PasswdSendFinalFailedStep f11774O000000o;

    public PasswdSendFinalFailedStep_ViewBinding(PasswdSendFinalFailedStep passwdSendFinalFailedStep, View view) {
        this.f11774O000000o = passwdSendFinalFailedStep;
        passwdSendFinalFailedStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        passwdSendFinalFailedStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        passwdSendFinalFailedStep.mTitlebarTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitlebarTv'", TextView.class);
        passwdSendFinalFailedStep.mDeviceImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_image, "field 'mDeviceImage'", SimpleDraweeView.class);
        passwdSendFinalFailedStep.mTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tips, "field 'mTips'", TextView.class);
        passwdSendFinalFailedStep.mButton1 = Utils.findRequiredView(view, R.id.button1, "field 'mButton1'");
        passwdSendFinalFailedStep.mButton2 = Utils.findRequiredView(view, R.id.button2, "field 'mButton2'");
        passwdSendFinalFailedStep.mButton3 = Utils.findRequiredView(view, R.id.button3, "field 'mButton3'");
        passwdSendFinalFailedStep.mButtonName_1 = (TextView) Utils.findRequiredViewAsType(view, R.id.button1_name, "field 'mButtonName_1'", TextView.class);
        passwdSendFinalFailedStep.mButtonName_2 = (TextView) Utils.findRequiredViewAsType(view, R.id.button2_name, "field 'mButtonName_2'", TextView.class);
        passwdSendFinalFailedStep.mButtonName_3 = (TextView) Utils.findRequiredViewAsType(view, R.id.button3_name, "field 'mButtonName_3'", TextView.class);
    }

    public void unbind() {
        PasswdSendFinalFailedStep passwdSendFinalFailedStep = this.f11774O000000o;
        if (passwdSendFinalFailedStep != null) {
            this.f11774O000000o = null;
            passwdSendFinalFailedStep.mTitleBar = null;
            passwdSendFinalFailedStep.mReturnBtn = null;
            passwdSendFinalFailedStep.mTitlebarTv = null;
            passwdSendFinalFailedStep.mDeviceImage = null;
            passwdSendFinalFailedStep.mTips = null;
            passwdSendFinalFailedStep.mButton1 = null;
            passwdSendFinalFailedStep.mButton2 = null;
            passwdSendFinalFailedStep.mButton3 = null;
            passwdSendFinalFailedStep.mButtonName_1 = null;
            passwdSendFinalFailedStep.mButtonName_2 = null;
            passwdSendFinalFailedStep.mButtonName_3 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
