package _m_j;

import android.view.animation.Interpolator;
import java.util.Random;

public final class hfo implements hfp {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f18866O000000o = -1;
    private int O00000Oo = 0;
    private long O00000o;
    private long O00000o0;
    private float O00000oO;
    private float O00000oo;
    private Interpolator O0000O0o;

    public hfo(long j, long j2, Interpolator interpolator) {
        new Random();
        this.O00000o0 = j;
        this.O00000o = j2;
        this.O00000oO = (float) (this.O00000o - this.O00000o0);
        this.O00000oo = (float) (this.O00000Oo - this.f18866O000000o);
        this.O0000O0o = interpolator;
    }

    public final void O000000o(hfi hfi, long j) {
        if (this.f18866O000000o == -1) {
            this.f18866O000000o = hfi.O00000oo;
            this.O00000oo = (float) (this.O00000Oo - this.f18866O000000o);
        }
        int i = this.O00000Oo;
        int i2 = this.f18866O000000o;
        if (i == i2) {
            this.O00000oo = (float) i2;
        }
        long j2 = this.O00000o0;
        if (j < j2) {
            return;
        }
        if (j > this.O00000o) {
            hfi.O00000oo = this.O00000Oo;
            return;
        }
        hfi.O00000oo = (int) (((float) this.f18866O000000o) + (this.O00000oo * this.O0000O0o.getInterpolation((((float) (j - j2)) * 1.0f) / this.O00000oO)));
    }
}
