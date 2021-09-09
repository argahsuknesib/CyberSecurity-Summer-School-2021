package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageV3 implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = new Api();
    public static final Parser<Api> PARSER = new AbstractParser<Api>() {
        /* class com.google.protobuf.Api.AnonymousClass1 */

        public final Api parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Api(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    public List<Method> methods_;
    public List<Mixin> mixins_;
    public volatile Object name_;
    public List<Option> options_;
    public SourceContext sourceContext_;
    public int syntax_;
    public volatile Object version_;

    private Api(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Api() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    /* access modifiers changed from: protected */
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Api();
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            if (!z2 || !true) {
                                this.methods_ = new ArrayList();
                                z2 |= true;
                            }
                            this.methods_.add(codedInputStream.readMessage(Method.parser(), extensionRegistryLite));
                        } else if (readTag == 26) {
                            if (!z2 || !true) {
                                this.options_ = new ArrayList();
                                z2 |= true;
                            }
                            this.options_.add(codedInputStream.readMessage(Option.parser(), extensionRegistryLite));
                        } else if (readTag == 34) {
                            this.version_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                            this.sourceContext_ = (SourceContext) codedInputStream.readMessage(SourceContext.parser(), extensionRegistryLite);
                            if (builder != null) {
                                builder.mergeFrom(this.sourceContext_);
                                this.sourceContext_ = builder.buildPartial();
                            }
                        } else if (readTag == 50) {
                            if (!z2 || !true) {
                                this.mixins_ = new ArrayList();
                                z2 |= true;
                            }
                            this.mixins_.add(codedInputStream.readMessage(Mixin.parser(), extensionRegistryLite));
                        } else if (readTag == 56) {
                            this.syntax_ = codedInputStream.readEnum();
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
                        this.methods_ = Collections.unmodifiableList(this.methods_);
                    }
                    if (z2 && true) {
                        this.options_ = Collections.unmodifiableList(this.options_);
                    }
                    if (z2 && true) {
                        this.mixins_ = Collections.unmodifiableList(this.mixins_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.methods_ = Collections.unmodifiableList(this.methods_);
            }
            if (z2 && true) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            if (z2 && true) {
                this.mixins_ = Collections.unmodifiableList(this.mixins_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
            return;
        }
        throw new NullPointerException();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    /* access modifiers changed from: protected */
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
    }

    public final String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    public final ByteString getNameBytes() {
        Object obj = this.name_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.name_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public final List<Method> getMethodsList() {
        return this.methods_;
    }

    public final List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    public final int getMethodsCount() {
        return this.methods_.size();
    }

    public final Method getMethods(int i) {
        return this.methods_.get(i);
    }

    public final MethodOrBuilder getMethodsOrBuilder(int i) {
        return this.methods_.get(i);
    }

    public final List<Option> getOptionsList() {
        return this.options_;
    }

    public final List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    public final int getOptionsCount() {
        return this.options_.size();
    }

    public final Option getOptions(int i) {
        return this.options_.get(i);
    }

    public final OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public final String getVersion() {
        Object obj = this.version_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.version_ = stringUtf8;
        return stringUtf8;
    }

    public final ByteString getVersionBytes() {
        Object obj = this.version_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.version_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public final boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public final SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    public final SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    public final List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public final List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    public final int getMixinsCount() {
        return this.mixins_.size();
    }

    public final Mixin getMixins(int i) {
        return this.mixins_.get(i);
    }

    public final MixinOrBuilder getMixinsOrBuilder(int i) {
        return this.mixins_.get(i);
    }

    public final int getSyntaxValue() {
        return this.syntax_;
    }

    public final Syntax getSyntax() {
        Syntax valueOf = Syntax.valueOf(this.syntax_);
        return valueOf == null ? Syntax.UNRECOGNIZED : valueOf;
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        for (int i = 0; i < this.methods_.size(); i++) {
            codedOutputStream.writeMessage(2, this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        if (!getVersionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.version_);
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(7, this.syntax_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public final int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        for (int i2 = 0; i2 < this.methods_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.methods_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (!getVersionBytes().isEmpty()) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.version_);
        }
        if (this.sourceContext_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i4 = 0; i4 < this.mixins_.size(); i4++) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, this.mixins_.get(i4));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(7, this.syntax_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Api)) {
            return super.equals(obj);
        }
        Api api = (Api) obj;
        if (!getName().equals(api.getName()) || !getMethodsList().equals(api.getMethodsList()) || !getOptionsList().equals(api.getOptionsList()) || !getVersion().equals(api.getVersion()) || hasSourceContext() != api.hasSourceContext()) {
            return false;
        }
        if ((!hasSourceContext() || getSourceContext().equals(api.getSourceContext())) && getMixinsList().equals(api.getMixinsList()) && this.syntax_ == api.syntax_ && this.unknownFields.equals(api.unknownFields)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getMethodsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int hashCode2 = (((hashCode * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext()) {
            hashCode2 = (((hashCode2 * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        if (getMixinsCount() > 0) {
            hashCode2 = (((hashCode2 * 37) + 6) * 53) + getMixinsList().hashCode();
        }
        int hashCode3 = (((((hashCode2 * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    public static Api parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Api parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Api parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Api parseFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Api parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public final Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Api api) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApiOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> methodsBuilder_;
        private List<Method> methods_;
        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> mixinsBuilder_;
        private List<Mixin> mixins_;
        private Object name_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;
        private Object version_;

        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getMethodsFieldBuilder();
                getOptionsFieldBuilder();
                getMixinsFieldBuilder();
            }
        }

        public final Builder clear() {
            super.clear();
            this.name_ = "";
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.methods_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            this.version_ = "";
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV33 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                this.mixins_ = Collections.emptyList();
                this.bitField0_ &= -5;
            } else {
                repeatedFieldBuilderV33.clear();
            }
            this.syntax_ = 0;
            return this;
        }

        public final Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        public final Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        public final Api build() {
            Api buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        public final Api buildPartial() {
            Api api = new Api(this);
            api.name_ = this.name_;
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.methods_ = Collections.unmodifiableList(this.methods_);
                    this.bitField0_ &= -2;
                }
                api.methods_ = this.methods_;
            } else {
                api.methods_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -3;
                }
                api.options_ = this.options_;
            } else {
                api.options_ = repeatedFieldBuilderV32.build();
            }
            api.version_ = this.version_;
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                api.sourceContext_ = this.sourceContext_;
            } else {
                api.sourceContext_ = singleFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV33 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.mixins_ = Collections.unmodifiableList(this.mixins_);
                    this.bitField0_ &= -5;
                }
                api.mixins_ = this.mixins_;
            } else {
                api.mixins_ = repeatedFieldBuilderV33.build();
            }
            api.syntax_ = this.syntax_;
            onBuilt();
            return api;
        }

        public final Builder clone() {
            return (Builder) super.clone();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.Api.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Api$Builder
          com.google.protobuf.Api.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
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
          com.google.protobuf.Api.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Api$Builder
          com.google.protobuf.Api.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
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
          com.google.protobuf.Api.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Api$Builder
          com.google.protobuf.Api.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public final Builder mergeFrom(Message message) {
            if (message instanceof Api) {
                return mergeFrom((Api) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public final Builder mergeFrom(Api api) {
            if (api == Api.getDefaultInstance()) {
                return this;
            }
            if (!api.getName().isEmpty()) {
                this.name_ = api.name_;
                onChanged();
            }
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = null;
            if (this.methodsBuilder_ == null) {
                if (!api.methods_.isEmpty()) {
                    if (this.methods_.isEmpty()) {
                        this.methods_ = api.methods_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMethodsIsMutable();
                        this.methods_.addAll(api.methods_);
                    }
                    onChanged();
                }
            } else if (!api.methods_.isEmpty()) {
                if (this.methodsBuilder_.isEmpty()) {
                    this.methodsBuilder_.dispose();
                    this.methodsBuilder_ = null;
                    this.methods_ = api.methods_;
                    this.bitField0_ &= -2;
                    this.methodsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMethodsFieldBuilder() : null;
                } else {
                    this.methodsBuilder_.addAllMessages(api.methods_);
                }
            }
            if (this.optionsBuilder_ == null) {
                if (!api.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = api.options_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(api.options_);
                    }
                    onChanged();
                }
            } else if (!api.options_.isEmpty()) {
                if (this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = api.options_;
                    this.bitField0_ &= -3;
                    this.optionsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                } else {
                    this.optionsBuilder_.addAllMessages(api.options_);
                }
            }
            if (!api.getVersion().isEmpty()) {
                this.version_ = api.version_;
                onChanged();
            }
            if (api.hasSourceContext()) {
                mergeSourceContext(api.getSourceContext());
            }
            if (this.mixinsBuilder_ == null) {
                if (!api.mixins_.isEmpty()) {
                    if (this.mixins_.isEmpty()) {
                        this.mixins_ = api.mixins_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureMixinsIsMutable();
                        this.mixins_.addAll(api.mixins_);
                    }
                    onChanged();
                }
            } else if (!api.mixins_.isEmpty()) {
                if (this.mixinsBuilder_.isEmpty()) {
                    this.mixinsBuilder_.dispose();
                    this.mixinsBuilder_ = null;
                    this.mixins_ = api.mixins_;
                    this.bitField0_ &= -5;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getMixinsFieldBuilder();
                    }
                    this.mixinsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.mixinsBuilder_.addAllMessages(api.mixins_);
                }
            }
            if (api.syntax_ != 0) {
                setSyntaxValue(api.getSyntaxValue());
            }
            mergeUnknownFields(api.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Api api;
            Api api2 = null;
            try {
                Api parsePartialFrom = Api.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                api = (Api) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th) {
                th = th;
                api2 = api;
                if (api2 != null) {
                }
                throw th;
            }
        }

        public final String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getNameBytes() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.methods_ = new ArrayList(this.methods_);
                this.bitField0_ |= 1;
            }
        }

        public final List<Method> getMethodsList() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.methods_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        public final int getMethodsCount() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        public final Method getMethods(int i) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public final Builder setMethods(int i, Method method) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, method);
            } else if (method != null) {
                ensureMethodsIsMutable();
                this.methods_.set(i, method);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder setMethods(int i, Method.Builder builder) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public final Builder addMethods(Method method) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(method);
            } else if (method != null) {
                ensureMethodsIsMutable();
                this.methods_.add(method);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addMethods(int i, Method method) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, method);
            } else if (method != null) {
                ensureMethodsIsMutable();
                this.methods_.add(i, method);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addMethods(Method.Builder builder) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public final Builder addMethods(int i, Method.Builder builder) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<? extends com.google.protobuf.Method>, java.util.List<com.google.protobuf.Method>]
         candidates:
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
        public final Builder addAllMethods(Iterable<? extends Method> iterable) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.methods_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public final Builder clearMethods() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.methods_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public final Builder removeMethods(int i) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public final Method.Builder getMethodsBuilder(int i) {
            return getMethodsFieldBuilder().getBuilder(i);
        }

        public final MethodOrBuilder getMethodsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        public final List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.methods_);
        }

        public final Method.Builder addMethodsBuilder() {
            return getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public final Method.Builder addMethodsBuilder(int i) {
            return getMethodsFieldBuilder().addBuilder(i, Method.getDefaultInstance());
        }

        public final List<Method.Builder> getMethodsBuilderList() {
            return getMethodsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> getMethodsFieldBuilder() {
            if (this.methodsBuilder_ == null) {
                List<Method> list = this.methods_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.methodsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.methods_ = null;
            }
            return this.methodsBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 2;
            }
        }

        public final List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        public final int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        public final Option getOptions(int i) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public final Builder setOptions(int i, Option option) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, option);
            } else if (option != null) {
                ensureOptionsIsMutable();
                this.options_.set(i, option);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder setOptions(int i, Option.Builder builder) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public final Builder addOptions(Option option) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(option);
            } else if (option != null) {
                ensureOptionsIsMutable();
                this.options_.add(option);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addOptions(int i, Option option) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, option);
            } else if (option != null) {
                ensureOptionsIsMutable();
                this.options_.add(i, option);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addOptions(Option.Builder builder) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public final Builder addOptions(int i, Option.Builder builder) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<? extends com.google.protobuf.Option>, java.util.List<com.google.protobuf.Option>]
         candidates:
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
        public final Builder addAllOptions(Iterable<? extends Option> iterable) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.options_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public final Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public final Builder removeOptions(int i) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public final Option.Builder getOptionsBuilder(int i) {
            return getOptionsFieldBuilder().getBuilder(i);
        }

        public final OptionOrBuilder getOptionsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        public final List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.options_);
        }

        public final Option.Builder addOptionsBuilder() {
            return getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public final Option.Builder addOptionsBuilder(int i) {
            return getOptionsFieldBuilder().addBuilder(i, Option.getDefaultInstance());
        }

        public final List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        public final String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.version_ = stringUtf8;
            return stringUtf8;
        }

        public final ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Builder setVersion(String str) {
            if (str != null) {
                this.version_ = str;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final Builder clearVersion() {
            this.version_ = Api.getDefaultInstance().getVersion();
            onChanged();
            return this;
        }

        public final Builder setVersionBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final boolean hasSourceContext() {
            return (this.sourceContextBuilder_ == null && this.sourceContext_ == null) ? false : true;
        }

        public final SourceContext getSourceContext() {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessage();
            }
            SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
        }

        public final Builder setSourceContext(SourceContext sourceContext) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(sourceContext);
            } else if (sourceContext != null) {
                this.sourceContext_ = sourceContext;
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder setSourceContext(SourceContext.Builder builder) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sourceContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public final Builder mergeSourceContext(SourceContext sourceContext) {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                SourceContext sourceContext2 = this.sourceContext_;
                if (sourceContext2 != null) {
                    this.sourceContext_ = SourceContext.newBuilder(sourceContext2).mergeFrom(sourceContext).buildPartial();
                } else {
                    this.sourceContext_ = sourceContext;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(sourceContext);
            }
            return this;
        }

        public final Builder clearSourceContext() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
                onChanged();
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            return this;
        }

        public final SourceContext.Builder getSourceContextBuilder() {
            onChanged();
            return getSourceContextFieldBuilder().getBuilder();
        }

        public final SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
        }

        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContextBuilder_ = new SingleFieldBuilderV3<>(getSourceContext(), getParentForChildren(), isClean());
                this.sourceContext_ = null;
            }
            return this.sourceContextBuilder_;
        }

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.mixins_ = new ArrayList(this.mixins_);
                this.bitField0_ |= 4;
            }
        }

        public final List<Mixin> getMixinsList() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.mixins_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        public final int getMixinsCount() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        public final Mixin getMixins(int i) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public final Builder setMixins(int i, Mixin mixin) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, mixin);
            } else if (mixin != null) {
                ensureMixinsIsMutable();
                this.mixins_.set(i, mixin);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder setMixins(int i, Mixin.Builder builder) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public final Builder addMixins(Mixin mixin) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(mixin);
            } else if (mixin != null) {
                ensureMixinsIsMutable();
                this.mixins_.add(mixin);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addMixins(int i, Mixin mixin) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, mixin);
            } else if (mixin != null) {
                ensureMixinsIsMutable();
                this.mixins_.add(i, mixin);
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public final Builder addMixins(Mixin.Builder builder) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public final Builder addMixins(int i, Mixin.Builder builder) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
         arg types: [java.lang.Iterable<? extends com.google.protobuf.Mixin>, java.util.List<com.google.protobuf.Mixin>]
         candidates:
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
          com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
        public final Builder addAllMixins(Iterable<? extends Mixin> iterable) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.mixins_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public final Builder clearMixins() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.mixins_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public final Builder removeMixins(int i) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public final Mixin.Builder getMixinsBuilder(int i) {
            return getMixinsFieldBuilder().getBuilder(i);
        }

        public final MixinOrBuilder getMixinsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        public final List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.mixins_);
        }

        public final Mixin.Builder addMixinsBuilder() {
            return getMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
        }

        public final Mixin.Builder addMixinsBuilder(int i) {
            return getMixinsFieldBuilder().addBuilder(i, Mixin.getDefaultInstance());
        }

        public final List<Mixin.Builder> getMixinsBuilderList() {
            return getMixinsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> getMixinsFieldBuilder() {
            if (this.mixinsBuilder_ == null) {
                this.mixinsBuilder_ = new RepeatedFieldBuilderV3<>(this.mixins_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.mixins_ = null;
            }
            return this.mixinsBuilder_;
        }

        public final int getSyntaxValue() {
            return this.syntax_;
        }

        public final Builder setSyntaxValue(int i) {
            this.syntax_ = i;
            onChanged();
            return this;
        }

        public final Syntax getSyntax() {
            Syntax valueOf = Syntax.valueOf(this.syntax_);
            return valueOf == null ? Syntax.UNRECOGNIZED : valueOf;
        }

        public final Builder setSyntax(Syntax syntax) {
            if (syntax != null) {
                this.syntax_ = syntax.getNumber();
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public final Builder clearSyntax() {
            this.syntax_ = 0;
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

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    public final Parser<Api> getParserForType() {
        return PARSER;
    }

    public final Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
