package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwz extends zzws<Double> {
    zzwz(zzxc zzxc, String str, Double d) {
        super(zzxc, str, d, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfb */
    public final Double zzey(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbnh;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid double value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
