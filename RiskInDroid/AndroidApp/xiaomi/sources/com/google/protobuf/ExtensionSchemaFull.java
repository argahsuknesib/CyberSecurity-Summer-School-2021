package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();

    ExtensionSchemaFull() {
    }

    private static <T> long getExtensionsFieldOffset() {
        try {
            return UnsafeUtil.objectFieldOffset(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
        } catch (Throwable unused) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3.ExtendableMessage;
    }

    public final FieldSet<Descriptors.FieldDescriptor> getExtensions(Object obj) {
        return (FieldSet) UnsafeUtil.getObject(obj, EXTENSION_FIELD_OFFSET);
    }

    /* access modifiers changed from: package-private */
    public final void setExtensions(Object obj, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        UnsafeUtil.putObject(obj, EXTENSION_FIELD_OFFSET, fieldSet);
    }

    /* access modifiers changed from: package-private */
    public final FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object obj) {
        FieldSet<Descriptors.FieldDescriptor> extensions = getExtensions(obj);
        if (!extensions.isImmutable()) {
            return extensions;
        }
        FieldSet<Descriptors.FieldDescriptor> clone = extensions.clone();
        setExtensions(obj, clone);
        return clone;
    }

    /* access modifiers changed from: package-private */
    public final void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB parseExtension(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException {
        Object field;
        ArrayList arrayList;
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        int number = extensionInfo.descriptor.getNumber();
        if (!extensionInfo.descriptor.isRepeated() || !extensionInfo.descriptor.isPacked()) {
            Object obj2 = null;
            if (extensionInfo.descriptor.getLiteType() != WireFormat.FieldType.ENUM) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(reader.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(reader.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(reader.readInt64());
                        break;
                    case 4:
                        obj2 = Long.valueOf(reader.readUInt64());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(reader.readInt32());
                        break;
                    case 6:
                        obj2 = Long.valueOf(reader.readFixed64());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(reader.readFixed32());
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        obj2 = Boolean.valueOf(reader.readBool());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(reader.readUInt32());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(reader.readSFixed32());
                        break;
                    case 11:
                        obj2 = Long.valueOf(reader.readSFixed64());
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        obj2 = Integer.valueOf(reader.readSInt32());
                        break;
                    case 13:
                        obj2 = Long.valueOf(reader.readSInt64());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        obj2 = reader.readBytes();
                        break;
                    case 16:
                        obj2 = reader.readString();
                        break;
                    case 17:
                        obj2 = reader.readGroup(extensionInfo.defaultInstance.getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        obj2 = reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite);
                        break;
                }
            } else {
                int readInt32 = reader.readInt32();
                obj2 = extensionInfo.descriptor.getEnumType().findValueByNumber(readInt32);
                if (obj2 == null) {
                    return SchemaUtil.storeUnknownEnum(number, readInt32, ub, unknownFieldSchema);
                }
            }
            if (extensionInfo.descriptor.isRepeated()) {
                fieldSet.addRepeatedField(extensionInfo.descriptor, obj2);
            } else {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()];
                if ((i == 17 || i == 18) && (field = fieldSet.getField(extensionInfo.descriptor)) != null) {
                    obj2 = Internal.mergeMessage(field, obj2);
                }
                fieldSet.setField(extensionInfo.descriptor, obj2);
            }
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    reader.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    reader.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    reader.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    reader.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    reader.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    reader.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    reader.readFixed32List(arrayList);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    arrayList = new ArrayList();
                    reader.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    reader.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    reader.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    reader.readSFixed64List(arrayList);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    arrayList = new ArrayList();
                    reader.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    reader.readSInt64List(arrayList);
                    break;
                case 14:
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    reader.readEnumList(arrayList2);
                    ArrayList arrayList3 = new ArrayList();
                    for (Integer intValue : arrayList2) {
                        int intValue2 = intValue.intValue();
                        Descriptors.EnumValueDescriptor findValueByNumber = extensionInfo.descriptor.getEnumType().findValueByNumber(intValue2);
                        if (findValueByNumber != null) {
                            arrayList3.add(findValueByNumber);
                        } else {
                            ub = SchemaUtil.storeUnknownEnum(number, intValue2, ub, unknownFieldSchema);
                        }
                    }
                    arrayList = arrayList3;
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + extensionInfo.descriptor.getLiteType());
            }
            fieldSet.setField(extensionInfo.descriptor, arrayList);
        }
        return ub;
    }

    /* renamed from: com.google.protobuf.ExtensionSchemaFull$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int extensionNumber(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).getNumber();
    }

    /* access modifiers changed from: package-private */
    public final void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.isRepeated()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    SchemaUtil.writeDoubleList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 2:
                    SchemaUtil.writeFloatList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 3:
                    SchemaUtil.writeInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 4:
                    SchemaUtil.writeUInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 5:
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 6:
                    SchemaUtil.writeFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 7:
                    SchemaUtil.writeFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    SchemaUtil.writeBoolList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 9:
                    SchemaUtil.writeUInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 10:
                    SchemaUtil.writeSFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 11:
                    SchemaUtil.writeSFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    SchemaUtil.writeSInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 13:
                    SchemaUtil.writeSInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 14:
                    ArrayList arrayList = new ArrayList();
                    for (Descriptors.EnumValueDescriptor number : (List) entry.getValue()) {
                        arrayList.add(Integer.valueOf(number.getNumber()));
                    }
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList, writer, fieldDescriptor.isPacked());
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    SchemaUtil.writeBytesList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.writeStringList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    SchemaUtil.writeGroupList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 18:
                    SchemaUtil.writeMessageList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(fieldDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.writeFloat(fieldDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.writeInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.writeUInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.writeFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.writeFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    writer.writeBool(fieldDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.writeUInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.writeSFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.writeSFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    writer.writeSInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.writeSInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Descriptors.EnumValueDescriptor) entry.getValue()).getNumber());
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    writer.writeBytes(fieldDescriptor.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.writeString(fieldDescriptor.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.writeGroup(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                case 18:
                    writer.writeMessage(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return ((ExtensionRegistry) extensionRegistryLite).findExtensionByNumber(((Message) messageLite).getDescriptorForType(), i);
    }

    /* access modifiers changed from: package-private */
    public final void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            fieldSet.setField(extensionInfo.descriptor, reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite));
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, reader.readBytes()));
    }

    /* access modifiers changed from: package-private */
    public final void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        Message buildPartial = extensionInfo.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            BinaryReader newInstance = BinaryReader.newInstance(ByteBuffer.wrap(byteString.toByteArray()), true);
            Protobuf.getInstance().mergeFrom(buildPartial, newInstance, extensionRegistryLite);
            fieldSet.setField(extensionInfo.descriptor, buildPartial);
            if (newInstance.getFieldNumber() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
    }
}
