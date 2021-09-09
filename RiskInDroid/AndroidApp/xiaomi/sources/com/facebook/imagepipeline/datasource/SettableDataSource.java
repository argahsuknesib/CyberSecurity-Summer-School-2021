package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;

public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {
    public static <V> SettableDataSource<V> create() {
        return new SettableDataSource<>();
    }

    private SettableDataSource() {
    }

    public final boolean set(CloseableReference<T> closeableReference) {
        return super.setResult(CloseableReference.cloneOrNull(closeableReference), true);
    }

    public final boolean setException(Throwable th) {
        return super.setFailure(th);
    }

    public final boolean setProgress(float f) {
        return super.setProgress(f);
    }

    public final CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* access modifiers changed from: protected */
    public final void closeResult(CloseableReference<T> closeableReference) {
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
    }
}
