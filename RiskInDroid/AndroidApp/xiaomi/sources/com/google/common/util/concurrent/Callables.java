package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@GwtCompatible(emulated = true)
public final class Callables {
    private Callables() {
    }

    public static <T> Callable<T> returning(final T t) {
        return new Callable<T>() {
            /* class com.google.common.util.concurrent.Callables.AnonymousClass1 */

            public final T call() {
                return t;
            }
        };
    }

    @GwtIncompatible
    @Beta
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable<T>() {
            /* class com.google.common.util.concurrent.Callables.AnonymousClass2 */

            public final ListenableFuture<T> call() throws Exception {
                return listeningExecutorService.submit(callable);
            }
        };
    }

    @GwtIncompatible
    static <T> Callable<T> threadRenaming(final Callable callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable<T>() {
            /* class com.google.common.util.concurrent.Callables.AnonymousClass3 */

            public final T call() throws Exception {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean trySetName = Callables.trySetName((String) supplier.get(), currentThread);
                try {
                    return callable.call();
                } finally {
                    if (trySetName) {
                        Callables.trySetName(name, currentThread);
                    }
                }
            }
        };
    }

    @GwtIncompatible
    static Runnable threadRenaming(final Runnable runnable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Runnable() {
            /* class com.google.common.util.concurrent.Callables.AnonymousClass4 */

            public final void run() {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean trySetName = Callables.trySetName((String) supplier.get(), currentThread);
                try {
                    runnable.run();
                } finally {
                    if (trySetName) {
                        Callables.trySetName(name, currentThread);
                    }
                }
            }
        };
    }

    @GwtIncompatible
    public static boolean trySetName(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
