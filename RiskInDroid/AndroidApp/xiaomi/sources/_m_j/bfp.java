package _m_j;

import com.imi.fastjson.JSONException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public final class bfp extends bdw implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfp f12929O000000o = new bfp();

    public final int O000000o() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public final <T> T O000000o(bdo bdo, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        if (obj instanceof Number) {
            return new Timestamp(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            try {
                return new Timestamp(bdo.O000000o().parse(str).getTime());
            } catch (ParseException unused) {
                return new Timestamp(Long.parseLong(str));
            }
        } else {
            throw new JSONException("parse error");
        }
    }
}
