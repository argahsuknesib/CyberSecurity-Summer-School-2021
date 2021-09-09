package _m_j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ghb<E> extends ggz<E> {
    public ghb(List<E> list) {
        super(list);
    }

    public final boolean addAll(Collection<? extends E> collection) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(collection);
            arrayList.removeAll(this);
        }
        return super.addAll(arrayList);
    }

    public final boolean addAll(int i, Collection<? extends E> collection) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(collection);
            arrayList.removeAll(this);
        }
        return super.addAll(i, arrayList);
    }

    public final synchronized boolean add(E e) {
        return contains(e) || super.add(e);
    }

    public final synchronized void add(int i, E e) {
        synchronized (this) {
            if (!contains(e)) {
                super.add(i, e);
            }
        }
    }
}
