package _m_j;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hdb {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18806O000000o;
    public final String O00000Oo;
    public String O00000o;
    public final String[] O00000o0;
    public hdc O00000oO;
    public List<Pair<String, Object>> O00000oo;
    public List<Pair<String, Object>> O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public int O0000OoO;
    public String O0000Ooo;

    public hdb(JSONObject jSONObject, JSONArray jSONArray) {
        JSONObject optJSONObject = jSONObject.optJSONObject("button_name");
        if (optJSONObject != null) {
            this.f18806O000000o = gpl.O000000o(optJSONObject);
        }
        this.O00000Oo = hcg.O000000o(jSONObject.optString("prop_value"));
        JSONArray optJSONArray = jSONObject.optJSONArray("prop_values");
        if (optJSONArray != null) {
            String[] strArr = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                strArr[i] = hcg.O000000o(optJSONArray.optString(i));
            }
            Arrays.sort(strArr);
            this.O00000o0 = strArr;
        } else {
            this.O00000o0 = null;
        }
        this.O00000o = jSONObject.optString("method");
        this.O00000oO = new hdc(jSONObject.optJSONArray("param"), jSONArray);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("enable_status");
        if (optJSONArray2 != null) {
            this.O00000oo = new ArrayList();
            O000000o(optJSONArray2, this.O00000oo);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("disable_status");
        if (optJSONArray3 != null) {
            this.O0000O0o = new ArrayList();
            O000000o(optJSONArray3, this.O0000O0o);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("button_image");
        if (optJSONObject2 != null) {
            this.O0000OOo = optJSONObject2.optString("normal");
            this.O0000Oo0 = optJSONObject2.optString("selected");
            this.O0000Oo = optJSONObject2.optString("unable");
        }
        this.O0000Ooo = jSONObject.optString("action");
    }

    private static void O000000o(JSONArray jSONArray, List<Pair<String, Object>> list) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            list.add(new Pair(optJSONObject.optString("key"), optJSONObject.opt("value")));
        }
    }

    public final Object O000000o(List<hdb> list) {
        hdc hdc = this.O00000oO;
        if (hdc != null && hdc.O00000Oo != null && this.O00000oO.O00000Oo.size() == 1) {
            return this.O00000oO.O00000Oo.get(0);
        }
        for (hdb next : list) {
            if (!next.O000000o(String.valueOf(this.O00000Oo))) {
                return next.O00000Oo;
            }
        }
        return null;
    }

    public static hdb O000000o(List<hdb> list, Object obj) {
        hdb hdb = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        String valueOf = String.valueOf(obj);
        Iterator<hdb> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            hdb next = it.next();
            if (next.O000000o(valueOf)) {
                hdb = next;
                break;
            }
        }
        if (hdb != null) {
            return hdb;
        }
        if (list.size() > 1) {
            return list.get(1);
        }
        return list.size() == 1 ? list.get(0) : hdb;
    }

    public final boolean O000000o(String str) {
        String O000000o2 = hcg.O000000o(str);
        String str2 = this.O00000Oo;
        if (str2 != null && str2.equals(O000000o2)) {
            return true;
        }
        String[] strArr = this.O00000o0;
        return strArr != null && Arrays.binarySearch(strArr, O000000o2) >= 0;
    }
}
