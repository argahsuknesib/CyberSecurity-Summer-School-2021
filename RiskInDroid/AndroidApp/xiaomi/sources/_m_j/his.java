package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import android.text.TextUtils;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class his extends hik {
    String O00000o;
    String O00000o0;
    String O00000oO;
    Set<String> O00000oo = new HashSet();

    public his(String str, hig.O000000o o000000o) {
        super(str, o000000o);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.O00000o0 = jSONObject.optString("bt_mac");
                this.O00000o = jSONObject.optString("wifi_mac");
                this.O00000oO = jSONObject.optString("id_hash");
                JSONArray optJSONArray = jSONObject.optJSONArray("supports");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.O00000oo.add(optJSONArray.optString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Tag tag) {
        if (!TextUtils.isEmpty(this.O00000o0) || !TextUtils.isEmpty(this.O00000o)) {
            dwv.O000000o o000000o = new dwv.O000000o();
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.O00000oO)) {
                hashMap.put((short) 8, this.O00000oO.getBytes());
            }
            if (!TextUtils.isEmpty(this.O00000o0)) {
                hashMap.put((short) 2, hig.O000000o(this.O00000o0));
            }
            if (!TextUtils.isEmpty(this.O00000o)) {
                hashMap.put((short) 1, hig.O000000o(this.O00000o));
            }
            o000000o.O000000o((byte) 2, new dwt(Short.MAX_VALUE, Byte.MAX_VALUE, (byte) 0, (byte) 0, null));
            o000000o.O000000o((byte) 1, new dww(5, (byte) 0, (byte) 0, hashMap));
            try {
                new dwu();
                hig.O000000o(tag, hig.O000000o("com.xiaomi.mi_connect_service", dwu.O000000o(o000000o.O000000o())), 0, this.O00000Oo);
            } catch (NfcTagDataCorruptException e) {
                e.printStackTrace();
                if (this.O00000Oo != null) {
                    this.O00000Oo.O000000o(-9000, e.getMessage());
                }
            }
        } else if (this.O00000Oo != null) {
            this.O00000Oo.O000000o(-9000, "param has null");
        }
    }
}
