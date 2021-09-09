package _m_j;

import java.util.Arrays;

final class jno implements jnn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f1975O000000o = {'#', '&', '+', '-', '.', '@', '_'};
    private static final char[] O00000Oo = {',', '.'};
    private int O00000o = -1;
    private int O00000o0 = -1;
    private int O00000oO = -1;
    private int O00000oo = -1;
    private int O0000O0o = -1;
    private int O0000OOo = -1;

    jno() {
        Arrays.sort(f1975O000000o);
        Arrays.sort(O00000Oo);
    }

    public final void O000000o() {
        this.O00000o0 = -1;
        this.O00000o = -1;
        this.O00000oO = -1;
        this.O00000oo = -1;
        this.O0000O0o = -1;
        this.O0000OOo = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if ((java.util.Arrays.binarySearch(_m_j.jno.O00000Oo, r10.O000000o()) >= 0) == false) goto L_0x0098;
     */
    public final void O000000o(jnh jnh) {
        boolean z = true;
        if (this.O00000oO == -1) {
            if (2 == jnh.O00000Oo()) {
                this.O00000oO = jnh.O00000o;
                this.O00000oo = this.O00000oO;
            }
        } else if (2 == jnh.O00000Oo()) {
            this.O00000oo = jnh.O00000o;
        } else {
            int i = jnh.O00000o0;
            int i2 = this.O00000oO;
            jnh.O000000o(new jnp(i, i2, (this.O00000oo - i2) + 1, 1));
            this.O00000oO = -1;
            this.O00000oo = -1;
        }
        if (!(!jnh.O00000o0() || this.O00000oO == -1 || this.O00000oo == -1)) {
            int i3 = jnh.O00000o0;
            int i4 = this.O00000oO;
            jnh.O000000o(new jnp(i3, i4, (this.O00000oo - i4) + 1, 1));
            this.O00000oO = -1;
            this.O00000oo = -1;
        }
        boolean z2 = (this.O00000oO == -1 && this.O00000oo == -1) ? false : true;
        if (this.O0000O0o == -1) {
            if (1 == jnh.O00000Oo()) {
                this.O0000O0o = jnh.O00000o;
                this.O0000OOo = this.O0000O0o;
            }
        } else if (1 == jnh.O00000Oo()) {
            this.O0000OOo = jnh.O00000o;
        } else {
            if (jnh.O00000Oo() == 0) {
            }
            int i5 = jnh.O00000o0;
            int i6 = this.O0000O0o;
            jnh.O000000o(new jnp(i5, i6, (this.O0000OOo - i6) + 1, 2));
            this.O0000O0o = -1;
            this.O0000OOo = -1;
        }
        if (!(!jnh.O00000o0() || this.O0000O0o == -1 || this.O0000OOo == -1)) {
            int i7 = jnh.O00000o0;
            int i8 = this.O0000O0o;
            jnh.O000000o(new jnp(i7, i8, (this.O0000OOo - i8) + 1, 2));
            this.O0000O0o = -1;
            this.O0000OOo = -1;
        }
        boolean z3 = (this.O0000O0o != -1 || this.O0000OOo != -1) || z2;
        if (this.O00000o0 == -1) {
            if (1 == jnh.O00000Oo() || 2 == jnh.O00000Oo()) {
                this.O00000o0 = jnh.O00000o;
                this.O00000o = this.O00000o0;
            }
        } else if (1 == jnh.O00000Oo() || 2 == jnh.O00000Oo()) {
            this.O00000o = jnh.O00000o;
        } else {
            if (jnh.O00000Oo() == 0) {
                if (Arrays.binarySearch(f1975O000000o, jnh.O000000o()) >= 0) {
                    this.O00000o = jnh.O00000o;
                }
            }
            int i9 = jnh.O00000o0;
            int i10 = this.O00000o0;
            jnh.O000000o(new jnp(i9, i10, (this.O00000o - i10) + 1, 3));
            this.O00000o0 = -1;
            this.O00000o = -1;
        }
        if (!(!jnh.O00000o0() || this.O00000o0 == -1 || this.O00000o == -1)) {
            int i11 = jnh.O00000o0;
            int i12 = this.O00000o0;
            jnh.O000000o(new jnp(i11, i12, (this.O00000o - i12) + 1, 3));
            this.O00000o0 = -1;
            this.O00000o = -1;
        }
        if (!((this.O00000o0 == -1 && this.O00000o == -1) ? false : true) && !z3) {
            z = false;
        }
        if (z) {
            jnh.O000000o("LETTER_SEGMENTER");
        } else {
            jnh.O00000Oo("LETTER_SEGMENTER");
        }
    }
}
