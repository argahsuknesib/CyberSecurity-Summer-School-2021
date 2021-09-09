package _m_j;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class ann extends anq {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Method f12485O000000o;
    protected Class<?>[] O00000o0;

    public ann(Method method, anr anr, anr[] anrArr) {
        super(anr, anrArr);
        if (method != null) {
            this.f12485O000000o = method;
            return;
        }
        throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
    }

    public final ann O000000o(Method method) {
        return new ann(method, this.O00000Oo, this.O00000o);
    }

    public final ann O000000o(anr anr) {
        return new ann(this.f12485O000000o, anr, this.O00000o);
    }

    public final Method O00000oo() {
        return this.f12485O000000o;
    }

    public final String O00000Oo() {
        return this.f12485O000000o.getName();
    }

    public final Type O00000o0() {
        return this.f12485O000000o.getGenericReturnType();
    }

    public final Class<?> O00000o() {
        return this.f12485O000000o.getReturnType();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anq.O000000o(_m_j.asp, java.lang.reflect.TypeVariable<?>[]):_m_j.ajv
     arg types: [_m_j.asp, java.lang.reflect.TypeVariable<java.lang.reflect.Method>[]]
     candidates:
      _m_j.ann.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.anq.O000000o(int, _m_j.anr):_m_j.anp
      _m_j.anq.O000000o(int, java.lang.annotation.Annotation):void
      _m_j.anm.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.anq.O000000o(_m_j.asp, java.lang.reflect.TypeVariable<?>[]):_m_j.ajv */
    public final ajv O000000o(asp asp) {
        return O000000o(asp, (TypeVariable<?>[]) this.f12485O000000o.getTypeParameters());
    }

    public final Object O0000Oo0() throws Exception {
        return this.f12485O000000o.invoke(null, new Object[0]);
    }

    public final Object O000000o(Object[] objArr) throws Exception {
        return this.f12485O000000o.invoke(null, objArr);
    }

    public final Object O000000o(Object obj) throws Exception {
        return this.f12485O000000o.invoke(null, obj);
    }

    public final Class<?> O0000Oo() {
        return this.f12485O000000o.getDeclaringClass();
    }

    public final Method O0000O0o() {
        return this.f12485O000000o;
    }

    public final void O000000o(Object obj, Object obj2) throws IllegalArgumentException {
        try {
            this.f12485O000000o.invoke(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed to setValue() with method " + O0000Ooo() + ": " + e.getMessage(), e);
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException("Failed to setValue() with method " + O0000Ooo() + ": " + e2.getMessage(), e2);
        }
    }

    public final Object O00000Oo(Object obj) throws IllegalArgumentException {
        try {
            return this.f12485O000000o.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed to getValue() with method " + O0000Ooo() + ": " + e.getMessage(), e);
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException("Failed to getValue() with method " + O0000Ooo() + ": " + e2.getMessage(), e2);
        }
    }

    public final int O0000OOo() {
        return O0000o00().length;
    }

    public final String O0000Ooo() {
        return this.f12485O000000o.getDeclaringClass().getName() + "#" + this.f12485O000000o.getName() + "(" + O0000o00().length + " params)";
    }

    public final Class<?>[] O0000o00() {
        if (this.O00000o0 == null) {
            this.O00000o0 = this.f12485O000000o.getParameterTypes();
        }
        return this.O00000o0;
    }

    public final Class<?> O0000o0() {
        Class<?>[] O0000o00 = O0000o00();
        if (O0000o00.length <= 0) {
            return null;
        }
        return O0000o00[0];
    }

    public final Type O000000o(int i) {
        Type[] genericParameterTypes = this.f12485O000000o.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return genericParameterTypes[i];
    }

    public final Class<?> O0000o0O() {
        return this.f12485O000000o.getReturnType();
    }

    public final String toString() {
        return "[method " + O0000Ooo() + "]";
    }

    public final /* bridge */ /* synthetic */ Member O0000OoO() {
        return this.f12485O000000o;
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement O000000o() {
        return this.f12485O000000o;
    }
}
