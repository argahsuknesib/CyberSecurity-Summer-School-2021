package com.facebook.imagepipeline.cache;

import _m_j.kq;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache {
    public static final Class<?> TAG = BufferedDiskCache.class;
    public final FileCache mFileCache;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    public final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    public final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.mStagingArea.containsKey(cacheKey) || this.mFileCache.hasKeySync(cacheKey);
    }

    public kq<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return kq.O000000o(Boolean.TRUE);
        }
        return containsAsync(cacheKey);
    }

    private kq<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            return kq.O000000o(new Callable<Boolean>() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass1 */

                public Boolean call() throws Exception {
                    return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return kq.O000000o(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public kq<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            return foundPinnedImage(cacheKey, encodedImage);
        }
        return getAsync(cacheKey, atomicBoolean);
    }

    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss();
        try {
            return this.mFileCache.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private kq<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            return kq.O000000o(new Callable<EncodedImage>() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass2 */

                public EncodedImage call() throws Exception {
                    CloseableReference of;
                    if (!atomicBoolean.get()) {
                        EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                        if (encodedImage != null) {
                            FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                        } else {
                            FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                            try {
                                of = CloseableReference.of(BufferedDiskCache.this.readFromDiskCache(cacheKey));
                                EncodedImage encodedImage2 = new EncodedImage(of);
                                CloseableReference.closeSafely(of);
                                encodedImage = encodedImage2;
                            } catch (Exception unused) {
                                return null;
                            } catch (Throwable th) {
                                CloseableReference.closeSafely(of);
                                throw th;
                            }
                        }
                        if (!Thread.interrupted()) {
                            return encodedImage;
                        }
                        FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                        if (encodedImage != null) {
                            encodedImage.close();
                        }
                        throw new InterruptedException();
                    }
                    throw new CancellationException();
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return kq.O000000o(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        this.mStagingArea.put(cacheKey, encodedImage);
        final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
        try {
            this.mWriteExecutor.execute(new Runnable() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass3 */

                public void run() {
                    try {
                        BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                    } finally {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                        EncodedImage.closeSafely(cloneOrNull);
                    }
                }
            });
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
            this.mStagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(cloneOrNull);
        }
    }

    public kq<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            return kq.O000000o(new Callable<Void>() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass4 */

                public Void call() throws Exception {
                    BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                    BufferedDiskCache.this.mFileCache.remove(cacheKey);
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return kq.O000000o(e);
        }
    }

    public kq<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return kq.O000000o(new Callable<Void>() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass5 */

                public Void call() throws Exception {
                    BufferedDiskCache.this.mStagingArea.clearAll();
                    BufferedDiskCache.this.mFileCache.clearAll();
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return kq.O000000o(e);
        }
    }

    private kq<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return kq.O000000o(encodedImage);
    }

    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        InputStream openStream;
        try {
            FLog.v(TAG, "Disk cache read for %s", cacheKey.getUriString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.v(TAG, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.v(TAG, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit();
            openStream = resource.openStream();
            PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
            openStream.close();
            FLog.v(TAG, "Successful read from disk cache for %s", cacheKey.getUriString());
            return newByteBuffer;
        } catch (IOException e) {
            FLog.w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        } catch (Throwable th) {
            openStream.close();
            throw th;
        }
    }

    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        FLog.v(TAG, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass6 */

                public void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            FLog.v(TAG, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e) {
            FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }
}
