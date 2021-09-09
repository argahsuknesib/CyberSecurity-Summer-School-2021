package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public final class izy extends jad {

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f1686O000000o;
    protected float O00000Oo;
    protected float O00000o;
    protected float O00000o0;
    private int O0000o0o;

    public izy() {
        this.O00000oo = 172;
        this.O0000o0 = 0.0f;
        this.O0000o0O = 0.78f;
    }

    public final void O000000o(Canvas canvas, Paint paint) {
        int O000000o2 = O000000o(paint, this.O00000oO);
        if (paint.getAlpha() > 0) {
            canvas.drawColor(paint.getColor());
        }
        if (this.O0000OoO > 0.0f) {
            if (O000000o2 < 255) {
                int alpha = paint.getAlpha();
                O000000o2 = alpha > O000000o2 ? 0 : ((O000000o2 - alpha) * 255) / (255 - alpha);
            }
            paint.setAlpha(O000000o2);
            O000000o(paint, this.O0000o0o);
            if (paint.getAlpha() > 0) {
                canvas.drawCircle(this.O00000o0, this.O00000o, this.O0000OoO, paint);
            }
        }
    }

    public final void O000000o(float f) {
        super.O000000o(f);
        this.O00000o0 = this.f1686O000000o + ((this.O0000Ooo - this.f1686O000000o) * f);
        this.O00000o = this.O00000Oo + ((this.O0000o00 - this.O00000Oo) * f);
    }

    public final void O00000Oo(float f) {
        super.O00000Oo(f);
        this.O0000OoO = this.O0000Oo;
        this.O0000o0o = 255 - ((int) (f * 255.0f));
    }

    public final void O000000o(float f, float f2) {
        this.f1686O000000o = f;
        this.O00000o0 = f;
        this.O00000Oo = f2;
        this.O00000o = f2;
        this.O0000o0o = 255;
    }
}
