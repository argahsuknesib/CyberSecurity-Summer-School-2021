package _m_j;

public final class cpz implements Comparable<cpz> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f14222O000000o;
    public final int O00000Oo;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        cpz cpz = (cpz) obj;
        return (this.f14222O000000o * this.O00000Oo) - (cpz.f14222O000000o * cpz.O00000Oo);
    }

    cpz(int i, int i2) {
        this.f14222O000000o = i;
        this.O00000Oo = i2;
    }

    /* access modifiers changed from: package-private */
    public final cpz O000000o() {
        return new cpz(this.O00000Oo, this.f14222O000000o);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof cpz) {
            cpz cpz = (cpz) obj;
            return this.f14222O000000o == cpz.f14222O000000o && this.O00000Oo == cpz.O00000Oo;
        }
    }

    public final String toString() {
        return this.f14222O000000o + "x" + this.O00000Oo;
    }

    public final int hashCode() {
        int i = this.O00000Oo;
        int i2 = this.f14222O000000o;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
