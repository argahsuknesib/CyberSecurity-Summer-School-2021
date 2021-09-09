package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ApConnectMidrFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ApConnectMidrFailedStep f11630O000000o;

    public ApConnectMidrFailedStep_ViewBinding(ApConnectMidrFailedStep apConnectMidrFailedStep, View view) {
        this.f11630O000000o = apConnectMidrFailedStep;
        apConnectMidrFailedStep.mManualView = Utils.findRequiredView(view, R.id.base_ui_connect_manually, "field 'mManualView'");
        apConnectMidrFailedStep.mSettingWifiBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mSettingWifiBtn'", Button.class);
        apConnectMidrFailedStep.mManualIcon = (TextView) Utils.findRequiredViewAsType(view, R.id.manual_connect_icon, "field 'mManualIcon'", TextView.class);
        apConnectMidrFailedStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        apConnectMidrFailedStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        apConnectMidrFailedStep.mTitlebarTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitlebarTv'", TextView.class);
        apConnectMidrFailedStep.mManualText = (TextView) Utils.findRequiredViewAsType(view, R.id.manual_text, "field 'mManualText'", TextView.class);
    }

    public void unbind() {
        ApConnectMidrFailedStep apConnectMidrFailedStep = this.f11630O000000o;
        if (apConnectMidrFailedStep != null) {
            this.f11630O000000o = null;
            apConnectMidrFailedStep.mManualView = null;
            apConnectMidrFailedStep.mSettingWifiBtn = null;
            apConnectMidrFailedStep.mManualIcon = null;
            apConnectMidrFailedStep.mTitleBar = null;
            apConnectMidrFailedStep.mReturnBtn = null;
            apConnectMidrFailedStep.mTitlebarTv = null;
            apConnectMidrFailedStep.mManualText = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
