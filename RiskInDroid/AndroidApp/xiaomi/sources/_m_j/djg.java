package _m_j;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class djg implements Iterable<String> {

    /* renamed from: O000000o  reason: collision with root package name */
    ConcurrentLinkedQueue<String> f14715O000000o;
    AtomicInteger O00000Oo;

    public djg() {
        this.f14715O000000o = null;
        this.O00000Oo = null;
        this.f14715O000000o = new ConcurrentLinkedQueue<>();
        this.O00000Oo = new AtomicInteger(0);
    }

    public final void O000000o() {
        this.f14715O000000o.clear();
        this.O00000Oo.set(0);
    }

    public final Iterator<String> iterator() {
        return this.f14715O000000o.iterator();
    }
}
