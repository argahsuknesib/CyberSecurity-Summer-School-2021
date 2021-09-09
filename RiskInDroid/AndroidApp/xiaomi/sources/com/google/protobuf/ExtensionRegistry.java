package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.GeneratedMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry extends ExtensionRegistryLite {
    static final ExtensionRegistry EMPTY_REGISTRY = new ExtensionRegistry(true);
    private final Map<String, ExtensionInfo> immutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    private final Map<String, ExtensionInfo> mutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor, Message message, AnonymousClass1 r3) {
            this(fieldDescriptor, message);
        }

        private ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor) {
            this.descriptor = fieldDescriptor;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            this.descriptor = fieldDescriptor;
            this.defaultInstance = message;
        }
    }

    @Deprecated
    public ExtensionInfo findExtensionByName(String str) {
        return findImmutableExtensionByName(str);
    }

    public ExtensionInfo findImmutableExtensionByName(String str) {
        return this.immutableExtensionsByName.get(str);
    }

    public ExtensionInfo findMutableExtensionByName(String str) {
        return this.mutableExtensionsByName.get(str);
    }

    @Deprecated
    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor descriptor, int i) {
        return findImmutableExtensionByNumber(descriptor, i);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor descriptor, int i) {
        return this.immutableExtensionsByNumber.get(new DescriptorIntPair(descriptor, i));
    }

    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor descriptor, int i) {
        return this.mutableExtensionsByNumber.get(new DescriptorIntPair(descriptor, i));
    }

    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String str) {
        HashSet hashSet = new HashSet();
        for (DescriptorIntPair next : this.mutableExtensionsByNumber.keySet()) {
            if (next.descriptor.getFullName().equals(str)) {
                hashSet.add(this.mutableExtensionsByNumber.get(next));
            }
        }
        return hashSet;
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String str) {
        HashSet hashSet = new HashSet();
        for (DescriptorIntPair next : this.immutableExtensionsByNumber.keySet()) {
            if (next.descriptor.getFullName().equals(str)) {
                hashSet.add(this.immutableExtensionsByNumber.get(next));
            }
        }
        return hashSet;
    }

    public void add(Extension<?, ?> extension) {
        if (extension.getExtensionType() == Extension.ExtensionType.IMMUTABLE || extension.getExtensionType() == Extension.ExtensionType.MUTABLE) {
            add(newExtensionInfo(extension), extension.getExtensionType());
        }
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> generatedExtension) {
        add((Extension<?, ?>) generatedExtension);
    }

    static ExtensionInfo newExtensionInfo(Extension<?, ?> extension) {
        if (extension.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return new ExtensionInfo(extension.getDescriptor(), null, null);
        }
        if (extension.getMessageDefaultInstance() != null) {
            return new ExtensionInfo(extension.getDescriptor(), extension.getMessageDefaultInstance(), null);
        }
        throw new IllegalStateException("Registered message-type extension had null default instance: " + extension.getDescriptor().getFullName());
    }

    public void add(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            ExtensionInfo extensionInfo = new ExtensionInfo(fieldDescriptor, null, null);
            add(extensionInfo, Extension.ExtensionType.IMMUTABLE);
            add(extensionInfo, Extension.ExtensionType.MUTABLE);
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    public void add(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            add(new ExtensionInfo(fieldDescriptor, message, null), Extension.ExtensionType.IMMUTABLE);
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }

    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    private ExtensionRegistry(ExtensionRegistry extensionRegistry) {
        super(extensionRegistry);
        this.immutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByNumber);
    }

    ExtensionRegistry(boolean z) {
        super(EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    private void add(ExtensionInfo extensionInfo, Extension.ExtensionType extensionType) {
        Map<String, ExtensionInfo> map;
        Map<DescriptorIntPair, ExtensionInfo> map2;
        if (extensionInfo.descriptor.isExtension()) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[extensionType.ordinal()];
            if (i == 1) {
                map = this.immutableExtensionsByName;
                map2 = this.immutableExtensionsByNumber;
            } else if (i == 2) {
                map = this.mutableExtensionsByName;
                map2 = this.mutableExtensionsByNumber;
            } else {
                return;
            }
            map.put(extensionInfo.descriptor.getFullName(), extensionInfo);
            map2.put(new DescriptorIntPair(extensionInfo.descriptor.getContainingType(), extensionInfo.descriptor.getNumber()), extensionInfo);
            Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
            if (fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.isOptional() && fieldDescriptor.getExtensionScope() == fieldDescriptor.getMessageType()) {
                map.put(fieldDescriptor.getMessageType().getFullName(), extensionInfo);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }

    /* renamed from: com.google.protobuf.ExtensionRegistry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = new int[Extension.ExtensionType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.IMMUTABLE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.MUTABLE.ordinal()] = 2;
        }
    }

    static final class DescriptorIntPair {
        public final Descriptors.Descriptor descriptor;
        private final int number;

        DescriptorIntPair(Descriptors.Descriptor descriptor2, int i) {
            this.descriptor = descriptor2;
            this.number = i;
        }

        public final int hashCode() {
            return (this.descriptor.hashCode() * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof DescriptorIntPair)) {
                return false;
            }
            DescriptorIntPair descriptorIntPair = (DescriptorIntPair) obj;
            if (this.descriptor == descriptorIntPair.descriptor && this.number == descriptorIntPair.number) {
                return true;
            }
            return false;
        }
    }
}
