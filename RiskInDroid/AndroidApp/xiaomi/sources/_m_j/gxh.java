package _m_j;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class gxh implements Comparable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18464O000000o;
    public int O00000Oo;
    public long O00000o;
    public int O00000o0;
    public long O00000oO;
    public String O00000oo;
    public long O0000O0o;

    public gxh() {
        this.f18464O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = null;
        this.O0000O0o = 0;
    }

    public gxh(Date date) {
        this.f18464O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        Date O00000Oo2 = goz.O00000Oo(date);
        this.O00000o = O00000Oo2.getTime() / 1000;
        this.O00000oO = O00000Oo2.getTime() / 1000;
        this.O00000oo = gxq.O000000o(O00000Oo2, "yyyy-MM-dd");
        this.O0000O0o = O00000Oo2.getTime();
    }

    public static gxh O000000o(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString("date", null)) == null) {
            return null;
        }
        gxh gxh = new gxh();
        gxh.f18464O000000o = jSONObject.optInt("shallowSleepTime");
        gxh.O00000Oo = jSONObject.optInt("deepSleepTime");
        gxh.O00000o0 = jSONObject.optInt("wakeTime");
        gxh.O00000o = jSONObject.optLong("sleepStartTime");
        gxh.O00000oO = jSONObject.optLong("sleepEndTime");
        gxh.O00000oo = optString;
        gxh.O0000O0o = gxq.O000000o(optString, "yyyy-MM-dd");
        return gxh;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shallowSleepTime", this.f18464O000000o);
            jSONObject.put("deepSleepTime", this.O00000Oo);
            jSONObject.put("wakeTime", this.O00000o0);
            jSONObject.put("sleepStartTime", this.O00000o);
            jSONObject.put("sleepEndTime", this.O00000oO);
            jSONObject.put("date", this.O00000oo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gxh)) {
            return false;
        }
        return this.O00000oo.equalsIgnoreCase(((gxh) obj).O00000oo);
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof gxh)) {
            return -1;
        }
        gxh gxh = (gxh) obj;
        if (this.O00000oo.equalsIgnoreCase(gxh.O00000oo)) {
            return 0;
        }
        long j = this.O0000O0o;
        long j2 = gxh.O0000O0o;
        if (j < j2) {
            return 1;
        }
        if (j > j2) {
            return -1;
        }
        return 0;
    }
}
