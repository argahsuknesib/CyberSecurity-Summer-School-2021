package com.facebook.common.internal;

import java.util.Arrays;

public final class Objects {
    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(simpleName(obj.getClass()));
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(simpleName(cls));
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }

    private static String simpleName(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static <T> T firstNonNull(T t, T t2) {
        return t != null ? t : Preconditions.checkNotNull(t2);
    }

    public static final class ToStringHelper {
        private final String className;
        private ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(String str) {
            this.holderHead = new ValueHolder();
            this.holderTail = this.holderHead;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public final ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public final ToStringHelper add(String str, Object obj) {
            return addHolder(str, obj);
        }

        public final ToStringHelper add(String str, boolean z) {
            return addHolder(str, String.valueOf(z));
        }

        public final ToStringHelper add(String str, char c) {
            return addHolder(str, String.valueOf(c));
        }

        public final ToStringHelper add(String str, double d) {
            return addHolder(str, String.valueOf(d));
        }

        public final ToStringHelper add(String str, float f) {
            return addHolder(str, String.valueOf(f));
        }

        public final ToStringHelper add(String str, int i) {
            return addHolder(str, String.valueOf(i));
        }

        public final ToStringHelper add(String str, long j) {
            return addHolder(str, String.valueOf(j));
        }

        public final ToStringHelper addValue(Object obj) {
            return addHolder(obj);
        }

        public final ToStringHelper addValue(boolean z) {
            return addHolder(String.valueOf(z));
        }

        public final ToStringHelper addValue(char c) {
            return addHolder(String.valueOf(c));
        }

        public final ToStringHelper addValue(double d) {
            return addHolder(String.valueOf(d));
        }

        public final ToStringHelper addValue(float f) {
            return addHolder(String.valueOf(f));
        }

        public final ToStringHelper addValue(int i) {
            return addHolder(String.valueOf(i));
        }

        public final ToStringHelper addValue(long j) {
            return addHolder(String.valueOf(j));
        }

        public final String toString() {
            boolean z = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                if (!z || valueHolder.value != null) {
                    sb.append(str);
                    if (valueHolder.name != null) {
                        sb.append(valueHolder.name);
                        sb.append('=');
                    }
                    sb.append(valueHolder.value);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(Object obj) {
            addHolder().value = obj;
            return this;
        }

        private ToStringHelper addHolder(String str, Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        static final class ValueHolder {
            String name;
            ValueHolder next;
            Object value;

            private ValueHolder() {
            }
        }
    }
}
