package _m_j;

import java.util.Random;

public final class gks implements gkr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f17947O000000o;
    private float O00000Oo;

    public gks(float f, float f2) {
        this.O00000Oo = f;
        this.f17947O000000o = f2;
    }

    public final void O000000o(gkp gkp, Random random) {
        float nextFloat = random.nextFloat();
        float f = this.f17947O000000o;
        float f2 = this.O00000Oo;
        gkp.O00000o = (nextFloat * (f - f2)) + f2;
    }
}
