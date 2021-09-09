package _m_j;

import org.json.JSONObject;

public final class cdn extends cdm {
    public long O00000oO;
    public long O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    private long O0000Oo;
    private String O0000Oo0;

    public final String O00000o() {
        return "mistat_page_tv";
    }

    public cdn() {
    }

    public cdn(String str, long j, long j2, String str2, String str3) {
        this.O0000Oo0 = str;
        this.O0000Oo = j;
        this.O00000oO = j2;
        this.O00000oo = 0;
        this.O0000O0o = str2;
        this.O0000OOo = str3;
    }

    public final String O000000o() {
        return this.O0000Oo0;
    }

    public final void O000000o(String str) {
        this.O0000Oo0 = str;
    }

    public final long O00000Oo() {
        return this.O0000Oo;
    }

    public final void O000000o(long j) {
        this.O0000Oo = j;
    }

    public final String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.O0000Oo0);
            jSONObject.put("timestamp", this.O0000Oo);
            jSONObject.put("startTime", this.O00000oO);
            jSONObject.put("endTime", this.O00000oo);
            jSONObject.put("pageId", this.O0000O0o);
            jSONObject.put("pageRef", this.O0000OOo);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
