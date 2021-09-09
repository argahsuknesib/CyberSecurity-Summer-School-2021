package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DynamicMessage extends AbstractMessage {
    public final FieldSet<Descriptors.FieldDescriptor> fields;
    private int memoizedSize = -1;
    public final Descriptors.FieldDescriptor[] oneofCases;
    public final Descriptors.Descriptor type;
    public final UnknownFieldSet unknownFields;

    DynamicMessage(Descriptors.Descriptor descriptor, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor[] fieldDescriptorArr, UnknownFieldSet unknownFieldSet) {
        this.type = descriptor;
        this.fields = fieldSet;
        this.oneofCases = fieldDescriptorArr;
        this.unknownFields = unknownFieldSet;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor descriptor) {
        return new DynamicMessage(descriptor, FieldSet.emptySet(), new Descriptors.FieldDescriptor[descriptor.toProto().getOneofDeclCount()], UnknownFieldSet.getDefaultInstance());
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, CodedInputStream codedInputStream) throws IOException {
        return ((Builder) newBuilder(descriptor).mergeFrom(codedInputStream)).buildParsed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
     arg types: [com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistry]
     candidates:
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType */
    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, CodedInputStream codedInputStream, ExtensionRegistry extensionRegistry) throws IOException {
        return ((Builder) newBuilder(descriptor).mergeFrom(codedInputStream, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, ByteString byteString) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(descriptor).mergeFrom(byteString)).buildParsed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
     arg types: [com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistry]
     candidates:
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType */
    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, ByteString byteString, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(descriptor).mergeFrom(byteString, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, byte[] bArr) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(descriptor).mergeFrom(bArr)).buildParsed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
     arg types: [byte[], com.google.protobuf.ExtensionRegistry]
     candidates:
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType */
    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, byte[] bArr, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(descriptor).mergeFrom(bArr, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, InputStream inputStream) throws IOException {
        return ((Builder) newBuilder(descriptor).mergeFrom(inputStream)).buildParsed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
     arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistry]
     candidates:
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.Message.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
      com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType */
    public static DynamicMessage parseFrom(Descriptors.Descriptor descriptor, InputStream inputStream, ExtensionRegistry extensionRegistry) throws IOException {
        return ((Builder) newBuilder(descriptor).mergeFrom(inputStream, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static Builder newBuilder(Descriptors.Descriptor descriptor) {
        return new Builder(descriptor);
    }

    public static Builder newBuilder(Message message) {
        return new Builder(message.getDescriptorForType()).mergeFrom(message);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    public final DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    public final Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    public final boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        verifyOneofContainingType(oneofDescriptor);
        return this.oneofCases[oneofDescriptor.getIndex()] != null;
    }

    public final Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
        verifyOneofContainingType(oneofDescriptor);
        return this.oneofCases[oneofDescriptor.getIndex()];
    }

    public final boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        return this.fields.hasField(fieldDescriptor);
    }

    public final Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        Object field = this.fields.getField(fieldDescriptor);
        if (field != null) {
            return field;
        }
        if (fieldDescriptor.isRepeated()) {
            return Collections.emptyList();
        }
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return getDefaultInstance(fieldDescriptor.getMessageType());
        }
        return fieldDescriptor.getDefaultValue();
    }

    public final int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        verifyContainingType(fieldDescriptor);
        return this.fields.getRepeatedFieldCount(fieldDescriptor);
    }

    public final Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        verifyContainingType(fieldDescriptor);
        return this.fields.getRepeatedField(fieldDescriptor, i);
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    static boolean isInitialized(Descriptors.Descriptor descriptor, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        for (Descriptors.FieldDescriptor next : descriptor.getFields()) {
            if (next.isRequired() && !fieldSet.hasField(next)) {
                return false;
            }
        }
        return fieldSet.isInitialized();
    }

    public final boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(codedOutputStream);
            this.unknownFields.writeAsMessageSetTo(codedOutputStream);
            return;
        }
        this.fields.writeTo(codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }

    public final int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            i2 = this.fields.getMessageSetSerializedSize();
            i = this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            i2 = this.fields.getSerializedSize();
            i = this.unknownFields.getSerializedSize();
        }
        int i4 = i2 + i;
        this.memoizedSize = i4;
        return i4;
    }

    public final Builder newBuilderForType() {
        return new Builder(this.type);
    }

    public final Builder toBuilder() {
        return newBuilderForType().mergeFrom((Message) this);
    }

    public final Parser<DynamicMessage> getParserForType() {
        return new AbstractParser<DynamicMessage>() {
            /* class com.google.protobuf.DynamicMessage.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
             arg types: [com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite]
             candidates:
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.Message.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
              com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType */
            public DynamicMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder newBuilder = DynamicMessage.newBuilder(DynamicMessage.this.type);
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };
    }

    private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor oneofDescriptor) {
        if (oneofDescriptor.getContainingType() != this.type) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    public static final class Builder extends AbstractMessage.Builder<Builder> {
        private FieldSet<Descriptors.FieldDescriptor> fields;
        private final Descriptors.FieldDescriptor[] oneofCases;
        private final Descriptors.Descriptor type;
        private UnknownFieldSet unknownFields;

        private Builder(Descriptors.Descriptor descriptor) {
            this.type = descriptor;
            this.fields = FieldSet.newFieldSet();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[descriptor.toProto().getOneofDeclCount()];
            if (descriptor.getOptions().getMapEntry()) {
                populateMapEntry();
            }
        }

        private void populateMapEntry() {
            for (Descriptors.FieldDescriptor next : this.type.getFields()) {
                if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    this.fields.setField(next, DynamicMessage.getDefaultInstance(next.getMessageType()));
                } else {
                    this.fields.setField(next, next.getDefaultValue());
                }
            }
        }

        public final Builder clear() {
            if (this.fields.isImmutable()) {
                this.fields = FieldSet.newFieldSet();
            } else {
                this.fields.clear();
            }
            if (this.type.getOptions().getMapEntry()) {
                populateMapEntry();
            }
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        }

        public final Builder mergeFrom(Message message) {
            if (!(message instanceof DynamicMessage)) {
                return (Builder) super.mergeFrom(message);
            }
            DynamicMessage dynamicMessage = (DynamicMessage) message;
            if (dynamicMessage.type == this.type) {
                ensureIsMutable();
                this.fields.mergeFrom(dynamicMessage.fields);
                mergeUnknownFields(dynamicMessage.unknownFields);
                int i = 0;
                while (true) {
                    Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                    if (i >= fieldDescriptorArr.length) {
                        return this;
                    }
                    if (fieldDescriptorArr[i] == null) {
                        fieldDescriptorArr[i] = dynamicMessage.oneofCases[i];
                    } else if (!(dynamicMessage.oneofCases[i] == null || this.oneofCases[i] == dynamicMessage.oneofCases[i])) {
                        this.fields.clearField(this.oneofCases[i]);
                        this.oneofCases[i] = dynamicMessage.oneofCases[i];
                    }
                    i++;
                }
            } else {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
        }

        public final DynamicMessage build() {
            if (isInitialized()) {
                return buildPartial();
            }
            Descriptors.Descriptor descriptor = this.type;
            FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            throw newUninitializedMessageException((Message) new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields));
        }

        public final DynamicMessage buildParsed() throws InvalidProtocolBufferException {
            if (isInitialized()) {
                return buildPartial();
            }
            Descriptors.Descriptor descriptor = this.type;
            FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            throw newUninitializedMessageException((Message) new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields)).asInvalidProtocolBufferException();
        }

        public final DynamicMessage buildPartial() {
            this.fields.makeImmutable();
            Descriptors.Descriptor descriptor = this.type;
            FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            return new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.unknownFields);
        }

        public final Builder clone() {
            Builder builder = new Builder(this.type);
            builder.fields.mergeFrom(this.fields);
            builder.mergeUnknownFields(this.unknownFields);
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
            System.arraycopy(fieldDescriptorArr, 0, builder.oneofCases, 0, fieldDescriptorArr.length);
            return builder;
        }

        public final boolean isInitialized() {
            return DynamicMessage.isInitialized(this.type, this.fields);
        }

        public final Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        public final DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        public final Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        public final Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return new Builder(fieldDescriptor.getMessageType());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        public final boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            return this.oneofCases[oneofDescriptor.getIndex()] != null;
        }

        public final Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            return this.oneofCases[oneofDescriptor.getIndex()];
        }

        public final Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            verifyOneofContainingType(oneofDescriptor);
            Descriptors.FieldDescriptor fieldDescriptor = this.oneofCases[oneofDescriptor.getIndex()];
            if (fieldDescriptor != null) {
                clearField(fieldDescriptor);
            }
            return this;
        }

        public final boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            return this.fields.hasField(fieldDescriptor);
        }

        public final Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            Object field = this.fields.getField(fieldDescriptor);
            if (field != null) {
                return field;
            }
            if (fieldDescriptor.isRepeated()) {
                return Collections.emptyList();
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType());
            }
            return fieldDescriptor.getDefaultValue();
        }

        public final Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
                ensureEnumValueDescriptor(fieldDescriptor, obj);
            }
            Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                int index = containingOneof.getIndex();
                Descriptors.FieldDescriptor fieldDescriptor2 = this.oneofCases[index];
                if (!(fieldDescriptor2 == null || fieldDescriptor2 == fieldDescriptor)) {
                    this.fields.clearField(fieldDescriptor2);
                }
                this.oneofCases[index] = fieldDescriptor;
            } else if (fieldDescriptor.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3 && !fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && obj.equals(fieldDescriptor.getDefaultValue())) {
                this.fields.clearField(fieldDescriptor);
                return this;
            }
            this.fields.setField(fieldDescriptor, obj);
            return this;
        }

        public final Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                int index = containingOneof.getIndex();
                Descriptors.FieldDescriptor[] fieldDescriptorArr = this.oneofCases;
                if (fieldDescriptorArr[index] == fieldDescriptor) {
                    fieldDescriptorArr[index] = null;
                }
            }
            this.fields.clearField(fieldDescriptor);
            return this;
        }

        public final int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            verifyContainingType(fieldDescriptor);
            return this.fields.getRepeatedFieldCount(fieldDescriptor);
        }

        public final Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            verifyContainingType(fieldDescriptor);
            return this.fields.getRepeatedField(fieldDescriptor, i);
        }

        public final Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            this.fields.setRepeatedField(fieldDescriptor, i, obj);
            return this;
        }

        public final Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            verifyContainingType(fieldDescriptor);
            ensureIsMutable();
            this.fields.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            return this;
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
            return this;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.type) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.getContainingType() != this.type) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        private void ensureSingularEnumValueDescriptor(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            Internal.checkNotNull(obj);
            if (!(obj instanceof Descriptors.EnumValueDescriptor)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void ensureEnumValueDescriptor(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.isRepeated()) {
                for (Object ensureSingularEnumValueDescriptor : (List) obj) {
                    ensureSingularEnumValueDescriptor(fieldDescriptor, ensureSingularEnumValueDescriptor);
                }
                return;
            }
            ensureSingularEnumValueDescriptor(fieldDescriptor, obj);
        }

        private void ensureIsMutable() {
            if (this.fields.isImmutable()) {
                this.fields = this.fields.clone();
            }
        }

        public final Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        public final Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }
    }
}
