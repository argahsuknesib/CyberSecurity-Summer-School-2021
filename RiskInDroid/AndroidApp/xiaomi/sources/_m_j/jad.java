package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public class jad extends izz {
    protected float O0000Oo;
    protected float O0000Oo0;
    protected float O0000OoO;
    protected float O0000Ooo;
    protected float O0000o0;
    protected float O0000o00;
    protected float O0000o0O;

    public jad() {
        this((byte) 0);
    }

    private jad(byte b) {
        this.O0000o0 = 0.68f;
        this.O0000o0O = 0.98f;
    }

    public void O000000o(Canvas canvas, Paint paint) {
        if (this.O0000OoO > 0.0f && this.O00000oO > 0) {
            O000000o(paint, this.O00000oO);
            canvas.drawCircle(this.O0000Ooo, this.O0000o00, this.O0000OoO, paint);
        }
    }

    public void O000000o(float f) {
        super.O000000o(f);
        float f2 = this.O0000Oo0;
        this.O0000OoO = f2 + ((this.O0000Oo - f2) * f);
    }

    public void O00000Oo(float f) {
        super.O00000Oo(f);
        float f2 = this.O0000Oo;
        this.O0000OoO = f2 + ((this.O0000Oo0 - f2) * f);
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(float f, float f2) {
        this.O0000Ooo = f / 2.0f;
        this.O0000o00 = f2 / 2.0f;
        O00000o0(Math.max(this.O0000Ooo, this.O0000o00));
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(float f) {
        this.O0000Oo0 = this.O0000o0 * f;
        this.O0000Oo = f * this.O0000o0O;
    }
}
