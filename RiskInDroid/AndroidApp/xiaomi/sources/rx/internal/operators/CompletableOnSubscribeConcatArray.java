package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

public final class CompletableOnSubscribeConcatArray implements Completable.OnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeConcatArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public final void call(CompletableSubscriber completableSubscriber) {
        ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, this.sources);
        completableSubscriber.onSubscribe(concatInnerSubscriber.sd);
        concatInnerSubscriber.next();
    }

    static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableSubscriber actual;
        int index;
        final SerialSubscription sd = new SerialSubscription();
        final Completable[] sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Completable[] completableArr) {
            this.actual = completableSubscriber;
            this.sources = completableArr;
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
                Completable[] completableArr = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == completableArr.length) {
                        this.actual.onCompleted();
                        return;
                    }
                    completableArr[i].unsafeSubscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
