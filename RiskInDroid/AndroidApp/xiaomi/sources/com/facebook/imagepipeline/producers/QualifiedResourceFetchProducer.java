package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class QualifiedResourceFetchProducer extends LocalFetchProducer {
    private final ContentResolver mContentResolver;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "QualifiedResourceFetchProducer";
    }

    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(this.mContentResolver.openInputStream(imageRequest.getSourceUri()), -1);
    }
}
