package _m_j;

import java.lang.reflect.Modifier;

public abstract class ajv extends aji {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<?> f12412O000000o;
    protected final int O00000Oo;
    protected final Object O00000o;
    protected final Object O00000o0;

    public ajv O000000o(int i) {
        return null;
    }

    public abstract ajv O000000o(Object obj);

    public abstract ajv O00000Oo(Object obj);

    public String O00000Oo(int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract ajv O00000o(Class<?> cls);

    public abstract ajv O00000o(Object obj);

    public abstract ajv O00000o0(Object obj);

    public abstract ajv O00000oO(Class<?> cls);

    public abstract ajv O00000oo(Class<?> cls);

    public boolean O00000oo() {
        return false;
    }

    public abstract boolean O0000OoO();

    public boolean O0000Ooo() {
        return false;
    }

    public int O0000o() {
        return 0;
    }

    public boolean O0000o00() {
        return false;
    }

    public ajv O0000o0O() {
        return null;
    }

    public ajv O0000o0o() {
        return null;
    }

    public abstract boolean equals(Object obj);

    public abstract String toString();

    protected ajv(Class<?> cls, int i, Object obj, Object obj2) {
        this.f12412O000000o = cls;
        this.O00000Oo = cls.getName().hashCode() + i;
        this.O00000o0 = obj;
        this.O00000o = obj2;
    }

    public final ajv O000000o(Class<?> cls) {
        if (cls == this.f12412O000000o) {
            return this;
        }
        O0000O0o(cls);
        ajv O00000o2 = O00000o(cls);
        if (this.O00000o0 != O00000o2.O0000oO0()) {
            O00000o2 = O00000o2.O00000o0(this.O00000o0);
        }
        return this.O00000o != O00000o2.O0000oO() ? O00000o2.O000000o(this.O00000o) : O00000o2;
    }

    public final ajv O00000Oo(Class<?> cls) {
        if (cls == this.f12412O000000o) {
            return this;
        }
        ajv O00000o2 = O00000o(cls);
        if (this.O00000o0 != O00000o2.O0000oO0()) {
            O00000o2 = O00000o2.O00000o0(this.O00000o0);
        }
        return this.O00000o != O00000o2.O0000oO() ? O00000o2.O000000o(this.O00000o) : O00000o2;
    }

    public final ajv O00000o0(Class<?> cls) {
        Class<?> cls2 = this.f12412O000000o;
        if (cls == cls2) {
            return this;
        }
        O0000O0o(cls2);
        return O00000o(cls);
    }

    public final Class<?> O00000Oo() {
        return this.f12412O000000o;
    }

    public boolean O00000o0() {
        return Modifier.isAbstract(this.f12412O000000o.getModifiers());
    }

    public boolean O00000o() {
        if ((this.f12412O000000o.getModifiers() & 1536) != 0 && !this.f12412O000000o.isPrimitive()) {
            return false;
        }
        return true;
    }

    public final boolean O00000oO() {
        return Throwable.class.isAssignableFrom(this.f12412O000000o);
    }

    public final boolean O0000O0o() {
        return this.f12412O000000o.isEnum();
    }

    public final boolean O0000OOo() {
        return this.f12412O000000o.isInterface();
    }

    public final boolean O0000Oo0() {
        return this.f12412O000000o.isPrimitive();
    }

    public final boolean O0000Oo() {
        return Modifier.isFinal(this.f12412O000000o.getModifiers());
    }

    public boolean O0000o0() {
        return O0000o() > 0;
    }

    public <T> T O0000oO0() {
        return this.O00000o0;
    }

    public <T> T O0000oO() {
        return this.O00000o;
    }

    private void O0000O0o(Class<?> cls) {
        if (!this.f12412O000000o.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is not assignable to " + this.f12412O000000o.getName());
        }
    }

    public final int hashCode() {
        return this.O00000Oo;
    }
}
