package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Timestamp extends GeneratedMessageV3 implements TimestampOrBuilder {
    private static final Timestamp DEFAULT_INSTANCE = new Timestamp();
    public static final Parser<Timestamp> PARSER = new AbstractParser<Timestamp>() {
        /* class com.google.protobuf.Timestamp.AnonymousClass1 */

        public final Timestamp parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Timestamp(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    public int nanos_;
    public long seconds_;

    private Timestamp(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Timestamp() {
        this.memoizedIsInitialized = -1;
    }

    /* access modifiers changed from: protected */
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Timestamp();
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Timestamp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite != null) {
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.seconds_ = codedInputStream.readInt64();
                        } else if (readTag == 16) {
                            this.nanos_ = codedInputStream.readInt32();
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
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    /* access modifiers changed from: protected */
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Builder.class);
    }

    public final long getSeconds() {
        return this.seconds_;
    }

    public final int getNanos() {
        return this.nanos_;
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
        long j = this.seconds_;
        if (j != 0) {
            codedOutputStream.writeInt64(1, j);
        }
        int i = this.nanos_;
        if (i != 0) {
            codedOutputStream.writeInt32(2, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public final int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        long j = this.seconds_;
        int i2 = 0;
        if (j != 0) {
            i2 = 0 + CodedOutputStream.computeInt64Size(1, j);
        }
        int i3 = this.nanos_;
        if (i3 != 0) {
            i2 += CodedOutputStream.computeInt32Size(2, i3);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Timestamp)) {
            return super.equals(obj);
        }
        Timestamp timestamp = (Timestamp) obj;
        if (getSeconds() == timestamp.getSeconds() && getNanos() == timestamp.getNanos() && this.unknownFields.equals(timestamp.unknownFields)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + Internal.hashLong(getSeconds())) * 37) + 2) * 53) + getNanos()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Timestamp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Timestamp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Timestamp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Timestamp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Timestamp parseFrom(InputStream inputStream) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Timestamp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public final Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Timestamp timestamp) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(timestamp);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimestampOrBuilder {
        private int nanos_;
        private long seconds_;

        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Builder.class);
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
            this.seconds_ = 0;
            this.nanos_ = 0;
            return this;
        }

        public final Descriptors.Descriptor getDescriptorForType() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
        }

        public final Timestamp getDefaultInstanceForType() {
            return Timestamp.getDefaultInstance();
        }

        public final Timestamp build() {
            Timestamp buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        public final Timestamp buildPartial() {
            Timestamp timestamp = new Timestamp(this);
            timestamp.seconds_ = this.seconds_;
            timestamp.nanos_ = this.nanos_;
            onBuilt();
            return timestamp;
        }

        public final Builder clone() {
            return (Builder) super.clone();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.Timestamp.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Timestamp.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Timestamp$Builder
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
          com.google.protobuf.Timestamp.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Timestamp.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Timestamp$Builder
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
          com.google.protobuf.Timestamp.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Timestamp.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Timestamp$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public final Builder mergeFrom(Message message) {
            if (message instanceof Timestamp) {
                return mergeFrom((Timestamp) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public final Builder mergeFrom(Timestamp timestamp) {
            if (timestamp == Timestamp.getDefaultInstance()) {
                return this;
            }
            if (timestamp.getSeconds() != 0) {
                setSeconds(timestamp.getSeconds());
            }
            if (timestamp.getNanos() != 0) {
                setNanos(timestamp.getNanos());
            }
            mergeUnknownFields(timestamp.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Timestamp timestamp;
            Timestamp timestamp2 = null;
            try {
                Timestamp parsePartialFrom = Timestamp.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                timestamp = (Timestamp) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th) {
                th = th;
                timestamp2 = timestamp;
                if (timestamp2 != null) {
                }
                throw th;
            }
        }

        public final long getSeconds() {
            return this.seconds_;
        }

        public final Builder setSeconds(long j) {
            this.seconds_ = j;
            onChanged();
            return this;
        }

        public final Builder clearSeconds() {
            this.seconds_ = 0;
            onChanged();
            return this;
        }

        public final int getNanos() {
            return this.nanos_;
        }

        public final Builder setNanos(int i) {
            this.nanos_ = i;
            onChanged();
            return this;
        }

        public final Builder clearNanos() {
            this.nanos_ = 0;
            onChanged();
            return this;
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static Timestamp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Timestamp> parser() {
        return PARSER;
    }

    public final Parser<Timestamp> getParserForType() {
        return PARSER;
    }

    public final Timestamp getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
