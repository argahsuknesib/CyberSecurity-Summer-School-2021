package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects {

    public static final class ToStringHelper {
        private final List<String> zzul;
        private final Object zzum;

        private ToStringHelper(Object obj) {
            this.zzum = Preconditions.checkNotNull(obj);
            this.zzul = new ArrayList();
        }

        public final ToStringHelper add(String str, Object obj) {
            List<String> list = this.zzul;
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final ToStringHelper addValue(Object obj) {
            this.zzul.add(String.valueOf(obj));
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzum.getClass().getSimpleName());
            sb.append('{');
            int size = this.zzul.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.zzul.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
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
        return new ToStringHelper(obj);
    }
}
