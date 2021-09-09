package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class AuthAccountRequestCreator implements Parcelable.Creator<AuthAccountRequest> {
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    scopeArr = SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
                    break;
                case 4:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 5:
                    num2 = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 6:
                    account = SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AuthAccountRequest(i, iBinder, scopeArr, num, num2, account);
    }

    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
