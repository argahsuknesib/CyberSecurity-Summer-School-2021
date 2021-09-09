package _m_j;

import _m_j.dt;

public final class dv extends dt<dv> {
    public dw O0000ooO = null;
    private float O0000ooo = Float.MAX_VALUE;
    private boolean O00oOooO = false;

    public <K> dv(K k, du<K> duVar) {
        super(k, duVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo(long j) {
        if (this.O00oOooO) {
            float f = this.O0000ooo;
            if (f != Float.MAX_VALUE) {
                this.O0000ooO.O00000oo = (double) f;
                this.O0000ooo = Float.MAX_VALUE;
            }
            this.O0000o0o = (float) this.O0000ooO.O00000oo;
            this.O0000o0O = 0.0f;
            this.O00oOooO = false;
            return true;
        }
        if (this.O0000ooo != Float.MAX_VALUE) {
            long j2 = j / 2;
            dt.O000000o O000000o2 = this.O0000ooO.O000000o((double) this.O0000o0o, (double) this.O0000o0O, j2);
            dw dwVar = this.O0000ooO;
            dwVar.O00000oo = (double) this.O0000ooo;
            this.O0000ooo = Float.MAX_VALUE;
            dt.O000000o O000000o3 = dwVar.O000000o((double) O000000o2.f14911O000000o, (double) O000000o2.O00000Oo, j2);
            this.O0000o0o = O000000o3.f14911O000000o;
            this.O0000o0O = O000000o3.O00000Oo;
        } else {
            dt.O000000o O000000o4 = this.O0000ooO.O000000o((double) this.O0000o0o, (double) this.O0000o0O, j);
            this.O0000o0o = O000000o4.f14911O000000o;
            this.O0000o0O = O000000o4.O00000Oo;
        }
        this.O0000o0o = Math.max(this.O0000o0o, this.O0000oo0);
        this.O0000o0o = Math.min(this.O0000o0o, this.O0000oOo);
        float f2 = this.O0000o0o;
        float f3 = this.O0000o0O;
        dw dwVar2 = this.O0000ooO;
        if (!(((double) Math.abs(f3)) < dwVar2.O00000oO && ((double) Math.abs(f2 - ((float) dwVar2.O00000oo))) < dwVar2.O00000o)) {
            return false;
        }
        this.O0000o0o = (float) this.O0000ooO.O00000oo;
        this.O0000o0O = 0.0f;
        return true;
    }

    public final void O000000o() {
        dw dwVar = this.O0000ooO;
        if (dwVar != null) {
            double d = (double) ((float) dwVar.O00000oo);
            if (d > ((double) this.O0000oOo)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (d >= ((double) this.O0000oo0)) {
                dw dwVar2 = this.O0000ooO;
                dwVar2.O00000o = Math.abs((double) (this.O0000oo * 0.75f));
                dwVar2.O00000oO = dwVar2.O00000o * 62.5d;
                super.O000000o();
            } else {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public final void O000000o(float f) {
        if (this.O0000oOO) {
            this.O0000ooo = f;
            return;
        }
        if (this.O0000ooO == null) {
            this.O0000ooO = new dw(f);
        }
        this.O0000ooO.O00000oo = (double) f;
        O000000o();
    }
}
