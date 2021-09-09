package _m_j;

import org.json.JSONObject;

public final class cds extends cdm {
    public String O00000oO;
    private String O00000oo;
    private long O0000O0o;
    private long O0000OOo = System.currentTimeMillis();
    private long O0000Oo;
    private long O0000Oo0 = ccw.f13642O000000o;
    private String O0000OoO;
    private String O0000Ooo;

    public final String O00000o() {
        return "mistat_view_show";
    }

    public cds() {
    }

    public cds(String str, String str2, String str3) {
        this.O00000oO = str;
        this.O0000OoO = str3;
        this.O0000Ooo = str2;
    }

    public final String O000000o() {
        return this.O00000oo;
    }

    public final void O000000o(String str) {
        this.O00000oo = str;
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
            jSONObject.put("sessionId", this.O00000oo);
            jSONObject.put("viewLeaveTime", this.O00000oo);
            jSONObject.put("viewLeaveTime", this.O0000O0o);
            jSONObject.put("viewShowTime", this.O0000OOo);
            jSONObject.put("pageShowTime", this.O0000Oo0);
            jSONObject.put("timestamp", this.O0000Oo);
            jSONObject.put("viewId", this.O00000oO);
            jSONObject.put("pageId", this.O0000Ooo);
            jSONObject.put("label", this.O0000OoO);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
