package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class SafeParcelResponseCreator implements Parcelable.Creator<SafeParcelResponse> {
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Parcel parcel2 = null;
        int i = 0;
        FieldMappingDictionary fieldMappingDictionary = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                parcel2 = SafeParcelReader.createParcel(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                fieldMappingDictionary = (FieldMappingDictionary) SafeParcelReader.createParcelable(parcel, readHeader, FieldMappingDictionary.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
    }

    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
