package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity;
import com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hps {
    private static volatile hps O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private SharedPreferences f489O000000o;

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private hps() {
    }

    public static hps O000000o() {
        if (O00000Oo == null) {
            synchronized (hps.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hps();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(String str, final int i, final fsm<List<SceneApi.O000OOOo>, fso> fsm) {
        hob.O000000o();
        hob.O000000o(ServiceApplication.getAppContext(), 15, str, new fsm<JSONObject, fso>() {
            /* class _m_j.hps.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONObject != null) {
                    int i = 0;
                    while (jSONObject.has(String.valueOf(i))) {
                        try {
                            SceneApi.O000OOOo O000000o2 = SceneApi.O000OOOo.O000000o(jSONObject.optJSONObject(String.valueOf(i)), false);
                            if (O000000o2 != null) {
                                arrayList.add(O000000o2);
                            }
                            i++;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (((SceneApi.O000OOOo) arrayList.get(size)).O00000o != i) {
                            arrayList.remove(size);
                        }
                    }
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(arrayList);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    public final void O000000o(String str, fsm<PluginRecommendSceneInfo, fso> fsm) {
        String concat = "plugin_recommend_scene_".concat(String.valueOf(str));
        if (this.f489O000000o == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.f489O000000o = appContext.getSharedPreferences(O000000o2 + "scene_list_cache", 0);
            }
        }
        SharedPreferences sharedPreferences = this.f489O000000o;
        String str2 = "";
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(concat, str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                fsm.onSuccess(PluginRecommendSceneInfo.parse(new JSONObject(str2)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("api_version", 5);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/scene/get_rec_in_plugin").O000000o(arrayList).O000000o(), new fss(str) {
                /* class _m_j.$$Lambda$hps$h8e86nwBqgncH_pYHBwk0BaXhfM */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final Object parse(JSONObject jSONObject) {
                    return hps.this.O000000o(this.f$1, jSONObject);
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e2) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e2.getMessage()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PluginRecommendSceneInfo O000000o(String str, JSONObject jSONObject) throws JSONException {
        String concat = "plugin_recommend_scene_".concat(String.valueOf(str));
        String jSONObject2 = jSONObject.toString();
        if (this.f489O000000o == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.f489O000000o = appContext.getSharedPreferences(O000000o2 + "scene_list_cache", 0);
            }
        }
        SharedPreferences sharedPreferences = this.f489O000000o;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(concat, jSONObject2);
            edit.apply();
        }
        return PluginRecommendSceneInfo.parse(jSONObject);
    }

    public static void O00000Oo(String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/get_ble_keysetting").O000000o(arrayList).O000000o(), $$Lambda$hps$YFxmNGdR6uCjRsj89gEOj0rfeM.INSTANCE, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
        }
    }

    public static void O000000o(List<String> list, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("dids", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/get_ble_gatewayinfo").O000000o(arrayList).O000000o(), $$Lambda$hps$hG2slJ0DeU9xfYmyHWkKtmeOI1A.INSTANCE, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
        }
    }

    public final void O000000o(final fsm<JSONObject, fso> fsm) {
        new AppConfigHelper(ServiceApplication.getAppContext()).O000000o("scene_rec_result_temp_youpin", "1", "zh_CN", null, new AppConfigHelper.O000000o() {
            /* class _m_j.hps.AnonymousClass2 */

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                fsm fsm = fsm;
                if (fsm != null) {
                    try {
                        fsm.onSuccess(new JSONObject(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
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
    public static void O000000o(String str, String str2, boolean z, boolean z2, fsm<List<JSONObject>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sr_id", str);
            }
            jSONObject.put("need_blegateway", true);
            jSONObject.put("need_zigbeegateway", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/scene/get_scene_rec_product_url").O000000o(arrayList).O000000o(), new fss(str2, z, z2) {
            /* class _m_j.$$Lambda$hps$eULcgPHq78w5xXECWe2ZQwU4tmA */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object parse(JSONObject jSONObject) {
                return hps.O000000o(this.f$0, this.f$1, this.f$2, jSONObject);
            }
        }, Crypto.RC4, fsm);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(String str, boolean z, boolean z2, JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject3 = jSONObject.optJSONObject(str.toLowerCase());
        if (optJSONObject3 != null) {
            Iterator<String> keys = optJSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next);
                if (optJSONObject4 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(next, optJSONObject4.optString("good_url"));
                    arrayList.add(jSONObject2);
                }
            }
        }
        if (z && (optJSONObject2 = jSONObject.optJSONObject("BleGateway".toLowerCase())) != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(next2);
                if (optJSONObject5 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(next2, optJSONObject5.optString("good_url"));
                    arrayList.add(jSONObject3);
                }
            }
        }
        if (z2 && (optJSONObject = jSONObject.optJSONObject("ZigbeeGateway".toLowerCase())) != null) {
            Iterator<String> keys3 = optJSONObject.keys();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                JSONObject optJSONObject6 = optJSONObject.optJSONObject(next3);
                if (optJSONObject6 != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(next3, optJSONObject6.optString("good_url"));
                    arrayList.add(jSONObject4);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static Intent O000000o(Context context, String str, String str2) {
        try {
            if (Long.parseLong(str2) / 1000 == 2) {
                Intent intent = new Intent(context, CreateSceneFromRecommendActivity.class);
                intent.putExtra("need_choose_detail", true);
                intent.putExtra("sr_id", new Integer(str2));
                intent.putExtra("did", str);
                return intent;
            }
            char c = 65535;
            switch (str2.hashCode()) {
                case 1507423:
                    if (str2.equals("1000")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1507424:
                    if (str2.equals("1001")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1507425:
                    if (str2.equals("1002")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1507426:
                    if (str2.equals("1003")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                Intent intent2 = new Intent(context, PluginRecommendSceneActivity.class);
                intent2.putExtra("sr_id", new Integer(str2));
                intent2.putExtra("did", str);
                return intent2;
            } else if (c != 1 && c != 2 && c != 3) {
                return null;
            } else {
                Intent intent3 = new Intent(context, LightActionStartActivity.class);
                intent3.putExtra("sr_id", new Integer(str2));
                intent3.putExtra("did", str);
                return intent3;
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
