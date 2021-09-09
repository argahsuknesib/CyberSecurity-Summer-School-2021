package _m_j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgt implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgt f12959O000000o = new bgt();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj == null) {
            bhu.write("null");
        } else {
            bhc.O000000o(((File) obj).getPath());
        }
    }
}
