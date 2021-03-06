package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaHooks;

public final class CompletableOnSubscribeConcat implements Completable.OnSubscribe {
    final int prefetch;
    final Observable<Completable> sources;

    /* JADX WARN: Type inference failed for: r1v0, types: [rx.Observable<? extends rx.Completable>, rx.Observable<rx.Completable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public CompletableOnSubscribeConcat(Observable<? extends Completable> r1, int i) {
        this.sources = r1;
        this.prefetch = i;
    }

    public final void call(CompletableSubscriber completableSubscriber) {
        CompletableConcatSubscriber completableConcatSubscriber = new CompletableConcatSubscriber(completableSubscriber, this.prefetch);
        completableSubscriber.onSubscribe(completableConcatSubscriber);
        this.sources.unsafeSubscribe(completableConcatSubscriber);
    }

    static final class CompletableConcatSubscriber extends Subscriber<Completable> {
        volatile boolean active;
        final CompletableSubscriber actual;
        volatile boolean done;
        final ConcatInnerSubscriber inner = new ConcatInnerSubscriber();
        final AtomicBoolean once = new AtomicBoolean();
        final SpscArrayQueue<Completable> queue;
        final SequentialSubscription sr = new SequentialSubscription();

        public CompletableConcatSubscriber(CompletableSubscriber completableSubscriber, int i) {
            this.actual = completableSubscriber;
            this.queue = new SpscArrayQueue<>(i);
            add(this.sr);
            request((long) i);
        }

        public final void onNext(Completable completable) {
            if (!this.queue.offer(completable)) {
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        public final void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                RxJavaHooks.onError(th);
            }
        }

        public final void onCompleted() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            unsubscribe();
            onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            ConcatInnerSubscriber concatInnerSubscriber = this.inner;
            if (concatInnerSubscriber.getAndIncrement() == 0) {
                while (!isUnsubscribed()) {
                    if (!this.active) {
                        boolean z = this.done;
                        Completable poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.actual.onCompleted();
                            return;
                        } else if (!z2) {
                            this.active = true;
                            poll.subscribe(concatInnerSubscriber);
                            request(1);
                        }
                    }
                    if (concatInnerSubscriber.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
            private static final long serialVersionUID = 7233503139645205620L;

            ConcatInnerSubscriber() {
            }

            public final void onSubscribe(Subscription subscription) {
                CompletableConcatSubscriber.this.sr.set(subscription);
            }

            public final void onError(Throwable th) {
                CompletableConcatSubscriber.this.innerError(th);
            }

            public final void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }
        }
    }
}
