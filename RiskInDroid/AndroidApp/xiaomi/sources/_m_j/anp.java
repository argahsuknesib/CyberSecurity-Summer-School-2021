package _m_j;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class anp extends anm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final anq f12487O000000o;
    protected final int O00000o;
    protected final Type O00000o0;

    public final AnnotatedElement O000000o() {
        return null;
    }

    public final String O00000Oo() {
        return "";
    }

    public anp(anq anq, Type type, anr anr, int i) {
        super(anr);
        this.f12487O000000o = anq;
        this.O00000o0 = type;
        this.O00000o = i;
    }

    public final anp O000000o(anr anr) {
        if (anr == this.O00000Oo) {
            return this;
        }
        return this.f12487O000000o.O000000o(this.O00000o, anr);
    }

    public final <A extends Annotation> A O000000o(Class<A> cls) {
        if (this.O00000Oo == null) {
            return null;
        }
        return this.O00000Oo.O000000o(cls);
    }

    public final Type O00000o0() {
        return this.O00000o0;
    }

    public final Class<?> O00000o() {
        Type type = this.O00000o0;
        if (type instanceof Class) {
            return (Class) type;
        }
        return asq.O000000o().O000000o(this.O00000o0).O00000Oo();
    }

    public final Class<?> O0000Oo() {
        return this.f12487O000000o.O0000Oo();
    }

    public final Member O0000OoO() {
        return this.f12487O000000o.O0000OoO();
    }

    public final void O000000o(Object obj, Object obj2) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + this.f12487O000000o.O0000Oo().getName());
    }

    public final Object O00000Oo(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + this.f12487O000000o.O0000Oo().getName());
    }

    public final Type O00000oo() {
        return this.O00000o0;
    }

    public final anq O0000O0o() {
        return this.f12487O000000o;
    }

    public final int O0000OOo() {
        return this.O00000o;
    }

    public final String toString() {
        return "[parameter #" + this.O00000o + ", annotations: " + this.O00000Oo + "]";
    }
}
