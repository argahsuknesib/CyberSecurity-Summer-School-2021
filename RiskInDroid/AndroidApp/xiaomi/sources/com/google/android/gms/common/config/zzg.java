package com.google.android.gms.common.config;

import android.content.Context;

final class zzg extends GservicesValue<String> {
    zzg(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieve(String str) {
        return GservicesValue.zzmu.zzb(this.mKey, (String) this.mDefaultValue);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        return context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, (String) obj);
    }
}
