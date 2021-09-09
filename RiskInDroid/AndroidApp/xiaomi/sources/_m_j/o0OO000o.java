package _m_j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class o0OO000o<K, V> {
    o0OO000o<K, V>.O00000Oo O00000Oo;
    o0OO000o<K, V>.O0000O0o O00000o;
    o0OO000o<K, V>.O00000o0 O00000o0;

    /* access modifiers changed from: protected */
    public abstract int O000000o();

    /* access modifiers changed from: protected */
    public abstract int O000000o(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object O000000o(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract V O000000o(int i, V v);

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i);

    /* access modifiers changed from: protected */
    public abstract void O000000o(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int O00000Oo(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> O00000Oo();

    /* access modifiers changed from: protected */
    public abstract void O00000o0();

    o0OO000o() {
    }

    final class O000000o<T> implements Iterator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f2243O000000o;
        int O00000Oo;
        boolean O00000o = false;
        int O00000o0;

        O000000o(int i) {
            this.f2243O000000o = i;
            this.O00000Oo = o0OO000o.this.O000000o();
        }

        public final boolean hasNext() {
            return this.O00000o0 < this.O00000Oo;
        }

        public final T next() {
            if (hasNext()) {
                T O000000o2 = o0OO000o.this.O000000o(this.O00000o0, this.f2243O000000o);
                this.O00000o0++;
                this.O00000o = true;
                return O000000o2;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.O00000o) {
                this.O00000o0--;
                this.O00000Oo--;
                this.O00000o = false;
                o0OO000o.this.O000000o(this.O00000o0);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class O00000o implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2245O000000o;
        int O00000Oo;
        boolean O00000o0 = false;

        O00000o() {
            this.f2245O000000o = o0OO000o.this.O000000o() - 1;
            this.O00000Oo = -1;
        }

        public final boolean hasNext() {
            return this.O00000Oo < this.f2245O000000o;
        }

        public final void remove() {
            if (this.O00000o0) {
                o0OO000o.this.O000000o(this.O00000Oo);
                this.O00000Oo--;
                this.f2245O000000o--;
                this.O00000o0 = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.O00000o0) {
                return o0OO000o.this.O000000o(this.O00000Oo, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.O00000o0) {
                return o0OO000o.this.O000000o(this.O00000Oo, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.O00000o0) {
                return o0OO000o.this.O000000o(this.O00000Oo, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.O00000o0) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!o0O0Oo00.O000000o(entry.getKey(), o0OO000o.this.O000000o(this.O00000Oo, 0)) || !o0O0Oo00.O000000o(entry.getValue(), o0OO000o.this.O000000o(this.O00000Oo, 1))) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            int i;
            if (this.O00000o0) {
                int i2 = 0;
                Object O000000o2 = o0OO000o.this.O000000o(this.O00000Oo, 0);
                Object O000000o3 = o0OO000o.this.O000000o(this.O00000Oo, 1);
                if (O000000o2 == null) {
                    i = 0;
                } else {
                    i = O000000o2.hashCode();
                }
                if (O000000o3 != null) {
                    i2 = O000000o3.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        public final /* synthetic */ Object next() {
            if (hasNext()) {
                this.O00000Oo++;
                this.O00000o0 = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    final class O00000Oo implements Set<Map.Entry<K, V>> {
        O00000Oo() {
        }

        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int O000000o2 = o0OO000o.this.O000000o();
            for (Map.Entry entry : collection) {
                o0OO000o.this.O000000o(entry.getKey(), entry.getValue());
            }
            return O000000o2 != o0OO000o.this.O000000o();
        }

        public final void clear() {
            o0OO000o.this.O00000o0();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int O000000o2 = o0OO000o.this.O000000o(entry.getKey());
            if (O000000o2 < 0) {
                return false;
            }
            return o0O0Oo00.O000000o(o0OO000o.this.O000000o(O000000o2, 1), entry.getValue());
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return o0OO000o.this.O000000o() == 0;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new O00000o();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return o0OO000o.this.O000000o();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
         arg types: [_m_j.o0OO000o$O00000Oo, java.lang.Object]
         candidates:
          _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
          _m_j.o0OO000o.O000000o(int, int):java.lang.Object
          _m_j.o0OO000o.O000000o(int, java.lang.Object):V
          _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
          _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
          _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean */
        public final boolean equals(Object obj) {
            return o0OO000o.O000000o((Set) this, obj);
        }

        public final int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int O000000o2 = o0OO000o.this.O000000o() - 1; O000000o2 >= 0; O000000o2--) {
                Object O000000o3 = o0OO000o.this.O000000o(O000000o2, 0);
                Object O000000o4 = o0OO000o.this.O000000o(O000000o2, 1);
                if (O000000o3 == null) {
                    i = 0;
                } else {
                    i = O000000o3.hashCode();
                }
                if (O000000o4 == null) {
                    i2 = 0;
                } else {
                    i2 = O000000o4.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    final class O00000o0 implements Set<K> {
        O00000o0() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            o0OO000o.this.O00000o0();
        }

        public final boolean contains(Object obj) {
            return o0OO000o.this.O000000o(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map O00000Oo = o0OO000o.this.O00000Oo();
            for (Object containsKey : collection) {
                if (!O00000Oo.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return o0OO000o.this.O000000o() == 0;
        }

        public final Iterator<K> iterator() {
            return new O000000o(0);
        }

        public final boolean remove(Object obj) {
            int O000000o2 = o0OO000o.this.O000000o(obj);
            if (O000000o2 < 0) {
                return false;
            }
            o0OO000o.this.O000000o(O000000o2);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map O00000Oo = o0OO000o.this.O00000Oo();
            int size = O00000Oo.size();
            for (Object remove : collection) {
                O00000Oo.remove(remove);
            }
            return size != O00000Oo.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return o0OO000o.O000000o(o0OO000o.this.O00000Oo(), collection);
        }

        public final int size() {
            return o0OO000o.this.O000000o();
        }

        public final Object[] toArray() {
            return o0OO000o.this.O00000Oo(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return o0OO000o.this.O000000o(tArr, 0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
         arg types: [_m_j.o0OO000o$O00000o0, java.lang.Object]
         candidates:
          _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
          _m_j.o0OO000o.O000000o(int, int):java.lang.Object
          _m_j.o0OO000o.O000000o(int, java.lang.Object):V
          _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
          _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
          _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean */
        public final boolean equals(Object obj) {
            return o0OO000o.O000000o((Set) this, obj);
        }

        public final int hashCode() {
            int i;
            int i2 = 0;
            for (int O000000o2 = o0OO000o.this.O000000o() - 1; O000000o2 >= 0; O000000o2--) {
                Object O000000o3 = o0OO000o.this.O000000o(O000000o2, 0);
                if (O000000o3 == null) {
                    i = 0;
                } else {
                    i = O000000o3.hashCode();
                }
                i2 += i;
            }
            return i2;
        }
    }

    final class O0000O0o implements Collection<V> {
        O0000O0o() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            o0OO000o.this.O00000o0();
        }

        public final boolean contains(Object obj) {
            return o0OO000o.this.O00000Oo(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return o0OO000o.this.O000000o() == 0;
        }

        public final Iterator<V> iterator() {
            return new O000000o(1);
        }

        public final boolean remove(Object obj) {
            int O00000Oo = o0OO000o.this.O00000Oo(obj);
            if (O00000Oo < 0) {
                return false;
            }
            o0OO000o.this.O000000o(O00000Oo);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int O000000o2 = o0OO000o.this.O000000o();
            int i = 0;
            boolean z = false;
            while (i < O000000o2) {
                if (collection.contains(o0OO000o.this.O000000o(i, 1))) {
                    o0OO000o.this.O000000o(i);
                    i--;
                    O000000o2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int O000000o2 = o0OO000o.this.O000000o();
            int i = 0;
            boolean z = false;
            while (i < O000000o2) {
                if (!collection.contains(o0OO000o.this.O000000o(i, 1))) {
                    o0OO000o.this.O000000o(i);
                    i--;
                    O000000o2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return o0OO000o.this.O000000o();
        }

        public final Object[] toArray() {
            return o0OO000o.this.O00000Oo(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return o0OO000o.this.O000000o(tArr, 1);
        }
    }

    public static <K, V> boolean O000000o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] O00000Oo(int i) {
        int O000000o2 = O000000o();
        Object[] objArr = new Object[O000000o2];
        for (int i2 = 0; i2 < O000000o2; i2++) {
            objArr[i2] = O000000o(i2, i);
        }
        return objArr;
    }

    public final <T> T[] O000000o(T[] tArr, int i) {
        int O000000o2 = O000000o();
        if (tArr.length < O000000o2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), O000000o2);
        }
        for (int i2 = 0; i2 < O000000o2; i2++) {
            tArr[i2] = O000000o(i2, i);
        }
        if (tArr.length > O000000o2) {
            tArr[O000000o2] = null;
        }
        return tArr;
    }

    public static <T> boolean O000000o(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public final Set<K> O00000o() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new O00000o0();
        }
        return this.O00000o0;
    }
}
