package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = -1.0d;

    /* access modifiers changed from: protected */
    public final Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final Excluder withVersion(double d) {
        Excluder clone = clone();
        clone.version = d;
        return clone;
    }

    public final Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.modifiers = 0;
        for (int i : iArr) {
            clone.modifiers = i | clone.modifiers;
        }
        return clone;
    }

    public final Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public final Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    public final Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.serializationStrategies = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies.add(exclusionStrategy);
        }
        if (z2) {
            clone.deserializationStrategies = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies.add(exclusionStrategy);
        }
        return clone;
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        final boolean z = excludeClassChecks || excludeClassInStrategy(rawType, true);
        final boolean z2 = excludeClassChecks || excludeClassInStrategy(rawType, false);
        if (!z && !z2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {
            /* class com.google.gson.internal.Excluder.AnonymousClass1 */
            private TypeAdapter<T> delegate;

            public T read(JsonReader jsonReader) throws IOException {
                if (!z2) {
                    return delegate().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (z) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t);
                }
            }

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }
        };
    }

    public final boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        for (ExclusionStrategy shouldSkipField : list) {
            if (shouldSkipField.shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((this.serializeInnerClasses || !isInnerClass(cls)) && !isAnonymousOrLocal(cls)) {
            return false;
        }
        return true;
    }

    public final boolean excludeClass(Class<?> cls, boolean z) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z);
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        for (ExclusionStrategy shouldSkipClass : z ? this.serializationStrategies : this.deserializationStrategies) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls)) {
            return cls.isAnonymousClass() || cls.isLocalClass();
        }
        return false;
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }
}
