package _m_j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;

public final class hhf extends GradientDrawable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18938O000000o = 0;
    public int O00000Oo = 100;
    public int O00000o = 10;
    public int O00000o0;
    public int O00000oO = 0;
    private Paint O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private Path O0000Oo;
    private int O0000Oo0;
    private Paint O0000OoO;
    private int O0000Ooo;
    private int O0000o00;

    public final int getOpacity() {
        return -1;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public hhf() {
        setGradientType(0);
        setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    }

    public final void O000000o(int i, int i2) {
        this.O0000Ooo = i;
        this.O0000o00 = i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [int, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    public final void draw(Canvas canvas) {
        if (this.O0000O0o == 0 || this.O0000OOo == 0) {
            Rect bounds = getBounds();
            this.O0000O0o = bounds.width();
            this.O0000OOo = bounds.height();
            this.O0000Oo0 = this.O0000OOo / 2;
            int i = this.O0000Oo0;
            RectF rectF = new RectF(0.0f, 0.0f, (float) (i * 2), (float) (i * 2));
            int i2 = this.O0000O0o;
            RectF rectF2 = new RectF((float) (i2 - (this.O0000Oo0 * 2)), 0.0f, (float) i2, (float) this.O0000OOo);
            int i3 = this.O0000Oo0;
            RectF rectF3 = new RectF((float) i3, 0.0f, (float) (this.O0000O0o - i3), (float) this.O0000OOo);
            this.O0000Oo = new Path();
            this.O0000Oo.addArc(rectF, 90.0f, 180.0f);
            this.O0000Oo.addRect(rectF3, Path.Direction.CCW);
            this.O0000Oo.addArc(rectF2, -90.0f, 180.0f);
            this.O0000OoO = new Paint(1);
            this.O00000oo = new Paint(1);
            this.O00000oo.setColor(-3355444);
            this.O00000oo.setStyle(Paint.Style.STROKE);
            this.O00000oo.setStrokeWidth(3.0f);
            this.O00000oo.setAlpha(150);
        }
        canvas.clipPath(this.O0000Oo);
        super.draw(canvas);
        canvas.save();
        int i4 = (int) (((float) (this.O0000O0o * this.O00000o0)) / ((float) (this.O00000Oo - this.f18938O000000o)));
        int i5 = this.O0000Oo0;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.O0000O0o;
        int i7 = this.O0000Oo0;
        if (i4 > i6 - i7) {
            i4 = i6 - i7;
        }
        this.O0000OoO.setShadowLayer(24.0f, 2.0f, 2.0f, 1145324612);
        this.O0000OoO.setAntiAlias(true);
        this.O0000OoO.setColor(this.O0000Ooo);
        float f = (float) i4;
        int i8 = this.O0000Oo0;
        float f2 = (float) i8;
        int i9 = this.O00000oO;
        canvas.drawCircle(f, f2, i9 == 0 ? (float) (i8 - 3) : (float) (i9 - 3), this.O0000OoO);
        int i10 = this.O0000Oo0;
        float f3 = (float) i10;
        int i11 = this.O00000oO;
        canvas.drawCircle(f, f3, i11 == 0 ? (float) (i10 - 3) : (float) (i11 - 3), this.O00000oo);
        this.O0000OoO.clearShadowLayer();
        this.O0000OoO.setColor(this.O0000o00);
        canvas.drawCircle(f, (float) this.O0000Oo0, (float) this.O00000o, this.O0000OoO);
        canvas.restore();
    }
}
