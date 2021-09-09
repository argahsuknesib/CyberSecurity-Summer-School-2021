package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class ConverterWrapperCreator implements Parcelable.Creator<ConverterWrapper> {
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.createParcelable(parcel, readHeader, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConverterWrapper(i, stringToIntConverter);
    }

    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
