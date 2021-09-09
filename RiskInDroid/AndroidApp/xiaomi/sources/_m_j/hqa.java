package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hqa {

    /* renamed from: O000000o  reason: collision with root package name */
    public JSONObject f515O000000o = new JSONObject();
    public JSONObject O00000Oo = new JSONObject();
    public List<O00000Oo> O00000o0 = new ArrayList();

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f517O000000o;
        public String O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public List<O000000o> O0000Oo = new ArrayList();
        public List<O000000o> O0000Oo0 = new ArrayList();
    }

    private static boolean O000000o(int i) {
        return i == 0 || i == 1;
    }

    public static hqa O000000o(JSONObject jSONObject) {
        hqa hqa = new hqa();
        JSONArray optJSONArray = jSONObject.optJSONArray("userRecom");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            return hqa;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.O00000oo = optJSONObject.optInt("ua", -1);
            if (O000000o(o00000Oo.O00000oo)) {
                o00000Oo.f517O000000o = optJSONObject.optString("sr_id");
                o00000Oo.O00000Oo = optJSONObject.optString("intro");
                o00000Oo.O00000o0 = optJSONObject.optInt("st_id");
                o00000Oo.O00000o = optJSONObject.optInt("enable");
                o00000Oo.O00000oO = optJSONObject.optInt("enable_push");
                o00000Oo.O0000O0o = optJSONObject.optString("jpg", "");
                o00000Oo.O0000OOo = optJSONObject.optString("gif");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("launch");
                if (optJSONArray2 != null) {
                    o00000Oo.O0000Oo0.addAll(O000000o.O000000o(optJSONArray2));
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("action");
                if (optJSONArray3 != null) {
                    o00000Oo.O0000Oo.addAll(O000000o.O000000o(optJSONArray3));
                }
                arrayList.add(o00000Oo);
            }
        }
        hqa.O00000o0.addAll(arrayList);
        hqa.O00000Oo = jSONObject.optJSONObject("sc_ids");
        hqa.f515O000000o = jSONObject.optJSONObject("sa_ids");
        return hqa;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public JSONObject f516O000000o = new JSONObject();
        public String O00000Oo;
        public String O00000o;
        public JSONArray O00000o0 = new JSONArray();
        public String O00000oO;
        public int O00000oo;

        public static List<O000000o> O000000o(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (!(jSONArray == null || jSONArray.length() == 0)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    O000000o o000000o = new O000000o();
                    o000000o.O00000Oo = optJSONObject.optString("name", "");
                    o000000o.f516O000000o = optJSONObject.optJSONObject("model_list");
                    o000000o.O00000o0 = optJSONObject.optJSONArray("gid");
                    o000000o.O00000oo = optJSONObject.optInt("type", 0);
                    o000000o.O00000o = optJSONObject.optString("src", "");
                    o000000o.O00000oO = optJSONObject.optString("key", "");
                    arrayList.add(o000000o);
                }
            }
            return arrayList;
        }
    }
}
