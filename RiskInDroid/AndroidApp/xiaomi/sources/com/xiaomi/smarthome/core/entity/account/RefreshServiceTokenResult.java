package com.xiaomi.smarthome.core.entity.account;

import android.os.Parcel;
import android.os.Parcelable;

public class RefreshServiceTokenResult implements Parcelable {
    public static final Parcelable.Creator<RefreshServiceTokenResult> CREATOR = new Parcelable.Creator<RefreshServiceTokenResult>() {
        /* class com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RefreshServiceTokenResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RefreshServiceTokenResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6720O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public long O00000oo;

    public int describeContents() {
        return 0;
    }

    public RefreshServiceTokenResult() {
    }

    protected RefreshServiceTokenResult(Parcel parcel) {
        this.f6720O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6720O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeLong(this.O00000oo);
    }
}
