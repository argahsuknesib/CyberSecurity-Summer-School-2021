package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public final class izj {
    public static void O000000o(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static int O000000o(Resources resources, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i, null);
        }
        return resources.getColor(i);
    }

    public static ColorStateList O00000Oo(Resources resources, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, null);
        }
        return resources.getColorStateList(i);
    }
}
