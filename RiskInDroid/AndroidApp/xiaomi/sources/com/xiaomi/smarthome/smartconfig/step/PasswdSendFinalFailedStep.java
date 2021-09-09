package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gwg;
import _m_j.htr;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class PasswdSendFinalFailedStep extends SmartConfigStep {
    @BindView(6233)
    View mButton1;
    @BindView(6235)
    View mButton2;
    @BindView(6237)
    View mButton3;
    @BindView(6234)
    TextView mButtonName_1;
    @BindView(6236)
    TextView mButtonName_2;
    @BindView(6238)
    TextView mButtonName_3;
    @BindView(6424)
    SimpleDraweeView mDeviceImage;
    @BindView(6920)
    View mReturnBtn;
    @BindView(7511)
    TextView mTips;
    @BindView(7517)
    View mTitleBar;
    @BindView(6925)
    TextView mTitlebarTv;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Context context) {
        PluginDeviceInfo pluginInfo;
        O000000o(context, (int) R.layout.smart_config_passwd_failed_ui);
        gwg.O000000o(this.mTitleBar);
        this.mTitlebarTv.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
        this.mTips.setText(this.O000O0oo.getString(R.string.please_check_device_light));
        final String str = (String) htr.O000000o().O000000o("device_model");
        boolean z = false;
        if (str != null) {
            DeviceFactory.O000000o(this.mDeviceImage, DeviceFactory.O0000o(str), 0);
            SmartConfigRouterFactory.getStatClickManager().add_fail2nd_solution(str);
        }
        ScanResult scanResult = (ScanResult) htr.O000000o().O000000o("device_ap");
        if (!(scanResult == null || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(scanResult))) == null || pluginInfo.O0000ooO() != 1)) {
            z = true;
        }
        if (z) {
            this.mButtonName_1.setText((int) R.string.smart_config_bright);
            this.mButtonName_2.setText((int) R.string.smart_config_blink_fast);
            this.mButtonName_3.setText((int) R.string.smart_config_blink_slow);
        } else {
            this.mButtonName_1.setText((int) R.string.smart_config_blue_light_bright);
            this.mButtonName_2.setText((int) R.string.smart_config_blue_light_blinking);
            this.mButtonName_3.setText((int) R.string.smart_config_yellow_light_blinking);
        }
        this.mButton1.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.PasswdSendFinalFailedStep.AnonymousClass1 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().add_fail2nd_lbblue(str);
                htr.O000000o().O00000Oo("send_passwd_success", Boolean.TRUE);
                PasswdSendFinalFailedStep.this.O000O0o();
            }
        });
        this.mButton2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.PasswdSendFinalFailedStep.AnonymousClass2 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().add_fail2nd_blue(str);
                htr.O000000o().O00000Oo("send_passwd_success", Boolean.TRUE);
                PasswdSendFinalFailedStep.this.O000O0o();
            }
        });
        this.mButton3.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.PasswdSendFinalFailedStep.AnonymousClass3 */

            public final void onClick(View view) {
                htr.O000000o().O00000Oo("send_passwd_success", Boolean.FALSE);
                SmartConfigRouterFactory.getStatClickManager().add_fail2nd_yellow(str);
                PasswdSendFinalFailedStep.this.O000O0o();
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.PasswdSendFinalFailedStep.AnonymousClass4 */

            public final void onClick(View view) {
                PasswdSendFinalFailedStep.this.G_();
            }
        });
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
