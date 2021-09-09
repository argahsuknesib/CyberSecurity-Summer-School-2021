package _m_j;

public final class grf {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18179O000000o;
    public int O00000Oo;
    public float O00000o = 0.0f;
    public float O00000o0;
    public int O00000oO = 0;
    private int O00000oo;
    private float O0000O0o;
    private float O0000OOo = 0.5f;
    private int O0000Oo = 0;
    private boolean O0000Oo0 = false;

    public grf(int i, int i2, int i3) {
        if (i2 > 0) {
            this.f18179O000000o = Math.max(0, i);
            this.O00000oo = Math.max(0, i2);
            this.O00000Oo = Math.max(0, i3);
            int i4 = this.O00000oo;
            int i5 = this.f18179O000000o;
            this.O00000o0 = (float) (i4 - i5);
            int i6 = this.O00000Oo;
            this.O0000O0o = (float) (i5 - i6);
            this.O00000o = 0.0f;
            this.O00000oO = i5 - i6;
            this.O0000Oo = i5 - i4;
            return;
        }
        throw new IllegalArgumentException("maxHeight must > 0");
    }

    public final boolean O000000o() {
        return this.O00000o < ((float) this.O00000oO);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r0 > ((float) r1)) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r0 < ((float) r1)) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r0 > ((float) r1)) goto L_0x003e;
     */
    public final int O000000o(float f) {
        float f2;
        int i;
        float f3 = this.O00000o;
        if (f3 >= 0.0f) {
            f2 = f3 + f;
            if (f2 < 0.0f) {
                float f4 = this.O0000OOo;
                f2 *= f4;
                int i2 = this.O0000Oo;
                if (f2 < ((float) i2)) {
                    f -= (f2 - ((float) i2)) / f4;
                    f2 = (float) i2;
                }
            } else {
                i = this.O00000oO;
            }
            this.O00000o = f2;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O00000o);
            gsy.O00000Oo("PullHeaderLayout", sb.toString());
            return (int) f;
        }
        float f5 = this.O0000OOo;
        f2 = f3 + (f * f5);
        if (f2 > 0.0f) {
            f2 /= f5;
            i = this.O00000oO;
        } else {
            i = this.O0000Oo;
        }
        f -= f2 - ((float) i);
        f2 = (float) i;
        this.O00000o = f2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.O00000o);
        gsy.O00000Oo("PullHeaderLayout", sb2.toString());
        return (int) f;
    }

    public final boolean O00000Oo() {
        return this.O00000o < 0.0f;
    }
}
