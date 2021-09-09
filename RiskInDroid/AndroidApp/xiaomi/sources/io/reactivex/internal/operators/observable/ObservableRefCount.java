package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = connectableObservable;
        this.n = i;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.connection;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.connection = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != ((long) this.n)) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.source.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.source.connect(refConnection);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        return;
     */
    public final void cancel(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null) {
                if (this.connection == refConnection) {
                    long j = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j;
                    if (j == 0) {
                        if (refConnection.connected) {
                            if (this.timeout == 0) {
                                timeout(refConnection);
                                return;
                            }
                            SequentialDisposable sequentialDisposable = new SequentialDisposable();
                            refConnection.timer = sequentialDisposable;
                            sequentialDisposable.replace(this.scheduler.scheduleDirect(refConnection, this.timeout, this.unit));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void terminated(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null && this.connection == refConnection) {
                this.connection = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j == 0) {
                if (this.source instanceof Disposable) {
                    ((Disposable) this.source).dispose();
                } else if (this.source instanceof ResettableConnectable) {
                    ((ResettableConnectable) this.source).resetIf((Disposable) refConnection.get());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void timeout(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (this.source instanceof Disposable) {
                    ((Disposable) this.source).dispose();
                } else if (this.source instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) this.source).resetIf(disposable);
                    }
                }
            }
        }
    }

    static final class RefConnection extends AtomicReference<Disposable> implements Consumer<Disposable>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        public final void run() {
            this.parent.timeout(this);
        }

        public final void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.source).resetIf(disposable);
                }
            }
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        public final void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
