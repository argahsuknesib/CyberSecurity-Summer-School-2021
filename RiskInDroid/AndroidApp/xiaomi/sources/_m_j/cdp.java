package _m_j;

import org.json.JSONObject;

public final class cdp extends cdm {
    public String O00000oO;
    public long O00000oo;
    public String O0000O0o;
    private String O0000OOo;
    private long O0000Oo0;

    public final String O00000o() {
        return "mistat_start_up";
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

    public final String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.O0000OOo);
            jSONObject.put("resolution", this.O00000oO);
            jSONObject.put("startTime", this.O00000oo);
            jSONObject.put("network", this.O0000O0o);
            jSONObject.put("timestamp", this.O0000Oo0);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
