package _m_j;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class hlg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hlg f19033O000000o = new hlg("get network type failed") {
        /* class _m_j.hlg.AnonymousClass1 */

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", "error");
                jSONObject.put("msg", this.O00000o0);
            } catch (JSONException e) {
                gsy.O00000Oo("NetState", "toJson: " + Log.getStackTraceString(e));
            }
            gsy.O00000Oo("NetState", "toJson: networkAvailable: " + this.O00000Oo + " ;networkType: " + this.O00000o0);
            return jSONObject;
        }
    };
    protected boolean O00000Oo;
    protected String O00000o0;

    public hlg(boolean z, String str) {
        this.O00000Oo = z;
        this.O00000o0 = str;
    }

    public JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "ok");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("networkAvailable", this.O00000Oo);
            jSONObject2.put("networkType", this.O00000o0);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e) {
            gsy.O00000Oo("NetState", "toJson: " + Log.getStackTraceString(e));
        }
        gsy.O00000Oo("NetState", "toJson: networkAvailable: " + this.O00000Oo + " ;networkType: " + this.O00000o0);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hlg hlg = (hlg) obj;
            if (this.O00000Oo != hlg.O00000Oo) {
                return false;
            }
            String str = this.O00000o0;
            if (str != null) {
                return str.equals(hlg.O00000o0);
            }
            if (hlg.O00000o0 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.O00000Oo ? 1 : 0) * true;
        String str = this.O00000o0;
        return i + (str != null ? str.hashCode() : 0);
    }
}
