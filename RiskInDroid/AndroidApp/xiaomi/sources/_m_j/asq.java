package _m_j;

import _m_j.ass;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class asq {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final asq f12572O000000o = new asq();
    protected static final asn O00000Oo = new asn(String.class);
    protected static final asn O00000o = new asn(Integer.TYPE);
    protected static final asn O00000o0 = new asn(Boolean.TYPE);
    protected static final asn O00000oO = new asn(Long.TYPE);
    private static final ajv[] O0000OoO = new ajv[0];
    protected final LRUMap<ash, ajv> O00000oo = new LRUMap<>(16, 100);
    protected ask O0000O0o;
    protected ask O0000OOo;
    protected final ass O0000Oo = new ass(this);
    protected final asr[] O0000Oo0 = null;

    private asq() {
    }

    public static asq O000000o() {
        return f12572O000000o;
    }

    public static ajv O00000Oo() {
        return O00000o0();
    }

    public final ajv O000000o(ajv ajv, Class<?> cls) {
        if (!(ajv instanceof asn) || (!cls.isArray() && !Map.class.isAssignableFrom(cls) && !Collection.class.isAssignableFrom(cls))) {
            return ajv.O000000o(cls);
        }
        if (ajv.O00000Oo().isAssignableFrom(cls)) {
            new asp(this, ajv.O00000Oo());
            ajv O00000Oo2 = O00000Oo(cls);
            Object O0000oO0 = ajv.O0000oO0();
            if (O0000oO0 != null) {
                O00000Oo2 = O00000Oo2.O00000o0(O0000oO0);
            }
            Object O0000oO = ajv.O0000oO();
            if (O0000oO != null) {
                return O00000Oo2.O000000o(O0000oO);
            }
            return O00000Oo2;
        }
        throw new IllegalArgumentException("Class " + cls.getClass().getName() + " not subtype of " + ajv);
    }

    public final ajv O000000o(String str) throws IllegalArgumentException {
        ass ass = this.O0000Oo;
        ass.O000000o o000000o = new ass.O000000o(str.trim());
        ajv O000000o2 = ass.O000000o(o000000o);
        if (!o000000o.hasMoreTokens()) {
            return O000000o2;
        }
        throw ass.O000000o(o000000o, "Unexpected tokens after complete type");
    }

    public final ajv[] O00000Oo(ajv ajv, Class<?> cls) {
        Class<?> O00000Oo2 = ajv.O00000Oo();
        if (O00000Oo2 != cls) {
            return O000000o(O00000Oo2, cls, new asp(this, ajv));
        }
        int O0000o = ajv.O0000o();
        if (O0000o == 0) {
            return null;
        }
        ajv[] ajvArr = new ajv[O0000o];
        for (int i = 0; i < O0000o; i++) {
            ajvArr[i] = ajv.O000000o(i);
        }
        return ajvArr;
    }

    private ajv[] O00000Oo(Class<?> cls, Class<?> cls2) {
        return O000000o(cls, cls2, new asp(this, cls));
    }

    private ajv[] O000000o(Class<?> cls, Class<?> cls2, asp asp) {
        ask O00000o02 = O00000o0(cls, cls2);
        if (O00000o02 != null) {
            while (O00000o02.O00000Oo() != null) {
                O00000o02 = O00000o02.O00000Oo();
                Class<?> O00000oO2 = O00000o02.O00000oO();
                asp asp2 = new asp(this, O00000oO2);
                if (O00000o02.O00000o0()) {
                    Type[] actualTypeArguments = O00000o02.O00000o().getActualTypeArguments();
                    TypeVariable[] typeParameters = O00000oO2.getTypeParameters();
                    int length = actualTypeArguments.length;
                    for (int i = 0; i < length; i++) {
                        asp2.O000000o(typeParameters[i].getName(), f12572O000000o.O00000Oo(actualTypeArguments[i], asp));
                    }
                }
                asp = asp2;
            }
            if (!O00000o02.O00000o0()) {
                return null;
            }
            return asp.O00000Oo();
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a subtype of " + cls2.getName());
    }

    public final ajv O000000o(Type type) {
        return O00000Oo(type, (asp) null);
    }

    public final ajv O000000o(Type type, asp asp) {
        return O00000Oo(type, asp);
    }

    public final ajv O00000Oo(Type type, asp asp) {
        ajv ajv;
        if (type instanceof Class) {
            ajv = O00000Oo((Class) type);
        } else if (type instanceof ParameterizedType) {
            ajv = O000000o((ParameterizedType) type, asp);
        } else if (type instanceof GenericArrayType) {
            ajv = O000000o((GenericArrayType) type, asp);
        } else if (type instanceof TypeVariable) {
            ajv = O000000o((TypeVariable<?>) ((TypeVariable) type), asp);
        } else if (type instanceof WildcardType) {
            ajv = O000000o((WildcardType) type, asp);
        } else {
            StringBuilder sb = new StringBuilder("Unrecognized Type: ");
            sb.append(type == null ? "[null]" : type.toString());
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.O0000Oo0 != null && !ajv.O0000OoO()) {
            for (asr O000000o2 : this.O0000Oo0) {
                ajv = O000000o2.O000000o();
            }
        }
        return ajv;
    }

    private static ajv O000000o(Class<?> cls, ajv[] ajvArr) {
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters.length == ajvArr.length) {
            String[] strArr = new String[typeParameters.length];
            int length = typeParameters.length;
            for (int i = 0; i < length; i++) {
                strArr[i] = typeParameters[i].getName();
            }
            return new asn(cls, strArr, ajvArr, null, null);
        }
        throw new IllegalArgumentException("Parameter type mismatch for " + cls.getName() + ": expected " + typeParameters.length + " parameters, was given " + ajvArr.length);
    }

    public static ajv O000000o(Class<?> cls) {
        return new asn(cls);
    }

    /* access modifiers changed from: protected */
    public final ajv O00000Oo(Class<?> cls) {
        ajv ajv;
        ajv ajv2;
        asn asn;
        if (cls == String.class) {
            return O00000Oo;
        }
        if (cls == Boolean.TYPE) {
            return O00000o0;
        }
        if (cls == Integer.TYPE) {
            return O00000o;
        }
        if (cls == Long.TYPE) {
            return O00000oO;
        }
        ash ash = new ash(cls);
        synchronized (this.O00000oo) {
            ajv = this.O00000oo.get(ash);
        }
        if (ajv != null) {
            return ajv;
        }
        if (cls.isArray()) {
            ajv2 = asg.O000000o(O00000Oo(cls.getComponentType(), (asp) null));
        } else {
            if (cls.isEnum()) {
                asn = new asn(cls);
            } else if (Map.class.isAssignableFrom(cls)) {
                ajv2 = O00000o0(cls);
            } else if (Collection.class.isAssignableFrom(cls)) {
                ajv2 = O00000o(cls);
            } else {
                asn = new asn(cls);
            }
            ajv2 = asn;
        }
        synchronized (this.O00000oo) {
            this.O00000oo.put(ash, ajv2);
        }
        return ajv2;
    }

    /* access modifiers changed from: protected */
    public final ajv O000000o(Class<?> cls, List<ajv> list) {
        if (cls.isArray()) {
            return asg.O000000o(O00000Oo(cls.getComponentType(), (asp) null));
        }
        if (cls.isEnum()) {
            return new asn(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (list.size() <= 0) {
                return O00000o0(cls);
            }
            return asm.O000000o(cls, list.get(0), list.size() >= 2 ? list.get(1) : O00000o0());
        } else if (Collection.class.isAssignableFrom(cls)) {
            if (list.size() > 0) {
                return asj.O000000o(cls, list.get(0));
            }
            return O00000o(cls);
        } else if (list.size() == 0) {
            return new asn(cls);
        } else {
            return O000000o(cls, (ajv[]) list.toArray(new ajv[list.size()]));
        }
    }

    private ajv O000000o(ParameterizedType parameterizedType, asp asp) {
        int i;
        ajv[] ajvArr;
        Class cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments == null) {
            i = 0;
        } else {
            i = actualTypeArguments.length;
        }
        if (i == 0) {
            ajvArr = O0000OoO;
        } else {
            ajv[] ajvArr2 = new ajv[i];
            for (int i2 = 0; i2 < i; i2++) {
                ajvArr2[i2] = O00000Oo(actualTypeArguments[i2], asp);
            }
            ajvArr = ajvArr2;
        }
        if (Map.class.isAssignableFrom(cls)) {
            ajv[] O00000Oo2 = O00000Oo(O000000o(cls, ajvArr), Map.class);
            if (O00000Oo2.length == 2) {
                return asm.O000000o(cls, O00000Oo2[0], O00000Oo2[1]);
            }
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + cls.getName() + " (found " + O00000Oo2.length + ")");
        } else if (Collection.class.isAssignableFrom(cls)) {
            ajv[] O00000Oo3 = O00000Oo(O000000o(cls, ajvArr), Collection.class);
            if (O00000Oo3.length == 1) {
                return asj.O000000o(cls, O00000Oo3[0]);
            }
            throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + cls.getName() + " (found " + O00000Oo3.length + ")");
        } else if (i == 0) {
            return new asn(cls);
        } else {
            return O000000o(cls, ajvArr);
        }
    }

    private ajv O000000o(GenericArrayType genericArrayType, asp asp) {
        return asg.O000000o(O00000Oo(genericArrayType.getGenericComponentType(), asp));
    }

    private ajv O000000o(TypeVariable<?> typeVariable, asp asp) {
        if (asp == null) {
            return O00000o0();
        }
        String name = typeVariable.getName();
        ajv O000000o2 = asp.O000000o(name);
        if (O000000o2 != null) {
            return O000000o2;
        }
        Type[] bounds = typeVariable.getBounds();
        asp.O00000Oo(name);
        return O00000Oo(bounds[0], asp);
    }

    private ajv O000000o(WildcardType wildcardType, asp asp) {
        return O00000Oo(wildcardType.getUpperBounds()[0], asp);
    }

    private ajv O00000o0(Class<?> cls) {
        ajv[] O00000Oo2 = O00000Oo(cls, (Class<?>) Map.class);
        if (O00000Oo2 == null) {
            return asm.O000000o(cls, O00000o0(), O00000o0());
        }
        if (O00000Oo2.length == 2) {
            return asm.O000000o(cls, O00000Oo2[0], O00000Oo2[1]);
        }
        throw new IllegalArgumentException("Strange Map type " + cls.getName() + ": can not determine type parameters");
    }

    private ajv O00000o(Class<?> cls) {
        ajv[] O00000Oo2 = O00000Oo(cls, (Class<?>) Collection.class);
        if (O00000Oo2 == null) {
            return asj.O000000o(cls, O00000o0());
        }
        if (O00000Oo2.length == 1) {
            return asj.O000000o(cls, O00000Oo2[0]);
        }
        throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": can not determine type parameters");
    }

    private static ajv O00000o0() {
        return new asn(Object.class);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.asq.O00000Oo(java.lang.reflect.Type, java.lang.Class<?>):_m_j.ask
     arg types: [java.lang.Class<?>, java.lang.Class<?>]
     candidates:
      _m_j.asq.O00000Oo(java.lang.Class<?>, java.lang.Class<?>):_m_j.ajv[]
      _m_j.asq.O00000Oo(java.lang.reflect.Type, _m_j.asp):_m_j.ajv
      _m_j.asq.O00000Oo(_m_j.ajv, java.lang.Class<?>):_m_j.ajv[]
      _m_j.asq.O00000Oo(java.lang.reflect.Type, java.lang.Class<?>):_m_j.ask */
    private ask O00000o0(Class<?> cls, Class<?> cls2) {
        if (cls2.isInterface()) {
            return O00000Oo((Type) cls, cls2);
        }
        return O000000o(cls, cls2);
    }

    private ask O000000o(Type type, Class<?> cls) {
        ask O000000o2;
        ask ask = new ask(type);
        Class<?> O00000oO2 = ask.O00000oO();
        if (O00000oO2 == cls) {
            return ask;
        }
        Type genericSuperclass = O00000oO2.getGenericSuperclass();
        if (genericSuperclass == null || (O000000o2 = O000000o(genericSuperclass, cls)) == null) {
            return null;
        }
        O000000o2.O00000Oo(ask);
        ask.O000000o(O000000o2);
        return ask;
    }

    private ask O00000Oo(Type type, Class<?> cls) {
        ask ask = new ask(type);
        Class<?> O00000oO2 = ask.O00000oO();
        if (O00000oO2 == cls) {
            return new ask(type);
        }
        if (O00000oO2 == HashMap.class && cls == Map.class) {
            return O000000o(ask);
        }
        if (O00000oO2 == ArrayList.class && cls == List.class) {
            return O00000Oo(ask);
        }
        return O000000o(ask, cls);
    }

    private ask O000000o(ask ask, Class<?> cls) {
        ask O00000Oo2;
        Class<?> O00000oO2 = ask.O00000oO();
        Type[] genericInterfaces = O00000oO2.getGenericInterfaces();
        if (genericInterfaces != null) {
            for (Type O00000Oo3 : genericInterfaces) {
                ask O00000Oo4 = O00000Oo(O00000Oo3, cls);
                if (O00000Oo4 != null) {
                    O00000Oo4.O00000Oo(ask);
                    ask.O000000o(O00000Oo4);
                    return ask;
                }
            }
        }
        Type genericSuperclass = O00000oO2.getGenericSuperclass();
        if (genericSuperclass == null || (O00000Oo2 = O00000Oo(genericSuperclass, cls)) == null) {
            return null;
        }
        O00000Oo2.O00000Oo(ask);
        ask.O000000o(O00000Oo2);
        return ask;
    }

    private synchronized ask O000000o(ask ask) {
        if (this.O0000O0o == null) {
            ask O000000o2 = ask.O000000o();
            O000000o(O000000o2, Map.class);
            this.O0000O0o = O000000o2.O00000Oo();
        }
        ask O000000o3 = this.O0000O0o.O000000o();
        ask.O000000o(O000000o3);
        O000000o3.O00000Oo(ask);
        return ask;
    }

    private synchronized ask O00000Oo(ask ask) {
        if (this.O0000OOo == null) {
            ask O000000o2 = ask.O000000o();
            O000000o(O000000o2, List.class);
            this.O0000OOo = O000000o2.O00000Oo();
        }
        ask O000000o3 = this.O0000OOo.O000000o();
        ask.O000000o(O000000o3);
        O000000o3.O00000Oo(ask);
        return ask;
    }

    public final asj O000000o(Class<? extends Collection> cls, Class<?> cls2) {
        return asj.O000000o(cls, O00000Oo(cls2, (asp) null));
    }

    public final asm O000000o(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        return asm.O000000o(cls, O00000Oo(cls2, (asp) null), O00000Oo(cls3, (asp) null));
    }
}
