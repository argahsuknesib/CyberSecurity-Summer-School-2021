package _m_j;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class O0Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f6677O000000o = false;
    private CopyOnWriteArrayList<O0Oo00> O00000Oo = new CopyOnWriteArrayList<>();

    public abstract void O00000Oo();

    public O0Oo0(boolean z) {
    }

    public final void O000000o() {
        Iterator<O0Oo00> it = this.O00000Oo.iterator();
        while (it.hasNext()) {
            it.next().O000000o();
        }
    }

    public final void O000000o(O0Oo00 o0Oo00) {
        this.O00000Oo.add(o0Oo00);
    }

    public final void O00000Oo(O0Oo00 o0Oo00) {
        this.O00000Oo.remove(o0Oo00);
    }
}
