package _m_j;

public abstract class atb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final atb f12582O000000o = new atb() {
        /* class _m_j.atb.AnonymousClass1 */

        public final String O000000o(String str) {
            return str;
        }
    };

    public abstract String O000000o(String str);

    protected atb() {
    }

    public static atb O000000o(final String str, final String str2) {
        boolean z = true;
        boolean z2 = str != null && str.length() > 0;
        if (str2 == null || str2.length() <= 0) {
            z = false;
        }
        if (!z2) {
            return z ? new atb() {
                /* class _m_j.atb.AnonymousClass4 */

                public final String O000000o(String str) {
                    return str + str2;
                }

                public final String toString() {
                    return "[SuffixTransformer('" + str2 + "')]";
                }
            } : f12582O000000o;
        }
        if (z) {
            return new atb() {
                /* class _m_j.atb.AnonymousClass2 */

                public final String O000000o(String str) {
                    return str + str + str2;
                }

                public final String toString() {
                    return "[PreAndSuffixTransformer('" + str + "','" + str2 + "')]";
                }
            };
        }
        return new atb() {
            /* class _m_j.atb.AnonymousClass3 */

            public final String O000000o(String str) {
                return str + str;
            }

            public final String toString() {
                return "[PrefixTransformer('" + str + "')]";
            }
        };
    }

    public static atb O000000o(atb atb, atb atb2) {
        return new O000000o(atb, atb2);
    }

    public static class O000000o extends atb {
        protected final atb O00000Oo;
        protected final atb O00000o0;

        public O000000o(atb atb, atb atb2) {
            this.O00000Oo = atb;
            this.O00000o0 = atb2;
        }

        public final String O000000o(String str) {
            return this.O00000Oo.O000000o(this.O00000o0.O000000o(str));
        }

        public final String toString() {
            return "[ChainedTransformer(" + this.O00000Oo + ", " + this.O00000o0 + ")]";
        }
    }
}
