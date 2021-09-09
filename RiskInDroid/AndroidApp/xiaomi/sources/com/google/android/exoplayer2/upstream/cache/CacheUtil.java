package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CacheUtil {
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = $$Lambda$CacheUtil$uQzD0N2Max0h6DuMDYcCbN2peIo.INSTANCE;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : generateKey(dataSpec.uri);
    }

    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static Pair<Long, Long> getCached(DataSpec dataSpec, Cache cache, CacheKeyFactory cacheKeyFactory) {
        DataSpec dataSpec2 = dataSpec;
        String buildCacheKey = buildCacheKey(dataSpec2, cacheKeyFactory);
        long j = dataSpec2.position;
        long requestLength = getRequestLength(dataSpec2, cache, buildCacheKey);
        long j2 = j;
        long j3 = requestLength;
        long j4 = 0;
        while (j3 != 0) {
            long cachedLength = cache.getCachedLength(buildCacheKey, j2, j3 != -1 ? j3 : Long.MAX_VALUE);
            if (cachedLength <= 0) {
                cachedLength = -cachedLength;
                if (cachedLength == Long.MAX_VALUE) {
                    break;
                }
            } else {
                j4 += cachedLength;
            }
            j2 += cachedLength;
            if (j3 == -1) {
                cachedLength = 0;
            }
            j3 -= cachedLength;
        }
        return Pair.create(Long.valueOf(requestLength), Long.valueOf(j4));
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheKeyFactory cacheKeyFactory, DataSource dataSource, ProgressListener progressListener, AtomicBoolean atomicBoolean) throws IOException, InterruptedException {
        cache(dataSpec, cache, cacheKeyFactory, new CacheDataSource(cache, dataSource), new byte[131072], null, 0, progressListener, atomicBoolean, false);
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheKeyFactory cacheKeyFactory, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, ProgressListener progressListener, AtomicBoolean atomicBoolean, boolean z) throws IOException, InterruptedException {
        ProgressNotifier progressNotifier;
        long j;
        long j2;
        DataSpec dataSpec2 = dataSpec;
        ProgressListener progressListener2 = progressListener;
        Assertions.checkNotNull(cacheDataSource);
        Assertions.checkNotNull(bArr);
        String buildCacheKey = buildCacheKey(dataSpec2, cacheKeyFactory);
        if (progressListener2 != null) {
            progressNotifier = new ProgressNotifier(progressListener2);
            Pair<Long, Long> cached = getCached(dataSpec, cache, cacheKeyFactory);
            progressNotifier.init(((Long) cached.first).longValue(), ((Long) cached.second).longValue());
            j = ((Long) cached.first).longValue();
        } else {
            j = getRequestLength(dataSpec2, cache, buildCacheKey);
            progressNotifier = null;
        }
        ProgressNotifier progressNotifier2 = progressNotifier;
        long j3 = dataSpec2.position;
        boolean z2 = j == -1;
        long j4 = j;
        long j5 = j3;
        while (j4 != 0) {
            throwExceptionIfInterruptedOrCancelled(atomicBoolean);
            long cachedLength = cache.getCachedLength(buildCacheKey, j5, z2 ? Long.MAX_VALUE : j4);
            if (cachedLength <= 0) {
                long j6 = -cachedLength;
                long j7 = j6 == Long.MAX_VALUE ? -1 : j6;
                j2 = j6;
                if (readAndDiscard(dataSpec, j5, j7, cacheDataSource, bArr, priorityTaskManager, i, progressNotifier2, j7 == j4, atomicBoolean) < j2) {
                    if (z && !z2) {
                        throw new EOFException();
                    }
                    return;
                }
            } else {
                j2 = cachedLength;
            }
            j5 += j2;
            if (!z2) {
                j4 -= j2;
            }
        }
    }

    private static long getRequestLength(DataSpec dataSpec, Cache cache, String str) {
        if (dataSpec.length != -1) {
            return dataSpec.length;
        }
        long contentLength = ContentMetadata.CC.getContentLength(cache.getContentMetadata(str));
        if (contentLength == -1) {
            return -1;
        }
        return contentLength - dataSpec.position;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r14 = r7;
        r0 = false;
     */
    private static long readAndDiscard(DataSpec dataSpec, long j, long j2, DataSource dataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, ProgressNotifier progressNotifier, boolean z, AtomicBoolean atomicBoolean) throws IOException, InterruptedException {
        long j3;
        boolean z2;
        DataSpec dataSpec2 = dataSpec;
        DataSource dataSource2 = dataSource;
        byte[] bArr2 = bArr;
        ProgressNotifier progressNotifier2 = progressNotifier;
        long j4 = j - dataSpec2.position;
        long j5 = -1;
        long j6 = j2 != -1 ? j4 + j2 : -1;
        long j7 = j4;
        while (true) {
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(i);
            }
            throwExceptionIfInterruptedOrCancelled(atomicBoolean);
            if (j6 == j5) {
                break;
            }
            try {
                j3 = dataSource2.open(dataSpec2.subrange(j7, j6 - j7));
                z2 = true;
                break;
            } catch (IOException e) {
                if (!z) {
                    break;
                } else if (isCausedByPositionOutOfRange(e)) {
                    Util.closeQuietly(dataSource);
                }
                throw e;
            } catch (PriorityTaskManager.PriorityTooLowException unused) {
                Util.closeQuietly(dataSource);
                j5 = -1;
            } catch (Throwable th) {
                Util.closeQuietly(dataSource);
                throw th;
            }
        }
        if (!z2) {
            j3 = dataSource2.open(dataSpec2.subrange(j7, j5));
        }
        if (!(!z || progressNotifier2 == null || j3 == j5)) {
            progressNotifier2.onRequestLengthResolved(j3 + j7);
        }
        while (true) {
            if (j7 == j6) {
                break;
            }
            throwExceptionIfInterruptedOrCancelled(atomicBoolean);
            int read = dataSource2.read(bArr2, 0, j6 != j5 ? (int) Math.min((long) bArr2.length, j6 - j7) : bArr2.length);
            if (read != -1) {
                long j8 = (long) read;
                j7 += j8;
                if (progressNotifier2 != null) {
                    progressNotifier2.onBytesCached(j8);
                }
                j5 = -1;
            } else if (progressNotifier2 != null) {
                progressNotifier2.onRequestLengthResolved(j7);
            }
        }
        long j9 = j7 - j4;
        Util.closeQuietly(dataSource);
        return j9;
    }

    public static void remove(DataSpec dataSpec, Cache cache, CacheKeyFactory cacheKeyFactory) {
        remove(cache, buildCacheKey(dataSpec, cacheKeyFactory));
    }

    public static void remove(Cache cache, String str) {
        for (CacheSpan removeSpan : cache.getCachedSpans(str)) {
            try {
                cache.removeSpan(removeSpan);
            } catch (Cache.CacheException unused) {
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 0) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    private static String buildCacheKey(DataSpec dataSpec, CacheKeyFactory cacheKeyFactory) {
        if (cacheKeyFactory == null) {
            cacheKeyFactory = DEFAULT_CACHE_KEY_FACTORY;
        }
        return cacheKeyFactory.buildCacheKey(dataSpec);
    }

    private static void throwExceptionIfInterruptedOrCancelled(AtomicBoolean atomicBoolean) throws InterruptedException {
        if (Thread.interrupted() || (atomicBoolean != null && atomicBoolean.get())) {
            throw new InterruptedException();
        }
    }

    private CacheUtil() {
    }

    static final class ProgressNotifier {
        private long bytesCached;
        private final ProgressListener listener;
        private long requestLength;

        public ProgressNotifier(ProgressListener progressListener) {
            this.listener = progressListener;
        }

        public final void init(long j, long j2) {
            this.requestLength = j;
            this.bytesCached = j2;
            this.listener.onProgress(j, j2, 0);
        }

        public final void onRequestLengthResolved(long j) {
            if (this.requestLength == -1 && j != -1) {
                this.requestLength = j;
                this.listener.onProgress(j, this.bytesCached, 0);
            }
        }

        public final void onBytesCached(long j) {
            this.bytesCached += j;
            this.listener.onProgress(this.requestLength, this.bytesCached, j);
        }
    }
}
