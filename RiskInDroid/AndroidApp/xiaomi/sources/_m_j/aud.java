package _m_j;

import android.graphics.Bitmap;
import android.graphics.RectF;

public final class aud {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12618O000000o;
    public Bitmap O00000Oo;
    public boolean O00000o;
    public RectF O00000o0;
    public int O00000oO;

    public aud(int i, Bitmap bitmap, RectF rectF, boolean z, int i2) {
        this.f12618O000000o = i;
        this.O00000Oo = bitmap;
        this.O00000o0 = rectF;
        this.O00000o = z;
        this.O00000oO = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aud)) {
            return false;
        }
        aud aud = (aud) obj;
        if (aud.f12618O000000o == this.f12618O000000o && aud.O00000o0.left == this.O00000o0.left && aud.O00000o0.right == this.O00000o0.right && aud.O00000o0.top == this.O00000o0.top && aud.O00000o0.bottom == this.O00000o0.bottom) {
            return true;
        }
        return false;
    }
}
