package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.gson.reflect.TypeToken<T>, com.google.gson.reflect.TypeToken] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> r4) {
        JsonAdapter jsonAdapter = (JsonAdapter) r4.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, r4, jsonAdapter);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r9v13, types: [com.google.gson.TypeAdapter] */
    /* JADX WARN: Type inference failed for: r9v14, types: [com.google.gson.TypeAdapter] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor2, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TreeTypeAdapter treeTypeAdapter;
        Object construct = constructorConstructor2.get(TypeToken.get((Class) jsonAdapter.value())).construct();
        if (construct instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) construct).create(gson, typeToken);
        } else {
            boolean z = construct instanceof JsonSerializer;
            if (z || (construct instanceof JsonDeserializer)) {
                JsonDeserializer jsonDeserializer = null;
                JsonSerializer jsonSerializer = z ? (JsonSerializer) construct : null;
                if (construct instanceof JsonDeserializer) {
                    jsonDeserializer = (JsonDeserializer) construct;
                }
                treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }
}
