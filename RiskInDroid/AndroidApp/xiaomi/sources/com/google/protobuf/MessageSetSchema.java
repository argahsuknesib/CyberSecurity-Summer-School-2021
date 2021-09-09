package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema2;
        this.hasExtensions = extensionSchema2.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema2, extensionSchema2, messageLite);
    }

    public final T newInstance() {
        return this.defaultInstance.newBuilderForType().buildPartial();
    }

    public final boolean equals(T t, T t2) {
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    public final void mergeFrom(T t, T t2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    public final void writeTo(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeAsMessageSetTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        GeneratedMessageLite generatedMessageLite = t;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
            unknownFieldSetLite = UnknownFieldSetLite.newInstance();
            generatedMessageLite.unknownFields = unknownFieldSetLite;
        }
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> ensureExtensionsAreMutable = ((GeneratedMessageLite.ExtendableMessage) t).ensureExtensionsAreMutable();
        GeneratedMessageLite.GeneratedExtension generatedExtension = null;
        while (i < i2) {
            int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
            int i3 = registers.int1;
            if (i3 == WireFormat.MESSAGE_SET_ITEM_TAG) {
                int i4 = 0;
                ByteString byteString = null;
                while (decodeVarint32 < i2) {
                    decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, decodeVarint32, registers);
                    int i5 = registers.int1;
                    int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
                    int tagWireType = WireFormat.getTagWireType(i5);
                    if (tagFieldNumber != 2) {
                        if (tagFieldNumber == 3) {
                            if (generatedExtension != null) {
                                decodeVarint32 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass()), bArr, decodeVarint32, i2, registers);
                                ensureExtensionsAreMutable.setField(generatedExtension.descriptor, registers.object1);
                            } else if (tagWireType == 2) {
                                decodeVarint32 = ArrayDecoders.decodeBytes(bArr, decodeVarint32, registers);
                                byteString = (ByteString) registers.object1;
                            }
                        }
                    } else if (tagWireType == 0) {
                        decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, decodeVarint32, registers);
                        i4 = registers.int1;
                        generatedExtension = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, i4);
                    }
                    if (i5 == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                        break;
                    }
                    decodeVarint32 = ArrayDecoders.skipField(i5, bArr, decodeVarint32, i2, registers);
                }
                if (byteString != null) {
                    unknownFieldSetLite.storeField(WireFormat.makeTag(i4, 2), byteString);
                }
                i = decodeVarint32;
            } else if (WireFormat.getTagWireType(i3) == 2) {
                GeneratedMessageLite.GeneratedExtension findExtensionByNumber = this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(i3));
                if (findExtensionByNumber != null) {
                    i = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) findExtensionByNumber.getMessageDefaultInstance().getClass()), bArr, decodeVarint32, i2, registers);
                    ensureExtensionsAreMutable.setField(findExtensionByNumber.descriptor, registers.object1);
                } else {
                    i = ArrayDecoders.decodeUnknownField(i3, bArr, decodeVarint32, i2, unknownFieldSetLite, registers);
                }
                generatedExtension = findExtensionByNumber;
            } else {
                i = ArrayDecoders.skipField(i3, bArr, decodeVarint32, i2, registers);
            }
        }
        if (i != i2) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public final void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, ExtensionSchema<ET> extensionSchema2, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t);
        FieldSet<ET> mutableExtensions = extensionSchema2.getMutableExtensions(t);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
                    return;
                }
            } finally {
                unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema2, mutableExtensions, unknownFieldSchema2, builderFromMessage));
    }

    public final void makeImmutable(T t) {
        this.unknownFieldSchema.makeImmutable(t);
        this.extensionSchema.makeImmutable(t);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema2, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema2, UB ub) throws IOException {
        int tag = reader.getTag();
        if (tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
            int i = 0;
            Object obj = null;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i = reader.readUInt32();
                    obj = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, i);
                } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (obj != null) {
                        extensionSchema2.parseLengthPrefixedMessageSetItem(reader, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                if (byteString != null) {
                    if (obj != null) {
                        extensionSchema2.parseMessageSetItem(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema2.addLengthDelimited(ub, i, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (WireFormat.getTagWireType(tag) != 2) {
            return reader.skipField();
        } else {
            Object findExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (findExtensionByNumber == null) {
                return unknownFieldSchema2.mergeOneFieldFrom(ub, reader);
            }
            extensionSchema2.parseLengthPrefixedMessageSetItem(reader, findExtensionByNumber, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    public final boolean isInitialized(T t) {
        return this.extensionSchema.getExtensions(t).isInitialized();
    }

    public final int getSerializedSize(T t) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t) + 0;
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSizeAsMessageSet(unknownFieldSchema2.getFromMessage(t));
    }
}
