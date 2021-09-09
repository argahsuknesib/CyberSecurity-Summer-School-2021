package com.xiaomi.smarthome.device;

import _m_j.dct;
import _m_j.dda;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ffr;
import _m_j.fgb;
import _m_j.fqr;
import _m_j.gnl;
import _m_j.gsy;
import _m_j.hsk;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public class ScanBleDeviceActivity extends BaseActivity implements ScanDeviceProgressBar.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    BluetoothAdapter f7028O000000o;
    BluetoothAdapter.LeScanCallback O00000Oo = new BluetoothAdapter.LeScanCallback() {
        /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass1 */

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (!ScanBleDeviceActivity.this.isFindTarget) {
                BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(bluetoothDevice, i, bArr);
                MiotBleAdvPacket O000000o2 = dda.O000000o(bluetoothSearchResult.O00000o0);
                if (O000000o2 != null && ScanBleDeviceActivity.this.mBleMac.equalsIgnoreCase(O000000o2.O00000o)) {
                    gsy.O000000o(3, "ScanBleDeviceActivity", "Find target device " + bluetoothDevice.toString());
                    ScanBleDeviceActivity scanBleDeviceActivity = ScanBleDeviceActivity.this;
                    scanBleDeviceActivity.isFindTarget = true;
                    scanBleDeviceActivity.f7028O000000o.stopLeScan(ScanBleDeviceActivity.this.O00000Oo);
                    String O00000Oo = CoreApi.O000000o().O00000Oo(ScanBleDeviceActivity.this.mPid);
                    ffr.O00000Oo(bluetoothDevice.getAddress(), ScanBleDeviceActivity.this.mPid);
                    ffr.O0000O0o(bluetoothDevice.getAddress(), O00000Oo);
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
                    fbt fbt = new fbt(ScanBleDeviceActivity.this.getContext(), "SmartConfigMainActivity");
                    fbt.O000000o("strategy_id", 19);
                    fbt.O000000o("model", O00000Oo);
                    fbt.O000000o("combo_ble_mac", bluetoothDevice.getAddress());
                    fbt.O000000o("mitv_did", ScanBleDeviceActivity.this.mDid);
                    fbt.O000000o("mitv_atype", ScanBleDeviceActivity.this.aType);
                    fbs.O000000o(fbt);
                    ScanBleDeviceActivity.this.finish();
                }
            }
        }
    };
    public String aType;
    public boolean isFindTarget;
    public String mBleMac;
    @BindView(5095)
    TextView mCannotFindDeviceTx;
    public String mDid;
    public int mPid;
    @BindView(5787)
    ScanDeviceProgressBar mProgressBar;
    @BindView(5892)
    Button mRescanBt;
    @BindView(5893)
    TextView mScanDescText;
    @BindView(5895)
    RelativeLayout mScanFailView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scan_choose_bluetooth_device);
        ButterKnife.bind(this);
        this.mProgressBar.O00000o0 = this;
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ScanBleDeviceActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.scan_device));
        this.mProgressBar.O00000o0 = this;
        this.mRescanBt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ScanBleDeviceActivity.this.startBleScan();
            }
        });
        Intent intent = getIntent();
        this.mBleMac = intent.getStringExtra("ble_mac");
        this.aType = intent.getStringExtra("aType");
        this.mDid = intent.getStringExtra("did");
        this.mPid = intent.getIntExtra("pid", 0);
        this.f7028O000000o = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.mCannotFindDeviceTx.getPaint().setFlags(9);
        this.mCannotFindDeviceTx.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass4 */

            public final void onClick(View view) {
                fbt fbt = new fbt(ScanBleDeviceActivity.this, "WebShellActivity");
                fbt.O000000o("url", hsk.O00000Oo(CommonApplication.getAppContext()) + "/views/faqDetail.html?question=" + ScanBleDeviceActivity.this.getString(R.string.param_question_cannot_find_device));
                fbs.O000000o(fbt);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (!gnl.O00000Oo()) {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass6 */

                public final void onResponse(int i, Object obj) {
                    if (i == 0) {
                        ScanBleDeviceActivity.this.startBleScan();
                    } else {
                        ScanBleDeviceActivity.this.finish();
                    }
                }
            });
        } else {
            startBleScan();
        }
    }

    public void onPause() {
        super.onPause();
        BluetoothAdapter.LeScanCallback leScanCallback = this.O00000Oo;
        if (leScanCallback != null) {
            this.f7028O000000o.stopLeScan(leScanCallback);
        }
    }

    public void startBleScan() {
        this.mScanFailView.setVisibility(8);
        this.mScanDescText.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        this.mProgressBar.O00000o0();
        this.mProgressBar.setTime(25000);
        this.mProgressBar.O000000o();
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.device.ScanBleDeviceActivity.AnonymousClass5 */

            public final void run() {
                ScanBleDeviceActivity.this.f7028O000000o.startLeScan(ScanBleDeviceActivity.this.O00000Oo);
            }
        });
    }

    public void onTimeOut() {
        BluetoothAdapter.LeScanCallback leScanCallback = this.O00000Oo;
        if (leScanCallback != null) {
            this.f7028O000000o.stopLeScan(leScanCallback);
        }
        if (!this.isFindTarget) {
            this.mProgressBar.O00000Oo();
            this.mScanDescText.setVisibility(8);
            this.mProgressBar.setVisibility(8);
            this.mScanFailView.setVisibility(0);
        }
    }
}
