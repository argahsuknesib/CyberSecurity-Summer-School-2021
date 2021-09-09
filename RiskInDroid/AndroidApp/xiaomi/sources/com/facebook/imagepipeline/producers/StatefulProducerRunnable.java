package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    private final Consumer<T> mConsumer;
    private final ProducerListener mProducerListener;
    private final String mProducerName;
    private final String mRequestId;

    public abstract void disposeResult(Object obj);

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getExtraMapOnSuccess(Object obj) {
        return null;
    }

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2) {
        this.mConsumer = consumer;
        this.mProducerListener = producerListener;
        this.mProducerName = str;
        this.mRequestId = str2;
        this.mProducerListener.onProducerStart(this.mRequestId, this.mProducerName);
    }

    public void onSuccess(Object obj) {
        ProducerListener producerListener = this.mProducerListener;
        String str = this.mRequestId;
        producerListener.onProducerFinishWithSuccess(str, this.mProducerName, producerListener.requiresExtraMap(str) ? getExtraMapOnSuccess(obj) : null);
        this.mConsumer.onNewResult(obj, 1);
    }

    public void onFailure(Exception exc) {
        ProducerListener producerListener = this.mProducerListener;
        String str = this.mRequestId;
        producerListener.onProducerFinishWithFailure(str, this.mProducerName, exc, producerListener.requiresExtraMap(str) ? getExtraMapOnFailure(exc) : null);
        this.mConsumer.onFailure(exc);
    }

    public void onCancellation() {
        ProducerListener producerListener = this.mProducerListener;
        String str = this.mRequestId;
        producerListener.onProducerFinishWithCancellation(str, this.mProducerName, producerListener.requiresExtraMap(str) ? getExtraMapOnCancellation() : null);
        this.mConsumer.onCancellation();
    }
}
