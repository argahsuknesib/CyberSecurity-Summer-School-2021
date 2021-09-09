package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;

public enum NullValue implements ProtocolMessageEnum {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    private static final NullValue[] VALUES = values();
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = new Internal.EnumLiteMap<NullValue>() {
        /* class com.google.protobuf.NullValue.AnonymousClass1 */

        public final NullValue findValueByNumber(int i) {
            return NullValue.forNumber(i);
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
    public static NullValue valueOf(int i) {
        return forNumber(i);
    }

    public static NullValue forNumber(int i) {
        if (i != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return StructProto.getDescriptor().getEnumTypes().get(0);
    }

    public static NullValue valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[enumValueDescriptor.getIndex()];
        }
    }

    private NullValue(int i) {
        this.value = i;
    }
}
