package _m_j;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class blr {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, Object> f13070O000000o;
    public Map<String, O000000o> O00000Oo;
    public Map<String, O00000o> O00000o;
    public Map<String, O00000Oo> O00000o0;
    public Set<String> O00000oO;
    List<Object> O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public boolean O0000Oo = true;
    String O0000Oo0;
    boolean O0000OoO = true;
    public boolean O0000Ooo;
    public int O0000o;
    public int O0000o0 = 10;
    public int O0000o00 = 50;
    public boolean O0000o0O = true;
    boolean O0000o0o;
    public List<O00000o0> O0000oO;
    public int O0000oO0;
    public boolean O0000oOO;
    public int O0000oOo = 0;
    public int O0000oo = -1;
    public int O0000oo0 = 2;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13071O000000o;
        public String O00000Oo;
        String O00000o0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13072O000000o;
        public int O00000Oo;
        public String O00000o0;
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13073O000000o;
        public String O00000Oo;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f13074O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
    }

    private static Set<String> O000000o(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (next.startsWith("sensitive.") && jSONObject.getBoolean(next)) {
                    hashSet.add(next.split("\\.")[1]);
                }
            } catch (Exception e) {
                bmz.O00000o0("CollectConfiguration", "parse sensitives failed", new Object[0]);
                bmz.O000000o(e);
            }
        }
        return hashSet;
    }

    private static Set<String> O00000oO(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (jSONObject.getBoolean(next)) {
                    hashSet.add(next);
                }
            } catch (Exception e) {
                bmz.O00000o0("CollectConfiguration", "parse sensitives failed", new Object[0]);
                bmz.O000000o(e);
            }
        }
        return hashSet;
    }

    private static Map<String, O000000o> O000000o(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                O000000o o000000o = new O000000o();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o000000o.f13071O000000o = next;
                o000000o.O00000Oo = jSONObject2.getString("pn");
                o000000o.O00000o0 = jSONObject2.getString("uri");
                hashMap.put(o000000o.f13071O000000o, o000000o);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static Map<String, O00000Oo> O00000Oo(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                O00000Oo o00000Oo = new O00000Oo();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o00000Oo.f13072O000000o = next;
                if (TextUtils.equals("sdcard", jSONObject2.getString("type"))) {
                    o00000Oo.O00000Oo = 0;
                } else if (TextUtils.equals("absolute", jSONObject2.getString("type"))) {
                    o00000Oo.O00000Oo = 1;
                }
                o00000Oo.O00000o0 = jSONObject2.getString("dir");
                hashMap.put(o00000Oo.f13072O000000o, o00000Oo);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static Map<String, O00000o> O00000o0(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                O00000o o00000o = new O00000o();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o00000o.f13073O000000o = next;
                o00000o.O00000Oo = jSONObject2.getString("pn");
                hashMap.put(o00000o.f13073O000000o, o00000o);
                hashMap.put(o00000o.f13073O000000o, o00000o);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static List<O00000o0> O00000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    O00000o0 o00000o0 = new O00000o0();
                    o00000o0.f13074O000000o = jSONObject.getString("stype");
                    o00000o0.O00000Oo = jSONObject.getInt("enable");
                    o00000o0.O00000o0 = jSONObject.getInt("interval");
                    o00000o0.O00000o = jSONObject.getInt("times");
                    arrayList.add(o00000o0);
                } catch (JSONException unused) {
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(48:1|2|3|4|(1:6)|7|(1:9)|13|14|15|19|20|21|25|26|27|31|32|36|(2:37|38)|39|41|42|43|45|46|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|76|77) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00cd */
    public static blr O000000o(String str) {
        blr blr = new blr();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.has("usrappcnt")) {
                    blr.O0000o00 = jSONObject.getInt("usrappcnt");
                }
                if (jSONObject.has("sysappcnt")) {
                    blr.O0000o0 = jSONObject.getInt("sysappcnt");
                }
            } catch (Exception e) {
                bmz.O000000o(e);
            }
            try {
                blr.O00000Oo = O000000o(jSONObject.getJSONArray("risk_apps"));
            } catch (Exception e2) {
                bmz.O000000o(e2);
            }
            try {
                blr.O00000o0 = O00000Oo(jSONObject.getJSONArray("risk_dirs"));
            } catch (Exception e3) {
                bmz.O000000o(e3);
            }
            try {
                blr.O00000o = O00000o0(jSONObject.getJSONArray("white_apps"));
            } catch (Exception e4) {
                bmz.O000000o(e4);
            }
            try {
                blr.O00000oO = O000000o(jSONObject);
            } catch (Exception e5) {
                bmz.O000000o(e5);
            }
            try {
                blr.O0000Oo = jSONObject.getBoolean("core_atamper");
            } catch (Exception unused) {
            }
            try {
                blr.O0000OoO = jSONObject.getBoolean("all_atamper");
            } catch (Exception unused2) {
            }
            try {
                blr.O0000Ooo = jSONObject.getBoolean("risk_file_switch");
            } catch (Exception unused3) {
            }
            try {
                blr.O0000o0O = jSONObject.getBoolean("upload_checker_switch");
            } catch (Exception unused4) {
            }
            try {
                blr.O0000o0o = jSONObject.getBoolean("hook_switch");
            } catch (Exception unused5) {
            }
            try {
                blr.O0000o = jSONObject.getInt("sensor_times");
                blr.O0000oO0 = jSONObject.getInt("sensor_interval");
                blr.O0000oO = O00000o(jSONObject.getJSONArray("sensor"));
            } catch (Exception unused6) {
            }
            try {
                blr.O0000oOO = jSONObject.optBoolean("ip_cache_switch");
            } catch (Exception unused7) {
            }
            try {
                blr.O0000oOo = jSONObject.getInt("net_max");
            } catch (Exception unused8) {
            }
            try {
                blr.O0000oo0 = jSONObject.getInt("re_max");
            } catch (Exception unused9) {
            }
            blr.O0000oo = jSONObject.getInt("up_max");
            blr.O0000O0o = str;
            blr.O0000OOo = bne.O00000oo(str);
            return blr;
        } catch (Exception e6) {
            throw new IOException(e6);
        }
    }

    private static Map<String, O000000o> O00000Oo(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                O000000o o000000o = new O000000o();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o000000o.f13071O000000o = next;
                o000000o.O00000Oo = jSONObject2.getString("pn");
                o000000o.O00000o0 = jSONObject2.getString("uri");
                hashMap.put(o000000o.f13071O000000o, o000000o);
            } catch (Exception e) {
                bmz.O00000o0("CollectConfiguration", "parse risk app failed", new Object[0]);
                bmz.O000000o(e);
            }
        }
        return hashMap;
    }

    private static Map<String, O00000Oo> O00000o0(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                O00000Oo o00000Oo = new O00000Oo();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o00000Oo.f13072O000000o = next;
                if (TextUtils.equals("sdcard", jSONObject2.getString("type"))) {
                    o00000Oo.O00000Oo = 0;
                } else if (TextUtils.equals("absolute", jSONObject2.getString("type"))) {
                    o00000Oo.O00000Oo = 1;
                }
                o00000Oo.O00000o0 = jSONObject2.getString("dir");
                hashMap.put(o00000Oo.f13072O000000o, o00000Oo);
            } catch (Exception e) {
                bmz.O00000o0("CollectConfiguration", "parse risk dir failed", new Object[0]);
                bmz.O000000o(e);
            }
        }
        return hashMap;
    }

    private static Map<String, O00000o> O00000o(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                O00000o o00000o = new O00000o();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                o00000o.f13073O000000o = next;
                o00000o.O00000Oo = jSONObject2.getString("pn");
                hashMap.put(o00000o.f13073O000000o, o00000o);
            } catch (Exception e) {
                bmz.O00000o0("CollectConfiguration", "parse white app failed", new Object[0]);
                bmz.O000000o(e);
            }
        }
        return hashMap;
    }

    public static blr O00000Oo(String str) {
        blr blr = new blr();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                blr.O00000Oo = O00000Oo(jSONObject.getJSONObject("risk_apps"));
            } catch (Exception e) {
                bmz.O000000o(e);
            }
            try {
                blr.O00000o0 = O00000o0(jSONObject.getJSONObject("risk_dirs"));
            } catch (Exception e2) {
                bmz.O000000o(e2);
            }
            try {
                blr.O00000o = O00000o(jSONObject.getJSONObject("white_apps"));
            } catch (Exception e3) {
                bmz.O000000o(e3);
            }
            try {
                blr.O00000oO = O00000oO(jSONObject.getJSONObject("sensitive"));
            } catch (Exception e4) {
                bmz.O000000o(e4);
            }
            try {
                blr.O0000Oo = jSONObject.getBoolean("core_atamper");
            } catch (Exception e5) {
                bmz.O000000o(e5);
            }
            try {
                blr.O0000OoO = jSONObject.getBoolean("all_atamper");
            } catch (Exception e6) {
                bmz.O000000o(e6);
            }
            try {
                blr.O0000Ooo = jSONObject.getBoolean("risk_file_switch");
            } catch (Exception e7) {
                bmz.O000000o(e7);
            }
            try {
                blr.O0000o0O = jSONObject.getBoolean("upload_checker_switch");
            } catch (Exception e8) {
                bmz.O000000o(e8);
            }
            blr.O0000O0o = str;
            blr.O0000OOo = bne.O00000oo(str);
            return blr;
        } catch (Exception e9) {
            throw new IOException(e9);
        }
    }
}
