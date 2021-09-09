package com.xiaomi.smarthome.smartconfig;

import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class XiaofangChooseConnection extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private BroadcastReceiver f11478O000000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.smartconfig.XiaofangChooseConnection.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                Message obtainMessage = XiaofangChooseConnection.this.mHandler.obtainMessage();
                obtainMessage.what = 101;
                obtainMessage.obj = (NetworkInfo) parcelableExtra;
                XiaofangChooseConnection.this.mHandler.sendMessage(obtainMessage);
            }
        }
    };
    @BindView(6198)
    View mBottomContainer;
    @BindView(7370)
    ImageView mIcon;
    @BindView(7372)
    TextView mInfo;
    @BindView(7371)
    TextView mInfoSubTitle;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(6171)
    View mMainIconContainer;
    @BindView(6855)
    TextView mManualIcon;
    @BindView(6856)
    TextView mManualText;
    @BindView(6170)
    View mManualView;
    @BindView(7210)
    TextView mRightBtn;
    @BindView(6986)
    Button mSettingWifiBtn;

    public void handleMessage(Message message) {
        if (message.what == 101) {
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            NetworkInfo networkInfo = (NetworkInfo) message.obj;
            NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
            StringBuilder sb = new StringBuilder();
            sb.append(detailedState.toString());
            sb.append(", ");
            String str = "";
            sb.append(networkInfo.getReason() != null ? networkInfo.getReason() : str);
            sb.append(", ");
            sb.append(networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo() : str);
            sb.append(", ");
            if (networkInfo.getReason() != null) {
                str = networkInfo.getReason();
            }
            sb.append(str);
            gsy.O000000o(6, "WifiState", sb.toString());
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && connectionInfo.getSSID().contains("isa-camera-isc5")) {
                finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smart_config_connect_ap_failed_ui);
        ButterKnife.bind(this);
        this.mMainIconContainer.setVisibility(8);
        this.mBottomContainer.setVisibility(8);
        this.mManualView.setVisibility(0);
        this.mSettingWifiBtn.setVisibility(0);
        this.mSettingWifiBtn.setText((int) R.string.smart_config_set_wifi_btn);
        String format = String.format(getText(R.string.smart_config_manual_text).toString(), "isa-camera-isc5_miap****");
        this.mManualIcon.setText("isa-camera-isc5_miap****");
        this.mManualText.setText(format);
        this.mSettingWifiBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaofangChooseConnection.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
                XiaofangChooseConnection.this.startActivity(intent);
            }
        });
        registerReceiver(this.f11478O000000o, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    }
}
