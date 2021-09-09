package _m_j;

import org.json.JSONArray;
import org.json.JSONObject;

public final class bur {

    /* renamed from: O000000o  reason: collision with root package name */
    public String[] f13296O000000o;
    private String O00000Oo;
    private long O00000o;
    private long O00000o0;

    public bur(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.O00000Oo = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ips");
        int length = jSONArray.length();
        this.f13296O000000o = new String[length];
        for (int i = 0; i < length; i++) {
            this.f13296O000000o[i] = jSONArray.getString(i);
        }
        this.O00000o0 = jSONObject.getLong("ttl");
        this.O00000o = System.currentTimeMillis() / 1000;
    }

    public final String toString() {
        String str = "host: " + this.O00000Oo + " ip cnt: " + this.f13296O000000o.length + " ttl: " + this.O00000o0;
        for (int i = 0; i < this.f13296O000000o.length; i++) {
            str = str + "\n ip: " + this.f13296O000000o[i];
        }
        return str;
    }
}
