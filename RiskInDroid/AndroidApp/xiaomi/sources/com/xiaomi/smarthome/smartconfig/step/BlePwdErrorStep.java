package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fqy;
import _m_j.gnk;
import _m_j.htr;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class BlePwdErrorStep extends SmartConfigStep {
    @BindView(7370)
    ImageView mIcon;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(7372)
    TextView mMainTitle;
    @BindView(7210)
    TextView mRightBtn;
    @BindView(7371)
    TextView mSubMainTitle;

    public final void O000000o(Message message) {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
    }

    public final void H_() {
        gnk.O00000o0(String.format("%s.onResumeStep", getClass().getSimpleName()));
    }

    public final void I_() {
        gnk.O00000o0(String.format("%s.onPauseStep", getClass().getSimpleName()));
    }

    public final void O0000O0o() {
        gnk.O00000o0(String.format("%s.onFinishStep", getClass().getSimpleName()));
    }

    public final boolean G_() {
        gnk.O00000o0(String.format("%s.onBackPressed", getClass().getSimpleName()));
        htr.O000000o().O00000Oo("restore_wifi", Boolean.TRUE);
        return super.G_();
    }

    public final void O000000o(Context context) {
        if (this.O000Ooo0) {
            O000000o(context, (int) R.layout.smart_miconfig_base_left_right_ui);
        } else {
            O000000o(context, (int) R.layout.smart_config_base_left_right_ui);
        }
        this.mIcon.setImageResource(R.drawable.config_failed_disconnect);
        this.mMainTitle.setText((int) R.string.ble_combo_pwd_error);
        this.mSubMainTitle.setText("");
        this.mLeftBtn.setText((int) R.string.sh_common_cancel);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.BlePwdErrorStep.AnonymousClass1 */

            public final void onClick(View view) {
                gnk.O00000o0(String.format("BlePwdErrorStep Cancel Button Pressed", new Object[0]));
                htr.O000000o().O00000Oo("restore_wifi", Boolean.TRUE);
                BlePwdErrorStep.this.b_(true);
            }
        });
        this.mRightBtn.setText((int) R.string.mj_retry);
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.BlePwdErrorStep.AnonymousClass2 */

            public final void onClick(View view) {
                gnk.O00000o0(String.format("BlePwdErrorStep Rrtry Button Pressed", new Object[0]));
                htr.O000000o().O00000Oo("send_passwd_success", Boolean.FALSE);
                Intent intent = new Intent(BlePwdErrorStep.this.O000O0oo, SmartConfigMainActivity.class);
                fqy.O000000o(intent, BlePwdErrorStep.this.O000O0oo);
                intent.putExtra("strategy_id", ((Integer) htr.O000000o().O000000o("combo_strategy")).intValue());
                intent.putExtra("model", (String) htr.O000000o().O000000o("device_model"));
                intent.putExtra("scanResult", (ScanResult) htr.O000000o().O000000o("device_ap"));
                intent.putExtra("bssid", (String) htr.O000000o().O000000o("target_bssid"));
                intent.putExtra("password", (String) htr.O000000o().O000000o("target_passwd"));
                intent.putExtra("combo_ble_mac", (String) htr.O000000o().O000000o("combo_ble_mac"));
                BlePwdErrorStep.this.O000O0oo.startActivity(intent);
                BlePwdErrorStep.this.b_(true);
            }
        });
    }
}
