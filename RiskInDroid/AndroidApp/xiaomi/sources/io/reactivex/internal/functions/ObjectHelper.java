package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiObjectPredicate();

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> T requireNonNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return EQUALS;
    }

    public static int verifyPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    public static long verifyPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }

    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        public final boolean test(Object obj, Object obj2) {
            return ObjectHelper.equals(obj, obj2);
        }
    }

    @Deprecated
    public static long requireNonNull(long j, String str) {
        throw new InternalError("Null check on a primitive: ".concat(String.valueOf(str)));
    }
}
