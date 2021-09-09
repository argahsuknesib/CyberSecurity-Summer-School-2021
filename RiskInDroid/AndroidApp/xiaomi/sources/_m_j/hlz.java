package _m_j;

import _m_j.hlz;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hlz {
    public static void O000000o(String str, final fsm<O000000o, fso> fsm) {
        O000000o(Collections.singletonList(str), new fsm<O000000o[], fso>() {
            /* class _m_j.hlz.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                O000000o[] o000000oArr = (O000000o[]) obj;
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(o000000oArr[0]);
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

    public static void O000000o(List<String> list, fsm<O000000o[], fso> fsm) {
        if (list == null || list.size() == 0) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.$$Lambda$hlz$D01x2LZJfTk8TwF79RA6zzmL3Ko */

                public final void run() {
                    fsm.this.onSuccess(new hlz.O000000o[0]);
                }
            });
        } else {
            CommonApplication.getGlobalWorkerHandler().post(new Runnable(list, fsm) {
                /* class _m_j.$$Lambda$hlz$74aOBzdFQwZMyWPw0SubZKdhi8c */
                private final /* synthetic */ List f$0;
                private final /* synthetic */ fsm f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    hlz.O00000Oo(this.f$0, this.f$1);
                }
            });
        }
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
    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(List list, fsm fsm) {
        O000000o[] o000000oArr = new O000000o[list.size()];
        StringBuilder sb = new StringBuilder();
        SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("get_product_config_cache_json2", 0);
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String string = sharedPreferences.getString(str, null);
            if (TextUtils.isEmpty(string)) {
                sb.append(str);
                sb.append(",");
            } else {
                gsy.O00000Oo("DeviceImageApi", "get cache model:" + str + " url:" + string);
                try {
                    o000000oArr[i] = O000000o.O000000o(new JSONObject(string));
                } catch (JSONException e) {
                    gsy.O00000Oo(LogType.NETWORK, "DeviceImageApi", Log.getStackTraceString(e));
                }
            }
        }
        if (sb.length() != 0) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String sb2 = sb.deleteCharAt(sb.length() - 1).toString();
            try {
                jSONObject.put("models", sb2);
                jSONObject.put("device", Build.DEVICE);
                jSONObject.put("include_gray", true);
            } catch (JSONException e2) {
                gsy.O00000Oo(LogType.NETWORK, "DeviceImageApi", Log.getStackTraceString(e2));
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo(CoreApi.O000000o().O0000Ooo() ? "/v2/product/get_product_config_new" : "/v2/public/get_product_config").O000000o(arrayList).O000000o(), new fss(sb2, sharedPreferences, list, o000000oArr) {
                /* class _m_j.$$Lambda$hlz$AhyTWuA5vMbjGxMNgqr8To4iuY */
                private final /* synthetic */ String f$0;
                private final /* synthetic */ SharedPreferences f$1;
                private final /* synthetic */ List f$2;
                private final /* synthetic */ hlz.O000000o[] f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final Object parse(JSONObject jSONObject) {
                    return hlz.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, jSONObject);
                }
            }, Crypto.RC4, fsm);
        } else if (fsm != null) {
            CommonApplication.getGlobalHandler().post(new Runnable(o000000oArr) {
                /* class _m_j.$$Lambda$hlz$PP15xAH8ZQUMQLMIcWmMk7gpoI */
                private final /* synthetic */ hlz.O000000o[] f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    fsm.this.onSuccess(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ O000000o[] O000000o(String str, SharedPreferences sharedPreferences, List list, O000000o[] o000000oArr, JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("configs");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            O000000o O000000o2 = O000000o.O000000o(optJSONObject);
            String str2 = O000000o2.O00000o0;
            if (TextUtils.isEmpty(str2)) {
                String[] split = str.split(",");
                if (split.length > i) {
                    str2 = split[i];
                    O000000o2.O00000o0 = str2;
                }
            }
            if (!TextUtils.isEmpty(O000000o2.f19057O000000o) || !TextUtils.isEmpty(O000000o2.O00000Oo)) {
                if (optJSONObject != null) {
                    String jSONObject2 = optJSONObject.toString();
                    gsy.O00000Oo("DeviceImageApi", "request model:" + str2 + " url:" + jSONObject2);
                    sharedPreferences.edit().putString(str2, jSONObject2).apply();
                }
            } else if (!TextUtils.isEmpty(O000000o2.O0000OOo)) {
                O000000o2.f19057O000000o = O000000o2.O0000OOo;
            }
            int indexOf = list.indexOf(str2);
            if (indexOf >= 0) {
                o000000oArr[indexOf] = O000000o2;
            }
        }
        for (int i2 = 0; i2 < o000000oArr.length; i2++) {
            O000000o o000000o = o000000oArr[i2];
            if (o000000o == null) {
                o000000o = new O000000o();
                o000000oArr[i2] = o000000o;
                o000000o.O00000o0 = (String) list.get(i2);
            }
            PluginDeviceInfo pluginDeviceInfo = null;
            if (TextUtils.isEmpty(o000000o.f19057O000000o) && (pluginDeviceInfo = CoreApi.O000000o().O00000oO(o000000o.O00000o0)) != null) {
                o000000o.O0000OOo = pluginDeviceInfo.O0000o0();
                o000000o.f19057O000000o = o000000o.O0000OOo;
            }
            if (TextUtils.isEmpty(o000000o.O00000o) && !(pluginDeviceInfo == null && (pluginDeviceInfo = CoreApi.O000000o().O00000oO(o000000o.O00000o0)) == null)) {
                o000000o.O00000o = pluginDeviceInfo.O0000Oo0();
            }
        }
        return o000000oArr;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f19057O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public int O00000oO;
        public int O00000oo;
        public String O0000O0o;
        public String O0000OOo;

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            JSONObject optJSONObject = jSONObject.optJSONObject("neg_screen");
            if (jSONObject == null) {
                return o000000o;
            }
            o000000o.O00000o0 = jSONObject.optString("model");
            o000000o.O00000o = jSONObject.optString("name");
            o000000o.O00000oO = jSONObject.optInt("wifi_rssi");
            o000000o.O00000oo = jSONObject.optInt("link_rssi");
            o000000o.O0000O0o = jSONObject.optString("bt_bind_style");
            o000000o.O0000OOo = jSONObject.optString("icon_real");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("short_480");
                String optString2 = optJSONObject.optString("short_video");
                String optString3 = optJSONObject.optString("neg_480");
                String optString4 = optJSONObject.optString("neg_video");
                if (!TextUtils.isEmpty(optString3)) {
                    o000000o.f19057O000000o = optString3;
                } else if (!TextUtils.isEmpty(optString)) {
                    o000000o.f19057O000000o = "https://static.home.mi.com/app/image/get/file/".concat(String.valueOf(optString));
                } else {
                    o000000o.f19057O000000o = "";
                }
                if (!TextUtils.isEmpty(optString4)) {
                    o000000o.O00000Oo = optString4;
                } else if (!TextUtils.isEmpty(optString2)) {
                    o000000o.O00000Oo = "https://static.home.mi.com/app/image/get/file/".concat(String.valueOf(optString2));
                } else {
                    o000000o.O00000Oo = "";
                }
            }
            return o000000o;
        }
    }
}
