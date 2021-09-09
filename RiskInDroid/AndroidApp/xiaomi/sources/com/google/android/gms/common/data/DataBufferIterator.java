package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> mDataBuffer;
    protected int mPosition = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.mDataBuffer = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    public boolean hasNext() {
        return this.mPosition < this.mDataBuffer.getCount() - 1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.mDataBuffer;
            int i = this.mPosition + 1;
            this.mPosition = i;
            return dataBuffer.get(i);
        }
        int i2 = this.mPosition;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
