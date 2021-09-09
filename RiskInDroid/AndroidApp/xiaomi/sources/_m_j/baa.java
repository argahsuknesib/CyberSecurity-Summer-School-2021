package _m_j;

import android.text.TextUtils;
import org.json.JSONObject;

public final class baa {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f12740O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private long O0000O0o;

    public baa() {
        this.f12740O000000o = 4096;
        this.O0000O0o = System.currentTimeMillis();
    }

    public baa(String str, String str2) {
        this(str, str2, null);
    }

    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("messageType", Integer.valueOf(this.f12740O000000o));
            jSONObject.putOpt("eventID", this.O00000o0);
            jSONObject.putOpt("appPackage", this.O00000Oo);
            jSONObject.putOpt("eventTime", Long.valueOf(this.O0000O0o));
            if (!TextUtils.isEmpty(this.O00000o)) {
                jSONObject.putOpt("globalID", this.O00000o);
            }
            if (!TextUtils.isEmpty(this.O00000oO)) {
                jSONObject.putOpt("taskID", this.O00000oO);
            }
            if (!TextUtils.isEmpty(this.O00000oo)) {
                jSONObject.putOpt("property", this.O00000oo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private baa(String str, String str2, String str3) {
        this.f12740O000000o = 4096;
        this.O0000O0o = System.currentTimeMillis();
        this.f12740O000000o = 4096;
        this.O00000Oo = str;
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000o0 = str2;
        this.O00000oo = null;
    }
}
