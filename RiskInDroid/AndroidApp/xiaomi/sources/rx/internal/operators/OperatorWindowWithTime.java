package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    public OperatorWindowWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = scheduler2;
    }

    public final Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber, createWorker);
            exactSubscriber.add(createWorker);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber, createWorker);
        inexactSubscriber.add(createWorker);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }

    static final class State<T> {
        static final State<Object> EMPTY = new State<>(null, null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> observer, Observable<T> observable, int i) {
            this.consumer = observer;
            this.producer = observable;
            this.count = i;
        }

        public final State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }

        public final State<T> create(Observer<T> observer, Observable<T> observable) {
            return new State<>(observer, observable, 0);
        }

        public final State<T> clear() {
            return empty();
        }

        public static <T> State<T> empty() {
            return EMPTY;
        }
    }

    final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        final Object guard = new Object();
        List<Object> queue;
        volatile State<T> state = State.empty();
        final Scheduler.Worker worker;

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            this.child = new SerializedSubscriber(subscriber);
            this.worker = worker2;
            subscriber.add(Subscriptions.create(new Action0(OperatorWindowWithTime.this) {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass1 */

                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        public final void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            if (emitValue(r5) != false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0030, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r2 = r4.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0033, code lost:
            if (r2 != null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0035, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0038, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r4.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x003c, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0041, code lost:
            if (drain(r2) != false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0043, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0045, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0048, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0049, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x004d, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x004e, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0051, code lost:
            r5 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0053, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0055, code lost:
            r5 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0056, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0057, code lost:
            if (r1 == false) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x005b, code lost:
            monitor-enter(r4.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0063, code lost:
            throw r5;
         */
        public final void onNext(T t) {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                boolean z = true;
                this.emitting = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean drain(List<Object> list) {
            if (list == null) {
                return true;
            }
            Iterator<Object> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else if (NotificationLite.isError(next)) {
                    error(NotificationLite.getError(next));
                    break;
                } else if (NotificationLite.isCompleted(next)) {
                    complete();
                    break;
                } else if (!emitValue(next)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean replaceSubject() {
            Observer<T> observer = this.state.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject create = UnicastSubject.create();
            this.state = this.state.create(create, create);
            this.child.onNext(create);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean emitValue(T t) {
            State<T> state2;
            State<T> state3 = this.state;
            if (state3.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                state3 = this.state;
            }
            state3.consumer.onNext(t);
            if (state3.count == OperatorWindowWithTime.this.size - 1) {
                state3.consumer.onCompleted();
                state2 = state3.clear();
            } else {
                state2 = state3.next();
            }
            this.state = state2;
            return true;
        }

        public final void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(th));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void error(Throwable th) {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        /* access modifiers changed from: package-private */
        public final void complete() {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        public final void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(NotificationLite.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void scheduleExact() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass2 */

                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            }, 0, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            if (replaceSubject() != false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0032, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r3 = r6.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0035, code lost:
            if (r3 != null) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0037, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x003a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x003e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0043, code lost:
            if (drain(r3) != false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0045, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0047, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x004a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x004b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x004f, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0050, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0053, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0054, code lost:
            r5 = r2;
            r2 = r1;
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0058, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x005a, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x005b, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x005c, code lost:
            if (r2 == false) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0060, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0068, code lost:
            throw r1;
         */
        public final void nextWindow() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
                    return;
                }
                boolean z = true;
                this.emitting = true;
            }
        }
    }

    static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks = new LinkedList();
        boolean done;
        final Object guard = new Object();
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            super(subscriber);
            this.child = subscriber;
            this.worker = worker2;
        }

        public final void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
            if (r0.hasNext() == false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
            r1 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next();
            r1.consumer.onNext(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
            if (r1.count != r5.this$0.size) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
            r1.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
            return;
         */
        public final void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList arrayList = new ArrayList(this.chunks);
                    Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                    while (it.hasNext()) {
                        CountedSerializedSubject next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == OperatorWindowWithTime.this.size) {
                            it.remove();
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
            if (r0.hasNext() == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            ((rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next()).consumer.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r3.child.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            r0 = r1.iterator();
         */
        public final void onError(Throwable th) {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
            if (r0.hasNext() == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            ((rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next()).consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r3.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            r0 = r1.iterator();
         */
        public final void onCompleted() {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void scheduleChunk() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass1 */

                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public final void startNewChunk() {
            final CountedSerializedSubject createCountedSerializedSubject = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(createCountedSerializedSubject);
                    try {
                        this.child.onNext(createCountedSerializedSubject.producer);
                        this.worker.schedule(new Action0() {
                            /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass2 */

                            public void call() {
                                InexactSubscriber.this.terminateChunk(createCountedSerializedSubject);
                            }
                        }, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            r4.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        public final void terminateChunk(CountedSerializedSubject<T> countedSerializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == countedSerializedSubject) {
                                z = true;
                                it.remove();
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new CountedSerializedSubject<>(create, create);
        }
    }
}
