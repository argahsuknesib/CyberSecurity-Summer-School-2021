package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
@RequiresApi(21)
class DrawableCompatLollipop {
    DrawableCompatLollipop() {
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void setTint(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        return !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperLollipop(drawable) : drawable;
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void clearColorFilter(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        while (true) {
            drawable.clearColorFilter();
            if (!(drawable instanceof InsetDrawable)) {
                if (!(drawable instanceof DrawableWrapper)) {
                    break;
                }
                drawable = ((DrawableWrapper) drawable).getWrappedDrawable();
            } else {
                drawable = ((InsetDrawable) drawable).getDrawable();
            }
        }
        if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Drawable child = drawableContainerState.getChild(i);
                if (child != null) {
                    clearColorFilter(child);
                }
            }
        }
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
