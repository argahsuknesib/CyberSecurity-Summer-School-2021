package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

class OO000o0 extends Drawable implements Drawable.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f6710O000000o;
    int O00000Oo = -1;
    private Drawable O00000o;
    private Rect O00000o0;
    private Drawable O00000oO;
    private int O00000oo = 255;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private long O0000Oo;
    private Runnable O0000Oo0;
    private long O0000OoO;
    private O000000o O0000Ooo;

    OO000o0() {
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.O00000oO;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f6710O000000o.getChangingConfigurations();
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        O00000Oo o00000Oo = this.f6710O000000o;
        Rect rect2 = null;
        boolean z2 = true;
        if (!o00000Oo.O0000OoO) {
            if (o00000Oo.O0000o00 != null || o00000Oo.O0000Ooo) {
                rect2 = o00000Oo.O0000o00;
            } else {
                o00000Oo.O00000o0();
                Rect rect3 = new Rect();
                int i = o00000Oo.O0000Oo;
                Drawable[] drawableArr = o00000Oo.O0000Oo0;
                Rect rect4 = null;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect3)) {
                        if (rect4 == null) {
                            rect4 = new Rect(0, 0, 0, 0);
                        }
                        if (rect3.left > rect4.left) {
                            rect4.left = rect3.left;
                        }
                        if (rect3.top > rect4.top) {
                            rect4.top = rect3.top;
                        }
                        if (rect3.right > rect4.right) {
                            rect4.right = rect3.right;
                        }
                        if (rect3.bottom > rect4.bottom) {
                            rect4.bottom = rect3.bottom;
                        }
                    }
                }
                o00000Oo.O0000Ooo = true;
                o00000Oo.O0000o00 = rect4;
                rect2 = rect4;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.O00000o;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (!isAutoMirrored() || ab.O0000OOo(this) != 1) {
            z2 = false;
        }
        if (z2) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return z;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public void setAlpha(int i) {
        if (!this.O0000O0o || this.O00000oo != i) {
            this.O0000O0o = true;
            this.O00000oo = i;
            Drawable drawable = this.O00000o;
            if (drawable == null) {
                return;
            }
            if (this.O0000Oo == 0) {
                drawable.setAlpha(i);
            } else {
                O000000o(false);
            }
        }
    }

    public int getAlpha() {
        return this.O00000oo;
    }

    public void setDither(boolean z) {
        if (this.f6710O000000o.O00oOooO != z) {
            O00000Oo o00000Oo = this.f6710O000000o;
            o00000Oo.O00oOooO = z;
            Drawable drawable = this.O00000o;
            if (drawable != null) {
                drawable.setDither(o00000Oo.O00oOooO);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        O00000Oo o00000Oo = this.f6710O000000o;
        o00000Oo.O000O0o = true;
        if (o00000Oo.O000O0o0 != colorFilter) {
            this.f6710O000000o.O000O0o0 = colorFilter;
            Drawable drawable = this.O00000o;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        O00000Oo o00000Oo = this.f6710O000000o;
        o00000Oo.O000OO00 = true;
        if (o00000Oo.O000O0oO != colorStateList) {
            this.f6710O000000o.O000O0oO = colorStateList;
            ab.O000000o(this.O00000o, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        O00000Oo o00000Oo = this.f6710O000000o;
        o00000Oo.O000OO0o = true;
        if (o00000Oo.O000O0oo != mode) {
            this.f6710O000000o.O000O0oo = mode;
            ab.O000000o(this.O00000o, mode);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.O00000oO;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean isStateful() {
        O00000Oo o00000Oo = this.f6710O000000o;
        if (o00000Oo.O0000oo0) {
            return o00000Oo.O0000oo;
        }
        o00000Oo.O00000o0();
        int i = o00000Oo.O0000Oo;
        Drawable[] drawableArr = o00000Oo.O0000Oo0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            } else if (drawableArr[i2].isStateful()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        o00000Oo.O0000oo = z;
        o00000Oo.O0000oo0 = true;
        return z;
    }

    public void setAutoMirrored(boolean z) {
        if (this.f6710O000000o.O00oOoOo != z) {
            O00000Oo o00000Oo = this.f6710O000000o;
            o00000Oo.O00oOoOo = z;
            Drawable drawable = this.O00000o;
            if (drawable != null) {
                ab.O000000o(drawable, o00000Oo.O00oOoOo);
            }
        }
    }

    public boolean isAutoMirrored() {
        return this.f6710O000000o.O00oOoOo;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.O00000oO;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.O00000oO = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.O0000O0o) {
                this.O00000o.setAlpha(this.O00000oo);
            }
        }
        if (this.O0000OoO != 0) {
            this.O0000OoO = 0;
            z = true;
        }
        if (this.O0000Oo != 0) {
            this.O0000Oo = 0;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            ab.O000000o(drawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.O00000o0;
        if (rect == null) {
            this.O00000o0 = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            ab.O000000o(drawable, i, i2, i3, i4);
        }
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.O00000o0;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.O00000oO;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.O00000oO;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    public boolean onLayoutDirectionChanged(int i) {
        O00000Oo o00000Oo = this.f6710O000000o;
        int i2 = this.O00000Oo;
        int i3 = o00000Oo.O0000Oo;
        Drawable[] drawableArr = o00000Oo.O0000Oo0;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            if (drawableArr[i4] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        o00000Oo.O000O00o = i;
        return z;
    }

    public int getIntrinsicWidth() {
        if (this.f6710O000000o.O0000o0) {
            O00000Oo o00000Oo = this.f6710O000000o;
            if (!o00000Oo.O0000o0O) {
                o00000Oo.O00000o();
            }
            return o00000Oo.O0000o0o;
        }
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getIntrinsicHeight() {
        if (this.f6710O000000o.O0000o0) {
            O00000Oo o00000Oo = this.f6710O000000o;
            if (!o00000Oo.O0000o0O) {
                o00000Oo.O00000o();
            }
            return o00000Oo.O0000o;
        }
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getMinimumWidth() {
        if (this.f6710O000000o.O0000o0) {
            O00000Oo o00000Oo = this.f6710O000000o;
            if (!o00000Oo.O0000o0O) {
                o00000Oo.O00000o();
            }
            return o00000Oo.O0000oO0;
        }
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getMinimumHeight() {
        if (this.f6710O000000o.O0000o0) {
            O00000Oo o00000Oo = this.f6710O000000o;
            if (!o00000Oo.O0000o0O) {
                o00000Oo.O00000o();
            }
            return o00000Oo.O0000oO;
        }
        Drawable drawable = this.O00000o;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        O00000Oo o00000Oo = this.f6710O000000o;
        if (o00000Oo != null) {
            o00000Oo.O00000Oo();
        }
        if (drawable == this.O00000o && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.O00000o && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.O00000o && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.O00000oO;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public int getOpacity() {
        Drawable drawable = this.O00000o;
        int i = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        O00000Oo o00000Oo = this.f6710O000000o;
        if (o00000Oo.O0000oOO) {
            return o00000Oo.O0000oOo;
        }
        o00000Oo.O00000o0();
        int i2 = o00000Oo.O0000Oo;
        Drawable[] drawableArr = o00000Oo.O0000Oo0;
        if (i2 > 0) {
            i = drawableArr[0].getOpacity();
        }
        int i3 = i;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 = Drawable.resolveOpacity(i3, drawableArr[i4].getOpacity());
        }
        o00000Oo.O0000oOo = i3;
        o00000Oo.O0000oOO = true;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i) {
        if (i == this.O00000Oo) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f6710O000000o.O000O0Oo > 0) {
            Drawable drawable = this.O00000oO;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.O00000o;
            if (drawable2 != null) {
                this.O00000oO = drawable2;
                this.O0000OoO = ((long) this.f6710O000000o.O000O0Oo) + uptimeMillis;
            } else {
                this.O00000oO = null;
                this.O0000OoO = 0;
            }
        } else {
            Drawable drawable3 = this.O00000o;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i < 0 || i >= this.f6710O000000o.O0000Oo) {
            this.O00000o = null;
            this.O00000Oo = -1;
        } else {
            Drawable O00000Oo2 = this.f6710O000000o.O00000Oo(i);
            this.O00000o = O00000Oo2;
            this.O00000Oo = i;
            if (O00000Oo2 != null) {
                if (this.f6710O000000o.O000O0OO > 0) {
                    this.O0000Oo = uptimeMillis + ((long) this.f6710O000000o.O000O0OO);
                }
                O000000o(O00000Oo2);
            }
        }
        if (!(this.O0000Oo == 0 && this.O0000OoO == 0)) {
            Runnable runnable = this.O0000Oo0;
            if (runnable == null) {
                this.O0000Oo0 = new Runnable() {
                    /* class _m_j.OO000o0.AnonymousClass1 */

                    public final void run() {
                        OO000o0.this.O000000o(true);
                        OO000o0.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            O000000o(true);
        }
        invalidateSelf();
        return true;
    }

    private void O000000o(Drawable drawable) {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new O000000o();
        }
        O000000o o000000o = this.O0000Ooo;
        o000000o.f6712O000000o = drawable.getCallback();
        drawable.setCallback(o000000o);
        try {
            if (this.f6710O000000o.O000O0OO <= 0 && this.O0000O0o) {
                drawable.setAlpha(this.O00000oo);
            }
            if (this.f6710O000000o.O000O0o) {
                drawable.setColorFilter(this.f6710O000000o.O000O0o0);
            } else {
                if (this.f6710O000000o.O000OO00) {
                    ab.O000000o(drawable, this.f6710O000000o.O000O0oO);
                }
                if (this.f6710O000000o.O000OO0o) {
                    ab.O000000o(drawable, this.f6710O000000o.O000O0oo);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f6710O000000o.O00oOooO);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f6710O000000o.O00oOoOo);
            }
            Rect rect = this.O00000o0;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.O0000Ooo.O000000o());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void O000000o(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.O0000O0o = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.O00000o;
        if (drawable2 != null) {
            long j = this.O0000Oo;
            if (j != 0) {
                if (j <= uptimeMillis) {
                    drawable2.setAlpha(this.O00000oo);
                } else {
                    this.O00000o.setAlpha(((255 - (((int) ((j - uptimeMillis) * 255)) / this.f6710O000000o.O000O0OO)) * this.O00000oo) / 255);
                    z2 = true;
                    drawable = this.O00000oO;
                    if (drawable != null) {
                        long j2 = this.O0000OoO;
                        if (j2 != 0) {
                            if (j2 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.O00000oO = null;
                            } else {
                                this.O00000oO.setAlpha(((((int) ((j2 - uptimeMillis) * 255)) / this.f6710O000000o.O000O0Oo) * this.O00000oo) / 255);
                                if (!z && z3) {
                                    scheduleSelf(this.O0000Oo0, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                        z3 = z2;
                        if (!z) {
                            return;
                        }
                        return;
                    }
                    this.O0000OoO = 0;
                    z3 = z2;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            drawable = this.O00000oO;
            if (drawable != null) {
            }
            this.O0000OoO = 0;
            z3 = z2;
            if (!z) {
            }
        }
        this.O0000Oo = 0;
        z2 = false;
        drawable = this.O00000oO;
        if (drawable != null) {
        }
        this.O0000OoO = 0;
        z3 = z2;
        if (!z) {
        }
    }

    public Drawable getCurrent() {
        return this.O00000o;
    }

    public void applyTheme(Resources.Theme theme) {
        O00000Oo o00000Oo = this.f6710O000000o;
        if (theme != null) {
            o00000Oo.O00000o0();
            int i = o00000Oo.O0000Oo;
            Drawable[] drawableArr = o00000Oo.O0000Oo0;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                    drawableArr[i2].applyTheme(theme);
                    o00000Oo.O0000O0o |= drawableArr[i2].getChangingConfigurations();
                }
            }
            o00000Oo.O000000o(theme.getResources());
        }
    }

    public boolean canApplyTheme() {
        return this.f6710O000000o.canApplyTheme();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f6710O000000o.O00000oO()) {
            return null;
        }
        this.f6710O000000o.O00000oo = getChangingConfigurations();
        return this.f6710O000000o;
    }

    public Drawable mutate() {
        if (!this.O0000OOo && super.mutate() == this) {
            O00000Oo O00000Oo2 = O00000Oo();
            O00000Oo2.O000000o();
            O000000o(O00000Oo2);
            this.O0000OOo = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public O00000Oo O00000Oo() {
        return this.f6710O000000o;
    }

    static abstract class O00000Oo extends Drawable.ConstantState {
        Resources O00000o;
        final OO000o0 O00000o0;
        int O00000oO = 160;
        int O00000oo;
        int O0000O0o;
        SparseArray<Drawable.ConstantState> O0000OOo;
        int O0000Oo;
        Drawable[] O0000Oo0;
        boolean O0000OoO;
        boolean O0000Ooo;
        int O0000o;
        boolean O0000o0;
        Rect O0000o00;
        boolean O0000o0O;
        int O0000o0o;
        int O0000oO;
        int O0000oO0;
        boolean O0000oOO;
        int O0000oOo;
        boolean O0000oo;
        boolean O0000oo0;
        boolean O0000ooO;
        boolean O0000ooo;
        int O000O00o;
        int O000O0OO;
        int O000O0Oo;
        boolean O000O0o;
        ColorFilter O000O0o0;
        ColorStateList O000O0oO;
        PorterDuff.Mode O000O0oo;
        boolean O000OO00;
        boolean O000OO0o;
        boolean O00oOoOo;
        boolean O00oOooO;
        boolean O00oOooo;

        O00000Oo(O00000Oo o00000Oo, OO000o0 oO000o0, Resources resources) {
            Resources resources2;
            this.O0000OoO = false;
            this.O0000o0 = false;
            this.O00oOooO = true;
            this.O000O0OO = 0;
            this.O000O0Oo = 0;
            this.O00000o0 = oO000o0;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = o00000Oo != null ? o00000Oo.O00000o : null;
            }
            this.O00000o = resources2;
            this.O00000oO = OO000o0.O000000o(resources, o00000Oo != null ? o00000Oo.O00000oO : 0);
            if (o00000Oo != null) {
                this.O00000oo = o00000Oo.O00000oo;
                this.O0000O0o = o00000Oo.O0000O0o;
                this.O0000ooO = true;
                this.O0000ooo = true;
                this.O0000OoO = o00000Oo.O0000OoO;
                this.O0000o0 = o00000Oo.O0000o0;
                this.O00oOooO = o00000Oo.O00oOooO;
                this.O00oOooo = o00000Oo.O00oOooo;
                this.O000O00o = o00000Oo.O000O00o;
                this.O000O0OO = o00000Oo.O000O0OO;
                this.O000O0Oo = o00000Oo.O000O0Oo;
                this.O00oOoOo = o00000Oo.O00oOoOo;
                this.O000O0o0 = o00000Oo.O000O0o0;
                this.O000O0o = o00000Oo.O000O0o;
                this.O000O0oO = o00000Oo.O000O0oO;
                this.O000O0oo = o00000Oo.O000O0oo;
                this.O000OO00 = o00000Oo.O000OO00;
                this.O000OO0o = o00000Oo.O000OO0o;
                if (o00000Oo.O00000oO == this.O00000oO) {
                    if (o00000Oo.O0000Ooo) {
                        this.O0000o00 = new Rect(o00000Oo.O0000o00);
                        this.O0000Ooo = true;
                    }
                    if (o00000Oo.O0000o0O) {
                        this.O0000o0o = o00000Oo.O0000o0o;
                        this.O0000o = o00000Oo.O0000o;
                        this.O0000oO0 = o00000Oo.O0000oO0;
                        this.O0000oO = o00000Oo.O0000oO;
                        this.O0000o0O = true;
                    }
                }
                if (o00000Oo.O0000oOO) {
                    this.O0000oOo = o00000Oo.O0000oOo;
                    this.O0000oOO = true;
                }
                if (o00000Oo.O0000oo0) {
                    this.O0000oo = o00000Oo.O0000oo;
                    this.O0000oo0 = true;
                }
                Drawable[] drawableArr = o00000Oo.O0000Oo0;
                this.O0000Oo0 = new Drawable[drawableArr.length];
                this.O0000Oo = o00000Oo.O0000Oo;
                SparseArray<Drawable.ConstantState> sparseArray = o00000Oo.O0000OOo;
                if (sparseArray != null) {
                    this.O0000OOo = sparseArray.clone();
                } else {
                    this.O0000OOo = new SparseArray<>(this.O0000Oo);
                }
                int i = this.O0000Oo;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.O0000OOo.put(i2, constantState);
                        } else {
                            this.O0000Oo0[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.O0000Oo0 = new Drawable[10];
            this.O0000Oo = 0;
        }

        public int getChangingConfigurations() {
            return this.O00000oo | this.O0000O0o;
        }

        public final int O000000o(Drawable drawable) {
            int i = this.O0000Oo;
            if (i >= this.O0000Oo0.length) {
                O00000Oo(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.O00000o0);
            this.O0000Oo0[i] = drawable;
            this.O0000Oo++;
            this.O0000O0o = drawable.getChangingConfigurations() | this.O0000O0o;
            O00000Oo();
            this.O0000o00 = null;
            this.O0000Ooo = false;
            this.O0000o0O = false;
            this.O0000ooO = false;
            return i;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            this.O0000oOO = false;
            this.O0000oo0 = false;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            SparseArray<Drawable.ConstantState> sparseArray = this.O0000OOo;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.O0000Oo0[this.O0000OOo.keyAt(i)] = O00000Oo(this.O0000OOo.valueAt(i).newDrawable(this.O00000o));
                }
                this.O0000OOo = null;
            }
        }

        private Drawable O00000Oo(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.O000O00o);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.O00000o0);
            return mutate;
        }

        public final Drawable O00000Oo(int i) {
            int indexOfKey;
            Drawable drawable = this.O0000Oo0[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.O0000OOo;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable O00000Oo = O00000Oo(this.O0000OOo.valueAt(indexOfKey).newDrawable(this.O00000o));
            this.O0000Oo0[i] = O00000Oo;
            this.O0000OOo.removeAt(indexOfKey);
            if (this.O0000OOo.size() == 0) {
                this.O0000OOo = null;
            }
            return O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Resources resources) {
            if (resources != null) {
                this.O00000o = resources;
                int O000000o2 = OO000o0.O000000o(resources, this.O00000oO);
                int i = this.O00000oO;
                this.O00000oO = O000000o2;
                if (i != O000000o2) {
                    this.O0000o0O = false;
                    this.O0000Ooo = false;
                }
            }
        }

        public boolean canApplyTheme() {
            int i = this.O0000Oo;
            Drawable[] drawableArr = this.O0000Oo0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.O0000OOo.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void O000000o() {
            int i = this.O0000Oo;
            Drawable[] drawableArr = this.O0000Oo0;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.O00oOooo = true;
        }

        /* access modifiers changed from: package-private */
        public void O00000o() {
            this.O0000o0O = true;
            O00000o0();
            int i = this.O0000Oo;
            Drawable[] drawableArr = this.O0000Oo0;
            this.O0000o = -1;
            this.O0000o0o = -1;
            this.O0000oO = 0;
            this.O0000oO0 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.O0000o0o) {
                    this.O0000o0o = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.O0000o) {
                    this.O0000o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.O0000oO0) {
                    this.O0000oO0 = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.O0000oO) {
                    this.O0000oO = minimumHeight;
                }
            }
        }

        public void O00000Oo(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.O0000Oo0, 0, drawableArr, 0, i);
            this.O0000Oo0 = drawableArr;
        }

        public final synchronized boolean O00000oO() {
            if (this.O0000ooO) {
                return this.O0000ooo;
            }
            O00000o0();
            this.O0000ooO = true;
            int i = this.O0000Oo;
            Drawable[] drawableArr = this.O0000Oo0;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.O0000ooo = false;
                    return false;
                }
            }
            this.O0000ooo = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void O000000o(O00000Oo o00000Oo) {
        this.f6710O000000o = o00000Oo;
        int i = this.O00000Oo;
        if (i >= 0) {
            this.O00000o = o00000Oo.O00000Oo(i);
            Drawable drawable = this.O00000o;
            if (drawable != null) {
                O000000o(drawable);
            }
        }
        this.O00000oO = null;
    }

    static class O000000o implements Drawable.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        Drawable.Callback f6712O000000o;

        public final void invalidateDrawable(Drawable drawable) {
        }

        O000000o() {
        }

        public final Drawable.Callback O000000o() {
            Drawable.Callback callback = this.f6712O000000o;
            this.f6712O000000o = null;
            return callback;
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f6712O000000o;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f6712O000000o;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int O000000o(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
