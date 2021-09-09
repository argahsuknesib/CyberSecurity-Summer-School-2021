package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        this(new Object(), new AtomicReference(), new ArrayList(), observable, func0);
    }

    private OperatorMulticast(final Object obj, final AtomicReference<Subject<? super T, ? extends R>> atomicReference, final List<Subscriber<? super R>> list, Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        super(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorMulticast.AnonymousClass1 */

            public void call(Subscriber<? super R> subscriber) {
                synchronized (obj) {
                    if (atomicReference.get() == null) {
                        list.add(subscriber);
                    } else {
                        ((Subject) atomicReference.get()).unsafeSubscribe(subscriber);
                    }
                }
            }
        });
        this.guard = obj;
        this.connectedSubject = atomicReference;
        this.waitingForConnect = list;
        this.source = observable;
        this.subjectFactory = func0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        r6.call(r5.guardedSubscription);
        r6 = r5.guard;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = r5.subscription;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        r5.source.subscribe((rx.Subscriber) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    public final void connect(Action1<? super Subscription> action1) {
        synchronized (this.guard) {
            if (this.subscription != null) {
                action1.call(this.guardedSubscription);
                return;
            }
            Subject subject = (Subject) this.subjectFactory.call();
            this.subscription = Subscribers.from(subject);
            final AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorMulticast.AnonymousClass2 */

                /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
                    r1.unsubscribe();
                 */
                public void call() {
                    synchronized (OperatorMulticast.this.guard) {
                        if (OperatorMulticast.this.guardedSubscription == atomicReference.get()) {
                            Subscriber<T> subscriber = OperatorMulticast.this.subscription;
                            OperatorMulticast.this.subscription = null;
                            OperatorMulticast.this.guardedSubscription = null;
                            OperatorMulticast.this.connectedSubject.set(null);
                        }
                    }
                }
            }));
            this.guardedSubscription = (Subscription) atomicReference.get();
            for (final Subscriber next : this.waitingForConnect) {
                subject.unsafeSubscribe(new Subscriber<R>(next) {
                    /* class rx.internal.operators.OperatorMulticast.AnonymousClass3 */

                    public void onNext(R r) {
                        next.onNext(r);
                    }

                    public void onError(Throwable th) {
                        next.onError(th);
                    }

                    public void onCompleted() {
                        next.onCompleted();
                    }
                });
            }
            this.waitingForConnect.clear();
            this.connectedSubject.set(subject);
        }
    }
}
