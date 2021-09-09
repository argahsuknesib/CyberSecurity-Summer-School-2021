package _m_j;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

abstract class jv extends Drawable implements ac {
    Drawable O00000o0;

    jv() {
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            ab.O000000o(drawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            ab.O000000o(drawable, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            ab.O000000o(drawable, theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}
