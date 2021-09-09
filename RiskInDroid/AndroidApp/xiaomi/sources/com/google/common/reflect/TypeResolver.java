package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Beta
public final class TypeResolver {
    private final TypeTable typeTable;

    public TypeResolver() {
        this.typeTable = new TypeTable();
    }

    private TypeResolver(TypeTable typeTable2) {
        this.typeTable = typeTable2;
    }

    static TypeResolver covariantly(Type type) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(type));
    }

    static TypeResolver invariantly(Type type) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(WildcardCapturer.INSTANCE.capture(type)));
    }

    public final TypeResolver where(Type type, Type type2) {
        HashMap newHashMap = Maps.newHashMap();
        populateTypeMappings(newHashMap, (Type) Preconditions.checkNotNull(type), (Type) Preconditions.checkNotNull(type2));
        return where(newHashMap);
    }

    /* access modifiers changed from: package-private */
    public final TypeResolver where(Map<TypeVariableKey, ? extends Type> map) {
        return new TypeResolver(this.typeTable.where(map));
    }

    public static void populateTypeMappings(final Map<TypeVariableKey, Type> map, Type type, final Type type2) {
        if (!type.equals(type2)) {
            new TypeVisitor() {
                /* class com.google.common.reflect.TypeResolver.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public final void visitTypeVariable(TypeVariable<?> typeVariable) {
                    map.put(new TypeVariableKey(typeVariable), type2);
                }

                /* access modifiers changed from: package-private */
                public final void visitWildcardType(WildcardType wildcardType) {
                    Type type = type2;
                    if (type instanceof WildcardType) {
                        WildcardType wildcardType2 = (WildcardType) type;
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Type[] upperBounds2 = wildcardType2.getUpperBounds();
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                        Preconditions.checkArgument(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, type2);
                        for (int i = 0; i < upperBounds.length; i++) {
                            TypeResolver.populateTypeMappings(map, upperBounds[i], upperBounds2[i]);
                        }
                        for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                            TypeResolver.populateTypeMappings(map, lowerBounds[i2], lowerBounds2[i2]);
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public final void visitParameterizedType(ParameterizedType parameterizedType) {
                    Type type = type2;
                    if (!(type instanceof WildcardType)) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) TypeResolver.expectArgument(ParameterizedType.class, type);
                        if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                            TypeResolver.populateTypeMappings(map, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                        }
                        Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                        Preconditions.checkArgument(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                        for (int i = 0; i < actualTypeArguments.length; i++) {
                            TypeResolver.populateTypeMappings(map, actualTypeArguments[i], actualTypeArguments2[i]);
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public final void visitGenericArrayType(GenericArrayType genericArrayType) {
                    Type type = type2;
                    if (!(type instanceof WildcardType)) {
                        Type componentType = Types.getComponentType(type);
                        Preconditions.checkArgument(componentType != null, "%s is not an array type.", type2);
                        TypeResolver.populateTypeMappings(map, genericArrayType.getGenericComponentType(), componentType);
                    }
                }

                /* access modifiers changed from: package-private */
                public final void visitClass(Class<?> cls) {
                    if (!(type2 instanceof WildcardType)) {
                        throw new IllegalArgumentException("No type mapping from " + cls + " to " + type2);
                    }
                }
            }.visit(type);
        }
    }

    public final Type resolveType(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            return this.typeTable.resolve((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return resolveParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return resolveGenericArrayType((GenericArrayType) type);
        }
        return type instanceof WildcardType ? resolveWildcardType((WildcardType) type) : type;
    }

    /* access modifiers changed from: package-private */
    public final Type[] resolveTypesInPlace(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]);
        }
        return typeArr;
    }

    public final Type[] resolveTypes(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = resolveType(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType resolveWildcardType(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(resolveTypes(wildcardType.getLowerBounds()), resolveTypes(wildcardType.getUpperBounds()));
    }

    private Type resolveGenericArrayType(GenericArrayType genericArrayType) {
        return Types.newArrayType(resolveType(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType parameterizedType) {
        Type type;
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType == null) {
            type = null;
        } else {
            type = resolveType(ownerType);
        }
        return Types.newParameterizedTypeWithOwner(type, (Class) resolveType(parameterizedType.getRawType()), resolveTypes(parameterizedType.getActualTypeArguments()));
    }

    public static <T> T expectArgument(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    static class TypeTable {
        private final ImmutableMap<TypeVariableKey, Type> map;

        TypeTable() {
            this.map = ImmutableMap.of();
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public final TypeTable where(Map<TypeVariableKey, ? extends Type> map2) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(this.map);
            for (Map.Entry next : map2.entrySet()) {
                TypeVariableKey typeVariableKey = (TypeVariableKey) next.getKey();
                Type type = (Type) next.getValue();
                Preconditions.checkArgument(!typeVariableKey.equalsType(type), "Type variable %s bound to itself", typeVariableKey);
                builder.put(typeVariableKey, type);
            }
            return new TypeTable(builder.build());
        }

        /* access modifiers changed from: package-private */
        public final Type resolve(final TypeVariable<?> typeVariable) {
            return resolveInternal(typeVariable, new TypeTable() {
                /* class com.google.common.reflect.TypeResolver.TypeTable.AnonymousClass1 */

                public Type resolveInternal(TypeVariable<?> typeVariable, TypeTable typeTable) {
                    if (typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration())) {
                        return typeVariable;
                    }
                    return this.resolveInternal(typeVariable, typeTable);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public Type resolveInternal(TypeVariable<?> typeVariable, TypeTable typeTable) {
            Type type = this.map.get(new TypeVariableKey(typeVariable));
            if (type != null) {
                return new TypeResolver(typeTable).resolveType(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] resolveTypes = new TypeResolver(typeTable).resolveTypes(bounds);
            if (!Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY || !Arrays.equals(bounds, resolveTypes)) {
                return Types.newArtificialTypeVariable(typeVariable.getGenericDeclaration(), typeVariable.getName(), resolveTypes);
            }
            return typeVariable;
        }
    }

    static final class TypeMappingIntrospector extends TypeVisitor {
        private final Map<TypeVariableKey, Type> mappings = Maps.newHashMap();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariableKey, Type> getTypeMappings(Type type) {
            Preconditions.checkNotNull(type);
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.visit(type);
            return ImmutableMap.copyOf(typeMappingIntrospector.mappings);
        }

        /* access modifiers changed from: package-private */
        public final void visitClass(Class<?> cls) {
            visit(cls.getGenericSuperclass());
            visit(cls.getGenericInterfaces());
        }

        /* access modifiers changed from: package-private */
        public final void visitParameterizedType(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                map(new TypeVariableKey(typeParameters[i]), actualTypeArguments[i]);
            }
            visit(cls);
            visit(parameterizedType.getOwnerType());
        }

        /* access modifiers changed from: package-private */
        public final void visitTypeVariable(TypeVariable<?> typeVariable) {
            visit(typeVariable.getBounds());
        }

        /* access modifiers changed from: package-private */
        public final void visitWildcardType(WildcardType wildcardType) {
            visit(wildcardType.getUpperBounds());
        }

        private void map(TypeVariableKey typeVariableKey, Type type) {
            if (!this.mappings.containsKey(typeVariableKey)) {
                Type type2 = type;
                while (type2 != null) {
                    if (typeVariableKey.equalsType(type2)) {
                        while (type != null) {
                            type = this.mappings.remove(TypeVariableKey.forLookup(type));
                        }
                        return;
                    }
                    type2 = this.mappings.get(TypeVariableKey.forLookup(type2));
                }
                this.mappings.put(typeVariableKey, type);
            }
        }
    }

    static class WildcardCapturer {
        static final WildcardCapturer INSTANCE = new WildcardCapturer();
        private final AtomicInteger id;

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger atomicInteger) {
            this.id = atomicInteger;
        }

        /* access modifiers changed from: package-private */
        public final Type capture(Type type) {
            Preconditions.checkNotNull(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.newArrayType(notForTypeVariable().capture(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = forTypeVariable(typeParameters[i]).capture(actualTypeArguments[i]);
                }
                return Types.newParameterizedTypeWithOwner(notForTypeVariable().captureNullable(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? captureAsTypeVariable(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        /* access modifiers changed from: package-private */
        public TypeVariable<?> captureAsTypeVariable(Type[] typeArr) {
            return Types.newArtificialTypeVariable(WildcardCapturer.class, "capture#" + this.id.incrementAndGet() + "-of ? extends " + Joiner.on('&').join(typeArr), typeArr);
        }

        private WildcardCapturer forTypeVariable(final TypeVariable<?> typeVariable) {
            return new WildcardCapturer(this.id) {
                /* class com.google.common.reflect.TypeResolver.WildcardCapturer.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public TypeVariable<?> captureAsTypeVariable(Type[] typeArr) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.captureAsTypeVariable((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private WildcardCapturer notForTypeVariable() {
            return new WildcardCapturer(this.id);
        }

        private Type captureNullable(Type type) {
            if (type == null) {
                return null;
            }
            return capture(type);
        }
    }

    static final class TypeVariableKey {
        private final TypeVariable<?> var;

        TypeVariableKey(TypeVariable<?> typeVariable) {
            this.var = (TypeVariable) Preconditions.checkNotNull(typeVariable);
        }

        public final int hashCode() {
            return Objects.hashCode(this.var.getGenericDeclaration(), this.var.getName());
        }

        public final boolean equals(Object obj) {
            if (obj instanceof TypeVariableKey) {
                return equalsTypeVariable(((TypeVariableKey) obj).var);
            }
            return false;
        }

        public final String toString() {
            return this.var.toString();
        }

        static TypeVariableKey forLookup(Type type) {
            if (type instanceof TypeVariable) {
                return new TypeVariableKey((TypeVariable) type);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean equalsType(Type type) {
            if (type instanceof TypeVariable) {
                return equalsTypeVariable((TypeVariable) type);
            }
            return false;
        }

        private boolean equalsTypeVariable(TypeVariable<?> typeVariable) {
            return this.var.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.var.getName().equals(typeVariable.getName());
        }
    }
}
