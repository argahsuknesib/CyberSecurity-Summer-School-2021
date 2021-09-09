package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzz extends zzj<zzp> {
    private final zzaa zzdb;

    public zzz(Context context, zzaa zzaa) {
        super(context, "TextNativeHandle");
        this.zzdb = zzaa;
        zzh();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzr zzr;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        if (instantiate == null) {
            zzr = null;
        } else {
            ? queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            zzr = queryLocalInterface instanceof zzr ? queryLocalInterface : new zzs(instantiate);
        }
        if (zzr == null) {
            return null;
        }
        return zzr.zza(ObjectWrapper.wrap(context), this.zzdb);
    }

    public final zzt[] zza(Bitmap bitmap, zzk zzk, zzv zzv) {
        if (!isOperational()) {
            return new zzt[0];
        }
        try {
            return ((zzp) zzh()).zza(ObjectWrapper.wrap(bitmap), zzk, zzv);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzt[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zze() throws RemoteException {
        ((zzp) zzh()).zzi();
    }
}
