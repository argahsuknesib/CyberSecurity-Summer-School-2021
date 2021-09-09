package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzf implements Parcelable.Creator<Barcode.ContactInfo> {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Barcode.PersonName personName = null;
        String str = null;
        String str2 = null;
        Barcode.Phone[] phoneArr = null;
        Barcode.Email[] emailArr = null;
        String[] strArr = null;
        Barcode.Address[] addressArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    personName = SafeParcelReader.createParcelable(parcel, readHeader, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    phoneArr = SafeParcelReader.createTypedArray(parcel, readHeader, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = SafeParcelReader.createTypedArray(parcel, readHeader, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    addressArr = SafeParcelReader.createTypedArray(parcel, readHeader, Barcode.Address.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Barcode.ContactInfo(personName, str, str2, phoneArr, emailArr, strArr, addressArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }
}
