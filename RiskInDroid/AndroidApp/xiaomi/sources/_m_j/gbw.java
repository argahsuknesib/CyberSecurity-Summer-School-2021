package _m_j;

import _m_j.fwy;
import _m_j.hsi;
import com.xiaomi.smarthome.application.CommonApplication;

public class gbw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hsi.O000000o f17507O000000o;

    private static hsi.O000000o O00000Oo() {
        fwy.O00000Oo o00000Oo = fwz.O000000o().O00000Oo().O000O0o;
        hsi.O000000o o000000o = o00000Oo != null ? fwy.this.O0000Oo0 : null;
        if (o000000o != null) {
            return o000000o;
        }
        if (f17507O000000o == null) {
            synchronized (gbw.class) {
                if (f17507O000000o == null) {
                    fkl.O000000o();
                    f17507O000000o = fkl.O000000o(CommonApplication.getAppContext());
                }
            }
        }
        return f17507O000000o;
    }

    public static String O000000o() {
        hsi.O000000o O00000Oo = O00000Oo();
        return O00000Oo != null ? O00000Oo.O00000oo : "";
    }
}
