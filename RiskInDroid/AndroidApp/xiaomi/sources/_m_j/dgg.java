package _m_j;

import android.content.Context;

public abstract class dgg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f14601O000000o = null;

    protected dgg(Context context) {
        this.f14601O000000o = context;
    }

    public final void O000000o(dgf dgf) {
        if (dgf != null) {
            String dgf2 = dgf.toString();
            if (O000000o()) {
                O000000o(dgi.O00000o(dgf2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(String str);

    /* access modifiers changed from: protected */
    public abstract boolean O000000o();

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    public final dgf O00000o0() {
        String O00000o0 = O000000o() ? dgi.O00000o0(O00000Oo()) : null;
        if (O00000o0 != null) {
            return dgf.O000000o(O00000o0);
        }
        return null;
    }
}
