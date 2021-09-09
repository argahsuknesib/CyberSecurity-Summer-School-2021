package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzj;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zza extends zzj<zze> {
    private final zzc zzbw;

    public zza(Context context, zzc zzc) {
        super(context, "FaceNativeHandle");
        this.zzbw = zzc;
        zzh();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzg zzg;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator");
        if (instantiate == null) {
            zzg = null;
        } else {
            ? queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            zzg = queryLocalInterface instanceof zzg ? queryLocalInterface : new zzh(instantiate);
        }
        if (zzg == null) {
            return null;
        }
        return zzg.zza(ObjectWrapper.wrap(context), this.zzbw);
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzk zzk) {
        FaceParcel[] faceParcelArr;
        Landmark[] landmarkArr;
        int i = 0;
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zze) zzh()).zzc(ObjectWrapper.wrap(byteBuffer), zzk);
            Face[] faceArr = new Face[zzc.length];
            int i2 = 0;
            while (i2 < zzc.length) {
                FaceParcel faceParcel = zzc[i2];
                int i3 = faceParcel.id;
                PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
                float f = faceParcel.width;
                float f2 = faceParcel.height;
                float f3 = faceParcel.zzbx;
                float f4 = faceParcel.zzby;
                LandmarkParcel[] landmarkParcelArr = faceParcel.zzbz;
                if (landmarkParcelArr == null) {
                    faceParcelArr = zzc;
                    landmarkArr = new Landmark[i];
                } else {
                    landmarkArr = new Landmark[landmarkParcelArr.length];
                    int i4 = 0;
                    while (i4 < landmarkParcelArr.length) {
                        LandmarkParcel landmarkParcel = landmarkParcelArr[i4];
                        landmarkArr[i4] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
                        i4++;
                        zzc = zzc;
                        landmarkParcelArr = landmarkParcelArr;
                    }
                    faceParcelArr = zzc;
                }
                faceArr[i2] = new Face(i3, pointF, f, f2, f3, f4, landmarkArr, faceParcel.zzca, faceParcel.zzcb, faceParcel.zzcc);
                i2++;
                zzc = faceParcelArr;
                i = 0;
            }
            return faceArr;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public final boolean zzd(int i) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zze) zzh()).zzd(i);
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return false;
        }
    }

    public final void zze() throws RemoteException {
        ((zze) zzh()).zzf();
    }
}
