package com.xiaomi.passport.ui.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.phonenum.data.AccountCertification;

public class PhoneAccount implements Parcelable {
    public static final Parcelable.Creator<PhoneAccount> CREATOR = new Parcelable.Creator<PhoneAccount>() {
        /* class com.xiaomi.passport.ui.data.PhoneAccount.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PhoneAccount[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PhoneAccount(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final AccountCertification f6215O000000o;
    public final RegisterUserInfo O00000Oo;

    public int describeContents() {
        return 0;
    }

    public PhoneAccount(AccountCertification accountCertification, RegisterUserInfo registerUserInfo) {
        this.f6215O000000o = accountCertification;
        this.O00000Oo = registerUserInfo;
    }

    protected PhoneAccount(Parcel parcel) {
        this.f6215O000000o = parcel.readParcelable(AccountCertification.class.getClassLoader());
        this.O00000Oo = (RegisterUserInfo) parcel.readParcelable(RegisterUserInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6215O000000o, i);
        parcel.writeParcelable(this.O00000Oo, i);
    }

    public final boolean O000000o() {
        return this.O00000Oo.status == RegisterUserInfo.RegisterStatus.STATUS_NOT_REGISTERED;
    }

    public final boolean O00000Oo() {
        return !O000000o();
    }

    public final boolean O00000o0() {
        return this.O00000Oo.status == RegisterUserInfo.RegisterStatus.STATUS_REGISTERED_NOT_RECYCLED;
    }
}
