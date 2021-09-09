package _m_j;

import android.view.animation.Interpolator;

public final class axd implements Interpolator {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float f12678O000000o;
    private final float O00000Oo;
    private final float O00000o0;

    public axd() {
        this((byte) 0);
    }

    private axd(byte b) {
        this.f12678O000000o = 0.3f;
        this.O00000Oo = 0.19999999f;
        this.O00000o0 = 2.5000002f;
    }

    public final float getInterpolation(float f) {
        if (Math.abs(f - 0.5f) < this.O00000Oo) {
            return (f - this.f12678O000000o) * this.O00000o0;
        }
        return f < 0.5f ? 0.0f : 1.0f;
    }
}
