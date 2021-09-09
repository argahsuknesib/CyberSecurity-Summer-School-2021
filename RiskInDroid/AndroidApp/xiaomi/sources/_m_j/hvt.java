package _m_j;

import _m_j.hvt;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hvt extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f722O000000o;
    public boolean O00000Oo;
    int O00000o = 0;
    public PushBindEntity O00000o0;
    public String O00000oO = null;
    public String O00000oo = null;
    public Runnable O0000O0o = new Runnable() {
        /* class _m_j.hvt.AnonymousClass1 */

        public final void run() {
            if (hvt.this.O00000o0 != null && hvt.this.O00000Oo && !hvt.this.O000OO00) {
                htq O000000o2 = htq.O000000o();
                String str = hvt.this.O00000o0.O0000O0o;
                String str2 = hvt.this.O00000o0.O00000o;
                AnonymousClass1 r4 = new hua<JSONObject, hud>() {
                    /* class _m_j.hvt.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        int i;
                        JSONObject jSONObject = (JSONObject) obj;
                        gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "isBoundDeviceStatus:".concat(String.valueOf(jSONObject)));
                        if (jSONObject == null) {
                            i = 0;
                        } else {
                            i = jSONObject.optInt("status");
                        }
                        if (i == 3) {
                            hvt.this.f722O000000o = 0;
                            hvt.this.O0000oOO();
                        } else if (i == 2) {
                            hvt.this.O00000Oo(1);
                            hvt.this.f722O000000o = 2;
                        } else {
                            hvt.this.f722O000000o = 0;
                        }
                    }

                    public final void O000000o(hud hud) {
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "isBoundDeviceStatus-onFailure:" + hud.O00000Oo);
                    }
                };
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", str);
                    jSONObject.put("mac", str2);
                } catch (JSONException unused) {
                }
                arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
                ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
                o000000o.f11489O000000o = "POST";
                ConfigNetRequest.O000000o O000000o3 = o000000o.O000000o("/v2/router/config_status");
                O000000o3.O00000o0 = arrayList;
                SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3.O000000o(), new huc(new hub<JSONObject>() {
                    /* class _m_j.htq.AnonymousClass39 */

                    public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) {
                        return jSONObject;
                    }
                }, r4) {
                    /* class _m_j.htq.AnonymousClass40 */

                    /* renamed from: O000000o */
                    final /* synthetic */ hub f683O000000o;
                    final /* synthetic */ hua O00000Oo;

                    {
                        this.f683O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void O000000o(String str) {
                        hue.O000000o().O000000o(str, this.f683O000000o, this.O00000Oo);
                    }

                    public final void O000000o(int i, String str) {
                        hua hua = this.O00000Oo;
                        if (hua != null) {
                            hua.O00000Oo(new hud(i, str));
                        }
                    }
                });
                htq.O000000o().O000000o(hvt.this.O000O0oo, hvt.this.O00000o0.O0000O0o, false, hvt.this.O00000o0.O00000o, hvt.this.O00000o0.O00000oO, hvt.this.O00000o0.O00000oo, null, hvt.this.O000OOOo, new hua<List<Device>, hud>() {
                    /* class _m_j.hvt.AnonymousClass1.AnonymousClass2 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        Device device;
                        List list = (List) obj;
                        gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "checkNext--success: " + list.size());
                        if (list.size() == 0 || (device = (Device) list.get(0)) == null) {
                            gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "checkNext: count-- " + hvt.this.O00000o);
                            O000000o();
                        } else {
                            hvt.this.O000000o(device);
                        }
                        hvt.this.O00000o++;
                    }

                    public final void O000000o(hud hud) {
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "getNewDevice--fail: " + hud.O00000Oo);
                        O000000o();
                    }

                    private void O000000o() {
                        hvt.this.x_().postDelayed(hvt.this.O0000O0o, 4000);
                    }
                });
            }
        }
    };
    public Runnable O0000OOo = new Runnable() {
        /* class _m_j.hvt.AnonymousClass2 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
         arg types: [java.lang.String, int]
         candidates:
          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
        public final void run() {
            hvt hvt = hvt.this;
            gsy.O00000o0(LogType.KUAILIAN, "AiotDeviceStatusStep", "getConfigDevices");
            htq O000000o2 = htq.O000000o();
            AnonymousClass5 r2 = new hua<JSONObject, hud>() {
                /* class _m_j.hvt.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "AiotDeviceStatusStep", "getConfigDevices onSuccess:" + jSONObject.toString());
                    hvt.this.x_().post(new Runnable(jSONObject) {
                        /* class _m_j.$$Lambda$hvt$5$MDiJMEAAYLNF7vBPv9l9tXn3uFI */
                        private final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            hvt.AnonymousClass5.this.O000000o(this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(JSONObject jSONObject) {
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("devices");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                PushBindEntity O000000o2 = PushBindEntity.O000000o(optJSONArray.optJSONObject(i), true);
                                if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.O0000O0o) && !hwf.O00000Oo(O000000o2.f11457O000000o.O00000Oo())) {
                                    O000000o2.O0000OoO = true;
                                    if (O000000o2.O0000O0o.equals(hvt.this.O00000o0.O0000O0o) && !TextUtils.isEmpty(O000000o2.O0000Oo0)) {
                                        hvt.this.O00000o0 = O000000o2;
                                        if (hvt.this.O00000Oo) {
                                            hvt.this.O000000o(hvt.this.O00000o0);
                                        }
                                        hvt.this.x_().removeCallbacks(hvt.this.O0000OOo);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000o0(logType, "AiotDeviceStatusStep", "getConfigDevices onSuccess Exception:" + e.getMessage());
                    }
                    if (TextUtils.isEmpty(hvt.this.O00000o0.O0000Oo0)) {
                        hvt.this.O00000o();
                    }
                }

                public final void O000000o(hud hud) {
                    gsy.O00000o0(LogType.KUAILIAN, "AiotDeviceStatusStep", "getConfigDevices onFailure:".concat(String.valueOf(hud)));
                    hvt.this.O00000o();
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("showNotShake", true);
            } catch (JSONException e) {
                e.printStackTrace();
                gsy.O00000o0(LogType.KUAILIAN, "SmartConfigApi", "getConfigDevices JSONException");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
            ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
            o000000o.f11489O000000o = "POST";
            ConfigNetRequest.O000000o O000000o3 = o000000o.O000000o("/v2/router/config_devices");
            O000000o3.O00000o0 = arrayList;
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3.O000000o(), new huc(new hub<JSONObject>() {
                /* class _m_j.htq.AnonymousClass37 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) {
                    return jSONObject;
                }
            }, r2) {
                /* class _m_j.htq.AnonymousClass38 */

                /* renamed from: O000000o */
                final /* synthetic */ hub f680O000000o;
                final /* synthetic */ hua O00000Oo;

                {
                    this.f680O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void O000000o(String str) {
                    hue.O000000o().O000000o(str, this.f680O000000o, this.O00000Oo);
                }

                public final void O000000o(int i, String str) {
                    hua hua = this.O00000Oo;
                    if (hua != null) {
                        hua.O000000o(new hud(i, str));
                    }
                }
            });
        }
    };
    Device O0000Oo;
    int O0000Oo0 = 2;
    private int O0000OoO = -1;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void O000000o(Device device) {
        this.O0000Oo = device;
        htr.O000000o().O00000Oo("connected_device", device);
        fno.O000000o().O000000o(device);
        fno.O000000o().O0000Oo0(device.did);
        gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "DeviceFinderCallback.onDeviceConnectionSuccess");
        this.f722O000000o = 2;
        O00000Oo(2);
        O00000Oo(device);
    }

    private void O00000Oo(Device device) {
        this.O0000Oo0 = 2;
        if (O0000o()) {
            this.f722O000000o = 3;
            O000000o(device, new Callback() {
                /* class _m_j.hvt.AnonymousClass3 */

                public final void onSuccess(Object obj) {
                    hvt.this.u_();
                }

                public final void onFailure(int i, String str) {
                    hvt.this.O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                }
            });
        }
    }

    public final void O000000o(final Device device, final Callback callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "device_auth_login");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loginurl", this.O00000oo);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        fjq.O000000o().O000000o(device.did, jSONObject.toString(), new fjo<String>() {
            /* class _m_j.hvt.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                int i = -1;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i = new JSONObject(str).optInt("code", -1);
                        if (i == 0) {
                            callback.onSuccess(str);
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (hvt.this.O0000Oo0 == 0) {
                    callback.onFailure(i, "");
                    return;
                }
                hvt hvt = hvt.this;
                hvt.O0000Oo0--;
                hvt.this.x_().postDelayed(new Runnable() {
                    /* class _m_j.hvt.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        hvt.this.O000000o(device, callback);
                    }
                }, 4000);
            }

            public final void O000000o(int i) {
                if (hvt.this.O0000Oo0 == 0) {
                    callback.onFailure(i, "");
                    return;
                }
                hvt hvt = hvt.this;
                hvt.O0000Oo0--;
                hvt.this.x_().postDelayed(new Runnable() {
                    /* class _m_j.hvt.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        hvt.this.O000000o(device, callback);
                    }
                }, 4000);
            }

            public final void O000000o(int i, Object obj) {
                if (hvt.this.O0000Oo0 == 0) {
                    callback.onFailure(i, "");
                    return;
                }
                hvt hvt = hvt.this;
                hvt.O0000Oo0--;
                hvt.this.x_().postDelayed(new Runnable() {
                    /* class _m_j.hvt.AnonymousClass4.AnonymousClass3 */

                    public final void run() {
                        hvt.this.O000000o(device, callback);
                    }
                }, 4000);
            }
        });
    }

    public final void O00000o() {
        if (this.O00000Oo) {
            x_().removeCallbacks(this.O0000OOo);
            x_().postDelayed(this.O0000OOo, 1000);
        }
    }

    public final void O00000Oo(int i) {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "onIndexSuccess: mSuccessStep-- " + this.O0000OoO + "  --index: " + i);
        for (int i2 = this.O0000OoO; i2 < i; i2++) {
            e_(i);
        }
        this.O0000OoO = i;
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 90000;
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 90000;
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = 90000;
        arrayList.add(gke);
        arrayList.add(gke2);
        arrayList.add(gke3);
        if (O0000o()) {
            gke gke4 = new gke();
            gke4.f17943O000000o = 3;
            gke4.O00000Oo = 50000;
            arrayList.add(gke4);
        }
        return arrayList;
    }

    public final void C_() {
        O00000oO(this.f722O000000o);
    }

    private void O00000oO(int i) {
        gsy.O000000o(4, "AiotDeviceStatusStep", " getStepIndex(): " + this.O000O0o0.getStepIndex() + "  --step: " + i);
        if (this.O000O0o0.getStepIndex() == 1 && i >= 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.router_recongise_device_success, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o(2);
        }
        if (this.O000O0o0.getStepIndex() == 2 && i > 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        }
        if (this.O000O0o0.getStepIndex() == 3 && 2 <= i) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.device_bind_success, (int) R.string.gateway_wifi_hintdevice);
        }
    }

    public final void O000000o(Context context) {
        gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "onCreateStep");
        this.O00000o0 = (PushBindEntity) htr.O000000o().O000000o("aiot_wifi");
        this.O000OOOo = this.O00000o0.f11457O000000o.O00000Oo();
        htr.O000000o().O00000Oo("device_model", this.O00000o0.f11457O000000o.O00000Oo());
        super.O000000o(context);
    }

    public final void O00000o0(int i) {
        Device device;
        if (this.f722O000000o != 3 || (device = this.O0000Oo) == null) {
            this.O00000Oo = true;
            this.O0000OoO = -1;
            this.f722O000000o = 0;
            LogType logType = LogType.KUAILIAN;
            gsy.O00000Oo(logType, "AiotDeviceStatusStep", "startConnection:" + this.O00000o0);
            if (O0000o()) {
                SmartConfigRouterFactory.getSmartConfigManager().getLoginInfo(new hua<huv, hud>() {
                    /* class _m_j.hvt.AnonymousClass6 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        huv huv = (huv) obj;
                        hvt.this.O00000oO = huv.O00000o0;
                        hvt.this.O00000oo = huv.O00000Oo;
                        if (TextUtils.isEmpty(hvt.this.O00000o0.O0000Oo0)) {
                            hvt.this.x_().post(hvt.this.O0000OOo);
                            return;
                        }
                        hvt hvt = hvt.this;
                        hvt.O000000o(hvt.O00000o0);
                    }

                    public final void O000000o(hud hud) {
                        hvt.this.O00000Oo(SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR);
                    }
                });
            } else if (TextUtils.isEmpty(this.O00000o0.O0000Oo0)) {
                x_().post(this.O0000OOo);
            } else {
                O000000o(this.O00000o0);
            }
        } else {
            O00000Oo(device);
        }
    }

    public final void O000000o(PushBindEntity pushBindEntity) {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "makeWifiParams： " + O0000o0o().toString());
        htq.O000000o().O000000o(pushBindEntity, O0000o0o().toString().getBytes(), new hua<JSONObject, hud>() {
            /* class _m_j.hvt.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                LogType logType = LogType.KUAILIAN;
                gsy.O00000Oo(logType, "AiotDeviceStatusStep", "startConnection.onSuccess： " + ((JSONObject) obj).toString());
                hvt.this.x_().postDelayed(hvt.this.O0000O0o, 4000);
            }

            public final void O000000o(hud hud) {
                hvt.this.O0000oOO();
                LogType logType = LogType.KUAILIAN;
                gsy.O00000Oo(logType, "AiotDeviceStatusStep", "startConnection.onFailure： " + hud.O00000Oo);
            }
        });
    }

    private JSONObject O0000o0o() {
        JSONObject jSONObject = new JSONObject();
        try {
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            jSONObject.put("config_type", this.O0000oo0.type);
            String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
            if (!TextUtils.isEmpty(countryDomain)) {
                jSONObject.put("country_domain", countryDomain);
            }
            jSONObject.put("gmt_offset", (Integer) htr.O000000o().O000000o("gmt_offset", 28800));
            if (O00000o02 == null) {
                O00000o02 = "";
            }
            jSONObject.put("passwd", O00000o02);
            jSONObject.put("ssid", O00000Oo2);
            jSONObject.put("tz", htr.O000000o().O000000o("gmt_tz", ""));
            JSONObject jSONObject2 = new JSONObject();
            String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
            if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                countryCode = "CN";
            }
            jSONObject2.put("cc", countryCode);
            jSONObject.put("wifi_config", jSONObject2);
            gsy.O00000Oo("AiotDeviceStatusStep", "WifiConfigJson : " + jSONObject2.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean O0000o() {
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O000OOOo);
        return pluginInfo != null && pluginInfo.O00000o() == 20;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.hvt.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        if (i == 0) {
            x_().removeCallbacks(this.O0000OOo);
        }
        this.O00000Oo = false;
        gsy.O00000Oo(LogType.KUAILIAN, "AiotDeviceStatusStep", "onStageTimeOut index:".concat(String.valueOf(i)));
        O00000oO(i - 1);
        if (i == 0) {
            this.O000OoOo = "3000.7.1";
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail, (int) R.drawable.common_bind_device_has_binded_failed);
        } else if (i == 1) {
            this.O000OoOo = "3000.7.2";
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.ble_combo_device_title_error, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 2) {
            this.O000OoOo = "3000.7.3";
            O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.ble_combo_device_title_error, (int) R.drawable.common_bind_device_connect_network_failed);
        }
        O000000o(false, 0, (SmartConfigStep.Step) null);
        this.O000O0o0.setCommonBtnText(this.O000O0oo.getString(R.string.push_changewifi_fail_rechose));
        this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
            /* class _m_j.hvt.AnonymousClass8 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(hvt.this.O000O0oo, "ResetDevicePage").O000000o("model", hvt.this.O00000o0.f11457O000000o.O00000Oo()).O000000o(101));
            }
        });
        SmartConfigRouterFactory.getSmartConfigManager().addBlackList(this.O00000o0);
        return null;
    }

    public final void z_() {
        this.f722O000000o = 0;
    }

    public final int O00000Oo() {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "getCurrentStageIndex mCurrentIndex:" + this.f722O000000o);
        return this.f722O000000o;
    }

    public final void O0000O0o() {
        htr.O000000o().O00000Oo("mi_router_info", null);
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "AiotDeviceStatusStep", "onFinishStep mCurrentIndex:" + this.f722O000000o);
        super.O0000O0o();
    }

    public final void B_() {
        this.O000O0o0.O000000o();
        this.O000O0o0.O000000o((int) R.string.wifi_recongise_device, (int) R.string.wifi_add_device);
        this.O000O0o0.O000000o(1);
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == 100) {
            boolean booleanExtra = intent.getBooleanExtra("login_result", false);
            fte.O00000Oo("AiotDeviceStatusStep onActivityResult login_result = ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                this.f722O000000o = 3;
                e_(3);
                return;
            }
            O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
            return;
        }
        ((Activity) this.O000O0oo).setResult(i2, intent);
        O000O0o();
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hvt.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hvt.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void u_() {
        fte.O00000Oo("AiotDeviceStatusStep startPassportAuth Use Local Account");
        fbt fbt = new fbt(this.O000O0oo, "ScDeviceLocalAccountWebAuthActivity");
        if (this.O000Ooo0) {
            fbt.O000000o("height_ratio");
        }
        fbt.O000000o("login_url", this.O00000oO).O000000o(100);
        fbs.O000000o(fbt);
    }
}
