package _m_j;

import android.util.Log;

public final class dnb extends dnc {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14803O000000o;

    public dnb(String str) {
        this.f14803O000000o = str;
    }

    public final void O000000o(dnc dnc) {
        if (dnc != null) {
            this.f14803O000000o = new String(((dnb) dnc).f14803O000000o);
        } else {
            Log.e("StrValue_TMTEST", "value is null");
        }
    }

    /* renamed from: O000000o */
    public final dnc clone() {
        return O00000Oo.O000000o(this.f14803O000000o);
    }

    public final Class<?> O00000Oo() {
        return String.class;
    }

    public final Object O00000o0() {
        return this.f14803O000000o;
    }

    public final String toString() {
        return "value type:string, value:" + this.f14803O000000o;
    }
}
