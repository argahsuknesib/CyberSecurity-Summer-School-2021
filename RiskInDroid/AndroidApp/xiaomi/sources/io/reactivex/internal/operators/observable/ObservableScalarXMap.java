package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {
    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) observableSource).call();
            if (call == null) {
                EmptyDisposable.complete(observer);
                return true;
            }
            try {
                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null ObservableSource");
                if (observableSource2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) observableSource2).call();
                        if (call2 == null) {
                            EmptyDisposable.complete(observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call2);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptyDisposable.error(th, observer);
                        return true;
                    }
                } else {
                    observableSource2.subscribe(observer);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, observer);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, observer);
            return true;
        }
    }

    public static <T, U> Observable<U> scalarXMap(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapObservable(t, function));
    }

    static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final T value;

        ScalarXMapObservable(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.value = t;
            this.mapper = function;
        }

        public final void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.complete(observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptyDisposable.error(th, observer);
                    }
                } else {
                    observableSource.subscribe(observer);
                }
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, observer);
            }
        }
    }

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        public ScalarDisposable(Observer<? super T> observer2, T t) {
            this.observer = observer2;
            this.value = t;
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Nullable
        public final T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public final boolean isEmpty() {
            return get() != 1;
        }

        public final void clear() {
            lazySet(3);
        }

        public final void dispose() {
            set(3);
        }

        public final boolean isDisposed() {
            return get() == 3;
        }

        public final int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public final void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }
}
