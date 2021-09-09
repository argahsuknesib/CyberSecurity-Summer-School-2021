package io.realm.internal;

import _m_j.irr;
import _m_j.irs;

public class Util {
    static native String nativeGetTablePrefix();

    public static String O000000o() {
        return nativeGetTablePrefix();
    }

    public static Class<? extends irr> O000000o(Class<? extends irr> cls) {
        if (cls.equals(irr.class) || cls.equals(irs.class)) {
            throw new IllegalArgumentException("RealmModel or RealmObject was passed as an argument. Only subclasses of these can be used as arguments to methods that accept a Realm model class.");
        }
        Class superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(irs.class)) ? cls : superclass;
    }

    public static boolean O000000o(String str) {
        return str == null || str.length() == 0;
    }
}
