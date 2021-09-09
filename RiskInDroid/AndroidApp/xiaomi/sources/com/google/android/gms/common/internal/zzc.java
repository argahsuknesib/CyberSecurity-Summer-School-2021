package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class zzc extends DialogRedirect {
    private final /* synthetic */ Fragment val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zzsh;

    zzc(Intent intent, Fragment fragment, int i) {
        this.zzsh = intent;
        this.val$fragment = fragment;
        this.val$requestCode = i;
    }

    public final void redirect() {
        Intent intent = this.zzsh;
        if (intent != null) {
            this.val$fragment.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
