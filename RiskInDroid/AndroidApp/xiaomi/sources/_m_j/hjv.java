package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hjv implements hjq {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f19004O000000o = "";
    public String O00000Oo = "";
    public long O00000o = -1;
    public String O00000o0 = "";
    public long O00000oO = -1;
    public String O00000oo = "";
    public String O0000O0o = "";
    private int O0000OOo = -1;
    private int O0000Oo = -1;
    private int O0000Oo0 = -1;

    public static List<hjv> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("ok".equalsIgnoreCase(jSONObject.getString("result"))) {
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("values");
                JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hjv hjv = new hjv();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    hjv.O00000oo = jSONObject2.optString("shortKey");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("banner");
                    hjv.f19004O000000o = jSONObject3.getString("imgUrl");
                    hjv.O00000o0 = jSONObject3.getString("h5Url");
                    hjv.O0000OOo = jSONObject3.optInt("allUid");
                    hjv.O00000Oo = jSONObject3.optString("name");
                    hjv.O00000o = jSONObject3.getLong("beginTime");
                    hjv.O00000oO = jSONObject3.getLong("endTime");
                    hjv.O0000Oo0 = jSONObject3.getInt("position");
                    hjv.O0000Oo = jSONObject3.getInt("status");
                    if (optJSONObject != null) {
                        hjv.O0000O0o = optJSONObject.optString("expId", "");
                    }
                    arrayList.add(hjv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            arrayList.clear();
        }
        return arrayList;
    }

    public final boolean O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis < this.O00000o || currentTimeMillis > this.O00000oO;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hjv hjv = (hjv) obj;
            if (this.O00000o != hjv.O00000o || this.O00000oO != hjv.O00000oO || this.O0000Oo0 != hjv.O0000Oo0) {
                return false;
            }
            String str = this.O00000o0;
            if (str == null ? hjv.O00000o0 != null : !str.equals(hjv.O00000o0)) {
                return false;
            }
            String str2 = this.O00000Oo;
            if (str2 == null ? hjv.O00000Oo != null : !str2.equals(hjv.O00000Oo)) {
                return false;
            }
            String str3 = this.f19004O000000o;
            if (str3 != null) {
                return str3.equals(hjv.f19004O000000o);
            }
            if (hjv.f19004O000000o == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.O00000o0;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f19004O000000o;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O00000Oo;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j = this.O00000o;
        long j2 = this.O00000oO;
        int i2 = (((((((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.O0000Oo0) * 31;
        String str4 = this.f19004O000000o;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 + i;
    }

    public final String O00000Oo() {
        return this.f19004O000000o;
    }
}
