package _m_j;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class hwt extends ConfigStep {
    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final int O00000Oo() {
        return 0;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        return null;
    }

    public final void z_() {
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 15000;
        arrayList.add(gke);
        return arrayList;
    }

    public final void O00000o0(int i) {
        int i2 = AnonymousClass5.f930O000000o[BaseBindView.StepStatus.LOADING.ordinal()];
        if (i2 == 1) {
            this.O000O0o0.O000000o(3);
            this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.keep_phone_wifi_connect);
        } else if (i2 == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi, (int) R.string.keep_phone_wifi_connect);
        } else if (i2 == 3) {
            O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.keep_phone_wifi_connect, (int) R.drawable.common_bind_device_connect_network_failed);
        }
        final String str = (String) htr.O000000o().O000000o("bind_device_did");
        String str2 = (String) htr.O000000o().O000000o("bind_device_token");
        String str3 = (String) htr.O000000o().O000000o("bind_device_sn");
        Long l = (Long) htr.O000000o().O000000o("bind_device_timestamp");
        String str4 = (String) htr.O000000o().O000000o("bind_device_key");
        if (TextUtils.isEmpty(str4)) {
            String authAppId = hsl.O000000o().getAuthAppId();
            htq O000000o2 = htq.O000000o();
            long longValue = l.longValue();
            AnonymousClass1 r2 = new hua<Integer, hud>() {
                /* class _m_j.hwt.AnonymousClass1 */

                public final void O000000o(hud hud) {
                    hsl.O000000o().handleAuthFail(-113);
                    hwt.this.b_(false);
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    hwt.this.O000000o(str);
                }
            };
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("token", str2);
                jSONObject.put("sn", str3);
                jSONObject.put("hashstamp", longValue);
                jSONObject.put("applicationId", authAppId);
            } catch (JSONException unused) {
            }
            arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
            ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
            o000000o.f11489O000000o = "POST";
            ConfigNetRequest.O000000o O000000o3 = o000000o.O000000o("/home/appbinddevice");
            O000000o3.O00000o0 = arrayList;
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3.O000000o(), new huc(new hub<Integer>() {
                /* class _m_j.htq.AnonymousClass31 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) {
                    return Integer.valueOf(jSONObject.getInt("ret"));
                }
            }, r2) {
                /* class _m_j.htq.AnonymousClass32 */

                /* renamed from: O000000o */
                final /* synthetic */ hub f673O000000o;
                final /* synthetic */ hua O00000Oo;

                {
                    this.f673O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void O000000o(String str) {
                    hue.O000000o().O000000o(str, this.f673O000000o, this.O00000Oo);
                }

                public final void O000000o(int i, String str) {
                    hua hua = this.O00000Oo;
                    if (hua != null) {
                        hua.O00000Oo(new hud(i, str));
                    }
                }
            });
            return;
        }
        htq O000000o4 = htq.O000000o();
        AnonymousClass2 r1 = new hua<JSONObject, hud>() {
            /* class _m_j.hwt.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                String optString = ((JSONObject) obj).optString("bind_did");
                if (TextUtils.isEmpty(optString)) {
                    hsl.O000000o().handleAuthFail(-113);
                    hwt.this.b_(false);
                    return;
                }
                hwt.this.O000000o(optString);
                gsy.O000000o(6, "SmartHome", String.format("Bind Success did = %s", optString));
            }

            public final void O000000o(hud hud) {
                gsy.O000000o(6, "SmartHome", String.format("Bind Error did = %s, error - %d", str, Integer.valueOf(hud.f693O000000o)));
                hsl.O000000o().handleAuthFail(-113);
                hwt.this.b_(false);
            }
        };
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bind_key", str4);
        } catch (JSONException unused2) {
        }
        arrayList2.add(new ConfigKeyValuePair("data", jSONObject2.toString()));
        ConfigNetRequest.O000000o o000000o2 = new ConfigNetRequest.O000000o();
        o000000o2.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o5 = o000000o2.O000000o("/home/bind_with_bindkey");
        O000000o5.O00000o0 = arrayList2;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o5.O000000o(), new huc(new hub<JSONObject>() {
            /* class _m_j.htq.AnonymousClass34 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) {
                return jSONObject;
            }
        }, r1) {
            /* class _m_j.htq.AnonymousClass35 */

            /* renamed from: O000000o */
            final /* synthetic */ hub f677O000000o;
            final /* synthetic */ hua O00000Oo;

            {
                this.f677O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, this.f677O000000o, this.O00000Oo);
            }

            public final void O000000o(int i, String str) {
                hua hua = this.O00000Oo;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(int i, int i2, Intent intent) {
        O0000ooo();
        gsy.O000000o(6, "SmartHome", "onActivityResult");
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str) {
        gsy.O000000o(6, "SmartHome", String.format("getDeviceInfo did = %s", str));
        htq.O000000o().O000000o(this.O000O0oo, new String[]{str}, new hua<List<Device>, hud>() {
            /* class _m_j.hwt.AnonymousClass3 */

            public final /* synthetic */ void O000000o(Object obj) {
                List list = (List) obj;
                if (list.size() > 0) {
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        fno.O000000o().O00000Oo(O000000o2);
                    }
                    Device device = (Device) list.get(0);
                    fno.O000000o().O000000o(device);
                    gsy.O000000o(6, "SmartHome", String.format("OnSuccess did = %s", str));
                    htk.O000000o();
                    htk.O00000Oo(str);
                    htr.O000000o().O00000Oo("connected_device", device);
                    hwt.this.x_().postDelayed(new Runnable() {
                        /* class _m_j.hwt.AnonymousClass3.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                          _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                          _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
                        public final void run() {
                            fbs.O000000o(new fbt(hwt.this.O000O0oo, "/setting/DeviceAuthSlaveListActivity").O000000o("device_id", str).O000000o("bottom_bar", true).O000000o(6));
                        }
                    }, 1000);
                    hwt.this.x_().postDelayed(new Runnable() {
                        /* class _m_j.hwt.AnonymousClass3.AnonymousClass2 */

                        public final void run() {
                            gsy.O000000o(6, "SmartHome", "Start final page and do callback");
                            hwt.this.O0000ooo();
                            hsl.O000000o().handleAuthSuccess(101);
                        }
                    }, 2000);
                    return;
                }
                gsy.O000000o(6, "SmartHome", String.format("Find No Device did = %s", str));
                hwt.this.O0000ooo();
                hsl.O000000o().handleAuthSuccess(100);
            }

            public final void O000000o(hud hud) {
                hsl.O000000o().handleAuthSuccess(100);
                hwt.this.O0000ooo();
            }
        });
    }

    /* renamed from: _m_j.hwt$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f930O000000o = new int[BaseBindView.StepStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f930O000000o[BaseBindView.StepStatus.LOADING.ordinal()] = 1;
            f930O000000o[BaseBindView.StepStatus.SUCCESS.ordinal()] = 2;
            try {
                f930O000000o[BaseBindView.StepStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwt.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    hwt.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
