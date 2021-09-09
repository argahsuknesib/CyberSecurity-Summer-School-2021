package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ApConnectFailed2Step_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ApConnectFailed2Step f11624O000000o;

    public ApConnectFailed2Step_ViewBinding(ApConnectFailed2Step apConnectFailed2Step, View view) {
        this.f11624O000000o = apConnectFailed2Step;
        apConnectFailed2Step.mSettingWifiBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mSettingWifiBtn'", Button.class);
        apConnectFailed2Step.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        apConnectFailed2Step.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        apConnectFailed2Step.mTitlebarTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitlebarTv'", TextView.class);
        apConnectFailed2Step.mTvFailHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fail_hint, "field 'mTvFailHint'", TextView.class);
    }

    public void unbind() {
        ApConnectFailed2Step apConnectFailed2Step = this.f11624O000000o;
        if (apConnectFailed2Step != null) {
            this.f11624O000000o = null;
            apConnectFailed2Step.mSettingWifiBtn = null;
            apConnectFailed2Step.mTitleBar = null;
            apConnectFailed2Step.mReturnBtn = null;
            apConnectFailed2Step.mTitlebarTv = null;
            apConnectFailed2Step.mTvFailHint = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
