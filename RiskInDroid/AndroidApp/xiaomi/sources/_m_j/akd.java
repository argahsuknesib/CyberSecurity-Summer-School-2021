package _m_j;

public abstract class akd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final akd f12415O000000o = new O000000o();

    public String O000000o(String str) {
        return str;
    }

    public String O00000Oo(String str) {
        return str;
    }

    public String O00000o(String str) {
        return str;
    }

    public String O00000o0(String str) {
        return str;
    }

    public static abstract class O00000Oo extends akd {
        public abstract String O00000oO(String str);

        public final String O000000o(String str) {
            return O00000oO(str);
        }

        public final String O00000Oo(String str) {
            return O00000oO(str);
        }

        public final String O00000o0(String str) {
            return O00000oO(str);
        }

        public final String O00000o(String str) {
            return O00000oO(str);
        }
    }

    public static class O000000o extends O00000Oo {
        public final String O00000oO(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (i2 > 0 || charAt != '_') {
                    if (Character.isUpperCase(charAt)) {
                        if (!z && i > 0 && sb.charAt(i - 1) != '_') {
                            sb.append('_');
                            i++;
                        }
                        charAt = Character.toLowerCase(charAt);
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(charAt);
                    i++;
                }
            }
            return i > 0 ? sb.toString() : str;
        }
    }
}
