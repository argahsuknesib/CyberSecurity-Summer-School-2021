package com.xiaomi.smarthome.core.entity.account;

import android.os.Parcel;
import android.os.Parcelable;

public class WXAccount implements Parcelable {
    public static final Parcelable.Creator<WXAccount> CREATOR = new Parcelable.Creator<WXAccount>() {
        /* class com.xiaomi.smarthome.core.entity.account.WXAccount.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WXAccount[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WXAccount(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f6721O000000o;
    private String O00000Oo;
    private String O00000o0;

    public int describeContents() {
        return 0;
    }

    public WXAccount() {
    }

    protected WXAccount(Parcel parcel) {
        this.f6721O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6721O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }
}
