package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.reflect.Field;

@SuppressLint({"RestrictedAPI"})
public final class OOOOOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Rect f12331O000000o = new Rect();
    private static final int[] O00000Oo = {16842912};
    private static Class<?> O00000o;
    private static final int[] O00000o0 = new int[0];

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                O00000o = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static Rect O000000o(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (O00000o != null) {
            try {
                Drawable O0000O0o = ab.O0000O0o(drawable);
                Object invoke = O0000O0o.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(O0000O0o, new Object[0]);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : O00000o.getFields()) {
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
                            rect2.left = field.getInt(invoke);
                        } else if (c == 1) {
                            rect2.top = field.getInt(invoke);
                        } else if (c == 2) {
                            rect2.right = field.getInt(invoke);
                        } else if (c == 3) {
                            rect2.bottom = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f12331O000000o;
    }

    static void O00000Oo(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(O00000Oo);
            } else {
                drawable.setState(O00000o0);
            }
            drawable.setState(state);
        }
    }

    public static boolean O00000o0(Drawable drawable) {
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
                for (Drawable O00000o02 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!O00000o0(O00000o02)) {
                        return false;
                    }
                }
                return true;
            } else if (drawable instanceof ad) {
                drawable = ((ad) drawable).O000000o();
            } else if (drawable instanceof OO000o) {
                drawable = ((OO000o) drawable).getWrappedDrawable();
            } else if (!(drawable instanceof ScaleDrawable)) {
                return true;
            } else {
                drawable = ((ScaleDrawable) drawable).getDrawable();
            }
        }
    }

    public static PorterDuff.Mode O000000o(int i, PorterDuff.Mode mode) {
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
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
