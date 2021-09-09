package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

@Beta
public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {
    /* access modifiers changed from: protected */
    public abstract S generateState();

    /* access modifiers changed from: protected */
    public abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    /* access modifiers changed from: protected */
    public void onUnsubscribe(S s) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass1 */

            public final S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass2 */

            public final S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        }, action1);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass3 */

            public final Void call(Void voidR, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return voidR;
            }
        });
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass4 */

            public final Void call(Void voidR, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return null;
            }
        }, new Action1<Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass5 */

            public final void call(Void voidR) {
                action0.call();
            }
        });
    }

    static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        public final /* bridge */ /* synthetic */ void call(Object obj) {
            AsyncOnSubscribe.super.call((Subscriber) obj);
        }

        AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this(null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this(null, func3, null);
        }

        /* access modifiers changed from: protected */
        public final S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        /* access modifiers changed from: protected */
        public final S next(S s, long j, Observer<Observable<? extends T>> observer) {
            return this.next.call(s, Long.valueOf(j), observer);
        }

        /* access modifiers changed from: protected */
        public final void onUnsubscribe(S s) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s);
            }
        }
    }

    public final void call(final Subscriber<? super T> subscriber) {
        try {
            Object generateState = generateState();
            UnicastSubject create = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, generateState, create);
            AnonymousClass6 r0 = new Subscriber<T>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass6 */

                public void onNext(T t) {
                    subscriber.onNext(t);
                }

                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                public void onCompleted() {
                    subscriber.onCompleted();
                }

                public void setProducer(Producer producer) {
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            create.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass7 */

                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(r0);
            subscriber.add(r0);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th) {
            subscriber.onError(th);
        }
    }

    static final class AsyncOuterManager<S, T> implements Observer<Observable<? extends T>>, Producer, Subscription {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        final AtomicBoolean isUnsubscribed;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.serializedSubscriber = new SerializedObserver<>(this);
            this.state = s;
            this.merger = unicastSubject;
            this.isUnsubscribed = new AtomicBoolean();
        }

        public final void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.requests = new ArrayList();
                        this.requests.add(0L);
                        return;
                    }
                    this.emitting = true;
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void setConcatProducer(Producer producer) {
            if (this.concatProducer == null) {
                this.concatProducer = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        public final boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public final void nextIteration(long j) {
            this.state = this.parent.next(this.state, j, this.serializedSubscriber);
        }

        /* access modifiers changed from: package-private */
        public final void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th) {
                handleThrownError(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
            r5 = r5.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
            if (r5.hasNext() == false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
            if (tryEmit(r5.next().longValue()) == false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            return;
         */
        public final void request(long j) {
            boolean z;
            if (j != 0) {
                if (j >= 0) {
                    synchronized (this) {
                        z = true;
                        if (this.emitting) {
                            List list = this.requests;
                            if (list == null) {
                                list = new ArrayList();
                                this.requests = list;
                            }
                            list.add(Long.valueOf(j));
                        } else {
                            this.emitting = true;
                            z = false;
                        }
                    }
                    this.concatProducer.request(j);
                    if (z || tryEmit(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.requests;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.requests = null;
                        }
                    }
                    while (true) {
                    }
                }
                throw new IllegalStateException("Request can't be negative! ".concat(String.valueOf(j)));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            if (tryEmit(r4) == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r4 = r3.requests;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            if (r4 != null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
            r3.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
            r3.requests = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003d, code lost:
            r4 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
            if (r4.hasNext() == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0055, code lost:
            if (tryEmit(r4.next().longValue()) == false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0057, code lost:
            return;
         */
        public final void requestRemaining(long j) {
            if (j != 0) {
                if (j >= 0) {
                    synchronized (this) {
                        if (this.emitting) {
                            List list = this.requests;
                            if (list == null) {
                                list = new ArrayList();
                                this.requests = list;
                            }
                            list.add(Long.valueOf(j));
                            return;
                        }
                        this.emitting = true;
                    }
                } else {
                    throw new IllegalStateException("Request can't be negative! ".concat(String.valueOf(j)));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean tryEmit(long j) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j;
                nextIteration(j);
                if ((this.hasTerminated && !this.subscriptions.hasSubscriptions()) || isUnsubscribed()) {
                    cleanup();
                    return true;
                } else if (this.onNextCalled) {
                    return false;
                } else {
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
            } catch (Throwable th) {
                handleThrownError(th);
                return true;
            }
        }

        private void handleThrownError(Throwable th) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th);
            cleanup();
        }

        public final void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public final void onError(Throwable th) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public final void onNext(Observable<? extends T> observable) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (!this.hasTerminated) {
                    subscribeBufferToObservable(observable);
                    return;
                }
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            final BufferUntilSubscriber create = BufferUntilSubscriber.create();
            final long j = this.expectedDelivery;
            final AnonymousClass1 r3 = new Subscriber<T>() {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass1 */
                long remaining = j;

                public void onNext(T t) {
                    this.remaining--;
                    create.onNext(t);
                }

                public void onError(Throwable th) {
                    create.onError(th);
                }

                public void onCompleted() {
                    create.onCompleted();
                    long j = this.remaining;
                    if (j > 0) {
                        AsyncOuterManager.this.requestRemaining(j);
                    }
                }
            };
            this.subscriptions.add(r3);
            observable.doOnTerminate(new Action0() {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass2 */

                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(r3);
                }
            }).subscribe((Subscriber) r3);
            this.merger.onNext(create);
        }
    }

    static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        protected UnicastSubject(State<T> state2) {
            super(state2);
            this.state = state2;
        }

        public final void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        public final void onError(Throwable th) {
            this.state.subscriber.onError(th);
        }

        public final void onNext(T t) {
            this.state.subscriber.onNext(t);
        }

        static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            State() {
            }

            public final void call(Subscriber<? super T> subscriber2) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = subscriber2;
                    } else {
                        subscriber2.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }
    }
}
