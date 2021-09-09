package com.xiaomi.smarthome.device.authorization.page;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class DeviceAuthSlaveListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceAuthSlaveListActivity f7090O000000o;

    public DeviceAuthSlaveListActivity_ViewBinding(DeviceAuthSlaveListActivity deviceAuthSlaveListActivity, View view) {
        this.f7090O000000o = deviceAuthSlaveListActivity;
        deviceAuthSlaveListActivity.mThirdOkButton = (TextView) Utils.findRequiredViewAsType(view, R.id.back_btn, "field 'mThirdOkButton'", TextView.class);
        deviceAuthSlaveListActivity.mTitleTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTextView'", TextView.class);
        deviceAuthSlaveListActivity.commonWhiteEmptyView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.common_white_empty_view, "field 'commonWhiteEmptyView'", LinearLayout.class);
        deviceAuthSlaveListActivity.moduleA4ReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'moduleA4ReturnBtn'", ImageView.class);
    }

    public void unbind() {
        DeviceAuthSlaveListActivity deviceAuthSlaveListActivity = this.f7090O000000o;
        if (deviceAuthSlaveListActivity != null) {
            this.f7090O000000o = null;
            deviceAuthSlaveListActivity.mThirdOkButton = null;
            deviceAuthSlaveListActivity.mTitleTextView = null;
            deviceAuthSlaveListActivity.commonWhiteEmptyView = null;
            deviceAuthSlaveListActivity.moduleA4ReturnBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
