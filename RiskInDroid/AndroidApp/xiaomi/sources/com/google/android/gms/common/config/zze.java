package com.google.android.gms.common.config;

import android.content.Context;

final class zze extends GservicesValue<Float> {
    zze(String str, Float f) {
        super(str, f);
    }

    private static Float zza(Context context, String str, Float f) {
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                return Float.valueOf(Float.parseFloat(string));
            } catch (NumberFormatException unused) {
            }
        }
        return f;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieve(String str) {
        return GservicesValue.zzmu.zza(this.mKey, (Float) this.mDefaultValue);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        return zza(context, str, (Float) obj);
    }
}
