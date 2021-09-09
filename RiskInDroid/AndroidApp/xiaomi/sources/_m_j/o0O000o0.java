package _m_j;

import _m_j.o0OoO00O;
import java.util.HashMap;

public final class o0O000o0<K, V> extends o0OoO00O<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<K, o0OoO00O.O00000o0<K, V>> f2230O000000o = new HashMap<>();

    /* access modifiers changed from: protected */
    public final o0OoO00O.O00000o0<K, V> O000000o(K k) {
        return this.f2230O000000o.get(k);
    }

    public final V O000000o(K k, V v) {
        o0OoO00O.O00000o0 O000000o2 = O000000o(k);
        if (O000000o2 != null) {
            return O000000o2.O00000Oo;
        }
        this.f2230O000000o.put(k, O00000Oo(k, v));
        return null;
    }

    public final V O00000Oo(K k) {
        V O00000Oo = super.O00000Oo(k);
        this.f2230O000000o.remove(k);
        return O00000Oo;
    }

    public final boolean O00000o0(K k) {
        return this.f2230O000000o.containsKey(k);
    }
}
