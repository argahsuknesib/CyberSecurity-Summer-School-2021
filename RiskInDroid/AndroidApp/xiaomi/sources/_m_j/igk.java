package _m_j;

final class igk {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f1273O000000o;
    final int O00000Oo;
    final int O00000o;
    final int O00000o0;
    int O00000oO = -1;

    igk(int i, int i2, int i3, int i4) {
        this.f1273O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = i4;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return O000000o(this.O00000oO);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i) {
        return i != -1 && this.O00000o0 == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O00000oO = ((this.O00000o / 30) * 3) + (this.O00000o0 / 3);
    }

    /* access modifiers changed from: package-private */
    public final int O00000o0() {
        return this.O00000Oo - this.f1273O000000o;
    }

    public final String toString() {
        return this.O00000oO + "|" + this.O00000o;
    }
}
