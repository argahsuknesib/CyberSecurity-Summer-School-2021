package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

public class NativePooledByteBuffer implements PooledByteBuffer {
    @VisibleForTesting
    CloseableReference<NativeMemoryChunk> mBufRef;
    private final int mSize;

    public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> closeableReference, int i) {
        Preconditions.checkNotNull(closeableReference);
        Preconditions.checkArgument(i >= 0 && i <= closeableReference.get().getSize());
        this.mBufRef = closeableReference.clone();
        this.mSize = i;
    }

    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    public synchronized byte read(int i) {
        ensureValid();
        boolean z = true;
        Preconditions.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return this.mBufRef.get().read(i);
    }

    public synchronized void read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        Preconditions.checkArgument(i + i3 <= this.mSize);
        this.mBufRef.get().read(i, bArr, i2, i3);
    }

    public synchronized long getNativePtr() {
        ensureValid();
        return this.mBufRef.get().getNativePtr();
    }

    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    public synchronized void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void ensureValid() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
