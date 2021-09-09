package _m_j;

import com.imi.fastjson.JSONException;
import java.text.ParseException;
import java.util.Date;

public final class bej extends bdw implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bej f12905O000000o = new bej();

    public final int O000000o() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public final <T> T O000000o(bdo bdo, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            bdq bdq = new bdq(str);
            try {
                if (bdq.O00000Oo(false)) {
                    return bdq.O0000o0().getTime();
                }
                bdq.close();
                try {
                    return bdo.O000000o().parse(str);
                } catch (ParseException unused) {
                    return new Date(Long.parseLong(str));
                }
            } finally {
                bdq.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }
}
