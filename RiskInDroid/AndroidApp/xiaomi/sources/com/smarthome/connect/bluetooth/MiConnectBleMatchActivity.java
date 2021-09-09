package com.smarthome.connect.bluetooth;

import _m_j.dck;
import _m_j.dcm;
import _m_j.dcn;
import _m_j.dco;
import _m_j.dcp;
import _m_j.dct;
import _m_j.dcv;
import _m_j.dcx;
import _m_j.dda;
import _m_j.dde;
import _m_j.ddm;
import _m_j.ei;
import _m_j.foc;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.miconnect.MiConnectBleBindActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public class MiConnectBleMatchActivity extends AppCompatActivity implements dck {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int f5623O000000o = 2132346128;
    public static BleDevice mMatchedDevice;
    private FrameLayout O00000Oo;
    private BleDevice O00000o;
    private ei O00000o0;
    private dcm O00000oO;
    private Handler O00000oo = new Handler();

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        dct.O00000o0("getIntentData");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("model");
        BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) intent.getParcelableExtra("ble_result");
        MiotBleAdvPacket O000000o2 = dda.O000000o(bluetoothSearchResult.O00000o0);
        BtDevice btDevice = new BtDevice(bluetoothSearchResult);
        btDevice.setModel(stringExtra);
        btDevice.O000000o(O000000o2);
        this.O00000o = BleDevice.O000000o(btDevice);
        BleDevice bleDevice = this.O00000o;
        if (bleDevice != null) {
            bleDevice.model = stringExtra;
        }
        BleDevice bleDevice2 = this.O00000o;
        if (!(bleDevice2 != null && !TextUtils.isEmpty(bleDevice2.model))) {
            dct.O00000o0("getIntentData finish");
            finishConnect();
            return;
        }
        mMatchedDevice = null;
        dde.O000000o(getWindow());
        setContentView(f5623O000000o);
        findViewById(R.id.blank_view).setOnTouchListener(new View.OnTouchListener() {
            /* class com.smarthome.connect.bluetooth.MiConnectBleMatchActivity.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    MiConnectBleMatchActivity.this.showExitDialog();
                }
                return true;
            }
        });
        findViewById(R.id.viewpager).setOnTouchListener(new View.OnTouchListener() {
            /* class com.smarthome.connect.bluetooth.MiConnectBleMatchActivity.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.O00000Oo = (FrameLayout) findViewById(R.id.viewpager);
        this.O00000o0 = getSupportFragmentManager().O000000o();
        dct.O00000o0("setContentFragments start");
        dct.O00000o0("setContentFragments");
        int O0000Oo = this.O00000o.O0000Oo();
        if (O0000Oo != 0) {
            if (O0000Oo == 1) {
                if (!TextUtils.isEmpty(BleDevice.O00000o(this.O00000o.model)) || dda.O000000o(this.O00000o)) {
                    O000000o();
                }
            }
        } else if (dda.O000000o(this.O00000o)) {
            O000000o();
        }
        dct.O00000o0("setContentFragments end");
        dcn O00000Oo2 = dcn.O00000Oo();
        if (dco.O000000o().O00000Oo() == null || dco.O000000o().O00000Oo().size() <= 0) {
            dct.O00000o0("no home data");
            changeHomeFragment();
            return;
        }
        dct.O00000o0("show select home and room fragment");
        this.O00000o0.O000000o(R.id.viewpager, O00000Oo2, "show select");
        O00000Oo2.O0000O0o = new dcn.O000000o() {
            /* class com.smarthome.connect.bluetooth.MiConnectBleMatchActivity.AnonymousClass4 */

            public final void O000000o() {
                MiConnectBleMatchActivity.this.changeHomeFragment();
            }
        };
        this.O00000o0.O00000Oo();
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000oo.removeCallbacks(null);
    }

    public void onBackPressed() {
        showExitDialog();
    }

    public void showExitDialog() {
        ddm ddm = new ddm();
        ddm.f14500O000000o = new Runnable() {
            /* class com.smarthome.connect.bluetooth.MiConnectBleMatchActivity.AnonymousClass1 */

            public final void run() {
                dct.O00000o0("on back");
                MiConnectBleMatchActivity.this.finishConnect();
            }
        };
        dcv.O00000Oo.O00000Oo();
        ddm.show(getSupportFragmentManager(), "show exit dialog");
    }

    public void changeHomeFragment() {
        dct.O00000o0("changeHomeFragment");
        if (this.O00000oO == null) {
            onDeviceMatched(this.O00000o);
            return;
        }
        this.O00000o0 = getSupportFragmentManager().O000000o();
        this.O00000o0.O00000Oo(R.id.viewpager, this.O00000oO, null);
        dcx dcx = dcv.O00000Oo;
        dcx.O000000o("closeto_pair_device", dcx.O00000Oo);
        this.O00000o0.O00000Oo();
    }

    private void O000000o() {
        dct.O00000o0("addMatchImagePage");
        this.O00000oO = dcm.O00000Oo();
        this.O00000oO.O0000OOo = this.O00000o;
    }

    public static void setMatchedDevice(BleDevice bleDevice) {
        mMatchedDevice = bleDevice;
        foc.O0000o(bleDevice.mac);
    }

    public void onDeviceMatched(BleDevice bleDevice) {
        dct.O00000o0("onDeviceMatched");
        Intent intent = new Intent();
        if (getIntent().hasExtra("key_qrcode_oob")) {
            intent.putExtra("key_qrcode_oob", getIntent().getStringExtra("key_qrcode_oob"));
        }
        onDeviceMatched(this, bleDevice, intent);
    }

    public void onDeviceMatched(final Activity activity, BleDevice bleDevice, Intent intent) {
        dct.O00000oo("onDeviceMatched: ");
        setMatchedDevice(bleDevice);
        if (bleDevice.O0000O0o()) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(activity.getPackageName(), MiConnectBleBindActivity.class.getName()));
            intent2.putExtras(getIntent());
            intent2.putExtra("extra_from", "from_match");
            if (intent != null && intent.hasExtra("key_qrcode_oob")) {
                intent2.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
            }
            activity.startActivity(intent2);
            this.O00000oo.postDelayed(new Runnable() {
                /* class com.smarthome.connect.bluetooth.MiConnectBleMatchActivity.AnonymousClass5 */

                public final void run() {
                    activity.finish();
                }
            }, 300);
            return;
        }
        dct.O00000o0("device is not miio device");
        finishConnect();
    }

    public void finishConnect() {
        finish();
        dcp.O000000o().O000000o((Activity) this);
    }
}
