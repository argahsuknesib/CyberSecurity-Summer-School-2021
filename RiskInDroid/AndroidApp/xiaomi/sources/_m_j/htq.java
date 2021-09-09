package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class htq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile htq f645O000000o;
    private static final Object O00000Oo = new Object();

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000oO(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O0000O0o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O0000OOo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private htq() {
    }

    public static htq O000000o() {
        if (f645O000000o == null) {
            synchronized (O00000Oo) {
                if (f645O000000o == null) {
                    f645O000000o = new htq();
                }
            }
        }
        return f645O000000o;
    }

    public final void O000000o(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua) {
        String str7 = str;
        final String str8 = str2;
        final long currentTimeMillis = System.currentTimeMillis();
        grr.O000000o();
        final int O00000oo = grr.O00000oo(context);
        O000000o("start getNewDevice did:%s, foundBindKey:%s,mac is null=%s,ssid:%s", str7, String.valueOf(z), Boolean.valueOf(TextUtils.isEmpty(str2)), str3);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        final AtomicInteger atomicInteger2 = atomicInteger;
        final String str9 = str;
        final hua<List<Device>, hud> hua2 = hua;
        final AnonymousClass1 r0 = new hua<List<Device>, hud>() {
            /* class _m_j.htq.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                List list = (List) obj;
                int decrementAndGet = atomicInteger2.decrementAndGet();
                long currentTimeMillis = System.currentTimeMillis();
                htq.O000000o("getNewDevice callback onSuccess, getCurrent %d", Integer.valueOf(decrementAndGet));
                if (decrementAndGet == 0) {
                    htq.O000000o(str9, 50);
                    hua2.O000000o(list);
                    SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.TIME, "get_new_device_list", Long.toString(currentTimeMillis - currentTimeMillis), Integer.toString(O00000oo), false);
                } else if (decrementAndGet > 0 && list != null && list.size() > 0) {
                    atomicInteger2.set(0);
                    htq.O000000o(str9, 52);
                    hua2.O000000o(list);
                    SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.TIME, "get_new_device_list", Long.toString(currentTimeMillis - currentTimeMillis), Integer.toString(O00000oo), false);
                }
            }

            public final void O000000o(hud hud) {
                if (hud != null) {
                    htq.O000000o("getNewDevice callback onFail ,code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                } else {
                    htq.O000000o("getNewDevice callback onFail but error is null", new Object[0]);
                }
                htq.O000000o(str9, 45);
                if (hud != null) {
                    htq.O000000o(str9, hud.f693O000000o);
                }
                if (atomicInteger2.decrementAndGet() == 0) {
                    hua2.O000000o(hud);
                }
            }
        };
        final $$Lambda$htq$NDQpdKuz4TWnthMfgimNgN9NtHI r02 = new hub(str6, str8) {
            /* class _m_j.$$Lambda$htq$NDQpdKuz4TWnthMfgimNgN9NtHI */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object parse(JSONObject jSONObject) {
                return htq.O000000o(this.f$0, this.f$1, jSONObject);
            }
        };
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            atomicInteger.incrementAndGet();
            O000000o("searchDeviceByDeviceNew did = ".concat(String.valueOf(str)), new Object[0]);
            JSONObject jSONObject = new JSONObject();
            try {
                String O00000o0 = TextUtils.isEmpty(str3) ? gog.O00000o0(context) : str3;
                String O00000Oo2 = TextUtils.isEmpty(str4) ? gog.O00000Oo(context) : str4;
                if (!TextUtils.isEmpty(O00000o0) && !TextUtils.isEmpty(O00000Oo2)) {
                    jSONObject.put("ssid", O00000o0);
                    jSONObject.put("bssid", O00000Oo2.toUpperCase());
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("did", str7);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("NewDeviceMac", str2.toUpperCase());
                }
            } catch (JSONException unused) {
            }
            O000000o(str7, 46);
            gsy.O00000Oo(LogType.NETWORK, "getNewDevice", "device_new".concat(String.valueOf(jSONObject)));
            O000000o("do http request: /home/device_new", new Object[0]);
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o("/home/device_new", jSONObject), new huc() {
                /* class _m_j.htq.AnonymousClass22 */

                public final void O000000o(String str) {
                    htq.O000000o("searchDeviceByDeviceNew onSuccess ", new Object[0]);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0("dn", !TextUtils.isEmpty(str) ? "yes" : "no");
                    hue.O000000o().O000000o(str, r02, r0);
                }

                public final void O000000o(int i, String str) {
                    hud hud = new hud(i, str);
                    htq.O000000o("searchDeviceByDeviceNew onFail：%s", hud.toString());
                    hua hua = r0;
                    if (hua != null) {
                        hua.O00000Oo(hud);
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0("dn", hud.O000000o());
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str5)) {
            atomicInteger.incrementAndGet();
            O000000o("searchDeviceByCheckBindKey did = ".concat(String.valueOf(str)), new Object[0]);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("bindkey", str5);
            } catch (JSONException unused2) {
            }
            O000000o(str7, 48);
            gsy.O00000Oo(LogType.NETWORK, "getNewDevice", "check_bindkey".concat(String.valueOf(jSONObject2)));
            O000000o("do http request: /user/check_bindkey", new Object[0]);
            final AnonymousClass33 r2 = new hub<JSONObject>() {
                /* class _m_j.htq.AnonymousClass33 */

                /* access modifiers changed from: private */
                /* renamed from: O000000o */
                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    if (jSONObject == null) {
                        return null;
                    }
                    int optInt = jSONObject.optInt("ret");
                    String optString = jSONObject.optString("bind_did");
                    if (optInt != 1 || TextUtils.isEmpty(optString)) {
                        htq.O000000o("searchDeviceByCheckBindKey onFail：ret != 1", new Object[0]);
                    } else {
                        htq htq = htq.this;
                        hub hub = r02;
                        AnonymousClass1 r4 = new hua<List<Device>, hud>() {
                            /* class _m_j.htq.AnonymousClass33.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                List list = (List) obj;
                                if (!TextUtils.isEmpty(str8)) {
                                    htk.O000000o().O000000o(str8, -1);
                                }
                                hvg.O000000o(CommonApplication.getAppContext()).O00000o0("cb", (list == null || list.size() <= 0) ? "no" : "yes");
                                r0.O000000o(list);
                            }

                            public final void O000000o(hud hud) {
                                if (!TextUtils.isEmpty(str8)) {
                                    htk.O000000o().O000000o(str8, 1204);
                                }
                                r0.O000000o(hud);
                                htq.O000000o("http ListPage onFail：%s", hud.toString());
                            }
                        };
                        htq.O000000o("searchDeviceByListPage did = ".concat(String.valueOf(optString)), new Object[0]);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(optString);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("dids", jSONArray);
                        } catch (JSONException unused) {
                        }
                        htq.O000000o(optString, 44);
                        gsy.O00000Oo(LogType.NETWORK, "getNewDevice", "device_list".concat(String.valueOf(jSONObject2)));
                        htq.O000000o("do http request: /v2/home/device_list_page", new Object[0]);
                        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(htq.O000000o("/v2/home/device_list_page", jSONObject2), new huc(hub, r4) {
                            /* class _m_j.htq.AnonymousClass11 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ hub f648O000000o;
                            final /* synthetic */ hua O00000Oo;

                            {
                                this.f648O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void O000000o(String str) {
                                htq.O000000o("searchDeviceByListPage onSuccess ".concat(String.valueOf(str)), new Object[0]);
                                hvg.O000000o(CommonApplication.getAppContext()).O00000o0("dlp", !TextUtils.isEmpty(str) ? "yes" : "no");
                                hue.O000000o().O000000o(str, this.f648O000000o, this.O00000Oo);
                            }

                            public final void O000000o(int i, String str) {
                                if (this.O00000Oo != null) {
                                    hud hud = new hud(i, str);
                                    htq.O000000o("searchDeviceByListPage onFail：%s", hud.toString());
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0("dlp", hud.O000000o());
                                    this.O00000Oo.O00000Oo(hud);
                                }
                                htq.O000000o("device list page onFail：%s", str);
                            }
                        });
                    }
                    return jSONObject;
                }
            };
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o("/user/check_bindkey", jSONObject2), new huc() {
                /* class _m_j.htq.AnonymousClass36 */

                public final void O000000o(String str) {
                    htq.O000000o("searchDeviceByCheckBindKey onSuccess ".concat(String.valueOf(str)), new Object[0]);
                    hue.O000000o().O000000o(str, r2, null);
                    gsy.O00000Oo(LogType.NETWORK, "getNewDevice", "check_bindkey onSuccess:".concat(String.valueOf(str)));
                }

                public final void O000000o(int i, String str) {
                    hud hud = new hud(i, str);
                    htq.O000000o("searchDeviceByCheckBindKey onFail：%s", hud.toString());
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0("cb", hud.O000000o());
                    hua hua = r0;
                    if (hua != null) {
                        hua.O00000Oo(hud);
                    }
                }
            });
        }
        if (atomicInteger.get() == 0) {
            r0.O000000o(new hud(-1, "no request params"));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(String str, String str2, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Device O000000o2 = DeviceFactory.O000000o(optJSONArray.getJSONObject(i));
            if (O000000o2 != null) {
                String optString = optJSONArray.getJSONObject(i).optString("model");
                String optString2 = optJSONArray.getJSONObject(i).optString("uid");
                boolean z = true;
                if (eyr.O000000o(optString, true, 100, eyr.O00000Oo().O0000Oo0) && !TextUtils.equals(optString2, SmartConfigRouterFactory.getCoreApiManager().getMiId())) {
                    z = false;
                }
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str);
                if (pluginInfo != null && pluginInfo.O00000o() == 23 && (TextUtils.isEmpty(O000000o2.parentId) || !O000000o2.isOnline)) {
                    z = false;
                }
                if (z) {
                    arrayList.add(O000000o2);
                }
            } else if (!TextUtils.isEmpty(str2)) {
                htk.O000000o().O000000o(str2, 1205);
            }
        }
        return arrayList;
    }

    public static ConfigNetRequest O000000o(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o(str);
        O000000o2.O00000o0 = arrayList;
        return O000000o2.O000000o();
    }

    public final void O000000o(PushBindEntity pushBindEntity, byte[] bArr, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        int i = !TextUtils.isEmpty(htr.O000000o().O00000Oo()) ? 2 : 1;
        gsy.O00000Oo(LogType.NETWORK, "AiotDeviceStatusStep", "configtype： ".concat(String.valueOf(i)));
        try {
            jSONObject.put("did", pushBindEntity.O0000O0o);
            jSONObject.put("router_did", pushBindEntity.O00000Oo);
            jSONObject.put("configtype", i);
            if (i == 2) {
                KeyPair O000000o2 = fir.O000000o();
                ECPublicKey eCPublicKey = (ECPublicKey) O000000o2.getPublic();
                try {
                    SecretKey O000000o3 = fir.O000000o(fio.O000000o(Base64.decode(pushBindEntity.O0000Oo0, 2), eCPublicKey.getParams()), O000000o2.getPrivate());
                    fip O000000o4 = fip.O000000o("HmacSHA256");
                    O000000o4.O000000o(O000000o3.getEncoded(), gru.O000000o(Base64.decode(pushBindEntity.O0000Oo, 0)).getBytes());
                    byte[] O000000o5 = O000000o4.O000000o("".getBytes(), 16);
                    Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    instance.init(1, new SecretKeySpec(O000000o5, "AES"), new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
                    byte[] doFinal = instance.doFinal(bArr);
                    jSONObject.put("appdata", Base64.encodeToString(doFinal, 2));
                    jSONObject.put("public_key", Base64.encodeToString(fio.O000000o(eCPublicKey), 2));
                    jSONObject.put("sign", Base64.encodeToString(fir.O000000o(O000000o5, doFinal), 2));
                } catch (Exception e) {
                    Log.e("AiotDeviceStatusStep", "ECCurve.verify", e);
                }
            }
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        gsy.O00000Oo(LogType.NETWORK, "AiotDeviceStatusStep", "request bindNbIotDevice:".concat(String.valueOf(jSONObject2)));
        arrayList.add(new ConfigKeyValuePair("data", jSONObject2));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o6 = o000000o.O000000o("/v2/router/config_confirm");
        O000000o6.O00000o0 = arrayList;
        ConfigNetRequest O000000o7 = O000000o6.O000000o();
        final $$Lambda$htq$DRxnbefZbjJAtcnX7CxryuZxBPk r12 = $$Lambda$htq$DRxnbefZbjJAtcnX7CxryuZxBPk.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o7, new huc() {
            /* class _m_j.htq.AnonymousClass2 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r12, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(String str, String str2, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("regist_by", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final $$Lambda$htq$1Q7r1NMcZoElTzsBUoSv1oKDPm0 r4 = $$Lambda$htq$1Q7r1NMcZoElTzsBUoSv1oKDPm0.INSTANCE;
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/v2/home/report_new_bind");
        O000000o2.O00000o0 = arrayList;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o2.O000000o(), new huc() {
            /* class _m_j.htq.AnonymousClass3 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r4, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

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
    public final void O00000Oo(String str, String str2, final hua<JSONObject, hud> hua) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            hua.O000000o(new hud(Integer.MIN_VALUE, "empty did"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("timezone", str2);
            jSONObject.put("sync_device", false);
            arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
            ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
            o000000o.f11489O000000o = "POST";
            ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/v2/device/set_timezone");
            O000000o2.O00000o0 = arrayList;
            ConfigNetRequest O000000o3 = O000000o2.O000000o();
            final AnonymousClass4 r5 = new hub<JSONObject>() {
                /* class _m_j.htq.AnonymousClass4 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            };
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
                /* class _m_j.htq.AnonymousClass5 */

                public final void O000000o(String str) {
                    hue.O000000o().O000000o(str, r5, hua);
                }

                public final void O000000o(int i, String str) {
                    hua hua = hua;
                    if (hua != null) {
                        hua.O00000Oo(new hud(i, str));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public final void O00000o0(String str, String str2, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/appgateway/miot/appbindkeyservice/AppBindKeyService/GetBindKey");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final AnonymousClass6 r0 = new hub<JSONObject>() {
            /* class _m_j.htq.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        if (eyr.O000000o(str, true, 100, eyr.O00000Oo().O0000oOo)) {
            hua.O000000o(new hud(-1, "设备不支持动态did"));
        } else {
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
                /* class _m_j.htq.AnonymousClass7 */

                public final void O000000o(String str) {
                    hue.O000000o().O000000o(str, r0, hua);
                }

                public final void O000000o(int i, String str) {
                    hua hua = hua;
                    if (hua != null) {
                        hua.O00000Oo(new hud(i, str));
                    }
                }
            });
        }
    }

    public final void O000000o(final hua<String, hud> hua) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ConfigKeyValuePair("data", new JSONObject().toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/user/get_bindkey");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final AnonymousClass8 r1 = new hub<String>() {
            /* class _m_j.htq.AnonymousClass8 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optString("bindkey");
            }
        };
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass9 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r1, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(String str, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bindkey", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/user/check_bindkey");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final AnonymousClass10 r0 = new hub<JSONObject>() {
            /* class _m_j.htq.AnonymousClass10 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass12 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r0, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(String str, String str2, String str3, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", str);
            jSONObject.put("token", str2);
            jSONObject.put("model", str3);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/device/lapapplydid");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$RVrImLNjonfE918FnOwjeB6DrPg r5 = $$Lambda$htq$RVrImLNjonfE918FnOwjeB6DrPg.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass13 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r5, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(String str, String str2, String str3, String str4, String str5, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", str);
            jSONObject.put("token", str2);
            jSONObject.put("model", str3);
            jSONObject.put("did", str4);
            jSONObject.put("passwd", str5);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/device/lapbind");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$QD39UwC14uDxiEYIrwClsrcYCM r5 = $$Lambda$htq$QD39UwC14uDxiEYIrwClsrcYCM.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass14 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r5, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(Context context, String[] strArr, final hua<List<Device>, hud> hua) {
        if (context != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i <= 0; i++) {
                    jSONArray.put(strArr[0]);
                }
                jSONObject.put("dids", jSONArray);
                String O00000o0 = gog.O00000o0(context.getApplicationContext());
                String O00000Oo2 = gog.O00000Oo(context.getApplicationContext());
                if (!TextUtils.isEmpty(O00000o0) && !TextUtils.isEmpty(O00000Oo2) && !TextUtils.equals(O00000Oo2, "02:00:00:00:00:00")) {
                    jSONObject.put("ssid", O00000o0);
                    jSONObject.put("bssid", O00000Oo2.toUpperCase());
                }
            } catch (JSONException unused) {
            }
            final AnonymousClass17 r6 = new hub<JSONObject>() {
                /* class _m_j.htq.AnonymousClass17 */

                /* access modifiers changed from: private */
                /* renamed from: O000000o */
                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject != null) {
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("list");
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                    if (optJSONObject != null) {
                                        arrayList.add(DeviceFactory.O000000o(optJSONObject));
                                    }
                                }
                            }
                            if (jSONObject.optBoolean("has_more")) {
                                String optString = jSONObject.optString("next_start_did");
                                gsy.O00000Oo("SmartConfigApi", "/home/device_list_new request next page with did:".concat(String.valueOf(optString)));
                                jSONObject.put("start_did", optString);
                                SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(htq.O000000o("/v2/home/device_list_page", jSONObject), new huc() {
                                    /* class _m_j.htq.AnonymousClass17.AnonymousClass1 */

                                    public final void O000000o(String str) {
                                        hue.O000000o().O000000o(str, this, null);
                                    }

                                    public final void O000000o(int i, String str) {
                                        if (hua != null) {
                                            hua.O00000Oo(new hud(i, str));
                                        }
                                    }
                                });
                            } else {
                                gsy.O00000Oo("SmartConfigApi", "/home/device_list_response success times:" + arrayList.size());
                                if (hua != null) {
                                    hua.O00000Oo(arrayList);
                                }
                            }
                        } catch (JSONException e) {
                            gsy.O00000Oo("SmartConfigApi", "/home/device_list_response JSONException times:" + arrayList.size());
                            hua hua = hua;
                            if (hua != null) {
                                hua.O00000Oo(new hud(-1, Log.getStackTraceString(e)));
                            }
                        }
                    } else {
                        gsy.O00000Oo("SmartConfigApi", "/home/device_list_response resultObject null times:" + arrayList.size());
                        if (hua != null) {
                            hua.O00000Oo(arrayList);
                        }
                    }
                    return jSONObject;
                }
            };
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o("/v2/home/device_list_page", jSONObject), new huc() {
                /* class _m_j.htq.AnonymousClass18 */

                public final void O000000o(String str) {
                    hue.O000000o().O000000o(str, r6, null);
                }

                public final void O000000o(int i, String str) {
                    hua hua = hua;
                    if (hua != null) {
                        hua.O00000Oo(new hud(i, str));
                    }
                }
            });
        }
    }

    public final void O00000Oo(String str, String str2, String str3, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", str);
            jSONObject.put("bindKey", str2);
            jSONObject.put("sign", str3);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        gsy.O00000Oo(LogType.NETWORK, "NbiotStep", "request bindNbIotDevice:".concat(String.valueOf(jSONObject2)));
        arrayList.add(new ConfigKeyValuePair("data", jSONObject2));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/v2/device/nb_iot_bind");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final AnonymousClass19 r5 = new hub<JSONObject>() {
            /* class _m_j.htq.AnonymousClass19 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass20 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r5, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O00000o(String str, String str2, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "POST");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("user_id", SmartConfigRouterFactory.getCoreApiManager().getMiId());
            jSONObject2.put("router_did", str);
            jSONObject2.put("deviceId", str);
            jSONObject2.put("bssid", str2);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/appgateway/third/miwifi/app/r/api/misystem/get_iotdev_status");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$LIq2bTi451kuRMrfYI3wvFONBms r8 = $$Lambda$htq$LIq2bTi451kuRMrfYI3wvFONBms.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass21 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r8, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O000000o(String str, String str2, String str3, String str4, final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
            jSONObject.put("router_did", str2);
            jSONObject.put("ssid", str3);
            jSONObject.put("bssid", str4);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        gsy.O00000Oo(LogType.NETWORK, "NbiotStep", "request bindNbIotDevice:".concat(String.valueOf(jSONObject2)));
        arrayList.add(new ConfigKeyValuePair("data", jSONObject2));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/v2/aiot/bind_confirm");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$C1Us2EeAVvj4prdxVfDfC1rVhAI r5 = $$Lambda$htq$C1Us2EeAVvj4prdxVfDfC1rVhAI.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass23 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r5, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O00000Oo(final hua<JSONObject, hud> hua) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ConfigKeyValuePair("data", new JSONObject().toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/user/get_bindkey");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$2wnNRYj3GS7wl7qIttjYv_DDi4 r1 = $$Lambda$htq$2wnNRYj3GS7wl7qIttjYv_DDi4.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass24 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r1, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O00000Oo(String str, final hua<String, hud> hua) {
        MiioLocalAPI.O000000o(str, new dxe() {
            /* class _m_j.htq.AnonymousClass27 */

            public final void onResponse(String str) {
                htq.O00000o0(str, new hua<JSONObject, hud>() {
                    /* class _m_j.htq.AnonymousClass27.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        String optString = ((JSONObject) obj).optString("token");
                        if (hua != null) {
                            hua.O00000Oo(optString);
                        }
                    }

                    public final void O000000o(hud hud) {
                        if (hua != null) {
                            hua.O00000Oo(hud);
                        }
                    }
                });
            }
        }, 9);
    }

    public static void O00000o0(String str, hua<JSONObject, hud> hua) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            if (optInt != 0) {
                hua.O00000Oo(new hud(optInt, ""));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
            }
            hua.O00000Oo(optJSONObject);
        } catch (JSONException unused) {
            hua.O00000Oo(new hud(-31, ""));
        }
    }

    public final void O000000o(Device device, final hua<Integer, hud> hua) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", device.did);
            jSONObject.put("token", device.token);
            jSONObject.put("pid", device.pid);
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/home/binddevice");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final $$Lambda$htq$DMFfJBEcn_v4FhwGSXebegTs0UQ r0 = $$Lambda$htq$DMFfJBEcn_v4FhwGSXebegTs0UQ.INSTANCE;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class _m_j.htq.AnonymousClass28 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r0, hua);
            }

            public final void O000000o(int i, String str) {
                hua hua = hua;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final void O00000Oo(final Device device, final hua<Integer, hud> hua) {
        O000000o(device, new hua<Integer, hud>() {
            /* class _m_j.htq.AnonymousClass29 */

            public final /* synthetic */ void O000000o(Object obj) {
                Integer num = (Integer) obj;
                if (num.intValue() == 1) {
                    device.setOwner(true);
                    device.userId = SmartConfigRouterFactory.getCoreApiManager().getMiId();
                }
                fno.O000000o().O000000o(device);
                hua.O000000o(num);
            }

            public final void O000000o(hud hud) {
                hua.O000000o(hud);
            }
        });
    }

    public static void O000000o(String str, int i) {
        if (str == null) {
            str = "0";
        }
        gok.O000000o(str, i);
    }

    public static void O000000o(String str, Object... objArr) {
        hts.O000000o("SmartConfigApi", str, objArr);
    }
}
