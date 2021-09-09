package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ApDeviceUserErrorStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ApDeviceUserErrorStep f11639O000000o;

    public ApDeviceUserErrorStep_ViewBinding(ApDeviceUserErrorStep apDeviceUserErrorStep, View view) {
        this.f11639O000000o = apDeviceUserErrorStep;
        apDeviceUserErrorStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        apDeviceUserErrorStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        apDeviceUserErrorStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        apDeviceUserErrorStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        apDeviceUserErrorStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        ApDeviceUserErrorStep apDeviceUserErrorStep = this.f11639O000000o;
        if (apDeviceUserErrorStep != null) {
            this.f11639O000000o = null;
            apDeviceUserErrorStep.mIcon = null;
            apDeviceUserErrorStep.mMainTitle = null;
            apDeviceUserErrorStep.mSubMainTitle = null;
            apDeviceUserErrorStep.mLeftBtn = null;
            apDeviceUserErrorStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
