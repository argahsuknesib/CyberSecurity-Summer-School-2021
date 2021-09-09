package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    final Observable<? extends U> windowOpenings;

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    public final Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        AnonymousClass1 r3 = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.AnonymousClass1 */

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onNext(U u) {
                sourceSubscriber.beginWindow(u);
            }

            public void onError(Throwable th) {
                sourceSubscriber.onError(th);
            }

            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(r3);
        this.windowOpenings.unsafeSubscribe(r3);
        return sourceSubscriber;
    }

    static final class SerializedSubject<T> {
        final Observer<T> consumer;
        final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    final class SourceSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<SerializedSubject<T>> chunks = new LinkedList();
        final CompositeSubscription composite;
        boolean done;
        final Object guard = new Object();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.composite = compositeSubscription;
        }

        public final void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r0.hasNext() == false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onNext(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            r0 = r1.iterator();
         */
        public final void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList arrayList = new ArrayList(this.chunks);
                }
            }
        }

        public final void onError(Throwable th) {
            try {
                synchronized (this.guard) {
                    if (!this.done) {
                        this.done = true;
                        ArrayList<SerializedSubject> arrayList = new ArrayList<>(this.chunks);
                        this.chunks.clear();
                        for (SerializedSubject serializedSubject : arrayList) {
                            serializedSubject.consumer.onError(th);
                        }
                        this.child.onError(th);
                    }
                }
                this.composite.unsubscribe();
            } catch (Throwable th2) {
                this.composite.unsubscribe();
                throw th2;
            }
        }

        public final void onCompleted() {
            try {
                synchronized (this.guard) {
                    if (!this.done) {
                        this.done = true;
                        ArrayList<SerializedSubject> arrayList = new ArrayList<>(this.chunks);
                        this.chunks.clear();
                        for (SerializedSubject serializedSubject : arrayList) {
                            serializedSubject.consumer.onCompleted();
                        }
                        this.child.onCompleted();
                    }
                }
                this.composite.unsubscribe();
            } catch (Throwable th) {
                this.composite.unsubscribe();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public final void beginWindow(U u) {
            final SerializedSubject createSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(createSerializedSubject);
                    this.child.onNext(createSerializedSubject.producer);
                    try {
                        Observable observable = (Observable) OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u);
                        AnonymousClass1 r1 = new Subscriber<V>() {
                            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.AnonymousClass1 */
                            boolean once = true;

                            public void onNext(V v) {
                                onCompleted();
                            }

                            public void onError(Throwable th) {
                                SourceSubscriber.this.onError(th);
                            }

                            public void onCompleted() {
                                if (this.once) {
                                    this.once = false;
                                    SourceSubscriber.this.endWindow(createSerializedSubject);
                                    SourceSubscriber.this.composite.remove(this);
                                }
                            }
                        };
                        this.composite.add(r1);
                        observable.unsafeSubscribe(r1);
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
        public final void endWindow(SerializedSubject<T> serializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<SerializedSubject<T>> it = this.chunks.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == serializedSubject) {
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
        public final SerializedSubject<T> createSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new SerializedSubject<>(create, create);
        }
    }
}
