package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gsy;
import _m_j.gwg;
import _m_j.htr;
import _m_j.iag;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ApConnectFailedStep extends SmartConfigStep {
    @BindView(6855)
    TextView mManualIcon;
    @BindView(6856)
    TextView mManualText;
    @BindView(6170)
    View mManualView;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6986)
    Button mSettingWifiBtn;
    @BindView(7517)
    View mTitleBar;
    @BindView(6925)
    TextView mTitlebarTv;

    public final void I_() {
    }

    public final void O0000O0o() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
    }

    public final boolean G_() {
        b_(false);
        return true;
    }

    public final void O000000o(Message message) {
        if (this.O000O0oo != null && message.what == 101) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.O000OOOo);
            if (O00000oO == null || !(O00000oO.O00000o() == 16 || O00000oO.O00000o() == 24 || O00000oO.O00000o() == 23)) {
                O00000Oo();
            }
        }
    }

    private void O00000Oo() {
        ScanResult y_;
        WifiManager wifiManager = (WifiManager) this.O000O0oo.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            gsy.O000000o(6, "ApConnectFailedStep", "WifiState".concat(String.valueOf(connectionInfo)));
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && (y_ = y_()) != null && iag.O000000o(connectionInfo.getSSID(), y_.SSID)) {
                O000O0o();
            }
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_connect_ap_failed_ui);
        O000O0OO();
        SmartConfigRouterFactory.getStatClickManager().add_fail1st_manualadd(this.O000OOOo);
        gwg.O000000o(this.mTitleBar);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApConnectFailedStep.AnonymousClass1 */

            public final void onClick(View view) {
                ApConnectFailedStep.this.G_();
            }
        });
        this.mTitlebarTv.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
        if (this.O000O0oo != null) {
            this.mManualView.setVisibility(0);
            this.mSettingWifiBtn.setVisibility(0);
            this.mSettingWifiBtn.setText((int) R.string.smart_config_set_wifi_btn);
            ScanResult scanResult = (ScanResult) htr.O000000o().O000000o("device_ap");
            String str = (String) htr.O000000o().O000000o("wifi_ssid");
            if (scanResult != null) {
                str = scanResult.SSID;
            }
            if (str != null) {
                String format = String.format(this.O000O0oo.getText(R.string.smart_config_manual_text).toString(), str);
                this.mManualIcon.setText(str);
                this.mManualText.setText(format);
            }
            this.mSettingWifiBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ApConnectFailedStep.AnonymousClass2 */

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    SmartConfigRouterFactory.getStatClickManager().add_fail1st_wifi(ApConnectFailedStep.this.O000OOOo);
                    intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
                    try {
                        ((Activity) ApConnectFailedStep.this.O000O0oo).startActivityForResult(intent, 102);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public final void H_() {
        O00000Oo();
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == 102) {
            O00000Oo();
        }
    }
}
