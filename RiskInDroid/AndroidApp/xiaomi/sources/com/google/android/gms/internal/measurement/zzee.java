package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zzee implements Parcelable.Creator<zzed> {
    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzjx zzjx = null;
        String str3 = null;
        zzeu zzeu = null;
        zzeu zzeu2 = null;
        zzeu zzeu3 = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    zzjx = SafeParcelReader.createParcelable(parcel2, readHeader, zzjx.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    zzeu = SafeParcelReader.createParcelable(parcel2, readHeader, zzeu.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    zzeu2 = SafeParcelReader.createParcelable(parcel2, readHeader, zzeu.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    zzeu3 = SafeParcelReader.createParcelable(parcel2, readHeader, zzeu.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzed(str, str2, zzjx, j, z, str3, zzeu, j2, zzeu2, j3, zzeu3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzed[i];
    }
}
