package com.xiaomi.accounts;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accounts.IAccountManagerResponse;

public class AccountManagerResponse implements Parcelable {
    public static final Parcelable.Creator<AccountManagerResponse> CREATOR = new Parcelable.Creator<AccountManagerResponse>() {
        /* class com.xiaomi.accounts.AccountManagerResponse.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccountManagerResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AccountManagerResponse(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private IAccountManagerResponse f5962O000000o;

    public int describeContents() {
        return 0;
    }

    public AccountManagerResponse(IAccountManagerResponse iAccountManagerResponse) {
        this.f5962O000000o = iAccountManagerResponse;
    }

    public AccountManagerResponse(Parcel parcel) {
        this.f5962O000000o = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f5962O000000o.asBinder());
    }
}
