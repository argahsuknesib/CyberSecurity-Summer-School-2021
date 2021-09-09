package _m_j;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public abstract class izo extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    public ColorStateList f1672O000000o;
    protected boolean O00000Oo = false;
    protected boolean O00000o = false;
    protected boolean O00000o0 = true;
    private int O00000oO;
    private int O00000oo = 255;

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, boolean z, boolean z2);

    public izo(ColorStateList colorStateList) {
        O000000o(colorStateList);
    }

    public final void O000000o(boolean z) {
        this.O00000o = z;
    }

    public boolean isStateful() {
        return this.f1672O000000o.isStateful() || super.isStateful();
    }

    public boolean setState(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean state = super.setState(iArr);
        boolean z = this.O00000Oo;
        boolean z2 = this.O00000o0;
        this.O00000Oo = false;
        this.O00000o0 = true;
        for (int i : iArr) {
            if (i == 16842912) {
                this.O00000Oo = true;
            } else if (i == -16842910) {
                this.O00000o0 = false;
            }
        }
        if (!(!state && z == this.O00000Oo && z2 == this.O00000o0)) {
            O000000o(O000000o(), z, this.O00000Oo);
            invalidateSelf();
        }
        return state;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int defaultColor = iArr == null ? this.f1672O000000o.getDefaultColor() : this.f1672O000000o.getColorForState(iArr, this.O00000oO);
        boolean z = this.O00000oO != defaultColor;
        if (z) {
            this.O00000oO = defaultColor;
        }
        return z;
    }

    public int getAlpha() {
        return this.O00000oo;
    }

    public void setAlpha(int i) {
        if (i != this.O00000oo) {
            this.O00000oo = i;
            onStateChange(getState());
        }
    }

    public final void O000000o(int i) {
        O000000o(ColorStateList.valueOf(i));
    }

    public final void O000000o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f1672O000000o = colorStateList;
        onStateChange(getState());
    }

    public final int O000000o() {
        return O00000Oo(this.O00000oO);
    }

    private int O00000Oo(int i) {
        int i2 = this.O00000oo;
        return i2 < 255 ? izh.O00000Oo(i, i2) : i;
    }
}
