package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bro {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13221O000000o = false;

    public static String O000000o(Context context) {
        if (btq.O000000o(context).O000000o()) {
            return btq.O00000Oo();
        }
        return null;
    }

    public static String O000000o(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tid", str);
            jSONObject.put("diu", str2);
            jSONObject.put("diu2", str3);
            jSONObject.put("diu3", str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String O000000o2 = bwo.O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            String O000000o3 = bwh.O000000o(bsp.O000000o((jSONObject2 + "\u0000").getBytes(), O000000o2.getBytes()));
            if (!TextUtils.isEmpty(O000000o3)) {
                try {
                    String O000000o4 = bwh.O000000o(bwn.O000000o(O000000o2.getBytes("utf-8"), bwn.O000000o("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUi5cTlCSDfczffuYb2UyvrKXuW/7xqBhLYG1ro+PmCNdJ01U1o7uc18YP6VNl5ZBF1IadY/XC6JphzBzCARVOqk1OE/Qfb1dQF6tO2nEZmDVDFeMHXsDtM1Jic/ntBcAy7Y6GP3OyqPRLgUribU7+m4CmAtk8b5y117cyWMBsXwIDAQAB")));
                    return "key=" + URLEncoder.encode(O000000o4) + "&data=" + URLEncoder.encode(O000000o3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized Map<String, String> O000000o() {
        synchronized (bro.class) {
            if (f13221O000000o) {
                return null;
            }
            f13221O000000o = true;
            HashMap hashMap = new HashMap();
            hashMap.put("ent", "2");
            StringBuilder sb = new StringBuilder();
            sb.append("channel=lbs_sdk&div=ANDSDK10");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lbs_sdkANDSDK10@Z2naXvxC0K5f6IEJhtQzUolm9S8yOTkq");
            String O000000o2 = bwo.O000000o(stringBuffer.toString());
            sb.append("&sign=");
            sb.append(O000000o2.toUpperCase(Locale.US));
            sb.append("&output=json\u0000");
            hashMap.put("in", bwh.O000000o(bsp.O000000o(sb.toString().getBytes(), "DVGeEYOpNkFbzfQA".getBytes())));
            hashMap.put("keyt", "100");
            return hashMap;
        }
    }

    public static String O00000Oo() {
        return bwm.O00000Oo();
    }

    public static void O000000o(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("code") == 1) {
                String optString = new JSONObject(jSONObject.optString("data")).optString("adiu");
                if (!TextUtils.isEmpty(optString)) {
                    bwm.O000000o(optString);
                    btq O000000o2 = btq.O000000o(context);
                    buk.O000000o(O000000o2.f13276O000000o).O00000Oo = O000000o2.O00000Oo;
                    buk O000000o3 = buk.O000000o(O000000o2.f13276O000000o);
                    if (O000000o3.f13288O000000o != null) {
                        O000000o3.f13288O000000o.clear();
                        O000000o3.f13288O000000o.add(optString);
                    }
                    O000000o3.O000000o(optString, 273);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
