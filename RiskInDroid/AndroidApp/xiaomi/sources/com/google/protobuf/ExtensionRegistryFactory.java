package com.google.protobuf;

final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();

    ExtensionRegistryFactory() {
    }

    static Class<?> reflectExtensionRegistry() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite invokeSubclassFactory = invokeSubclassFactory("newInstance");
        if (invokeSubclassFactory != null) {
            return invokeSubclassFactory;
        }
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite invokeSubclassFactory = invokeSubclassFactory("getEmptyRegistry");
        if (invokeSubclassFactory != null) {
            return invokeSubclassFactory;
        }
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    static boolean isFullRegistry(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = EXTENSION_REGISTRY_CLASS;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String str) {
        Class<?> cls = EXTENSION_REGISTRY_CLASS;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
