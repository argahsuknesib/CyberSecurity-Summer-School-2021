package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            this.subscribers = (PublishProducer[]) EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was ".concat(String.valueOf(i)));
    }

    public final void call(Subscriber<? super T> subscriber) {
        PublishProducer publishProducer = new PublishProducer(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }

    public final void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
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

    /* access modifiers changed from: package-private */
    public final void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    /* access modifiers changed from: package-private */
    public final void drain() {
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i = 0;
            do {
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                long j = Long.MAX_VALUE;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        T poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 == j && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j2);
                        }
                        for (PublishProducer<T> produced : publishProducerArr) {
                            BackpressureUtils.produced(produced, j2);
                        }
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        if (publishProducerArr != TERMINATED) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    this.subscribers = (PublishProducer[]) TERMINATED;
                }
            }
        }
        return publishProducerArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean add(PublishProducer<T> publishProducer) {
        if (this.subscribers == TERMINATED) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            if (publishProducerArr == TERMINATED) {
                return false;
            }
            int length = publishProducerArr.length;
            PublishProducer<T>[] publishProducerArr2 = new PublishProducer[(length + 1)];
            System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
            publishProducerArr2[length] = publishProducer;
            this.subscribers = publishProducerArr2;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    public final void remove(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr;
        PublishProducer<T>[] publishProducerArr2 = this.subscribers;
        if (publishProducerArr2 != TERMINATED && publishProducerArr2 != EMPTY) {
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr3 = this.subscribers;
                if (publishProducerArr3 != TERMINATED) {
                    if (publishProducerArr3 != EMPTY) {
                        int i = -1;
                        int length = publishProducerArr3.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (publishProducerArr3[i2] == publishProducer) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                publishProducerArr = (PublishProducer[]) EMPTY;
                            } else {
                                PublishProducer<T>[] publishProducerArr4 = new PublishProducer[(length - 1)];
                                System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, i);
                                System.arraycopy(publishProducerArr3, i + 1, publishProducerArr4, i, (length - i) - 1);
                                publishProducerArr = publishProducerArr4;
                            }
                            this.subscribers = publishProducerArr;
                        }
                    }
                }
            }
        }
    }

    static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        public final void onNext(T t) {
            this.state.onNext(t);
        }

        public final void onError(Throwable th) {
            this.state.onError(th);
        }

        public final void onCompleted() {
            this.state.onCompleted();
        }

        public final void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    public final Subscriber<T> subscriber() {
        return this.parent;
    }

    public final void unsubscribe() {
        this.parent.unsubscribe();
    }

    public final boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j)));
            } else if (j != 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }

        public final boolean isUnsubscribed() {
            return this.once.get();
        }

        public final void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }
}
