package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;

public abstract class ifv {

    /* renamed from: O000000o  reason: collision with root package name */
    final idl f1260O000000o;
    final igd O00000Oo;

    public abstract String O000000o() throws NotFoundException, FormatException;

    ifv(idl idl) {
        this.f1260O000000o = idl;
        this.O00000Oo = new igd(idl);
    }

    public static ifv O000000o(idl idl) {
        if (idl.O000000o(1)) {
            return new ifs(idl);
        }
        if (!idl.O000000o(2)) {
            return new ifw(idl);
        }
        int O000000o2 = igd.O000000o(idl, 1, 4);
        if (O000000o2 == 4) {
            return new ifm(idl);
        }
        if (O000000o2 == 5) {
            return new ifn(idl);
        }
        int O000000o3 = igd.O000000o(idl, 1, 5);
        if (O000000o3 == 12) {
            return new ifo(idl);
        }
        if (O000000o3 == 13) {
            return new ifp(idl);
        }
        switch (igd.O000000o(idl, 1, 7)) {
            case 56:
                return new ifq(idl, "310", "11");
            case 57:
                return new ifq(idl, "320", "11");
            case 58:
                return new ifq(idl, "310", "13");
            case 59:
                return new ifq(idl, "320", "13");
            case 60:
                return new ifq(idl, "310", "15");
            case 61:
                return new ifq(idl, "320", "15");
            case 62:
                return new ifq(idl, "310", "17");
            case 63:
                return new ifq(idl, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(idl)));
        }
    }
}
