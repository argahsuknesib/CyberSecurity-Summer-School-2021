package _m_j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;

public final class gre extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18178O000000o = 0;
    private final String O00000Oo;
    private float O00000o = 0.0f;
    private final Paint O00000o0;
    private Paint.FontMetrics O00000oO;
    private Paint O00000oo;

    public final int getOpacity() {
        return -3;
    }

    public gre(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000Oo = str;
            this.O00000o0 = new Paint();
            this.O00000o0.setColor(-1);
            this.O00000o0.setTextSize((float) gri.O000000o(this.O00000Oo.length() < 2 ? 11.0f : 10.0f));
            this.O00000o0.setAntiAlias(true);
            this.O00000o0.setFakeBoldText(true);
            this.O00000o0.setStyle(Paint.Style.FILL);
            this.O00000o0.setTextAlign(Paint.Align.LEFT);
            this.O00000oO = this.O00000o0.getFontMetrics();
            this.O00000o = this.O00000o0.measureText(this.O00000Oo);
            return;
        }
        throw new IllegalArgumentException("text cannot be empty, please specify valid text");
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!(bounds == null || this.f18178O000000o == 0 || Build.VERSION.SDK_INT < 21)) {
            if (this.O00000oo == null) {
                this.O00000oo = new Paint();
                this.O00000oo.setColor(this.f18178O000000o);
                this.O00000oo.setAntiAlias(true);
            }
            gsy.O000000o(3, "hzd1", "getBounds height=" + bounds.height());
            if (this.O00000Oo.length() <= 2) {
                canvas.drawOval((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.O00000oo);
            } else {
                float min = (float) Math.min(bounds.width() / 2, bounds.height() / 2);
                float f = (float) bounds.left;
                float f2 = (float) bounds.top;
                float f3 = (float) bounds.right;
                float f4 = (float) bounds.bottom;
                Path path = new Path();
                float f5 = min < 0.0f ? 0.0f : min;
                if (min < 0.0f) {
                    min = 0.0f;
                }
                float f6 = f3 - f;
                float f7 = f4 - f2;
                float f8 = f6 / 2.0f;
                if (f5 > f8) {
                    f5 = f8;
                }
                float f9 = f7 / 2.0f;
                if (min > f9) {
                    min = f9;
                }
                float f10 = f6 - (f5 * 2.0f);
                float f11 = f7 - (min * 2.0f);
                path.moveTo(f3, f2 + min);
                float f12 = -min;
                float f13 = -f5;
                path.rQuadTo(0.0f, f12, f13, f12);
                path.rLineTo(-f10, 0.0f);
                path.rQuadTo(f13, 0.0f, f13, min);
                path.rLineTo(0.0f, f11);
                path.rQuadTo(0.0f, min, f5, min);
                path.rLineTo(f10, 0.0f);
                path.rQuadTo(f5, 0.0f, f5, f12);
                path.rLineTo(0.0f, -f11);
                path.close();
                canvas.drawPath(path, this.O00000oo);
            }
        }
        canvas.drawText(this.O00000Oo, (((float) bounds.width()) - this.O00000o) / 2.0f, (((((float) bounds.height()) - this.O00000oO.descent) - this.O00000oO.ascent) / 2.0f) + this.O00000oO.leading, this.O00000o0);
    }

    public final void setAlpha(int i) {
        this.O00000o0.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O00000o0.setColorFilter(colorFilter);
    }
}
