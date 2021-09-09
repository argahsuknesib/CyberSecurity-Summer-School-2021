package com.xiaomi.smarthome.core.entity.account;

import android.os.Parcel;
import android.os.Parcelable;

public enum AccountType implements Parcelable {
    MI,
    WX,
    OAUTH;
    
    public static final Parcelable.Creator<AccountType> CREATOR = new Parcelable.Creator<AccountType>() {
        /* class com.xiaomi.smarthome.core.entity.account.AccountType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccountType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return AccountType.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
