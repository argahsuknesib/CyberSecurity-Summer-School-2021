package _m_j;

import org.json.JSONObject;

public final class giu {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f17817O000000o;
    private String O00000Oo;

    public static giu O000000o(JSONObject jSONObject) {
        giu giu = new giu();
        try {
            giu.f17817O000000o = gjd.O000000o(jSONObject, "id");
            giu.O00000Oo = gjd.O000000o(jSONObject, "name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giu;
    }
}
