package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

@Beta
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final ImmutableMap<TypeToken<? extends B>, B> delegate;

    public static <B> ImmutableTypeToInstanceMap<B> of() {
        return new ImmutableTypeToInstanceMap<>(ImmutableMap.of());
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    @Beta
    public static final class Builder<B> {
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder;

        private Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        @CanIgnoreReturnValue
        public final <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.mapBuilder.put(TypeToken.of((Class) cls), t);
            return this;
        }

        @CanIgnoreReturnValue
        public final <T extends B> Builder<B> put(TypeToken<T> typeToken, T t) {
            this.mapBuilder.put(typeToken.rejectTypeVariables(), t);
            return this;
        }

        public final ImmutableTypeToInstanceMap<B> build() {
            return new ImmutableTypeToInstanceMap<>(this.mapBuilder.build());
        }
    }

    private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public final <T extends B> T getInstance(TypeToken<T> typeToken) {
        return trustedGet(typeToken.rejectTypeVariables());
    }

    public final <T extends B> T getInstance(Class<T> cls) {
        return trustedGet(TypeToken.of((Class) cls));
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final <T extends B> T putInstance(TypeToken<T> typeToken, T t) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final B put(TypeToken<? extends B> typeToken, B b) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    public final Map<TypeToken<? extends B>, B> delegate() {
        return this.delegate;
    }

    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.delegate.get(typeToken);
    }
}
