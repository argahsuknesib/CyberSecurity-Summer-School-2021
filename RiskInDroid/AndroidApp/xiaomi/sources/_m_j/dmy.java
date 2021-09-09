package _m_j;

import android.util.Log;

public final class dmy extends dnc {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f14799O000000o;

    public dmy(float f) {
        this.f14799O000000o = f;
    }

    public final void O000000o(dnc dnc) {
        if (dnc != null) {
            this.f14799O000000o = ((dmy) dnc).f14799O000000o;
        } else {
            Log.e("FloatValue_TMTEST", "value is null");
        }
    }

    /* renamed from: O000000o */
    public final dnc clone() {
        return O00000Oo.O000000o(this.f14799O000000o);
    }

    public final Class<?> O00000Oo() {
        return Float.TYPE;
    }

    public final Object O00000o0() {
        return Float.valueOf(this.f14799O000000o);
    }

    public final String toString() {
        return String.format("value type:float, value:%f", Float.valueOf(this.f14799O000000o));
    }
}
