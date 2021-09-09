package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class zzez extends zzo implements zzey {
    public zzez() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Object obj;
        switch (i) {
            case 1:
                zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzjx) zzp.zza(parcel, zzjx.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            default:
                return false;
            case 4:
                zza((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                obj = zza((zzdz) zzp.zza(parcel, zzdz.CREATOR), zzp.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 9:
                byte[] zza = zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                zza((zzed) zzp.zza(parcel, zzed.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzb((zzed) zzp.zza(parcel, zzed.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                obj = zza(parcel.readString(), parcel.readString(), zzp.zza(parcel), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                obj = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzp.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 16:
                obj = zza(parcel.readString(), parcel.readString(), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 17:
                obj = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 18:
                zzd((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
