package _m_j;

import java.util.Collection;
import java.util.HashMap;

public final class aox extends aow {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final akr<?> f12510O000000o;
    protected final HashMap<String, String> O00000Oo;
    protected final HashMap<String, ajv> O00000oO;

    private aox(akr<?> akr, ajv ajv, HashMap<String, String> hashMap, HashMap<String, ajv> hashMap2) {
        super(ajv, akr.O0000o0());
        this.f12510O000000o = akr;
        this.O00000Oo = hashMap;
        this.O00000oO = hashMap2;
    }

    public static aox O000000o(akr<?> akr, ajv ajv, Collection<aod> collection, boolean z, boolean z2) {
        ajv ajv2;
        if (z != z2) {
            HashMap hashMap = null;
            HashMap hashMap2 = z ? new HashMap() : null;
            if (z2) {
                hashMap = new HashMap();
            }
            if (collection != null) {
                for (aod next : collection) {
                    Class<?> O000000o2 = next.O000000o();
                    String O00000Oo2 = next.O00000o0() ? next.O00000Oo() : O000000o(O000000o2);
                    if (z) {
                        hashMap2.put(O000000o2.getName(), O00000Oo2);
                    }
                    if (z2 && ((ajv2 = (ajv) hashMap.get(O00000Oo2)) == null || !O000000o2.isAssignableFrom(ajv2.O00000Oo()))) {
                        hashMap.put(O00000Oo2, akr.O00000Oo(O000000o2));
                    }
                }
            }
            return new aox(akr, ajv, hashMap2, hashMap);
        }
        throw new IllegalArgumentException();
    }

    public final String O000000o(Object obj) {
        String str;
        Class<?> cls = obj.getClass();
        String name = cls.getName();
        synchronized (this.O00000Oo) {
            str = this.O00000Oo.get(name);
            if (str == null) {
                if (this.f12510O000000o.O0000O0o()) {
                    str = this.f12510O000000o.O000000o().O00000oO(this.f12510O000000o.O00000o0(cls).O00000o0());
                }
                if (str == null) {
                    str = O000000o(cls);
                }
                this.O00000Oo.put(name, str);
            }
        }
        return str;
    }

    public final String O000000o(Object obj, Class<?> cls) {
        return O000000o(obj);
    }

    public final ajv O000000o(String str) throws IllegalArgumentException {
        return this.O00000oO.get(str);
    }

    public final String toString() {
        return '[' + getClass().getName() + "; id-to-type=" + this.O00000oO + ']';
    }

    private static String O000000o(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return name;
        }
        return name.substring(lastIndexOf + 1);
    }
}
