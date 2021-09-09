package _m_j;

import android.view.animation.Interpolator;

public final class das implements Interpolator {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final float f14420O000000o = (1.0f / O000000o(1.0f));
    private static final float O00000Oo = (1.0f - (f14420O000000o * O000000o(1.0f)));

    private static float O000000o(float f) {
        float f2 = f * 8.0f;
        if (f2 < 1.0f) {
            return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f);
    }

    public final float getInterpolation(float f) {
        float O000000o2 = f14420O000000o * O000000o(f);
        return O000000o2 > 0.0f ? O000000o2 + O00000Oo : O000000o2;
    }
}
