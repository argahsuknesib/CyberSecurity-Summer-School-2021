package _m_j;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class anl extends anm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Field f12484O000000o;

    public anl(Field field, anr anr) {
        super(anr);
        this.f12484O000000o = field;
    }

    public final anl O000000o(anr anr) {
        return new anl(this.f12484O000000o, anr);
    }

    public final Field O00000oo() {
        return this.f12484O000000o;
    }

    public final String O00000Oo() {
        return this.f12484O000000o.getName();
    }

    public final <A extends Annotation> A O000000o(Class<A> cls) {
        return this.O00000Oo.O000000o(cls);
    }

    public final Type O00000o0() {
        return this.f12484O000000o.getGenericType();
    }

    public final Class<?> O00000o() {
        return this.f12484O000000o.getType();
    }

    public final Class<?> O0000Oo() {
        return this.f12484O000000o.getDeclaringClass();
    }

    public final Member O0000OoO() {
        return this.f12484O000000o;
    }

    public final void O000000o(Object obj, Object obj2) throws IllegalArgumentException {
        try {
            this.f12484O000000o.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed to setValue() for field " + O0000O0o() + ": " + e.getMessage(), e);
        }
    }

    public final Object O00000Oo(Object obj) throws IllegalArgumentException {
        try {
            return this.f12484O000000o.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed to getValue() for field " + O0000O0o() + ": " + e.getMessage(), e);
        }
    }

    public final String O0000O0o() {
        return this.f12484O000000o.getDeclaringClass().getName() + "#" + this.f12484O000000o.getName();
    }

    public final String toString() {
        return "[field " + O0000O0o() + "]";
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement O000000o() {
        return this.f12484O000000o;
    }
}
