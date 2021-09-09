package _m_j;

import _m_j.auh;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public final class atk {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PriorityQueue<aud> f12598O000000o = new PriorityQueue<>(auh.O000000o.f12621O000000o, this.O00000oO);
    public final PriorityQueue<aud> O00000Oo = new PriorityQueue<>(auh.O000000o.f12621O000000o, this.O00000oO);
    public final Object O00000o = new Object();
    public final List<aud> O00000o0 = new ArrayList();
    private final O000000o O00000oO = new O000000o();

    public final void O000000o() {
        synchronized (this.O00000o) {
            this.f12598O000000o.addAll(this.O00000Oo);
            this.O00000Oo.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        return r0;
     */
    public final boolean O000000o(int i, RectF rectF, int i2) {
        aud aud = new aud(i, null, rectF, false, 0);
        synchronized (this.O00000o) {
            aud O000000o2 = O000000o(this.f12598O000000o, aud);
            boolean z = true;
            if (O000000o2 != null) {
                this.f12598O000000o.remove(O000000o2);
                O000000o2.O00000oO = i2;
                this.O00000Oo.offer(O000000o2);
                return true;
            } else if (O000000o(this.O00000Oo, aud) == null) {
                z = false;
            }
        }
    }

    public final boolean O000000o(int i, RectF rectF) {
        aud aud = new aud(i, null, rectF, true, 0);
        synchronized (this.O00000o0) {
            for (aud equals : this.O00000o0) {
                if (equals.equals(aud)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static aud O000000o(PriorityQueue<aud> priorityQueue, aud aud) {
        Iterator<aud> it = priorityQueue.iterator();
        while (it.hasNext()) {
            aud next = it.next();
            if (next.equals(aud)) {
                return next;
            }
        }
        return null;
    }

    public final List<aud> O00000Oo() {
        ArrayList arrayList;
        synchronized (this.O00000o) {
            arrayList = new ArrayList(this.f12598O000000o);
            arrayList.addAll(this.O00000Oo);
        }
        return arrayList;
    }

    public final List<aud> O00000o0() {
        List<aud> list;
        synchronized (this.O00000o0) {
            list = this.O00000o0;
        }
        return list;
    }

    class O000000o implements Comparator<aud> {
        O000000o() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            aud aud = (aud) obj;
            aud aud2 = (aud) obj2;
            if (aud.O00000oO == aud2.O00000oO) {
                return 0;
            }
            return aud.O00000oO > aud2.O00000oO ? 1 : -1;
        }
    }
}
