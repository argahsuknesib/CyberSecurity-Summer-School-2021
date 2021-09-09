package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum FieldType {
    DOUBLE(0, Collection.SCALAR, JavaType.DOUBLE),
    FLOAT(1, Collection.SCALAR, JavaType.FLOAT),
    INT64(2, Collection.SCALAR, JavaType.LONG),
    UINT64(3, Collection.SCALAR, JavaType.LONG),
    INT32(4, Collection.SCALAR, JavaType.INT),
    FIXED64(5, Collection.SCALAR, JavaType.LONG),
    FIXED32(6, Collection.SCALAR, JavaType.INT),
    BOOL(7, Collection.SCALAR, JavaType.BOOLEAN),
    STRING(8, Collection.SCALAR, JavaType.STRING),
    MESSAGE(9, Collection.SCALAR, JavaType.MESSAGE),
    BYTES(10, Collection.SCALAR, JavaType.BYTE_STRING),
    UINT32(11, Collection.SCALAR, JavaType.INT),
    ENUM(12, Collection.SCALAR, JavaType.ENUM),
    SFIXED32(13, Collection.SCALAR, JavaType.INT),
    SFIXED64(14, Collection.SCALAR, JavaType.LONG),
    SINT32(15, Collection.SCALAR, JavaType.INT),
    SINT64(16, Collection.SCALAR, JavaType.LONG),
    GROUP(17, Collection.SCALAR, JavaType.MESSAGE),
    DOUBLE_LIST(18, Collection.VECTOR, JavaType.DOUBLE),
    FLOAT_LIST(19, Collection.VECTOR, JavaType.FLOAT),
    INT64_LIST(20, Collection.VECTOR, JavaType.LONG),
    UINT64_LIST(21, Collection.VECTOR, JavaType.LONG),
    INT32_LIST(22, Collection.VECTOR, JavaType.INT),
    FIXED64_LIST(23, Collection.VECTOR, JavaType.LONG),
    FIXED32_LIST(24, Collection.VECTOR, JavaType.INT),
    BOOL_LIST(25, Collection.VECTOR, JavaType.BOOLEAN),
    STRING_LIST(26, Collection.VECTOR, JavaType.STRING),
    MESSAGE_LIST(27, Collection.VECTOR, JavaType.MESSAGE),
    BYTES_LIST(28, Collection.VECTOR, JavaType.BYTE_STRING),
    UINT32_LIST(29, Collection.VECTOR, JavaType.INT),
    ENUM_LIST(30, Collection.VECTOR, JavaType.ENUM),
    SFIXED32_LIST(31, Collection.VECTOR, JavaType.INT),
    SFIXED64_LIST(32, Collection.VECTOR, JavaType.LONG),
    SINT32_LIST(33, Collection.VECTOR, JavaType.INT),
    SINT64_LIST(34, Collection.VECTOR, JavaType.LONG),
    DOUBLE_LIST_PACKED(35, Collection.PACKED_VECTOR, JavaType.DOUBLE),
    FLOAT_LIST_PACKED(36, Collection.PACKED_VECTOR, JavaType.FLOAT),
    INT64_LIST_PACKED(37, Collection.PACKED_VECTOR, JavaType.LONG),
    UINT64_LIST_PACKED(38, Collection.PACKED_VECTOR, JavaType.LONG),
    INT32_LIST_PACKED(39, Collection.PACKED_VECTOR, JavaType.INT),
    FIXED64_LIST_PACKED(40, Collection.PACKED_VECTOR, JavaType.LONG),
    FIXED32_LIST_PACKED(41, Collection.PACKED_VECTOR, JavaType.INT),
    BOOL_LIST_PACKED(42, Collection.PACKED_VECTOR, JavaType.BOOLEAN),
    UINT32_LIST_PACKED(43, Collection.PACKED_VECTOR, JavaType.INT),
    ENUM_LIST_PACKED(44, Collection.PACKED_VECTOR, JavaType.ENUM),
    SFIXED32_LIST_PACKED(45, Collection.PACKED_VECTOR, JavaType.INT),
    SFIXED64_LIST_PACKED(46, Collection.PACKED_VECTOR, JavaType.LONG),
    SINT32_LIST_PACKED(47, Collection.PACKED_VECTOR, JavaType.INT),
    SINT64_LIST_PACKED(48, Collection.PACKED_VECTOR, JavaType.LONG),
    GROUP_LIST(49, Collection.VECTOR, JavaType.MESSAGE),
    MAP(50, Collection.MAP, JavaType.VOID);
    
    private static final Type[] EMPTY_TYPES = new Type[0];
    private static final FieldType[] VALUES;
    private final Collection collection;
    private final Class<?> elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    static {
        FieldType[] values = values();
        VALUES = new FieldType[values.length];
        for (FieldType fieldType : values) {
            VALUES[fieldType.id] = fieldType;
        }
    }

    private FieldType(int i, Collection collection2, JavaType javaType2) {
        int i2;
        this.id = i;
        this.collection = collection2;
        this.javaType = javaType2;
        int i3 = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType$Collection[collection2.ordinal()];
        if (i3 == 1) {
            this.elementType = javaType2.getBoxedType();
        } else if (i3 != 2) {
            this.elementType = null;
        } else {
            this.elementType = javaType2.getBoxedType();
        }
        boolean z = false;
        if (!(collection2 != Collection.SCALAR || (i2 = AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[javaType2.ordinal()]) == 1 || i2 == 2 || i2 == 3)) {
            z = true;
        }
        this.primitiveScalar = z;
    }

    /* renamed from: com.google.protobuf.FieldType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType$Collection = new int[Collection.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = new int[JavaType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $SwitchMap$com$google$protobuf$FieldType$Collection[Collection.MAP.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$FieldType$Collection[Collection.VECTOR.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$FieldType$Collection[Collection.SCALAR.ordinal()] = 3;
        }
    }

    public final int id() {
        return this.id;
    }

    public final JavaType getJavaType() {
        return this.javaType;
    }

    public final boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public final boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public final boolean isScalar() {
        return this.collection == Collection.SCALAR;
    }

    public final boolean isList() {
        return this.collection.isList();
    }

    public final boolean isMap() {
        return this.collection == Collection.MAP;
    }

    public final boolean isValidForField(Field field) {
        if (Collection.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public static FieldType forId(int i) {
        if (i < 0) {
            return null;
        }
        FieldType[] fieldTypeArr = VALUES;
        if (i >= fieldTypeArr.length) {
            return null;
        }
        return fieldTypeArr[i];
    }

    private static Type getGenericSuperList(Class<?> cls) {
        for (Type type : cls.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                if (List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
            return genericSuperclass;
        }
        return null;
    }

    private static Type getListParameter(Class<?> cls, Type[] typeArr) {
        boolean z;
        while (true) {
            int i = 0;
            if (cls != List.class) {
                Type genericSuperList = getGenericSuperList(cls);
                if (!(genericSuperList instanceof ParameterizedType)) {
                    typeArr = EMPTY_TYPES;
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i >= length) {
                            cls = cls.getSuperclass();
                            break;
                        }
                        Class<?> cls2 = interfaces[i];
                        if (List.class.isAssignableFrom(cls2)) {
                            cls = cls2;
                            break;
                        }
                        i++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperList;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        Type type = actualTypeArguments[i2];
                        if (type instanceof TypeVariable) {
                            TypeVariable[] typeParameters = cls.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= typeParameters.length) {
                                        z = false;
                                        break;
                                    } else if (type == typeParameters[i3]) {
                                        actualTypeArguments[i2] = typeArr[i3];
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z) {
                                    throw new RuntimeException("Unable to find replacement for ".concat(String.valueOf(type)));
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    cls = (Class) parameterizedType.getRawType();
                    typeArr = actualTypeArguments;
                }
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean isList;

        private Collection(boolean z) {
            this.isList = z;
        }

        public final boolean isList() {
            return this.isList;
        }
    }
}
