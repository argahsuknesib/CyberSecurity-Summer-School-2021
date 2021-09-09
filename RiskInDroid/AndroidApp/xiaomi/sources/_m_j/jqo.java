package _m_j;

import java.util.LinkedHashSet;
import java.util.Set;

public final class jqo {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Set<jou> f2061O000000o = new LinkedHashSet();

    public final synchronized void O000000o(jou jou) {
        this.f2061O000000o.add(jou);
    }

    public final synchronized void O00000Oo(jou jou) {
        this.f2061O000000o.remove(jou);
    }

    public final synchronized boolean O00000o0(jou jou) {
        return this.f2061O000000o.contains(jou);
    }
}
