package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class o0O0O0Oo extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    float f2235O000000o;
    float O00000Oo;
    private final Paint O00000o;
    ColorStateList O00000o0;
    private final RectF O00000oO;
    private final Rect O00000oo;
    private boolean O0000O0o = false;
    private boolean O0000OOo = true;
    private ColorStateList O0000Oo;
    private PorterDuffColorFilter O0000Oo0;
    private PorterDuff.Mode O0000OoO = PorterDuff.Mode.SRC_IN;

    public final int getOpacity() {
        return -3;
    }

    o0O0O0Oo(ColorStateList colorStateList, float f) {
        this.f2235O000000o = f;
        this.O00000o = new Paint(5);
        O000000o(colorStateList);
        this.O00000oO = new RectF();
        this.O00000oo = new Rect();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.O00000o0 = colorStateList;
        this.O00000o.setColor(this.O00000o0.getColorForState(getState(), this.O00000o0.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f, boolean z, boolean z2) {
        if (f != this.O00000Oo || this.O0000O0o != z || this.O0000OOo != z2) {
            this.O00000Oo = f;
            this.O0000O0o = z;
            this.O0000OOo = z2;
            O000000o((Rect) null);
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.O00000o;
        if (this.O0000Oo0 == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.O0000Oo0);
            z = true;
        }
        RectF rectF = this.O00000oO;
        float f = this.f2235O000000o;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.O00000oO.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.O00000oo.set(rect);
        if (this.O0000O0o) {
            float O000000o2 = o0O0O0o0.O000000o(this.O00000Oo, this.f2235O000000o, this.O0000OOo);
            this.O00000oo.inset((int) Math.ceil((double) o0O0O0o0.O00000Oo(this.O00000Oo, this.f2235O000000o, this.O0000OOo)), (int) Math.ceil((double) O000000o2));
            this.O00000oO.set(this.O00000oo);
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        O000000o(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.O00000oo, this.f2235O000000o);
    }

    public final void setAlpha(int i) {
        this.O00000o.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O00000o.setColorFilter(colorFilter);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.O0000Oo = colorStateList;
        this.O0000Oo0 = O000000o(this.O0000Oo, this.O0000OoO);
        invalidateSelf();
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.O0000OoO = mode;
        this.O0000Oo0 = O000000o(this.O0000Oo, this.O0000OoO);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.O00000o0;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.O00000o.getColor();
        if (z) {
            this.O00000o.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.O0000Oo;
        if (colorStateList2 == null || (mode = this.O0000OoO) == null) {
            return z;
        }
        this.O0000Oo0 = O000000o(colorStateList2, mode);
        return true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.O0000Oo;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.O00000o0;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter O000000o(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
