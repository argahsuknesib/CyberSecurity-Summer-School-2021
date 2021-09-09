package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class DeviceInfoStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceInfoStep f11754O000000o;

    public DeviceInfoStep_ViewBinding(DeviceInfoStep deviceInfoStep, View view) {
        this.f11754O000000o = deviceInfoStep;
        deviceInfoStep.mDeviceIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mDeviceIcon'", SimpleDraweeView.class);
        deviceInfoStep.mDeviceInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mDeviceInfo'", TextView.class);
        deviceInfoStep.mDeviceInfoSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mDeviceInfoSubTitle'", TextView.class);
        deviceInfoStep.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
        deviceInfoStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        deviceInfoStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        deviceInfoStep.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
    }

    public void unbind() {
        DeviceInfoStep deviceInfoStep = this.f11754O000000o;
        if (deviceInfoStep != null) {
            this.f11754O000000o = null;
            deviceInfoStep.mDeviceIcon = null;
            deviceInfoStep.mDeviceInfo = null;
            deviceInfoStep.mDeviceInfoSubTitle = null;
            deviceInfoStep.mNextBtn = null;
            deviceInfoStep.mTitleBar = null;
            deviceInfoStep.mReturnBtn = null;
            deviceInfoStep.mTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
