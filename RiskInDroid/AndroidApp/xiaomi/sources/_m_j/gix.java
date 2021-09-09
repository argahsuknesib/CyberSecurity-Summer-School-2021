package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gix {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17820O000000o;
    public giv O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public int O00000oo;
    public int O0000O0o;
    private int O0000OOo;

    public static List<gix> O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                gix gix = new gix();
                gix.f17820O000000o = gjd.O000000o(optJSONObject, "id");
                gix.O00000Oo = giv.O000000o(optJSONObject.optJSONObject("key"));
                gix.O00000o0 = gjd.O000000o(optJSONObject, "controller_id");
                gix.O00000o = gjd.O000000o(optJSONObject, "matched");
                gix.O00000oO = gjd.O000000o(optJSONObject, "mismatched");
                gix.O0000OOo = optJSONObject.optInt("count");
                gix.O00000oo = optJSONObject.optInt("cursor");
                gix.O0000O0o = optJSONObject.optInt("total");
                arrayList.add(gix);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
