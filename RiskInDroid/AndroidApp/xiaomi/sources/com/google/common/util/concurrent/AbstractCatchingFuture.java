package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    Class<X> exceptionType;
    F fallback;
    ListenableFuture<? extends V> inputFuture;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract T doFallback(F f, X x) throws Exception;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void setResult(T t);

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture listenableFuture, Class cls, Function function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture listenableFuture, Class cls, AsyncFunction asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = Preconditions.checkNotNull(f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    public final void run() {
        Object obj;
        Throwable th;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        boolean z = true;
        boolean z2 = (listenableFuture == null) | (cls == null);
        if (f != null) {
            z = false;
        }
        if (!(z | z2) && !isCancelled()) {
            this.inputFuture = null;
            try {
                obj = Futures.getDone(listenableFuture);
                th = null;
            } catch (ExecutionException e) {
                th = (Throwable) Preconditions.checkNotNull(e.getCause());
                obj = null;
                if (th == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                obj = null;
                if (th == null) {
                }
            }
            if (th == null) {
                set(obj);
            } else if (!Platform.isInstanceOfThrowableClass(th, cls)) {
                setFuture(listenableFuture);
            } else {
                try {
                    Object doFallback = doFallback(f, th);
                    this.exceptionType = null;
                    this.fallback = null;
                    setResult(doFallback);
                } catch (Throwable th3) {
                    this.exceptionType = null;
                    this.fallback = null;
                    throw th3;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f) + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        public final ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        public final void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* access modifiers changed from: package-private */
        public final V doFallback(Function<? super X, ? extends V> function, X x) throws Exception {
            return function.apply(x);
        }

        /* access modifiers changed from: package-private */
        public final void setResult(V v) {
            set(v);
        }
    }
}
