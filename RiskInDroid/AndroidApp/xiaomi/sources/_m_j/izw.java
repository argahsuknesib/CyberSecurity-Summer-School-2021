package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public abstract class izw extends izv {

    /* renamed from: O000000o  reason: collision with root package name */
    private PorterDuffColorFilter f1680O000000o;
    private ColorStateList O00000Oo = null;
    private PorterDuff.Mode O00000o0 = PorterDuff.Mode.SRC_IN;
    protected final Paint O0000o0 = new Paint(1);

    public abstract void O000000o(Canvas canvas, Paint paint);

    public izw(ColorStateList colorStateList) {
        super(colorStateList);
        this.O0000o0.setColor(this.O0000o00);
        this.f1680O000000o = O000000o(this.f1680O000000o, this.O00000Oo, this.O00000o0);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.O0000o0;
        if (paint != null && paint.getColorFilter() != colorFilter) {
            paint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        Paint paint = this.O0000o0;
        if (paint.getXfermode() != null) {
            return -3;
        }
        int alpha = paint.getAlpha();
        if (alpha == 0) {
            return -2;
        }
        return alpha == 255 ? -1 : -3;
    }

    public void setDither(boolean z) {
        this.O0000o0.setDither(z);
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.O00000Oo != colorStateList) {
            this.O00000Oo = colorStateList;
            this.f1680O000000o = O000000o(this.f1680O000000o, colorStateList, this.O00000o0);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2 = this.O00000o0;
        if (mode != mode2 || mode.compareTo((Enum) mode2) != 0) {
            this.O00000o0 = mode;
            this.f1680O000000o = O000000o(this.f1680O000000o, this.O00000Oo, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.O00000Oo;
        return colorStateList != null && colorStateList.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.O00000Oo;
        if (colorStateList == null || (mode = this.O00000o0) == null) {
            return onStateChange;
        }
        this.f1680O000000o = O000000o(this.f1680O000000o, colorStateList, mode);
        return true;
    }

    /* access modifiers changed from: protected */
    public void O000000o(int i) {
        Paint paint = this.O0000o0;
        if (paint != null && paint.getColor() != i) {
            paint.setColor(i);
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.O0000o0;
        int alpha = paint.getAlpha();
        paint.setAlpha(izh.O000000o(alpha, getAlpha()));
        if (!(paint.getAlpha() == 0 && paint.getXfermode() == null)) {
            if (this.f1680O000000o == null || paint.getColorFilter() != null) {
                z = false;
            } else {
                paint.setColorFilter(this.f1680O000000o);
                z = true;
            }
            O000000o(canvas, this.O0000o0);
            if (z) {
                paint.setColorFilter(null);
            }
        }
        paint.setAlpha(alpha);
    }

    public final Paint O00000o() {
        return this.O0000o0;
    }

    private PorterDuffColorFilter O000000o(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (porterDuffColorFilter == null) {
            return new PorterDuffColorFilter(colorForState, mode);
        }
        try {
            Class<?> cls = porterDuffColorFilter.getClass();
            cls.getMethod("setColor", Integer.class).invoke(porterDuffColorFilter, Integer.valueOf(colorForState));
            cls.getMethod("setMode", PorterDuff.Mode.class).invoke(porterDuffColorFilter, mode);
            return porterDuffColorFilter;
        } catch (Exception unused) {
            return new PorterDuffColorFilter(colorForState, mode);
        }
    }
}
