package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzk extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzdg;
    protected final AtomicReference<zzl> zzer;
    private final Handler zzes;

    protected zzk(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    @VisibleForTesting
    private zzk(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zzer = new AtomicReference<>(null);
        this.zzes = new Handler(Looper.getMainLooper());
        this.zzdg = googleApiAvailability;
    }

    private static int zza(zzl zzl) {
        if (zzl == null) {
            return -1;
        }
        return zzl.zzu();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    public final void onActivityResult(int i, int i2, Intent intent) {
        zzl zzl = this.zzer.get();
        boolean z = true;
        if (i == 1) {
            if (i2 != -1) {
                if (i2 == 0) {
                    int i3 = 13;
                    if (intent != null) {
                        i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                    }
                    zzl zzl2 = new zzl(new ConnectionResult(i3, null), zza(zzl));
                    this.zzer.set(zzl2);
                    zzl = zzl2;
                }
            }
            if (z) {
            }
        } else if (i == 2) {
            int isGooglePlayServicesAvailable = this.zzdg.isGooglePlayServicesAvailable(getActivity());
            if (isGooglePlayServicesAvailable != 0) {
                z = false;
            }
            if (zzl != null) {
                if (zzl.getConnectionResult().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
                if (z) {
                    zzt();
                    return;
                } else if (zzl != null) {
                    zza(zzl.getConnectionResult(), zzl.zzu());
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza(this.zzer.get()));
        zzt();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzer.set(bundle.getBoolean("resolving_error", false) ? new zzl(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzl zzl = this.zzer.get();
        if (zzl != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzl.zzu());
            bundle.putInt("failed_status", zzl.getConnectionResult().getErrorCode());
            bundle.putParcelable("failed_resolution", zzl.getConnectionResult().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i);

    public final void zzb(ConnectionResult connectionResult, int i) {
        zzl zzl = new zzl(connectionResult, i);
        if (this.zzer.compareAndSet(null, zzl)) {
            this.zzes.post(new zzm(this, zzl));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzr();

    /* access modifiers changed from: protected */
    public final void zzt() {
        this.zzer.set(null);
        zzr();
    }
}
