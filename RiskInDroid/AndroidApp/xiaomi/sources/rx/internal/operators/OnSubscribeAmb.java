package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeAmb<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends Observable<? extends T>> sources;

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        arrayList.add(observable9);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }

    static final class AmbSubscriber<T> extends Subscriber<T> {
        private boolean chosen;
        private final Selection<T> selection;
        private final Subscriber<? super T> subscriber;

        AmbSubscriber(long j, Subscriber<? super T> subscriber2, Selection<T> selection2) {
            this.subscriber = subscriber2;
            this.selection = selection2;
            request(j);
        }

        public final void requestMore(long j) {
            request(j);
        }

        public final void onNext(T t) {
            if (isSelected()) {
                this.subscriber.onNext(t);
            }
        }

        public final void onCompleted() {
            if (isSelected()) {
                this.subscriber.onCompleted();
            }
        }

        public final void onError(Throwable th) {
            if (isSelected()) {
                this.subscriber.onError(th);
            }
        }

        private boolean isSelected() {
            if (this.chosen) {
                return true;
            }
            if (this.selection.get() == this) {
                this.chosen = true;
                return true;
            } else if (this.selection.compareAndSet(null, this)) {
                this.selection.unsubscribeOthers(this);
                this.chosen = true;
                return true;
            } else {
                this.selection.unsubscribeLosers();
                return false;
            }
        }
    }

    static final class Selection<T> extends AtomicReference<AmbSubscriber<T>> {
        final Collection<AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();

        Selection() {
        }

        public final void unsubscribeLosers() {
            AmbSubscriber ambSubscriber = (AmbSubscriber) get();
            if (ambSubscriber != null) {
                unsubscribeOthers(ambSubscriber);
            }
        }

        public final void unsubscribeOthers(AmbSubscriber<T> ambSubscriber) {
            for (AmbSubscriber<T> next : this.ambSubscribers) {
                if (next != ambSubscriber) {
                    next.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }

    private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> iterable) {
        this.sources = iterable;
    }

    public final void call(Subscriber<? super T> subscriber) {
        final Selection selection = new Selection();
        subscriber.add(Subscriptions.create(new Action0() {
            /* class rx.internal.operators.OnSubscribeAmb.AnonymousClass1 */

            public void call() {
                AmbSubscriber ambSubscriber = (AmbSubscriber) selection.get();
                if (ambSubscriber != null) {
                    ambSubscriber.unsubscribe();
                }
                OnSubscribeAmb.unsubscribeAmbSubscribers(selection.ambSubscribers);
            }
        }));
        for (Observable observable : this.sources) {
            if (subscriber.isUnsubscribed()) {
                break;
            }
            AmbSubscriber ambSubscriber = new AmbSubscriber(0, subscriber, selection);
            selection.ambSubscribers.add(ambSubscriber);
            AmbSubscriber ambSubscriber2 = (AmbSubscriber) selection.get();
            if (ambSubscriber2 != null) {
                selection.unsubscribeOthers(ambSubscriber2);
                return;
            }
            observable.unsafeSubscribe(ambSubscriber);
        }
        if (subscriber.isUnsubscribed()) {
            unsubscribeAmbSubscribers(selection.ambSubscribers);
        }
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeAmb.AnonymousClass2 */

            public void request(long j) {
                AmbSubscriber ambSubscriber = (AmbSubscriber) selection.get();
                if (ambSubscriber != null) {
                    ambSubscriber.requestMore(j);
                    return;
                }
                for (AmbSubscriber next : selection.ambSubscribers) {
                    if (!next.isUnsubscribed()) {
                        if (selection.get() == next) {
                            next.requestMore(j);
                            return;
                        }
                        next.requestMore(j);
                    }
                }
            }
        });
    }

    static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> collection) {
        if (!collection.isEmpty()) {
            for (AmbSubscriber<T> unsubscribe : collection) {
                unsubscribe.unsubscribe();
            }
            collection.clear();
        }
    }
}
