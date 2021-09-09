package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.parser.Feature;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class bdw implements bff {
    /* access modifiers changed from: protected */
    public abstract <T> T O000000o(bdo bdo, Object obj);

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        Object obj2 = null;
        if (O0000O0o.O00000o0() == 2) {
            obj2 = Long.valueOf(O0000O0o.O0000oo0());
            O0000O0o.O000000o(16);
        } else if (O0000O0o.O00000o0() == 4) {
            String O0000oO0 = O0000O0o.O0000oO0();
            O0000O0o.O000000o(16);
            String str = O0000oO0;
            if (O0000O0o.O000000o(Feature.AllowISO8601DateFormat)) {
                bdq bdq = new bdq(O0000oO0);
                Date date = O0000oO0;
                if (bdq.O0000ooo()) {
                    date = bdq.O0000o0().getTime();
                }
                bdq.close();
                str = date;
            }
            obj2 = str;
        } else if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o();
        } else if (O0000O0o.O00000o0() == 12) {
            O0000O0o.O000000o();
            if (O0000O0o.O00000o0() == 4) {
                if (bdf.f12884O000000o.equals(O0000O0o.O0000oO0())) {
                    O0000O0o.O000000o();
                    bdo.O000000o(17);
                    bih.O000000o(O0000O0o.O0000oO0());
                    bdo.O000000o(4);
                    bdo.O000000o(16);
                }
                O0000O0o.O00000Oo(2);
                if (O0000O0o.O00000o0() == 2) {
                    long O0000oo0 = O0000O0o.O0000oo0();
                    O0000O0o.O000000o();
                    obj2 = Long.valueOf(O0000oo0);
                    bdo.O000000o(13);
                } else {
                    throw new JSONException("syntax error : " + O0000O0o.O00000o());
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else if (bdo.O0000O0o == 2) {
            bdo.O0000O0o = 0;
            bdo.O000000o(16);
            if (O0000O0o.O00000o0() != 4) {
                throw new JSONException("syntax error");
            } else if ("val".equals(O0000O0o.O0000oO0())) {
                O0000O0o.O000000o();
                bdo.O000000o(17);
                obj2 = bdo.O000000o((Object) null);
                bdo.O000000o(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = bdo.O000000o((Object) null);
        }
        return O000000o(bdo, obj2);
    }
}
