package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;

public final class ize {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1664O000000o = 0;
    public int O00000Oo = 0;
    public float O00000o;
    public float[] O00000o0;
    private RectF O00000oO;
    private Paint O00000oo = new Paint(1);
    private Paint O0000O0o = new Paint(1);
    private Path O0000OOo;
    private izd O0000Oo;
    private Path O0000Oo0;

    public ize() {
        this.O00000oo.setStyle(Paint.Style.STROKE);
        this.O0000OOo = new Path();
        this.O0000Oo0 = new Path();
        this.O0000Oo = new izd();
        this.O00000oO = new RectF();
    }

    public final void O000000o(Rect rect) {
        this.O00000oO.set(((float) rect.left) - 0.5f, ((float) rect.top) - 0.5f, ((float) rect.right) + 0.5f, ((float) rect.bottom) + 0.5f);
        float f = this.f1664O000000o != 0 && this.O00000Oo != 0 ? 0.5f + (((float) this.f1664O000000o) / 2.0f) : 0.5f;
        this.O0000OOo = O000000o(this.O0000OOo, this.O00000oO, this.O00000o0, this.O00000o, f, f);
        Path path = this.O0000Oo0;
        if (path != null) {
            path.reset();
        } else {
            this.O0000Oo0 = new Path();
        }
        this.O0000Oo0.addRect(this.O00000oO, Path.Direction.CW);
        this.O0000Oo0.op(this.O0000OOo, Path.Op.DIFFERENCE);
    }

    private Path O000000o(Path path, RectF rectF, float[] fArr, float f, float f2, float f3) {
        if (fArr == null) {
            this.O0000Oo.O000000o(rectF, f, f2, f3);
        } else {
            this.O0000Oo.O000000o(rectF, fArr, f2, f3);
        }
        return this.O0000Oo.O000000o(path);
    }

    public final void O000000o(Canvas canvas, Xfermode xfermode) {
        this.O0000O0o.setXfermode(xfermode);
        canvas.drawPath(this.O0000Oo0, this.O0000O0o);
        this.O0000O0o.setXfermode(null);
    }

    public final void O000000o(Canvas canvas) {
        if ((this.f1664O000000o == 0 || this.O00000Oo == 0) ? false : true) {
            canvas.save();
            this.O00000oo.setStrokeWidth((float) this.f1664O000000o);
            this.O00000oo.setColor(this.O00000Oo);
            canvas.drawPath(this.O0000OOo, this.O00000oo);
            canvas.restore();
        }
    }
}
