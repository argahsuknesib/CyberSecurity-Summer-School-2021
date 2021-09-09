package _m_j;

import _m_j.fui;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fuh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fuh f17174O000000o;
    private static final Object O00000Oo = new Object();

    private fuh() {
    }

    public static fuh O000000o() {
        if (f17174O000000o == null) {
            synchronized (O00000Oo) {
                if (f17174O000000o == null) {
                    f17174O000000o = new fuh();
                }
            }
        }
        return f17174O000000o;
    }

    public final fsn O000000o(Context context, String str, JSONArray jSONArray, fsm<Map<Integer, fui.O00000Oo>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
            if (jSONArray.length() > 0) {
                jSONObject.put("keys", jSONArray);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_third_user_config").O000000o(arrayList).O000000o(), new fss<Map<Integer, fui.O00000Oo>>() {
            /* class _m_j.fuh.AnonymousClass1 */

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

    public final fsn O000000o(Context context, String str, String str2, fsm<fuo, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prefix", str);
            jSONObject.put("suffix", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/uploaduserfileurl").O000000o(arrayList).O000000o(), new fss<fuo>() {
            /* class _m_j.fuh.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return O000000o(jSONObject);
            }

            private static fuo O000000o(JSONObject jSONObject) throws JSONException {
                fuo fuo = new fuo();
                try {
                    fuo.f17193O000000o = jSONObject.getString("url");
                    fuo.O00000Oo = jSONObject.getString("obj_name");
                    fuo.O00000o0 = jSONObject.optString("method");
                } catch (Exception unused) {
                }
                return fuo;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, Locale locale, ServerBean serverBean, fsm<Void, fso> fsm) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        if (locale == null) {
            locale = CoreApi.O000000o().O00oOooo();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (locale.getLanguage() == null) {
                str = "";
            } else {
                str = locale.getLanguage().toLowerCase();
            }
            if (locale.getCountry() == null) {
                str2 = "";
            } else {
                str2 = locale.getCountry().toLowerCase();
            }
            if (!TextUtils.equals("en", str)) {
                if (!TextUtils.equals("ko", str) && !TextUtils.equals("ru", str) && !TextUtils.equals("es", str) && !TextUtils.equals("it", str) && !TextUtils.equals("fr", str) && !TextUtils.equals("id", str) && !TextUtils.equals("de", str) && !TextUtils.equals("pl", str) && !TextUtils.equals("vi", str) && !TextUtils.equals("ja", str) && !TextUtils.equals("th", str) && !TextUtils.equals("ar", str)) {
                    if (!TextUtils.equals("he", str)) {
                        if (!TextUtils.equals("in", str) || !TextUtils.equals("id", str2)) {
                            str = str + "_" + locale.getCountry();
                        } else {
                            str = "id";
                        }
                    }
                }
            }
            jSONObject.put("Language", str.trim());
            jSONObject.put("Locale", "");
            jSONObject.put("Country", serverBean.O00000Oo);
            grr.O000000o();
            jSONObject.put("TimeZone", grr.O0000o0o());
            grr.O000000o();
            jSONObject.put("TimeZoneID", grr.O0000o());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        try {
            jSONObject2 = jSONObject2.replace("\\", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject2));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/setuserglobal").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static int[] O000000o(JSONObject jSONObject, String str, int i, JSONArray jSONArray) throws JSONException {
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.length();
        if (length <= 2048) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", str);
            jSONObject3.put("key", String.valueOf(i));
            jSONObject3.put("data", jSONObject2);
            jSONArray.put(jSONObject3);
            return new int[]{i};
        }
        int i2 = length / 2048;
        if (length % 2048 != 0) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i3 > 1000) {
            return new int[0];
        }
        int[] iArr = new int[i3];
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("model", str);
        jSONObject4.put("key", String.valueOf(i));
        iArr[0] = i;
        int i4 = i + 1;
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("ts", i4);
        jSONObject5.put("tc", i2);
        jSONObject4.put("data", jSONObject5.toString());
        jSONArray.put(jSONObject4);
        int i5 = 0;
        int i6 = 1;
        for (int i7 = 0; i7 < i2; i7++) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("model", str);
            jSONObject6.put("key", String.valueOf(i4));
            if (i7 == i2 - 1) {
                jSONObject6.put("data", jSONObject2.substring(i5));
            } else {
                jSONObject6.put("data", jSONObject2.substring(i5, i5 + 2048));
            }
            jSONArray.put(jSONObject6);
            i5 += 2048;
            iArr[i6] = i4;
            i4++;
            i6++;
        }
        return iArr;
    }

    public static void O000000o(JSONObject jSONObject, JSONArray jSONArray, String str) throws JSONException {
        int i;
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.length();
        if (length > 2048) {
            i = length / 2048;
            if (length % 2048 != 0) {
                i++;
            }
        } else {
            i = 1;
        }
        if (i + 1 <= 100) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("component_id", str);
            jSONObject3.put("key", new StringBuilder("1").toString());
            JSONObject jSONObject4 = new JSONObject();
            int i2 = 2;
            jSONObject4.put("ts", 2);
            jSONObject4.put("tc", i);
            jSONObject3.put("data", jSONObject4.toString());
            jSONArray.put(jSONObject3);
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("component_id", str);
                jSONObject5.put("key", String.valueOf(i2));
                if (i4 == i - 1) {
                    jSONObject5.put("data", jSONObject2.substring(i3));
                } else {
                    jSONObject5.put("data", jSONObject2.substring(i3, i3 + 2048));
                }
                jSONArray.put(jSONObject5);
                i3 += 2048;
                i2++;
            }
        }
    }

    public static String O000000o(int i, int i2, Map<Integer, fui.O00000Oo> map) {
        int i3 = i2 + i;
        String str = "";
        while (i < i3) {
            fui.O00000Oo o00000Oo = map.get(Integer.valueOf(i));
            if (o00000Oo == null) {
                return null;
            }
            str = str + o00000Oo.O00000o0;
            i++;
        }
        return str;
    }

    public static boolean O000000o(fui.O00000Oo o00000Oo, int[] iArr) {
        if (o00000Oo != null && !TextUtils.isEmpty(o00000Oo.O00000o0)) {
            try {
                JSONObject jSONObject = new JSONObject(o00000Oo.O00000o0);
                iArr[0] = jSONObject.optInt("ts");
                iArr[1] = jSONObject.optInt("tc");
                if (jSONObject.isNull("ts") || jSONObject.isNull("tc")) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final fsn O000000o(Context context, int i, String str, fsm<List<hsx>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pid", i);
            jSONObject.put("did", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/get_share_user").O000000o(arrayList).O000000o(), new fss<List<hsx>>() {
            /* class _m_j.fuh.AnonymousClass6 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                    hsx hsx = new hsx();
                    hsx.f607O000000o = jSONObject2.optString("userid");
                    hsx.O00000Oo = jSONObject2.optString("nickname");
                    if (TextUtils.isEmpty(hsx.O00000Oo)) {
                        hsx.O00000Oo = hsx.f607O000000o;
                    }
                    hsx.O00000o0 = jSONObject2.optString("icon");
                    hsx.O00000o = jSONObject2.optLong("sharetime");
                    hsx.O00000oO = jSONObject2.optInt("status");
                    if (!jSONObject2.isNull("isReadOnly")) {
                        hsx.O00000oo = jSONObject2.optBoolean("isReadOnly") ? 1 : 2;
                    }
                    arrayList.add(hsx);
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, fsm<HashMap<String, List<hsx>>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/device_share_list").O000000o(arrayList).O000000o(), new fss<HashMap<String, List<hsx>>>() {
            /* class _m_j.fuh.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("list");
                if (optJSONObject == null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    if (optJSONArray != null) {
                        optJSONArray.length();
                    }
                    return hashMap;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = (List) hashMap.get(next);
                    if (obj == null) {
                        obj = new ArrayList();
                        hashMap.put(next, obj);
                    }
                    JSONArray jSONArray = optJSONObject.getJSONArray(next);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        hsx hsx = new hsx();
                        hsx.f607O000000o = jSONObject2.optString("userid");
                        hsx.O00000Oo = jSONObject2.optString("nickname");
                        if (TextUtils.isEmpty(hsx.O00000Oo)) {
                            hsx.O00000Oo = hsx.f607O000000o;
                        }
                        hsx.O00000o0 = jSONObject2.optString("icon");
                        hsx.O00000o = jSONObject2.optLong("mtime");
                        obj.add(hsx);
                    }
                }
                return hashMap;
            }
        }, Crypto.RC4, fsm);
    }
}
