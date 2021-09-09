package _m_j;

import org.json.JSONObject;

public final class cdr extends cdm {
    private String O00000oO;
    private long O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo0;

    public final String O00000o() {
        return "mistat_view_click";
    }

    public cdr() {
    }

    public cdr(String str, String str2, String str3) {
        this.O0000O0o = str;
        this.O0000OOo = str3;
        this.O0000Oo0 = str2;
    }

    public final String O000000o() {
        return this.O00000oO;
    }

    public final void O000000o(String str) {
        this.O00000oO = str;
    }

    public final long O00000Oo() {
        return this.O00000oo;
    }

    public final void O000000o(long j) {
        this.O00000oo = j;
    }

    public final String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.O00000oO);
            jSONObject.put("timestamp", this.O00000oo);
            jSONObject.put("viewId", this.O0000O0o);
            jSONObject.put("pageId", this.O0000Oo0);
            jSONObject.put("label", this.O0000OOo);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
