package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class jpi {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String[] f2020O000000o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<String> f2021O000000o = new ArrayList(20);

        private static void O00000o(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char charAt2 = str2.charAt(i2);
                        if (charAt2 <= 31 || charAt2 >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public final O000000o O000000o(String str) {
            int i = 0;
            while (i < this.f2021O000000o.size()) {
                if (str.equalsIgnoreCase(this.f2021O000000o.get(i))) {
                    this.f2021O000000o.remove(i);
                    this.f2021O000000o.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final O000000o O000000o(String str, String str2) {
            O00000o(str, str2);
            return O00000Oo(str, str2);
        }

        public final jpi O000000o() {
            return new jpi(this, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final O000000o O00000Oo(String str, String str2) {
            this.f2021O000000o.add(str);
            this.f2021O000000o.add(str2.trim());
            return this;
        }

        public final O000000o O00000o0(String str, String str2) {
            O00000o(str, str2);
            O000000o(str);
            O00000Oo(str, str2);
            return this;
        }
    }

    /* synthetic */ jpi(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public final String O000000o(int i) {
        return this.f2020O000000o[i * 2];
    }

    public final String O00000Oo(int i) {
        return this.f2020O000000o[(i * 2) + 1];
    }

    public final Date O00000Oo(String str) {
        String O000000o2 = O000000o(str);
        if (O000000o2 != null) {
            return jpx.O000000o(O000000o2);
        }
        return null;
    }

    private jpi(O000000o o000000o) {
        this.f2020O000000o = (String[]) o000000o.f2021O000000o.toArray(new String[o000000o.f2021O000000o.size()]);
    }

    public final String O000000o(String str) {
        String[] strArr = this.f2020O000000o;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final O000000o O000000o() {
        O000000o o000000o = new O000000o();
        Collections.addAll(o000000o.f2021O000000o, this.f2020O000000o);
        return o000000o;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f2020O000000o.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(O000000o(i));
            sb.append(": ");
            sb.append(O00000Oo(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
