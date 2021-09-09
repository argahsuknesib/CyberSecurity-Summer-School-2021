package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        this.memoizedHashCode = Protobuf.getInstance().schemaFor(this).hashCode(this);
        return this.memoizedHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) obj);
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.newInstance();
        }
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.getTagWireType(i) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(i, codedInputStream);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(i, i2);
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(i, byteString);
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom((GeneratedMessageLite) messagetype);
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: BuilderType
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final BuilderType toBuilder() {
        /*
            r1 = this;
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER
            java.lang.Object r0 = r1.dynamicMethod(r0)
            com.google.protobuf.GeneratedMessageLite$Builder r0 = (com.google.protobuf.GeneratedMessageLite.Builder) r0
            r0.mergeFrom(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.toBuilder():com.google.protobuf.GeneratedMessageLite$Builder");
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(codedOutputStream));
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        T t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((GeneratedMessageLite) UnsafeUtil.allocateInstance(cls)).getDefaultInstanceForType();
            if (t != null) {
                defaultInstanceMap.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    protected static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFieldSetLite);
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        protected Builder(MessageType r2) {
            /*
                r1 = this;
                r1.<init>()
                r1.defaultInstance = r2
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE
                java.lang.Object r2 = r2.dynamicMethod(r0)
                com.google.protobuf.GeneratedMessageLite r2 = (com.google.protobuf.GeneratedMessageLite) r2
                r1.instance = r2
                r2 = 0
                r1.isBuilt = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.Builder.<init>(com.google.protobuf.GeneratedMessageLite):void");
        }

        /* access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        protected void copyOnWriteInternal() {
            /*
                r2 = this;
                MessageType r0 = r2.instance
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE
                java.lang.Object r0 = r0.dynamicMethod(r1)
                com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
                MessageType r1 = r2.instance
                r2.mergeFromInstance(r0, r1)
                r2.instance = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.Builder.copyOnWriteInternal():void");
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public final BuilderType clear() {
            /*
                r2 = this;
                MessageType r0 = r2.instance
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE
                java.lang.Object r0 = r0.dynamicMethod(r1)
                com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
                r2.instance = r0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.Builder.clear():com.google.protobuf.GeneratedMessageLite$Builder");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: BuilderType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public BuilderType clone() {
            /*
                r2 = this;
                com.google.protobuf.GeneratedMessageLite r0 = r2.getDefaultInstanceForType()
                com.google.protobuf.GeneratedMessageLite$Builder r0 = r0.newBuilderForType()
                com.google.protobuf.GeneratedMessageLite r1 = r2.buildPartial()
                r0.mergeFrom(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.Builder.clone():com.google.protobuf.GeneratedMessageLite$Builder");
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException(buildPartial);
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((GeneratedMessageLite) messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            Protobuf.getInstance().schemaFor((Object) messagetype).mergeFrom(messagetype, messagetype2);
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor((Object) this.instance).mergeFrom(this.instance, bArr, i, i + i2, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType
         arg types: [byte[], int, int, com.google.protobuf.ExtensionRegistryLite]
         candidates:
          com.google.protobuf.GeneratedMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder
          com.google.protobuf.GeneratedMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType
          com.google.protobuf.AbstractMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.MessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder
          com.google.protobuf.GeneratedMessageLite.Builder.mergeFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):BuilderType */
        public BuilderType mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i, i2, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor((Object) this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.mergeFrom(messagetype.extensions);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownField(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i);
            return parseExtension(codedInputStream, extensionRegistryLite, extensionRegistryLite.findLiteExtensionByNumber(messagetype, tagFieldNumber), i, tagFieldNumber);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
        private boolean parseExtension(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension, int i, int i2) throws IOException {
            boolean z;
            boolean z2;
            Object obj;
            MessageLite messageLite;
            int tagWireType = WireFormat.getTagWireType(i);
            if (generatedExtension != null) {
                if (tagWireType == FieldSet.getWireFormatForFieldType(generatedExtension.descriptor.getLiteType(), false)) {
                    z2 = false;
                    z = false;
                    if (z2) {
                        return parseUnknownField(i, codedInputStream);
                    }
                    ensureExtensionsAreMutable();
                    if (z) {
                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if (generatedExtension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                Object findValueByNumber = generatedExtension.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                                if (findValueByNumber == null) {
                                    return true;
                                }
                                this.extensions.addRepeatedField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(findValueByNumber));
                            }
                        } else {
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.extensions.addRepeatedField(generatedExtension.descriptor, FieldSet.readPrimitiveField(codedInputStream, generatedExtension.descriptor.getLiteType(), false));
                            }
                        }
                        codedInputStream.popLimit(pushLimit);
                    } else {
                        int i3 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[generatedExtension.descriptor.getLiteJavaType().ordinal()];
                        if (i3 == 1) {
                            MessageLite.Builder builder = null;
                            if (!generatedExtension.descriptor.isRepeated() && (messageLite = (MessageLite) this.extensions.getField(generatedExtension.descriptor)) != null) {
                                builder = messageLite.toBuilder();
                            }
                            if (builder == null) {
                                builder = generatedExtension.getMessageDefaultInstance().newBuilderForType();
                            }
                            if (generatedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                                codedInputStream.readGroup(generatedExtension.getNumber(), builder, extensionRegistryLite);
                            } else {
                                codedInputStream.readMessage(builder, extensionRegistryLite);
                            }
                            obj = builder.build();
                        } else if (i3 != 2) {
                            obj = FieldSet.readPrimitiveField(codedInputStream, generatedExtension.descriptor.getLiteType(), false);
                        } else {
                            int readEnum = codedInputStream.readEnum();
                            Object findValueByNumber2 = generatedExtension.descriptor.getEnumType().findValueByNumber(readEnum);
                            if (findValueByNumber2 == null) {
                                mergeVarintField(i2, readEnum);
                                return true;
                            }
                            obj = findValueByNumber2;
                        }
                        if (generatedExtension.descriptor.isRepeated()) {
                            this.extensions.addRepeatedField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(obj));
                        } else {
                            this.extensions.setField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(obj));
                        }
                    }
                    return true;
                } else if (generatedExtension.descriptor.isRepeated && generatedExtension.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(generatedExtension.descriptor.getLiteType(), true)) {
                    z2 = false;
                    z = true;
                    if (z2) {
                    }
                }
            }
            z2 = true;
            z = false;
            if (z2) {
            }
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            if (i == WireFormat.MESSAGE_SET_ITEM_TAG) {
                mergeMessageSetExtensionFromCodedStream(messagetype, codedInputStream, extensionRegistryLite);
                return true;
            } else if (WireFormat.getTagWireType(i) == 2) {
                return parseUnknownField(messagetype, codedInputStream, extensionRegistryLite, i);
            } else {
                return codedInputStream.skipField(i);
            }
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = 0;
            ByteString byteString = null;
            GeneratedExtension generatedExtension = null;
            while (true) {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag != WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                        if (readTag != WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                            if (!codedInputStream.skipField(readTag)) {
                                break;
                            }
                        } else if (i == 0 || generatedExtension == null) {
                            byteString = codedInputStream.readBytes();
                        } else {
                            eagerlyMergeMessageSetExtension(codedInputStream, generatedExtension, extensionRegistryLite, i);
                            byteString = null;
                        }
                    } else {
                        i = codedInputStream.readUInt32();
                        if (i != 0) {
                            generatedExtension = extensionRegistryLite.findLiteExtensionByNumber(messagetype, i);
                        }
                    }
                } else {
                    break;
                }
            }
            codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (byteString != null && i != 0) {
                if (generatedExtension != null) {
                    mergeMessageSetExtensionFromBytes(byteString, extensionRegistryLite, generatedExtension);
                } else if (byteString != null) {
                    mergeLengthDelimitedField(i, byteString);
                }
            }
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            parseExtension(codedInputStream, extensionRegistryLite, generatedExtension, WireFormat.makeTag(i, 2), i);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) throws IOException {
            MessageLite messageLite = (MessageLite) this.extensions.getField(generatedExtension.descriptor);
            MessageLite.Builder builder = messageLite != null ? messageLite.toBuilder() : null;
            if (builder == null) {
                builder = generatedExtension.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(byteString, extensionRegistryLite);
            ensureExtensionsAreMutable().setField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(builder.build()));
        }

        /* access modifiers changed from: package-private */
        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.hasField(checkIsLite.descriptor);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.getRepeatedFieldCount(checkIsLite.descriptor);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            Object field = this.extensions.getField(checkIsLite.descriptor);
            if (field == null) {
                return checkIsLite.defaultValue;
            }
            return checkIsLite.fromFieldSetType(field);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return checkIsLite.singularFromFieldSetType(this.extensions.getRepeatedField(checkIsLite.descriptor, i));
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 r3) {
                this(z);
            }

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: package-private */
        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> fieldSet) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = fieldSet;
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            ((ExtendableMessage) this.instance).extensions = ((ExtendableMessage) this.instance).extensions.clone();
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.instance).extensions;
            if (!fieldSet.isImmutable()) {
                return fieldSet;
            }
            FieldSet<ExtensionDescriptor> clone = fieldSet.clone();
            ((ExtendableMessage) this.instance).extensions = clone;
            return clone;
        }

        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return (ExtendableMessage) this.instance;
            }
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (ExtendableMessage) super.buildPartial();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).hasExtension(extensionLite);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extensionLite);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.google.protobuf.ExtensionLite, com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r2, int i) {
            return ((ExtendableMessage) this.instance).getExtension(r2, i);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(checkIsLite.descriptor, checkIsLite.toFieldSetType(type));
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i, Type type) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(checkIsLite.descriptor, i, checkIsLite.singularToFieldSetType(type));
            return this;
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(checkIsLite.descriptor, checkIsLite.singularToFieldSetType(type));
            return this;
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension<MessageType, T> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(checkIsLite.descriptor);
            return this;
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z), cls);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        public final int getNumber() {
            return this.number;
        }

        public final WireFormat.FieldType getLiteType() {
            return this.type;
        }

        public final WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public final boolean isRepeated() {
            return this.isRepeated;
        }

        public final boolean isPacked() {
            return this.isPacked;
        }

        public final Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        public final MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public final int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
            }
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        /* access modifiers changed from: package-private */
        public Object fromFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularFromFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularFromFieldSetType : (List) obj) {
                arrayList.add(singularFromFieldSetType(singularFromFieldSetType));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public Object singularFromFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.descriptor.enumTypeMap.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        /* access modifiers changed from: package-private */
        public Object toFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularToFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularToFieldSetType : (List) obj) {
                arrayList.add(singularToFieldSetType(singularToFieldSetType));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public Object singularToFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        public Type getDefaultValue() {
            return this.defaultValue;
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName = this.messageClass.getName();

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        SerializedForm(MessageLite messageLite) {
            this.messageClass = messageLite.getClass();
            this.asBytes = messageLite.toByteArray();
        }

        /* access modifiers changed from: protected */
        public final Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e2) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            }
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e2);
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }
    }

    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.isLite()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    protected static final <T extends com.google.protobuf.GeneratedMessageLite<T, ?>> boolean isInitialized(T r2, boolean r3) {
        /*
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED
            java.lang.Object r0 = r2.dynamicMethod(r0)
            java.lang.Byte r0 = (java.lang.Byte) r0
            byte r0 = r0.byteValue()
            r1 = 1
            if (r0 != r1) goto L_0x0010
            return r1
        L_0x0010:
            if (r0 != 0) goto L_0x0014
            r2 = 0
            return r2
        L_0x0014:
            com.google.protobuf.Protobuf r0 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.Schema r0 = r0.schemaFor(r2)
            boolean r0 = r0.isInitialized(r2)
            if (r3 == 0) goto L_0x002c
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r3 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED
            if (r0 == 0) goto L_0x0028
            r1 = r2
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r2.dynamicMethod(r3, r1)
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.isInitialized(com.google.protobuf.GeneratedMessageLite, boolean):boolean");
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T t) {
            this.defaultInstance = t;
        }

        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
        }

        public T parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, bArr, i, i2, extensionRegistryLite);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    static <T extends com.google.protobuf.GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE
            java.lang.Object r1 = r1.dynamicMethod(r0)
            com.google.protobuf.GeneratedMessageLite r1 = (com.google.protobuf.GeneratedMessageLite) r1
            com.google.protobuf.Protobuf r0 = com.google.protobuf.Protobuf.getInstance()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x001b }
            com.google.protobuf.Schema r0 = r0.schemaFor(r1)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x001b }
            com.google.protobuf.CodedInputStreamReader r2 = com.google.protobuf.CodedInputStreamReader.forCodedInput(r2)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x001b }
            r0.mergeFrom(r1, r2, r3)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x001b }
            r0.makeImmutable(r1)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x001b }
            return r1
        L_0x001b:
            r1 = move-exception
            java.lang.Throwable r2 = r1.getCause()
            boolean r2 = r2 instanceof com.google.protobuf.InvalidProtocolBufferException
            if (r2 == 0) goto L_0x002b
            java.lang.Throwable r1 = r1.getCause()
            com.google.protobuf.InvalidProtocolBufferException r1 = (com.google.protobuf.InvalidProtocolBufferException) r1
            throw r1
        L_0x002b:
            throw r1
        L_0x002c:
            r2 = move-exception
            java.lang.Throwable r3 = r2.getCause()
            boolean r3 = r3 instanceof com.google.protobuf.InvalidProtocolBufferException
            if (r3 == 0) goto L_0x003c
            java.lang.Throwable r1 = r2.getCause()
            com.google.protobuf.InvalidProtocolBufferException r1 = (com.google.protobuf.InvalidProtocolBufferException) r1
            throw r1
        L_0x003c:
            com.google.protobuf.InvalidProtocolBufferException r3 = new com.google.protobuf.InvalidProtocolBufferException
            java.lang.String r2 = r2.getMessage()
            r3.<init>(r2)
            com.google.protobuf.InvalidProtocolBufferException r1 = r3.setUnfinishedMessage(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.parsePartialFrom(com.google.protobuf.GeneratedMessageLite, com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.GeneratedMessageLite");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    static <T extends com.google.protobuf.GeneratedMessageLite<T, ?>> T parsePartialFrom(T r7, byte[] r8, int r9, int r10, com.google.protobuf.ExtensionRegistryLite r11) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE
            java.lang.Object r7 = r7.dynamicMethod(r0)
            com.google.protobuf.GeneratedMessageLite r7 = (com.google.protobuf.GeneratedMessageLite) r7
            com.google.protobuf.Protobuf r0 = com.google.protobuf.Protobuf.getInstance()     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            com.google.protobuf.Schema r6 = r0.schemaFor(r7)     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            int r4 = r9 + r10
            com.google.protobuf.ArrayDecoders$Registers r5 = new com.google.protobuf.ArrayDecoders$Registers     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            r5.<init>(r11)     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.mergeFrom(r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            r6.makeImmutable(r7)     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            int r8 = r7.memoizedHashCode     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            if (r8 != 0) goto L_0x0026
            return r7
        L_0x0026:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            r8.<init>()     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
            throw r8     // Catch:{ IOException -> 0x0035, IndexOutOfBoundsException -> 0x002c }
        L_0x002c:
            com.google.protobuf.InvalidProtocolBufferException r8 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            com.google.protobuf.InvalidProtocolBufferException r7 = r8.setUnfinishedMessage(r7)
            throw r7
        L_0x0035:
            r8 = move-exception
            java.lang.Throwable r9 = r8.getCause()
            boolean r9 = r9 instanceof com.google.protobuf.InvalidProtocolBufferException
            if (r9 == 0) goto L_0x0045
            java.lang.Throwable r7 = r8.getCause()
            com.google.protobuf.InvalidProtocolBufferException r7 = (com.google.protobuf.InvalidProtocolBufferException) r7
            throw r7
        L_0x0045:
            com.google.protobuf.InvalidProtocolBufferException r9 = new com.google.protobuf.InvalidProtocolBufferException
            java.lang.String r8 = r8.getMessage()
            r9.<init>(r8)
            com.google.protobuf.InvalidProtocolBufferException r7 = r9.setUnfinishedMessage(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.parsePartialFrom(com.google.protobuf.GeneratedMessageLite, byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.GeneratedMessageLite");
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return parseFrom(t, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, byteString, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T parsePartialFrom;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            parsePartialFrom = parsePartialFrom(t, newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(parsePartialFrom);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, codedInputStream, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(parsePartialFrom);
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }
}
