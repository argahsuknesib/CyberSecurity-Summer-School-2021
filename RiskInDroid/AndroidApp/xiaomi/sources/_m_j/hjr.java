package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hjr implements hjq {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f19001O000000o = "-1";
    public String O00000Oo = "";
    public String O00000o = "";
    public String O00000o0 = "";
    public int O00000oO = -1;
    public long O00000oo = -1;
    public long O0000O0o = -1;
    @Deprecated
    public int O0000OOo = 1;
    public String O0000Oo = "";
    @Deprecated
    public String[] O0000Oo0 = new String[0];
    public String O0000OoO = "";
    public String O0000Ooo = "";
    public int O0000o = -1;
    public String O0000o0 = "";
    public int O0000o00 = 2;
    public String O0000o0O = "";
    public String O0000o0o = "";

    public static List<hjr> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("ok".equalsIgnoreCase(jSONObject.getString("result"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("list");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hjr hjr = new hjr();
                    arrayList.add(hjr);
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    hjr.O00000o0 = jSONObject2.optString("name");
                    hjr.O00000Oo = jSONObject2.getString("imgUrl");
                    hjr.O00000o = jSONObject2.getString("h5Url");
                    hjr.O00000oO = jSONObject2.getInt("jump");
                    hjr.O00000oo = jSONObject2.getLong("beginTime");
                    hjr.O0000O0o = jSONObject2.getLong("endTime");
                    hjr.O0000o00 = jSONObject2.optInt("showTitleType", 2);
                    hjr.O0000Oo = jSONObject2.optString("shareTitle", "");
                    hjr.O0000OoO = jSONObject2.optString("shareDesc", "");
                    hjr.O0000Ooo = jSONObject2.optString("shareImgUrl", "");
                    hjr.O0000o0 = jSONObject2.optString("id", "");
                    hjr.O0000o0O = jSONObject2.optString("shortKey", "");
                    if (optJSONObject != null) {
                        hjr.O0000o0o = optJSONObject.optString("expId", "");
                    }
                    hjr.f19001O000000o = jSONObject2.optString("type");
                    hjr.O0000o = jSONObject2.getInt("redPoint");
                }
            }
        } catch (Exception unused) {
            gsy.O00000Oo("Operation", "parse error with :".concat(String.valueOf(str)));
            arrayList.clear();
        }
        return arrayList;
    }

    public final boolean O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis < this.O00000oo || currentTimeMillis > this.O0000O0o;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hjr hjr = (hjr) obj;
        if (this.O00000oO == hjr.O00000oO && this.O00000oo == hjr.O00000oo && this.O0000O0o == hjr.O0000O0o && this.O0000o00 == hjr.O0000o00 && this.O00000o0.equals(hjr.O00000o0) && this.O00000o.equals(hjr.O00000o) && this.O0000Oo.equals(hjr.O0000Oo) && this.O0000OoO.equals(hjr.O0000OoO)) {
            return this.O0000Ooo.equals(hjr.O0000Ooo);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.O00000oo;
        long j2 = this.O0000O0o;
        return ((((((((((((((((this.O00000o0.hashCode() + 0) * 31) + this.O00000o.hashCode()) * 31) + this.O00000oO) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.O0000Oo.hashCode()) * 31) + this.O0000OoO.hashCode()) * 31) + this.O0000Ooo.hashCode()) * 31) + this.O0000o00;
    }

    public final String O00000Oo() {
        return this.O00000Oo;
    }
}
