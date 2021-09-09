package _m_j;

import bsh.Capabilities;
import bsh.Interpreter;
import java.util.Enumeration;
import java.util.Vector;

public final class ky {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ky f2159O000000o;

    public static class O000000o implements ku {

        /* renamed from: O000000o  reason: collision with root package name */
        Enumeration f2160O000000o;

        public O000000o(Object obj) {
            this.f2160O000000o = O000000o(obj);
        }

        private Enumeration O000000o(Object obj) {
            String obj2;
            while (obj != null) {
                if (obj instanceof Enumeration) {
                    return (Enumeration) obj;
                }
                if (obj instanceof Vector) {
                    return ((Vector) obj).elements();
                }
                if (obj.getClass().isArray()) {
                    return new kz(this, obj);
                }
                if (obj instanceof String) {
                    obj2 = (String) obj;
                } else if (obj instanceof StringBuffer) {
                    obj2 = obj.toString();
                } else {
                    StringBuffer stringBuffer = new StringBuffer("Cannot enumerate object of type ");
                    stringBuffer.append(obj.getClass());
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                obj = obj2.toCharArray();
            }
            throw new NullPointerException("Object arguments passed to the BasicBshIterator constructor cannot be null.");
        }

        public final Object O000000o() {
            return this.f2160O000000o.nextElement();
        }

        public final boolean O00000Oo() {
            return this.f2160O000000o.hasMoreElements();
        }
    }

    public static synchronized ky O000000o() {
        ky kyVar;
        synchronized (ky.class) {
            if (f2159O000000o == null && Capabilities.O000000o("java.util.Collection")) {
                try {
                    f2159O000000o = (ky) Class.forName("bsh.collection.CollectionManagerImpl").newInstance();
                } catch (Exception e) {
                    Interpreter.O00000Oo("unable to load CollectionManagerImpl: ".concat(String.valueOf(e)));
                }
            }
            if (f2159O000000o == null) {
                f2159O000000o = new ky();
            }
            kyVar = f2159O000000o;
        }
        return kyVar;
    }

    public static boolean O000000o(Object obj) {
        try {
            O00000Oo(obj);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static ku O00000Oo(Object obj) throws IllegalArgumentException {
        return new O000000o(obj);
    }
}
