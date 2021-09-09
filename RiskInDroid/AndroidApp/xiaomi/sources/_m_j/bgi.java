package _m_j;

import java.io.IOException;
import java.lang.reflect.Type;

public final class bgi implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgi f12949O000000o = new bgi();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        Character ch = (Character) obj;
        if (ch == null) {
            bhu.O000000o("");
        } else if (ch.charValue() == 0) {
            bhu.O000000o("\u0000");
        } else {
            bhu.O000000o(ch.toString());
        }
    }
}
