package _m_j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class hhj extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18948O000000o;
    public int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO = 0;
    private int O00000oo = 100;
    private Paint O0000O0o;
    private Paint O0000OOo;

    public final int getOpacity() {
        return -1;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int O000000o() {
        return (int) (((float) (this.O00000o0 * this.f18948O000000o)) / ((float) (this.O00000oo - this.O00000oO)));
    }

    public final void O000000o(int i) {
        if (this.O0000O0o == null) {
            this.O0000O0o = new Paint(1);
            this.O0000O0o.setStyle(Paint.Style.FILL);
        }
        this.O0000O0o.setColor(i);
    }

    public final void O00000Oo(int i) {
        if (this.O0000OOo == null) {
            this.O0000OOo = new Paint(1);
            this.O0000OOo.setStyle(Paint.Style.FILL);
        }
        this.O0000OOo.setColor(i);
    }

    public final void O000000o(int i, int i2) {
        this.O00000oO = i;
        this.O00000oo = i2;
    }

    public final void draw(Canvas canvas) {
        if (this.O00000o0 == 0 || this.O00000o == 0) {
            Rect bounds = getBounds();
            this.O00000o0 = bounds.width();
            this.O00000o = bounds.height();
            this.O00000Oo = this.O00000o / 2;
        }
        int i = this.O00000Oo;
        RectF rectF = new RectF(0.0f, 0.0f, (float) (i * 2), (float) (i * 2));
        int i2 = this.O00000o0;
        RectF rectF2 = new RectF((float) (i2 - (this.O00000Oo * 2)), 0.0f, (float) i2, (float) this.O00000o);
        canvas.drawArc(rectF, 90.0f, 180.0f, false, this.O0000O0o);
        int i3 = this.O00000Oo;
        canvas.drawRect(new RectF((float) i3, 0.0f, (float) (this.O00000o0 - i3), (float) this.O00000o), this.O0000O0o);
        canvas.drawArc(rectF2, -90.0f, 180.0f, false, this.O0000O0o);
        int O000000o2 = O000000o();
        int i4 = this.O00000Oo;
        if (O000000o2 < i4) {
            int degrees = (int) Math.toDegrees(Math.acos((double) (((float) (i4 - O000000o2)) / ((float) i4))));
            int i5 = 180 - degrees;
            canvas.drawArc(rectF, (float) i5, (float) (degrees * 2), false, this.O0000OOo);
            return;
        }
        canvas.drawArc(rectF, 90.0f, 180.0f, false, this.O0000OOo);
        int i6 = this.O00000o0;
        int i7 = this.O00000Oo;
        if (O000000o2 < i6 - i7) {
            canvas.drawRect(new RectF((float) i7, 0.0f, (float) O000000o2, (float) this.O00000o), this.O0000OOo);
            return;
        }
        canvas.drawRect(new RectF((float) i7, 0.0f, (float) (i6 - i7), (float) this.O00000o), this.O0000OOo);
        int i8 = this.O00000Oo;
        int degrees2 = (int) Math.toDegrees(Math.acos((double) (((float) ((i8 - this.O00000o0) + O000000o2)) / ((float) i8))));
        Path path = new Path();
        path.addArc(rectF2, -90.0f, 180.0f);
        Path path2 = new Path();
        path2.addArc(rectF2, (float) degrees2, (float) (degrees2 * -2));
        path.op(path2, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.O0000OOo);
    }
}
