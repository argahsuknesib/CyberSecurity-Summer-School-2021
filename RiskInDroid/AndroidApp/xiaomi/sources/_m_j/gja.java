package _m_j;

import java.util.List;
import org.json.JSONObject;

public final class gja {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<gix> f17824O000000o;
    private giu O00000Oo;
    private giu O00000o;
    private giu O00000o0;
    private git O00000oO;
    private String O00000oo;
    private List<giw> O0000O0o;

    public static gja O000000o(JSONObject jSONObject) {
        gja gja = new gja();
        try {
            gja.O00000Oo = giu.O000000o(jSONObject.optJSONObject("city"));
            gja.O00000o0 = giu.O000000o(jSONObject.optJSONObject("sp"));
            gja.O00000o = giu.O000000o(jSONObject.optJSONObject("category"));
            gja.O00000oO = git.O000000o(jSONObject.optJSONObject("brand"));
            gja.O00000oo = gjd.O000000o(jSONObject, "version");
            gja.O0000O0o = giw.O000000o(jSONObject.optJSONArray("keys"));
            gja.f17824O000000o = gix.O000000o(jSONObject.optJSONArray("nodes"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gja;
    }
}
