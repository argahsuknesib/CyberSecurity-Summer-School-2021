package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

final class af extends ae {
    private static Method O00000o;

    af(Drawable drawable) {
        super(drawable);
        O00000o0();
    }

    af(ag agVar, Resources resources) {
        super(agVar, resources);
        O00000o0();
    }

    public final void setHotspot(float f, float f2) {
        this.O00000o0.setHotspot(f, f2);
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.O00000o0.setHotspotBounds(i, i2, i3, i4);
    }

    public final void getOutline(Outline outline) {
        this.O00000o0.getOutline(outline);
    }

    public final Rect getDirtyBounds() {
        return this.O00000o0.getDirtyBounds();
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (O00000Oo()) {
            super.setTintList(colorStateList);
        } else {
            this.O00000o0.setTintList(colorStateList);
        }
    }

    public final void setTint(int i) {
        if (O00000Oo()) {
            super.setTint(i);
        } else {
            this.O00000o0.setTint(i);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (O00000Oo()) {
            super.setTintMode(mode);
        } else {
            this.O00000o0.setTintMode(mode);
        }
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.O00000o0;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public final boolean isProjected() {
        Method method;
        if (!(this.O00000o0 == null || (method = O00000o) == null)) {
            try {
                return ((Boolean) method.invoke(this.O00000o0, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    private static void O00000o0() {
        if (O00000o == null) {
            try {
                O00000o = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
