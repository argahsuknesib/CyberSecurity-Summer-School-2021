package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fcg {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16080O000000o;
    public String O00000Oo;

    public static List<fcg> O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("model");
                    String optString2 = optJSONObject.optString("firmware_version");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        fcg fcg = new fcg();
                        fcg.f16080O000000o = optString;
                        fcg.O00000Oo = optString2;
                        arrayList.add(fcg);
                    }
                }
            }
        }
        return arrayList;
    }
}
