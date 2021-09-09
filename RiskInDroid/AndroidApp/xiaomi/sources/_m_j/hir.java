package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import android.text.TextUtils;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import com.xiaomi.smarthome.device.Device;
import java.util.HashMap;

public final class hir extends hik {
    String O00000o;
    String O00000o0;
    String O00000oO;
    int O00000oo = 0;

    public hir(String str, hig.O000000o o000000o) {
        super(str, o000000o);
        Device O000000o2;
        if (!TextUtils.isEmpty(str)) {
            hij O000000o3 = hij.O000000o(str);
            this.O00000o0 = O000000o3.O00000Oo;
            this.O00000o = O000000o3.O00000o0;
            this.O00000oo = O000000o3.O00000oO;
            String str2 = O000000o3.f18962O000000o;
            if (!TextUtils.isEmpty(str2) && (O000000o2 = fno.O000000o().O000000o(str2)) != null) {
                this.O00000oO = O000000o2.model;
            }
        }
    }

    public final void O000000o(Tag tag) {
        if (!TextUtils.isEmpty(this.O00000o0) && !TextUtils.isEmpty(this.O00000oO)) {
            HashMap hashMap = new HashMap();
            hashMap.put((short) 2, hig.O000000o(this.O00000o0));
            hashMap.put((short) 18, this.O00000oO.getBytes());
            if (!TextUtils.isEmpty(this.O00000o)) {
                hashMap.put((short) 1, hig.O000000o(this.O00000o));
            }
            dww dww = new dww(3, (byte) 0, (byte) 0, hashMap);
            dwv.O000000o o000000o = new dwv.O000000o();
            o000000o.O000000o((byte) 1, dww);
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
