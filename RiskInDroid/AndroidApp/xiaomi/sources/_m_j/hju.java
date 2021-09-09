package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class hju implements hjq {
    public String O0000Ooo;

    public static List<hju> O000000o(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONArray jSONArray = jSONObject2.getJSONObject("module").getJSONArray("items");
            JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
            for (int i = 0; i < jSONArray.length(); i++) {
                hjt hjt = new hjt();
                arrayList.add(hjt);
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                hjt.O0000Ooo = jSONObject3.getString("img");
                hjt.f19003O000000o = jSONObject3.getString("pageUrl");
                hjt.O00000Oo = jSONObject3.getString("title");
                hjt.O00000o0 = jSONObject3.getString("id");
                if (optJSONObject != null) {
                    hjt.O00000o = optJSONObject.optString("expId", "");
                }
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("banners");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    hjs hjs = new hjs();
                    arrayList.add(hjs);
                    JSONObject jSONObject4 = optJSONArray.getJSONObject(i2);
                    hjs.O0000Ooo = jSONObject4.getString("imgUrl");
                    hjs.f19002O000000o = jSONObject4.getString("h5Url");
                    hjs.O00000Oo = jSONObject4.getString("shareImgUrl");
                    hjs.O00000o0 = jSONObject4.getString("name");
                    hjs.O0000O0o = jSONObject4.getString("shareDesc");
                    hjs.O00000o = jSONObject4.getLong("beginTime");
                    hjs.O00000oO = jSONObject4.getLong("endTime");
                    hjs.O00000oo = jSONObject4.getInt("position");
                    hjs.O0000OOo = jSONObject4.getInt("jump");
                    hjs.O0000Oo0 = jSONObject4.getString("id");
                    hjs.O0000Oo = jSONObject4.optString("shortKey");
                    if (optJSONObject != null) {
                        hjs.O0000OoO = optJSONObject.optString("expId", "");
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public final String O00000Oo() {
        return this.O0000Ooo;
    }
}
