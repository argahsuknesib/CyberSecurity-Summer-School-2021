package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public final class cu {
    public static ColorStateList O000000o(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof db) {
            return ((db) imageView).getSupportImageTintList();
        }
        return null;
    }

    public static void O000000o(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21 && (drawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof db) {
            ((db) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode O00000Oo(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof db) {
            return ((db) imageView).getSupportImageTintMode();
        }
        return null;
    }

    public static void O000000o(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21 && (drawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof db) {
            ((db) imageView).setSupportImageTintMode(mode);
        }
    }
}
