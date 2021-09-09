package _m_j;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public abstract class izv extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1679O000000o = 255;
    public ColorStateList O0000Ooo;
    int O0000o00;

    /* access modifiers changed from: protected */
    public void O000000o(int i) {
    }

    public izv(ColorStateList colorStateList) {
        O000000o(colorStateList);
    }

    public boolean isStateful() {
        return this.O0000Ooo.isStateful() || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return O00000o0(this.O0000Ooo.getColorForState(iArr, this.O0000o00));
    }

    public int getAlpha() {
        return this.f1679O000000o;
    }

    public void setAlpha(int i) {
        this.f1679O000000o = i;
        invalidateSelf();
    }

    public final void O00000Oo(int i) {
        O000000o(ColorStateList.valueOf(i));
    }

    public void O000000o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.O0000Ooo = colorStateList;
        O00000o0(colorStateList.getColorForState(getState(), colorStateList.getDefaultColor()));
    }

    private boolean O00000o0(int i) {
        boolean z = this.O0000o00 != i;
        if (z) {
            this.O0000o00 = i;
            O000000o(i);
            invalidateSelf();
        }
        return z;
    }
}
