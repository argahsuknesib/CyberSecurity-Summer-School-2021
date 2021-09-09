package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zzu implements Parcelable.Creator<zzt> {
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzac[] zzacArr = null;
        zzn zzn = null;
        zzn zzn2 = null;
        zzn zzn3 = null;
        String str = null;
        String str2 = null;
        float f = 0.0f;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzacArr = SafeParcelReader.createTypedArray(parcel2, readHeader, zzac.CREATOR);
                    break;
                case 3:
                    zzn = SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 4:
                    zzn2 = SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 5:
                    zzn3 = SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    f = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzt(zzacArr, zzn, zzn2, zzn3, str, f, str2, i, z, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
