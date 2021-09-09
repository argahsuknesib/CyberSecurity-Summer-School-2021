package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fbs;
import _m_j.fbt;
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

public class FindDeviceFailedFinalStep extends SmartConfigStep {
    @BindView(6233)
    View mButton1;
    @BindView(6235)
    View mButton2;
    @BindView(6237)
    View mButton3;
    @BindView(6234)
    TextView mButtonName_1;
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
        ScanResult scanResult = (ScanResult) htr.O000000o().O000000o("device_ap");
        boolean z = true;
        if (scanResult == null || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(scanResult))) == null || pluginInfo.O0000ooO() != 1) {
            z = false;
        }
        this.mTitlebarTv.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
        this.mTips.setText(this.O000O0oo.getString(R.string.please_check_device_light));
        final String str = (String) htr.O000000o().O000000o("device_model");
        if (str != null) {
            DeviceFactory.O000000o(this.mDeviceImage, DeviceFactory.O0000o(str), 0);
        }
        SmartConfigRouterFactory.getStatClickManager().add_fail3nd_solution(str);
        if (z) {
            this.mButtonName_1.setText((int) R.string.smart_config_bright);
            this.mButtonName_3.setText((int) R.string.smart_config_blink_fast);
        } else {
            this.mButtonName_1.setText((int) R.string.smart_config_blue_light_bright);
            this.mButtonName_3.setText((int) R.string.smart_config_blue_light_blinking);
        }
        this.mButton1.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.FindDeviceFailedFinalStep.AnonymousClass1 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().add_fail3nd_lbblue(str);
                FindDeviceFailedFinalStep.this.O000O0o();
            }
        });
        this.mButton3.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.FindDeviceFailedFinalStep.AnonymousClass2 */

            public final void onClick(View view) {
                Context appContext = FindDeviceFailedFinalStep.this.O000O0oo == null ? SmartConfigRouterFactory.getSmartConfigManager().getAppContext() : FindDeviceFailedFinalStep.this.O000O0oo;
                SmartConfigRouterFactory.getStatClickManager().add_fail3nd_blue(str);
                fbt fbt = new fbt(appContext, "ResetDevicePage");
                fbt.O000000o("model", DeviceFactory.O00000Oo((ScanResult) htr.O000000o().O000000o("device_ap")));
                fbs.O000000o(fbt);
                FindDeviceFailedFinalStep.this.b_(true);
            }
        });
        this.mButton2.setVisibility(8);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.FindDeviceFailedFinalStep.AnonymousClass3 */

            public final void onClick(View view) {
                FindDeviceFailedFinalStep.this.G_();
            }
        });
        this.mTitlebarTv.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
