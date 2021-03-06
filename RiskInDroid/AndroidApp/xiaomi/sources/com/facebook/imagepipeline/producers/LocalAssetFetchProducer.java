package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer extends LocalFetchProducer {
    private final AssetManager mAssetManager;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "LocalAssetFetchProducer";
    }

    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        this.mAssetManager = assetManager;
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(this.mAssetManager.open(getAssetName(imageRequest), 2), getLength(imageRequest));
    }

    private int getLength(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openFd = this.mAssetManager.openFd(getAssetName(imageRequest));
            int length = (int) openFd.getLength();
            if (openFd != null) {
                try {
                    openFd.close();
                } catch (IOException unused) {
                }
            }
            return length;
        } catch (IOException unused2) {
            if (assetFileDescriptor == null) {
                return -1;
            }
            try {
                assetFileDescriptor.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private static String getAssetName(ImageRequest imageRequest) {
        return imageRequest.getSourceUri().getPath().substring(1);
    }
}
