package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18381O000000o;
    public List<gvp> O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;

    public static gvm O000000o(JSONObject jSONObject) {
        List<gvp> list;
        JSONArray optJSONArray;
        gvm gvm = new gvm();
        gvm.O00000o0 = jSONObject.optString("category");
        gvm.O00000o = jSONObject.optString("name");
        gvm.O00000oO = jSONObject.optString("device_type");
        gvm.O00000oo = jSONObject.optString("model");
        gvm.O0000O0o = jSONObject.optString("icon_url");
        gvm.O0000OOo = jSONObject.optString("icon_url_480");
        gvm.f18381O000000o = jSONObject.optString("did");
        if (!jSONObject.isNull("tips") && (optJSONArray = jSONObject.optJSONArray("tips")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                gvp O000000o2 = gvp.O000000o(optJSONArray.optJSONObject(i));
                if (O000000o2 != null) {
                    arrayList.add(O000000o2);
                }
            }
            gvm.O00000Oo = arrayList;
        }
        if (TextUtils.isEmpty(gvm.O0000OOo) || TextUtils.isEmpty(gvm.f18381O000000o) || (list = gvm.O00000Oo) == null || list.isEmpty()) {
            return null;
        }
        return gvm;
    }
}
