package _m_j;

import _m_j.dwv;
import _m_j.hig;
import android.nfc.Tag;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;

public final class hit extends hik {
    public hit(String str, hig.O000000o o000000o) {
        super(str, o000000o);
    }

    public final void O000000o(Tag tag) {
        dwv.O000000o o000000o = new dwv.O000000o();
        try {
            new dwu();
            hig.O000000o(tag, hig.O000000o("com.xiaomi.smarthome", dwu.O000000o(o000000o.O000000o())), 3, this.O00000Oo);
        } catch (NfcTagDataCorruptException e) {
            e.printStackTrace();
            if (this.O00000Oo != null) {
                this.O00000Oo.O000000o(-9000, e.getMessage());
            }
        }
    }
}
