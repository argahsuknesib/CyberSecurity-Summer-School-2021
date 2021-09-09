package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public final class jac extends jaa {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f1692O000000o;
    private float O00000Oo = 0.0f;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000Oo;
    private float O0000Oo0;
    private int O0000OoO = 255;
    private int O0000Ooo = 255;

    public final void O000000o(Canvas canvas, Paint paint) {
        if (this.O00000Oo != 0.0f) {
            O000000o(paint, this.O0000OoO);
            canvas.drawCircle(this.O0000Oo0, this.O0000Oo, this.O00000Oo, paint);
        }
    }

    public final void O000000o(float f) {
        this.O00000Oo = this.f1692O000000o * f;
        float f2 = this.O00000o0;
        this.O0000Oo0 = f2 + ((this.O00000oO - f2) * f);
        float f3 = this.O00000o;
        this.O0000Oo = f3 + ((this.O00000oo - f3) * f);
    }

    public final void O00000Oo(float f) {
        int i = this.O0000Ooo;
        this.O0000OoO = i - ((int) (((float) i) * f));
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(float f, float f2) {
        this.O00000oO = f / 2.0f;
        this.O00000oo = f2 / 2.0f;
        this.f1692O000000o = Math.min(f, f2) / 2.0f;
    }

    public final void O000000o(float f, float f2) {
        float f3 = f - this.O00000oO;
        float f4 = f2 - this.O00000oo;
        float sqrt = this.f1692O000000o / ((float) Math.sqrt((double) ((f3 * f3) + (f4 * f4))));
        if (sqrt < 1.0f) {
            float f5 = this.O00000oO + (f3 * sqrt);
            this.O00000o0 = f5;
            this.O0000Oo0 = f5;
            float f6 = this.O00000oo + (f4 * sqrt);
            this.O00000o = f6;
            this.O0000Oo = f6;
        } else {
            this.O00000o0 = f;
            this.O0000Oo0 = f;
            this.O00000o = f2;
            this.O0000Oo = f2;
        }
        this.O0000OoO = this.O0000Ooo;
    }
}
