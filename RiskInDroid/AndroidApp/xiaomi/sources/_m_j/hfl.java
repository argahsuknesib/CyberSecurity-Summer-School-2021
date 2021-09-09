package _m_j;

import java.util.Random;

public final class hfl implements hfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f18863O000000o = 0.0f;
    private float O00000Oo = 0.0f;

    public hfl(float f, float f2) {
    }

    public final void O000000o(hfi hfi, Random random) {
        float nextFloat = random.nextFloat();
        float f = this.O00000Oo;
        float f2 = this.f18863O000000o;
        hfi.O0000Oo = (nextFloat * (f - f2)) + f2;
    }
}
