package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwx extends zzws<Integer> {
    zzwx(zzxc zzxc, String str, Integer num) {
        super(zzxc, str, num, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfa */
    public final Integer zzey(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbnh;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
            sb.append("Invalid integer value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
