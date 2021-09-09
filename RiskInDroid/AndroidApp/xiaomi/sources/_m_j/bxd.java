package _m_j;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bxd {
    public static String O000000o(bxm bxm, String str, Map<String, String> map) {
        if (bxm.O000000o() != 600 || TextUtils.isEmpty(str)) {
            bxb.O00000Oo("Error: build request data not invalid params!");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject O000000o2 = O000000o(bxm);
            if (O000000o2 == null) {
                bxb.O00000Oo("Error: build request header error!");
                return null;
            }
            jSONObject.put(bxj.O000000o("header"), O000000o2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bxj.O000000o("action"), bxj.O00000o0(str));
            JSONObject O000000o3 = O000000o(map);
            if (O000000o3 == null) {
                bxb.O00000Oo("Error: build request data error!");
                return null;
            }
            jSONObject2.put(bxj.O000000o("params"), O000000o3);
            jSONObject.put(bxj.O000000o("data"), jSONObject2);
            String jSONObject3 = jSONObject.toString();
            bxb.O000000o("build request json str: ".concat(String.valueOf(jSONObject3)));
            if (jSONObject3.getBytes().length <= 500) {
                return jSONObject3;
            }
            String O000000o4 = bxk.O000000o("2", jSONObject3);
            bxb.O000000o("Compress request str: ".concat(String.valueOf(O000000o4)));
            return O000000o4;
        } catch (JSONException e) {
            bxb.O00000Oo("Error: build request data exception: " + e.getMessage());
            return null;
        }
    }

    private static JSONObject O000000o(Map<String, String> map) {
        JSONObject jSONObject;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    jSONObject = new JSONObject();
                    try {
                        for (Map.Entry next : map.entrySet()) {
                            jSONObject.put(bxj.O000000o((String) next.getKey()), next.getValue());
                        }
                        return jSONObject;
                    } catch (JSONException e) {
                        e = e;
                        bxb.O00000Oo("Error: build data error: " + e.getMessage());
                        return jSONObject;
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        }
        return new JSONObject("{}");
    }

    private static JSONObject O000000o(bxm bxm) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(bxj.O000000o("ack"), bxm.O00000Oo);
                jSONObject.put(bxj.O000000o("tvKey"), bxm.f13380O000000o);
                jSONObject.put(bxj.O000000o("type"), Integer.parseInt(bxm.O00000o0));
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            jSONObject = null;
            bxb.O00000Oo("Error: build header JSONObject error!");
            return jSONObject;
        }
        return jSONObject;
    }
}
