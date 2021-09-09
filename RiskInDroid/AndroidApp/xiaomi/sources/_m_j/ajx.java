package _m_j;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ajx implements Iterable<ajx> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final List<ajx> f12413O000000o = Collections.emptyList();
    protected static final List<String> O00000Oo = Collections.emptyList();

    public abstract String O000000o();

    public int O00000Oo() {
        return 0;
    }

    public abstract boolean equals(Object obj);

    public abstract String toString();

    protected ajx() {
    }

    public final Iterator<ajx> iterator() {
        return O00000o0();
    }

    public Iterator<ajx> O00000o0() {
        return f12413O000000o.iterator();
    }
}
