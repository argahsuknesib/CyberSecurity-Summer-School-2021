package _m_j;

import android.animation.TimeInterpolator;

public final class gdl implements TimeInterpolator {
    public final float getInterpolation(float f) {
        double d = (double) f;
        Double.isNaN(d);
        return (float) ((Math.cos(d * 3.141592653589793d) - 1.0d) * -0.5d);
    }
}
