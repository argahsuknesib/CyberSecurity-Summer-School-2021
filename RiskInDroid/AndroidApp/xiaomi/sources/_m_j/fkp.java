package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fkp {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16547O000000o;
    public int O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public int O0000Oo;
    public String O0000Oo0;
    public O000000o O0000OoO;
    public String O0000Ooo;
    public int O0000o;
    public int O0000o0;
    public int O0000o00;
    public String O0000o0O;
    public String O0000o0o;
    public int O0000oO;
    public int O0000oO0;
    public int O0000oOO;
    public int O0000oOo;
    public int O0000oo;
    public int O0000oo0;
    public int O0000ooO;
    public int O0000ooo;
    public int O000O00o;
    public String O000O0OO;
    public int O000O0Oo;
    public int O000O0o;
    public List<Integer> O000O0o0;
    public int O000O0oO;
    public List<Integer> O000O0oo;
    public List<String> O000OO;
    public List<Integer> O000OO00;
    public int O000OO0o;
    public int O000OOOo;
    public int O000OOo;
    public int O000OOo0;
    public byte O000OOoO;
    public int O000OOoo;
    public int O000Oo00;
    public long O00oOoOo;
    public int O00oOooO;
    public int O00oOooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16548O000000o;
        public String O00000Oo;
    }

    public static fkp O000000o(JSONObject jSONObject) {
        fkp fkp = new fkp();
        fkp.f16547O000000o = jSONObject.optString("model");
        fkp.O00000Oo = jSONObject.optInt("pd_id");
        fkp.O00000o0 = jSONObject.optInt("min_app_version");
        fkp.O00000o = jSONObject.optString("name");
        fkp.O0000Oo = jSONObject.optInt("bind_confirm");
        JSONObject optJSONObject = jSONObject.optJSONObject("model_regex");
        if (optJSONObject != null) {
            O000000o o000000o = new O000000o();
            o000000o.f16548O000000o = optJSONObject.optString("ssid");
            o000000o.O00000Oo = optJSONObject.optString("passwd");
            fkp.O0000OoO = o000000o;
        }
        fkp.O0000Ooo = jSONObject.optString("desc");
        fkp.O0000o00 = jSONObject.optInt("pid");
        fkp.O0000o0 = jSONObject.optInt("status");
        fkp.O0000o0O = jSONObject.optString("brand_name");
        fkp.O0000o0o = jSONObject.optString("cate_name");
        fkp.O0000o = jSONObject.optInt("bt_bind_style");
        fkp.O0000oO0 = jSONObject.optInt("ct_offline_enter");
        fkp.O0000oO = jSONObject.optInt("permission_control");
        fkp.O0000oOO = jSONObject.optInt("wexin_share");
        fkp.O0000oOo = jSONObject.optInt("bt_match");
        fkp.O0000oo0 = jSONObject.optInt("bt_rssi");
        fkp.O0000oo = jSONObject.optInt("sc_failed");
        fkp.O0000ooO = jSONObject.optInt("voice_control");
        fkp.O0000ooo = jSONObject.optInt("voice_ctrl_ed");
        fkp.O00oOooO = jSONObject.optInt("op_history");
        fkp.O000O0o = jSONObject.optInt("sc_type");
        fkp.O000O0oO = jSONObject.optInt("sc_status");
        JSONArray optJSONArray = jSONObject.optJSONArray("sc_type_more");
        fkp.O000O0oo = new ArrayList();
        int i = 0;
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                fkp.O000O0oo.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
        }
        fkp.O00oOooo = jSONObject.optInt("bt_is_secure");
        fkp.O000O00o = jSONObject.optInt("bt_gateway");
        fkp.O00000oO = O000000o(jSONObject, "icon_on", "https://cdn.fds.api.xiaomi.com");
        fkp.O00000oo = O000000o(jSONObject, "icon_off", "https://cdn.fds.api.xiaomi.com");
        fkp.O0000O0o = O000000o(jSONObject, "icon_offline", "https://cdn.fds.api.xiaomi.com");
        fkp.O0000OOo = O000000o(jSONObject, "icon_bluetooth_pairing", "https://cdn.fds.api.xiaomi.com");
        fkp.O0000Oo0 = O000000o(jSONObject, "icon_real", "https://cdn.fds.api.xiaomi.com");
        fkp.O000O0OO = O000000o(jSONObject, "icon_336", "https://cdn.fds.api.xiaomi.com");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sc_type_more_v2");
        fkp.O000OO00 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                fkp.O000OO00.add(Integer.valueOf(optJSONArray2.optInt(i3)));
            }
        }
        fkp.O000OO0o = jSONObject.optInt("fiveG_wifi");
        fkp.O000O0Oo = jSONObject.optInt("subcategory_id");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("relations");
        fkp.O000OO = new ArrayList();
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                fkp.O000OO.add(optJSONArray3.optString(i4));
            }
        }
        fkp.O00oOoOo = jSONObject.optLong("verified_time");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("display_type_list");
        fkp.O000O0o0 = new ArrayList();
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                fkp.O000O0o0.add(Integer.valueOf(optJSONArray4.optInt(i5)));
            }
        }
        fkp.O000OOOo = jSONObject.optInt("rank");
        fkp.O000OOo0 = jSONObject.optInt("inherit_id");
        fkp.O000OOo = jSONObject.optInt("mesh_gateway");
        fkp.O000OOoO = (byte) jSONObject.optInt("member_cnt");
        fkp.O000Oo00 = jSONObject.optInt("support_uwb");
        int i6 = fkp.O000O00o;
        int i7 = fkp.O000OOo;
        int optInt = jSONObject.optInt("infrared_gateway");
        int optInt2 = jSONObject.optInt("zigbee_gateway");
        int i8 = fkp.O000Oo00;
        if (1 == i6) {
            i = 1;
        }
        if (1 == i7) {
            i |= 2;
        }
        if (1 == optInt) {
            i |= 16;
        }
        if (2 == optInt2) {
            i |= 4;
        } else if (4 == optInt2) {
            i |= 8;
        }
        if (i8 > 0) {
            i = i8 == 1 ? i | 256 : i | 65536;
        }
        fkp.O000OOoo = i;
        return fkp;
    }

    private static String O000000o(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString) || optString.startsWith("http") || optString.startsWith("https")) {
            return optString;
        }
        return str2 + optString;
    }
}
