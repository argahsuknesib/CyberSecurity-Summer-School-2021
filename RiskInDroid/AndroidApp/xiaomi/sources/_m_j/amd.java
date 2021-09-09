package _m_j;

import java.io.IOException;

public final class amd {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Object f12452O000000o;
    public Object O00000Oo;

    public amd(Object obj) {
        this.f12452O000000o = obj;
    }

    public final void O000000o(Object obj) throws IOException {
        if (this.O00000Oo == null) {
            this.O00000Oo = obj;
            return;
        }
        throw new IllegalStateException("Already had POJO for id (" + this.f12452O000000o.getClass().getName() + ") [" + this.f12452O000000o + "]");
    }
}
