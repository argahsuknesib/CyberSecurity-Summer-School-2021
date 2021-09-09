package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class DiskStorageCache implements FileCache, DiskTrimmable {
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    private static final Class<?> TAG = DiskStorageCache.class;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLastUpdateTime;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final CacheStats mCacheStats;
    private final Clock mClock;
    public final CountDownLatch mCountDownLatch;
    private final long mDefaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    public boolean mIndexReady;
    public final Object mLock = new Object();
    private final long mLowDiskSpaceCacheSizeLimit;
    @VisibleForTesting
    final Set<String> mResourceIndex;
    private final StatFsHelper mStatFsHelper;
    private final DiskStorage mStorage;

    @VisibleForTesting
    static class CacheStats {
        private long mCount = -1;
        private boolean mInitialized = false;
        private long mSize = -1;

        CacheStats() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = -1;
            this.mSize = -1;
        }

        public synchronized void set(long j, long j2) {
            this.mCount = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.mCount;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Context context, Executor executor, boolean z) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        this.mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheSizeLastUpdateTime = -1;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mCacheStats = new CacheStats();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        this.mClock = SystemClock.get();
        this.mIndexPopulateAtStartupEnabled = z;
        this.mResourceIndex = new HashSet();
        if (this.mIndexPopulateAtStartupEnabled) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() {
                /* class com.facebook.cache.disk.DiskStorageCache.AnonymousClass1 */

                public void run() {
                    synchronized (DiskStorageCache.this.mLock) {
                        DiskStorageCache.this.maybeUpdateFileCacheSize();
                    }
                    DiskStorageCache diskStorageCache = DiskStorageCache.this;
                    diskStorageCache.mIndexReady = true;
                    diskStorageCache.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return this.mStorage.getDumpInfo();
    }

    public boolean isEnabled() {
        return this.mStorage.isEnabled();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public void awaitIndex() {
        try {
            this.mCountDownLatch.await();
        } catch (InterruptedException unused) {
            FLog.e(TAG, "Memory Index is not ready yet. ");
        }
    }

    public boolean isIndexReady() {
        return this.mIndexReady || !this.mIndexPopulateAtStartupEnabled;
    }

    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        try {
            synchronized (this.mLock) {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                String str = null;
                binaryResource = null;
                for (int i = 0; i < resourceIds.size(); i++) {
                    str = resourceIds.get(i);
                    cacheKey2.setResourceId(str);
                    binaryResource = this.mStorage.getResource(str, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                }
                if (binaryResource == null) {
                    this.mCacheEventListener.onMiss(cacheKey2);
                    this.mResourceIndex.remove(str);
                } else {
                    this.mCacheEventListener.onHit(cacheKey2);
                    this.mResourceIndex.add(str);
                }
            }
            cacheKey2.recycle();
            return binaryResource;
        } catch (IOException e) {
            try {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
                cacheKey2.setException(e);
                this.mCacheEventListener.onReadException(cacheKey2);
                return null;
            } finally {
                cacheKey2.recycle();
            }
        }
    }

    public boolean probe(CacheKey cacheKey) {
        String str;
        String str2 = null;
        try {
            synchronized (this.mLock) {
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    String str3 = null;
                    int i = 0;
                    while (i < resourceIds.size()) {
                        try {
                            String str4 = resourceIds.get(i);
                            try {
                                if (this.mStorage.touch(str4, cacheKey)) {
                                    this.mResourceIndex.add(str4);
                                    return true;
                                }
                                i++;
                                str3 = str4;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    throw th;
                                } catch (IOException e) {
                                    e = e;
                                    str2 = str;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = str3;
                            throw th;
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    str = null;
                    th = th3;
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            SettableCacheEvent exception = SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str2).setException(e);
            this.mCacheEventListener.onReadException(exception);
            exception.recycle();
            return false;
        }
    }

    private DiskStorage.Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        maybeEvictFilesInCacheDir();
        return this.mStorage.insert(str, cacheKey);
    }

    private BinaryResource endInsert(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource commit;
        synchronized (this.mLock) {
            commit = inserter.commit(cacheKey);
            this.mResourceIndex.add(str);
            this.mCacheStats.increment(commit.size(), 1);
        }
        return commit;
    }

    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String firstResourceId;
        DiskStorage.Inserter startInsert;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        this.mCacheEventListener.onWriteAttempt(cacheKey2);
        synchronized (this.mLock) {
            firstResourceId = CacheKeyUtil.getFirstResourceId(cacheKey);
        }
        cacheKey2.setResourceId(firstResourceId);
        try {
            startInsert = startInsert(firstResourceId, cacheKey);
            startInsert.writeData(writerCallback, cacheKey);
            BinaryResource endInsert = endInsert(startInsert, cacheKey, firstResourceId);
            cacheKey2.setItemSize(endInsert.size()).setCacheSize(this.mCacheStats.getSize());
            this.mCacheEventListener.onWriteSuccess(cacheKey2);
            if (!startInsert.cleanUp()) {
                FLog.e(TAG, "Failed to delete temp file");
            }
            cacheKey2.recycle();
            return endInsert;
        } catch (IOException e) {
            try {
                cacheKey2.setException(e);
                this.mCacheEventListener.onWriteException(cacheKey2);
                FLog.e(TAG, "Failed inserting a file into the cache", e);
                throw e;
            } catch (Throwable th) {
                cacheKey2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            if (!startInsert.cleanUp()) {
                FLog.e(TAG, "Failed to delete temp file");
            }
            throw th2;
        }
    }

    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                Class<?> cls = TAG;
                cacheErrorLogger.logError(cacheErrorCategory, cls, "delete: " + e.getMessage(), e);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public long clearOldEntries(long j) {
        long j2;
        synchronized (this.mLock) {
            try {
                long now = this.mClock.now();
                Collection<DiskStorage.Entry> entries = this.mStorage.getEntries();
                long size = this.mCacheStats.getSize();
                int i = 0;
                long j3 = 0;
                j2 = 0;
                for (DiskStorage.Entry next : entries) {
                    try {
                        long j4 = now;
                        long max = Math.max(1L, Math.abs(now - next.getTimestamp()));
                        if (max >= j) {
                            long remove = this.mStorage.remove(next);
                            this.mResourceIndex.remove(next.getId());
                            if (remove > 0) {
                                i++;
                                j3 += remove;
                                SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(next.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(remove).setCacheSize(size - j3);
                                this.mCacheEventListener.onEviction(cacheSize);
                                cacheSize.recycle();
                            }
                        } else {
                            j2 = Math.max(j2, max);
                        }
                        now = j4;
                    } catch (IOException e) {
                        e = e;
                        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                        return j2;
                    }
                }
                this.mStorage.purgeUnexpectedResources();
                if (i > 0) {
                    maybeUpdateFileCacheSize();
                    this.mCacheStats.increment(-j3, (long) (-i));
                }
            } catch (IOException e2) {
                e = e2;
                j2 = 0;
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                return j2;
            }
        }
        return j2;
    }

    private void maybeEvictFilesInCacheDir() throws IOException {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            if (size > this.mCacheSizeLimit) {
                evictAboveSize((this.mCacheSizeLimit * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    private void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2 = j;
        try {
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize();
            long j3 = size - j2;
            int i = 0;
            long j4 = 0;
            for (DiskStorage.Entry next : sortedEntries) {
                if (j4 > j3) {
                    break;
                }
                long remove = this.mStorage.remove(next);
                this.mResourceIndex.remove(next.getId());
                if (remove > 0) {
                    i++;
                    j4 += remove;
                    SettableCacheEvent cacheLimit = SettableCacheEvent.obtain().setResourceId(next.getId()).setEvictionReason(evictionReason).setItemSize(remove).setCacheSize(size - j4).setCacheLimit(j2);
                    this.mCacheEventListener.onEviction(cacheLimit);
                    cacheLimit.recycle();
                }
            }
            this.mCacheStats.increment(-j4, (long) (-i));
            this.mStorage.purgeUnexpectedResources();
        } catch (IOException e) {
            CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
            Class<?> cls = TAG;
            cacheErrorLogger.logError(cacheErrorCategory, cls, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        long now = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry next : collection) {
            if (next.getTimestamp() > now) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void updateFileCacheSizeLimit() {
        if (this.mStatFsHelper.testLowDiskSpace(this.mStorage.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }

    public long getSize() {
        return this.mCacheStats.getSize();
    }

    public long getCount() {
        return this.mCacheStats.getCount();
    }

    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorage.clearAll();
                this.mResourceIndex.clear();
                this.mCacheEventListener.onCleared();
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                Class<?> cls = TAG;
                cacheErrorLogger.logError(cacheErrorCategory, cls, "clearAll: " + e.getMessage(), e);
            }
            this.mCacheStats.reset();
        }
    }

    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.mLock) {
            List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return;
     */
    public void trimToMinimum() {
        synchronized (this.mLock) {
            maybeUpdateFileCacheSize();
            long size = this.mCacheStats.getSize();
            if (this.mCacheSizeLimitMinimum > 0 && size > 0) {
                if (size >= this.mCacheSizeLimitMinimum) {
                    double d = (double) this.mCacheSizeLimitMinimum;
                    double d2 = (double) size;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    double d3 = 1.0d - (d / d2);
                    if (d3 > 0.02d) {
                        trimBy(d3);
                    }
                }
            }
        }
    }

    public void trimToNothing() {
        clearAll();
    }

    private void trimBy(double d) {
        synchronized (this.mLock) {
            try {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                double d2 = (double) size;
                Double.isNaN(d2);
                evictAboveSize(size - ((long) (d * d2)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                Class<?> cls = TAG;
                cacheErrorLogger.logError(cacheErrorCategory, cls, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    public boolean maybeUpdateFileCacheSize() {
        long now = this.mClock.now();
        if (this.mCacheStats.isInitialized()) {
            long j = this.mCacheSizeLastUpdateTime;
            if (j != -1 && now - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                return false;
            }
        }
        return maybeUpdateFileCacheSizeAndIndex();
    }

    private boolean maybeUpdateFileCacheSizeAndIndex() {
        Set<String> set;
        long now = this.mClock.now();
        long j = FUTURE_TIMESTAMP_THRESHOLD_MS + now;
        if (!this.mIndexPopulateAtStartupEnabled || !this.mResourceIndex.isEmpty()) {
            set = this.mIndexPopulateAtStartupEnabled ? new HashSet<>() : null;
        } else {
            set = this.mResourceIndex;
        }
        try {
            long j2 = -1;
            int i = 0;
            int i2 = 0;
            long j3 = 0;
            boolean z = false;
            int i3 = 0;
            for (DiskStorage.Entry next : this.mStorage.getEntries()) {
                i3++;
                j3 += next.getSize();
                if (next.getTimestamp() > j) {
                    i++;
                    i2 = (int) (((long) i2) + next.getSize());
                    j2 = Math.max(next.getTimestamp() - now, j2);
                    z = true;
                } else if (this.mIndexPopulateAtStartupEnabled) {
                    set.add(next.getId());
                }
            }
            if (z) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            long j4 = (long) i3;
            if (!(this.mCacheStats.getCount() == j4 && this.mCacheStats.getSize() == j3)) {
                if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != set) {
                    this.mResourceIndex.clear();
                    this.mResourceIndex.addAll(set);
                }
                this.mCacheStats.set(j3, j4);
            }
            this.mCacheSizeLastUpdateTime = now;
            return true;
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}
