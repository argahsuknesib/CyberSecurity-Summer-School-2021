package _m_j;

import com.fasterxml.jackson.databind.util.LRUMap;

public final class atf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected LRUMap<ash, aja> f12587O000000o;

    public final synchronized aja O000000o(Class<?> cls, akr<?> akr) {
        ash ash = new ash(cls);
        if (this.f12587O000000o == null) {
            this.f12587O000000o = new LRUMap<>(20, 200);
        } else {
            aja aja = this.f12587O000000o.get(ash);
            if (aja != null) {
                return aja;
            }
        }
        String O000000o2 = akr.O000000o().O000000o(akr.O00000o0(cls).O00000o0());
        if (O000000o2 == null) {
            O000000o2 = cls.getSimpleName();
        }
        aja aja2 = new aja(O000000o2);
        this.f12587O000000o.put(ash, aja2);
        return aja2;
    }
}
