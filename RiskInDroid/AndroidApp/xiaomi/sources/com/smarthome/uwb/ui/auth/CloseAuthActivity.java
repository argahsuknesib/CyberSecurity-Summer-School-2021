package com.smarthome.uwb.ui.auth;

import _m_j.ddu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import _m_j.hzf;
import _m_j.hzn;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.UwbDevice;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.auth.AuthResultCallback;
import com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.idm.UwbScanListener;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import java.util.List;
import org.json.JSONObject;

public class CloseAuthActivity extends UwbBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f5694O000000o = "com.smarthome.uwb.ui.auth.CloseAuthActivity";
    TextView O00000Oo;
    SimpleDraweeView O00000o;
    TextView O00000o0;
    View O00000oO;
    UwbScanDevice O00000oo;
    boolean O0000O0o = false;
    Handler O0000OOo;
    Runnable O0000Oo = new Runnable() {
        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass1 */

        public final void run() {
            CloseAuthActivity.this.finish();
        }
    };
    Handler O0000Oo0;
    String O0000OoO;
    UwbConEngine.IEngineStateCallback O0000Ooo = new UwbConEngine.IEngineStateCallback() {
        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass3 */

        public final void onRetryKeyRetrieve() {
        }

        public final void onSwitchCommunication(int i, String str) {
        }

        public final void onConnEstablished() {
            UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus IEngineStateCallback onConnEstablished, start IOT");
            CloseAuthActivity closeAuthActivity = CloseAuthActivity.this;
            closeAuthActivity.runOnUiThread(new Runnable() {
                /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass2 */

                public final void run() {
                    hzf.O0000O0o(CloseAuthActivity.this.O00000o0);
                    CloseAuthActivity.this.O00000Oo.setBackground(null);
                    CloseAuthActivity.this.O00000Oo.setTextColor(CloseAuthActivity.this.getColor(R.color.white_60));
                    CloseAuthActivity.this.O00000Oo.setText((int) R.string.mj_uwb_connected);
                    CloseAuthActivity.this.O00000Oo.setTranslationY((float) (-UIUtils.dp2px(CloseAuthActivity.this, 20.0f)));
                }
            });
            CloseAuthActivity.this.O0000Oo0.postDelayed(CloseAuthActivity.this.O0000o0, 500);
        }

        public final void onConnectionError(int i, String str) {
            UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus IEngineStateCallback onConnectionError: ".concat(String.valueOf(i)));
        }

        public final void onEstablishSecurityError(int i, String str) {
            UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus IEngineStateCallback onEstablishSecurityError: ".concat(String.valueOf(i)));
        }
    };
    Runnable O0000o0 = new Runnable() {
        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass5 */

        public final void run() {
            CloseAuthActivity closeAuthActivity = CloseAuthActivity.this;
            closeAuthActivity.O0000O0o = true;
            closeAuthActivity.finish();
            hzn.O000000o(new UwbDevice(CloseAuthActivity.this.O00000oo, null));
        }
    };
    UwbScanListener O0000o00 = new UwbScanListener() {
        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass4 */

        public final void onScanState(int i) {
        }

        public final void onScanning(List<UwbScanDevice> list) {
            if (list != null && !list.isEmpty()) {
                for (UwbScanDevice next : list) {
                    String str = CloseAuthActivity.f5694O000000o;
                    UwbLogUtil.d(str, "UwbLogUtilPlus close auth processUWBIntent device:" + next.toString());
                    if (TextUtils.equals(next.getUwbAddress(), CloseAuthActivity.this.O00000oo.getUwbAddress())) {
                        CloseAuthActivity.this.O00000oo = next;
                        return;
                    }
                }
            }
        }
    };
    Runnable O0000o0O = new Runnable() {
        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass6 */

        public final void run() {
            UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus HapticRunnable");
            if (CloseAuthActivity.this.O000000o() > 300) {
                hzf.O0000Ooo(CloseAuthActivity.this.O00000o0);
                CloseAuthActivity.this.O0000OOo.postDelayed(this, 333);
            } else if (CloseAuthActivity.this.O000000o() > 0) {
                hzf.O0000OoO(CloseAuthActivity.this.O00000o0);
                CloseAuthActivity.this.O0000OOo.postDelayed(this, 66);
            }
        }
    };

    public static void startCardActivity(Context context, UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent();
        intent.setClass(context, CloseAuthActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("UWB_SCAN_DEVICE", uwbScanDevice.toJSON().toString());
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        try {
            this.O00000oo = UwbScanDevice.parse(new JSONObject(getIntent().getStringExtra("UWB_SCAN_DEVICE")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = f5694O000000o;
        UwbLogUtil.w(str, "UwbLogUtilPlus mUwbScanDevice: " + this.O00000oo);
        if (this.O00000oo == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_close_auth);
        this.O00000Oo = (TextView) findViewById(R.id.device_distance_tv);
        this.O00000o = (SimpleDraweeView) findViewById(R.id.device_iv);
        this.O00000o0 = (TextView) findViewById(R.id.device_tv);
        O000000o(null);
        if (UwbDeviceUtil.isThirdTagDevice(this.O00000oo)) {
            this.O0000OoO = getString(R.string.mj_uwb_third_tv_name);
            O000000o(this.O0000OoO);
            this.O00000o.setImageURI(Uri.parse(new StringBuilder("res://com.xiaomi.smarthome.uwb.lib/2132084516").toString()));
        } else {
            ddu.O000000o(String.valueOf(this.O00000oo.getPid()), new fsm<ddu.O000000o, fso>() {
                /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ddu.O000000o o000000o = (ddu.O000000o) obj;
                    boolean z = false;
                    if (o000000o != null) {
                        String str = CloseAuthActivity.f5694O000000o;
                        UwbLogUtil.w(str, "UwbLogUtilPlus CloseAuthActivity image: " + o000000o.f14524O000000o + " name: " + o000000o.O00000o);
                        if (!TextUtils.isEmpty(o000000o.f14524O000000o)) {
                            CloseAuthActivity.this.O00000o.setImageURI(Uri.parse(o000000o.f14524O000000o));
                            z = true;
                        }
                        CloseAuthActivity.this.O0000OoO = o000000o.O00000o;
                        CloseAuthActivity.this.O000000o(o000000o.O00000o);
                    }
                    if (!z && UwbDeviceUtil.isTagDeviceType(CloseAuthActivity.this.O00000oo.getDeviceType()) && 5662 == CloseAuthActivity.this.O00000oo.getPid()) {
                        CloseAuthActivity closeAuthActivity = CloseAuthActivity.this;
                        closeAuthActivity.O0000OoO = closeAuthActivity.getString(R.string.mj_uwb_tag_name);
                        CloseAuthActivity closeAuthActivity2 = CloseAuthActivity.this;
                        closeAuthActivity2.O000000o(closeAuthActivity2.O0000OoO);
                        CloseAuthActivity.this.O00000o.setImageURI(Uri.parse(new StringBuilder("res://com.xiaomi.smarthome.uwb.lib/2132087608").toString()));
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(3, CloseAuthActivity.f5694O000000o, "CloseAuthActivity can not get image!!!");
                }
            });
        }
        this.O00000oO = findViewById(R.id.timeout_pop_l);
        UIUtils.initBottomMargin(this, this.O00000oO);
        findViewById(R.id.uwb_back).setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass9 */

            public final void onClick(View view) {
                CloseAuthActivity.this.finish();
            }
        });
        UwbApi.getInstance().isEngineReady(this.O0000Ooo);
        this.O0000OOo = new Handler();
        this.O0000Oo0 = new Handler();
        UwbStrangerRegister.setGlobalAuthResultCallback(new AuthResultCallback() {
            /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass7 */

            public final void onSuccess(Bundle bundle) {
            }

            public final void onFailed(int i) {
                UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus AuthResultCallback: ".concat(String.valueOf(i)));
                if (-2 == i) {
                    UwbLogUtil.w(CloseAuthActivity.f5694O000000o, "UwbLogUtilPlus AuthResultCallback, timeout");
                    CloseAuthActivity.this.runOnUiThread(new Runnable() {
                        /* class com.smarthome.uwb.ui.auth.CloseAuthActivity.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            Toast.makeText(CloseAuthActivity.this, CloseAuthActivity.this.getString(com.xiaomi.smarthome.uwb_mijia.R.string.mj_uwb_iot_auth_timeout), 1).show();
                            CloseAuthActivity.this.finish();
                        }
                    });
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        UwbStrangerRegister.setGlobalAuthResultCallback(null);
        this.O0000Oo0.removeCallbacksAndMessages(null);
    }

    public void onStart() {
        super.onStart();
        UwbIdmManager.getInstance().addUWBScanListener(this.O0000o00);
        UwbLogUtil.w(f5694O000000o, "UwbLogUtilPlus onstart");
        this.O0000OOo.post(this.O0000o0O);
    }

    public void onStop() {
        super.onStop();
        UwbLogUtil.w(f5694O000000o, "UwbLogUtilPlus onstop");
        UwbIdmManager.getInstance().removeUWBScanListener(this.O0000o00);
        this.O0000OOo.removeCallbacksAndMessages(null);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000Oo(str);
        }
    }

    private void O00000Oo(String str) {
        this.O00000o0.setBackground(null);
        this.O00000o0.setText(str);
    }

    public boolean needExitUwb() {
        String str = f5694O000000o;
        StringBuilder sb = new StringBuilder("UwbLogUtilPlus needExitUwb: ");
        sb.append(!this.O0000O0o);
        UwbLogUtil.w(str, sb.toString());
        if (!this.O0000O0o) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long O000000o() {
        UwbScanDevice uwbScanDevice = this.O00000oo;
        if (uwbScanDevice != null) {
            return uwbScanDevice.getDistance();
        }
        return 0;
    }
}
