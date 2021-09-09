package _m_j;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class jlg<K extends Comparable, V> implements Map<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    TreeMap<K, V> f1917O000000o = new TreeMap<>(new Comparator<K>() {
        /* class _m_j.jlg.AnonymousClass1 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return -((Comparable) obj).compareTo((Comparable) obj2);
        }
    });

    public final boolean containsValue(Object obj) {
        return false;
    }

    public final int size() {
        return this.f1917O000000o.size();
    }

    public final boolean isEmpty() {
        return this.f1917O000000o.isEmpty();
    }

    public final boolean containsKey(Object obj) {
        return this.f1917O000000o.get(obj) != null;
    }

    public final V get(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.f1917O000000o.keySet().iterator();
        K next = it.next();
        while (true) {
            Comparable comparable2 = (Comparable) next;
            if (!it.hasNext()) {
                return this.f1917O000000o.get(comparable2);
            }
            if (comparable.compareTo(comparable2) >= 0) {
                return this.f1917O000000o.get(comparable2);
            }
            next = it.next();
        }
    }

    /* renamed from: O000000o */
    public final V put(K k, V v) {
        return this.f1917O000000o.put(k, v);
    }

    public final V remove(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.f1917O000000o.keySet().iterator();
        K next = it.next();
        while (true) {
            Comparable comparable2 = (Comparable) next;
            if (!it.hasNext()) {
                return this.f1917O000000o.remove(comparable2);
            }
            if (comparable.compareTo(comparable2) >= 0) {
                return this.f1917O000000o.remove(comparable2);
            }
            next = it.next();
        }
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        this.f1917O000000o.putAll(map);
    }

    public final void clear() {
        this.f1917O000000o.clear();
    }

    public final Set<K> keySet() {
        return this.f1917O000000o.keySet();
    }

    public final Collection<V> values() {
        return this.f1917O000000o.values();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return this.f1917O000000o.entrySet();
    }
}
