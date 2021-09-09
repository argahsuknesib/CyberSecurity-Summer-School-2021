package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hys {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hys f998O000000o;

    private hys() {
    }

    public static hys O000000o() {
        if (f998O000000o == null) {
            synchronized (hys.class) {
                if (f998O000000o == null) {
                    f998O000000o = new hys();
                }
            }
        }
        return f998O000000o;
    }

    public final fsn O000000o(Context context, String str, fsm<UserInfo, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/profile").O000000o(arrayList).O000000o(), new fss<UserInfo>() {
            /* class _m_j.hys.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return UserInfo.O000000o(jSONObject);
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, List<Long> list, fsm<List<UserInfo>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                int i = 100;
                if (list.size() <= 100) {
                    i = list.size();
                }
                for (int i2 = 0; i2 < i; i2++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(i2));
                    jSONArray.put(sb.toString());
                }
            }
            jSONObject.put("uids", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/profiles").O000000o(arrayList).O000000o(), new fss<List<UserInfo>>() {
            /* class _m_j.hys.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray;
                ArrayList arrayList = new ArrayList();
                Context appContext = ServiceApplication.getAppContext();
                appContext.getSharedPreferences("shared_user_info_list_" + CoreApi.O000000o().O0000o0(), 0).edit().putString("content", jSONObject.toString()).commit();
                if (!jSONObject.isNull("list") && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserInfo O000000o2 = UserInfo.O000000o(optJSONArray.optJSONObject(i));
                        if (!TextUtils.isEmpty(O000000o2.f7549O000000o) && !TextUtils.isEmpty(O000000o2.O00000Oo) && !TextUtils.isEmpty(O000000o2.f7549O000000o) && !TextUtils.equals("-1", O000000o2.f7549O000000o)) {
                            arrayList.add(O000000o2);
                        }
                    }
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/cancel").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hys.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    public final fsn O000000o(Context context, List<String> list, int i, String str, fsm<List<String>, fso> fsm) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            JSONArray jSONArray2 = new JSONArray();
            for (String put : list) {
                jSONArray2.put(put);
            }
            jSONObject.put("userid", jSONArray2);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("list", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/delete_user").O000000o(arrayList).O000000o(), new fss<List<String>>() {
                /* class _m_j.hys.AnonymousClass4 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                        String optString = jSONObject2.optString("did");
                        if (jSONObject2.optInt("ret") != 1) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException unused2) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    public final fsn O000000o(Context context, String str, int i, String str2, fsm<List<String>, fso> fsm) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str2);
            jSONObject.put("pid", i);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            jSONObject.put("userid", jSONArray2);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("list", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/delete_user").O000000o(arrayList).O000000o(), new fss<List<String>>() {
                /* class _m_j.hys.AnonymousClass5 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                        String optString = jSONObject2.optString("did");
                        if (jSONObject2.optInt("ret") != 1) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException unused2) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }
}
