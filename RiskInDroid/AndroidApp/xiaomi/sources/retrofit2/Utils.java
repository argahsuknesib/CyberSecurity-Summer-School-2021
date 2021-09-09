package retrofit2;

import _m_j.jax;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ResponseBody;

final class Utils {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private Utils() {
    }

    static Class<?> getRawType(Type type) {
        while (type != null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                throw new IllegalArgumentException();
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                } else {
                    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
                }
            }
        }
        throw new NullPointerException("type == null");
    }

    static boolean equals(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                if (!equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                    return false;
                }
                return true;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            } else if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                    return false;
                }
                return true;
            } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        Type type2;
        Class<?> cls3;
        while (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int i = 0;
                int length = interfaces.length;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    } else {
                        if (cls2.isAssignableFrom(interfaces[i])) {
                            type2 = cls.getGenericInterfaces()[i];
                            cls3 = interfaces[i];
                            break;
                        }
                        i++;
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    cls3 = cls.getSuperclass();
                    if (cls3 == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(cls3)) {
                        type2 = cls.getGenericSuperclass();
                        Type type3 = type2;
                        cls = cls3;
                        type = type3;
                    } else {
                        cls = cls3;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return resolve(type, cls, getGenericSupertype(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.reflect.WildcardType} */
    /* JADX WARNING: Multi-variable type inference failed */
    static Type resolve(Type type, Class<?> cls, Type type2) {
        while (true) {
            boolean z = r10 instanceof TypeVariable;
            Type type3 = type2;
            if (z) {
                TypeVariable typeVariable = (TypeVariable) type3;
                Type resolveTypeVariable = resolveTypeVariable(type, cls, typeVariable);
                if (resolveTypeVariable == typeVariable) {
                    return resolveTypeVariable;
                }
                type3 = resolveTypeVariable;
            } else {
                if (type3 instanceof Class) {
                    Class cls2 = (Class) type3;
                    if (cls2.isArray()) {
                        Type componentType = cls2.getComponentType();
                        Type resolve = resolve(type, cls, componentType);
                        if (componentType == resolve) {
                            return cls2;
                        }
                        return new GenericArrayTypeImpl(resolve);
                    }
                }
                if (type3 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type3;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type resolve2 = resolve(type, cls, genericComponentType);
                    if (genericComponentType == resolve2) {
                        return genericArrayType;
                    }
                    return new GenericArrayTypeImpl(resolve2);
                }
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type resolve3 = resolve(type, cls, ownerType);
                    boolean z2 = resolve3 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    for (int i = 0; i < length; i++) {
                        Type resolve4 = resolve(type, cls, actualTypeArguments[i]);
                        if (resolve4 != actualTypeArguments[i]) {
                            if (!z2) {
                                actualTypeArguments = actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i] = resolve4;
                        }
                    }
                    return z2 ? new ParameterizedTypeImpl(resolve3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                boolean z3 = type3 instanceof WildcardType;
                Type type4 = type3;
                if (z3) {
                    WildcardType wildcardType = (WildcardType) type3;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type resolve5 = resolve(type, cls, lowerBounds[0]);
                        type4 = wildcardType;
                        if (resolve5 != lowerBounds[0]) {
                            return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{resolve5});
                        }
                    } else {
                        type4 = wildcardType;
                        if (upperBounds.length == 1) {
                            Type resolve6 = resolve(type, cls, upperBounds[0]);
                            type4 = wildcardType;
                            if (resolve6 != upperBounds[0]) {
                                return new WildcardTypeImpl(new Type[]{resolve6}, EMPTY_TYPE_ARRAY);
                            }
                        }
                    }
                }
                return type4;
            }
        }
    }

    private static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean isAnnotationPresent(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return true;
            }
        }
        return false;
    }

    static ResponseBody buffer(ResponseBody responseBody) throws IOException {
        jax jax = new jax();
        responseBody.source().O000000o(jax);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), jax);
    }

    static <T> void validateServiceInterface(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    static boolean hasUnresolvableType(Type type) {
        String str;
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                for (Type hasUnresolvableType : ((ParameterizedType) type).getActualTypeArguments()) {
                    if (hasUnresolvableType(hasUnresolvableType)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                type = ((GenericArrayType) type).getGenericComponentType();
            } else if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            } else {
                if (type == null) {
                    str = "null";
                } else {
                    str = type.getClass().getName();
                }
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
            }
        }
        return false;
    }

    static Type getCallResponseType(Type type) {
        if (type instanceof ParameterizedType) {
            return getParameterUpperBound(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() != null ? false : true)) {
                    throw new IllegalArgumentException();
                }
            }
            this.ownerType = type;
            this.rawType = type2;
            this.typeArguments = (Type[]) typeArr.clone();
            Type[] typeArr2 = this.typeArguments;
            int length = typeArr2.length;
            while (i < length) {
                Type type3 = typeArr2[i];
                if (type3 != null) {
                    Utils.checkNotPrimitive(type3);
                    i++;
                } else {
                    throw new NullPointerException();
                }
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public final Type getRawType() {
            return this.rawType;
        }

        public final Type getOwnerType() {
            return this.ownerType;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils.equals(this, (ParameterizedType) obj);
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ Utils.hashCodeOrZero(this.ownerType);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(Utils.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(Utils.typeToString(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                sb.append(", ");
                sb.append(Utils.typeToString(this.typeArguments[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = type;
        }

        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils.equals(this, (GenericArrayType) obj);
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final String toString() {
            return Utils.typeToString(this.componentType) + "[]";
        }
    }

    static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] != null) {
                    Utils.checkNotPrimitive(typeArr2[0]);
                    if (typeArr[0] == Object.class) {
                        this.lowerBound = typeArr2[0];
                        this.upperBound = Object.class;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw new NullPointerException();
            } else if (typeArr[0] != null) {
                Utils.checkNotPrimitive(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = typeArr[0];
            } else {
                throw new NullPointerException();
            }
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public final Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return Utils.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils.equals(this, (WildcardType) obj);
        }

        public final int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public final String toString() {
            if (this.lowerBound != null) {
                return "? super " + Utils.typeToString(this.lowerBound);
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                return "? extends " + Utils.typeToString(this.upperBound);
            }
        }
    }
}
