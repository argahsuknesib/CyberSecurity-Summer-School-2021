package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShuffleFilteredDataBuffer<T> extends FilteredDataBuffer<T> {
    private final List<Integer> zzoh;
    private final int zzoi;

    public ShuffleFilteredDataBuffer(DataBuffer<T> dataBuffer, int i) {
        super(dataBuffer);
        this.zzoi = i;
        int i2 = this.zzoi;
        int count = this.mDataBuffer.getCount();
        if (i2 <= count) {
            ArrayList arrayList = new ArrayList(count);
            for (int i3 = 0; i3 < count; i3++) {
                arrayList.add(Integer.valueOf(i3));
            }
            Collections.shuffle(arrayList);
            this.zzoh = arrayList.subList(0, i2);
            return;
        }
        throw new IllegalArgumentException("numIndexes must be smaller or equal to max");
    }

    public final int computeRealPosition(int i) {
        if (i >= 0 && i < getCount()) {
            return this.zzoh.get(i).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    public final int getCount() {
        return Math.min(this.zzoi, this.mDataBuffer.getCount());
    }
}
