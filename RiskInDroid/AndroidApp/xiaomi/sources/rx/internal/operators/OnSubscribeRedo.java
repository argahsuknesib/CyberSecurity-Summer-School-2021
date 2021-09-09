package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T> implements Observable.OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1<Observable<? extends Notification<?>>, Observable<?>>() {
        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable<? extends Notification<?>>) ((Observable) obj));
        }

        public final Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1.AnonymousClass1 */

                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((Notification<?>) ((Notification) obj));
                }

                public Notification<?> call(Notification<?> notification) {
                    return Notification.createOnNext(null);
                }
            });
        }
    };
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
    private final Scheduler scheduler;
    final Observable<T> source;
    final boolean stopOnComplete;
    final boolean stopOnError;

    public static final class RedoFinite implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final long count;

        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable<? extends Notification<?>>) ((Observable) obj));
        }

        public RedoFinite(long j) {
            this.count = j;
        }

        public final Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RedoFinite.AnonymousClass1 */
                int num;

                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((Notification<?>) ((Notification) obj));
                }

                public Notification<?> call(Notification<?> notification) {
                    if (RedoFinite.this.count == 0) {
                        return notification;
                    }
                    this.num++;
                    return ((long) this.num) <= RedoFinite.this.count ? Notification.createOnNext(Integer.valueOf(this.num)) : notification;
                }
            }).dematerialize();
        }
    }

    public static final class RetryWithPredicate implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {
        final Func2<Integer, Throwable, Boolean> predicate;

        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable<? extends Notification<?>>) ((Observable) obj));
        }

        public RetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
            this.predicate = func2;
        }

        public final Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> observable) {
            return observable.scan(Notification.createOnNext(0), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RetryWithPredicate.AnonymousClass1 */

                public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
                    return call((Notification<Integer>) ((Notification) obj), (Notification<?>) ((Notification) obj2));
                }

                /* JADX WARN: Type inference failed for: r5v0, types: [rx.Notification<?>, rx.Notification<java.lang.Integer>, rx.Notification] */
                /* JADX WARNING: Unknown variable types count: 1 */
                public Notification<Integer> call(Notification<Integer> notification, Notification<?> r5) {
                    int intValue = notification.getValue().intValue();
                    return RetryWithPredicate.this.predicate.call(Integer.valueOf(intValue), r5.getThrowable()).booleanValue() ? Notification.createOnNext(Integer.valueOf(intValue + 1)) : r5;
                }
            });
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable) {
        return retry(observable, REDO_INFINITE);
    }

    public static <T> Observable<T> retry(Observable observable, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        } else if (j == 0) {
            return observable;
        } else {
            return retry(observable, new RedoFinite(j));
        }
    }

    public static <T> Observable<T> retry(Observable observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, Schedulers.trampoline()));
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, scheduler2));
    }

    public static <T> Observable<T> repeat(Observable<T> observable) {
        return repeat(observable, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable observable, Scheduler scheduler2) {
        return repeat(observable, REDO_INFINITE, scheduler2);
    }

    public static <T> Observable<T> repeat(Observable observable, long j) {
        return repeat(observable, j, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable observable, long j, Scheduler scheduler2) {
        if (j == 0) {
            return Observable.empty();
        }
        if (j >= 0) {
            return repeat(observable, new RedoFinite(j - 1), scheduler2);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> repeat(Observable observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, Schedulers.trampoline()));
    }

    public static <T> Observable<T> repeat(Observable observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, scheduler2));
    }

    public static <T> Observable<T> redo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, false, scheduler2));
    }

    private OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z, boolean z2, Scheduler scheduler2) {
        this.source = observable;
        this.controlHandlerFunction = func1;
        this.stopOnComplete = z;
        this.stopOnError = z2;
        this.scheduler = scheduler2;
    }

    public final void call(Subscriber<? super T> subscriber) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serialized = BehaviorSubject.create().toSerialized();
        serialized.subscribe(Subscribers.empty());
        ProducerArbiter producerArbiter = new ProducerArbiter();
        final Subscriber<? super T> subscriber2 = subscriber;
        final SerializedSubject serializedSubject = serialized;
        final ProducerArbiter producerArbiter2 = producerArbiter;
        final AtomicLong atomicLong2 = atomicLong;
        AnonymousClass2 r1 = new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2 */

            public void call() {
                if (!subscriber2.isUnsubscribed()) {
                    AnonymousClass1 r0 = new Subscriber<T>() {
                        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2.AnonymousClass1 */
                        boolean done;

                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serializedSubject.onNext(Notification.createOnCompleted());
                            }
                        }

                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serializedSubject.onNext(Notification.createOnError(th));
                            }
                        }

                        public void onNext(T t) {
                            if (!this.done) {
                                subscriber2.onNext(t);
                                decrementConsumerCapacity();
                                producerArbiter2.produced(1);
                            }
                        }

                        private void decrementConsumerCapacity() {
                            long j;
                            do {
                                j = atomicLong2.get();
                                if (j == Long.MAX_VALUE) {
                                    return;
                                }
                            } while (!atomicLong2.compareAndSet(j, j - 1));
                        }

                        public void setProducer(Producer producer) {
                            producerArbiter2.setProducer(producer);
                        }
                    };
                    serialSubscription.set(r0);
                    OnSubscribeRedo.this.source.unsafeSubscribe(r0);
                }
            }
        };
        final Observable observable = (Observable) this.controlHandlerFunction.call(serialized.lift(new Observable.Operator<Notification<?>, Notification<?>>() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3 */

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Subscriber<? super Notification<?>>) ((Subscriber) obj));
            }

            public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> subscriber) {
                return new Subscriber<Notification<?>>(subscriber) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void onNext(Object obj) {
                        onNext((Notification<?>) ((Notification) obj));
                    }

                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    public void onNext(Notification<?> notification) {
                        if (notification.isOnCompleted() && OnSubscribeRedo.this.stopOnComplete) {
                            subscriber.onCompleted();
                        } else if (!notification.isOnError() || !OnSubscribeRedo.this.stopOnError) {
                            subscriber.onNext(notification);
                        } else {
                            subscriber.onError(notification.getThrowable());
                        }
                    }

                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }
                };
            }
        }));
        final AtomicLong atomicLong3 = atomicLong;
        final Scheduler.Worker worker = createWorker;
        final AnonymousClass2 r6 = r1;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        createWorker.schedule(new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4 */

            public void call() {
                observable.unsafeSubscribe(new Subscriber<Object>(subscriber2) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4.AnonymousClass1 */

                    public void onCompleted() {
                        subscriber2.onCompleted();
                    }

                    public void onError(Throwable th) {
                        subscriber2.onError(th);
                    }

                    public void onNext(Object obj) {
                        if (subscriber2.isUnsubscribed()) {
                            return;
                        }
                        if (atomicLong3.get() > 0) {
                            worker.schedule(r6);
                        } else {
                            atomicBoolean2.compareAndSet(false, true);
                        }
                    }

                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }
                });
            }
        });
        final AtomicLong atomicLong4 = atomicLong;
        final ProducerArbiter producerArbiter3 = producerArbiter;
        final AtomicBoolean atomicBoolean3 = atomicBoolean;
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass5 */

            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(atomicLong4, j);
                    producerArbiter3.request(j);
                    if (atomicBoolean3.compareAndSet(true, false)) {
                        worker.schedule(r6);
                    }
                }
            }
        });
    }
}
