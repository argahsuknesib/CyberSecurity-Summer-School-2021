package _m_j;

import org.json.JSONObject;

public final class giv {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17818O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;

    public static giv O000000o(JSONObject jSONObject) {
        giv giv = new giv();
        try {
            giv.f17818O000000o = gjd.O000000o(jSONObject, "ac_key");
            giv.O00000Oo = gjd.O000000o(jSONObject, "id");
            giv.O00000o0 = gjd.O000000o(jSONObject, "name");
            giv.O00000o = gjd.O000000o(jSONObject, "display_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giv;
    }
}
