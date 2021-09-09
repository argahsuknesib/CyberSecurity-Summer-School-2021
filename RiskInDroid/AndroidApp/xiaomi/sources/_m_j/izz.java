package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;

public class izz extends jaa {
    protected int O00000oO = 0;
    protected int O00000oo = 256;

    public void O000000o(Canvas canvas, Paint paint) {
        int i = this.O00000oO;
        if (i > 0) {
            O000000o(paint, i);
            canvas.drawColor(paint.getColor());
        }
    }

    public void O000000o(float f) {
        this.O00000oO = (int) (f * ((float) this.O00000oo));
    }

    public void O00000Oo(float f) {
        int i = this.O00000oo;
        this.O00000oO = i - ((int) (((float) i) * f));
    }
}
