package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    public final void onDisposed(@NonNull Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
