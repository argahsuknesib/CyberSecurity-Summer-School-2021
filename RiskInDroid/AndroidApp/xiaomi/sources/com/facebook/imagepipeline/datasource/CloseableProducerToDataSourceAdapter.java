package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        return new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener);
    }

    private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        super(producer, settableProducerContext, requestListener);
    }

    public CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* access modifiers changed from: protected */
    public void closeResult(CloseableReference<T> closeableReference) {
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.onNewResultImpl(java.lang.Object, int):void
     arg types: [com.facebook.common.references.CloseableReference<T>, int]
     candidates:
      com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.onNewResultImpl(com.facebook.common.references.CloseableReference, int):void
      com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.onNewResultImpl(java.lang.Object, int):void */
    /* access modifiers changed from: protected */
    public void onNewResultImpl(CloseableReference<T> closeableReference, int i) {
        super.onNewResultImpl((Object) CloseableReference.cloneOrNull(closeableReference), i);
    }
}
