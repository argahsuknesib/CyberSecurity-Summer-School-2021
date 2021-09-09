package _m_j;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class gxi implements Comparable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18465O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public long O0000Oo0;

    public static gxi O000000o(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString("date", null)) == null) {
            return null;
        }
        gxi gxi = new gxi();
        gxi.f18465O000000o = jSONObject.optInt("walkTime", 0);
        gxi.O00000Oo = jSONObject.optInt("walkDistance", 0);
        gxi.O00000o0 = jSONObject.optInt("runTime", 0);
        gxi.O00000o = jSONObject.optInt("runDistance", 0);
        gxi.O00000oO = jSONObject.optInt("runCalorie", 0);
        gxi.O00000oo = jSONObject.optInt("calorie", 0);
        gxi.O0000O0o = jSONObject.optInt("step", 0);
        gxi.O0000OOo = optString;
        gxi.O0000Oo0 = gxq.O000000o(optString, "yyyy-MM-dd");
        return gxi;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("walkTime", this.f18465O000000o);
            jSONObject.put("walkDistance", this.O00000Oo);
            jSONObject.put("runTime", this.O00000o0);
            jSONObject.put("runDistance", this.O00000o);
            jSONObject.put("runCalorie", this.O00000oO);
            jSONObject.put("calorie", this.O00000oo);
            jSONObject.put("step", this.O0000O0o);
            jSONObject.put("date", this.O0000OOo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gxi)) {
            return false;
        }
        return this.O0000OOo.equalsIgnoreCase(((gxi) obj).O0000OOo);
    }

    public gxi() {
        this.f18465O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = 0;
        this.O0000OOo = null;
        this.O0000Oo0 = 0;
    }

    public gxi(Date date) {
        this.f18465O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = 0;
        Date O00000Oo2 = goz.O00000Oo(date);
        this.O0000OOo = gxq.O000000o(O00000Oo2, "yyyy-MM-dd");
        this.O0000Oo0 = O00000Oo2.getTime();
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof gxi)) {
            return -1;
        }
        gxi gxi = (gxi) obj;
        if (this.O0000OOo.equalsIgnoreCase(gxi.O0000OOo)) {
            return 0;
        }
        long j = this.O0000Oo0;
        long j2 = gxi.O0000Oo0;
        if (j < j2) {
            return 1;
        }
        if (j > j2) {
            return -1;
        }
        return 0;
    }
}
