package com.smarthome.uwb.ui;

import _m_j.ddt;
import _m_j.fno;
import _m_j.ft;
import _m_j.fux;
import _m_j.ggb;
import _m_j.hte;
import _m_j.hzq;
import _m_j.hzs;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import com.xiaomi.smarthome.uwb.ui.widget.SHLoadingDialog;

public class UwbTagBindLoadingActivity extends UwbBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    UwbScanDevice f5675O000000o;
    SHLoadingDialog O00000Oo;
    private int O00000o = 0;
    boolean O00000o0 = true;
    private Dialog O00000oO = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_uwb_loading_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.f5675O000000o = (UwbScanDevice) intent.getParcelableExtra("uwb_scan_result");
            this.O00000o = intent.getIntExtra("intent_key_state_mode", 0);
        }
        if (this.O00000o == 1) {
            O000000o();
        } else if (this.f5675O000000o == null) {
            hte.O000000o(this, (int) R.string.action_fail);
            UwbLogUtil.d("UwbTagBindLoadingActivity", "start UwbGeneralLoadingActivity with null device");
            finish();
        } else {
            O000000o();
        }
    }

    public static void startCheckPermission() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagBindLoadingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("intent_key_state_mode", 1);
        UwbSdk.getApplication().startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
     arg types: [com.smarthome.uwb.ui.UwbTagBindLoadingActivity, int, ?]
     candidates:
      _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
      _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
    private void O000000o() {
        if (!fux.O000000o((Activity) this, false, (int) R.string.location_disable_hint)) {
            Dialog dialog = this.O00000oO;
            if (dialog != null && dialog.isShowing()) {
                this.O00000oO.dismiss();
            }
            fux.O000000o((Activity) this, true, (int) R.string.permission_location_rational_desc_new);
        } else if (this.O00000o != 1) {
            O00000Oo();
        }
    }

    public void onResume() {
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        super.onResume();
    }

    public void onPause() {
        getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        super.onPause();
    }

    private void O00000Oo() {
        this.O00000oO = hzq.O000000o(this, PluginDeviceManager.instance.getModelByProductId((int) this.f5675O000000o.getPid()), new SmartConfigStep.O000000o() {
            /* class com.smarthome.uwb.ui.UwbTagBindLoadingActivity.AnonymousClass1 */

            public final void O000000o() {
                UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding onCurrentStepFinish1");
                UwbTagBindLoadingActivity.this.startTagBindingLoading();
            }

            public final Handler O00000Oo() {
                return UwbTagBindLoadingActivity.this.mHandler;
            }

            public final void O000000o(SmartConfigStep.Step step) {
                UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding onCurrentStepFinish2");
            }

            public final void O00000Oo(SmartConfigStep.Step step) {
                UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding onCurrentStepPause");
            }

            public final void O000000o(boolean z) {
                UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding onFinishSmartConfig");
            }
        });
        Dialog dialog = this.O00000oO;
        if (dialog != null) {
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.smarthome.uwb.ui.UwbTagBindLoadingActivity.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    UwbTagBindLoadingActivity.this.finish();
                }
            });
        } else {
            startTagBindingLoading();
        }
    }

    public void startTagBindingLoading() {
        Dialog dialog = this.O00000oO;
        if (dialog != null && dialog.isShowing()) {
            this.O00000oO.dismiss();
        }
        this.O00000Oo = new SHLoadingDialog(this, getString(R.string.default_uwb__loading_text), false);
        this.O00000Oo.show();
        hzs.O000000o(this.f5675O000000o, null, null, new hzs.O000000o() {
            /* class com.smarthome.uwb.ui.UwbTagBindLoadingActivity.AnonymousClass3 */

            public final void O000000o(int i, String str) {
                SHLoadingDialog sHLoadingDialog = UwbTagBindLoadingActivity.this.O00000Oo;
                sHLoadingDialog.appendDebugView(hzs.O000000o(i) + " : " + str);
            }

            public final void O000000o(Object obj) {
                if (!UwbTagBindLoadingActivity.this.isValid()) {
                    UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding: startConfigBindTag onSuccess but activity finished1.");
                    return;
                }
                final String str = null;
                if (obj instanceof ddt.O00000Oo) {
                    str = ((ddt.O00000Oo) obj).f14520O000000o;
                } else if (obj instanceof Device) {
                    str = ((Device) obj).did;
                }
                fno.O000000o().O000000o(new fno.O000000o() {
                    /* class com.smarthome.uwb.ui.UwbTagBindLoadingActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onRefreshClientDeviceChanged(int i, Device device) {
                    }

                    public final void onRefreshClientDeviceSuccess(int i) {
                        if (!UwbTagBindLoadingActivity.this.isValid()) {
                            UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding: forceUpdateDeviceRemote onSuccess but activity finished2.");
                            return;
                        }
                        fno.O000000o().O00000Oo(this);
                        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                            /* class com.smarthome.uwb.ui.UwbTagBindLoadingActivity.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                if (!UwbTagBindLoadingActivity.this.isValid()) {
                                    UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding: onSuccess after activity finished3.");
                                    return;
                                }
                                UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding: onSuccess");
                                UwbTagBindLoadingActivity.this.sendBindingResult(0, CoreApi.O000000o().O0000o0(), 0, null, str);
                            }
                        }, 10000);
                    }
                });
                ggb.O00000Oo().O000000o(false);
            }

            public final void O00000Oo(int i, String str) {
                if (!UwbTagBindLoadingActivity.this.isValid()) {
                    UwbLogUtil.d("UwbTagBindLoadingActivity", "startTagBinding: onFail after activity finished.");
                    return;
                }
                UwbLogUtil.e("UwbTagBindLoadingActivity", "startTagBinding: onFail " + i + "," + str);
                UwbTagBindLoadingActivity.this.sendBindingResult(-1, null, i, str, null);
                UwbTagBindLoadingActivity.this.finish();
            }
        });
    }

    public void sendBindingResult(int i, String str, int i2, String str2, String str3) {
        UwbLogUtil.d("UwbTagBindLoadingActivity", "sendBindingResult code=" + i + ",tagId=" + str3 + ",error=" + i2 + ",msg=" + str2);
        Intent intent = new Intent("UwbGeneralLoadingActivity-Action");
        intent.putExtra("arg_code", i);
        intent.putExtra("arg_error_code", i2);
        intent.putExtra("arg_uid", str);
        intent.putExtra("arg_error_msg", str2);
        intent.putExtra("arg_tag_id", str3);
        ft.O000000o(this).O000000o(intent);
        this.O00000o0 = false;
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.smarthome.uwb.ui.$$Lambda$UwbTagBindLoadingActivity$e0WAzEtDZVv8uOI4UZ4NgTOayo */

            public final void run() {
                UwbTagBindLoadingActivity.this.O00000o0();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        UwbLogUtil.d("UwbTagBindLoadingActivity", "finish will be called");
        finish();
    }

    public void onBackPressed() {
        sendBindingResult(1, null, 0, null, null);
        super.onBackPressed();
    }

    public boolean needExitUwb() {
        return this.O00000o0;
    }

    public void onDestroy() {
        SHLoadingDialog sHLoadingDialog = this.O00000Oo;
        if (sHLoadingDialog != null) {
            sHLoadingDialog.dismiss();
        }
        Dialog dialog = this.O00000oO;
        if (dialog != null && dialog.isShowing()) {
            this.O00000oO.dismiss();
        }
        super.onDestroy();
    }
}
