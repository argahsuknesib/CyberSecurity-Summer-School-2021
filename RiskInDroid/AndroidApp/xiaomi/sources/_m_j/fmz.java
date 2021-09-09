package _m_j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class fmz<K, V> implements Map<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    final Map<K, V>[] f16680O000000o;

    public fmz(Map... mapArr) {
        this.f16680O000000o = mapArr;
    }

    public final int size() {
        int i = 0;
        for (Map<K, V> size : this.f16680O000000o) {
            i += size.size();
        }
        return i;
    }

    public final boolean isEmpty() {
        for (Map<K, V> isEmpty : this.f16680O000000o) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsKey(Object obj) {
        for (Map<K, V> containsKey : this.f16680O000000o) {
            if (containsKey.containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        for (Map<K, V> containsValue : this.f16680O000000o) {
            if (containsValue.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public final V get(Object obj) {
        for (Map<K, V> map : this.f16680O000000o) {
            V v = map.get(obj);
            if (v != null) {
                return v;
            }
        }
        return null;
    }

    public final V put(K k, V v) {
        throw new RuntimeException("can not put");
    }

    public final V remove(Object obj) {
        throw new RuntimeException("can not remove");
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new RuntimeException("can not putAll");
    }

    public final void clear() {
        throw new RuntimeException("can not clear");
    }

    public final Set<K> keySet() {
        Map<K, V>[] mapArr = this.f16680O000000o;
        if (mapArr.length == 1) {
            return mapArr[0].keySet();
        }
        HashSet hashSet = new HashSet();
        for (Map<K, V> keySet : this.f16680O000000o) {
            hashSet.addAll(keySet.keySet());
        }
        return hashSet;
    }

    public final Collection<V> values() {
        Map<K, V>[] mapArr = this.f16680O000000o;
        if (mapArr.length == 1) {
            return mapArr[0].values();
        }
        ArrayList arrayList = new ArrayList();
        for (Map<K, V> values : this.f16680O000000o) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Map<K, V>[] mapArr = this.f16680O000000o;
        if (mapArr.length == 1) {
            return mapArr[0].entrySet();
        }
        HashSet hashSet = new HashSet();
        for (Map<K, V> entrySet : this.f16680O000000o) {
            hashSet.addAll(entrySet.entrySet());
        }
        return hashSet;
    }
}
