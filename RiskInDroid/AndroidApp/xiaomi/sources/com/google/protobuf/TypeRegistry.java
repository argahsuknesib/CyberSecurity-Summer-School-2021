package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class TypeRegistry {
    public static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
    private final Map<String, Descriptors.Descriptor> types;

    static class EmptyTypeRegistryHolder {
        public static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap());

        private EmptyTypeRegistryHolder() {
        }
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.EMPTY;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Descriptors.Descriptor find(String str) {
        return this.types.get(str);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String str) throws InvalidProtocolBufferException {
        return find(getTypeName(str));
    }

    TypeRegistry(Map<String, Descriptors.Descriptor> map) {
        this.types = map;
    }

    private static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: ".concat(String.valueOf(str)));
    }

    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        public final Builder add(Descriptors.Descriptor descriptor) {
            if (this.types != null) {
                addFile(descriptor.getFile());
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public final Builder add(Iterable<Descriptors.Descriptor> iterable) {
            if (this.types != null) {
                for (Descriptors.Descriptor file : iterable) {
                    addFile(file.getFile());
                }
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public final TypeRegistry build() {
            TypeRegistry typeRegistry = new TypeRegistry(this.types);
            this.types = null;
            return typeRegistry;
        }

        private void addFile(Descriptors.FileDescriptor fileDescriptor) {
            if (this.files.add(fileDescriptor.getFullName())) {
                for (Descriptors.FileDescriptor addFile : fileDescriptor.getDependencies()) {
                    addFile(addFile);
                }
                for (Descriptors.Descriptor addMessage : fileDescriptor.getMessageTypes()) {
                    addMessage(addMessage);
                }
            }
        }

        private void addMessage(Descriptors.Descriptor descriptor) {
            for (Descriptors.Descriptor addMessage : descriptor.getNestedTypes()) {
                addMessage(addMessage);
            }
            if (this.types.containsKey(descriptor.getFullName())) {
                Logger logger = TypeRegistry.logger;
                logger.warning("Type " + descriptor.getFullName() + " is added multiple times.");
                return;
            }
            this.types.put(descriptor.getFullName(), descriptor);
        }
    }
}
