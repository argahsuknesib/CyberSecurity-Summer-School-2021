package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

public class ThreadHandoffProducer<T> implements Producer<T> {
    public final Producer<T> mInputProducer;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final Consumer<T> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final AnonymousClass1 r0 = new StatefulProducerRunnable<T>(consumer, listener, "BackgroundThreadHandoffProducer", id) {
            /* class com.facebook.imagepipeline.producers.ThreadHandoffProducer.AnonymousClass1 */

            public void disposeResult(T t) {
            }

            public T getResult() throws Exception {
                return null;
            }

            public void onSuccess(T t) {
                listener.onProducerFinishWithSuccess(id, "BackgroundThreadHandoffProducer", null);
                ThreadHandoffProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.ThreadHandoffProducer.AnonymousClass2 */

            public void onCancellationRequested() {
                r0.cancel();
                ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(r0);
            }
        });
        this.mThreadHandoffProducerQueue.addToQueueOrExecute(r0);
    }
}
