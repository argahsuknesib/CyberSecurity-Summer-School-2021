package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    static class ExtensionClassHolder {
        static final Class<?> INSTANCE = resolveExtensionClass();

        private ExtensionClassHolder() {
        }

        static Class<?> resolveExtensionClass() {
            try {
                return Class.forName("com.google.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean z) {
        eagerlyParseMessageSets = z;
    }

    public static ExtensionRegistryLite newInstance() {
        return doFullRuntimeInheritanceCheck ? ExtensionRegistryFactory.create() : new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    extensionRegistryLite = doFullRuntimeInheritanceCheck ? ExtensionRegistryFactory.createEmpty() : EMPTY_REGISTRY_LITE;
                    emptyRegistry = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return this.extensionsByNumber.get(new ObjectIntPair(containingtype, i));
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension<?, ?>) ((GeneratedMessageLite.GeneratedExtension) extensionLite));
        }
        if (doFullRuntimeInheritanceCheck && ExtensionRegistryFactory.isFullRegistry(this)) {
            try {
                getClass().getMethod("add", ExtensionClassHolder.INSTANCE).invoke(this, extensionLite);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extensionLite), e);
            }
        }
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY_REGISTRY_LITE) {
            this.extensionsByNumber = Collections.emptyMap();
        } else {
            this.extensionsByNumber = Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.object == objectIntPair.object && this.number == objectIntPair.number) {
                return true;
            }
            return false;
        }
    }
}
