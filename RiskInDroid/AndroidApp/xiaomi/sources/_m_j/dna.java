package _m_j;

import android.util.Log;

public final class dna extends dnc {

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f14802O000000o;

    public dna(Object obj) {
        this.f14802O000000o = obj;
    }

    public final void O000000o(dnc dnc) {
        if (dnc != null) {
            this.f14802O000000o = ((dna) dnc).f14802O000000o;
        } else {
            Log.e("ObjValue_TMTEST", "value is null");
        }
    }

    /* renamed from: O000000o */
    public final dnc clone() {
        return O00000Oo.O000000o(this.f14802O000000o);
    }

    public final Class<?> O00000Oo() {
        return this.f14802O000000o.getClass();
    }

    public final Object O00000o0() {
        return this.f14802O000000o;
    }

    public final String toString() {
        return "value type:object, value:" + this.f14802O000000o;
    }
}
