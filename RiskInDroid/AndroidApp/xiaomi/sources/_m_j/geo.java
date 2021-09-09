package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@RouterService
public class geo extends gdy {
    private static final geo INSTANCE = new geo();

    @cug
    public static geo provideInstance() {
        return INSTANCE;
    }

    public boolean onReceiveMessage(String str, String str2) {
        processMessage(str2);
        return true;
    }

    private void processMessage(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("details");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(parse(optJSONArray.optJSONObject(i)));
                }
                if (arrayList.size() > 0) {
                    hni.O000000o().O000000o(arrayList);
                }
            }
        } catch (Exception unused) {
        }
    }

    private SceneApi.O000OOOo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SceneApi.O000OOOo o000OOOo = new SceneApi.O000OOOo();
        o000OOOo.f11131O000000o = jSONObject.optString("us_id");
        o000OOOo.O0000Oo0 = jSONObject.optBoolean("enable");
        return o000OOOo;
    }
}
