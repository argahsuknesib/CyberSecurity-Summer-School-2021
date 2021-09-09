package _m_j;

import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import org.json.JSONException;
import org.json.JSONObject;

public class gxm {
    private static volatile gxm O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f18471O000000o;
    public boolean O00000Oo = false;
    public volatile boolean O00000o0 = false;

    public class O000000o implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f18474O000000o = 0;
        public long O00000Oo = 0;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;

        public O000000o() {
        }

        public final Object clone() {
            try {
                return (O000000o) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    public final String O000000o() {
        if (O000000o(this.f18471O000000o)) {
            return this.f18471O000000o.O00000oo;
        }
        return null;
    }

    public final String O00000Oo() {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (O0000o0 == null || !O000000o(this.f18471O000000o) || !O0000o0.equalsIgnoreCase(this.f18471O000000o.O00000o0)) {
            return null;
        }
        return this.f18471O000000o.O00000oO;
    }

    public static gxm O00000o0() {
        if (O00000o == null) {
            synchronized (gxm.class) {
                if (O00000o == null) {
                    O00000o = new gxm();
                }
            }
        }
        return O00000o;
    }

    public static boolean O000000o(O000000o o000000o) {
        return (o000000o == null || o000000o.O00000oO == null || o000000o.f18474O000000o + o000000o.O00000Oo <= System.currentTimeMillis() / 1000) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final String O00000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_token", this.f18471O000000o.O00000oO);
            jSONObject.put("mac_key", this.f18471O000000o.O00000oo);
            jSONObject.put("mac_algorithm", this.f18471O000000o.O00000o);
            jSONObject.put("expires", this.f18471O000000o.O00000Oo);
            jSONObject.put("user_id", this.f18471O000000o.O00000o0);
            jSONObject.put("get_token_time", this.f18471O000000o.f18474O000000o);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private gxm() {
        String string;
        SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("oauth.2.0.access.info", 0);
        if (sharedPreferences != null && (string = sharedPreferences.getString("access.token".concat(String.valueOf(CoreApi.O000000o().O0000o0())), null)) != null && !string.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.f18471O000000o == null) {
                    this.f18471O000000o = new O000000o();
                    this.f18471O000000o.O00000oO = jSONObject.optString("access_token", null);
                    this.f18471O000000o.O00000oo = jSONObject.optString("mac_key", null);
                    this.f18471O000000o.O00000o = jSONObject.optString("mac_algorithm", null);
                    this.f18471O000000o.O00000Oo = jSONObject.optLong("expires", 0);
                    this.f18471O000000o.O00000o0 = jSONObject.optString("user_id", null);
                    this.f18471O000000o.f18474O000000o = jSONObject.optLong("get_token_time", 0);
                }
            } catch (JSONException unused) {
            }
        }
    }
}
