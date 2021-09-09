package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;

final class zzb extends Drawable.ConstantState {
    private zzb() {
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        return CrossFadingDrawable.zza.zzqj;
    }
}
