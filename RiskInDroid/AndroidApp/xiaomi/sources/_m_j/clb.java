package _m_j;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class clb implements Comparable<clb> {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13986O000000o;
    public long O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO = "";
    public boolean O0000Ooo;
    public int O0000o;
    public long O0000o0;
    public boolean O0000o00;
    public long O0000o0O;
    public long O0000o0o;
    public String O0000oO;
    public String O0000oO0;
    public String O0000oOO;
    public String O0000oOo;
    public String O0000oo;
    public String O0000oo0;
    public boolean O0000ooO;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return (int) (this.O00000Oo - ((clb) obj).O00000Oo);
    }

    public final String O000000o() {
        if (TextUtils.isEmpty(this.O0000OOo)) {
            return null;
        }
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            return "fds://" + this.O0000OOo;
        }
        return "fds://" + this.O0000OOo + "?" + this.O0000Oo0;
    }

    public static clb O000000o(JSONObject jSONObject) {
        JSONArray jSONArray;
        clb clb = new clb();
        clb.f13986O000000o = jSONObject.optString("uid");
        clb.O00000Oo = jSONObject.optLong("time") * 1000;
        clb.O00000o0 = jSONObject.optString("did");
        clb.O00000o = jSONObject.optString("type");
        clb.O00000oO = jSONObject.optString("key");
        try {
            jSONArray = new JSONArray(jSONObject.optString("value"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null) {
            clb.O00000oo = jSONArray.optString(0);
            clb.O0000O0o = jSONArray.optString(1);
            clb.O0000OOo = jSONArray.optString(2);
            clb.O0000Oo0 = jSONArray.optString(3);
            clb.O0000Oo = jSONArray.optString(4);
        }
        return clb;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof clb)) {
            clb clb = (clb) obj;
            if (this.O00000Oo != clb.O00000Oo || !this.O00000o0.equals(clb.O00000o0) || !this.O00000oO.equals(clb.O00000oO) || !this.O00000o.equals(clb.O00000o)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", this.O0000o0);
            jSONObject.put("expireTime", this.O0000o0O);
            jSONObject.put("createTime", this.O0000o0o);
            jSONObject.put("offset", this.O0000o);
            jSONObject.put("imgStoreId", this.O0000oO0);
            jSONObject.put("imgStoreUrl", this.O0000oO);
            jSONObject.put("fileId", this.O0000oOO);
            jSONObject.put("videoStoreId", this.O0000oOo);
            jSONObject.put("desc", this.O0000oo0);
            jSONObject.put("tags", this.O0000oo);
            jSONObject.put("title", this.O0000OoO);
            jSONObject.put("isLocalCached", this.O0000ooO);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String toString() {
        return "AlarmItem{uid='" + this.f13986O000000o + '\'' + ", time=" + this.O00000Oo + ", did='" + this.O00000o0 + '\'' + ", type='" + this.O00000o + '\'' + ", key='" + this.O00000oO + '\'' + ", videoObject='" + this.O00000oo + '\'' + ", videoSecret='" + this.O0000O0o + '\'' + ", picObject='" + this.O0000OOo + '\'' + ", picSecret='" + this.O0000Oo0 + '\'' + ", triggle='" + this.O0000Oo + '\'' + ", title='" + this.O0000OoO + '\'' + ", isV2=" + this.O0000Ooo + ", isM3U8=" + this.O0000o00 + ", duration=" + this.O0000o0 + ", expireTime=" + this.O0000o0O + ", createTime=" + this.O0000o0o + ", offset=" + this.O0000o + ", imgStoreId='" + this.O0000oO0 + '\'' + ", imgStoreUrl='" + this.O0000oO + '\'' + ", fileId='" + this.O0000oOO + '\'' + ", videoStoreId='" + this.O0000oOo + '\'' + ", desc='" + this.O0000oo0 + '\'' + ", tags='" + this.O0000oo + '\'' + ", isLocalCached=" + this.O0000ooO + '}';
    }
}
