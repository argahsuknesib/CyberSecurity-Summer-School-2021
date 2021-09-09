package _m_j;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class exk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final exk f15920O000000o = new O000000o();
    public static final exk O00000Oo = new O00000Oo();

    public static class O000000o extends exk {
        public final float O000000o(float f) {
            return f;
        }

        public final float O00000Oo(float f) {
            return f;
        }
    }

    public abstract float O000000o(float f);

    public abstract float O00000Oo(float f);

    public float O00000o0(float f) {
        return 1.0f;
    }

    public static exk O000000o(int i) {
        if (i == 0) {
            return O00000Oo;
        }
        if (i == 1) {
            return f15920O000000o;
        }
        throw new IllegalArgumentException("Unknown id: ".concat(String.valueOf(i)));
    }

    public static class O00000Oo extends exk {
        private final Interpolator O00000o;
        private final Interpolator O00000o0;

        public O00000Oo() {
            this((byte) 0);
        }

        private O00000Oo(byte b) {
            this.O00000o0 = new AccelerateInterpolator(3.0f);
            this.O00000o = new DecelerateInterpolator(3.0f);
        }

        public final float O000000o(float f) {
            return this.O00000o0.getInterpolation(f);
        }

        public final float O00000Oo(float f) {
            return this.O00000o.getInterpolation(f);
        }

        public final float O00000o0(float f) {
            return 1.0f / ((1.0f - O000000o(f)) + O00000Oo(f));
        }
    }
}
