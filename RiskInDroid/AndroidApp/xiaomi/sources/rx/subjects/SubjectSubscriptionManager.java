package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active = true;
    volatile Object latest;
    Action1<SubjectObserver<T>> onAdded = Actions.empty();
    Action1<SubjectObserver<T>> onStart = Actions.empty();
    Action1<SubjectObserver<T>> onTerminated = Actions.empty();

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
    }

    public final void call(Subscriber<? super T> subscriber) {
        SubjectObserver subjectObserver = new SubjectObserver(subscriber);
        addUnsubscriber(subscriber, subjectObserver);
        this.onStart.call(subjectObserver);
        if (!subscriber.isUnsubscribed() && add(subjectObserver) && subscriber.isUnsubscribed()) {
            remove(subjectObserver);
        }
    }

    /* access modifiers changed from: package-private */
    public final void addUnsubscriber(Subscriber<? super T> subscriber, final SubjectObserver<T> subjectObserver) {
        subscriber.add(Subscriptions.create(new Action0() {
            /* class rx.subjects.SubjectSubscriptionManager.AnonymousClass1 */

            public void call() {
                SubjectSubscriptionManager.this.remove(subjectObserver);
            }
        }));
    }

    /* access modifiers changed from: package-private */
    public final void setLatest(Object obj) {
        this.latest = obj;
    }

    /* access modifiers changed from: package-private */
    public final Object getLatest() {
        return this.latest;
    }

    /* access modifiers changed from: package-private */
    public final SubjectObserver<T>[] observers() {
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public final boolean add(SubjectObserver<T> subjectObserver) {
        State state;
        do {
            state = (State) get();
            if (state.terminated) {
                this.onTerminated.call(subjectObserver);
                return false;
            }
        } while (!compareAndSet(state, state.add(subjectObserver)));
        this.onAdded.call(subjectObserver);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void remove(SubjectObserver<T> subjectObserver) {
        State state;
        State remove;
        do {
            state = (State) get();
            if (state.terminated || (remove = state.remove(subjectObserver)) == state) {
                return;
            }
        } while (!compareAndSet(state, remove));
    }

    /* access modifiers changed from: package-private */
    public final SubjectObserver<T>[] next(Object obj) {
        setLatest(obj);
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public final SubjectObserver<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (((State) get()).terminated) {
            return State.NO_OBSERVERS;
        }
        return ((State) getAndSet(State.TERMINATED)).observers;
    }

    public static final class State<T> {
        static final State EMPTY = new State(false, NO_OBSERVERS);
        static final SubjectObserver[] NO_OBSERVERS = new SubjectObserver[0];
        static final State TERMINATED = new State(true, NO_OBSERVERS);
        final SubjectObserver[] observers;
        final boolean terminated;

        public State(boolean z, SubjectObserver[] subjectObserverArr) {
            this.terminated = z;
            this.observers = subjectObserverArr;
        }

        public final State add(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[(length + 1)];
            System.arraycopy(subjectObserverArr, 0, subjectObserverArr2, 0, length);
            subjectObserverArr2[length] = subjectObserver;
            return new State(this.terminated, subjectObserverArr2);
        }

        public final State remove(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr;
            SubjectObserver[] subjectObserverArr2 = this.observers;
            if (r1 == 1 && subjectObserverArr2[0] == subjectObserver) {
                return EMPTY;
            }
            if (r1 == 0) {
                return this;
            }
            int i = r1 - 1;
            SubjectObserver[] subjectObserverArr3 = new SubjectObserver[i];
            int i2 = 0;
            for (SubjectObserver subjectObserver2 : subjectObserverArr2) {
                if (subjectObserver2 != subjectObserver) {
                    if (i2 == i) {
                        return this;
                    }
                    subjectObserverArr3[i2] = subjectObserver2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return EMPTY;
            }
            if (i2 < i) {
                subjectObserverArr = new SubjectObserver[i2];
                System.arraycopy(subjectObserverArr3, 0, subjectObserverArr, 0, i2);
            } else {
                subjectObserverArr = subjectObserverArr3;
            }
            return new State(this.terminated, subjectObserverArr);
        }
    }

    public static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public final void onNext(T t) {
            this.actual.onNext(t);
        }

        public final void onError(Throwable th) {
            this.actual.onError(th);
        }

        public final void onCompleted() {
            this.actual.onCompleted();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.fastPath = true;
         */
        public final void emitNext(Object obj) {
            if (!this.fastPath) {
                synchronized (this) {
                    this.first = false;
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(obj);
                        return;
                    }
                }
            }
            NotificationLite.accept(this.actual, obj);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            emitLoop(null, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        public final void emitFirst(Object obj) {
            synchronized (this) {
                if (this.first) {
                    if (!this.emitting) {
                        boolean z = false;
                        this.first = false;
                        if (obj != null) {
                            z = true;
                        }
                        this.emitting = z;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void emitLoop(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object accept : list) {
                            accept(accept);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                if (z2) {
                    accept(obj);
                    z2 = false;
                }
                synchronized (this) {
                    try {
                        list = this.queue;
                        this.queue = null;
                        if (list == null) {
                            this.emitting = false;
                            try {
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void accept(Object obj) {
            if (obj != null) {
                NotificationLite.accept(this.actual, obj);
            }
        }

        /* access modifiers changed from: package-private */
        public final Observer<? super T> getActual() {
            return this.actual;
        }

        public final <I> I index() {
            return this.index;
        }

        public final void index(Object obj) {
            this.index = obj;
        }
    }
}
