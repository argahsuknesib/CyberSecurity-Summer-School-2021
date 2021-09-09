package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzww extends zzws<Long> {
    zzww(zzxc zzxc, String str, Long l) {
        super(zzxc, str, l, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzez */
    public final Long zzey(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbnh;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length());
            sb.append("Invalid long value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
