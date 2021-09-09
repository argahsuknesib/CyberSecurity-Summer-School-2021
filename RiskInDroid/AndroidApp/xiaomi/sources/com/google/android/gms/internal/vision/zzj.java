package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

public abstract class zzj<T> {
    private final Context mContext;
    private final Object mLock = new Object();
    private final String mTag;
    private boolean zzci = false;
    private T zzcj;

    public zzj(Context context, String str) {
        this.mContext = context;
        this.mTag = str;
    }

    public final boolean isOperational() {
        return zzh() != null;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    /* access modifiers changed from: protected */
    public abstract void zze() throws RemoteException;

    public final void zzg() {
        synchronized (this.mLock) {
            if (this.zzcj != null) {
                try {
                    zze();
                } catch (RemoteException e) {
                    Log.e(this.mTag, "Could not finalize native handle", e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final T zzh() {
        synchronized (this.mLock) {
            if (this.zzcj != null) {
                T t = this.zzcj;
                return t;
            }
            try {
                this.zzcj = zza(DynamiteModule.load(this.mContext, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "com.google.android.gms.vision.dynamite"), this.mContext);
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e(this.mTag, "Error creating remote native handle", e);
            }
            if (!this.zzci && this.zzcj == null) {
                Log.w(this.mTag, "Native handle not yet available. Reverting to no-op handle.");
                this.zzci = true;
            } else if (this.zzci && this.zzcj != null) {
                Log.w(this.mTag, "Native handle is now available.");
            }
            T t2 = this.zzcj;
            return t2;
        }
    }
}
