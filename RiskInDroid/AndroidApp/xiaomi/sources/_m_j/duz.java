package _m_j;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

public class duz {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14965O000000o = (Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
    private String O00000Oo = esl.O00000o0();
    public int O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public String O0000Oo0;

    public JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.O00000oO);
            jSONObject.put("reportType", this.O0000O0o);
            jSONObject.put("clientInterfaceId", this.O00000oo);
            jSONObject.put("os", this.f14965O000000o);
            jSONObject.put("miuiVersion", this.O00000Oo);
            jSONObject.put("pkgName", this.O0000OOo);
            jSONObject.put("sdkVersion", this.O0000Oo0);
            return jSONObject;
        } catch (JSONException e) {
            duv.O000000o(e);
            return null;
        }
    }

    public String O00000Oo() {
        JSONObject O000000o2 = O000000o();
        return O000000o2 == null ? "" : O000000o2.toString();
    }
}
