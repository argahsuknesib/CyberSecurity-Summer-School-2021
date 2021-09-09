package _m_j;

import android.view.animation.Interpolator;

public final class czn implements Interpolator {
    public final float getInterpolation(float f) {
        if (f < 0.25f) {
            double d = (double) f;
            Double.isNaN(d);
            return (((float) Math.pow(d - 0.125d, 2.0d)) * -38.4f) + 0.6f;
        }
        double d2 = (double) f;
        if (d2 < 0.5d || d2 >= 0.75d) {
            return 0.0f;
        }
        Double.isNaN(d2);
        return (((float) Math.pow(d2 - 0.625d, 2.0d)) * -19.2f) + 0.3f;
    }
}
