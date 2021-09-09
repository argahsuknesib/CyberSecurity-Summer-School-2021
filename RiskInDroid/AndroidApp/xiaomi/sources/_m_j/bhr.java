package _m_j;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public final class bhr implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bhr f12977O000000o = new bhr();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        Object obj3;
        if (obj instanceof AtomicReference) {
            obj3 = ((AtomicReference) obj).get();
        } else {
            obj3 = ((Reference) obj).get();
        }
        bhc.O00000o0(obj3);
    }
}
