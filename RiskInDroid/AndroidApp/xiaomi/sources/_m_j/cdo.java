package _m_j;

import org.json.JSONObject;

public final class cdo extends cdm {
    private long O00000oO;
    private long O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private long O0000Oo0;

    public final String O00000o() {
        return "mistat_session";
    }

    public final boolean O00000o0() {
        return true;
    }

    public cdo() {
    }

    public cdo(long j, long j2, String str) {
        this.O00000oO = j;
        this.O00000oo = j2;
        this.O0000O0o = str;
    }

    public final String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.O00000oO);
            jSONObject.put("endTime", this.O00000oo);
            jSONObject.put("sessionId", this.O0000OOo);
            jSONObject.put("netWork", this.O0000O0o);
            jSONObject.put("timestamp", this.O0000Oo0);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O000000o() {
        return this.O0000OOo;
    }

    public final void O000000o(String str) {
        this.O0000OOo = str;
    }

    public final long O00000Oo() {
        return this.O0000Oo0;
    }

    public final void O000000o(long j) {
        this.O0000Oo0 = j;
    }
}
