package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class ConnectionInfoCreator implements Parcelable.Creator<ConnectionInfo> {
    public ConnectionInfo createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionInfo(bundle, featureArr);
    }

    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
