package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PasswdSendFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private PasswdSendFailedStep f11769O000000o;

    public PasswdSendFailedStep_ViewBinding(PasswdSendFailedStep passwdSendFailedStep, View view) {
        this.f11769O000000o = passwdSendFailedStep;
        passwdSendFailedStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        passwdSendFailedStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        passwdSendFailedStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        passwdSendFailedStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        passwdSendFailedStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        PasswdSendFailedStep passwdSendFailedStep = this.f11769O000000o;
        if (passwdSendFailedStep != null) {
            this.f11769O000000o = null;
            passwdSendFailedStep.mIcon = null;
            passwdSendFailedStep.mMainTitle = null;
            passwdSendFailedStep.mSubMainTitle = null;
            passwdSendFailedStep.mLeftBtn = null;
            passwdSendFailedStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
