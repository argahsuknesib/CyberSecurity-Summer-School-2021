package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public final class jae extends jad {

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f1693O000000o;
    protected float O00000Oo;

    public jae() {
        this.O0000o0 = 0.0f;
        this.O0000o0O = 1.0f;
    }

    public final void O000000o(Canvas canvas, Paint paint) {
        if (this.O0000OoO > 0.0f) {
            canvas.drawCircle(this.f1693O000000o, this.O00000Oo, this.O0000OoO, paint);
        } else if (this.O00000oO > 0) {
            O000000o(paint, this.O00000oO);
            canvas.drawColor(paint.getColor());
        }
    }

    public final void O00000Oo(float f) {
        super.O00000Oo(f);
        this.O0000OoO = 0.0f;
    }

    public final void O000000o(float f, float f2) {
        float f3;
        this.f1693O000000o = f;
        this.O00000Oo = f2;
        float f4 = 0.0f;
        if (f < this.O0000Ooo) {
            f3 = this.O0000O0o;
        } else {
            f3 = 0.0f;
        }
        if (f2 < this.O0000o00) {
            f4 = this.O0000OOo;
        }
        float f5 = f3 - f;
        float f6 = f4 - f2;
        O00000o0((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }
}
