package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class FieldMask extends GeneratedMessageV3 implements FieldMaskOrBuilder {
    private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
    public static final Parser<FieldMask> PARSER = new AbstractParser<FieldMask>() {
        /* class com.google.protobuf.FieldMask.AnonymousClass1 */

        public final FieldMask parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new FieldMask(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    public LazyStringList paths_;

    private FieldMask(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private FieldMask() {
        this.memoizedIsInitialized = -1;
        this.paths_ = LazyStringArrayList.EMPTY;
    }

    /* access modifiers changed from: protected */
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new FieldMask();
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private FieldMask(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if (!z2 || !true) {
                                this.paths_ = new LazyStringArrayList();
                                z2 |= true;
                            }
                            this.paths_.add(readStringRequireUtf8);
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.paths_ = this.paths_.getUnmodifiableView();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.paths_ = this.paths_.getUnmodifiableView();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
            return;
        }
        throw new NullPointerException();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    /* access modifiers changed from: protected */
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
    }

    public final ProtocolStringList getPathsList() {
        return this.paths_;
    }

    public final int getPathsCount() {
        return this.paths_.size();
    }

    public final String getPaths(int i) {
        return (String) this.paths_.get(i);
    }

    public final ByteString getPathsBytes(int i) {
        return this.paths_.getByteString(i);
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
        for (int i = 0; i < this.paths_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.paths_.getRaw(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public final int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.paths_.size(); i3++) {
            i2 += computeStringSizeNoTag(this.paths_.getRaw(i3));
        }
        int size = i2 + 0 + (getPathsList().size() * 1) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size;
        return size;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldMask)) {
            return super.equals(obj);
        }
        FieldMask fieldMask = (FieldMask) obj;
        if (getPathsList().equals(fieldMask.getPathsList()) && this.unknownFields.equals(fieldMask.unknownFields)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (getPathsCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getPathsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static FieldMask parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static FieldMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FieldMask parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static FieldMask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static FieldMask parseFrom(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public final Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FieldMask fieldMask) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(fieldMask);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldMaskOrBuilder {
        private int bitField0_;
        private LazyStringList paths_;

        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
        }

        private Builder() {
            this.paths_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.paths_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public final Builder clear() {
            super.clear();
            this.paths_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        public final Descriptors.Descriptor getDescriptorForType() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        public final FieldMask getDefaultInstanceForType() {
            return FieldMask.getDefaultInstance();
        }

        public final FieldMask build() {
            FieldMask buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        public final FieldMask buildPartial() {
            FieldMask fieldMask = new FieldMask(this);
            if ((this.bitField0_ & 1) != 0) {
                this.paths_ = this.paths_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            fieldMask.paths_ = this.paths_;
            onBuilt();
            return fieldMask;
        }

        public final Builder clone() {
            return (Builder) super.clone();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.FieldMask.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.FieldMask$Builder
          com.google.protobuf.FieldMask.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
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
          com.google.protobuf.FieldMask.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.FieldMask$Builder
          com.google.protobuf.FieldMask.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
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
          com.google.protobuf.FieldMask.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.FieldMask$Builder
          com.google.protobuf.FieldMask.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public final Builder mergeFrom(Message message) {
            if (message instanceof FieldMask) {
                return mergeFrom((FieldMask) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public final Builder mergeFrom(FieldMask fieldMask) {
            if (fieldMask == FieldMask.getDefaultInstance()) {
                return this;
            }
            if (!fieldMask.paths_.isEmpty()) {
                if (this.paths_.isEmpty()) {
                    this.paths_ = fieldMask.paths_;
                    this.bitField0_ &= -2;
                } else {
                    ensurePathsIsMutable();
                    this.paths_.addAll(fieldMask.paths_);
                }
                onChanged();
            }
            mergeUnknownFields(fieldMask.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            FieldMask fieldMask;
            FieldMask fieldMask2 = null;
            try {
                FieldMask parsePartialFrom = FieldMask.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                fieldMask = (FieldMask) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th) {
                th = th;
                fieldMask2 = fieldMask;
                if (fieldMask2 != null) {
                }
                throw th;
            }
        }

        private void ensurePathsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.paths_ = new LazyStringArrayList(this.paths_);
                this.bitField0_ |= 1;
            }
        }

        public final ProtocolStringList getPathsList() {
            return this.paths_.getUnmodifiableView();
        }

        public final int getPathsCount() {
            return this.paths_.size();
        }

        public final String getPaths(int i) {
            return (String) this.paths_.get(i);
        }

        public final ByteString getPathsBytes(int i) {
            return this.paths_.getByteString(i);
        }

        public final Builder setPaths(int i, String str) {
            if (str != null) {
                ensurePathsIsMutable();
                this.paths_.set(i, str);
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final Builder addPaths(String str) {
            if (str != null) {
                ensurePathsIsMutable();
                this.paths_.add(str);
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<java.lang.String>, com.google.protobuf.LazyStringList]
         candidates:
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
        public final Builder addAllPaths(Iterable<String> iterable) {
            ensurePathsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.paths_);
            onChanged();
            return this;
        }

        public final Builder clearPaths() {
            this.paths_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public final Builder addPathsBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensurePathsIsMutable();
                this.paths_.add(byteString);
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FieldMask> parser() {
        return PARSER;
    }

    public final Parser<FieldMask> getParserForType() {
        return PARSER;
    }

    public final FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
