package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class fui {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17181O000000o;
    public String O00000Oo;
    public ArrayList<O000000o> O00000o0;

    public static fui O000000o(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("component_id");
        String optString = jSONObject.optString("key");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (TextUtils.isEmpty(optString) || optJSONObject == null) {
            return null;
        }
        fui fui = new fui();
        fui.f17181O000000o = optInt;
        fui.O00000Oo = optString;
        fui.O00000o0 = new ArrayList<>();
        Iterator<String> keys = optJSONObject.keys();
        while (keys != null && keys.hasNext()) {
            String next = keys.next();
            fui.O00000o0.add(new O000000o(next, optJSONObject.optString(next)));
        }
        return fui;
    }

    public static JSONObject O000000o(fui fui) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (fui == null) {
            return jSONObject;
        }
        jSONObject.put("component_id", fui.f17181O000000o);
        jSONObject.put("key", fui.O00000Oo);
        JSONObject jSONObject2 = new JSONObject();
        for (int i = 0; i < fui.O00000o0.size(); i++) {
            jSONObject2.put(fui.O00000o0.get(i).f17182O000000o, fui.O00000o0.get(i).O00000Oo);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17182O000000o;
        public String O00000Oo;

        public O000000o(String str, String str2) {
            this.f17182O000000o = str;
            this.O00000Oo = str2;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17183O000000o;
        public int O00000Oo;
        public String O00000o0;

        public static O00000Oo O000000o(JSONObject jSONObject) {
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.f17183O000000o = jSONObject.optString("component_id");
            try {
                o00000Oo.O00000Oo = Integer.valueOf(jSONObject.optString("key")).intValue();
                o00000Oo.O00000o0 = jSONObject.optString("data");
                if (TextUtils.isEmpty(o00000Oo.O00000o0)) {
                    return null;
                }
                return o00000Oo;
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
