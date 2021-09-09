package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import android.text.TextUtils;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class hip extends hik {
    String O00000o0;

    public hip(String str, hig.O000000o o000000o) {
        super(str, o000000o);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.O00000o0 = new JSONObject(str).optString("bt_mac");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Tag tag) {
        if (!TextUtils.isEmpty(this.O00000o0)) {
            dwv.O000000o o000000o = new dwv.O000000o();
            HashMap hashMap = new HashMap();
            hashMap.put((short) 2, hig.O000000o(this.O00000o0));
            o000000o.O000000o((byte) 1, new dww(5, (byte) 0, (byte) 0, hashMap));
            o000000o.O000000o((byte) 2, new dwt(Short.MAX_VALUE, Byte.MAX_VALUE, (byte) 0, (byte) 0, null));
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
