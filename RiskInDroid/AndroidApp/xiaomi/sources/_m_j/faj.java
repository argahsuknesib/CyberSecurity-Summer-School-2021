package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class faj {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16000O000000o;
    public String O00000Oo;
    String O00000o;
    public String O00000o0;
    public String O00000oO;
    public List<O000000o> O00000oo = new ArrayList();
    boolean O0000O0o;
    long O0000OOo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f16001O000000o;
        List<String> O00000Oo;

        public final String toString() {
            return "AuthDetail{authType='" + this.f16001O000000o + '\'' + ", authValues=" + this.O00000Oo + '}';
        }
    }

    public static faj O000000o(JSONObject jSONObject) {
        faj faj = new faj();
        if (jSONObject != null) {
            faj.f16000O000000o = jSONObject.optString("app_title", "");
            faj.O00000Oo = jSONObject.optString("app_intro", "");
            faj.O00000o0 = jSONObject.optString("app_icon", "");
            faj.O00000o = jSONObject.optString("app_public_key", "");
            faj.O0000O0o = jSONObject.optBoolean("default_enable", false);
            faj.O0000OOo = jSONObject.optLong("default_expire");
            faj.O00000oO = jSONObject.optString("app_button_info", ServiceApplication.getAppContext().getResources().getString(R.string.auth_check_config));
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("details");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        O000000o o000000o = new O000000o();
                        o000000o.f16001O000000o = optJSONObject.optInt("auth_type");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("auth_value");
                        if (optJSONArray2 != null) {
                            o000000o.O00000Oo = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                o000000o.O00000Oo.add(optJSONArray2.get(i2).toString());
                            }
                        }
                        faj.O00000oo.add(o000000o);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return faj;
    }

    public final String toString() {
        return "AuthInfo{appName='" + this.f16000O000000o + '\'' + ", appDesc='" + this.O00000Oo + '\'' + ", appIcon='" + this.O00000o0 + '\'' + ", appPublicKey='" + this.O00000o + '\'' + ", authDetails=" + this.O00000oo + ", defaultEnable=" + this.O0000O0o + ", defaultExpire=" + this.O0000OOo + '}';
    }
}
