package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fmf {
    public static fsn O000000o(List<String> list, fsm<JSONObject, fso> fsm) {
        if (list == null || list.isEmpty()) {
            fsm.onFailure(new fso(-1, "invalid serviceKey parameters"));
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            grr.O000000o();
            jSONObject.put("version", String.valueOf(grr.O00000o0(CommonApplication.getAppContext())));
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("grey_key", jSONArray);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/user/check_gray").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fmf.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
