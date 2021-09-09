package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class ct {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Field f14329O000000o;
    private static boolean O00000Oo;

    public static void O000000o(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof cz) {
            ((cz) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static ColorStateList O000000o(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof cz) {
            return ((cz) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static void O000000o(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof cz) {
            ((cz) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable O00000Oo(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!O00000Oo) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f14329O000000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            O00000Oo = true;
        }
        Field field = f14329O000000o;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f14329O000000o = null;
            }
        }
        return null;
    }
}
