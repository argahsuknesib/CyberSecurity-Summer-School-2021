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

public class CameraApChooseConnection extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f11400O000000o;
    private BroadcastReceiver O00000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.smartconfig.CameraApChooseConnection.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                Message obtainMessage = CameraApChooseConnection.this.mHandler.obtainMessage();
                obtainMessage.what = 101;
                obtainMessage.obj = (NetworkInfo) parcelableExtra;
                CameraApChooseConnection.this.mHandler.sendMessage(obtainMessage);
            }
        }
    };
    @BindView(6920)
    ImageView mIvReturn;
    @BindView(6986)
    Button mSettingWifiBtn;
    @BindView(6113)
    TextView mTvAp;
    @BindView(6925)
    TextView mTvTitle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_ap_choose);
        ButterKnife.bind(this);
        this.f11400O000000o = getIntent().getStringExtra("model");
        this.mIvReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraApChooseConnection.AnonymousClass1 */

            public final void onClick(View view) {
                CameraApChooseConnection.this.finish();
            }
        });
        this.mTvTitle.setText((int) R.string.camera_connect_guide);
        this.mSettingWifiBtn.setVisibility(0);
        this.mSettingWifiBtn.setText((int) R.string.smart_config_goto_setting);
        ((WifiManager) getSystemService("wifi")).getConnectionInfo();
        this.mSettingWifiBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraApChooseConnection.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
                try {
                    CameraApChooseConnection.this.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        });
        registerReceiver(this.O00000Oo, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if ("isa.camera.isc5".equals(this.f11400O000000o)) {
            this.mTvAp.setText("isa-camera-isc5_miap****");
        } else if ("mijia.camera.v1".equals(this.f11400O000000o)) {
            this.mTvAp.setText("mijia-camera-v1_mibt****");
        }
    }

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
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected()) {
                if ("isa.camera.isc5".equals(this.f11400O000000o) && connectionInfo.getSSID().contains("isa-camera-isc5")) {
                    finish();
                }
                if ("mijia.camera.v1".equals(this.f11400O000000o) && connectionInfo.getSSID().contains("mijia-camera-v1")) {
                    finish();
                }
            }
        }
    }
}
