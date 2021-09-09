package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public final class Struct extends GeneratedMessageV3 implements StructOrBuilder {
    private static final Struct DEFAULT_INSTANCE = new Struct();
    public static final Parser<Struct> PARSER = new AbstractParser<Struct>() {
        /* class com.google.protobuf.Struct.AnonymousClass1 */

        public final Struct parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Struct(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    public MapField<String, Value> fields_;
    private byte memoizedIsInitialized;

    private Struct(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Struct() {
        this.memoizedIsInitialized = -1;
    }

    /* access modifiers changed from: protected */
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Struct();
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Struct(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite != null) {
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.fields_ = MapField.newMapField(FieldsDefaultEntryHolder.defaultEntry);
                                z2 |= true;
                            }
                            MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                            this.fields_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
            return;
        }
        throw new NullPointerException();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    /* access modifiers changed from: protected */
    public final MapField internalGetMapField(int i) {
        if (i == 1) {
            return internalGetFields();
        }
        throw new RuntimeException("Invalid map field number: ".concat(String.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    static final class FieldsDefaultEntryHolder {
        static final MapEntry<String, Value> defaultEntry = MapEntry.newDefaultInstance(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    public final MapField<String, Value> internalGetFields() {
        MapField<String, Value> mapField = this.fields_;
        return mapField == null ? MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry) : mapField;
    }

    public final int getFieldsCount() {
        return internalGetFields().getMap().size();
    }

    public final boolean containsFields(String str) {
        if (str != null) {
            return internalGetFields().getMap().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Deprecated
    public final Map<String, Value> getFields() {
        return getFieldsMap();
    }

    public final Map<String, Value> getFieldsMap() {
        return internalGetFields().getMap();
    }

    public final Value getFieldsOrDefault(String str, Value value) {
        if (str != null) {
            Map<String, Value> map = internalGetFields().getMap();
            return map.containsKey(str) ? map.get(str) : value;
        }
        throw new NullPointerException();
    }

    public final Value getFieldsOrThrow(String str) {
        if (str != null) {
            Map<String, Value> map = internalGetFields().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }
        throw new NullPointerException();
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        this.unknownFields.writeTo(codedOutputStream);
    }

    public final int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (Map.Entry next : internalGetFields().getMap().entrySet()) {
            i2 += CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(next.getKey()).setValue(next.getValue()).build());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Struct)) {
            return super.equals(obj);
        }
        Struct struct = (Struct) obj;
        if (internalGetFields().equals(struct.internalGetFields()) && this.unknownFields.equals(struct.unknownFields)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (!internalGetFields().getMap().isEmpty()) {
            hashCode = (((hashCode * 37) + 1) * 53) + internalGetFields().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static Struct parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Struct parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Struct parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Struct parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Struct parseFrom(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public final Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Struct struct) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(struct);
    }

    public final Builder toBuilder() {
        if (this == DEFAULT_INSTANCE) {
            return new Builder();
        }
        return new Builder().mergeFrom(this);
    }

    /* access modifiers changed from: protected */
    public final Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StructOrBuilder {
        private int bitField0_;
        private MapField<String, Value> fields_;

        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        /* access modifiers changed from: protected */
        public final MapField internalGetMapField(int i) {
            if (i == 1) {
                return internalGetFields();
            }
            throw new RuntimeException("Invalid map field number: ".concat(String.valueOf(i)));
        }

        /* access modifiers changed from: protected */
        public final MapField internalGetMutableMapField(int i) {
            if (i == 1) {
                return internalGetMutableFields();
            }
            throw new RuntimeException("Invalid map field number: ".concat(String.valueOf(i)));
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public final Builder clear() {
            super.clear();
            internalGetMutableFields().clear();
            return this;
        }

        public final Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        public final Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        public final Struct build() {
            Struct buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        public final Struct buildPartial() {
            Struct struct = new Struct(this);
            struct.fields_ = internalGetFields();
            struct.fields_.makeImmutable();
            onBuilt();
            return struct;
        }

        public final Builder clone() {
            return (Builder) super.clone();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.Struct.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Struct.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Struct$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
         candidates:
          com.google.protobuf.Struct.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Struct.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Struct$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
        public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.Struct.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Struct.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Struct$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public final Builder mergeFrom(Message message) {
            if (message instanceof Struct) {
                return mergeFrom((Struct) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public final Builder mergeFrom(Struct struct) {
            if (struct == Struct.getDefaultInstance()) {
                return this;
            }
            internalGetMutableFields().mergeFrom(struct.internalGetFields());
            mergeUnknownFields(struct.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Struct struct;
            Struct struct2 = null;
            try {
                Struct parsePartialFrom = Struct.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                struct = (Struct) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th) {
                th = th;
                struct2 = struct;
                if (struct2 != null) {
                }
                throw th;
            }
        }

        private MapField<String, Value> internalGetFields() {
            MapField<String, Value> mapField = this.fields_;
            return mapField == null ? MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry) : mapField;
        }

        private MapField<String, Value> internalGetMutableFields() {
            onChanged();
            if (this.fields_ == null) {
                this.fields_ = MapField.newMapField(FieldsDefaultEntryHolder.defaultEntry);
            }
            if (!this.fields_.isMutable()) {
                this.fields_ = this.fields_.copy();
            }
            return this.fields_;
        }

        public final int getFieldsCount() {
            return internalGetFields().getMap().size();
        }

        public final boolean containsFields(String str) {
            if (str != null) {
                return internalGetFields().getMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Deprecated
        public final Map<String, Value> getFields() {
            return getFieldsMap();
        }

        public final Map<String, Value> getFieldsMap() {
            return internalGetFields().getMap();
        }

        public final Value getFieldsOrDefault(String str, Value value) {
            if (str != null) {
                Map<String, Value> map = internalGetFields().getMap();
                return map.containsKey(str) ? map.get(str) : value;
            }
            throw new NullPointerException();
        }

        public final Value getFieldsOrThrow(String str) {
            if (str != null) {
                Map<String, Value> map = internalGetFields().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }
            throw new NullPointerException();
        }

        public final Builder clearFields() {
            internalGetMutableFields().getMutableMap().clear();
            return this;
        }

        public final Builder removeFields(String str) {
            if (str != null) {
                internalGetMutableFields().getMutableMap().remove(str);
                return this;
            }
            throw new NullPointerException();
        }

        @Deprecated
        public final Map<String, Value> getMutableFields() {
            return internalGetMutableFields().getMutableMap();
        }

        public final Builder putFields(String str, Value value) {
            if (str == null) {
                throw new NullPointerException();
            } else if (value != null) {
                internalGetMutableFields().getMutableMap().put(str, value);
                return this;
            } else {
                throw new NullPointerException();
            }
        }

        public final Builder putAllFields(Map<String, Value> map) {
            internalGetMutableFields().getMutableMap().putAll(map);
            return this;
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    public final Parser<Struct> getParserForType() {
        return PARSER;
    }

    public final Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
