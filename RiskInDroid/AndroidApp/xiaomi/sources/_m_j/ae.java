package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class ae extends Drawable implements ac, ad, Drawable.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    static final PorterDuff.Mode f12365O000000o = PorterDuff.Mode.SRC_IN;
    ag O00000Oo;
    private int O00000o;
    Drawable O00000o0;
    private PorterDuff.Mode O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;

    /* access modifiers changed from: protected */
    public boolean O00000Oo() {
        return true;
    }

    ae(ag agVar, Resources resources) {
        this.O00000Oo = agVar;
        ag agVar2 = this.O00000Oo;
        if (agVar2 != null && agVar2.O00000Oo != null) {
            O000000o(this.O00000Oo.O00000Oo.newDrawable(resources));
        }
    }

    ae(Drawable drawable) {
        this.O00000Oo = O00000o0();
        O000000o(drawable);
    }

    public void jumpToCurrentState() {
        this.O00000o0.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.O00000o0.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.O00000o0.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        ag agVar = this.O00000Oo;
        return changingConfigurations | (agVar != null ? agVar.getChangingConfigurations() : 0) | this.O00000o0.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.O00000o0.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.O00000o0.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.O00000o0.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.O00000o0.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ag agVar;
        ColorStateList colorStateList = (!O00000Oo() || (agVar = this.O00000Oo) == null) ? null : agVar.O00000o0;
        return (colorStateList != null && colorStateList.isStateful()) || this.O00000o0.isStateful();
    }

    public boolean setState(int[] iArr) {
        return O000000o(iArr) || this.O00000o0.setState(iArr);
    }

    public int[] getState() {
        return this.O00000o0.getState();
    }

    public Drawable getCurrent() {
        return this.O00000o0.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.O00000o0.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.O00000o0.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.O00000o0.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.O00000o0.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.O00000o0.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.O00000o0.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.O00000o0.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.O00000o0.getPadding(rect);
    }

    public void setAutoMirrored(boolean z) {
        this.O00000o0.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.O00000o0.isAutoMirrored();
    }

    public Drawable.ConstantState getConstantState() {
        ag agVar = this.O00000Oo;
        if (agVar == null) {
            return null;
        }
        if (!(agVar.O00000Oo != null)) {
            return null;
        }
        this.O00000Oo.f12379O000000o = getChangingConfigurations();
        return this.O00000Oo;
    }

    public Drawable mutate() {
        if (!this.O0000O0o && super.mutate() == this) {
            this.O00000Oo = O00000o0();
            Drawable drawable = this.O00000o0;
            if (drawable != null) {
                drawable.mutate();
            }
            ag agVar = this.O00000Oo;
            if (agVar != null) {
                Drawable drawable2 = this.O00000o0;
                agVar.O00000Oo = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.O0000O0o = true;
        }
        return this;
    }

    private ag O00000o0() {
        return new ag(this.O00000Oo);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.O00000o0.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.O00000Oo.O00000o0 = colorStateList;
        O000000o(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.O00000Oo.O00000o = mode;
        O000000o(getState());
    }

    private boolean O000000o(int[] iArr) {
        if (!O00000Oo()) {
            return false;
        }
        ColorStateList colorStateList = this.O00000Oo.O00000o0;
        PorterDuff.Mode mode = this.O00000Oo.O00000o;
        if (colorStateList == null || mode == null) {
            this.O00000oo = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.O00000oo && colorForState == this.O00000o && mode == this.O00000oO)) {
                setColorFilter(colorForState, mode);
                this.O00000o = colorForState;
                this.O00000oO = mode;
                this.O00000oo = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable O000000o() {
        return this.O00000o0;
    }

    public final void O000000o(Drawable drawable) {
        Drawable drawable2 = this.O00000o0;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.O00000o0 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            ag agVar = this.O00000Oo;
            if (agVar != null) {
                agVar.O00000Oo = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
