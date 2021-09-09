package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;

final class ifo extends ift {
    ifo(idl idl) {
        super(idl);
    }

    public final String O000000o() throws NotFoundException, FormatException {
        if (this.f1260O000000o.O00000Oo >= 48) {
            StringBuilder sb = new StringBuilder();
            O00000Oo(sb, 8);
            int O000000o2 = this.O00000Oo.O000000o(48, 2);
            sb.append("(392");
            sb.append(O000000o2);
            sb.append(')');
            sb.append(this.O00000Oo.O000000o(50, (String) null).f1263O000000o);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
