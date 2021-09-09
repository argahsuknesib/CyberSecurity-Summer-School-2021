package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class giw {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f17819O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private boolean O00000oO;

    public static List<giw> O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                giw giw = new giw();
                giw.f17819O000000o = gjd.O000000o(optJSONObject, "ac_key");
                giw.O00000Oo = gjd.O000000o(optJSONObject, "id");
                giw.O00000o0 = gjd.O000000o(optJSONObject, "name");
                giw.O00000o = gjd.O000000o(optJSONObject, "display_name");
                giw.O00000oO = optJSONObject.optBoolean("must_match");
                arrayList.add(giw);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
