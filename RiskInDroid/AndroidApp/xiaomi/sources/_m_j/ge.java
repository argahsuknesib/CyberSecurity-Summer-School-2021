package _m_j;

import _m_j.gb;
import android.text.TextUtils;

class ge {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f17580O000000o = gb.f17476O000000o;

    static class O000000o implements gb.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f17581O000000o;
        private int O00000Oo;
        private int O00000o0;

        O000000o(String str, int i, int i2) {
            this.f17581O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return TextUtils.equals(this.f17581O000000o, o000000o.f17581O000000o) && this.O00000Oo == o000000o.O00000Oo && this.O00000o0 == o000000o.O00000o0;
        }

        public final int hashCode() {
            return bd.O000000o(this.f17581O000000o, Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0));
        }
    }
}
