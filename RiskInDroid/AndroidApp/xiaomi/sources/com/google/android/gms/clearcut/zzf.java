package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

public final class zzf implements Parcelable.Creator<zze> {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzr zzr = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        ExperimentTokens[] experimentTokensArr = null;
        boolean z = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzr = SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
                    break;
                case 3:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 4:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 5:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 7:
                    bArr2 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    experimentTokensArr = SafeParcelReader.createTypedArray(parcel, readHeader, ExperimentTokens.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zze(zzr, bArr, iArr, strArr, iArr2, bArr2, z, experimentTokensArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
