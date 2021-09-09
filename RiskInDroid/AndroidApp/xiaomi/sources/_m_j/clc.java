package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class clc {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f13987O000000o;
    public long O00000Oo;
    public int O00000o;
    public long O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public boolean O0000Ooo;

    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", this.f13987O000000o);
            jSONObject.put("expireTime", this.O00000Oo);
            jSONObject.put("createTime", this.O00000o0);
            jSONObject.put("offset", this.O00000o);
            jSONObject.put("imgStoreId", this.O00000oO);
            jSONObject.put("imgStoreUrl", this.O00000oo);
            jSONObject.put("fileId", this.O0000O0o);
            jSONObject.put("videoStoreId", this.O0000OOo);
            jSONObject.put("desc", this.O0000Oo0);
            jSONObject.put("tags", this.O0000Oo);
            jSONObject.put("title", this.O0000OoO);
            jSONObject.put("isLocalCached", this.O0000Ooo);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public clc() {
    }

    public clc(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f13987O000000o = jSONObject.optLong("duration");
            this.O00000Oo = jSONObject.optLong("expireTime");
            this.O00000o0 = jSONObject.optLong("createTime");
            this.O00000o = jSONObject.optInt("offset");
            this.O00000oO = jSONObject.optString("imgStoreId");
            this.O00000oo = jSONObject.optString("imgStoreUrl");
            this.O0000O0o = jSONObject.optString("fileId");
            this.O0000OOo = jSONObject.optString("videoStoreId");
            this.O0000Oo0 = jSONObject.optString("desc");
            this.O0000Oo = jSONObject.optString("tags");
            this.O0000OoO = jSONObject.optString("title");
            this.O0000Ooo = jSONObject.optBoolean("isLocalCached");
        } catch (JSONException unused) {
        }
    }
}
