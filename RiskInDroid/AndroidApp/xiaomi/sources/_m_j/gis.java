package _m_j;

import org.json.JSONObject;

public final class gis {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17815O000000o;
    public String O00000Oo;

    public static gis O000000o(JSONObject jSONObject) {
        gis gis = new gis();
        try {
            gis.O00000Oo = gjd.O000000o(jSONObject, "city_id");
            gis.f17815O000000o = gjd.O000000o(jSONObject, "area_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gis;
    }
}
