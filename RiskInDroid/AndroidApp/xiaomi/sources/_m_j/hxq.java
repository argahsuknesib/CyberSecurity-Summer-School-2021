package _m_j;

import _m_j.hxd;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class hxq {
    public final synchronized void O000000o(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        hxd hxd = hxd.O000000o.f946O000000o;
        try {
            if (gfr.O0000oO0) {
                if (hxd.O00000o0 != null) {
                    hxd.O000000o.f946O000000o.O00000o.O000000o("plugin", new JSONObject(new Gson().toJson(map)), str2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        map.put("country", Locale.getDefault().getCountry());
        map.put("uid", fcn.O000000o().O00000Oo());
        hxg.O000000o(str, str2, map);
    }
}
