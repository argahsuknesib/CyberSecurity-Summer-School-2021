package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zznj;

    public DataBufferRef(DataHolder dataHolder, int i) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        setDataRow(i);
    }

    /* access modifiers changed from: protected */
    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.zznj, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            return Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zznj), Integer.valueOf(this.zznj)) && dataBufferRef.mDataHolder == this.mDataHolder;
        }
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.mDataHolder.getBoolean(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public int getDataRow() {
        return this.mDataRow;
    }

    /* access modifiers changed from: protected */
    public double getDouble(String str) {
        return this.mDataHolder.getDouble(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.mDataHolder.getFloat(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.mDataHolder.getLong(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.zznj);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    /* access modifiers changed from: protected */
    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.zznj);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zznj), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    /* access modifiers changed from: protected */
    public Uri parseUri(String str) {
        return this.mDataHolder.parseUri(str, this.mDataRow, this.zznj);
    }

    /* access modifiers changed from: protected */
    public void setDataRow(int i) {
        Preconditions.checkState(i >= 0 && i < this.mDataHolder.getCount());
        this.mDataRow = i;
        this.zznj = this.mDataHolder.getWindowIndex(this.mDataRow);
    }
}
