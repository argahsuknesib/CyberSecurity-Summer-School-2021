package _m_j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bxh {

    /* renamed from: O000000o  reason: collision with root package name */
    private JSONObject f13377O000000o;

    public bxh(String str) throws JSONException {
        this.f13377O000000o = new JSONObject(str);
    }

    private bxh(JSONObject jSONObject) {
        this.f13377O000000o = jSONObject;
    }

    public final String O000000o(String str) {
        boolean equals = "action".equals(str);
        String optString = this.f13377O000000o.optString(bxj.O000000o(str));
        return equals ? bxj.O00000o(optString) : optString;
    }

    public final bxh O00000Oo(String str) {
        return new bxh(this.f13377O000000o.optJSONObject(bxj.O000000o(str)));
    }

    public final Map<String, String> O00000o0(String str) {
        JSONObject optJSONObject = this.f13377O000000o.optJSONObject(bxj.O000000o(str));
        if (optJSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(bxj.O00000Oo(next), optJSONObject.optString(next));
        }
        return hashMap;
    }
}
