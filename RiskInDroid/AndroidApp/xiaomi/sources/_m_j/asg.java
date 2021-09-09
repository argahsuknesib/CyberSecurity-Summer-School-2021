package _m_j;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

public final class asg extends aso {
    protected final ajv O00000oO;
    protected final Object O00000oo;

    public final String O00000Oo(int i) {
        if (i == 0) {
            return "E";
        }
        return null;
    }

    public final boolean O00000o() {
        return true;
    }

    public final boolean O00000o0() {
        return false;
    }

    public final boolean O00000oo() {
        return true;
    }

    public final boolean O0000OoO() {
        return true;
    }

    public final int O0000o() {
        return 1;
    }

    private asg(ajv ajv, Object obj, Object obj2, Object obj3) {
        super(obj.getClass(), ajv.hashCode(), obj2, obj3);
        this.O00000oO = ajv;
        this.O00000oo = obj;
    }

    public static asg O000000o(ajv ajv) {
        return new asg(ajv, Array.newInstance(ajv.O00000Oo(), 0), null, null);
    }

    /* access modifiers changed from: protected */
    public final String O0000oOO() {
        return this.f12412O000000o.getName();
    }

    public final ajv O00000o(Class<?> cls) {
        if (cls.isArray()) {
            return O000000o(asq.O000000o().O000000o((Type) cls.getComponentType()));
        }
        throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + cls.getName());
    }

    public final ajv O00000oO(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return O000000o(this.O00000oO.O000000o(cls));
    }

    public final ajv O00000oo(Class<?> cls) {
        if (cls == this.O00000oO.O00000Oo()) {
            return this;
        }
        return O000000o(this.O00000oO.O00000o0(cls));
    }

    public final boolean O0000o0() {
        return this.O00000oO.O0000o0();
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

    public final String toString() {
        return "[array type, component type: " + this.O00000oO + "]";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return this.O00000oO.equals(((asg) obj).O00000oO);
        }
        return false;
    }

    public final /* synthetic */ ajv O00000o(Object obj) {
        if (obj == this.O00000oO.O0000oO0()) {
            return this;
        }
        return new asg(this.O00000oO.O00000o0(obj), this.O00000oo, this.O00000o0, this.O00000o);
    }

    public final /* synthetic */ ajv O00000o0(Object obj) {
        if (obj == this.O00000o0) {
            return this;
        }
        return new asg(this.O00000oO, this.O00000oo, obj, this.O00000o);
    }

    public final /* synthetic */ ajv O00000Oo(Object obj) {
        if (obj == this.O00000oO.O0000oO()) {
            return this;
        }
        return new asg(this.O00000oO.O000000o(obj), this.O00000oo, this.O00000o0, this.O00000o);
    }

    public final /* synthetic */ ajv O000000o(Object obj) {
        if (obj == this.O00000o) {
            return this;
        }
        return new asg(this.O00000oO, this.O00000oo, this.O00000o0, obj);
    }
}
