package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class FieldCreator implements Parcelable.Creator<FastJsonResponse.Field> {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    converterWrapper = SafeParcelReader.createParcelable(parcel, readHeader, ConverterWrapper.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new FastJsonResponse.Field(i, i2, z, i3, z2, str, i4, str2, converterWrapper);
    }

    public FastJsonResponse.Field[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
