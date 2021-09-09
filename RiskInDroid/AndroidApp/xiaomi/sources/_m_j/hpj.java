package _m_j;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpj extends hpk {
    public static hpk O000000o(hpm hpm, String str, HashMap<String, Object> hashMap) {
        hpk hpk = new hpk();
        hpk.f468O000000o = 1;
        hpk.O0000Oo0 = hpm.getDid();
        hpk.O0000Oo = hpm.getModel();
        hpk.O00000o0 = str;
        hpk.O0000Oo0 = hpm.getDid();
        try {
            hpk.O00000oO = new JSONObject();
            for (Map.Entry next : hashMap.entrySet()) {
                hpk.O00000oO.put((String) next.getKey(), next.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hpk;
    }
}
