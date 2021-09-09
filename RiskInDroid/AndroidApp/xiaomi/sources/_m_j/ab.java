package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ab {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f12354O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static Method O00000o0;

    public static void O000000o(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static boolean O000000o(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    public static void O000000o(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void O000000o(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static void O000000o(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof ac) {
            ((ac) drawable).setTint(i);
        }
    }

    public static void O000000o(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof ac) {
            ((ac) drawable).setTintList(colorStateList);
        }
    }

    public static void O000000o(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof ac) {
            ((ac) drawable).setTintMode(mode);
        }
    }

    public static int O00000Oo(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static void O000000o(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean O00000o0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static ColorFilter O00000o(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static void O00000oO(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        while (Build.VERSION.SDK_INT < 23 && Build.VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                drawable = ((InsetDrawable) drawable).getDrawable();
            } else if (drawable instanceof ad) {
                drawable = ((ad) drawable).O000000o();
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    Drawable child = drawableContainerState.getChild(i);
                    if (child != null) {
                        O00000oO(child);
                    }
                }
                return;
            } else {
                return;
            }
        }
        drawable.clearColorFilter();
    }

    public static void O000000o(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static Drawable O00000oo(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable;
        }
        return Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof ac) ? new af(drawable) : drawable : !(drawable instanceof ac) ? new ae(drawable) : drawable;
    }

    public static <T extends Drawable> T O0000O0o(Drawable drawable) {
        return drawable instanceof ad ? ((ad) drawable).O000000o() : drawable;
    }

    public static boolean O00000Oo(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!O00000Oo) {
                Class<Drawable> cls = Drawable.class;
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f12354O000000o = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                O00000Oo = true;
            }
            Method method = f12354O000000o;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f12354O000000o = null;
                }
            }
        }
        return false;
    }

    public static int O0000OOo(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!O00000o) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    O00000o0 = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                O00000o = true;
            }
            Method method = O00000o0;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    O00000o0 = null;
                }
            }
        }
        return 0;
    }
}
