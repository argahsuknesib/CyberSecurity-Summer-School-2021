package com.xiaomi.smarthome.device;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ConfigRouterSubDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ConfigRouterSubDeviceActivity f6943O000000o;

    public ConfigRouterSubDeviceActivity_ViewBinding(ConfigRouterSubDeviceActivity configRouterSubDeviceActivity, View view) {
        this.f6943O000000o = configRouterSubDeviceActivity;
        configRouterSubDeviceActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        configRouterSubDeviceActivity.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        configRouterSubDeviceActivity.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
        configRouterSubDeviceActivity.mContentRv = (ListView) Utils.findRequiredViewAsType(view, R.id.rv_choose_ap, "field 'mContentRv'", ListView.class);
        configRouterSubDeviceActivity.mNoDeviceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_camera_ap_info, "field 'mNoDeviceTv'", TextView.class);
    }

    public void unbind() {
        ConfigRouterSubDeviceActivity configRouterSubDeviceActivity = this.f6943O000000o;
        if (configRouterSubDeviceActivity != null) {
            this.f6943O000000o = null;
            configRouterSubDeviceActivity.mTitleBar = null;
            configRouterSubDeviceActivity.mReturnBtn = null;
            configRouterSubDeviceActivity.mNextBtn = null;
            configRouterSubDeviceActivity.mContentRv = null;
            configRouterSubDeviceActivity.mNoDeviceTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
