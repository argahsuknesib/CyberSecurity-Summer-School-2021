package _m_j;

import java.util.ArrayList;
import java.util.List;

final class ifk {

    /* renamed from: O000000o  reason: collision with root package name */
    final List<ifj> f1259O000000o;
    final int O00000Oo;
    private final boolean O00000o0 = false;

    ifk(List<ifj> list, int i, boolean z) {
        this.f1259O000000o = new ArrayList(list);
        this.O00000Oo = i;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(List<ifj> list) {
        return this.f1259O000000o.equals(list);
    }

    public final String toString() {
        return "{ " + this.f1259O000000o + " }";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ifk)) {
            return false;
        }
        ifk ifk = (ifk) obj;
        if (!this.f1259O000000o.equals(ifk.f1259O000000o) || this.O00000o0 != ifk.O00000o0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f1259O000000o.hashCode() ^ Boolean.valueOf(this.O00000o0).hashCode();
    }
}
