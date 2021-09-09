package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import android.text.TextUtils;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class hiq extends hik {
    String O00000o;
    String O00000o0;
    String O00000oO;
    String O00000oo;

    public hiq(String str, hig.O000000o o000000o) {
        super(str, o000000o);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.O00000o0 = jSONObject.optString("us_id");
                this.O00000oo = jSONObject.optString("scene_name");
                this.O00000o = jSONObject.optString("owner_uid");
                this.O00000oO = jSONObject.optString("region");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Tag tag) {
        if (!TextUtils.isEmpty(this.O00000o0) && !TextUtils.isEmpty(this.O00000o) && !TextUtils.isEmpty(this.O00000oO)) {
            HashMap hashMap = new HashMap();
            hashMap.put((short) 1, this.O00000o0.getBytes());
            hashMap.put((short) 2, this.O00000o.getBytes());
            hashMap.put((short) 3, this.O00000oO.getBytes());
            if (!TextUtils.isEmpty(this.O00000oo)) {
                hashMap.put((short) 4, this.O00000oo.getBytes());
            }
            dww dww = new dww(7, (byte) 0, (byte) 0, hashMap);
            dwt dwt = new dwt(9, Byte.MAX_VALUE, (byte) 0, (byte) 0, null);
            dwv.O000000o o000000o = new dwv.O000000o();
            o000000o.O000000o((byte) 1, dww);
            o000000o.O000000o((byte) 2, dwt);
            try {
                new dwu();
                hig.O000000o(tag, hig.O000000o("com.xiaomi.smarthome", dwu.O000000o(o000000o.O000000o())), 3, this.O00000Oo);
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
