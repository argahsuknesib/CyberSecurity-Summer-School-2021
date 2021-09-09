package _m_j;

import android.text.TextUtils;

public final class bxs {

    public static class O00000Oo {
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static String f13388O000000o = "";
        protected static O000000o O00000Oo;

        public static void O000000o() {
            if (O00000Oo == null) {
                O00000Oo = new O000000o();
            }
        }

        public static O000000o O00000Oo() {
            return O00000Oo;
        }

        public static String O00000o0() {
            if (!TextUtils.isEmpty(f13388O000000o)) {
                return f13388O000000o;
            }
            if (cdz.O00000Oo) {
                return cee.O000000o("account_sid_test");
            }
            return cee.O000000o("account_sid");
        }
    }
}
