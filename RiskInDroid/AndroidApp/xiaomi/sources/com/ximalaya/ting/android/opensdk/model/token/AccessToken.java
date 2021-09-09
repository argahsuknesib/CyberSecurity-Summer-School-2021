package com.ximalaya.ting.android.opensdk.model.token;

import android.os.Parcel;
import android.os.Parcelable;

public class AccessToken implements Parcelable {
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator<AccessToken>() {
        /* class com.ximalaya.ting.android.opensdk.model.token.AccessToken.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccessToken[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AccessToken accessToken = new AccessToken();
            accessToken.O000000o(parcel);
            return accessToken;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12179O000000o;
    public long O00000Oo;
    public long O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12179O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeLong(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }

    public final void O000000o(Parcel parcel) {
        this.f12179O000000o = parcel.readString();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readLong();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
    }
}
