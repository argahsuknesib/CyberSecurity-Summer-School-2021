package _m_j;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class ank extends anq {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Constructor<?> f12483O000000o;

    public ank(Constructor<?> constructor, anr anr, anr[] anrArr) {
        super(anr, anrArr);
        if (constructor != null) {
            this.f12483O000000o = constructor;
            return;
        }
        throw new IllegalArgumentException("Null constructor not allowed");
    }

    public final Constructor<?> O00000oo() {
        return this.f12483O000000o;
    }

    public final String O00000Oo() {
        return this.f12483O000000o.getName();
    }

    public final Class<?> O00000o() {
        return this.f12483O000000o.getDeclaringClass();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anq.O000000o(_m_j.asp, java.lang.reflect.TypeVariable<?>[]):_m_j.ajv
     arg types: [_m_j.asp, java.lang.reflect.TypeVariable[]]
     candidates:
      _m_j.ank.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.anq.O000000o(int, _m_j.anr):_m_j.anp
      _m_j.anq.O000000o(int, java.lang.annotation.Annotation):void
      _m_j.anm.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.anq.O000000o(_m_j.asp, java.lang.reflect.TypeVariable<?>[]):_m_j.ajv */
    public final ajv O000000o(asp asp) {
        return O000000o(asp, (TypeVariable<?>[]) this.f12483O000000o.getTypeParameters());
    }

    public final int O0000O0o() {
        return this.f12483O000000o.getParameterTypes().length;
    }

    public final Class<?> O0000OOo() {
        Class<?>[] parameterTypes = this.f12483O000000o.getParameterTypes();
        if (parameterTypes.length <= 0) {
            return null;
        }
        return parameterTypes[0];
    }

    public final Type O000000o(int i) {
        Type[] genericParameterTypes = this.f12483O000000o.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return genericParameterTypes[i];
    }

    public final Object O0000Oo0() throws Exception {
        return this.f12483O000000o.newInstance(new Object[0]);
    }

    public final Object O000000o(Object[] objArr) throws Exception {
        return this.f12483O000000o.newInstance(objArr);
    }

    public final Object O000000o(Object obj) throws Exception {
        return this.f12483O000000o.newInstance(obj);
    }

    public final Class<?> O0000Oo() {
        return this.f12483O000000o.getDeclaringClass();
    }

    public final Member O0000OoO() {
        return this.f12483O000000o;
    }

    public final void O000000o(Object obj, Object obj2) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + this.f12483O000000o.getDeclaringClass().getName());
    }

    public final Object O00000Oo(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + this.f12483O000000o.getDeclaringClass().getName());
    }

    public final String toString() {
        return "[constructor for " + this.f12483O000000o.getName() + ", annotations: " + this.O00000Oo + "]";
    }

    public final Type O00000o0() {
        return this.f12483O000000o.getDeclaringClass();
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement O000000o() {
        return this.f12483O000000o;
    }
}
