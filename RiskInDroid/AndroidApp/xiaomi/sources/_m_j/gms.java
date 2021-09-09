package _m_j;

import android.text.TextUtils;

public final class gms implements gmr {

    /* renamed from: O000000o  reason: collision with root package name */
    private gmr f18018O000000o;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static gms f18019O000000o = new gms((byte) 0);
    }

    /* synthetic */ gms(byte b) {
        this();
    }

    private gms() {
        this.f18018O000000o = new gmq();
    }

    public static gms O000000o() {
        return O000000o.f18019O000000o;
    }

    public final String O00000o0(String str, String str2) {
        return O000000o(O000000o(str), str2);
    }

    public final String O00000o(String str, String str2) {
        return O00000Oo(O000000o(str), str2);
    }

    public final String O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return this.f18018O000000o.O000000o(str, str2);
    }

    public final String O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return this.f18018O000000o.O00000Oo(str, str2);
    }

    private static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return String.format("%s.%s", "token.key", str);
    }
}
