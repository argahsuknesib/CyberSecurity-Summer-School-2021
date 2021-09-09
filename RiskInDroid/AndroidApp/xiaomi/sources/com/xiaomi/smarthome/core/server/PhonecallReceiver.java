package com.xiaomi.smarthome.core.server;

import _m_j.flb;
import _m_j.fld;
import _m_j.fsr;
import _m_j.ft;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.frame.core.CoreApi;

public abstract class PhonecallReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f6789O000000o;

    public void onReceive(final Context context, final Intent intent) {
        final AnonymousClass1 r0 = new Runnable() {
            /* class com.xiaomi.smarthome.core.server.PhonecallReceiver.AnonymousClass1 */

            public final void run() {
                String str;
                if (TextUtils.equals("com.xiaomi.metoknlp.geofencing.state_change", intent.getAction())) {
                    PhonecallReceiver phonecallReceiver = PhonecallReceiver.this;
                    Intent intent = intent;
                    String stringExtra = intent.getStringExtra("Location");
                    String stringExtra2 = intent.getStringExtra("State");
                    String stringExtra3 = intent.getStringExtra("Describe");
                    if (fsr.O0000O0o) {
                        phonecallReceiver.O000000o("notified:location=" + stringExtra + ",state=" + stringExtra2 + ",desc=" + stringExtra3);
                    }
                    if (!TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.equals("Unknown_Place", stringExtra3)) {
                        if (TextUtils.equals("Back", stringExtra2) || TextUtils.equals("Enter", stringExtra2)) {
                            str = "enter_";
                        } else if (TextUtils.equals("Leave", stringExtra2)) {
                            str = "leave_";
                        } else {
                            return;
                        }
                        fld O00000o02 = fld.O00000o0();
                        String value = StatType.EVENT.getValue();
                        O00000o02.O000000o(value, "mihome", "geofence_MIUI_notified", stringExtra3 + "," + stringExtra2 + "," + stringExtra, null, false);
                        if (flb.O000000o().O00000o) {
                            flb O000000o2 = flb.O000000o();
                            O000000o2.O000000o(str + stringExtra3);
                            return;
                        }
                        if (fsr.O0000O0o) {
                            phonecallReceiver.O000000o("start init scene_manager");
                        }
                        fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "geofence_init_scene_manager", "", null, false);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("scene_manager_init_success_normal_scene");
                        intentFilter.addAction("scene_manager_init_fail_normal_scene");
                        ft.O000000o(CoreService.getAppContext()).O000000o(new BroadcastReceiver(str, stringExtra3) {
                            /* class com.xiaomi.smarthome.core.server.PhonecallReceiver.AnonymousClass3 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ String f6792O000000o;
                            final /* synthetic */ String O00000Oo;

                            {
                                this.f6792O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void onReceive(Context context, Intent intent) {
                                ft.O000000o(CoreService.getAppContext()).O000000o(this);
                                if (TextUtils.equals(intent.getAction(), "scene_manager_init_success_normal_scene")) {
                                    fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "geofence_init_scene_manager_suc", "", null, false);
                                    flb O000000o2 = flb.O000000o();
                                    O000000o2.O000000o(this.f6792O000000o + this.O00000Oo);
                                    return;
                                }
                                fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "geofence_init_scene_manager_fail", "", null, false);
                                if (fsr.O0000O0o) {
                                    PhonecallReceiver.this.O000000o("geofence execute fail due to scenemanager init fail");
                                }
                            }
                        }, intentFilter);
                        flb.O000000o().O00000Oo();
                    }
                } else if (intent.getExtras() != null) {
                    String string = intent.getExtras().getString("state");
                    intent.getExtras().getString("incoming_number");
                    if (!string.equals(TelephonyManager.EXTRA_STATE_IDLE) && !string.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                        string.equals(TelephonyManager.EXTRA_STATE_RINGING);
                    }
                }
            }
        };
        CoreApi.O000000o().O000000o(context, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.core.server.PhonecallReceiver.AnonymousClass2 */

            public final void onCoreReady() {
                r0.run();
            }
        });
    }

    public final void O000000o(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.xiaomi.smarthome.core.server.PhonecallReceiver.AnonymousClass4 */

            public final void run() {
                izb.O000000o(CoreService.getAppContext(), str, 1).show();
            }
        });
    }
}
