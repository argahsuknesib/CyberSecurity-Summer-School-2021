package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zzb extends DialogRedirect {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zzsh;

    zzb(Intent intent, Activity activity, int i) {
        this.zzsh = intent;
        this.val$activity = activity;
        this.val$requestCode = i;
    }

    public final void redirect() {
        Intent intent = this.zzsh;
        if (intent != null) {
            this.val$activity.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
