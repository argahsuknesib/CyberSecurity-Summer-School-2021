package androidx.appcompat.graphics.drawable;

import _m_j.ab;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.R;

public class DrawerArrowDrawable extends Drawable {
    private static final float O00000Oo = ((float) Math.toRadians(45.0d));

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f2670O000000o = new Paint();
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private boolean O0000O0o;
    private final Path O0000OOo = new Path();
    private boolean O0000Oo = false;
    private final int O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private int O0000o00 = 2;

    public int getOpacity() {
        return -3;
    }

    public DrawerArrowDrawable(Context context) {
        this.f2670O000000o.setStyle(Paint.Style.STROKE);
        this.f2670O000000o.setStrokeJoin(Paint.Join.MITER);
        this.f2670O000000o.setStrokeCap(Paint.Cap.BUTT);
        this.f2670O000000o.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.arrowHeadLength, R.attr.arrowShaftLength, R.attr.barLength, R.attr.color, R.attr.drawableSize, R.attr.gapBetweenBars, R.attr.spinBars, R.attr.thickness}, R.attr.drawerArrowStyle, 2132738277);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != this.f2670O000000o.getColor()) {
            this.f2670O000000o.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(7, 0.0f);
        if (this.f2670O000000o.getStrokeWidth() != dimension) {
            this.f2670O000000o.setStrokeWidth(dimension);
            double d = (double) (dimension / 2.0f);
            double cos = Math.cos((double) O00000Oo);
            Double.isNaN(d);
            this.O0000Ooo = (float) (d * cos);
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(6, true);
        if (this.O0000O0o != z) {
            this.O0000O0o = z;
            invalidateSelf();
        }
        float round = (float) Math.round(obtainStyledAttributes.getDimension(5, 0.0f));
        if (round != this.O00000oo) {
            this.O00000oo = round;
            invalidateSelf();
        }
        this.O0000Oo0 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.O00000o = (float) Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.O00000o0 = (float) Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.O00000oO = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void O000000o(boolean z) {
        if (this.O0000Oo != z) {
            this.O0000Oo = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i = this.O0000o00;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? ab.O0000OOo(this) == 0 : ab.O0000OOo(this) == 1))) {
            z = true;
        }
        float f = this.O00000o0;
        float sqrt = (float) Math.sqrt((double) (f * f * 2.0f));
        float f2 = this.O00000o;
        float f3 = this.O0000OoO;
        float f4 = ((sqrt - f2) * f3) + f2;
        float f5 = f2 + ((this.O00000oO - f2) * f3);
        float round = (float) Math.round(((this.O0000Ooo - 0.0f) * f3) + 0.0f);
        float f6 = ((O00000Oo - 0.0f) * this.O0000OoO) + 0.0f;
        float f7 = z ? 0.0f : -180.0f;
        double d = (double) f4;
        float f8 = f7 + (((z ? 180.0f : 0.0f) - f7) * this.O0000OoO);
        double d2 = (double) f6;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d);
        double sin = Math.sin(d2);
        Double.isNaN(d);
        float round3 = (float) Math.round(d * sin);
        this.O0000OOo.rewind();
        float strokeWidth = this.O00000oo + this.f2670O000000o.getStrokeWidth();
        float f9 = strokeWidth + (((-this.O0000Ooo) - strokeWidth) * this.O0000OoO);
        float f10 = (-f5) / 2.0f;
        this.O0000OOo.moveTo(f10 + round, 0.0f);
        this.O0000OOo.rLineTo(f5 - (round * 2.0f), 0.0f);
        this.O0000OOo.moveTo(f10, f9);
        this.O0000OOo.rLineTo(round2, round3);
        this.O0000OOo.moveTo(f10, -f9);
        this.O0000OOo.rLineTo(round2, -round3);
        this.O0000OOo.close();
        canvas.save();
        float strokeWidth2 = this.f2670O000000o.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth2);
        float f11 = this.O00000oo;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f11))) / 4) * 2)) + (strokeWidth2 * 1.5f) + f11);
        if (this.O0000O0o) {
            canvas2.rotate(f8 * ((float) (this.O0000Oo ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.O0000OOo, this.f2670O000000o);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (i != this.f2670O000000o.getAlpha()) {
            this.f2670O000000o.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2670O000000o.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.O0000Oo0;
    }

    public int getIntrinsicWidth() {
        return this.O0000Oo0;
    }

    public final void O000000o(float f) {
        if (this.O0000OoO != f) {
            this.O0000OoO = f;
            invalidateSelf();
        }
    }
}
