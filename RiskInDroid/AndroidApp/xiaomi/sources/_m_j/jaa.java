package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class jaa {
    float O0000O0o;
    float O0000OOo;

    public abstract void O000000o(float f);

    public void O000000o(float f, float f2) {
    }

    public abstract void O000000o(Canvas canvas, Paint paint);

    public abstract void O00000Oo(float f);

    /* access modifiers changed from: protected */
    public void O00000o0(float f, float f2) {
    }

    public final void O00000Oo(float f, float f2) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (this.O0000O0o != f || this.O0000OOo != f2) {
            this.O0000O0o = f;
            this.O0000OOo = f2;
            O00000o0(f, f2);
        }
    }

    protected static int O000000o(Paint paint, int i) {
        int alpha = paint.getAlpha();
        paint.setAlpha(izh.O000000o(alpha, i));
        return alpha;
    }

    public final jaa O000000o() throws CloneNotSupportedException {
        return (jaa) super.clone();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (jaa) super.clone();
    }
}
