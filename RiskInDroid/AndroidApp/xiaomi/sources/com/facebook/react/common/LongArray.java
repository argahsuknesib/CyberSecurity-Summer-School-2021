package com.facebook.react.common;

public class LongArray {
    private long[] mArray;
    private int mLength = 0;

    public static LongArray createWithInitialCapacity(int i) {
        return new LongArray(i);
    }

    private LongArray(int i) {
        this.mArray = new long[i];
    }

    public void add(long j) {
        growArrayIfNeeded();
        long[] jArr = this.mArray;
        int i = this.mLength;
        this.mLength = i + 1;
        jArr[i] = j;
    }

    public long get(int i) {
        if (i < this.mLength) {
            return this.mArray[i];
        }
        throw new IndexOutOfBoundsException(i + " >= " + this.mLength);
    }

    public void set(int i, long j) {
        if (i < this.mLength) {
            this.mArray[i] = j;
            return;
        }
        throw new IndexOutOfBoundsException(i + " >= " + this.mLength);
    }

    public int size() {
        return this.mLength;
    }

    public boolean isEmpty() {
        return this.mLength == 0;
    }

    public void dropTail(int i) {
        int i2 = this.mLength;
        if (i <= i2) {
            this.mLength = i2 - i;
            return;
        }
        throw new IndexOutOfBoundsException("Trying to drop " + i + " items from array of length " + this.mLength);
    }

    private void growArrayIfNeeded() {
        int i = this.mLength;
        if (i == this.mArray.length) {
            double d = (double) i;
            Double.isNaN(d);
            long[] jArr = new long[Math.max(i + 1, (int) (d * 1.8d))];
            System.arraycopy(this.mArray, 0, jArr, 0, this.mLength);
            this.mArray = jArr;
        }
    }
}
