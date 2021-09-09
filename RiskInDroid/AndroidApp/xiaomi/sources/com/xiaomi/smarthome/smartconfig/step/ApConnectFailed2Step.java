package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gwg;
import _m_j.htr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ApConnectFailed2Step extends SmartConfigStep {
    @BindView(6920)
    View mReturnBtn;
    @BindView(6986)
    Button mSettingWifiBtn;
    @BindView(7517)
    View mTitleBar;
    @BindView(6925)
    TextView mTitlebarTv;
    @BindView(7607)
    TextView mTvFailHint;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR2;
    }

    public final boolean G_() {
        b_(false);
        return true;
    }

    public final void O000000o(final Context context) {
        O000000o(context, (int) R.layout.smart_config_connect_ap_failed2_ui);
        gwg.O000000o(this.mTitleBar);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApConnectFailed2Step.AnonymousClass1 */

            public final void onClick(View view) {
                ApConnectFailed2Step.this.G_();
            }
        });
        final String str = (String) htr.O000000o().O000000o("device_model");
        String string = this.mTvFailHint.getResources().getString(R.string.kuailian_connect_fail_reason_content);
        if (!TextUtils.isEmpty(str) && DeviceFactory.O00000Oo(str)) {
            string = string.substring(0, string.lastIndexOf("\n"));
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null && O00000oO.O00000o() == 23) {
            string = string + this.mTvFailHint.getResources().getString(R.string.moxiang_camera_connect_fail_reason);
        }
        this.mTvFailHint.setText(string);
        this.mTitlebarTv.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
        this.mSettingWifiBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApConnectFailed2Step.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent;
                if (TextUtils.isEmpty(str)) {
                    ApConnectFailed2Step.this.b_(false);
                    return;
                }
                fbt fbt = new fbt(context, "ResetDevicePage");
                fbt.O000000o("model", str);
                Context context = context;
                if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
                    fbt.O000000o("connect_source", intent.getIntExtra("connect_source", 0)).O000000o("connect_unique", intent.getStringExtra("connect_unique"));
                }
                fbt.O000000o(1);
                fbs.O000000o(fbt);
            }
        });
    }

    public final void O000000o(int i, int i2, Intent intent) {
        if (intent == null) {
            b_(true);
        } else {
            b_(intent.getBooleanExtra("finish", true));
        }
    }
}
