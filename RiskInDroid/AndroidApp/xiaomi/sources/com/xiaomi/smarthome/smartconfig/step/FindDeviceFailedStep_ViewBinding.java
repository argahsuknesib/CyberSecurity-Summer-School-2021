package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class FindDeviceFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private FindDeviceFailedStep f11764O000000o;

    public FindDeviceFailedStep_ViewBinding(FindDeviceFailedStep findDeviceFailedStep, View view) {
        this.f11764O000000o = findDeviceFailedStep;
        findDeviceFailedStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        findDeviceFailedStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        findDeviceFailedStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        findDeviceFailedStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        findDeviceFailedStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        FindDeviceFailedStep findDeviceFailedStep = this.f11764O000000o;
        if (findDeviceFailedStep != null) {
            this.f11764O000000o = null;
            findDeviceFailedStep.mIcon = null;
            findDeviceFailedStep.mMainTitle = null;
            findDeviceFailedStep.mSubMainTitle = null;
            findDeviceFailedStep.mLeftBtn = null;
            findDeviceFailedStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
