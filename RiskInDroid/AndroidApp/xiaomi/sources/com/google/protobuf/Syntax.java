package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;

public enum Syntax implements ProtocolMessageEnum {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    private static final Syntax[] VALUES = values();
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = new Internal.EnumLiteMap<Syntax>() {
        /* class com.google.protobuf.Syntax.AnonymousClass1 */

        public final Syntax findValueByNumber(int i) {
            return Syntax.forNumber(i);
        }
    };
    private final int value;

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Syntax valueOf(int i) {
        return forNumber(i);
    }

    public static Syntax forNumber(int i) {
        if (i == 0) {
            return SYNTAX_PROTO2;
        }
        if (i != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[enumValueDescriptor.getIndex()];
        }
    }

    private Syntax(int i) {
        this.value = i;
    }
}
