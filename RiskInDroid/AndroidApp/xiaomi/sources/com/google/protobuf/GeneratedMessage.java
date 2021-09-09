package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    public static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        Message getDefaultInstanceForType();

        <Type> Type getExtension(Extension<MessageType, Type> extension);

        <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int i);

        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(Extension<MessageType, Type> extension);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    /* access modifiers changed from: protected */
    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    /* access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* access modifiers changed from: protected */
    public abstract Message.Builder newBuilderForType(BuilderParent builderParent);

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
        int i = 0;
        while (i < fields.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = fields.get(i);
            Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                i += containingOneof.getFieldCount() - 1;
                if (hasOneof(containingOneof)) {
                    fieldDescriptor = getOneofFieldDescriptor(containingOneof);
                } else {
                    i++;
                }
            } else {
                if (fieldDescriptor.isRepeated()) {
                    List list = (List) getField(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else if (!hasField(fieldDescriptor)) {
                }
                i++;
            }
            if (!z || fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) {
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                i++;
            } else {
                treeMap.put(fieldDescriptor, getFieldRaw(fieldDescriptor));
                i++;
            }
        }
        return treeMap;
    }

    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor next : getDescriptorForType().getFields()) {
            if (next.isRequired() && !hasField(next)) {
                return false;
            }
            if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (next.isRepeated()) {
                    for (Message isInitialized : (List) getField(next)) {
                        if (!isInitialized.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(next) && !((Message) getField(next)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    /* access modifiers changed from: package-private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).has(this);
    }

    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).get(this);
    }

    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
    }

    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
    }

    /* access modifiers changed from: package-private */
    public Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRaw(this);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i);
    }

    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return builder.mergeFieldFrom(i, codedInputStream);
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream inputStream) throws IOException {
        try {
            return (Message) parser.parseFrom(inputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return (Message) parser.parseFrom(inputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream codedInputStream) throws IOException {
        try {
            return (Message) parser.parseFrom(codedInputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return (Message) parser.parseFrom(codedInputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream inputStream) throws IOException {
        try {
            return (Message) parser.parseDelimitedFrom(inputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return (Message) parser.parseDelimitedFrom(inputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        return this.memoizedSize;
    }

    /* access modifiers changed from: protected */
    public Message.Builder newBuilderForType(final AbstractMessage.BuilderParent builderParent) {
        return newBuilderForType((BuilderParent) new BuilderParent() {
            /* class com.google.protobuf.GeneratedMessage.AnonymousClass1 */

            public void markDirty() {
                builderParent.markDirty();
            }
        });
    }

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        /* access modifiers changed from: protected */
        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(BuilderParent builderParent2) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent2;
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            this.builderParent = null;
        }

        /* access modifiers changed from: protected */
        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* access modifiers changed from: protected */
        public void markClean() {
            this.isClean = true;
        }

        /* access modifiers changed from: protected */
        public boolean isClean() {
            return this.isClean;
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
                com.google.protobuf.Message r0 = r2.getDefaultInstanceForType()
                com.google.protobuf.Message$Builder r0 = r0.newBuilderForType()
                com.google.protobuf.GeneratedMessage$Builder r0 = (com.google.protobuf.GeneratedMessage.Builder) r0
                com.google.protobuf.Message r1 = r2.buildPartial()
                r0.mergeFrom(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessage.Builder.clone():com.google.protobuf.GeneratedMessage$Builder");
        }

        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
            int i = 0;
            while (i < fields.size()) {
                Descriptors.FieldDescriptor fieldDescriptor = fields.get(i);
                Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
                if (containingOneof != null) {
                    i += containingOneof.getFieldCount() - 1;
                    if (hasOneof(containingOneof)) {
                        fieldDescriptor = getOneofFieldDescriptor(containingOneof);
                    } else {
                        i++;
                    }
                } else {
                    if (fieldDescriptor.isRepeated()) {
                        List list = (List) getField(fieldDescriptor);
                        if (!list.isEmpty()) {
                            treeMap.put(fieldDescriptor, list);
                        }
                    } else if (!hasField(fieldDescriptor)) {
                    }
                    i++;
                }
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                i++;
            }
            return treeMap;
        }

        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).newBuilder();
        }

        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getBuilder(this);
        }

        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedBuilder(this, i);
        }

        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return internalGetFieldAccessorTable().getOneof(oneofDescriptor).has(this);
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return internalGetFieldAccessorTable().getOneof(oneofDescriptor).get(this);
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object obj = internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
            return fieldDescriptor.isRepeated() ? Collections.unmodifiableList((List) obj) : obj;
        }

        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).set(this, obj);
            return this;
        }

        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).clear(this);
            return this;
        }

        public BuilderType clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            internalGetFieldAccessorTable().getOneof(oneofDescriptor).clear(this);
            return this;
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i);
        }

        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).setRepeated(this, i, obj);
            return this;
        }

        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).addRepeated(this, obj);
            return this;
        }

        public BuilderType setUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            onChanged();
            return this;
        }

        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
            onChanged();
            return this;
        }

        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor next : getDescriptorForType().getFields()) {
                if (next.isRequired() && !hasField(next)) {
                    return false;
                }
                if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (next.isRepeated()) {
                        for (Message isInitialized : (List) getField(next)) {
                            if (!isInitialized.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(next) && !((Message) getField(next)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return builder.mergeFieldFrom(i, codedInputStream);
        }

        class BuilderParentImpl implements BuilderParent {
            private BuilderParentImpl() {
            }

            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        /* access modifiers changed from: protected */
        public BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl();
            }
            return this.meAsParent;
        }

        /* access modifiers changed from: protected */
        public final void onChanged() {
            BuilderParent builderParent2;
            if (this.isClean && (builderParent2 = this.builderParent) != null) {
                builderParent2.markDirty();
                this.isClean = false;
            }
        }

        /* access modifiers changed from: protected */
        public MapField internalGetMapField(int i) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* access modifiers changed from: protected */
        public MapField internalGetMutableMapField(int i) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        public final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super(extendableBuilder);
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.hasField(checkNotLite.getDescriptor());
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.getRepeatedFieldCount(checkNotLite.getDescriptor());
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            Descriptors.FieldDescriptor descriptor = checkNotLite.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field != null) {
                return checkNotLite.fromReflectionType(field);
            }
            if (descriptor.isRepeated()) {
                return Collections.emptyList();
            }
            if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return checkNotLite.getMessageDefaultInstance();
            }
            return checkNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return checkNotLite.singularFromReflectionType(this.extensions.getRepeatedField(checkNotLite.getDescriptor(), i));
        }

        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((ExtensionLite) generatedExtension);
        }

        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            return getExtensionCount((ExtensionLite) generatedExtension);
        }

        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return getExtension((ExtensionLite) extension);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            return getExtension((ExtensionLite) generatedExtension);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.Extension<MessageType, java.util.List<Type>>, com.google.protobuf.ExtensionLite] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r1, int i) {
            return getExtension((ExtensionLite) r1, i);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.ExtensionLite, com.google.protobuf.GeneratedMessage$GeneratedExtension<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r1, int i) {
            return getExtension((ExtensionLite) r1, i);
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public boolean isInitialized() {
            return GeneratedMessage.super.isInitialized() && extensionsAreInitialized();
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), i);
        }

        /* access modifiers changed from: protected */
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        Descriptors.FieldDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else if (this.next instanceof LazyField.LazyEntry) {
                            codedOutputStream.writeRawMessageSetExtension(key.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (Message) this.next.getValue());
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
        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        /* access modifiers changed from: protected */
        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map<Descriptors.FieldDescriptor, Object> allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map<Descriptors.FieldDescriptor, Object> allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.hasField(fieldDescriptor);
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            Object field = this.extensions.getField(fieldDescriptor);
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

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedFieldCount(fieldDescriptor);
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedField(fieldDescriptor, i);
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.emptySet();

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(BuilderParent builderParent) {
            super(builderParent);
        }

        /* access modifiers changed from: package-private */
        public void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = fieldSet;
        }

        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (ExtendableBuilder) super.clear();
        }

        public BuilderType clone() {
            return (ExtendableBuilder) super.clone();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.hasField(checkNotLite.getDescriptor());
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.getRepeatedFieldCount(checkNotLite.getDescriptor());
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            Descriptors.FieldDescriptor descriptor = checkNotLite.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field != null) {
                return checkNotLite.fromReflectionType(field);
            }
            if (descriptor.isRepeated()) {
                return Collections.emptyList();
            }
            if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return checkNotLite.getMessageDefaultInstance();
            }
            return checkNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return checkNotLite.singularFromReflectionType(this.extensions.getRepeatedField(checkNotLite.getDescriptor(), i));
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(checkNotLite.getDescriptor(), checkNotLite.toReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i, Type type) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(checkNotLite.getDescriptor(), i, checkNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(checkNotLite.getDescriptor(), checkNotLite.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            Extension<MessageType, T> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            ensureExtensionsIsMutable();
            this.extensions.clearField(checkNotLite.getDescriptor());
            onChanged();
            return this;
        }

        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            return hasExtension((ExtensionLite) generatedExtension);
        }

        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            return getExtensionCount((ExtensionLite) generatedExtension);
        }

        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return getExtension((ExtensionLite) extension);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            return getExtension((ExtensionLite) generatedExtension);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.Extension<MessageType, java.util.List<Type>>, com.google.protobuf.ExtensionLite] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r1, int i) {
            return getExtension((ExtensionLite) r1, i);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.ExtensionLite, com.google.protobuf.GeneratedMessage$GeneratedExtension<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r1, int i) {
            return getExtension((ExtensionLite) r1, i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Extension<MessageType, Type>, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.Extension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType */
        public final <Type> BuilderType setExtension(Extension<MessageType, Type> extension, Type type) {
            return setExtension((ExtensionLite) extension, (Object) type);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.GeneratedMessage$GeneratedExtension<MessageType, Type>, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.Extension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType */
        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            return setExtension((ExtensionLite) generatedExtension, (Object) type);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, int, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Extension<MessageType, java.util.List<Type>>, int, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.Extension, int, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, int, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, int, java.lang.Object):BuilderType */
        public final <Type> BuilderType setExtension(Extension<MessageType, List<Type>> extension, int i, Type type) {
            return setExtension((ExtensionLite) extension, i, (Object) type);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, int, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.GeneratedMessage$GeneratedExtension<MessageType, java.util.List<Type>>, int, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.Extension, int, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, int, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setExtension(com.google.protobuf.ExtensionLite, int, java.lang.Object):BuilderType */
        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i, Type type) {
            return setExtension((ExtensionLite) generatedExtension, i, (Object) type);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Extension<MessageType, java.util.List<Type>>, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.Extension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType */
        public final <Type> BuilderType addExtension(Extension<MessageType, List<Type>> extension, Type type) {
            return addExtension((ExtensionLite) extension, (Object) type);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.GeneratedMessage$GeneratedExtension<MessageType, java.util.List<Type>>, Type]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.Extension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.GeneratedMessage$GeneratedExtension, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addExtension(com.google.protobuf.ExtensionLite, java.lang.Object):BuilderType */
        public <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, Type type) {
            return addExtension((ExtensionLite) generatedExtension, (Object) type);
        }

        public final <Type> BuilderType clearExtension(Extension<MessageType, ?> extension) {
            return clearExtension((ExtensionLite) extension);
        }

        public <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> generatedExtension) {
            return clearExtension((ExtensionLite) generatedExtension);
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), new MessageReflection.BuilderAdapter(this), i);
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map<Descriptors.FieldDescriptor, Object> allFieldsMutable = getAllFieldsMutable();
            allFieldsMutable.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            Object field = this.extensions.getField(fieldDescriptor);
            if (field != null) {
                return field;
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType());
            }
            return fieldDescriptor.getDefaultValue();
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedFieldCount(fieldDescriptor);
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedField(fieldDescriptor, i);
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.hasField(fieldDescriptor);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.setField(fieldDescriptor, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.setField(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.clearField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.clearField(fieldDescriptor);
            onChanged();
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderType */
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.setRepeatedField(fieldDescriptor, i, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(fieldDescriptor, i, obj);
            onChanged();
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.protobuf.GeneratedMessage.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
         arg types: [com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object]
         candidates:
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType
          com.google.protobuf.GeneratedMessage.ExtendableBuilder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.Message.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder
          com.google.protobuf.GeneratedMessage.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderType */
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.addRepeatedField(fieldDescriptor, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(ExtendableMessage extendableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(extendableMessage.extensions);
            onChanged();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message message, final int i, Class cls, Message message2) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() {
            /* class com.google.protobuf.GeneratedMessage.AnonymousClass2 */

            public final Descriptors.FieldDescriptor loadDescriptor() {
                return message.getDescriptorForType().getExtensions().get(i);
            }
        }, cls, message2, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, Message message) {
        return new GeneratedExtension<>(null, cls, message, Extension.ExtensionType.IMMUTABLE);
    }

    static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        /* access modifiers changed from: protected */
        public abstract Descriptors.FieldDescriptor loadDescriptor();

        private CachedDescriptorRetriever() {
        }

        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor == null) {
                synchronized (this) {
                    if (this.descriptor == null) {
                        this.descriptor = loadDescriptor();
                    }
                }
            }
            return this.descriptor;
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message message, final String str, Class cls, Message message2) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() {
            /* class com.google.protobuf.GeneratedMessage.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final Descriptors.FieldDescriptor loadDescriptor() {
                return message.getDescriptorForType().findFieldByName(str);
            }
        }, cls, message2, Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(final Class cls, Message message, final String str, final String str2) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() {
            /* class com.google.protobuf.GeneratedMessage.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final Descriptors.FieldDescriptor loadDescriptor() {
                try {
                    return ((Descriptors.FileDescriptor) cls.getClassLoader().loadClass(str).getField("descriptor").get(null)).findExtensionByName(str2);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot load descriptors: " + str + " is not a valid descriptor class name", e);
                }
            }
        }, cls, message, Extension.ExtensionType.MUTABLE);
    }

    public static class GeneratedExtension<ContainingType extends Message, Type> extends Extension<ContainingType, Type> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final Method enumGetValueDescriptor;
        private final Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class singularType;

        GeneratedExtension(ExtensionDescriptorRetriever extensionDescriptorRetriever, Class cls, Message message, Extension.ExtensionType extensionType2) {
            if (!Message.class.isAssignableFrom(cls) || cls.isInstance(message)) {
                this.descriptorRetriever = extensionDescriptorRetriever;
                this.singularType = cls;
                this.messageDefaultInstance = message;
                if (ProtocolMessageEnum.class.isAssignableFrom(cls)) {
                    this.enumValueOf = GeneratedMessage.getMethodOrDie(cls, "valueOf", Descriptors.EnumValueDescriptor.class);
                    this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new Class[0]);
                } else {
                    this.enumValueOf = null;
                    this.enumGetValueDescriptor = null;
                }
                this.extensionType = extensionType2;
                return;
            }
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + cls.getName());
        }

        public void internalInit(final Descriptors.FieldDescriptor fieldDescriptor) {
            if (this.descriptorRetriever == null) {
                this.descriptorRetriever = new ExtensionDescriptorRetriever() {
                    /* class com.google.protobuf.GeneratedMessage.GeneratedExtension.AnonymousClass1 */

                    public Descriptors.FieldDescriptor getDescriptor() {
                        return fieldDescriptor;
                    }
                };
                return;
            }
            throw new IllegalStateException("Already initialized.");
        }

        public Descriptors.FieldDescriptor getDescriptor() {
            ExtensionDescriptorRetriever extensionDescriptorRetriever = this.descriptorRetriever;
            if (extensionDescriptorRetriever != null) {
                return extensionDescriptorRetriever.getDescriptor();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        /* access modifiers changed from: protected */
        public Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        /* access modifiers changed from: protected */
        public Object fromReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularFromReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularFromReflectionType : (List) obj) {
                arrayList.add(singularFromReflectionType(singularFromReflectionType));
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public Object singularFromReflectionType(Object obj) {
            int i = AnonymousClass5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return obj;
                }
                return GeneratedMessage.invokeOrDie(this.enumValueOf, null, (Descriptors.EnumValueDescriptor) obj);
            } else if (this.singularType.isInstance(obj)) {
                return obj;
            } else {
                return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) obj).build();
            }
        }

        /* access modifiers changed from: protected */
        public Object toReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularToReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularToReflectionType : (List) obj) {
                arrayList.add(singularToReflectionType(singularToReflectionType));
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public Object singularToReflectionType(Object obj) {
            if (AnonymousClass5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()] != 2) {
                return obj;
            }
            return GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, obj, new Object[0]);
        }

        public int getNumber() {
            return getDescriptor().getNumber();
        }

        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        public Type getDefaultValue() {
            if (isRepeated()) {
                return Collections.emptyList();
            }
            if (getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return this.messageDefaultInstance;
            }
            return singularFromReflectionType(getDescriptor().getDefaultValue());
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessage$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = new int[Descriptors.FieldDescriptor.JavaType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;
        }
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    /* access modifiers changed from: protected */
    public MapField internalGetMapField(int i) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    public static final class FieldAccessorTable {
        private String[] camelCaseNames;
        public final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        interface FieldAccessor {
            void addRepeated(Builder builder, Object obj);

            void clear(Builder builder);

            Object get(Builder builder);

            Object get(GeneratedMessage generatedMessage);

            Message.Builder getBuilder(Builder builder);

            Object getRaw(Builder builder);

            Object getRaw(GeneratedMessage generatedMessage);

            Object getRepeated(Builder builder, int i);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            Message.Builder getRepeatedBuilder(Builder builder, int i);

            int getRepeatedCount(Builder builder);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            Object getRepeatedRaw(Builder builder, int i);

            Object getRepeatedRaw(GeneratedMessage generatedMessage, int i);

            boolean has(Builder builder);

            boolean has(GeneratedMessage generatedMessage);

            Message.Builder newBuilder();

            void set(Builder builder, Object obj);

            void setRepeated(Builder builder, int i, Object obj);
        }

        private boolean isMapFieldEnabled(Descriptors.FieldDescriptor fieldDescriptor) {
            return true;
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor2, String[] strArr, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
            this(descriptor2, strArr);
            ensureFieldAccessorsInitialized(cls, cls2);
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor2, String[] strArr) {
            this.descriptor = descriptor2;
            this.camelCaseNames = strArr;
            this.fields = new FieldAccessor[descriptor2.getFields().size()];
            this.oneofs = new OneofAccessor[descriptor2.getOneofs().size()];
            this.initialized = false;
        }

        public final FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                if (this.initialized) {
                    return this;
                }
                int length = this.fields.length;
                int i = 0;
                while (true) {
                    String str = null;
                    if (i >= length) {
                        break;
                    }
                    Descriptors.FieldDescriptor fieldDescriptor = this.descriptor.getFields().get(i);
                    if (fieldDescriptor.getContainingOneof() != null) {
                        str = this.camelCaseNames[fieldDescriptor.getContainingOneof().getIndex() + length];
                    }
                    String str2 = str;
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (!fieldDescriptor.isMapField() || !isMapFieldEnabled(fieldDescriptor)) {
                                this.fields[i] = new RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                            } else {
                                this.fields[i] = new MapFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                            }
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i] = new RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                        } else {
                            this.fields[i] = new RepeatedFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                        }
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.fields[i] = new SingularStringFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                    } else {
                        this.fields[i] = new SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                    }
                    i++;
                }
                int length2 = this.oneofs.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.oneofs[i2] = new OneofAccessor(this.descriptor, this.camelCaseNames[i2 + length], cls, cls2);
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }

        public final FieldAccessor getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fieldDescriptor.isExtension()) {
                return this.fields[fieldDescriptor.getIndex()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        public final OneofAccessor getOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.getContainingType() == this.descriptor) {
                return this.oneofs[oneofDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        static class OneofAccessor {
            private final Method caseMethod;
            private final Method caseMethodBuilder;
            private final Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            OneofAccessor(Descriptors.Descriptor descriptor2, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.descriptor = descriptor2;
                this.caseMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Case", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
            }

            public boolean has(GeneratedMessage generatedMessage) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber() != 0;
            }

            public boolean has(Builder builder) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber() != 0;
            }

            public Descriptors.FieldDescriptor get(GeneratedMessage generatedMessage) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public Descriptors.FieldDescriptor get(Builder builder) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }
        }

        public static boolean supportFieldPresence(Descriptors.FileDescriptor fileDescriptor) {
            return fileDescriptor.getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        static class SingularFieldAccessor implements FieldAccessor {
            protected final Method caseMethod;
            protected final Method caseMethodBuilder;
            protected final Method clearMethod;
            protected final Descriptors.FieldDescriptor field;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final boolean hasHasMethod;
            protected final Method hasMethod;
            protected final Method hasMethodBuilder;
            protected final boolean isOneofField;
            protected final Method setMethod;
            protected final Class<?> type;

            SingularFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2, String str2) {
                Method method;
                this.field = fieldDescriptor;
                this.isOneofField = fieldDescriptor.getContainingOneof() != null;
                this.hasHasMethod = FieldAccessorTable.supportFieldPresence(fieldDescriptor.getFile()) || (!this.isOneofField && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE);
                this.getMethod = GeneratedMessage.getMethodOrDie(cls, "get".concat(String.valueOf(str)), new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get".concat(String.valueOf(str)), new Class[0]);
                this.type = this.getMethod.getReturnType();
                this.setMethod = GeneratedMessage.getMethodOrDie(cls2, "set".concat(String.valueOf(str)), this.type);
                Method method2 = null;
                this.hasMethod = this.hasHasMethod ? GeneratedMessage.getMethodOrDie(cls, "has".concat(String.valueOf(str)), new Class[0]) : null;
                this.hasMethodBuilder = this.hasHasMethod ? GeneratedMessage.getMethodOrDie(cls2, "has".concat(String.valueOf(str)), new Class[0]) : null;
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
                if (this.isOneofField) {
                    method = GeneratedMessage.getMethodOrDie(cls, "get" + str2 + "Case", new Class[0]);
                } else {
                    method = null;
                }
                this.caseMethod = method;
                if (this.isOneofField) {
                    method2 = GeneratedMessage.getMethodOrDie(cls2, "get" + str2 + "Case", new Class[0]);
                }
                this.caseMethodBuilder = method2;
            }

            private int getOneofFieldNumber(GeneratedMessage generatedMessage) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
            }

            private int getOneofFieldNumber(Builder builder) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
            }

            public Object get(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
            }

            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            public Object getRaw(Builder builder) {
                return get(builder);
            }

            public void set(Builder builder, Object obj) {
                GeneratedMessage.invokeOrDie(this.setMethod, builder, obj);
            }

            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            public Object getRepeatedRaw(GeneratedMessage generatedMessage, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            public Object getRepeated(Builder builder, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            public Object getRepeatedRaw(Builder builder, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            public void setRepeated(Builder builder, int i, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            public void addRepeated(Builder builder, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            public boolean has(GeneratedMessage generatedMessage) {
                if (this.hasHasMethod) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, generatedMessage, new Object[0])).booleanValue();
                }
                if (this.isOneofField) {
                    if (getOneofFieldNumber(generatedMessage) == this.field.getNumber()) {
                        return true;
                    }
                    return false;
                } else if (!get(generatedMessage).equals(this.field.getDefaultValue())) {
                    return true;
                } else {
                    return false;
                }
            }

            public boolean has(Builder builder) {
                if (this.hasHasMethod) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
                }
                if (this.isOneofField) {
                    if (getOneofFieldNumber(builder) == this.field.getNumber()) {
                        return true;
                    }
                    return false;
                } else if (!get(builder).equals(this.field.getDefaultValue())) {
                    return true;
                } else {
                    return false;
                }
            }

            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            public int getRepeatedCount(Builder builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            public Message.Builder getRepeatedBuilder(Builder builder, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        static class RepeatedFieldAccessor implements FieldAccessor {
            protected final Method addRepeatedMethod;
            protected final Method clearMethod;
            protected final Method getCountMethod;
            protected final Method getCountMethodBuilder;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method getRepeatedMethod;
            protected final Method getRepeatedMethodBuilder;
            protected final Method setRepeatedMethod;
            protected final Class type = this.getRepeatedMethod.getReturnType();

            RepeatedFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.getMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "List", new Class[0]);
                this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(cls, "get".concat(String.valueOf(str)), Integer.TYPE);
                this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get".concat(String.valueOf(str)), Integer.TYPE);
                this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, "set".concat(String.valueOf(str)), Integer.TYPE, this.type);
                this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, "add".concat(String.valueOf(str)), this.type);
                this.getCountMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Count", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
            }

            public Object get(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
            }

            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            public Object getRaw(Builder builder) {
                return get(builder);
            }

            public void set(Builder builder, Object obj) {
                clear(builder);
                for (Object addRepeated : (List) obj) {
                    addRepeated(builder, addRepeated);
                }
            }

            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, generatedMessage, Integer.valueOf(i));
            }

            public Object getRepeated(Builder builder, int i) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(i));
            }

            public Object getRepeatedRaw(GeneratedMessage generatedMessage, int i) {
                return getRepeated(generatedMessage, i);
            }

            public Object getRepeatedRaw(Builder builder, int i) {
                return getRepeated(builder, i);
            }

            public void setRepeated(Builder builder, int i, Object obj) {
                GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(i), obj);
            }

            public void addRepeated(Builder builder, Object obj) {
                GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, obj);
            }

            public boolean has(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, generatedMessage, new Object[0])).intValue();
            }

            public int getRepeatedCount(Builder builder) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            public Message.Builder getRepeatedBuilder(Builder builder, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.field = fieldDescriptor;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private MapField<?, ?> getMapField(GeneratedMessage generatedMessage) {
                return generatedMessage.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMapField(Builder builder) {
                return builder.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMutableMapField(Builder builder) {
                return builder.internalGetMutableMapField(this.field.getNumber());
            }

            public Object get(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(generatedMessage); i++) {
                    arrayList.add(getRepeated(generatedMessage, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object get(Builder builder) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(builder); i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            public Object getRaw(Builder builder) {
                return get(builder);
            }

            public void set(Builder builder, Object obj) {
                clear(builder);
                for (Object addRepeated : (List) obj) {
                    addRepeated(builder, addRepeated);
                }
            }

            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return getMapField(generatedMessage).getList().get(i);
            }

            public Object getRepeated(Builder builder, int i) {
                return getMapField(builder).getList().get(i);
            }

            public Object getRepeatedRaw(GeneratedMessage generatedMessage, int i) {
                return getRepeated(generatedMessage, i);
            }

            public Object getRepeatedRaw(Builder builder, int i) {
                return getRepeated(builder, i);
            }

            public void setRepeated(Builder builder, int i, Object obj) {
                getMutableMapField(builder).getMutableList().set(i, (Message) obj);
            }

            public void addRepeated(Builder builder, Object obj) {
                getMutableMapField(builder).getMutableList().add((Message) obj);
            }

            public boolean has(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                return getMapField(generatedMessage).getList().size();
            }

            public int getRepeatedCount(Builder builder) {
                return getMapField(builder).getList().size();
            }

            public void clear(Builder builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            public Message.Builder getRepeatedBuilder(Builder builder, int i) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }
        }

        static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Descriptors.EnumDescriptor enumDescriptor;
            private Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private Method getValueMethod;
            private Method getValueMethodBuilder;
            private Method setValueMethod;
            private boolean supportUnknownEnumValue;
            private Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getValueMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", new Class[0]);
                    this.getValueMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", new Class[0]);
                    this.setValueMethod = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            public final Object get(GeneratedMessage generatedMessage) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethod, generatedMessage, new Object[0])).intValue());
            }

            public final Object get(Builder builder) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethodBuilder, builder, new Object[0])).intValue());
            }

            public final void set(Builder builder, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                }
                super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
            }
        }

        static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private Method addRepeatedValueMethod;
            private Descriptors.EnumDescriptor enumDescriptor;
            private Method getRepeatedValueMethod;
            private Method getRepeatedValueMethodBuilder;
            private final Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private Method setRepeatedValueMethod;
            private boolean supportUnknownEnumValue;
            private final Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.supportUnknownEnumValue = fieldDescriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", Integer.TYPE);
                    this.getRepeatedValueMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", Integer.TYPE);
                    this.setRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", Integer.TYPE, Integer.TYPE);
                    this.addRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls2, "add" + str + "Value", Integer.TYPE);
                }
            }

            public final Object get(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(generatedMessage);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(generatedMessage, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final Object get(Builder builder) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(builder);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final Object getRepeated(GeneratedMessage generatedMessage, int i) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, i), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethod, generatedMessage, Integer.valueOf(i))).intValue());
            }

            public final Object getRepeated(Builder builder, int i) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, i), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, Integer.valueOf(i))).intValue());
            }

            public final void setRepeated(Builder builder, int i, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedValueMethod, builder, Integer.valueOf(i), Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                }
                super.setRepeated(builder, i, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
            }

            public final void addRepeated(Builder builder, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                }
                super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
            }
        }

        static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final Method getBytesMethod;
            private final Method getBytesMethodBuilder;
            private final Method setBytesMethodBuilder;

            SingularStringFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.getBytesMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Bytes", new Class[0]);
                this.getBytesMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Bytes", ByteString.class);
            }

            public final Object getRaw(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethod, generatedMessage, new Object[0]);
            }

            public final Object getRaw(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethodBuilder, builder, new Object[0]);
            }

            public final void set(Builder builder, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessage.invokeOrDie(this.setBytesMethodBuilder, builder, obj);
                    return;
                }
                super.set(builder, obj);
            }
        }

        static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method getBuilderMethodBuilder;
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object coerceType(Object obj) {
                if (this.type.isInstance(obj)) {
                    return obj;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) obj).buildPartial();
            }

            public final void set(Builder builder, Object obj) {
                super.set(builder, coerceType(obj));
            }

            public final Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            public final Message.Builder getBuilder(Builder builder) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new Object[0]);
            }
        }

        static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method getBuilderMethodBuilder;
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object coerceType(Object obj) {
                if (this.type.isInstance(obj)) {
                    return obj;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) obj).build();
            }

            public final void setRepeated(Builder builder, int i, Object obj) {
                super.setRepeated(builder, i, coerceType(obj));
            }

            public final void addRepeated(Builder builder, Object obj) {
                super.addRepeated(builder, coerceType(obj));
            }

            public final Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            public final Message.Builder getRepeatedBuilder(Builder builder, int i) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, Integer.valueOf(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    public static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> extensionLite) {
        if (!extensionLite.isLite()) {
            return (Extension) extensionLite;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    protected static int computeStringSize(int i, Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.computeStringSize(i, (String) obj);
        }
        return CodedOutputStream.computeBytesSize(i, (ByteString) obj);
    }

    protected static int computeStringSizeNoTag(Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.computeStringSizeNoTag((String) obj);
        }
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
    }

    protected static void writeString(CodedOutputStream codedOutputStream, int i, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.writeString(i, (String) obj);
        } else {
            codedOutputStream.writeBytes(i, (ByteString) obj);
        }
    }

    protected static void writeStringNoTag(CodedOutputStream codedOutputStream, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.writeStringNoTag((String) obj);
        } else {
            codedOutputStream.writeBytesNoTag((ByteString) obj);
        }
    }
}
