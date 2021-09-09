package _m_j;

import _m_j.o0OO000o;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class o0O0OOO0<K, V> extends o0OO00OO<K, V> implements Map<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    o0OO000o<K, V> f2237O000000o;

    public o0O0OOO0() {
    }

    public o0O0OOO0(int i) {
        super(i);
    }

    public o0O0OOO0(o0OO00OO o0oo00oo) {
        super(o0oo00oo);
    }

    private o0OO000o<K, V> O000000o() {
        if (this.f2237O000000o == null) {
            this.f2237O000000o = new o0OO000o<K, V>() {
                /* class _m_j.o0O0OOO0.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final int O000000o() {
                    return o0O0OOO0.this.O0000OOo;
                }

                /* access modifiers changed from: protected */
                public final Object O000000o(int i, int i2) {
                    return o0O0OOO0.this.O0000O0o[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                public final int O000000o(Object obj) {
                    return o0O0OOO0.this.O000000o(obj);
                }

                /* access modifiers changed from: protected */
                public final int O00000Oo(Object obj) {
                    return o0O0OOO0.this.O00000Oo(obj);
                }

                /* access modifiers changed from: protected */
                public final Map<K, V> O00000Oo() {
                    return o0O0OOO0.this;
                }

                /* access modifiers changed from: protected */
                public final void O000000o(K k, V v) {
                    o0O0OOO0.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                public final V O000000o(int i, V v) {
                    return o0O0OOO0.this.O000000o(i, v);
                }

                /* access modifiers changed from: protected */
                public final void O000000o(int i) {
                    o0O0OOO0.this.O00000o(i);
                }

                /* access modifiers changed from: protected */
                public final void O00000o0() {
                    o0O0OOO0.this.clear();
                }
            };
        }
        return this.f2237O000000o;
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        O000000o(this.O0000OOo + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        o0OO000o O000000o2 = O000000o();
        if (O000000o2.O00000Oo == null) {
            O000000o2.O00000Oo = new o0OO000o.O00000Oo();
        }
        return O000000o2.O00000Oo;
    }

    public final Set<K> keySet() {
        return O000000o().O00000o();
    }

    public final Collection<V> values() {
        o0OO000o O000000o2 = O000000o();
        if (O000000o2.O00000o == null) {
            O000000o2.O00000o = new o0OO000o.O0000O0o();
        }
        return O000000o2.O00000o;
    }
}
