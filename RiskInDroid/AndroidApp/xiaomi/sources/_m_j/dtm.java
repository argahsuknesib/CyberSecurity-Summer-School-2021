package _m_j;

final class dtm {

    /* renamed from: O000000o  reason: collision with root package name */
    final dtb f14928O000000o;
    final boolean O00000Oo;

    dtm(dtb dtb, boolean z) {
        this.f14928O000000o = dtb;
        this.O00000Oo = z;
    }

    /* access modifiers changed from: package-private */
    public final dtm O000000o(dtb dtb) {
        if (dtb == this.f14928O000000o) {
            return this;
        }
        return new dtm(dtb, this.O00000Oo);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("${");
        sb.append(this.O00000Oo ? "?" : "");
        sb.append(this.f14928O000000o.O00000o());
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dtm) {
            dtm dtm = (dtm) obj;
            if (!dtm.f14928O000000o.equals(this.f14928O000000o) || dtm.O00000Oo != this.O00000Oo) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f14928O000000o.hashCode() + 41) * 41) + (this.O00000Oo ? 1 : 0)) * 41;
    }
}
