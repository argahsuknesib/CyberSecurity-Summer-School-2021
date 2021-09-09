package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i) {
        return new zzb(intent, activity, i);
    }

    public static DialogRedirect getInstance(Fragment fragment, Intent intent, int i) {
        return new zzc(intent, fragment, i);
    }

    public static DialogRedirect getInstance(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zzd(intent, lifecycleFragment, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            redirect();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void redirect();
}
