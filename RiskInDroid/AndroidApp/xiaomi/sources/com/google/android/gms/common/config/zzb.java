package com.google.android.gms.common.config;

import android.content.Context;

final class zzb extends GservicesValue<Long> {
    zzb(String str, Long l) {
        super(str, l);
    }

    private static Long zza(Context context, String str, Long l) {
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                return Long.valueOf(Long.parseLong(string));
            } catch (NumberFormatException unused) {
            }
        }
        return l;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieve(String str) {
        return GservicesValue.zzmu.getLong(this.mKey, (Long) this.mDefaultValue);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        return zza(context, str, (Long) obj);
    }
}
