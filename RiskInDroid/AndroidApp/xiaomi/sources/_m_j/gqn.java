package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

public abstract class gqn extends ColorDrawable {

    /* renamed from: O000000o  reason: collision with root package name */
    private Path f18152O000000o = new Path();
    private RectF O00000Oo = new RectF();
    private int O00000o;
    private int O00000o0;
    private Paint O00000oO;

    /* access modifiers changed from: protected */
    public abstract float[] O000000o(Rect rect);

    public gqn(int i) {
        super(i);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.O00000Oo.set(bounds);
        int i = this.O00000o;
        if (i > 1) {
            float f = (float) (i / 2);
            this.O00000Oo.inset(f, f);
        }
        this.f18152O000000o.addRoundRect(this.O00000Oo, O000000o(bounds), Path.Direction.CW);
        canvas.clipPath(this.f18152O000000o);
        super.draw(canvas);
        if (this.O00000o0 != 0) {
            if (this.O00000oO == null) {
                this.O00000oO = new Paint();
            }
            this.O00000oO.setColor(this.O00000o0);
            this.O00000oO.setStrokeWidth((float) this.O00000o);
            canvas.drawPath(this.f18152O000000o, this.O00000oO);
        }
    }

    public static class O000000o extends gqn {
        public O000000o(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        public final float[] O000000o(Rect rect) {
            float[] fArr = new float[8];
            int min = Math.min(rect.height(), rect.width()) / 2;
            for (int i = 0; i < 8; i++) {
                fArr[i] = (float) min;
            }
            return fArr;
        }
    }
}
