package _m_j;

import _m_j.ako;
import _m_j.aks;
import com.fasterxml.jackson.databind.MapperFeature;
import java.util.Map;

public abstract class aks<CFG extends ako, T extends aks<CFG, T>> extends akr<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int f12421O000000o = O000000o(MapperFeature.class);
    protected final Map<ash, Class<?>> O00000oo;
    protected final aoe O0000O0o;
    protected final String O0000OOo;
    protected final Class<?> O0000Oo0;

    protected aks(akn akn, aoe aoe, Map<ash, Class<?>> map) {
        super(akn, f12421O000000o);
        this.O00000oo = map;
        this.O0000O0o = aoe;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
    }

    protected aks(aks<CFG, T> aks, int i) {
        super(aks.O00000oO, i);
        this.O00000oo = aks.O00000oo;
        this.O0000O0o = aks.O0000O0o;
        this.O0000OOo = aks.O0000OOo;
        this.O0000Oo0 = aks.O0000Oo0;
    }

    public final aoe O0000oO0() {
        return this.O0000O0o;
    }

    public final String O0000oO() {
        return this.O0000OOo;
    }

    public final Class<?> O0000oOO() {
        return this.O0000Oo0;
    }

    public final Class<?> O00000oo(Class<?> cls) {
        Map<ash, Class<?>> map = this.O00000oo;
        if (map == null) {
            return null;
        }
        return map.get(new ash(cls));
    }
}
