package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;

public final class TransientDataHolder {
    private String zzos;
    private String zzot;
    private DataHolder.Builder zzou;

    public TransientDataHolder(String[] strArr) {
        this(strArr, null, null, null);
    }

    public TransientDataHolder(String[] strArr, String str, String str2, String str3) {
        this.zzos = str2;
        this.zzot = str3;
        this.zzou = str != null ? DataHolder.builder(strArr, str) : DataHolder.builder(strArr);
    }

    public final void addRow(ContentValues contentValues) {
        this.zzou.withRow(contentValues);
    }

    @VisibleForTesting
    public final DataHolder build(int i) {
        return build(i, new Bundle(), -1);
    }

    public final DataHolder build(int i, Bundle bundle, int i2) {
        bundle.putString("next_page_token", this.zzot);
        bundle.putString("prev_page_token", this.zzos);
        return this.zzou.build(i, bundle, i2);
    }

    public final boolean containsRowWithValue(String str, Object obj) {
        return this.zzou.containsRowWithValue(str, obj);
    }

    public final int getCount() {
        return this.zzou.getCount();
    }

    public final String getNextToken() {
        return this.zzot;
    }

    public final String getPrevToken() {
        return this.zzos;
    }

    public final void modifyUniqueRowValue(Object obj, String str, Object obj2) {
        this.zzou.modifyUniqueRowValue(obj, str, obj2);
    }

    @VisibleForTesting
    public final void removeRows(String str, Object obj) {
        this.zzou.removeRowsWithValue(str, obj);
    }

    public final void setNextToken(String str) {
        this.zzot = str;
    }

    public final void setPrevToken(String str) {
        this.zzos = str;
    }

    public final void sortData(String str) {
        this.zzou.sort(str);
    }

    public final void sortDataDescending(String str) {
        this.zzou.descendingSort(str);
    }
}
