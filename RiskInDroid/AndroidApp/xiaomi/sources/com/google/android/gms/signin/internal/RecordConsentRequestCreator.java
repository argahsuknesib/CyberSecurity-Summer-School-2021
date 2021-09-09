package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class RecordConsentRequestCreator implements Parcelable.Creator<RecordConsentRequest> {
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Account account = null;
        int i = 0;
        Scope[] scopeArr = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
            } else if (fieldId == 3) {
                scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new RecordConsentRequest(i, account, scopeArr, str);
    }

    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
