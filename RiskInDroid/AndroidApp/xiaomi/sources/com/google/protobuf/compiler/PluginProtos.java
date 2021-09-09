package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"F\n\u0007Version\u0012\r\n\u0005major\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005minor\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005patch\u0018\u0003 \u0001(\u0005\u0012\u000e\n\u0006suffix\u0018\u0004 \u0001(\t\"º\u0001\n\u0014CodeGeneratorRequest\u0012\u0018\n\u0010file_to_generate\u0018\u0001 \u0003(\t\u0012\u0011\n\tparameter\u0018\u0002 \u0001(\t\u00128\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProto\u0012;\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.Version\"ª\u0001\n\u0015CodeGeneratorResponse\u0012\r\n\u0005error\u0018\u0001 \u0001(\t\u0012B\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.File\u001a>\n\u0004File\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0017\n\u000finsertion_point\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007content\u0018\u000f \u0001(\tBg\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ9github.com/golang/protobuf/protoc-gen-go/plugin;plugin_go"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
    public static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion"});
    public static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor.getNestedTypes().get(0);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor, new String[]{"Name", "InsertionPoint", "Content"});
    public static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor, new String[]{"Error", "File"});
    public static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor = getDescriptor().getMessageTypes().get(0);
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_Version_descriptor, new String[]{"Major", "Minor", "Patch", "Suffix"});

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int i);

        ByteString getFileToGenerateBytes(int i);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int i);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int i);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int i);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        boolean hasError();
    }

    public interface VersionOrBuilder extends MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private PluginProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Version extends GeneratedMessageV3 implements VersionOrBuilder {
        private static final Version DEFAULT_INSTANCE = new Version();
        @Deprecated
        public static final Parser<Version> PARSER = new AbstractParser<Version>() {
            /* class com.google.protobuf.compiler.PluginProtos.Version.AnonymousClass1 */

            public final Version parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Version(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        public int bitField0_;
        public int major_;
        private byte memoizedIsInitialized;
        public int minor_;
        public int patch_;
        public volatile Object suffix_;

        private Version(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Version() {
            this.memoizedIsInitialized = -1;
            this.suffix_ = "";
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Version();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Version(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite != null) {
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.major_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.minor_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.patch_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                ByteString readBytes = codedInputStream.readBytes();
                                this.bitField0_ = 8 | this.bitField0_;
                                this.suffix_ = readBytes;
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
            return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
        }

        public final boolean hasMajor() {
            return (this.bitField0_ & 1) != 0;
        }

        public final int getMajor() {
            return this.major_;
        }

        public final boolean hasMinor() {
            return (this.bitField0_ & 2) != 0;
        }

        public final int getMinor() {
            return this.minor_;
        }

        public final boolean hasPatch() {
            return (this.bitField0_ & 4) != 0;
        }

        public final int getPatch() {
            return this.patch_;
        }

        public final boolean hasSuffix() {
            return (this.bitField0_ & 8) != 0;
        }

        public final String getSuffix() {
            Object obj = this.suffix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.suffix_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getSuffixBytes() {
            Object obj = this.suffix_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.suffix_ = copyFromUtf8;
            return copyFromUtf8;
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
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.suffix_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) != 0) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i2 += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i2 += GeneratedMessageV3.computeStringSize(4, this.suffix_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return super.equals(obj);
            }
            Version version = (Version) obj;
            if (hasMajor() != version.hasMajor()) {
                return false;
            }
            if ((hasMajor() && getMajor() != version.getMajor()) || hasMinor() != version.hasMinor()) {
                return false;
            }
            if ((hasMinor() && getMinor() != version.getMinor()) || hasPatch() != version.hasPatch()) {
                return false;
            }
            if ((hasPatch() && getPatch() != version.getPatch()) || hasSuffix() != version.hasSuffix()) {
                return false;
            }
            if ((!hasSuffix() || getSuffix().equals(version.getSuffix())) && this.unknownFields.equals(version.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = getDescriptor().hashCode() + 779;
            if (hasMajor()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getMajor();
            }
            if (hasMinor()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMinor();
            }
            if (hasPatch()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getPatch();
            }
            if (hasSuffix()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getSuffix().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Version parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Version parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Version parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Version parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Version parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Version parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Version parseFrom(InputStream inputStream) throws IOException {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Version parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Version parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Version) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Version parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Version parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version version) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(version);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private Object suffix_;

            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            private Builder() {
                this.suffix_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.suffix_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean z = Version.alwaysUseFieldBuilders;
            }

            public final Builder clear() {
                super.clear();
                this.major_ = 0;
                this.bitField0_ &= -2;
                this.minor_ = 0;
                this.bitField0_ &= -3;
                this.patch_ = 0;
                this.bitField0_ &= -5;
                this.suffix_ = "";
                this.bitField0_ &= -9;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            public final Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
            }

            public final Version build() {
                Version buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final Version buildPartial() {
                int i;
                Version version = new Version(this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    version.major_ = this.major_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    version.minor_ = this.minor_;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    version.patch_ = this.patch_;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    i |= 8;
                }
                version.suffix_ = this.suffix_;
                version.bitField0_ = i;
                onBuilt();
                return version;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.google.protobuf.compiler.PluginProtos.Version.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.Version.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$Version$Builder
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
              com.google.protobuf.compiler.PluginProtos.Version.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.Version.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.compiler.PluginProtos$Version$Builder
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
              com.google.protobuf.compiler.PluginProtos.Version.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.Version.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$Version$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof Version) {
                    return mergeFrom((Version) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(Version version) {
                if (version == Version.getDefaultInstance()) {
                    return this;
                }
                if (version.hasMajor()) {
                    setMajor(version.getMajor());
                }
                if (version.hasMinor()) {
                    setMinor(version.getMinor());
                }
                if (version.hasPatch()) {
                    setPatch(version.getPatch());
                }
                if (version.hasSuffix()) {
                    this.bitField0_ |= 8;
                    this.suffix_ = version.suffix_;
                    onChanged();
                }
                mergeUnknownFields(version.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Version version;
                Version version2 = null;
                try {
                    Version parsePartialFrom = Version.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    version = (Version) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    version2 = version;
                    if (version2 != null) {
                    }
                    throw th;
                }
            }

            public final boolean hasMajor() {
                return (this.bitField0_ & 1) != 0;
            }

            public final int getMajor() {
                return this.major_;
            }

            public final Builder setMajor(int i) {
                this.bitField0_ |= 1;
                this.major_ = i;
                onChanged();
                return this;
            }

            public final Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            public final boolean hasMinor() {
                return (this.bitField0_ & 2) != 0;
            }

            public final int getMinor() {
                return this.minor_;
            }

            public final Builder setMinor(int i) {
                this.bitField0_ |= 2;
                this.minor_ = i;
                onChanged();
                return this;
            }

            public final Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            public final boolean hasPatch() {
                return (this.bitField0_ & 4) != 0;
            }

            public final int getPatch() {
                return this.patch_;
            }

            public final Builder setPatch(int i) {
                this.bitField0_ |= 4;
                this.patch_ = i;
                onChanged();
                return this;
            }

            public final Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            public final boolean hasSuffix() {
                return (this.bitField0_ & 8) != 0;
            }

            public final String getSuffix() {
                Object obj = this.suffix_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.suffix_ = stringUtf8;
                }
                return stringUtf8;
            }

            public final ByteString getSuffixBytes() {
                Object obj = this.suffix_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.suffix_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setSuffix(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.suffix_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearSuffix() {
                this.bitField0_ &= -9;
                this.suffix_ = Version.getDefaultInstance().getSuffix();
                onChanged();
                return this;
            }

            public final Builder setSuffixBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.suffix_ = byteString;
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

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Version> parser() {
            return PARSER;
        }

        public final Parser<Version> getParserForType() {
            return PARSER;
        }

        public final Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorRequest extends GeneratedMessageV3 implements CodeGeneratorRequestOrBuilder {
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
        @Deprecated
        public static final Parser<CodeGeneratorRequest> PARSER = new AbstractParser<CodeGeneratorRequest>() {
            /* class com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.AnonymousClass1 */

            public final CodeGeneratorRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CodeGeneratorRequest(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        public int bitField0_;
        public Version compilerVersion_;
        public LazyStringList fileToGenerate_;
        private byte memoizedIsInitialized;
        public volatile Object parameter_;
        public List<DescriptorProtos.FileDescriptorProto> protoFile_;

        private CodeGeneratorRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CodeGeneratorRequest() {
            this.memoizedIsInitialized = -1;
            this.fileToGenerate_ = LazyStringArrayList.EMPTY;
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CodeGeneratorRequest();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CodeGeneratorRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                ByteString readBytes = codedInputStream.readBytes();
                                if (!z2 || !true) {
                                    this.fileToGenerate_ = new LazyStringArrayList();
                                    z2 |= true;
                                }
                                this.fileToGenerate_.add(readBytes);
                            } else if (readTag == 18) {
                                ByteString readBytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.parameter_ = readBytes2;
                            } else if (readTag == 26) {
                                Version.Builder builder = (this.bitField0_ & 2) != 0 ? this.compilerVersion_.toBuilder() : null;
                                this.compilerVersion_ = (Version) codedInputStream.readMessage(Version.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.compilerVersion_);
                                    this.compilerVersion_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag == 122) {
                                if (!z2 || !true) {
                                    this.protoFile_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.protoFile_.add(codedInputStream.readMessage(DescriptorProtos.FileDescriptorProto.PARSER, extensionRegistryLite));
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
                            this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                        }
                        if (z2 && true) {
                            this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (z2 && true) {
                    this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                }
                if (z2 && true) {
                    this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        public final ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        public final int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        public final String getFileToGenerate(int i) {
            return (String) this.fileToGenerate_.get(i);
        }

        public final ByteString getFileToGenerateBytes(int i) {
            return this.fileToGenerate_.getByteString(i);
        }

        public final boolean hasParameter() {
            return (this.bitField0_ & 1) != 0;
        }

        public final String getParameter() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.parameter_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getParameterBytes() {
            Object obj = this.parameter_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.parameter_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        public final List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        public final int getProtoFileCount() {
            return this.protoFile_.size();
        }

        public final DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
            return this.protoFile_.get(i);
        }

        public final DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i) {
            return this.protoFile_.get(i);
        }

        public final boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        public final Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        public final VersionOrBuilder getCompilerVersionOrBuilder() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            for (int i = 0; i < getProtoFileCount(); i++) {
                if (!getProtoFile(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileToGenerate_.getRaw(i));
            }
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                codedOutputStream.writeMessage(15, this.protoFile_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.fileToGenerate_.size(); i3++) {
                i2 += computeStringSizeNoTag(this.fileToGenerate_.getRaw(i3));
            }
            int size = i2 + 0 + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) != 0) {
                size += GeneratedMessageV3.computeStringSize(2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i4 = 0; i4 < this.protoFile_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(15, this.protoFile_.get(i4));
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorRequest)) {
                return super.equals(obj);
            }
            CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj;
            if (!getFileToGenerateList().equals(codeGeneratorRequest.getFileToGenerateList()) || hasParameter() != codeGeneratorRequest.hasParameter()) {
                return false;
            }
            if ((hasParameter() && !getParameter().equals(codeGeneratorRequest.getParameter())) || !getProtoFileList().equals(codeGeneratorRequest.getProtoFileList()) || hasCompilerVersion() != codeGeneratorRequest.hasCompilerVersion()) {
                return false;
            }
            if ((!hasCompilerVersion() || getCompilerVersion().equals(codeGeneratorRequest.getCompilerVersion())) && this.unknownFields.equals(codeGeneratorRequest.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = getDescriptor().hashCode() + 779;
            if (getFileToGenerateCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getFileToGenerateList().hashCode();
            }
            if (hasParameter()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getParameter().hashCode();
            }
            if (getProtoFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getProtoFileList().hashCode();
            }
            if (hasCompilerVersion()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCompilerVersion().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest codeGeneratorRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorRequest);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> compilerVersionBuilder_;
            private Version compilerVersion_;
            private LazyStringList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorRequest.alwaysUseFieldBuilders) {
                    getProtoFileFieldBuilder();
                    getCompilerVersionFieldBuilder();
                }
            }

            public final Builder clear() {
                super.clear();
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                this.parameter_ = "";
                this.bitField0_ &= -3;
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            public final CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            public final CodeGeneratorRequest build() {
                CodeGeneratorRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest codeGeneratorRequest = new CodeGeneratorRequest(this);
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                codeGeneratorRequest.fileToGenerate_ = this.fileToGenerate_;
                int i2 = (i & 2) != 0 ? 1 : 0;
                codeGeneratorRequest.parameter_ = this.parameter_;
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                        this.bitField0_ &= -5;
                    }
                    codeGeneratorRequest.protoFile_ = this.protoFile_;
                } else {
                    codeGeneratorRequest.protoFile_ = repeatedFieldBuilderV3.build();
                }
                if ((i & 8) != 0) {
                    SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        codeGeneratorRequest.compilerVersion_ = this.compilerVersion_;
                    } else {
                        codeGeneratorRequest.compilerVersion_ = singleFieldBuilderV3.build();
                    }
                    i2 |= 2;
                }
                codeGeneratorRequest.bitField0_ = i2;
                onBuilt();
                return codeGeneratorRequest;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$Builder
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
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$Builder
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
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CodeGeneratorRequest) {
                    return mergeFrom((CodeGeneratorRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CodeGeneratorRequest codeGeneratorRequest) {
                if (codeGeneratorRequest == CodeGeneratorRequest.getDefaultInstance()) {
                    return this;
                }
                if (!codeGeneratorRequest.fileToGenerate_.isEmpty()) {
                    if (this.fileToGenerate_.isEmpty()) {
                        this.fileToGenerate_ = codeGeneratorRequest.fileToGenerate_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFileToGenerateIsMutable();
                        this.fileToGenerate_.addAll(codeGeneratorRequest.fileToGenerate_);
                    }
                    onChanged();
                }
                if (codeGeneratorRequest.hasParameter()) {
                    this.bitField0_ |= 2;
                    this.parameter_ = codeGeneratorRequest.parameter_;
                    onChanged();
                }
                if (this.protoFileBuilder_ == null) {
                    if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                        if (this.protoFile_.isEmpty()) {
                            this.protoFile_ = codeGeneratorRequest.protoFile_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureProtoFileIsMutable();
                            this.protoFile_.addAll(codeGeneratorRequest.protoFile_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                    if (this.protoFileBuilder_.isEmpty()) {
                        this.protoFileBuilder_.dispose();
                        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = null;
                        this.protoFileBuilder_ = null;
                        this.protoFile_ = codeGeneratorRequest.protoFile_;
                        this.bitField0_ &= -5;
                        if (CodeGeneratorRequest.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getProtoFileFieldBuilder();
                        }
                        this.protoFileBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.protoFileBuilder_.addAllMessages(codeGeneratorRequest.protoFile_);
                    }
                }
                if (codeGeneratorRequest.hasCompilerVersion()) {
                    mergeCompilerVersion(codeGeneratorRequest.getCompilerVersion());
                }
                mergeUnknownFields(codeGeneratorRequest.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getProtoFileCount(); i++) {
                    if (!getProtoFile(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CodeGeneratorRequest codeGeneratorRequest;
                CodeGeneratorRequest codeGeneratorRequest2 = null;
                try {
                    CodeGeneratorRequest parsePartialFrom = CodeGeneratorRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    codeGeneratorRequest = (CodeGeneratorRequest) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    codeGeneratorRequest2 = codeGeneratorRequest;
                    if (codeGeneratorRequest2 != null) {
                    }
                    throw th;
                }
            }

            private void ensureFileToGenerateIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fileToGenerate_ = new LazyStringArrayList(this.fileToGenerate_);
                    this.bitField0_ |= 1;
                }
            }

            public final ProtocolStringList getFileToGenerateList() {
                return this.fileToGenerate_.getUnmodifiableView();
            }

            public final int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            public final String getFileToGenerate(int i) {
                return (String) this.fileToGenerate_.get(i);
            }

            public final ByteString getFileToGenerateBytes(int i) {
                return this.fileToGenerate_.getByteString(i);
            }

            public final Builder setFileToGenerate(int i, String str) {
                if (str != null) {
                    ensureFileToGenerateIsMutable();
                    this.fileToGenerate_.set(i, str);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder addFileToGenerate(String str) {
                if (str != null) {
                    ensureFileToGenerateIsMutable();
                    this.fileToGenerate_.add(str);
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
            public final Builder addAllFileToGenerate(Iterable<String> iterable) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fileToGenerate_);
                onChanged();
                return this;
            }

            public final Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public final Builder addFileToGenerateBytes(ByteString byteString) {
                if (byteString != null) {
                    ensureFileToGenerateIsMutable();
                    this.fileToGenerate_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final boolean hasParameter() {
                return (this.bitField0_ & 2) != 0;
            }

            public final String getParameter() {
                Object obj = this.parameter_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.parameter_ = stringUtf8;
                }
                return stringUtf8;
            }

            public final ByteString getParameterBytes() {
                Object obj = this.parameter_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.parameter_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setParameter(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.parameter_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearParameter() {
                this.bitField0_ &= -3;
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                onChanged();
                return this;
            }

            public final Builder setParameterBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.parameter_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.protoFile_ = new ArrayList(this.protoFile_);
                    this.bitField0_ |= 4;
                }
            }

            public final List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.protoFile_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            public final int getProtoFileCount() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            public final DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public final Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, fileDescriptorProto);
                } else if (fileDescriptorProto != null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i, fileDescriptorProto);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public final Builder addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(fileDescriptorProto);
                } else if (fileDescriptorProto != null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(fileDescriptorProto);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, fileDescriptorProto);
                } else if (fileDescriptorProto != null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i, fileDescriptorProto);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public final Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends com.google.protobuf.DescriptorProtos$FileDescriptorProto>, java.util.List<com.google.protobuf.DescriptorProtos$FileDescriptorProto>]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.protoFile_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public final Builder clearProtoFile() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public final Builder removeProtoFile(int i) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public final DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int i) {
                return getProtoFileFieldBuilder().getBuilder(i);
            }

            public final DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            public final List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.protoFile_);
            }

            public final DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return getProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public final DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int i) {
                return getProtoFileFieldBuilder().addBuilder(i, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public final List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return getProtoFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ == null) {
                    this.protoFileBuilder_ = new RepeatedFieldBuilderV3<>(this.protoFile_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.protoFile_ = null;
                }
                return this.protoFileBuilder_;
            }

            public final boolean hasCompilerVersion() {
                return (this.bitField0_ & 8) != 0;
            }

            public final Version getCompilerVersion() {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessage();
                }
                Version version = this.compilerVersion_;
                return version == null ? Version.getDefaultInstance() : version;
            }

            public final Builder setCompilerVersion(Version version) {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(version);
                } else if (version != null) {
                    this.compilerVersion_ = version;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public final Builder setCompilerVersion(Version.Builder builder) {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public final Builder mergeCompilerVersion(Version version) {
                Version version2;
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 8) == 0 || (version2 = this.compilerVersion_) == null || version2 == Version.getDefaultInstance()) {
                        this.compilerVersion_ = version;
                    } else {
                        this.compilerVersion_ = Version.newBuilder(this.compilerVersion_).mergeFrom(version).buildPartial();
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(version);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public final Builder clearCompilerVersion() {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public final Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return getCompilerVersionFieldBuilder().getBuilder();
            }

            public final VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Version version = this.compilerVersion_;
                return version == null ? Version.getDefaultInstance() : version;
            }

            private SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> getCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ == null) {
                    this.compilerVersionBuilder_ = new SingleFieldBuilderV3<>(getCompilerVersion(), getParentForChildren(), isClean());
                    this.compilerVersion_ = null;
                }
                return this.compilerVersionBuilder_;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        public final Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        public final CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorResponse extends GeneratedMessageV3 implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
        @Deprecated
        public static final Parser<CodeGeneratorResponse> PARSER = new AbstractParser<CodeGeneratorResponse>() {
            /* class com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.AnonymousClass1 */

            public final CodeGeneratorResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CodeGeneratorResponse(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        public int bitField0_;
        public volatile Object error_;
        public List<File> file_;
        private byte memoizedIsInitialized;

        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        private CodeGeneratorResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CodeGeneratorResponse() {
            this.memoizedIsInitialized = -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CodeGeneratorResponse();
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CodeGeneratorResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                ByteString readBytes = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.error_ = readBytes;
                            } else if (readTag == 122) {
                                if (!z2 || !true) {
                                    this.file_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.file_.add(codedInputStream.readMessage(File.PARSER, extensionRegistryLite));
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
                            this.file_ = Collections.unmodifiableList(this.file_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (z2 && true) {
                    this.file_ = Collections.unmodifiableList(this.file_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                return;
            }
            throw new NullPointerException();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
        }

        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
        }

        public static final class File extends GeneratedMessageV3 implements FileOrBuilder {
            private static final File DEFAULT_INSTANCE = new File();
            @Deprecated
            public static final Parser<File> PARSER = new AbstractParser<File>() {
                /* class com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.AnonymousClass1 */

                public final File parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new File(codedInputStream, extensionRegistryLite);
                }
            };
            private static final long serialVersionUID = 0;
            public int bitField0_;
            public volatile Object content_;
            public volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            public volatile Object name_;

            private File(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private File() {
                this.memoizedIsInitialized = -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new File();
            }

            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private File(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite != null) {
                    UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    ByteString readBytes = codedInputStream.readBytes();
                                    this.bitField0_ |= 1;
                                    this.name_ = readBytes;
                                } else if (readTag == 18) {
                                    ByteString readBytes2 = codedInputStream.readBytes();
                                    this.bitField0_ |= 2;
                                    this.insertionPoint_ = readBytes2;
                                } else if (readTag == 122) {
                                    ByteString readBytes3 = codedInputStream.readBytes();
                                    this.bitField0_ |= 4;
                                    this.content_ = readBytes3;
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
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
            }

            public final boolean hasName() {
                return (this.bitField0_ & 1) != 0;
            }

            public final String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.name_ = stringUtf8;
                }
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

            public final boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) != 0;
            }

            public final String getInsertionPoint() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.insertionPoint_ = stringUtf8;
                }
                return stringUtf8;
            }

            public final ByteString getInsertionPointBytes() {
                Object obj = this.insertionPoint_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.insertionPoint_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final boolean hasContent() {
                return (this.bitField0_ & 4) != 0;
            }

            public final String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.content_ = stringUtf8;
                }
                return stringUtf8;
            }

            public final ByteString getContentBytes() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
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
                if ((this.bitField0_ & 1) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 15, this.content_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public final int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.bitField0_ & 1) != 0) {
                    i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i2 += GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    i2 += GeneratedMessageV3.computeStringSize(15, this.content_);
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof File)) {
                    return super.equals(obj);
                }
                File file = (File) obj;
                if (hasName() != file.hasName()) {
                    return false;
                }
                if ((hasName() && !getName().equals(file.getName())) || hasInsertionPoint() != file.hasInsertionPoint()) {
                    return false;
                }
                if ((hasInsertionPoint() && !getInsertionPoint().equals(file.getInsertionPoint())) || hasContent() != file.hasContent()) {
                    return false;
                }
                if ((!hasContent() || getContent().equals(file.getContent())) && this.unknownFields.equals(file.unknownFields)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = getDescriptor().hashCode() + 779;
                if (hasName()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
                }
                if (hasInsertionPoint()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getInsertionPoint().hashCode();
                }
                if (hasContent()) {
                    hashCode = (((hashCode * 37) + 15) * 53) + getContent().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static File parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static File parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static File parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static File parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static File parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static File parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static File parseFrom(InputStream inputStream) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static File parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static File parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static File parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static File parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            public final Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File file) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(file);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private Object insertionPoint_;
                private Object name_;

                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean z = File.alwaysUseFieldBuilders;
                }

                public final Builder clear() {
                    super.clear();
                    this.name_ = "";
                    this.bitField0_ &= -2;
                    this.insertionPoint_ = "";
                    this.bitField0_ &= -3;
                    this.content_ = "";
                    this.bitField0_ &= -5;
                    return this;
                }

                public final Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                public final File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                public final File build() {
                    File buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                public final File buildPartial() {
                    File file = new File(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 0 ? 1 : 0;
                    file.name_ = this.name_;
                    if ((i & 2) != 0) {
                        i2 |= 2;
                    }
                    file.insertionPoint_ = this.insertionPoint_;
                    if ((i & 4) != 0) {
                        i2 |= 4;
                    }
                    file.content_ = this.content_;
                    file.bitField0_ = i2;
                    onBuilt();
                    return file;
                }

                public final Builder clone() {
                    return (Builder) super.clone();
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
                 arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
                 candidates:
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder
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
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder
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
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
                  com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder
                  com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
                  com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
                  com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
                public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                public final Builder mergeFrom(Message message) {
                    if (message instanceof File) {
                        return mergeFrom((File) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public final Builder mergeFrom(File file) {
                    if (file == File.getDefaultInstance()) {
                        return this;
                    }
                    if (file.hasName()) {
                        this.bitField0_ |= 1;
                        this.name_ = file.name_;
                        onChanged();
                    }
                    if (file.hasInsertionPoint()) {
                        this.bitField0_ |= 2;
                        this.insertionPoint_ = file.insertionPoint_;
                        onChanged();
                    }
                    if (file.hasContent()) {
                        this.bitField0_ |= 4;
                        this.content_ = file.content_;
                        onChanged();
                    }
                    mergeUnknownFields(file.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
                public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    File file;
                    File file2 = null;
                    try {
                        File parsePartialFrom = File.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        file = (File) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        file2 = file;
                        if (file2 != null) {
                        }
                        throw th;
                    }
                }

                public final boolean hasName() {
                    return (this.bitField0_ & 1) != 0;
                }

                public final String getName() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.name_ = stringUtf8;
                    }
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
                        this.bitField0_ |= 1;
                        this.name_ = str;
                        onChanged();
                        return this;
                    }
                    throw new NullPointerException();
                }

                public final Builder clearName() {
                    this.bitField0_ &= -2;
                    this.name_ = File.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                public final Builder setNameBytes(ByteString byteString) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.name_ = byteString;
                        onChanged();
                        return this;
                    }
                    throw new NullPointerException();
                }

                public final boolean hasInsertionPoint() {
                    return (this.bitField0_ & 2) != 0;
                }

                public final String getInsertionPoint() {
                    Object obj = this.insertionPoint_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.insertionPoint_ = stringUtf8;
                    }
                    return stringUtf8;
                }

                public final ByteString getInsertionPointBytes() {
                    Object obj = this.insertionPoint_;
                    if (!(obj instanceof String)) {
                        return (ByteString) obj;
                    }
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.insertionPoint_ = copyFromUtf8;
                    return copyFromUtf8;
                }

                public final Builder setInsertionPoint(String str) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.insertionPoint_ = str;
                        onChanged();
                        return this;
                    }
                    throw new NullPointerException();
                }

                public final Builder clearInsertionPoint() {
                    this.bitField0_ &= -3;
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    onChanged();
                    return this;
                }

                public final Builder setInsertionPointBytes(ByteString byteString) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.insertionPoint_ = byteString;
                        onChanged();
                        return this;
                    }
                    throw new NullPointerException();
                }

                public final boolean hasContent() {
                    return (this.bitField0_ & 4) != 0;
                }

                public final String getContent() {
                    Object obj = this.content_;
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.content_ = stringUtf8;
                    }
                    return stringUtf8;
                }

                public final ByteString getContentBytes() {
                    Object obj = this.content_;
                    if (!(obj instanceof String)) {
                        return (ByteString) obj;
                    }
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }

                public final Builder setContent(String str) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.content_ = str;
                        onChanged();
                        return this;
                    }
                    throw new NullPointerException();
                }

                public final Builder clearContent() {
                    this.bitField0_ &= -5;
                    this.content_ = File.getDefaultInstance().getContent();
                    onChanged();
                    return this;
                }

                public final Builder setContentBytes(ByteString byteString) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.content_ = byteString;
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

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            public final Parser<File> getParserForType() {
                return PARSER;
            }

            public final File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public final boolean hasError() {
            return (this.bitField0_ & 1) != 0;
        }

        public final String getError() {
            Object obj = this.error_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.error_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getErrorBytes() {
            Object obj = this.error_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.error_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final List<File> getFileList() {
            return this.file_;
        }

        public final List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public final int getFileCount() {
            return this.file_.size();
        }

        public final File getFile(int i) {
            return this.file_.get(i);
        }

        public final FileOrBuilder getFileOrBuilder(int i) {
            return this.file_.get(i);
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
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.error_);
            }
            for (int i = 0; i < this.file_.size(); i++) {
                codedOutputStream.writeMessage(15, this.file_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) != 0 ? GeneratedMessageV3.computeStringSize(1, this.error_) + 0 : 0;
            for (int i2 = 0; i2 < this.file_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(15, this.file_.get(i2));
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorResponse)) {
                return super.equals(obj);
            }
            CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj;
            if (hasError() != codeGeneratorResponse.hasError()) {
                return false;
            }
            if ((!hasError() || getError().equals(codeGeneratorResponse.getError())) && getFileList().equals(codeGeneratorResponse.getFileList()) && this.unknownFields.equals(codeGeneratorResponse.unknownFields)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = getDescriptor().hashCode() + 779;
            if (hasError()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getError().hashCode();
            }
            if (getFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getFileList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse codeGeneratorResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorResponse);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;

            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.error_ = "";
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorResponse.alwaysUseFieldBuilders) {
                    getFileFieldBuilder();
                }
            }

            public final Builder clear() {
                super.clear();
                this.error_ = "";
                this.bitField0_ &= -2;
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            public final CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            public final CodeGeneratorResponse build() {
                CodeGeneratorResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            public final CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse codeGeneratorResponse = new CodeGeneratorResponse(this);
                int i = 1;
                if ((this.bitField0_ & 1) == 0) {
                    i = 0;
                }
                codeGeneratorResponse.error_ = this.error_;
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.file_ = Collections.unmodifiableList(this.file_);
                        this.bitField0_ &= -3;
                    }
                    codeGeneratorResponse.file_ = this.file_;
                } else {
                    codeGeneratorResponse.file_ = repeatedFieldBuilderV3.build();
                }
                codeGeneratorResponse.bitField0_ = i;
                onBuilt();
                return codeGeneratorResponse;
            }

            public final Builder clone() {
                return (Builder) super.clone();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.GeneratedMessageV3.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
             arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
             candidates:
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Builder
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
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Builder
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
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
              com.google.protobuf.GeneratedMessageV3.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
            public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CodeGeneratorResponse) {
                    return mergeFrom((CodeGeneratorResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CodeGeneratorResponse codeGeneratorResponse) {
                if (codeGeneratorResponse == CodeGeneratorResponse.getDefaultInstance()) {
                    return this;
                }
                if (codeGeneratorResponse.hasError()) {
                    this.bitField0_ |= 1;
                    this.error_ = codeGeneratorResponse.error_;
                    onChanged();
                }
                if (this.fileBuilder_ == null) {
                    if (!codeGeneratorResponse.file_.isEmpty()) {
                        if (this.file_.isEmpty()) {
                            this.file_ = codeGeneratorResponse.file_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureFileIsMutable();
                            this.file_.addAll(codeGeneratorResponse.file_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorResponse.file_.isEmpty()) {
                    if (this.fileBuilder_.isEmpty()) {
                        this.fileBuilder_.dispose();
                        RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = null;
                        this.fileBuilder_ = null;
                        this.file_ = codeGeneratorResponse.file_;
                        this.bitField0_ &= -3;
                        if (CodeGeneratorResponse.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getFileFieldBuilder();
                        }
                        this.fileBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.fileBuilder_.addAllMessages(codeGeneratorResponse.file_);
                    }
                }
                mergeUnknownFields(codeGeneratorResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CodeGeneratorResponse codeGeneratorResponse;
                CodeGeneratorResponse codeGeneratorResponse2 = null;
                try {
                    CodeGeneratorResponse parsePartialFrom = CodeGeneratorResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    codeGeneratorResponse = (CodeGeneratorResponse) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } catch (Throwable th) {
                    th = th;
                    codeGeneratorResponse2 = codeGeneratorResponse;
                    if (codeGeneratorResponse2 != null) {
                    }
                    throw th;
                }
            }

            public final boolean hasError() {
                return (this.bitField0_ & 1) != 0;
            }

            public final String getError() {
                Object obj = this.error_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.error_ = stringUtf8;
                }
                return stringUtf8;
            }

            public final ByteString getErrorBytes() {
                Object obj = this.error_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.error_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final Builder setError(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.error_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder clearError() {
                this.bitField0_ &= -2;
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                onChanged();
                return this;
            }

            public final Builder setErrorBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.error_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.file_ = new ArrayList(this.file_);
                    this.bitField0_ |= 2;
                }
            }

            public final List<File> getFileList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.file_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            public final int getFileCount() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            public final File getFile(int i) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public final Builder setFile(int i, File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, file);
                } else if (file != null) {
                    ensureFileIsMutable();
                    this.file_.set(i, file);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder setFile(int i, File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public final Builder addFile(File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(file);
                } else if (file != null) {
                    ensureFileIsMutable();
                    this.file_.add(file);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder addFile(int i, File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, file);
                } else if (file != null) {
                    ensureFileIsMutable();
                    this.file_.add(i, file);
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            public final Builder addFile(File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public final Builder addFile(int i, File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void
             arg types: [java.lang.Iterable<? extends com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File>, java.util.List<com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File>]
             candidates:
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.Collection):void
              com.google.protobuf.AbstractMessageLite.Builder.addAll(java.lang.Iterable, java.util.List):void */
            public final Builder addAllFile(Iterable<? extends File> iterable) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.file_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public final Builder clearFile() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public final Builder removeFile(int i) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public final File.Builder getFileBuilder(int i) {
                return getFileFieldBuilder().getBuilder(i);
            }

            public final FileOrBuilder getFileOrBuilder(int i) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            public final List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.file_);
            }

            public final File.Builder addFileBuilder() {
                return getFileFieldBuilder().addBuilder(File.getDefaultInstance());
            }

            public final File.Builder addFileBuilder(int i) {
                return getFileFieldBuilder().addBuilder(i, File.getDefaultInstance());
            }

            public final List<File.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ == null) {
                    this.fileBuilder_ = new RepeatedFieldBuilderV3<>(this.file_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        public final Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        public final CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DescriptorProtos.getDescriptor();
    }
}
