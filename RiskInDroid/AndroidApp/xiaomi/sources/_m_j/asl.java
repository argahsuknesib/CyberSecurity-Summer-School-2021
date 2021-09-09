package _m_j;

import java.util.Map;

public class asl extends aso {
    protected final ajv O00000oO;
    protected final ajv O00000oo;

    public final String O00000Oo(int i) {
        if (i == 0) {
            return "K";
        }
        if (i == 1) {
            return "V";
        }
        return null;
    }

    public final boolean O0000OoO() {
        return true;
    }

    public final int O0000o() {
        return 2;
    }

    public final boolean O0000o00() {
        return true;
    }

    protected asl(Class<?> cls, ajv ajv, ajv ajv2, Object obj, Object obj2) {
        super(cls, ajv.hashCode() ^ ajv2.hashCode(), obj, obj2);
        this.O00000oO = ajv;
        this.O00000oo = ajv2;
    }

    public ajv O00000o(Class<?> cls) {
        return new asl(cls, this.O00000oO, this.O00000oo, this.O00000o0, this.O00000o);
    }

    public ajv O00000oO(Class<?> cls) {
        if (cls == this.O00000oo.O00000Oo()) {
            return this;
        }
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo.O000000o(cls), this.O00000o0, this.O00000o);
    }

    public ajv O00000oo(Class<?> cls) {
        if (cls == this.O00000oo.O00000Oo()) {
            return this;
        }
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo.O00000o0(cls), this.O00000o0, this.O00000o);
    }

    public ajv O0000O0o(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return new asl(this.f12412O000000o, this.O00000oO.O000000o(cls), this.O00000oo, this.O00000o0, this.O00000o);
    }

    public ajv O0000OOo(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return new asl(this.f12412O000000o, this.O00000oO.O00000o0(cls), this.O00000oo, this.O00000o0, this.O00000o);
    }

    /* renamed from: O00000oO */
    public asl O000000o(Object obj) {
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo, this.O00000o0, obj);
    }

    /* renamed from: O00000oo */
    public asl O00000Oo(Object obj) {
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo.O000000o(obj), this.O00000o0, this.O00000o);
    }

    /* renamed from: O0000O0o */
    public asl O00000o0(Object obj) {
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo, obj, this.O00000o);
    }

    /* renamed from: O0000OOo */
    public asl O00000o(Object obj) {
        return new asl(this.f12412O000000o, this.O00000oO, this.O00000oo.O00000o0(obj), this.O00000o0, this.O00000o);
    }

    /* access modifiers changed from: protected */
    public final String O0000oOO() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12412O000000o.getName());
        if (this.O00000oO != null) {
            sb.append('<');
            sb.append(this.O00000oO.O000000o());
            sb.append(',');
            sb.append(this.O00000oo.O000000o());
            sb.append('>');
        }
        return sb.toString();
    }

    public final ajv O0000o0O() {
        return this.O00000oO;
    }

    public final ajv O0000o0o() {
        return this.O00000oo;
    }

    public final ajv O000000o(int i) {
        if (i == 0) {
            return this.O00000oO;
        }
        if (i == 1) {
            return this.O00000oo;
        }
        return null;
    }

    public asl O0000Oo0(Object obj) {
        return new asl(this.f12412O000000o, this.O00000oO.O00000o0(obj), this.O00000oo, this.O00000o0, this.O00000o);
    }

    public final boolean O0000oOo() {
        return Map.class.isAssignableFrom(this.f12412O000000o);
    }

    public String toString() {
        return "[map-like type; class " + this.f12412O000000o.getName() + ", " + this.O00000oO + " -> " + this.O00000oo + "]";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        asl asl = (asl) obj;
        return this.f12412O000000o == asl.f12412O000000o && this.O00000oO.equals(asl.O00000oO) && this.O00000oo.equals(asl.O00000oo);
    }
}
