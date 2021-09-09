package _m_j;

import android.graphics.Bitmap;

public final class gra {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bitmap f18174O000000o;
    public int O00000Oo = 0;

    public gra(Bitmap bitmap) {
        this.f18174O000000o = bitmap;
    }

    private boolean O00000o0() {
        return (this.O00000Oo / 90) % 2 != 0;
    }

    public final int O000000o() {
        if (O00000o0()) {
            return this.f18174O000000o.getWidth();
        }
        return this.f18174O000000o.getHeight();
    }

    public final int O00000Oo() {
        if (O00000o0()) {
            return this.f18174O000000o.getHeight();
        }
        return this.f18174O000000o.getWidth();
    }
}
