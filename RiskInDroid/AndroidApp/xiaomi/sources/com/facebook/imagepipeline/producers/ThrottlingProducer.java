package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThrottlingProducer<T> implements Producer<T> {
    public final Executor mExecutor;
    private final Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    public int mNumCurrentRequests = 0;
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests = new ConcurrentLinkedQueue<>();

    public ThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.getListener().onProducerStart(producerContext.getId(), "ThrottlingProducer");
        synchronized (this) {
            z = true;
            if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(Pair.create(consumer, producerContext));
            } else {
                this.mNumCurrentRequests++;
                z = false;
            }
        }
        if (!z) {
            produceResultsInternal(consumer, producerContext);
        }
    }

    /* access modifiers changed from: package-private */
    public void produceResultsInternal(Consumer<T> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerFinishWithSuccess(producerContext.getId(), "ThrottlingProducer", null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(consumer), producerContext);
    }

    class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        private ThrottlerConsumer(Consumer<T> consumer) {
            super(consumer);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(T t, int i) {
            getConsumer().onNewResult(t, i);
            if (isLast(i)) {
                onRequestFinished();
            }
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        /* access modifiers changed from: protected */
        public void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        private void onRequestFinished() {
            final Pair poll;
            synchronized (ThrottlingProducer.this) {
                poll = ThrottlingProducer.this.mPendingRequests.poll();
                if (poll == null) {
                    ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                    throttlingProducer.mNumCurrentRequests--;
                }
            }
            if (poll != null) {
                ThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    /* class com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.AnonymousClass1 */

                    public void run() {
                        ThrottlingProducer.this.produceResultsInternal((Consumer) poll.first, (ProducerContext) poll.second);
                    }
                });
            }
        }
    }
}
