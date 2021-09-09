package _m_j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONObject;

public class ibu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ibu f1163O000000o;
    private static Map<Long, O000000o> O00000Oo;

    static {
        HashMap hashMap = new HashMap();
        O00000Oo = hashMap;
        hashMap.put(2882303761518389966L, new O000000o(2882303761518389966L, "com.yeelight.yeelight_iot", "NYP4eKp9/aUSy4tiMcLDFQ=="));
        O00000Oo.put(2882303761518390269L, new O000000o(2882303761518390269L, "com.yeelight.iot.yeelight_iot_engineering", "FxuI7DejwlurmX5ItGKBdw=="));
    }

    private ibu() {
    }

    public static ibu O000000o() {
        if (f1163O000000o == null) {
            synchronized (ibu.class) {
                if (f1163O000000o == null) {
                    f1163O000000o = new ibu();
                }
            }
        }
        return f1163O000000o;
    }

    public static String O000000o(long j) {
        return O00000Oo.containsKey(Long.valueOf(j)) ? O00000Oo.get(Long.valueOf(j)).O00000Oo : "";
    }

    public static String O00000Oo(long j) {
        return O00000Oo.containsKey(Long.valueOf(j)) ? O00000Oo.get(Long.valueOf(j)).O00000o0 : "";
    }

    public static JSONObject O000000o(long j, String str, String str2, String str3) {
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://account.xiaomi.com/oauth2/token").newBuilder();
        newBuilder.addQueryParameter("client_id", String.valueOf(j));
        newBuilder.addQueryParameter("client_secret", str);
        newBuilder.addQueryParameter("grant_type", "authorization_code");
        newBuilder.addQueryParameter("redirect_uri", str2);
        newBuilder.addQueryParameter("code", str3);
        JSONObject jSONObject = null;
        try {
            try {
                JSONObject jSONObject2 = new JSONObject(icf.O000000o().O00000Oo().newCall(new Request.Builder().url(newBuilder.toString()).build()).execute().body().string().replace("&&&START&&&", ""));
                try {
                    jSONObject2.put("mijia_server", gty.O000000o().getServerMachineCode());
                    return jSONObject2;
                } catch (Exception e) {
                    e = e;
                    jSONObject = jSONObject2;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f1164O000000o;
        public String O00000Oo;
        public String O00000o0;

        public O000000o(long j, String str, String str2) {
            this.f1164O000000o = j;
            this.O00000o0 = str2;
            this.O00000Oo = str;
        }
    }
}
