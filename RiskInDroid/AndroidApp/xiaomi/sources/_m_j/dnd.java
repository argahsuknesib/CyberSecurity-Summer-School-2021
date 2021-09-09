package _m_j;

import java.util.LinkedList;
import java.util.List;

public final class dnd {
    private static dnd O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    List<dmz> f14804O000000o = new LinkedList();
    List<dmy> O00000Oo = new LinkedList();
    List<dna> O00000o = new LinkedList();
    List<dnb> O00000o0 = new LinkedList();

    public static dnd O000000o() {
        if (O00000oO == null) {
            O00000oO = new dnd();
        }
        return O00000oO;
    }

    private dnd() {
    }

    public final dmz O000000o(int i) {
        if (this.f14804O000000o.size() <= 0) {
            return new dmz(i);
        }
        dmz remove = this.f14804O000000o.remove(0);
        remove.f14800O000000o = i;
        return remove;
    }

    public final dmy O000000o(float f) {
        if (this.O00000Oo.size() <= 0) {
            return new dmy(f);
        }
        dmy remove = this.O00000Oo.remove(0);
        remove.f14799O000000o = f;
        return remove;
    }

    public final dnb O000000o(String str) {
        if (this.O00000o0.size() <= 0) {
            return new dnb(str);
        }
        dnb remove = this.O00000o0.remove(0);
        remove.f14803O000000o = str;
        return remove;
    }

    public final dna O000000o(Object obj) {
        if (this.O00000o.size() <= 0) {
            return new dna(obj);
        }
        dna remove = this.O00000o.remove(0);
        remove.f14802O000000o = obj;
        return remove;
    }
}
