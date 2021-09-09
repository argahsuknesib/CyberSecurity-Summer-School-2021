package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzad implements Parcelable.Creator<zzac> {
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzx[] zzxArr = null;
        zzn zzn = null;
        zzn zzn2 = null;
        String str = null;
        String str2 = null;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzxArr = SafeParcelReader.createTypedArray(parcel, readHeader, zzx.CREATOR);
                    break;
                case 3:
                    zzn = SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
                    break;
                case 4:
                    zzn2 = SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzac(zzxArr, zzn, zzn2, str, f, str2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzac[i];
    }
}
