package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    protected int memoizedSize = -1;

    public interface BuilderParent {
        void markDirty();
    }

    @Deprecated
    protected static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    @Deprecated
    protected static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    /* access modifiers changed from: protected */
    public Message.Builder newBuilderForType(BuilderParent builderParent) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    public List<String> findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    public final String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFields(), codedOutputStream, false);
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSize = i;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFields());
        return this.memoizedSize;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return getDescriptorForType() == message.getDescriptorForType() && compareFields(getAllFields(), message.getAllFields()) && getUnknownFields().equals(message.getUnknownFields());
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashFields = (hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = hashFields;
        return hashFields;
    }

    private static ByteString toByteString(Object obj) {
        if (obj instanceof byte[]) {
            return ByteString.copyFrom((byte[]) obj);
        }
        return (ByteString) obj;
    }

    private static boolean compareBytes(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return toByteString(obj).equals(toByteString(obj2));
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    private static Map convertMapEntryListToMap(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        Message message = (Message) it.next();
        Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
        Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName("key");
        Descriptors.FieldDescriptor findFieldByName2 = descriptorForType.findFieldByName("value");
        Object field = message.getField(findFieldByName2);
        if (field instanceof Descriptors.EnumValueDescriptor) {
            field = Integer.valueOf(((Descriptors.EnumValueDescriptor) field).getNumber());
        }
        hashMap.put(message.getField(findFieldByName), field);
        while (it.hasNext()) {
            Message message2 = (Message) it.next();
            Object field2 = message2.getField(findFieldByName2);
            if (field2 instanceof Descriptors.EnumValueDescriptor) {
                field2 = Integer.valueOf(((Descriptors.EnumValueDescriptor) field2).getNumber());
            }
            hashMap.put(message2.getField(findFieldByName), field2);
        }
        return hashMap;
    }

    private static boolean compareMapField(Object obj, Object obj2) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) obj), convertMapEntryListToMap((List) obj2));
    }

    static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> map, Map<Descriptors.FieldDescriptor, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Descriptors.FieldDescriptor next : map.keySet()) {
            if (!map2.containsKey(next)) {
                return false;
            }
            Object obj = map.get(next);
            Object obj2 = map2.get(next);
            if (next.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
                if (next.isRepeated()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (!compareBytes(list.get(i), list2.get(i))) {
                            return false;
                        }
                    }
                    continue;
                } else if (!compareBytes(obj, obj2)) {
                    return false;
                }
            } else if (next.isMapField()) {
                if (!compareMapField(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static int hashMapField(Object obj) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) obj));
    }

    protected static int hashFields(int i, Map<Descriptors.FieldDescriptor, Object> map) {
        int i2;
        int hashEnum;
        for (Map.Entry next : map.entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
            Object value = next.getValue();
            int number = (i * 37) + fieldDescriptor.getNumber();
            if (fieldDescriptor.isMapField()) {
                i2 = number * 53;
                hashEnum = hashMapField(value);
            } else if (fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                i2 = number * 53;
                hashEnum = value.hashCode();
            } else if (fieldDescriptor.isRepeated()) {
                i2 = number * 53;
                hashEnum = Internal.hashEnumList((List) value);
            } else {
                i2 = number * 53;
                hashEnum = Internal.hashEnum((Internal.EnumLite) value);
            }
            i = i2 + hashEnum;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException((Message) this);
    }

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        public BuilderType clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        public BuilderType clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        public BuilderType clear() {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> key : getAllFields().entrySet()) {
                clearField((Descriptors.FieldDescriptor) key.getKey());
            }
            return this;
        }

        public List<String> findInitializationErrors() {
            return MessageReflection.findMissingFields(this);
        }

        public String getInitializationErrorString() {
            return MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return mergeFrom((Message) abstractMessageLite);
        }

        public BuilderType mergeFrom(Message message) {
            return mergeFrom(message, message.getAllFields());
        }

        /* access modifiers changed from: package-private */
        public BuilderType mergeFrom(Message message, Map<Descriptors.FieldDescriptor, Object> map) {
            if (message.getDescriptorForType() == getDescriptorForType()) {
                for (Map.Entry next : map.entrySet()) {
                    Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
                    if (fieldDescriptor.isRepeated()) {
                        for (Object addRepeatedField : (List) next.getValue()) {
                            addRepeatedField(fieldDescriptor, addRepeatedField);
                        }
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        Message message2 = (Message) getField(fieldDescriptor);
                        if (message2 == message2.getDefaultInstanceForType()) {
                            setField(fieldDescriptor, next.getValue());
                        } else {
                            setField(fieldDescriptor, message2.newBuilderForType().mergeFrom(message2).mergeFrom((Message) next.getValue()).build());
                        }
                    } else {
                        setField(fieldDescriptor, next.getValue());
                    }
                }
                mergeUnknownFields(message.getUnknownFields());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
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
        public BuilderType mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, (ExtensionRegistryLite) ExtensionRegistry.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            UnknownFieldSet.Builder builder;
            int readTag;
            if (codedInputStream.shouldDiscardUnknownFields()) {
                builder = null;
            } else {
                builder = UnknownFieldSet.newBuilder(getUnknownFields());
            }
            do {
                readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                }
            } while (MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new MessageReflection.BuilderAdapter(this), readTag));
            if (builder != null) {
                setUnknownFields(builder.build());
            }
            return this;
        }

        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFieldSet).build());
            return this;
        }

        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public String toString() {
            return TextFormat.printer().printToString(this);
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message) {
            return new UninitializedMessageException(MessageReflection.findMissingFields(message));
        }

        /* access modifiers changed from: package-private */
        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(byteString);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
         arg types: [com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite]
         candidates:
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
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
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType */
        public BuilderType mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(byteString, extensionRegistryLite);
        }

        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int):BuilderType
         arg types: [byte[], int, int]
         candidates:
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int):com.google.protobuf.Message$Builder
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], int, int):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.Message.Builder.mergeFrom(byte[], int, int):com.google.protobuf.Message$Builder
          com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], int, int):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int):BuilderType */
        public BuilderType mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, i, i2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
         arg types: [byte[], com.google.protobuf.ExtensionRegistryLite]
         candidates:
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
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
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType */
        public BuilderType mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, extensionRegistryLite);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType
         arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
         candidates:
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.Message.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Message$Builder
          com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType */
        public BuilderType mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            return (Builder) super.mergeFrom(inputStream);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
         arg types: [java.io.InputStream, com.google.protobuf.ExtensionRegistryLite]
         candidates:
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.Message, java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(byte[], com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
          com.google.protobuf.AbstractMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
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
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(java.io.InputStream, com.google.protobuf.ExtensionRegistryLite):BuilderType */
        public BuilderType mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Builder) super.mergeFrom(inputStream, extensionRegistryLite);
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
        }
    }

    @Deprecated
    protected static int hashEnum(Internal.EnumLite enumLite) {
        return enumLite.getNumber();
    }

    @Deprecated
    protected static int hashEnumList(List<? extends Internal.EnumLite> list) {
        int i = 1;
        for (Internal.EnumLite hashEnum : list) {
            i = (i * 31) + hashEnum(hashEnum);
        }
        return i;
    }
}
