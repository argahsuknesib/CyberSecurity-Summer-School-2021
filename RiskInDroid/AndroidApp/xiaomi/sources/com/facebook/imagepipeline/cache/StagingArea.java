package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StagingArea {
    private static final Class<?> TAG = StagingArea.class;
    private Map<CacheKey, EncodedImage> mMap = new HashMap();

    private StagingArea() {
    }

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage.closeSafely(this.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
        logStats();
    }

    public void clearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public boolean remove(CacheKey cacheKey) {
        EncodedImage remove;
        Preconditions.checkNotNull(cacheKey);
        synchronized (this) {
            remove = this.mMap.remove(cacheKey);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.isValid();
        } finally {
            remove.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkNotNull(encodedImage);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage encodedImage2 = this.mMap.get(cacheKey);
        if (encodedImage2 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
        CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
        if (!(byteBufferRef == null || byteBufferRef2 == null)) {
            try {
                if (byteBufferRef.get() == byteBufferRef2.get()) {
                    this.mMap.remove(cacheKey);
                    CloseableReference.closeSafely(byteBufferRef2);
                    CloseableReference.closeSafely(byteBufferRef);
                    EncodedImage.closeSafely(encodedImage2);
                    logStats();
                    return true;
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely(byteBufferRef2);
                CloseableReference.closeSafely(byteBufferRef);
                EncodedImage.closeSafely(encodedImage2);
                throw th;
            }
        }
        CloseableReference.closeSafely(byteBufferRef2);
        CloseableReference.closeSafely(byteBufferRef);
        EncodedImage.closeSafely(encodedImage2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        return r7;
     */
    public synchronized EncodedImage get(CacheKey cacheKey) {
        EncodedImage encodedImage;
        Preconditions.checkNotNull(cacheKey);
        EncodedImage encodedImage2 = this.mMap.get(cacheKey);
        if (encodedImage2 != null) {
            synchronized (encodedImage2) {
                if (!EncodedImage.isValid(encodedImage2)) {
                    this.mMap.remove(cacheKey);
                    FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage2)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImage = EncodedImage.cloneOrNull(encodedImage2);
            }
        } else {
            encodedImage = encodedImage2;
        }
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        if (!this.mMap.containsKey(cacheKey)) {
            return false;
        }
        EncodedImage encodedImage = this.mMap.get(cacheKey);
        synchronized (encodedImage) {
            if (EncodedImage.isValid(encodedImage)) {
                return true;
            }
            this.mMap.remove(cacheKey);
            FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
            return false;
        }
    }

    private synchronized void logStats() {
        FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}
