package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
    public static final Rect INSETS_NONE = new Rect();
    private static Class<?> sInsetsClazz;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    private DrawableUtils() {
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        if (sInsetsClazz != null) {
            try {
                Drawable unwrap = DrawableCompat.unwrap(drawable);
                Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(unwrap, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : sInsetsClazz.getFields()) {
                        String name = field.getName();
                        char c = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            rect.left = field.getInt(invoke);
                        } else if (c == 1) {
                            rect.top = field.getInt(invoke);
                        } else if (c == 2) {
                            rect.right = field.getInt(invoke);
                        } else if (c == 3) {
                            rect.bottom = field.getInt(invoke);
                        }
                    }
                    return rect;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return INSETS_NONE;
    }

    static void fixDrawable(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        while (true) {
            if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
                return false;
            }
            if (drawable instanceof DrawableContainer) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                    return true;
                }
                for (Drawable canSafelyMutateDrawable : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!canSafelyMutateDrawable(canSafelyMutateDrawable)) {
                        return false;
                    }
                }
                return true;
            } else if (drawable instanceof DrawableWrapper) {
                drawable = ((DrawableWrapper) drawable).getWrappedDrawable();
            } else if (drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper) {
                drawable = ((android.support.v7.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable();
            } else if (!(drawable instanceof ScaleDrawable)) {
                return true;
            } else {
                drawable = ((ScaleDrawable) drawable).getDrawable();
            }
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(ThemeUtils.CHECKED_STATE_SET);
        } else {
            drawable.setState(ThemeUtils.EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return Build.VERSION.SDK_INT >= 11 ? PorterDuff.Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }
}
