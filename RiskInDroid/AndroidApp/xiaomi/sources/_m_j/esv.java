package _m_j;

import android.text.TextUtils;
import java.util.Collection;

public final class esv {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final StringBuilder f15779O000000o;
        private final String O00000Oo;
        private final String O00000o0;

        public O000000o() {
            this(":", ",");
        }

        public O000000o(String str, String str2) {
            this.f15779O000000o = new StringBuilder();
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }

        public final O000000o O000000o(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f15779O000000o.length() > 0) {
                    this.f15779O000000o.append(this.O00000o0);
                }
                StringBuilder sb = this.f15779O000000o;
                sb.append(str);
                sb.append(this.O00000Oo);
                sb.append(obj);
            }
            return this;
        }

        public final String toString() {
            return this.f15779O000000o.toString();
        }
    }

    public static int O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static boolean O000000o(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
