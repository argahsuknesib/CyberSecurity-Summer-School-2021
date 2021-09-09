package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;

final class ifp extends ift {
    ifp(idl idl) {
        super(idl);
    }

    public final String O000000o() throws NotFoundException, FormatException {
        if (this.f1260O000000o.O00000Oo >= 48) {
            StringBuilder sb = new StringBuilder();
            O00000Oo(sb, 8);
            int O000000o2 = this.O00000Oo.O000000o(48, 2);
            sb.append("(393");
            sb.append(O000000o2);
            sb.append(')');
            int O000000o3 = this.O00000Oo.O000000o(50, 10);
            if (O000000o3 / 100 == 0) {
                sb.append('0');
            }
            if (O000000o3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(O000000o3);
            sb.append(this.O00000Oo.O000000o(60, (String) null).f1263O000000o);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
