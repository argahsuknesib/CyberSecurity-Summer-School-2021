package _m_j;

import android.graphics.Bitmap;

public final class cju {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13951O000000o = -1;
    public int O00000Oo;
    public int O00000o0;

    public static cju O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            return new cju(cjw.O000000o(bitmap), bitmap.getWidth(), bitmap.getHeight());
        }
        return null;
    }

    public static cju O000000o(int i, int i2) {
        return new cju(cjw.O000000o(), i, i2);
    }

    public cju(int i, int i2, int i3) {
        this.f13951O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
    }

    public final void O000000o() {
        cjw.O000000o(this.f13951O000000o);
        this.f13951O000000o = -1;
    }

    public final void O00000Oo(int i, int i2) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }
}
