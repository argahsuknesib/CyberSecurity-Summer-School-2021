package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zzea implements Parcelable.Creator<zzdz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j5 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    j5 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 17:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    z5 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzdz(str, str2, str3, str4, j, j2, str5, z, z2, j5, str6, j3, j4, i, z3, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdz[i];
    }
}
