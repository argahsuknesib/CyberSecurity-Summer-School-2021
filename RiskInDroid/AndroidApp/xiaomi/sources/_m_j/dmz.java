package _m_j;

import android.util.Log;

public final class dmz extends dnc {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14800O000000o;

    public dmz(int i) {
        this.f14800O000000o = i;
    }

    public final void O000000o(dnc dnc) {
        if (dnc != null) {
            this.f14800O000000o = ((dmz) dnc).f14800O000000o;
        } else {
            Log.e("IntValue_TMTEST", "value is null");
        }
    }

    /* renamed from: O000000o */
    public final dnc clone() {
        return O00000Oo.O000000o(this.f14800O000000o);
    }

    public final Class<?> O00000Oo() {
        return Integer.TYPE;
    }

    public final Object O00000o0() {
        return Integer.valueOf(this.f14800O000000o);
    }

    public final String toString() {
        return String.format("value type:int, value:%d", Integer.valueOf(this.f14800O000000o));
    }
}
