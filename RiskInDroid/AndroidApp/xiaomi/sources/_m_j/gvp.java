package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gvp {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<gvn> f18384O000000o;
    private List<String> O00000Oo;
    private String O00000o0;

    public static gvp O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject == null) {
            return null;
        }
        gvp gvp = new gvp();
        if (!jSONObject.isNull("content_details") && (optJSONArray2 = jSONObject.optJSONArray("content_details")) != null && optJSONArray2.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray2.length(); i++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                if (optJSONObject != null) {
                    gvn gvn = new gvn();
                    if (optJSONObject != null) {
                        gvn.f18382O000000o = optJSONObject.optString("content");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("slot_value");
                        gvo gvo = new gvo();
                        if (optJSONObject2 != null && !optJSONObject2.isNull("slot_value")) {
                            gvo.f18383O000000o = optJSONObject2.optBoolean("on");
                        }
                        gvn.O00000Oo = gvo;
                    }
                    arrayList.add(gvn);
                }
            }
            gvp.f18384O000000o = arrayList;
        }
        if (!jSONObject.isNull("contents") && (optJSONArray = jSONObject.optJSONArray("contents")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList2.add(optString);
                }
            }
            gvp.O00000Oo = arrayList2;
        }
        gvp.O00000o0 = jSONObject.optString("title");
        return gvp;
    }
}
