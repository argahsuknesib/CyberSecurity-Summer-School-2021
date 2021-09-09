package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwy extends zzws<Boolean> {
    zzwy(zzxc zzxc, String str, Boolean bool) {
        super(zzxc, str, bool, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzey(String str) {
        if (zzwn.zzbmi.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (zzwn.zzbmj.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.zzbnh;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
