package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

@GwtCompatible
public final class MoreObjects {
    public static <T> T firstNonNull(T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(String str) {
            this.holderHead = new ValueHolder();
            this.holderTail = this.holderHead;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public final ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, Object obj) {
            return addHolder(str, obj);
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, boolean z) {
            return addHolder(str, String.valueOf(z));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, char c) {
            return addHolder(str, String.valueOf(c));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, double d) {
            return addHolder(str, String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, float f) {
            return addHolder(str, String.valueOf(f));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, int i) {
            return addHolder(str, String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper add(String str, long j) {
            return addHolder(str, String.valueOf(j));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(Object obj) {
            return addHolder(obj);
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(boolean z) {
            return addHolder(String.valueOf(z));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(char c) {
            return addHolder(String.valueOf(c));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(double d) {
            return addHolder(String.valueOf(d));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(float f) {
            return addHolder(String.valueOf(f));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(int i) {
            return addHolder(String.valueOf(i));
        }

        @CanIgnoreReturnValue
        public final ToStringHelper addValue(long j) {
            return addHolder(String.valueOf(j));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
         arg types: [java.lang.String, int, int]
         candidates:
          ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
          ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
          ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
          ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
        public final String toString() {
            boolean z = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z || obj != null) {
                    sb.append(str);
                    if (valueHolder.name != null) {
                        sb.append(valueHolder.name);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
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

    private MoreObjects() {
    }
}
