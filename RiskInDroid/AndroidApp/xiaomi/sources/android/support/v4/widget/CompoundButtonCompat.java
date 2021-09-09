package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
    private static final CompoundButtonCompatImpl IMPL;

    interface CompoundButtonCompatImpl {
        Drawable getButtonDrawable(CompoundButton compoundButton);

        ColorStateList getButtonTintList(CompoundButton compoundButton);

        PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton);

        void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList);

        void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            IMPL = new Api23CompoundButtonImpl();
        } else if (i >= 21) {
            IMPL = new LollipopCompoundButtonImpl();
        } else {
            IMPL = new BaseCompoundButtonCompat();
        }
    }

    static class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatGingerbread.setButtonTintList(compoundButton, colorStateList);
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatGingerbread.getButtonTintList(compoundButton);
        }

        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            CompoundButtonCompatGingerbread.setButtonTintMode(compoundButton, mode);
        }

        public PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatGingerbread.getButtonTintMode(compoundButton);
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatGingerbread.getButtonDrawable(compoundButton);
        }
    }

    static class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatLollipop.setButtonTintList(compoundButton, colorStateList);
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.getButtonTintList(compoundButton);
        }

        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            CompoundButtonCompatLollipop.setButtonTintMode(compoundButton, mode);
        }

        public PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.getButtonTintMode(compoundButton);
        }
    }

    static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatApi23.getButtonDrawable(compoundButton);
        }
    }

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        IMPL.setButtonTintList(compoundButton, colorStateList);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintList(compoundButton);
    }

    public static void setButtonTintMode(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        IMPL.setButtonTintMode(compoundButton, mode);
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintMode(compoundButton);
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }
}
