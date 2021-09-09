package _m_j;

import _m_j.fui;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fuj {
    private static final Object O00000o = new Object();
    private static volatile fuj O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f17184O000000o;
    public String O00000Oo;

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private fuj() {
    }

    public static fuj O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000o) {
                if (O00000o0 == null) {
                    O00000o0 = new fuj();
                }
            }
        }
        return O00000o0;
    }

    public static String O00000Oo() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return "local_userconfig_pref";
        }
        return CoreApi.O000000o().O0000o0() + "_local_userconfig_pref";
    }

    public final fsn O000000o(Context context, JSONArray jSONArray, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONArray.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/set_user_config").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fuj.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, fui fui, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        new JSONObject();
        try {
            arrayList.add(new KeyValuePair("data", fui.O000000o(fui).toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/set_user_config").O000000o(arrayList).O000000o(), new fss<Void>() {
                /* class _m_j.fuj.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return null;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return new fsn(null);
        }
    }

    public final void O000000o(fui fui) {
        if (fui == null) {
            gsy.O000000o(6, "UserApi", "setUserConfigLocal userConfig is null");
        } else {
            CommonApplication.getGlobalWorkerHandler().post(new Runnable(fui, null) {
                /* class _m_j.fuj.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ fui f17187O000000o;
                final /* synthetic */ fsm O00000Oo = null;

                {
                    this.f17187O000000o = r2;
                }

                public final void run() {
                    if (fuj.this.f17184O000000o != null && !fuj.this.O00000Oo.equals(fuj.O00000Oo())) {
                        fuj.this.f17184O000000o = null;
                    }
                    if (fuj.this.f17184O000000o == null) {
                        fuj.this.O00000Oo = fuj.O00000Oo();
                        fuj.this.f17184O000000o = CommonApplication.getAppContext().getSharedPreferences(fuj.this.O00000Oo, 0);
                    }
                    try {
                        JSONObject O000000o2 = fui.O000000o(this.f17187O000000o);
                        SharedPreferences.Editor edit = fuj.this.f17184O000000o.edit();
                        edit.putString(this.f17187O000000o.f17181O000000o + this.f17187O000000o.O00000Oo, O000000o2.toString()).apply();
                        if (this.O00000Oo != null) {
                            this.O00000Oo.onSuccess(null);
                        }
                    } catch (JSONException e) {
                        fsm fsm = this.O00000Oo;
                        if (fsm != null) {
                            fsm.onFailure(new fso(-1, e.getMessage()));
                        }
                    }
                }
            });
        }
    }

    public final fsn O000000o(Context context, String[] strArr, fsm<ArrayList<fui>, fso> fsm) {
        if (fuq.O000000o().O000000o(context, 0, strArr, fsm)) {
            return new fsn(null);
        }
        return O000000o(context, 0, strArr, fsm);
    }

    private fsn O000000o(Context context, int i, String[] strArr, fsm<ArrayList<fui>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("component_id", 0);
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("keys", jSONArray);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_user_config").O000000o(arrayList).O000000o(), new fss<ArrayList<fui>>() {
            /* class _m_j.fuj.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        fui O000000o2 = fui.O000000o(optJSONArray.getJSONObject(i));
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        }
                    }
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, int i, JSONArray jSONArray, fsm<Map<Integer, fui.O00000Oo>, fso> fsm) {
        if (!fuq.O000000o().O000000o(context, i, jSONArray, fsm)) {
            return O00000Oo(context, i, jSONArray, fsm);
        }
        gsy.O00000Oo(LogType.NETWORK, "UserApi", "testAccept intercepted");
        return new fsn(null);
    }

    private fsn O00000Oo(Context context, int i, JSONArray jSONArray, fsm<Map<Integer, fui.O00000Oo>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("component_id", i);
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put("keys", jSONArray);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_user_config").O000000o(arrayList).O000000o(), new fss<Map<Integer, fui.O00000Oo>>() {
            /* class _m_j.fuj.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                HashMap hashMap = new HashMap();
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        fui.O00000Oo O000000o2 = fui.O00000Oo.O000000o(optJSONArray.getJSONObject(i));
                        if (O000000o2 != null) {
                            hashMap.put(Integer.valueOf(O000000o2.O00000Oo), O000000o2);
                        }
                    }
                }
                return hashMap;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("key", str);
            jSONObject2.put("value", str2);
            jSONObject.put("configInfos", jSONArray);
        } catch (JSONException unused) {
        }
        jSONArray.put(jSONObject2);
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/user/set_common_config").O000000o(arrayList).O000000o(), $$Lambda$fuj$JaPP_Hiwt10EakHct1fBP31J9uo.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, List<String> list, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        fli.O000000o(list, jSONArray);
        try {
            jSONObject.put("keys", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/user/get_common_config").O000000o(arrayList).O000000o(), $$Lambda$fuj$WzejBoLRPRMK5GsOGAAp3DvsqSA.INSTANCE, Crypto.RC4, fsm);
    }
}
