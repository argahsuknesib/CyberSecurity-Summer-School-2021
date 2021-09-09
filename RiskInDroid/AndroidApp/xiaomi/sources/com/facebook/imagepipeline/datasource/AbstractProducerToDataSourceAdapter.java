package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    private final RequestListener mRequestListener;
    private final SettableProducerContext mSettableProducerContext;

    protected AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        this.mSettableProducerContext = settableProducerContext;
        this.mRequestListener = requestListener;
        this.mRequestListener.onRequestStart(settableProducerContext.getImageRequest(), this.mSettableProducerContext.getCallerContext(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        producer.produceResults(createConsumer(), settableProducerContext);
    }

    private Consumer<T> createConsumer() {
        return new BaseConsumer<T>() {
            /* class com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.AnonymousClass1 */

            public void onNewResultImpl(T t, int i) {
                AbstractProducerToDataSourceAdapter.this.onNewResultImpl(t, i);
            }

            public void onFailureImpl(Throwable th) {
                AbstractProducerToDataSourceAdapter.this.onFailureImpl(th);
            }

            public void onCancellationImpl() {
                AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
            }

            public void onProgressUpdateImpl(float f) {
                AbstractProducerToDataSourceAdapter.this.setProgress(f);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(Object obj, int i) {
        boolean isLast = BaseConsumer.isLast(i);
        if (super.setResult(obj, isLast) && isLast) {
            this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        }
    }

    public void onFailureImpl(Throwable th) {
        if (super.setFailure(th)) {
            this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), th, this.mSettableProducerContext.isPrefetch());
        }
    }

    public synchronized void onCancellationImpl() {
        Preconditions.checkState(isClosed());
    }

    public ImageRequest getImageRequest() {
        return this.mSettableProducerContext.getImageRequest();
    }

    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
        this.mSettableProducerContext.cancel();
        return true;
    }
}
