package _m_j;

import java.util.AbstractList;
import java.util.List;

public final class jio extends AbstractList<jie> {

    /* renamed from: O000000o  reason: collision with root package name */
    List<jie> f1860O000000o;

    public jio(long j, jha jha, jid jid) {
        if (jlf.O00000Oo(jha, "moov/mvex/trex").isEmpty()) {
            this.f1860O000000o = new jim(j, jha, jid);
        } else {
            this.f1860O000000o = new jin(j, jha, jid);
        }
    }

    public final int size() {
        return this.f1860O000000o.size();
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.f1860O000000o.get(i);
    }
}
