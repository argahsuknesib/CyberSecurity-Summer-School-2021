package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class TimedValueQueue<V> {
    private int first;
    private int size;
    private long[] timestamps;
    private V[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int i) {
        this.timestamps = new long[i];
        this.values = newArray(i);
    }

    public final synchronized void add(long j, V v) {
        clearBufferOnTimeDiscontinuity(j);
        doubleCapacityIfFull();
        addUnchecked(j, v);
    }

    public final synchronized void clear() {
        this.first = 0;
        this.size = 0;
        Arrays.fill(this.values, (Object) null);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized V pollFloor(long j) {
        return poll(j, true);
    }

    public final synchronized V poll(long j) {
        return poll(j, false);
    }

    private V poll(long j, boolean z) {
        long j2 = Long.MAX_VALUE;
        V v = null;
        while (this.size > 0) {
            long j3 = j - this.timestamps[this.first];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            V[] vArr = this.values;
            int i = this.first;
            v = vArr[i];
            vArr[i] = null;
            this.first = (i + 1) % vArr.length;
            this.size--;
            j2 = j3;
        }
        return v;
    }

    private void clearBufferOnTimeDiscontinuity(long j) {
        int i = this.size;
        if (i > 0) {
            if (j <= this.timestamps[((this.first + i) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size >= length) {
            int i = length * 2;
            long[] jArr = new long[i];
            V[] newArray = newArray(i);
            int i2 = this.first;
            int i3 = length - i2;
            System.arraycopy(this.timestamps, i2, jArr, 0, i3);
            System.arraycopy(this.values, this.first, newArray, 0, i3);
            int i4 = this.first;
            if (i4 > 0) {
                System.arraycopy(this.timestamps, 0, jArr, i3, i4);
                System.arraycopy(this.values, 0, newArray, i3, this.first);
            }
            this.timestamps = jArr;
            this.values = newArray;
            this.first = 0;
        }
    }

    private void addUnchecked(long j, V v) {
        int i = this.first;
        int i2 = this.size;
        V[] vArr = this.values;
        int length = (i + i2) % vArr.length;
        this.timestamps[length] = j;
        vArr[length] = v;
        this.size = i2 + 1;
    }

    private static <V> V[] newArray(int i) {
        return (Object[]) new Object[i];
    }
}
