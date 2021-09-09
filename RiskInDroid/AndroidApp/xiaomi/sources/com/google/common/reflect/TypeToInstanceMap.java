package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

@Beta
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    <T extends B> T getInstance(TypeToken<T> typeToken);

    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    <T extends B> T putInstance(TypeToken<T> typeToken, T t);

    @CanIgnoreReturnValue
    <T extends B> T putInstance(Class<T> cls, T t);
}
