package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BasePool<V> implements Pool<V> {
    private final Class<?> TAG = getClass();
    private boolean mAllowNewBuckets;
    @VisibleForTesting
    final SparseArray<Bucket<V>> mBuckets;
    @VisibleForTesting
    final Counter mFree;
    @VisibleForTesting
    final Set<V> mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    @VisibleForTesting
    final Counter mUsed;

    /* access modifiers changed from: protected */
    public abstract V alloc(int i);

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public abstract void free(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getBucketedSize(int i);

    /* access modifiers changed from: protected */
    public abstract int getBucketedSizeForValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getSizeInBytes(int i);

    /* access modifiers changed from: protected */
    public void onParamsChanged() {
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        this.mPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray<>();
        initBuckets(new SparseIntArray(0));
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    /* access modifiers changed from: protected */
    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = alloc(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5.mUsed.decrement(r2);
        r4 = getBucket(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r4 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r4.decrementInUseCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        com.facebook.common.internal.Throwables.propagateIfPossible(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.facebook.common.internal.Preconditions.checkState(r5.mInUseValues.add(r0));
        trimToSoftCap();
        r5.mPoolStatsTracker.onAlloc(r2);
        logStats();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (com.facebook.common.logging.FLog.isLoggable(2) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        com.facebook.common.logging.FLog.v(r5.TAG, "get (alloc) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        return r0;
     */
    public V get(int i) {
        V v;
        ensurePoolSizeInvariant();
        int bucketedSize = getBucketedSize(i);
        synchronized (this) {
            Bucket bucket = getBucket(bucketedSize);
            if (bucket == null || (v = bucket.get()) == null) {
                int sizeInBytes = getSizeInBytes(bucketedSize);
                if (canAllocate(sizeInBytes)) {
                    this.mUsed.increment(sizeInBytes);
                    if (bucket != null) {
                        bucket.incrementInUseCount();
                    }
                } else {
                    throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, sizeInBytes);
                }
            } else {
                Preconditions.checkState(this.mInUseValues.add(v));
                int bucketedSizeForValue = getBucketedSizeForValue(v);
                int sizeInBytes2 = getSizeInBytes(bucketedSizeForValue);
                this.mUsed.increment(sizeInBytes2);
                this.mFree.decrement(sizeInBytes2);
                this.mPoolStatsTracker.onValueReuse(sizeInBytes2);
                logStats();
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
            }
        }
    }

    public void release(V v) {
        Preconditions.checkNotNull(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (!this.mInUseValues.remove(v)) {
                FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                if (bucketIfPresent != null && !bucketIfPresent.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded()) {
                    if (isReusable(v)) {
                        bucketIfPresent.release(v);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                }
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            }
            logStats();
        }
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(Object obj) {
        Preconditions.checkNotNull(obj);
        return true;
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        if (isMaxSizeSoftCapExceeded()) {
            if (this.mFree.mNumBytes != 0) {
                z = false;
                Preconditions.checkState(z);
            }
        }
        z = true;
        Preconditions.checkState(z);
    }

    private synchronized void initBuckets(SparseIntArray sparseIntArray) {
        Preconditions.checkNotNull(sparseIntArray);
        this.mBuckets.clear();
        SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i = 0; i < sparseIntArray2.size(); i++) {
                int keyAt = sparseIntArray2.keyAt(i);
                this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
            }
            this.mAllowNewBuckets = false;
            return;
        }
        this.mAllowNewBuckets = true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void trimToNothing() {
        int i;
        ArrayList arrayList = new ArrayList(this.mBuckets.size());
        SparseIntArray sparseIntArray = new SparseIntArray();
        synchronized (this) {
            for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                Bucket valueAt = this.mBuckets.valueAt(i2);
                if (valueAt.getFreeListSize() > 0) {
                    arrayList.add(valueAt);
                }
                sparseIntArray.put(this.mBuckets.keyAt(i2), valueAt.getInUseCount());
            }
            initBuckets(sparseIntArray);
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (i = 0; i < arrayList.size(); i++) {
            Bucket bucket = (Bucket) arrayList.get(i);
            while (true) {
                Object pop = bucket.pop();
                if (pop == null) {
                    break;
                }
                free(pop);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        return;
     */
    @VisibleForTesting
    public synchronized void trimToSize(int i) {
        int min = Math.min((this.mUsed.mNumBytes + this.mFree.mNumBytes) - i, this.mFree.mNumBytes);
        if (min > 0) {
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(min));
            }
            logStats();
            for (int i2 = 0; i2 < this.mBuckets.size() && min > 0; i2++) {
                Bucket valueAt = this.mBuckets.valueAt(i2);
                while (min > 0) {
                    Object pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    free(pop);
                    min -= valueAt.mItemSize;
                    this.mFree.decrement(valueAt.mItemSize);
                }
            }
            logStats();
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
            }
        }
    }

    private synchronized Bucket<V> getBucketIfPresent(int i) {
        return this.mBuckets.get(i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return r0;
     */
    @VisibleForTesting
    public synchronized Bucket<V> getBucket(int i) {
        Bucket<V> bucket = this.mBuckets.get(i);
        if (bucket == null) {
            if (this.mAllowNewBuckets) {
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(i));
                }
                Bucket<V> newBucket = newBucket(i);
                this.mBuckets.put(i, newBucket);
                return newBucket;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bucket<V> newBucket(int i) {
        return new Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized boolean canAllocate(int i) {
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    public synchronized Map<String, Integer> getStats() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (int i = 0; i < this.mBuckets.size(); i++) {
            int keyAt = this.mBuckets.keyAt(i);
            hashMap.put("buckets_used_" + getSizeInBytes(keyAt), Integer.valueOf(this.mBuckets.valueAt(i).getInUseCount()));
        }
        hashMap.put("soft_cap", Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
        hashMap.put("hard_cap", Integer.valueOf(this.mPoolParams.maxSizeHardCap));
        hashMap.put("used_count", Integer.valueOf(this.mUsed.mCount));
        hashMap.put("used_bytes", Integer.valueOf(this.mUsed.mNumBytes));
        hashMap.put("free_count", Integer.valueOf(this.mFree.mCount));
        hashMap.put("free_bytes", Integer.valueOf(this.mFree.mNumBytes));
        return hashMap;
    }

    @VisibleForTesting
    static class Counter {
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void decrement(int i) {
            int i2;
            int i3 = this.mNumBytes;
            if (i3 < i || (i2 = this.mCount) <= 0) {
                FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
                return;
            }
            this.mCount = i2 - 1;
            this.mNumBytes = i3 - i;
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
