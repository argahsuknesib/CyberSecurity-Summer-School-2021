package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMerge implements Completable.OnSubscribe {
    final boolean delayErrors;
    final int maxConcurrency;
    final Observable<Completable> source;

    /* JADX WARN: Type inference failed for: r1v0, types: [rx.Observable<? extends rx.Completable>, rx.Observable<rx.Completable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public CompletableOnSubscribeMerge(Observable<? extends Completable> r1, int i, boolean z) {
        this.source = r1;
        this.maxConcurrency = i;
        this.delayErrors = z;
    }

    public final void call(CompletableSubscriber completableSubscriber) {
        CompletableMergeSubscriber completableMergeSubscriber = new CompletableMergeSubscriber(completableSubscriber, this.maxConcurrency, this.delayErrors);
        completableSubscriber.onSubscribe(completableMergeSubscriber);
        this.source.unsafeSubscribe(completableMergeSubscriber);
    }

    static final class CompletableMergeSubscriber extends Subscriber<Completable> {
        final CompletableSubscriber actual;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Queue<Throwable>> errors = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(1);

        public CompletableMergeSubscriber(CompletableSubscriber completableSubscriber, int i, boolean z) {
            this.actual = completableSubscriber;
            this.delayErrors = z;
            if (i == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        public final Queue<Throwable> getOrCreateErrors() {
            Queue<Throwable> queue = this.errors.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            if (this.errors.compareAndSet(null, concurrentLinkedQueue)) {
                return concurrentLinkedQueue;
            }
            return this.errors.get();
        }

        public final void onNext(Completable completable) {
            if (!this.done) {
                this.wip.getAndIncrement();
                completable.unsafeSubscribe(new CompletableSubscriber() {
                    /* class rx.internal.operators.CompletableOnSubscribeMerge.CompletableMergeSubscriber.AnonymousClass1 */
                    Subscription d;
                    boolean innerDone;

                    public void onSubscribe(Subscription subscription) {
                        this.d = subscription;
                        CompletableMergeSubscriber.this.set.add(subscription);
                    }

                    public void onError(Throwable th) {
                        if (this.innerDone) {
                            RxJavaHooks.onError(th);
                            return;
                        }
                        this.innerDone = true;
                        CompletableMergeSubscriber.this.set.remove(this.d);
                        CompletableMergeSubscriber.this.getOrCreateErrors().offer(th);
                        CompletableMergeSubscriber.this.terminate();
                        if (CompletableMergeSubscriber.this.delayErrors && !CompletableMergeSubscriber.this.done) {
                            CompletableMergeSubscriber.this.request(1);
                        }
                    }

                    public void onCompleted() {
                        if (!this.innerDone) {
                            this.innerDone = true;
                            CompletableMergeSubscriber.this.set.remove(this.d);
                            CompletableMergeSubscriber.this.terminate();
                            if (!CompletableMergeSubscriber.this.done) {
                                CompletableMergeSubscriber.this.request(1);
                            }
                        }
                    }
                });
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            getOrCreateErrors().offer(th);
            this.done = true;
            terminate();
        }

        public final void onCompleted() {
            if (!this.done) {
                this.done = true;
                terminate();
            }
        }

        /* access modifiers changed from: package-private */
        public final void terminate() {
            Queue queue;
            if (this.wip.decrementAndGet() == 0) {
                Queue queue2 = this.errors.get();
                if (queue2 == null || queue2.isEmpty()) {
                    this.actual.onCompleted();
                    return;
                }
                Throwable collectErrors = CompletableOnSubscribeMerge.collectErrors(queue2);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(collectErrors);
                } else {
                    RxJavaHooks.onError(collectErrors);
                }
            } else if (!this.delayErrors && (queue = this.errors.get()) != null && !queue.isEmpty()) {
                Throwable collectErrors2 = CompletableOnSubscribeMerge.collectErrors(queue);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(collectErrors2);
                } else {
                    RxJavaHooks.onError(collectErrors2);
                }
            }
        }
    }

    public static Throwable collectErrors(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException(arrayList);
    }
}
