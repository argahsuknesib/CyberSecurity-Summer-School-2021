package _m_j;

import org.json.JSONObject;

public class cdm extends cdl {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f13669O000000o;
    protected long O00000Oo;
    public String O00000o;
    public String O00000o0;

    public boolean O00000o0() {
        return false;
    }

    public String O000000o() {
        return this.f13669O000000o;
    }

    public void O000000o(String str) {
        this.f13669O000000o = str;
    }

    public long O00000Oo() {
        return this.O00000Oo;
    }

    public void O000000o(long j) {
        this.O00000Oo = j;
    }

    public String O00000o() {
        return this.O00000o;
    }

    public String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.f13669O000000o);
            jSONObject.put("dataJson", this.O00000o0);
            jSONObject.put("category", this.O00000o);
            jSONObject.put("timestamp", this.O00000Oo);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
