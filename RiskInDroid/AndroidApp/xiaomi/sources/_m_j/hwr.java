package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class hwr extends ConfigStep {
    private static int O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f914O000000o;
    private String O00000Oo;
    private long O00000o = 60000;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final int O00000Oo() {
        return 0;
    }

    public final void s_() {
    }

    public final void z_() {
    }

    hwr() {
        this.O000Ooo = "camera-config :QRScanStep";
    }

    public final void O000000o(Context context) {
        this.O00000Oo = (String) htr.O000000o().O000000o("camera_bind_key");
        this.f914O000000o = (String) htr.O000000o().O000000o("device_model");
        if (eyr.O000000o(this.f914O000000o, true, 100, eyr.O00000Oo().O0000o)) {
            this.O00000o = 120000;
        }
        O000000o("create step,  model %s, timeout %d", this.f914O000000o, Long.valueOf(this.O00000o));
        super.O000000o(context);
    }

    public final ArrayList<gke> O0000Oo0() {
        gke gke = new gke();
        gke.O00000Oo = this.O00000o;
        gke.f17943O000000o = O00000o0;
        ArrayList<gke> arrayList = new ArrayList<>();
        arrayList.add(gke);
        return arrayList;
    }

    public final void O000000o(Message message) {
        if (message.what != 122) {
            super.O000000o(message);
            return;
        }
        O000000o("handle message check bind key", new Object[0]);
        O000000o("start checkBindKey", new Object[0]);
        O00000oo(12);
        htq.O000000o().O000000o(this.O00000Oo, new hua<JSONObject, hud>() {
            /* class _m_j.hwr.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Context context = hwr.this.O000O0oo;
                if (context == null) {
                    hwr.this.O000000o("check bind key onSuccess,but context is null", new Object[0]);
                    hwr.this.O00000oo(9);
                } else if (!(context instanceof CommonActivity) || ((CommonActivity) context).isValid()) {
                    int optInt = jSONObject.optInt("ret");
                    hwr.this.O000000o("check bind key onSuccess ret %d (0: binding; 1:bind success; -1:internal error; -2:bind timeout;-3:bind by other; or unknown error)", Integer.valueOf(optInt));
                    if (optInt == 0) {
                        hwr.this.O00000oo(14);
                        int optInt2 = jSONObject.optInt("check_after");
                        if ("chuangmi.camera.ipc009".equals(hwr.this.f914O000000o)) {
                            optInt2 = 5;
                        }
                        Handler x_ = hwr.this.x_();
                        hwr.this.O000000o("check bind key, left %d second for next check ", Integer.valueOf(optInt2));
                        if (x_ == null) {
                            return;
                        }
                        if (optInt2 > 0) {
                            hwr.this.x_().removeMessages(122);
                            hwr.this.x_().sendEmptyMessageDelayed(122, (long) (optInt2 * 1000));
                            return;
                        }
                        hwr.this.x_().removeMessages(122);
                        hwr.this.x_().sendEmptyMessageDelayed(122, 2000);
                    } else if (optInt == 1) {
                        hwr.this.O00000oo(16);
                        hwr hwr = hwr.this;
                        hwr.O000OOo = false;
                        hwr.O000OoO0 = true;
                        String optString = jSONObject.optString("bind_did");
                        hwr hwr2 = hwr.this;
                        if (!"yunyi.camera.mj1".equals(hwr2.f914O000000o) && hwr2.f914O000000o.contains("yunyi.camera") && !optString.startsWith("yunyi.")) {
                            optString = "yunyi.".concat(String.valueOf(optString));
                        }
                        hwr.this.O000000o(optString);
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(hwr.this.f914O000000o, BindStep.STEP_CHECK_BIND);
                    } else if (optInt == -2) {
                        hwr.this.O00000oo(13);
                        hwr hwr3 = hwr.this;
                        hwr3.O000OoOo = "3000.6.2";
                        if (!hwr3.O000OOoO && hwr.this.O000OOo) {
                            hwr hwr4 = hwr.this;
                            hwr4.O000OOoO = true;
                            if (!hwr4.O000Oo0o) {
                                hwr.this.O00000oO(3103);
                            }
                        }
                        if (hwr.this.O000Oo0o) {
                            hwr.this.O000Oo0O.push(hwr.this.O00000Oo(3103));
                        }
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(hwr.this.f914O000000o, BindStep.STEP_CHECK_BIND, 3103, "bindkey invalid!");
                        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
                        builder.O00000Oo((int) R.string.kuailian_falied_bindkey_invalide);
                        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class _m_j.hwr.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                hwr.this.O000000o("check bind key, the ret :timeout, click to generate a new QR code.", new Object[0]);
                                int intValue = ((Integer) htr.O000000o().O000000o("key_strategy_index", -1)).intValue();
                                gnk.O00000o0(String.format("strategy idx = %d", Integer.valueOf(intValue)));
                                hwr.this.O000000o(intValue == 9 ? SmartConfigStep.Step.STEP_QR_CAMERA : SmartConfigStep.Step.STEP_QR_CONFIG);
                            }
                        });
                        builder.O00000oo();
                    } else if (optInt == -3) {
                        hwr.this.O00000oo(18);
                        hwr hwr5 = hwr.this;
                        hwr5.O000OoOo = "3000.6.3";
                        if (!hwr5.O000OOoO && hwr.this.O000OOo) {
                            hwr hwr6 = hwr.this;
                            hwr6.O000OOoO = true;
                            if (!hwr6.O000Oo0o) {
                                hwr.this.O00000oO(3102);
                            }
                        }
                        if (hwr.this.O000Oo0o) {
                            hwr.this.O000Oo0O.push(hwr.this.O00000Oo(3102));
                        }
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(hwr.this.f914O000000o, BindStep.STEP_CHECK_BIND, 3102, "bindkey already bind!");
                        hwr.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                    } else {
                        hwr.this.O00000oo(20);
                        if (hwr.this.x_() != null) {
                            int i = 2000;
                            if ("chuangmi.camera.ipc009".equals(hwr.this.f914O000000o)) {
                                i = 5000;
                            }
                            hwr.this.x_().removeMessages(122);
                            hwr.this.x_().sendEmptyMessageDelayed(122, (long) i);
                        }
                    }
                } else {
                    hwr.this.O000000o("check bind key onSuccess,but activity is invalid", new Object[0]);
                    hwr.this.O00000oo(11);
                }
            }

            public final void O000000o(hud hud) {
                hwr.this.O00000oo(17);
                hwr.this.O000000o("check bindKey onFail, code %d, msg:%s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                Context context = hwr.this.O000O0oo;
                if (context == null) {
                    hwr.this.O00000oo(9);
                } else if (!(context instanceof CommonActivity) || ((CommonActivity) context).isValid()) {
                    Handler x_ = hwr.this.x_();
                    if (x_ != null) {
                        x_.removeMessages(122);
                        x_.sendEmptyMessageDelayed(122, 2000);
                    }
                } else {
                    hwr.this.O00000oo(11);
                }
            }
        });
    }

    public final void O0000O0o() {
        super.O0000O0o();
        if (!this.O000OoO0 && this.O00O0Oo) {
            O00oOooO();
        }
        O000000o("onFinishStep", new Object[0]);
        gom.O000000o(this.f914O000000o);
    }

    public final void I_() {
        super.I_();
        Handler x_ = x_();
        if (x_ != null) {
            x_.removeMessages(122);
        }
        O000000o("onPauseStep", new Object[0]);
    }

    public final hxy O00000Oo(int i) {
        hxy hxy = new hxy(0L, this.f914O000000o, O0000O0o(i), "", this.O000OOo);
        hxy.O00000oo = ((Integer) htr.O000000o().O000000o("selected_ap_level", 999)).intValue();
        hxy.O0000Oo0 = "NONE";
        return hxy;
    }

    public final void O00000oO(int i) {
        hxy O00000Oo2 = O00000Oo(i);
        O00000Oo2.O0000OoO = this.O0000oO0;
        hxi.O00000o0.O000000o(O00000Oo2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        O000000o(" onStateTimeout", new Object[0]);
        this.O000OoOo = "3000.6.1";
        O00000oo(15);
        if (!hze.O000000o(this.O000O0oo)) {
            this.O000OOo = false;
        }
        if (!this.O000OOoO && this.O000OOo) {
            this.O000OOoO = true;
            if (!this.O000Oo0o) {
                O00000oO(3101);
            }
        }
        if (this.O000Oo0o) {
            this.O000Oo0O.push(O00000Oo(3101));
        }
        O00oOooO();
        O000000o(false, 0, (SmartConfigStep.Step) null);
        if (!hze.O000000o(this.O000O0oo)) {
            O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.phone_wifi_error, R.drawable.common_bind_app_connect_network_failed);
        } else {
            O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.make_device_near_router, R.drawable.common_bind_device_connect_network_failed);
        }
        if (ftn.O00000oo(this.O000O0oo)) {
            this.O000O0o0.O000000o(new View.OnClickListener() {
                /* class _m_j.hwr.AnonymousClass1 */

                public final void onClick(View view) {
                    hwr.this.O000000o(((Integer) htr.O000000o().O000000o("key_strategy_index", -1)).intValue() == 9 ? SmartConfigStep.Step.STEP_QR_CAMERA : SmartConfigStep.Step.STEP_QR_CONFIG);
                }
            });
        }
        return null;
    }

    public final void O00000o0(int i) {
        O000000o("startConnection", new Object[0]);
        ScanResult y_ = y_();
        if (y_ != null) {
            htr.O000000o().O00000Oo("key_report_hash_mac", y_.BSSID);
        }
        String str = (String) htr.O000000o().O000000o("check_bind_key_did");
        if (!TextUtils.isEmpty(str)) {
            O000000o(str);
            return;
        }
        Handler x_ = x_();
        if (x_ != null) {
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.f914O000000o, BindStep.STEP_CHECK_BIND);
            x_.sendEmptyMessage(122);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo(int i) {
        gom.O000000o(this.f914O000000o, i);
    }

    public final void a_(SmartConfigStep.Step step) {
        O000000o("user click retry btn", new Object[0]);
        O00000oo(36);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str) {
        O00000oo(22);
        O000000o("getDeviceInfo did = %s", str, new Object[0]);
        htq.O000000o().O000000o(this.O000O0oo, new String[]{str}, new hua<List<Device>, hud>() {
            /* class _m_j.hwr.AnonymousClass3 */

            public final /* synthetic */ void O000000o(Object obj) {
                List<Device> list = (List) obj;
                hwr.this.O000000o("onSuccess size = %d,and bind device success", Integer.valueOf(list.size()));
                if (list.size() > 0) {
                    hwr.this.O00000oo(24);
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        fno.O000000o().O00000Oo(O000000o2);
                    }
                    for (Device device : list) {
                        if (str.equals(device.did)) {
                            O000000o2 = device;
                        }
                    }
                    hwr.this.O000000o("get deviceInfo onSuccess", new Object[0]);
                    fno.O000000o().O000000o(O000000o2);
                    gwe.O000000o().O000000o(O000000o2);
                    htk.O000000o();
                    htk.O00000Oo(str);
                    htr.O000000o().O00000Oo("connected_device", O000000o2);
                } else {
                    hwr.this.O00000oo(28);
                }
                hwr.this.e_(0);
            }

            public final void O000000o(hud hud) {
                hwr.this.O000000o("get deviceInfo onFail, code =%d,msg %s, but also bind success", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                hwr.this.O00000oo(26);
                gnk.O00000o0(String.format("onFailure %s", hud));
                hwr.this.e_(0);
            }
        });
    }

    public final boolean G_() {
        O000000o("onBackPressed ,stay page time %s ms", String.valueOf(System.currentTimeMillis() - this.O000OO), new Object[0]);
        O00000oo(30);
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwr.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hwr.this.O00000oo(32);
                    if (System.currentTimeMillis() - hwr.this.O000OO < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                        hwr.this.O000OOo = false;
                    }
                    if (!hwr.this.O000OOoO && hwr.this.O000OOo && hze.O000000o(hwr.this.O000O0oo)) {
                        hwr hwr = hwr.this;
                        hwr.O000OOoO = true;
                        if (!hwr.O000Oo0o) {
                            hwr.this.O00000oO(3100);
                        }
                    }
                    if (hwr.this.O000Oo0o && hwr.this.O000Oo0O.isEmpty()) {
                        hwr.this.O000Oo0O.push(hwr.this.O00000Oo(3100));
                    }
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    hwr.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), new DialogInterface.OnClickListener() {
                /* class _m_j.hwr.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hwr.this.O00000oo(34);
                }
            }).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
    }
}
