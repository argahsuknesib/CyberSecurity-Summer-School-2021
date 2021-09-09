package _m_j;

import org.json.JSONObject;

public final class giy {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17821O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    private int O00000oO;
    private int O00000oo;

    public static giy O000000o(JSONObject jSONObject) {
        giy giy = new giy();
        try {
            giy.f17821O000000o = gjd.O000000o(jSONObject, "did");
            giy.O00000oO = jSONObject.optInt("category");
            giy.O00000Oo = gjd.O000000o(jSONObject, "name");
            giy.O00000o0 = gjd.O000000o(jSONObject, "model");
            giy.O00000oo = jSONObject.optInt("pdid");
            giy.O00000o = gjd.O000000o(jSONObject, "parent_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giy;
    }
}
