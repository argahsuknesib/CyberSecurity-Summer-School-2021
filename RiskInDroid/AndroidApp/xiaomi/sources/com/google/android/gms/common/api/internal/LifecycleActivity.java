package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
    private final Object zzkz;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zzkz = activity;
    }

    public final boolean zzbv() {
        return this.zzkz instanceof FragmentActivity;
    }

    public final boolean zzbw() {
        return this.zzkz instanceof Activity;
    }

    public final Activity zzbx() {
        return (Activity) this.zzkz;
    }

    public final FragmentActivity zzby() {
        return (FragmentActivity) this.zzkz;
    }
}
