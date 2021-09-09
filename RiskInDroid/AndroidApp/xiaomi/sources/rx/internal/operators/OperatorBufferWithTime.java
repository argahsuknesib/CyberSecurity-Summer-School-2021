package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final Scheduler scheduler;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    public OperatorBufferWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = scheduler2;
    }

    public final Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(serializedSubscriber, createWorker);
            exactSubscriber.add(createWorker);
            subscriber.add(exactSubscriber);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(serializedSubscriber, createWorker);
        inexactSubscriber.add(createWorker);
        subscriber.add(inexactSubscriber);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }

    final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        boolean done;
        final Scheduler.Worker inner;

        public InexactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            r6 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            if (r6.hasNext() == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
            r5.child.onNext((java.util.List) r6.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        public final void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.chunks.iterator();
                    LinkedList linkedList = null;
                    while (it.hasNext()) {
                        List next = it.next();
                        next.add(t);
                        if (next.size() == OperatorBufferWithTime.this.count) {
                            it.remove();
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(next);
                        }
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunks.clear();
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r0 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (r0.hasNext() == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            r3.child.onNext((java.util.List) r0.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            r3.child.onCompleted();
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
            return;
         */
        public final void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        LinkedList linkedList = new LinkedList(this.chunks);
                        this.chunks.clear();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.child);
            }
        }

        /* access modifiers changed from: package-private */
        public final void scheduleChunk() {
            this.inner.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.AnonymousClass1 */

                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public final void startNewChunk() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    this.inner.schedule(new Action0() {
                        /* class rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.AnonymousClass2 */

                        public void call() {
                            InexactSubscriber.this.emitChunk(arrayList);
                        }
                    }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r2.child.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
            rx.exceptions.Exceptions.throwOrReport(r3, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        public final void emitChunk(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.chunks.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == list) {
                                it.remove();
                                z = true;
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
    }

    final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk = new ArrayList();
        boolean done;
        final Scheduler.Worker inner;

        public ExactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            r1.child.onNext(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        public final void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t);
                    if (this.chunk.size() == OperatorBufferWithTime.this.count) {
                        list = this.chunk;
                        this.chunk = new ArrayList();
                    } else {
                        list = null;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunk = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        public final void onCompleted() {
            try {
                this.inner.unsubscribe();
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.chunk;
                        this.chunk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.child);
            }
        }

        /* access modifiers changed from: package-private */
        public final void scheduleExact() {
            this.inner.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorBufferWithTime.ExactSubscriber.AnonymousClass1 */

                public void call() {
                    ExactSubscriber.this.emit();
                }
            }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public final void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.chunk;
                    this.chunk = new ArrayList();
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }
        }
    }
}
