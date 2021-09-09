package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;

public final class ScalarSynchronousObservable<T> extends Observable<T> {
    static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    final T t;

    static <T> Producer createProducer(Subscriber<? super T> subscriber, T t2) {
        if (STRONG_MODE) {
            return new SingleProducer(subscriber, t2);
        }
        return new WeakSingleProducer(subscriber, t2);
    }

    public static <T> ScalarSynchronousObservable<T> create(Object obj) {
        return new ScalarSynchronousObservable<>(obj);
    }

    protected ScalarSynchronousObservable(T t2) {
        super(RxJavaHooks.onCreate(new JustOnSubscribe(t2)));
        this.t = t2;
    }

    public final T get() {
        return this.t;
    }

    public final Observable<T> scalarScheduleOn(final Scheduler scheduler) {
        Object obj;
        if (scheduler instanceof EventLoopsScheduler) {
            final EventLoopsScheduler eventLoopsScheduler = (EventLoopsScheduler) scheduler;
            obj = new Func1<Action0, Subscription>() {
                /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass1 */

                public Subscription call(Action0 action0) {
                    return eventLoopsScheduler.scheduleDirect(action0);
                }
            };
        } else {
            obj = new Func1<Action0, Subscription>() {
                /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass2 */

                public Subscription call(final Action0 action0) {
                    final Scheduler.Worker createWorker = scheduler.createWorker();
                    createWorker.schedule(new Action0() {
                        /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass2.AnonymousClass1 */

                        public void call() {
                            try {
                                action0.call();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    });
                    return createWorker;
                }
            };
        }
        return unsafeCreate(new ScalarAsyncOnSubscribe(this.t, obj));
    }

    static final class JustOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final T value;

        JustOnSubscribe(T t) {
            this.value = t;
        }

        public final void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, this.value));
        }
    }

    static final class ScalarAsyncOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        ScalarAsyncOnSubscribe(T t, Func1<Action0, Subscription> func1) {
            this.value = t;
            this.onSchedule = func1;
        }

        public final void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(new ScalarAsyncProducer(subscriber, this.value, this.onSchedule));
        }
    }

    static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        final Subscriber<? super T> actual;
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        public ScalarAsyncProducer(Subscriber<? super T> subscriber, T t, Func1<Action0, Subscription> func1) {
            this.actual = subscriber;
            this.value = t;
            this.onSchedule = func1;
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j)));
            } else if (j != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        public final void call() {
            Subscriber<? super T> subscriber = this.actual;
            if (!subscriber.isUnsubscribed()) {
                T t = this.value;
                try {
                    subscriber.onNext(t);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber, t);
                }
            }
        }

        public final String toString() {
            return "ScalarAsyncProducer[" + ((Object) this.value) + ", " + get() + "]";
        }
    }

    public final <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> func1) {
        return unsafeCreate(new Observable.OnSubscribe<R>() {
            /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass3 */

            public void call(Subscriber<? super R> subscriber) {
                Observable observable = (Observable) func1.call(ScalarSynchronousObservable.this.t);
                if (observable instanceof ScalarSynchronousObservable) {
                    subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, ((ScalarSynchronousObservable) observable).t));
                } else {
                    observable.unsafeSubscribe(Subscribers.wrap(subscriber));
                }
            }
        });
    }

    static final class WeakSingleProducer<T> implements Producer {
        final Subscriber<? super T> actual;
        boolean once;
        final T value;

        public WeakSingleProducer(Subscriber<? super T> subscriber, T t) {
            this.actual = subscriber;
            this.value = t;
        }

        public final void request(long j) {
            if (!this.once) {
                if (j < 0) {
                    throw new IllegalStateException("n >= required but it was ".concat(String.valueOf(j)));
                } else if (j != 0) {
                    this.once = true;
                    Subscriber<? super T> subscriber = this.actual;
                    if (!subscriber.isUnsubscribed()) {
                        T t = this.value;
                        try {
                            subscriber.onNext(t);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                            }
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber, t);
                        }
                    }
                }
            }
        }
    }
}
