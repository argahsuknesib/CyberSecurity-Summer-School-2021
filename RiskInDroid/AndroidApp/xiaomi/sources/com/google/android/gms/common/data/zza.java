package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;

final class zza extends DataHolder.Builder {
    zza(String[] strArr, String str) {
        super(strArr, null, null);
    }

    public final DataHolder.Builder withRow(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    public final DataHolder.Builder withRow(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
