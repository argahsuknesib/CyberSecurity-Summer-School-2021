package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class QueuedProducer<T> extends AtomicLong implements Observer<T>, Producer {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final Subscriber<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QueuedProducer(Subscriber<? super T> subscriber) {
        this(subscriber, UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue());
    }

    public QueuedProducer(Subscriber<? super T> subscriber, Queue<Object> queue2) {
        this.child = subscriber;
        this.queue = queue2;
        this.wip = new AtomicInteger();
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j > 0) {
            BackpressureUtils.getAndAddRequest(this, j);
            drain();
        }
    }

    public final boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    public final void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
    }

    public final void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public final void onCompleted() {
        this.done = true;
        drain();
    }

    private boolean checkTerminated(boolean z, boolean z2) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th = this.error;
        if (th != null) {
            this.queue.clear();
            this.child.onError(th);
            return true;
        } else if (!z2) {
            return false;
        } else {
            this.child.onCompleted();
            return true;
        }
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.child;
            Queue<Object> queue2 = this.queue;
            while (!checkTerminated(this.done, queue2.isEmpty())) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0) {
                    boolean z = this.done;
                    Object poll = queue2.poll();
                    if (!checkTerminated(z, poll == null)) {
                        if (poll == null) {
                            break;
                        }
                        Object obj = null;
                        try {
                            if (poll == NULL_SENTINEL) {
                                subscriber.onNext(null);
                            } else {
                                subscriber.onNext(poll);
                            }
                            j--;
                            j2++;
                        } catch (Throwable th) {
                            if (poll != NULL_SENTINEL) {
                                obj = poll;
                            }
                            Exceptions.throwOrReport(th, subscriber, obj);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j2 == 0 || get() == Long.MAX_VALUE)) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
