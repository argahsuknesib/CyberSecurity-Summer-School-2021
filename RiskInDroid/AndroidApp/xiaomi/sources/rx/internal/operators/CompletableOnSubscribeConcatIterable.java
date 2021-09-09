package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class CompletableOnSubscribeConcatIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public final void call(CompletableSubscriber completableSubscriber) {
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, it);
            completableSubscriber.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onError(th);
        }
    }

    static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableSubscriber actual;
        final SerialSubscription sd = new SerialSubscription();
        final Iterator<? extends Completable> sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it) {
            this.actual = completableSubscriber;
            this.sources = it;
        }

        public final void onSubscribe(Subscription subscription) {
            this.sd.set(subscription);
        }

        public final void onError(Throwable th) {
            this.actual.onError(th);
        }

        public final void onCompleted() {
            next();
        }

        /* access modifiers changed from: package-private */
        public final void next() {
            if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends Completable> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            Completable completable = (Completable) it.next();
                            if (completable == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            completable.unsafeSubscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }
    }
}
