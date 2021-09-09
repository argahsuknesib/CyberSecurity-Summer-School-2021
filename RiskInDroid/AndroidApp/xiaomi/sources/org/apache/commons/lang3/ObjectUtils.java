package org.apache.commons.lang3;

import java.io.Serializable;

public final class ObjectUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Null f15432O000000o = new Null();

    @Deprecated
    public static boolean O000000o(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.f15432O000000o;
        }
    }
}
