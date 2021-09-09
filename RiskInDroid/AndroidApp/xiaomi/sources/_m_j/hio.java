package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import android.text.TextUtils;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class hio extends hik {
    String O00000o;
    String O00000o0;

    public hio(String str, hig.O000000o o000000o) {
        super(str, o000000o);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.O00000o0 = jSONObject.optString("ssid");
                this.O00000o = jSONObject.optString("pass_word");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Tag tag) {
        if (!TextUtils.isEmpty(this.O00000o0) && !TextUtils.isEmpty(this.O00000o)) {
            dwv.O000000o o000000o = new dwv.O000000o();
            HashMap hashMap = new HashMap();
            hashMap.put((short) 15, this.O00000o0.getBytes());
            hashMap.put((short) 17, this.O00000o.getBytes());
            o000000o.O000000o((byte) 1, new dww(2, (byte) 0, (byte) 0, hashMap));
            o000000o.O000000o((byte) 2, new dwt(11, Byte.MAX_VALUE, (byte) 0, (byte) 0, null));
            try {
                new dwu();
                dwv O000000o2 = o000000o.O000000o();
                String str = "com.xiaomi.smarthome";
                int i = 3;
                if (hig.O0000OOo()) {
                    str = "com.xiaomi.mi_connect_service";
                    i = 0;
                }
                hig.O000000o(tag, hig.O000000o(str, dwu.O000000o(O000000o2)), i, this.O00000Oo);
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
