package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public final <T> void writeTo(T t, Writer writer) throws IOException {
        schemaFor((Object) t).writeTo(t, writer);
    }

    public final <T> void mergeFrom(T t, Reader reader) throws IOException {
        mergeFrom(t, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public final <T> void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor((Object) t).mergeFrom(t, reader, extensionRegistryLite);
    }

    public final <T> void makeImmutable(T t) {
        schemaFor((Object) t).makeImmutable(t);
    }

    public final <T> boolean isInitialized(T t) {
        return schemaFor((Object) t).isInitialized(t);
    }

    public final <T> Schema<T> schemaFor(Class cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> createSchema = this.schemaFactory.createSchema(cls);
        Schema registerSchema = registerSchema(cls, createSchema);
        return registerSchema != null ? registerSchema : createSchema;
    }

    public final <T> Schema<T> schemaFor(Object obj) {
        return schemaFor((Class) obj.getClass());
    }

    public final Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    public final Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    private Protobuf() {
    }

    /* access modifiers changed from: package-private */
    public final int getTotalSchemaSize() {
        int i = 0;
        for (Schema next : this.schemaCache.values()) {
            if (next instanceof MessageSchema) {
                i += ((MessageSchema) next).getSchemaSize();
            }
        }
        return i;
    }
}
