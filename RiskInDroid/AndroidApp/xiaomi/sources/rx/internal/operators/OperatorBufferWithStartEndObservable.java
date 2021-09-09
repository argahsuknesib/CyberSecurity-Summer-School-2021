package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing> implements Observable.Operator<List<T>, T> {
    final Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosing;
    final Observable<? extends TOpening> bufferOpening;

    public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        this.bufferOpening = observable;
        this.bufferClosing = func1;
    }

    public final Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
        AnonymousClass1 r1 = new Subscriber<TOpening>() {
            /* class rx.internal.operators.OperatorBufferWithStartEndObservable.AnonymousClass1 */

            public void onNext(TOpening topening) {
                bufferingSubscriber.startBuffer(topening);
            }

            public void onError(Throwable th) {
                bufferingSubscriber.onError(th);
            }

            public void onCompleted() {
                bufferingSubscriber.onCompleted();
            }
        };
        subscriber.add(r1);
        subscriber.add(bufferingSubscriber);
        this.bufferOpening.unsafeSubscribe(r1);
        return bufferingSubscriber;
    }

    final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        final CompositeSubscription closingSubscriptions = new CompositeSubscription();
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            add(this.closingSubscriptions);
        }

        public final void onNext(T t) {
            synchronized (this) {
                for (List<T> add : this.chunks) {
                    add.add(t);
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
        public final void startBuffer(TOpening topening) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    try {
                        Observable observable = (Observable) OperatorBufferWithStartEndObservable.this.bufferClosing.call(topening);
                        AnonymousClass1 r1 = new Subscriber<TClosing>() {
                            /* class rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.AnonymousClass1 */

                            public void onNext(TClosing tclosing) {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }

                            public void onError(Throwable th) {
                                BufferingSubscriber.this.onError(th);
                            }

                            public void onCompleted() {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }
                        };
                        this.closingSubscriptions.add(r1);
                        observable.unsafeSubscribe(r1);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r2.child.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        public final void endBuffer(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.chunks.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == list) {
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
    }
}
