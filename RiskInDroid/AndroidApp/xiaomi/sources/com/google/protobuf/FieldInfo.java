package com.google.protobuf;

import com.google.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {
    private final Field cachedSizeField;
    private final boolean enforceUtf8;
    private final Internal.EnumVerifier enumVerifier;
    private final Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final OneofInfo oneof;
    private final Class<?> oneofStoredType;
    private final Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    private static boolean isExactlyOneBitSet(int i) {
        return i != 0 && (i & (i + -1)) == 0;
    }

    public static FieldInfo forField(Field field2, int i, FieldType fieldType, boolean z) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i, fieldType, null, null, 0, false, z, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forPackedField(Field field2, int i, FieldType fieldType, Field field3) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i, fieldType, null, null, 0, false, false, null, null, null, null, field3);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forRepeatedMessageField(Field field2, int i, FieldType fieldType, Class<?> cls) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        FieldType fieldType2 = fieldType;
        Internal.checkNotNull(fieldType2, "fieldType");
        Class<?> cls2 = cls;
        Internal.checkNotNull(cls2, "messageClass");
        return new FieldInfo(field2, i, fieldType2, cls2, null, 0, false, false, null, null, null, null, null);
    }

    public static FieldInfo forFieldWithEnumVerifier(Field field2, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier2) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier2, null);
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(Field field2, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier2, Field field3) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier2, field3);
    }

    public static FieldInfo forProto2OptionalField(Field field2, int i, FieldType fieldType, Field field3, int i2, boolean z, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i2)) {
            return new FieldInfo(field2, i, fieldType, null, field3, i2, false, z, null, null, null, enumVerifier2, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(i2)));
    }

    public static FieldInfo forOneofMemberField(int i, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z, Internal.EnumVerifier enumVerifier2) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Internal.checkNotNull(fieldType2, "fieldType");
        Internal.checkNotNull(oneofInfo, "oneof");
        Internal.checkNotNull(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo(null, i, fieldType, null, null, 0, false, z, oneofInfo, cls, null, enumVerifier2, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i + " is of type " + fieldType2);
    }

    private static void checkFieldNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: ".concat(String.valueOf(i)));
        }
    }

    public static FieldInfo forProto2RequiredField(Field field2, int i, FieldType fieldType, Field field3, int i2, boolean z, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i2)) {
            return new FieldInfo(field2, i, fieldType, null, field3, i2, true, z, null, null, null, enumVerifier2, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(i2)));
    }

    public static FieldInfo forMapField(Field field2, int i, Object obj, Internal.EnumVerifier enumVerifier2) {
        Object obj2 = obj;
        Internal.checkNotNull(obj2, "mapDefaultEntry");
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, FieldType.MAP, null, null, 0, false, true, null, null, obj2, enumVerifier2, null);
    }

    private FieldInfo(Field field2, int i, FieldType fieldType, Class<?> cls, Field field3, int i2, boolean z, boolean z2, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier2, Field field4) {
        this.field = field2;
        this.type = fieldType;
        this.messageClass = cls;
        this.fieldNumber = i;
        this.presenceField = field3;
        this.presenceMask = i2;
        this.required = z;
        this.enforceUtf8 = z2;
        this.oneof = oneofInfo;
        this.oneofStoredType = cls2;
        this.mapDefaultEntry = obj;
        this.enumVerifier = enumVerifier2;
        this.cachedSizeField = field4;
    }

    public final int getFieldNumber() {
        return this.fieldNumber;
    }

    public final Field getField() {
        return this.field;
    }

    public final FieldType getType() {
        return this.type;
    }

    public final OneofInfo getOneof() {
        return this.oneof;
    }

    public final Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public final Internal.EnumVerifier getEnumVerifier() {
        return this.enumVerifier;
    }

    public final int compareTo(FieldInfo fieldInfo) {
        return this.fieldNumber - fieldInfo.fieldNumber;
    }

    public final Class<?> getListElementType() {
        return this.messageClass;
    }

    public final Field getPresenceField() {
        return this.presenceField;
    }

    public final Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public final int getPresenceMask() {
        return this.presenceMask;
    }

    public final boolean isRequired() {
        return this.required;
    }

    public final boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public final Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    /* renamed from: com.google.protobuf.FieldInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType = new int[FieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$google$protobuf$FieldType[FieldType.MESSAGE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$FieldType[FieldType.MESSAGE_LIST.ordinal()] = 3;
            try {
                $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final Class<?> getMessageFieldClass() {
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (i == 1 || i == 2) {
            Field field2 = this.field;
            return field2 != null ? field2.getType() : this.oneofStoredType;
        } else if (i == 3 || i == 4) {
            return this.messageClass;
        } else {
            return null;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static final class Builder {
        private Field cachedSizeField;
        private boolean enforceUtf8;
        private Internal.EnumVerifier enumVerifier;
        private Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private OneofInfo oneof;
        private Class<?> oneofStoredType;
        private Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
        }

        public final Builder withField(Field field2) {
            if (this.oneof == null) {
                this.field = field2;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public final Builder withType(FieldType fieldType) {
            this.type = fieldType;
            return this;
        }

        public final Builder withFieldNumber(int i) {
            this.fieldNumber = i;
            return this;
        }

        public final Builder withPresence(Field field2, int i) {
            this.presenceField = (Field) Internal.checkNotNull(field2, "presenceField");
            this.presenceMask = i;
            return this;
        }

        public final Builder withOneof(OneofInfo oneofInfo, Class<?> cls) {
            if (this.field == null && this.presenceField == null) {
                this.oneof = oneofInfo;
                this.oneofStoredType = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public final Builder withRequired(boolean z) {
            this.required = z;
            return this;
        }

        public final Builder withMapDefaultEntry(Object obj) {
            this.mapDefaultEntry = obj;
            return this;
        }

        public final Builder withEnforceUtf8(boolean z) {
            this.enforceUtf8 = z;
            return this;
        }

        public final Builder withEnumVerifier(Internal.EnumVerifier enumVerifier2) {
            this.enumVerifier = enumVerifier2;
            return this;
        }

        public final Builder withCachedSizeField(Field field2) {
            this.cachedSizeField = field2;
            return this;
        }

        public final FieldInfo build() {
            OneofInfo oneofInfo = this.oneof;
            if (oneofInfo != null) {
                return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, oneofInfo, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
            }
            Object obj = this.mapDefaultEntry;
            if (obj != null) {
                return FieldInfo.forMapField(this.field, this.fieldNumber, obj, this.enumVerifier);
            }
            Field field2 = this.presenceField;
            if (field2 == null) {
                Internal.EnumVerifier enumVerifier2 = this.enumVerifier;
                if (enumVerifier2 != null) {
                    Field field3 = this.cachedSizeField;
                    if (field3 == null) {
                        return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2);
                    }
                    return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2, field3);
                }
                Field field4 = this.cachedSizeField;
                if (field4 == null) {
                    return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
                }
                return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, field4);
            } else if (this.required) {
                return FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            } else {
                return FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            }
        }
    }
}
