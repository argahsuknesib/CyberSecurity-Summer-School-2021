package com.xiaomi.youpin.common.util;

public final class ReflectUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Object f12054O000000o;

    public final int hashCode() {
        return this.f12054O000000o.hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ReflectUtils) && this.f12054O000000o.equals(((ReflectUtils) obj).f12054O000000o);
    }

    public final String toString() {
        return this.f12054O000000o.toString();
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }
}
