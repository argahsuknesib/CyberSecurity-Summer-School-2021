package _m_j;

import java.util.LinkedList;
import java.util.List;

public final class jib {

    /* renamed from: O000000o  reason: collision with root package name */
    public jkt f1848O000000o = jkt.f1911O000000o;
    public List<jig> O00000Oo = new LinkedList();

    public final void O000000o(jig jig) {
        if (O000000o(jig.O0000Ooo().O0000Oo) != null) {
            jig.O0000Ooo().O0000Oo = O00000Oo();
        }
        this.O00000Oo.add(jig);
    }

    public final String toString() {
        String str = "Movie{ ";
        for (jig next : this.O00000Oo) {
            str = str + "track_" + next.O0000Ooo().O0000Oo + " (" + next.O0000o00() + ") ";
        }
        return str + '}';
    }

    private long O00000Oo() {
        long j = 0;
        for (jig next : this.O00000Oo) {
            if (j < next.O0000Ooo().O0000Oo) {
                j = next.O0000Ooo().O0000Oo;
            }
        }
        return j + 1;
    }

    private jig O000000o(long j) {
        for (jig next : this.O00000Oo) {
            if (next.O0000Ooo().O0000Oo == j) {
                return next;
            }
        }
        return null;
    }

    public final long O000000o() {
        long j = this.O00000Oo.iterator().next().O0000Ooo().O00000o0;
        for (jig O0000Ooo : this.O00000Oo) {
            j = jld.O000000o(O0000Ooo.O0000Ooo().O00000o0, j);
        }
        return j;
    }
}
