package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@GwtIncompatible
public final class RemovalListeners {
    private RemovalListeners() {
    }

    public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> removalListener, final Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        return new RemovalListener<K, V>() {
            /* class com.google.common.cache.RemovalListeners.AnonymousClass1 */

            public final void onRemoval(final RemovalNotification<K, V> removalNotification) {
                executor.execute(new Runnable() {
                    /* class com.google.common.cache.RemovalListeners.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        removalListener.onRemoval(removalNotification);
                    }
                });
            }
        };
    }
}
