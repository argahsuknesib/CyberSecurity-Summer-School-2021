package _m_j;

import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hee {
    private static final hee O0000o0 = new hee();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18836O000000o;
    public Map<String, hee> O00000Oo;
    public ArrayMap<String, Integer> O00000o = new ArrayMap<>();
    public String O00000o0;
    public String O00000oO;
    public O000000o O00000oo = O000000o.O00000Oo;
    public List<Integer> O0000O0o;
    public List<O00000Oo> O0000OOo;
    public hdc O0000Oo;
    public List<Object> O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo;
    public TreeMap<String, String> O0000o00;

    public static hee O000000o(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return O0000o0;
        }
        return new hee(jSONObject);
    }

    private hee() {
    }

    private hee(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONArray("subProps") != null) {
                this.f18836O000000o = jSONObject.optString("prop_key");
                this.O00000Oo = new ArrayMap();
                JSONArray optJSONArray = jSONObject.optJSONArray("subProps");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hee O00000Oo2 = O00000Oo(optJSONArray.optJSONObject(i));
                    this.O00000Oo.put(O00000Oo2.f18836O000000o, O00000Oo2);
                }
            } else {
                hee O00000Oo3 = O00000Oo(jSONObject);
                this.f18836O000000o = O00000Oo3.f18836O000000o;
                this.O00000o0 = O00000Oo3.O00000o0;
                this.O00000oO = O00000Oo3.O00000oO;
                this.O00000oo = O00000Oo3.O00000oo;
                this.O0000OOo = O00000Oo3.O0000OOo;
                this.O0000Oo0 = O00000Oo3.O0000Oo0;
                this.O0000Oo = O00000Oo3.O0000Oo;
                this.O0000OoO = O00000Oo3.O0000OoO;
                this.O0000Ooo = O00000Oo3.O0000Ooo;
                this.O0000o00 = O00000Oo3.O0000o00;
                this.O00000o = O00000Oo3.O00000o;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("supportType");
            if (optJSONArray2 != null) {
                this.O0000O0o = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.O0000O0o.add(Integer.valueOf(optJSONArray2.optInt(i2)));
                }
            }
        }
    }

    private static hee O00000Oo(JSONObject jSONObject) {
        hee hee = new hee();
        hee.f18836O000000o = jSONObject.optString("prop_key");
        JSONObject optJSONObject = jSONObject.optJSONObject("prop_name");
        if (optJSONObject != null) {
            hee.O00000o0 = gpl.O000000o(optJSONObject);
        }
        hee.O00000oO = jSONObject.optString("format");
        int i = 0;
        hee.O00000oo = new O000000o(jSONObject.optDouble("ratio", 1.0d), jSONObject.optString("prop_unit"), (byte) 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("prop_extra");
        if (optJSONArray != null) {
            hee.O0000OOo = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hee.O0000OOo.add(new O00000Oo(optJSONArray.optJSONObject(i2)));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("switchStatus");
        if (optJSONArray2 != null) {
            hee.O0000Oo0 = new ArrayList();
            while (i < optJSONArray2.length()) {
                try {
                    hee.O0000Oo0.add(optJSONArray2.opt(i));
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        hee.O0000Oo = new hdc(null, jSONObject.optJSONArray("prop_value_type"));
        hee.O0000OoO = gpl.O000000o(jSONObject.optJSONObject("prop_status_name"));
        hee.O0000Ooo = jSONObject.optString("show_type");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("event_list");
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hee.O00000o.put(next, Integer.valueOf(optJSONObject2.optInt(next)));
            }
        }
        return hee;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Object f18837O000000o;
        public String O00000Oo;
        public double O00000o;
        public double O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;

        public O00000Oo(JSONObject jSONObject) {
            this.f18837O000000o = jSONObject.opt("value");
            this.O00000oO = jSONObject.optString("text_color");
            this.O00000oo = jSONObject.optString("foreground_color");
            this.O0000O0o = jSONObject.optString("image");
            JSONObject optJSONObject = jSONObject.optJSONObject("param_range");
            if (optJSONObject != null) {
                this.O00000o0 = optJSONObject.optDouble("min");
                this.O00000o = optJSONObject.optDouble("max");
            }
            this.O00000Oo = gpl.O000000o(jSONObject.optJSONObject("desc"));
        }
    }

    public static class O000000o extends hcu {
        public static final O000000o O00000Oo = new O000000o(1.0d, "");
        public String O00000o0;

        /* synthetic */ O000000o(double d, String str, byte b) {
            this(d, str);
        }

        private O000000o(double d, String str) {
            super(d);
            this.O00000o0 = str;
        }
    }
}
