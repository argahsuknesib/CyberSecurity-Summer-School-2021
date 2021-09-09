package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fwd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fwd f17301O000000o;

    private fwd() {
    }

    public static fwd O000000o() {
        if (f17301O000000o == null) {
            synchronized (fwd.class) {
                if (f17301O000000o == null) {
                    f17301O000000o = new fwd();
                }
            }
        }
        return f17301O000000o;
    }

    public final fsn O000000o(Context context, String str, List<String> list, fsm<List<String>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("pincode", str);
            jSONObject.put("dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/erase_alone").O000000o(arrayList).O000000o(), new fss<List<String>>() {
            /* class _m_j.fwd.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            List<String> f17302O000000o = new ArrayList();

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray = jSONObject.optJSONArray("dids");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.f17302O000000o.add(optJSONArray.getString(i));
                    }
                }
                return this.f17302O000000o;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, List<String> list, fsm<List<String>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/erase_generic").O000000o(arrayList).O000000o(), new fss<List<String>>() {
            /* class _m_j.fwd.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            List<String> f17303O000000o = new ArrayList();

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray = jSONObject.optJSONArray("dids");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.f17303O000000o.add(optJSONArray.getString(i));
                    }
                }
                return this.f17303O000000o;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, fsm<JSONObject, fso> fsm) {
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/get_generic").O000000o(), new fss<JSONObject>() {
            /* class _m_j.fwd.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, String str2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pincode", str);
            if (str2 != null) {
                jSONObject.put("did", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        AnonymousClass4 r5 = new fss<Boolean>() {
            /* class _m_j.fwd.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/check_generic").O000000o(arrayList).O000000o(), r5, Crypto.RC4, fsm);
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
    public final fsn O000000o(Context context, String str, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isforget", true);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        AnonymousClass5 r6 = new fss<Boolean>() {
            /* class _m_j.fwd.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/check_generic").O000000o(arrayList).O000000o(), r6, Crypto.RC4, fsm);
    }

    public final fsn O00000Oo(Context context, fsm<Boolean, fso> fsm) {
        return O000000o(context, 2, null, 1, fsm);
    }

    public final fsn O000000o(Context context, int i, String str, int i2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pincode", str);
            }
            jSONObject.put("status", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        AnonymousClass6 r4 = new fss<Boolean>() {
            /* class _m_j.fwd.AnonymousClass6 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/set_generic").O000000o(arrayList).O000000o(), r4, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, List<String> list, int i, fsm<List<String>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("dids", jSONArray);
            jSONObject.put("apply2all", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        AnonymousClass7 r5 = new fss<List<String>>() {
            /* class _m_j.fwd.AnonymousClass7 */

            /* renamed from: O000000o  reason: collision with root package name */
            List<String> f17308O000000o = new ArrayList();

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray = jSONObject.optJSONArray("dids");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.f17308O000000o.add(optJSONArray.getString(i));
                    }
                }
                return this.f17308O000000o;
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/pincode/apply_generic").O000000o(arrayList).O000000o(), r5, Crypto.RC4, fsm);
    }
}
