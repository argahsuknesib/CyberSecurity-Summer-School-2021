package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hgt {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18921O000000o = new ArrayList();
    public int O00000Oo;
    public int O00000o0;

    public static hgt O000000o(JSONObject jSONObject) {
        hgt hgt = new hgt();
        if (jSONObject == null) {
            return null;
        }
        hgt.O00000Oo = jSONObject.optInt("oldest_time");
        hgt.O00000o0 = jSONObject.optInt("latest_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("description_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                List<O000000o> O000000o2 = O000000o.O000000o(optJSONArray.optJSONObject(i));
                if (O000000o2 != null && O000000o2.size() > 0) {
                    hgt.f18921O000000o.addAll(O000000o2);
                }
            }
        }
        return hgt;
    }

    private static String O000000o(O000000o o000000o) {
        return o000000o.O00000Oo + o000000o.O00000o;
    }

    public final void O000000o() {
        List<O000000o> list = this.f18921O000000o;
        if (list != null && list.size() > 0) {
            O00000Oo(this.f18921O000000o);
            Collections.sort(this.f18921O000000o);
            O000000o(this.f18921O000000o);
        }
    }

    private static List<O000000o> O000000o(List<O000000o> list) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).O00000oO != null && list.get(size).O00000oO.O00000o > 0 && currentTimeMillis - ((long) list.get(size).O00000o0) > list.get(size).O00000oO.O00000o) {
                list.remove(size);
            }
        }
        return list;
    }

    private List<O000000o> O00000Oo(List<O000000o> list) {
        HashMap hashMap = new HashMap();
        this.O00000Oo = list.get(0).O00000o0;
        this.O00000o0 = this.O00000Oo;
        for (int size = list.size() - 1; size >= 0; size--) {
            String O000000o2 = O000000o(list.get(size));
            O000000o o000000o = list.get(size);
            if (o000000o.O00000o0 > this.O00000o0) {
                this.O00000o0 = o000000o.O00000o0;
            }
            if (o000000o.O00000o0 < this.O00000Oo) {
                this.O00000Oo = o000000o.O00000o0;
            }
            if (hashMap.containsKey(O000000o2)) {
                if (TextUtils.isEmpty(o000000o.f18922O000000o)) {
                    O000000o o000000o2 = (O000000o) hashMap.remove(O000000o2);
                    if (o000000o2 != null) {
                        list.remove(o000000o2);
                    }
                    list.remove(size);
                } else if (list.get(size).O00000o0 > ((O000000o) hashMap.get(O000000o2)).O00000o0) {
                    O000000o o000000o3 = (O000000o) hashMap.remove(O000000o2);
                    if (o000000o3 != null) {
                        list.remove(o000000o3);
                    }
                    hashMap.put(O000000o2, o000000o);
                } else {
                    list.remove(size);
                }
            } else if (TextUtils.isEmpty(o000000o.f18922O000000o)) {
                list.remove(size);
            } else {
                hashMap.put(O000000o2, o000000o);
            }
        }
        return list;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldest_time", this.O00000Oo);
            jSONObject.put("latest_time", this.O00000o0);
            JSONArray jSONArray = new JSONArray();
            if (this.f18921O000000o != null) {
                for (int i = 0; i < this.f18921O000000o.size(); i++) {
                    jSONArray.put(this.f18921O000000o.get(i).O000000o());
                }
            }
            jSONObject.put("description_list", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18922O000000o;
        public String O00000Oo;
        public String O00000o;
        public int O00000o0;
        public O00000Oo O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;

        public final /* synthetic */ int compareTo(Object obj) {
            O000000o o000000o = (O000000o) obj;
            int i = o000000o.O00000o0;
            int i2 = this.O00000o0;
            if (i != i2) {
                return i - i2;
            }
            if (!TextUtils.equals(o000000o.O00000Oo, this.O00000Oo)) {
                String str = o000000o.O00000Oo;
                if (str != null) {
                    return str.compareTo(this.O00000Oo);
                }
                String str2 = this.O00000Oo;
                if (str2 != null) {
                    return str2.compareTo(str);
                }
            }
            if (TextUtils.equals(o000000o.O00000o, this.O00000o)) {
                return 0;
            }
            String str3 = o000000o.O00000o;
            if (str3 != null) {
                return str3.compareTo(this.O00000o);
            }
            String str4 = this.O00000o;
            if (str4 != null) {
                return str4.compareTo(str3);
            }
            return 0;
        }

        public static List<O000000o> O000000o(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("did");
            String optString2 = jSONObject.optString("room_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("details");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    O000000o o000000o = new O000000o();
                    o000000o.O00000Oo = optString;
                    o000000o.f18922O000000o = optJSONArray.optJSONObject(i).optString("description");
                    if (!TextUtils.isEmpty(o000000o.f18922O000000o)) {
                        o000000o.f18922O000000o = o000000o.f18922O000000o.trim();
                    }
                    o000000o.O00000o0 = optJSONArray.optJSONObject(i).optInt("timestamp");
                    o000000o.O00000o = optJSONArray.optJSONObject(i).optString("prop");
                    o000000o.O00000oO = O00000Oo.O000000o(optJSONArray.optJSONObject(i).optString("extra"));
                    if (TextUtils.isEmpty(optJSONArray.optJSONObject(i).optString("value"))) {
                        o000000o.O00000oo = "";
                    } else {
                        o000000o.O00000oo = optJSONArray.optJSONObject(i).optString("value");
                    }
                    o000000o.O0000O0o = optJSONArray.optJSONObject(i).optString("attr_type");
                    o000000o.O0000OOo = optString2;
                    arrayList.add(o000000o);
                }
            }
            return arrayList;
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.O00000Oo);
                jSONObject.put("room_id", this.O0000OOo);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("description", this.f18922O000000o);
                jSONObject2.put("timestamp", this.O00000o0);
                jSONObject2.put("prop", this.O00000o);
                jSONObject2.put("extra", this.O00000oO.O000000o());
                jSONObject2.put("value", this.O00000oo);
                jSONObject2.put("attr_type", this.O0000O0o);
                jSONArray.put(jSONObject2);
                jSONObject.put("details", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18923O000000o;
        public String O00000Oo;
        public long O00000o = 0;
        public String O00000o0;

        public static O00000Oo O000000o(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                O00000Oo o00000Oo = new O00000Oo();
                o00000Oo.f18923O000000o = jSONObject.optString("home_icon");
                o00000Oo.O00000Oo = jSONObject.optString("item_icon");
                o00000Oo.O00000o0 = jSONObject.optString("item_colour");
                o00000Oo.O00000o = jSONObject.optLong("expireSeconds");
                return o00000Oo;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("home_icon", this.f18923O000000o);
                jSONObject.put("item_icon", this.O00000Oo);
                jSONObject.put("item_colour", this.O00000o0);
                jSONObject.put("expireSeconds", this.O00000o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
