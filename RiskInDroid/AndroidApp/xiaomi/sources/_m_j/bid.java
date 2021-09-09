package _m_j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class bid implements Comparable<bid> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12989O000000o;
    public final Method O00000Oo;
    public final Class<?> O00000o;
    public final Field O00000o0;
    public final Type O00000oO;
    public boolean O00000oo;
    private final Class<?> O0000O0o;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f12989O000000o.compareTo(((bid) obj).f12989O000000o);
    }

    public bid(String str, Class<?> cls, Class<?> cls2, Type type, Field field) {
        this.O00000oo = false;
        this.f12989O000000o = str;
        this.O0000O0o = cls;
        this.O00000o = cls2;
        this.O00000oO = type;
        this.O00000Oo = null;
        this.O00000o0 = field;
        if (field != null) {
            field.setAccessible(true);
        }
    }

    public bid(String str, Method method, Field field) {
        this(str, method, field, (Class<?>) null, (Type) null);
    }

    public bid(String str, Method method, Field field, Class<?> cls, Type type) {
        Type type2;
        Class<?> cls2;
        Type O000000o2;
        Type type3;
        this.O00000oo = false;
        this.f12989O000000o = str;
        this.O00000Oo = method;
        this.O00000o0 = field;
        if (method != null) {
            method.setAccessible(true);
        }
        if (field != null) {
            field.setAccessible(true);
        }
        if (method != null) {
            if (method.getParameterTypes().length == 1) {
                cls2 = method.getParameterTypes()[0];
                type3 = method.getGenericParameterTypes()[0];
            } else {
                Class<?> returnType = method.getReturnType();
                Type genericReturnType = method.getGenericReturnType();
                this.O00000oo = true;
                cls2 = returnType;
                type3 = genericReturnType;
            }
            this.O0000O0o = method.getDeclaringClass();
            type2 = type3;
        } else {
            cls2 = field.getType();
            type2 = field.getGenericType();
            this.O0000O0o = field.getDeclaringClass();
        }
        if (cls == null || cls2 != Object.class || !(type2 instanceof TypeVariable) || (O000000o2 = O000000o(cls, (TypeVariable) type2)) == null) {
            Type O000000o3 = O000000o(cls, type, type2);
            if (O000000o3 != type2) {
                if (O000000o3 instanceof ParameterizedType) {
                    cls2 = bih.O000000o(O000000o3);
                } else if (O000000o3 instanceof Class) {
                    cls2 = bih.O000000o(O000000o3);
                }
            }
            this.O00000oO = O000000o3;
            this.O00000o = cls2;
            return;
        }
        this.O00000o = bih.O000000o(O000000o2);
        this.O00000oO = O000000o2;
    }

    private static Type O000000o(Class<?> cls, Type type, Type type2) {
        boolean z;
        if (cls == null || type == null || !((z = type instanceof ParameterizedType))) {
            return type2;
        }
        if (type2 instanceof TypeVariable) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            TypeVariable typeVariable = (TypeVariable) type2;
            for (int i = 0; i < cls.getTypeParameters().length; i++) {
                if (cls.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                    return parameterizedType.getActualTypeArguments()[i];
                }
            }
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            boolean z2 = false;
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Type type3 = actualTypeArguments[i2];
                if (type3 instanceof TypeVariable) {
                    TypeVariable typeVariable2 = (TypeVariable) type3;
                    if (z) {
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        boolean z3 = z2;
                        for (int i3 = 0; i3 < cls.getTypeParameters().length; i3++) {
                            if (cls.getTypeParameters()[i3].getName().equals(typeVariable2.getName())) {
                                actualTypeArguments[i2] = parameterizedType3.getActualTypeArguments()[i3];
                                z3 = true;
                            }
                        }
                        z2 = z3;
                    }
                }
            }
            if (z2) {
                return new big(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
            }
        }
        return type2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.GenericDeclaration] */
    private static Type O000000o(Class<?> cls, TypeVariable<?> typeVariable) {
        ? genericDeclaration = typeVariable.getGenericDeclaration();
        while (true) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i] == typeVariable) {
                            return actualTypeArguments[i];
                        }
                    }
                    return null;
                }
            }
            Class<?> O000000o2 = bih.O000000o(genericSuperclass);
            if (genericSuperclass == null) {
                return null;
            }
            cls = O000000o2;
        }
    }

    public final String toString() {
        return this.f12989O000000o;
    }

    public final <T extends Annotation> T O000000o(Class cls) {
        Field field;
        Method method = this.O00000Oo;
        T annotation = method != null ? method.getAnnotation(cls) : null;
        return (annotation != null || (field = this.O00000o0) == null) ? annotation : field.getAnnotation(cls);
    }

    public final Object O000000o(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.O00000Oo;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.O00000o0.get(obj);
    }
}
