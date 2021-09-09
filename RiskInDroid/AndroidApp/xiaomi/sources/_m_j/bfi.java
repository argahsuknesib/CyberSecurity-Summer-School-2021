package _m_j;

import com.imi.fastjson.JSONException;
import java.util.Date;

public final class bfi extends bdw implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfi f12924O000000o = new bfi();

    public final int O000000o() {
        return 2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005a */
    public final <T> T O000000o(bdo bdo, Object obj) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Number) {
            return new java.sql.Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            bdq bdq = new bdq(str);
            try {
                if (bdq.O0000ooo()) {
                    j = bdq.O0000o0().getTimeInMillis();
                } else {
                    T date = new java.sql.Date(bdo.O000000o().parse(str).getTime());
                    bdq.close();
                    return date;
                }
                bdq.close();
                return new java.sql.Date(j);
            } catch (Throwable th) {
                bdq.close();
                throw th;
            }
        } else {
            throw new JSONException("parse error : ".concat(String.valueOf(obj)));
        }
    }
}
