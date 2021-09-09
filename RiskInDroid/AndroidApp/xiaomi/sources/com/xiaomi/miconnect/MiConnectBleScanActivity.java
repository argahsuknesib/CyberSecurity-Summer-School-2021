package com.xiaomi.miconnect;

import _m_j.dck;
import _m_j.dcp;
import _m_j.dct;
import _m_j.dda;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ffr;
import _m_j.fgb;
import _m_j.fqr;
import _m_j.gnl;
import _m_j.gsy;
import _m_j.htx;
import _m_j.hty;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;

public class MiConnectBleScanActivity extends BaseActivity implements dck {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f5986O000000o;
    SimpleDraweeView O00000Oo;
    BluetoothAdapter.LeScanCallback O00000o = new BluetoothAdapter.LeScanCallback() {
        /* class com.xiaomi.miconnect.MiConnectBleScanActivity.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
         arg types: [java.lang.String, com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult]
         candidates:
          _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
          _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (!MiConnectBleScanActivity.this.isFindTarget) {
                gsy.O000000o(3, "MiConnectBleScanActivity", "onLeScan device " + bluetoothDevice.toString());
                BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(bluetoothDevice, i, bArr);
                MiotBleAdvPacket O000000o2 = dda.O000000o(bluetoothSearchResult.O00000o0);
                if (O000000o2 != null && MiConnectBleScanActivity.this.mBleMac.equalsIgnoreCase(O000000o2.O00000o)) {
                    gsy.O000000o(3, "MiConnectBleScanActivity", "Find target device " + bluetoothDevice.toString());
                    MiConnectBleScanActivity miConnectBleScanActivity = MiConnectBleScanActivity.this;
                    miConnectBleScanActivity.isFindTarget = true;
                    miConnectBleScanActivity.O00000o0.stopLeScan(MiConnectBleScanActivity.this.O00000o);
                    MiConnectBleScanActivity.this.mHandler.removeMessages(100);
                    String modelByProductId = SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(MiConnectBleScanActivity.this.mPid);
                    ffr.O00000Oo(bluetoothDevice.getAddress(), MiConnectBleScanActivity.this.mPid);
                    ffr.O0000O0o(bluetoothDevice.getAddress(), modelByProductId);
                    if (!TextUtils.isEmpty(O000000o2.O00000o)) {
                        dct.O00000oO("setPropSMac " + dct.O000000o(O000000o2.O00000o));
                        ffr.O0000OOo(bluetoothDevice.getAddress(), O000000o2.O00000o);
                    } else {
                        dct.O00000o0("setPropSMac packet mac = null");
                    }
                    String O000000o3 = new fgb(bluetoothSearchResult.O00000o0).O000000o();
                    if (!TextUtils.isEmpty(O000000o3)) {
                        ffr.O00000o0(bluetoothDevice.getAddress(), O000000o3);
                    }
                    fbt fbt = new fbt(MiConnectBleScanActivity.this, "MiConnectConfigActivity");
                    fbt.O000000o("model", modelByProductId);
                    fbt.O000000o("combo_ble_key", O000000o2.O00000oo);
                    fbt.O000000o("mac", bluetoothDevice.getAddress());
                    fbt.O000000o("ble_result", (Parcelable) bluetoothSearchResult);
                    htx O000000o4 = hty.O000000o();
                    if (O000000o4 != null) {
                        fbt = O000000o4.setMitvStep(fbt);
                    }
                    fbt.O000000o("mitv_did", MiConnectBleScanActivity.this.mDid);
                    fbt.O000000o("mitv_atype", MiConnectBleScanActivity.this.aType);
                    fbs.O000000o(fbt);
                    MiConnectBleScanActivity.this.finish();
                }
            }
        }
    };
    BluetoothAdapter O00000o0;
    public String aType;
    public boolean isFindTarget;
    public String mBleMac;
    public String mDid;
    public int mPid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_miconnect_blescan_layout);
        ((TextView) findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_discovery_new_device);
        this.f5986O000000o = (TextView) findViewById(R.id.tv_name);
        this.O00000Oo = (SimpleDraweeView) findViewById(R.id.iv_icon);
        Intent intent = getIntent();
        this.mBleMac = intent.getStringExtra("ble_mac");
        this.aType = intent.getStringExtra("aType");
        this.mDid = intent.getStringExtra("did");
        this.mPid = intent.getIntExtra("pid", 0);
        String modelByProductId = SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(this.mPid);
        gsy.O000000o(3, "MiConnectBleScanActivity", "model = ".concat(String.valueOf(modelByProductId)));
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(modelByProductId);
        this.f5986O000000o.setText(pluginInfo.O0000Oo0());
        String str = dcp.O000000o().O00000Oo;
        if (TextUtils.isEmpty(str)) {
            str = pluginInfo.O0000o0();
        }
        if (TextUtils.isEmpty(str)) {
            this.O00000Oo.setImageResource(R.drawable.miconnect_launcher_src);
        } else {
            this.O00000Oo.setImageURI(Uri.parse(str));
        }
        this.O00000o0 = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
    }

    public void onResume() {
        super.onResume();
        if (!gnl.O00000Oo()) {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.miconnect.MiConnectBleScanActivity.AnonymousClass3 */

                public final void onResponse(int i, Object obj) {
                    if (i == 0) {
                        MiConnectBleScanActivity.this.startBleScan();
                        return;
                    }
                    dcp.O000000o().O000000o((Activity) MiConnectBleScanActivity.this);
                    MiConnectBleScanActivity.this.finish();
                }
            });
        } else {
            startBleScan();
        }
    }

    public void onPause() {
        super.onPause();
        BluetoothAdapter.LeScanCallback leScanCallback = this.O00000o;
        if (leScanCallback != null) {
            this.O00000o0.stopLeScan(leScanCallback);
        }
    }

    public void startBleScan() {
        SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.miconnect.MiConnectBleScanActivity.AnonymousClass2 */

            public final void run() {
                MiConnectBleScanActivity.this.mHandler.sendEmptyMessageDelayed(100, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                MiConnectBleScanActivity.this.O00000o0.startLeScan(MiConnectBleScanActivity.this.O00000o);
            }
        });
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 100) {
            BluetoothAdapter.LeScanCallback leScanCallback = this.O00000o;
            if (leScanCallback != null) {
                this.O00000o0.stopLeScan(leScanCallback);
            }
            dcp.O000000o().O000000o((Activity) this);
            finish();
        }
    }
}
