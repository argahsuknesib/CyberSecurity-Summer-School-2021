package _m_j;

import java.util.Random;

public final class hfm implements hfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f18864O000000o;
    private float O00000Oo;

    public hfm(float f, float f2) {
        this.O00000Oo = f;
        this.f18864O000000o = f2;
    }

    public final void O000000o(hfi hfi, Random random) {
        float nextFloat = random.nextFloat();
        float f = this.f18864O000000o;
        float f2 = this.O00000Oo;
        float f3 = (nextFloat * (f - f2)) + f2;
        if (f3 < 0.2f) {
            hfi.O00000o = 0.0f;
        } else if (f3 > 0.4f) {
            hfi.O00000o = f3;
        } else {
            hfi.O00000o = (random.nextFloat() * 0.7f) + 0.5f;
        }
    }
}
