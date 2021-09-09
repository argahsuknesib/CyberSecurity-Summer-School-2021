package _m_j;

import _m_j.aig;
import _m_j.aih;

public final class aqo extends aih.O00000o0 {
    protected final apt O00000Oo;

    public final aig<Object> O00000Oo() {
        return this;
    }

    public aqo(anz anz, apt apt) {
        this(anz.O00000Oo(), apt);
    }

    private aqo(Class<?> cls, apt apt) {
        super(cls);
        this.O00000Oo = apt;
    }

    public final Object O00000Oo(Object obj) {
        try {
            return this.O00000Oo.O000000o(obj);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException("Problem accessing property '" + this.O00000Oo.O00000o0() + "': " + e2.getMessage(), e2);
        }
    }

    public final aig<Object> O000000o(Class<?> cls) {
        return cls == this.f12387O000000o ? this : new aqo(cls, this.O00000Oo);
    }

    public final aig.O000000o O000000o(Object obj) {
        return new aig.O000000o(getClass(), this.f12387O000000o, obj);
    }
}
