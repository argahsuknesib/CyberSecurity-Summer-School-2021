package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public LongArray(int i) {
        this.values = new long[i];
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.values;
        if (i == jArr.length) {
            this.values = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.values;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.values[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
    }

    public final int size() {
        return this.size;
    }

    public final long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }
}
