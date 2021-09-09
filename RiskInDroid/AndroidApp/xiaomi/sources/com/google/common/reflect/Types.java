package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

final class Types {
    public static final Joiner COMMA_JOINER = Joiner.on(", ").useForNull("null");
    public static final Function<Type, String> TYPE_NAME = new Function<Type, String>() {
        /* class com.google.common.reflect.Types.AnonymousClass1 */

        public final String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    };

    static Type newArrayType(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z = true;
        Preconditions.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return supertypeOf(newArrayType(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "Wildcard should have only one upper bound.");
        return subtypeOf(newArrayType(upperBounds[0]));
    }

    static ParameterizedType newParameterizedTypeWithOwner(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return newParameterizedType(cls, typeArr);
        }
        Preconditions.checkNotNull(typeArr);
        Preconditions.checkArgument(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType newParameterizedType(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            /* access modifiers changed from: package-private */
            public final Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            /* access modifiers changed from: package-private */
            public final Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* access modifiers changed from: package-private */
        public abstract Class<?> getOwnerType(Class<?> cls);

        private static ClassOwnership detectJvmBehavior() {
            ParameterizedType parameterizedType = (ParameterizedType) new AnonymousClass1LocalClass<String>() {
                /* class com.google.common.reflect.Types.ClassOwnership.AnonymousClass3 */
            }.getClass().getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(AnonymousClass1LocalClass.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
    }

    static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return newTypeVariableImpl(d, str, typeArr);
    }

    @VisibleForTesting
    static WildcardType subtypeOf(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    @VisibleForTesting
    static WildcardType supertypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    static String toString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getComponentType(Type type) {
        Preconditions.checkNotNull(type);
        final AtomicReference atomicReference = new AtomicReference();
        new TypeVisitor() {
            /* class com.google.common.reflect.Types.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final void visitTypeVariable(TypeVariable<?> typeVariable) {
                atomicReference.set(Types.subtypeOfComponentType(typeVariable.getBounds()));
            }

            /* access modifiers changed from: package-private */
            public final void visitWildcardType(WildcardType wildcardType) {
                atomicReference.set(Types.subtypeOfComponentType(wildcardType.getUpperBounds()));
            }

            /* access modifiers changed from: package-private */
            public final void visitGenericArrayType(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            /* access modifiers changed from: package-private */
            public final void visitClass(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }
        }.visit(type);
        return (Type) atomicReference.get();
    }

    public static Type subtypeOfComponentType(Type[] typeArr) {
        for (Type componentType : typeArr) {
            Type componentType2 = getComponentType(componentType);
            if (componentType2 != null) {
                if (componentType2 instanceof Class) {
                    Class cls = (Class) componentType2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return subtypeOf(componentType2);
            }
        }
        return null;
    }

    static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final String toString() {
            return Types.toString(this.componentType) + "[]";
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return Objects.equal(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }
    }

    static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkArgument(typeArr.length == cls.getTypeParameters().length);
            Types.disallowPrimitiveType(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public final Type[] getActualTypeArguments() {
            return Types.toArray(this.argumentsList);
        }

        public final Type getRawType() {
            return this.rawType;
        }

        public final Type getOwnerType() {
            return this.ownerType;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                sb.append(JavaVersion.CURRENT.typeName(this.ownerType));
                sb.append('.');
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            sb.append(Types.COMMA_JOINER.join(Iterables.transform(this.argumentsList, Types.TYPE_NAME)));
            sb.append('>');
            return sb.toString();
        }

        public final int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (!getRawType().equals(parameterizedType.getRawType()) || !Objects.equal(getOwnerType(), parameterizedType.getOwnerType()) || !Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return false;
            }
            return true;
        }
    }

    private static <D extends GenericDeclaration> TypeVariable<D> newTypeVariableImpl(D d, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(d, str, typeArr)));
    }

    static final class TypeVariableInvocationHandler implements InvocationHandler {
        private static final ImmutableMap<String, Method> typeVariableMethods;
        public final TypeVariableImpl<?> typeVariableImpl;

        static {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (Method method : TypeVariableImpl.class.getMethods()) {
                if (method.getDeclaringClass().equals(TypeVariableImpl.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.put(method.getName(), method);
                }
            }
            typeVariableMethods = builder.build();
        }

        TypeVariableInvocationHandler(TypeVariableImpl<?> typeVariableImpl2) {
            this.typeVariableImpl = typeVariableImpl2;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = typeVariableMethods.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.typeVariableImpl, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    static final class TypeVariableImpl<D extends GenericDeclaration> {
        private final ImmutableList<Type> bounds;
        private final D genericDeclaration;
        private final String name;

        TypeVariableImpl(D d, String str, Type[] typeArr) {
            Types.disallowPrimitiveType(typeArr, "bound for type variable");
            this.genericDeclaration = (GenericDeclaration) Preconditions.checkNotNull(d);
            this.name = (String) Preconditions.checkNotNull(str);
            this.bounds = ImmutableList.copyOf(typeArr);
        }

        public final Type[] getBounds() {
            return Types.toArray(this.bounds);
        }

        public final D getGenericDeclaration() {
            return this.genericDeclaration;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTypeName() {
            return this.name;
        }

        public final String toString() {
            return this.name;
        }

        public final int hashCode() {
            return this.genericDeclaration.hashCode() ^ this.name.hashCode();
        }

        public final boolean equals(Object obj) {
            if (NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY) {
                if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                    TypeVariableImpl<?> typeVariableImpl = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).typeVariableImpl;
                    return this.name.equals(typeVariableImpl.getName()) && this.genericDeclaration.equals(typeVariableImpl.getGenericDeclaration()) && this.bounds.equals(typeVariableImpl.bounds);
                }
            }
            if (obj instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.name.equals(typeVariable.getName()) && this.genericDeclaration.equals(typeVariable.getGenericDeclaration());
            }
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.disallowPrimitiveType(typeArr, "lower bound for wildcard");
            Types.disallowPrimitiveType(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public final Type[] getLowerBounds() {
            return Types.toArray(this.lowerBounds);
        }

        public final Type[] getUpperBounds() {
            return Types.toArray(this.upperBounds);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                if (!this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) || !this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableIterator<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(it.next()));
            }
            for (Type typeName : Types.filterUpperBounds(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(typeName));
            }
            return sb.toString();
        }
    }

    public static Type[] toArray(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    public static Iterable<Type> filterUpperBounds(Iterable<Type> iterable) {
        return Iterables.filter(iterable, Predicates.not(Predicates.equalTo(Object.class)));
    }

    public static void disallowPrimitiveType(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                Preconditions.checkArgument(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    static Class<?> getArrayClass(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    enum JavaVersion {
        JAVA6 {
            /* access modifiers changed from: package-private */
            public final GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            /* access modifiers changed from: package-private */
            public final Type usedInGenericType(Type type) {
                Preconditions.checkNotNull(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }
        },
        JAVA7 {
            /* access modifiers changed from: package-private */
            public final Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.getArrayClass((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            /* access modifiers changed from: package-private */
            public final Type usedInGenericType(Type type) {
                return (Type) Preconditions.checkNotNull(type);
            }
        },
        JAVA8 {
            /* access modifiers changed from: package-private */
            public final Type newArrayType(Type type) {
                return JAVA7.newArrayType(type);
            }

            /* access modifiers changed from: package-private */
            public final Type usedInGenericType(Type type) {
                return JAVA7.usedInGenericType(type);
            }

            /* access modifiers changed from: package-private */
            public final String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        },
        JAVA9 {
            /* access modifiers changed from: package-private */
            public final boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            /* access modifiers changed from: package-private */
            public final Type newArrayType(Type type) {
                return JAVA8.newArrayType(type);
            }

            /* access modifiers changed from: package-private */
            public final Type usedInGenericType(Type type) {
                return JAVA8.usedInGenericType(type);
            }

            /* access modifiers changed from: package-private */
            public final String typeName(Type type) {
                return JAVA8.typeName(type);
            }
        };
        
        static final JavaVersion CURRENT;

        /* access modifiers changed from: package-private */
        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract Type newArrayType(Type type);

        /* access modifiers changed from: package-private */
        public abstract Type usedInGenericType(Type type);

        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new TypeCapture<Map.Entry<String, int[][]>>() {
                    /* class com.google.common.reflect.Types.JavaVersion.AnonymousClass5 */
                }.capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = JAVA8;
                } else {
                    CURRENT = JAVA9;
                }
            } else if (new TypeCapture<int[]>() {
                /* class com.google.common.reflect.Types.JavaVersion.AnonymousClass6 */
            }.capture() instanceof Class) {
                CURRENT = JAVA7;
            } else {
                CURRENT = JAVA6;
            }
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type usedInGenericType : typeArr) {
                builder.add((Object) usedInGenericType(usedInGenericType));
            }
            return builder.build();
        }

        /* access modifiers changed from: package-private */
        public String typeName(Type type) {
            return Types.toString(type);
        }
    }

    static final class NativeTypeVariableEquals<X> {
        static final boolean NATIVE_TYPE_VARIABLE_ONLY = (!NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0])));

        NativeTypeVariableEquals() {
        }
    }

    private Types() {
    }
}
