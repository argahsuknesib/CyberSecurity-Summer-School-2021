package com.xiaomi.accounts;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accounts.IAccountAuthenticatorResponse;

public class AccountAuthenticatorResponse implements Parcelable {
    public static final Parcelable.Creator<AccountAuthenticatorResponse> CREATOR = new Parcelable.Creator<AccountAuthenticatorResponse>() {
        /* class com.xiaomi.accounts.AccountAuthenticatorResponse.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccountAuthenticatorResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AccountAuthenticatorResponse(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public IAccountAuthenticatorResponse f5955O000000o;

    public int describeContents() {
        return 0;
    }

    public AccountAuthenticatorResponse(IAccountAuthenticatorResponse iAccountAuthenticatorResponse) {
        this.f5955O000000o = iAccountAuthenticatorResponse;
    }

    public AccountAuthenticatorResponse(Parcel parcel) {
        this.f5955O000000o = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f5955O000000o.asBinder());
    }
}
