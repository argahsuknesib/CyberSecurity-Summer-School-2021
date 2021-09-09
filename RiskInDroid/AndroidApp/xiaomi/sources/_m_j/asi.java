package _m_j;

import java.util.Collection;

public class asi extends aso {
    protected final ajv O00000oO;

    public final String O00000Oo(int i) {
        if (i == 0) {
            return "E";
        }
        return null;
    }

    public final boolean O0000OoO() {
        return true;
    }

    public final boolean O0000Ooo() {
        return true;
    }

    public final int O0000o() {
        return 1;
    }

    protected asi(Class<?> cls, ajv ajv, Object obj, Object obj2) {
        super(cls, ajv.hashCode(), obj, obj2);
        this.O00000oO = ajv;
    }

    public ajv O00000o(Class<?> cls) {
        return new asi(cls, this.O00000oO, this.O00000o0, this.O00000o);
    }

    public ajv O00000oO(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return new asi(this.f12412O000000o, this.O00000oO.O000000o(cls), this.O00000o0, this.O00000o);
    }

    public ajv O00000oo(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return new asi(this.f12412O000000o, this.O00000oO.O00000o0(cls), this.O00000o0, this.O00000o);
    }

    /* renamed from: O00000oO */
    public asi O000000o(Object obj) {
        return new asi(this.f12412O000000o, this.O00000oO, this.O00000o0, obj);
    }

    /* renamed from: O00000oo */
    public asi O00000Oo(Object obj) {
        return new asi(this.f12412O000000o, this.O00000oO.O000000o(obj), this.O00000o0, this.O00000o);
    }

    /* renamed from: O0000O0o */
    public asi O00000o0(Object obj) {
        return new asi(this.f12412O000000o, this.O00000oO, obj, this.O00000o);
    }

    /* renamed from: O0000OOo */
    public asi O00000o(Object obj) {
        return new asi(this.f12412O000000o, this.O00000oO.O00000o0(obj), this.O00000o0, this.O00000o);
    }

    public final ajv O0000o0o() {
        return this.O00000oO;
    }

    public final ajv O000000o(int i) {
        if (i == 0) {
            return this.O00000oO;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String O0000oOO() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12412O000000o.getName());
        if (this.O00000oO != null) {
            sb.append('<');
            sb.append(this.O00000oO.O000000o());
            sb.append('>');
        }
        return sb.toString();
    }

    public final boolean O0000oOo() {
        return Collection.class.isAssignableFrom(this.f12412O000000o);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        asi asi = (asi) obj;
        return this.f12412O000000o == asi.f12412O000000o && this.O00000oO.equals(asi.O00000oO);
    }

    public String toString() {
        return "[collection-like type; class " + this.f12412O000000o.getName() + ", contains " + this.O00000oO + "]";
    }
}
