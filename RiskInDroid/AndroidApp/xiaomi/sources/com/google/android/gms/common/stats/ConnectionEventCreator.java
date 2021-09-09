package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ConnectionEventCreator implements Parcelable.Creator<ConnectionEvent> {
    public ConnectionEvent createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                case 9:
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
