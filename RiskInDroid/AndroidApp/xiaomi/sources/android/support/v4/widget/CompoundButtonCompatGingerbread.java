package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

@TargetApi(9)
@RequiresApi(9)
class CompoundButtonCompatGingerbread {
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    CompoundButtonCompatGingerbread() {
    }

    static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintMode();
        }
        return null;
    }

    static Drawable getButtonDrawable(CompoundButton compoundButton) {
        if (!sButtonDrawableFieldFetched) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to retrieve mButtonDrawable field", e);
            }
            sButtonDrawableFieldFetched = true;
        }
        Field field = sButtonDrawableField;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to get button drawable via reflection", e2);
                sButtonDrawableField = null;
            }
        }
        return null;
    }
}
