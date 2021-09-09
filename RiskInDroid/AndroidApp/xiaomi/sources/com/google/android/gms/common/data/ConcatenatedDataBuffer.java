package com.google.android.gms.common.data;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.data.TextFilterable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
public final class ConcatenatedDataBuffer<T> implements DataBuffer<T>, ExclusionFilterable, TextFilterable {
    private Bundle mBundle;
    private final ArrayList<DataBuffer<T>> zznf = new ArrayList<>();
    private final ArrayList<Integer> zzng = new ArrayList<>();
    private int zznh;

    public ConcatenatedDataBuffer() {
    }

    public ConcatenatedDataBuffer(DataBuffer<T> dataBuffer) {
        append(dataBuffer);
    }

    public static <T> ConcatenatedDataBuffer<T> extend(ConcatenatedDataBuffer<T> concatenatedDataBuffer, DataBuffer<T> dataBuffer) {
        ConcatenatedDataBuffer<T> concatenatedDataBuffer2 = new ConcatenatedDataBuffer<>();
        ArrayList arrayList = concatenatedDataBuffer.zznf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            concatenatedDataBuffer2.append((DataBuffer) obj);
        }
        concatenatedDataBuffer2.append(dataBuffer);
        return concatenatedDataBuffer2;
    }

    public final void append(DataBuffer<T> dataBuffer) {
        if (dataBuffer != null) {
            synchronized (this) {
                if (this.zznf.isEmpty()) {
                    this.mBundle = new Bundle();
                    Bundle metadata = dataBuffer.getMetadata();
                    if (metadata != null) {
                        this.mBundle.putString("prev_page_token", metadata.getString("prev_page_token"));
                    }
                }
                this.zznf.add(dataBuffer);
                computeCounts();
                Bundle metadata2 = dataBuffer.getMetadata();
                if (metadata2 != null) {
                    this.mBundle.putString("next_page_token", metadata2.getString("next_page_token"));
                } else {
                    this.mBundle.remove("next_page_token");
                }
            }
        }
    }

    public final void clearFilters() {
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).clearFilters();
            }
        }
        computeCounts();
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final void computeCounts() {
        this.zzng.clear();
        int size = this.zznf.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer dataBuffer = this.zznf.get(i2);
            if (dataBuffer != null) {
                i += dataBuffer.getCount();
            }
            this.zzng.add(Integer.valueOf(i));
        }
        this.zznh = i;
    }

    public final void filterOut(String str) {
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).filterOut(str);
            }
        }
        computeCounts();
    }

    public final T get(int i) {
        DataBuffer dataBuffer;
        synchronized (this) {
            int i2 = 0;
            int size = this.zznf.size();
            while (i2 < size) {
                int intValue = this.zzng.get(i2).intValue();
                if (i >= intValue || (dataBuffer = this.zznf.get(i2)) == null) {
                    i2++;
                } else {
                    T t = dataBuffer.get((i - intValue) + dataBuffer.getCount());
                    return t;
                }
            }
            return null;
        }
    }

    public final int getCount() {
        int i;
        synchronized (this) {
            i = this.zznh;
        }
        return i;
    }

    public final Bundle getMetadata() {
        Bundle bundle;
        synchronized (this) {
            bundle = this.mBundle;
        }
        return bundle;
    }

    @Deprecated
    public final boolean isClosed() {
        return false;
    }

    public final Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    public final void release() {
        synchronized (this) {
            int size = this.zznf.size();
            for (int i = 0; i < size; i++) {
                DataBuffer dataBuffer = this.zznf.get(i);
                if (dataBuffer != null) {
                    dataBuffer.release();
                }
            }
            this.zznf.clear();
            this.zzng.clear();
            this.mBundle = null;
        }
    }

    public final void setFilterTerm(Context context, TextFilterable.StringFilter stringFilter, String str) {
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = this.zznf.get(i);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, stringFilter, str);
            }
        }
        computeCounts();
    }

    public final void setFilterTerm(Context context, String str) {
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = this.zznf.get(i);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, str);
            }
        }
        computeCounts();
    }

    public final Iterator<T> singleRefIterator() {
        return iterator();
    }

    public final void unfilter(String str) {
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).unfilter(str);
            }
        }
        computeCounts();
    }
}
