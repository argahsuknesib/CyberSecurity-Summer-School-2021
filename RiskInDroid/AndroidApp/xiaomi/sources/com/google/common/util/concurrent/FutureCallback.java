package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(V v);
}
