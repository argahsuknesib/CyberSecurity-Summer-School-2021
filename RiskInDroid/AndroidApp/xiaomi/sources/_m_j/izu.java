package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public abstract class izu extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f1678O000000o = new Paint(1);
    private int O00000Oo = 255;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    public ColorStateList O0000Ooo;
    public ColorStateList O0000o0;
    public ColorStateList O0000o00;

    public abstract void O000000o(Canvas canvas, Paint paint, int i, int i2, int i3);

    public int getOpacity() {
        return -3;
    }

    public izu(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        O000000o(colorStateList);
        O00000Oo(colorStateList2);
        O00000o0(colorStateList3);
    }

    public boolean isStateful() {
        return this.O0000Ooo.isStateful() || this.O0000o00.isStateful() || this.O0000o0.isStateful() || super.isStateful();
    }

    public void draw(Canvas canvas) {
        O000000o(canvas, this.f1678O000000o, this.O00000oo, this.O0000O0o, this.O0000OOo);
    }

    public boolean setState(int[] iArr) {
        boolean z;
        if (iArr == null) {
            return false;
        }
        boolean state = super.setState(iArr);
        int colorForState = this.O0000Ooo.getColorForState(iArr, this.O00000o0);
        int colorForState2 = this.O0000o00.getColorForState(iArr, this.O00000o);
        int colorForState3 = this.O0000o0.getColorForState(iArr, this.O00000oO);
        if (colorForState == this.O00000o0 && colorForState2 == this.O00000o && colorForState3 == this.O00000oO) {
            z = false;
        } else {
            this.O00000o0 = colorForState;
            this.O00000o = colorForState2;
            this.O00000oO = colorForState3;
            O000000o();
            invalidateSelf();
            z = true;
        }
        if (z || state) {
            return true;
        }
        return false;
    }

    public int getAlpha() {
        return this.O00000Oo;
    }

    public void setAlpha(int i) {
        this.O00000Oo = i;
        O000000o();
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1678O000000o.setColorFilter(colorFilter);
    }

    public final void O000000o(ColorStateList colorStateList) {
        this.O0000Ooo = colorStateList;
        this.O00000o0 = this.O0000Ooo.getDefaultColor();
        int i = this.O00000Oo;
        if (i < 255) {
            this.O00000oo = izh.O00000Oo(this.O00000o0, i);
        } else {
            this.O00000oo = this.O00000o0;
        }
    }

    public final void O00000Oo(ColorStateList colorStateList) {
        this.O0000o00 = colorStateList;
        this.O00000o = this.O0000o00.getDefaultColor();
        int i = this.O00000Oo;
        if (i < 255) {
            this.O0000O0o = izh.O00000Oo(this.O00000o, i);
        } else {
            this.O0000O0o = this.O00000o;
        }
    }

    public final void O00000o0(ColorStateList colorStateList) {
        this.O0000o0 = colorStateList;
        this.O00000oO = this.O0000o0.getDefaultColor();
        int i = this.O00000Oo;
        if (i < 255) {
            this.O0000OOo = izh.O00000Oo(this.O00000oO, i);
        } else {
            this.O0000OOo = this.O00000oO;
        }
    }

    private void O000000o() {
        int i = this.O00000Oo;
        if (i < 255) {
            this.O00000oo = izh.O00000Oo(this.O00000o0, i);
            this.O0000O0o = izh.O00000Oo(this.O00000o, this.O00000Oo);
            this.O0000OOo = izh.O00000Oo(this.O00000oO, this.O00000Oo);
            return;
        }
        this.O00000oo = this.O00000o0;
        this.O0000O0o = this.O00000o;
        this.O0000OOo = this.O00000oO;
    }
}
