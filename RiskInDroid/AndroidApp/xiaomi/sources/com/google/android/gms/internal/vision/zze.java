package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zze extends zzj<zzf> {
    private final zzc zzbb;

    public zze(Context context, zzc zzc) {
        super(context, "BarcodeNativeHandle");
        this.zzbb = zzc;
        zzh();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzh zzh;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (instantiate == null) {
            zzh = null;
        } else {
            ? queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            zzh = queryLocalInterface instanceof zzh ? queryLocalInterface : new zzi(instantiate);
        }
        if (zzh == null) {
            return null;
        }
        return zzh.zza(ObjectWrapper.wrap(context), this.zzbb);
    }

    public final Barcode[] zza(Bitmap bitmap, zzk zzk) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzf) zzh()).zzb(ObjectWrapper.wrap(bitmap), zzk);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzk zzk) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzf) zzh()).zza(ObjectWrapper.wrap(byteBuffer), zzk);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zze() throws RemoteException {
        if (isOperational()) {
            ((zzf) zzh()).zzf();
        }
    }
}
