package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;

@VisibleForTesting
class Bucket<V> {
    final Queue mFreeList;
    private int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3) {
        boolean z = true;
        Preconditions.checkState(i > 0);
        Preconditions.checkState(i2 >= 0);
        Preconditions.checkState(i3 < 0 ? false : z);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
    }

    public boolean isMaxLengthExceeded() {
        return this.mInUseLength + getFreeListSize() > this.mMaxLength;
    }

    /* access modifiers changed from: package-private */
    public int getFreeListSize() {
        return this.mFreeList.size();
    }

    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mInUseLength++;
        }
        return pop;
    }

    public V pop() {
        return this.mFreeList.poll();
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public void release(V v) {
        Preconditions.checkNotNull(v);
        int i = this.mInUseLength;
        if (i > 0) {
            this.mInUseLength = i - 1;
            addToFreeList(v);
            return;
        }
        FLog.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
    }

    /* access modifiers changed from: package-private */
    public void addToFreeList(V v) {
        this.mFreeList.add(v);
    }

    public void decrementInUseCount() {
        Preconditions.checkState(this.mInUseLength > 0);
        this.mInUseLength--;
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }
}
