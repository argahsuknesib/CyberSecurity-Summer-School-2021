package _m_j;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class cq {
    public static Interpolator O000000o(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2);
        }
        return new cp(f, f2);
    }
}
