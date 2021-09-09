package com.mi.global.shop.buy.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BuyOrderItem implements Parcelable {
    public static final Parcelable.Creator<BuyOrderItem> CREATOR = new Parcelable.Creator<BuyOrderItem>() {
        /* class com.mi.global.shop.buy.model.BuyOrderItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BuyOrderItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BuyOrderItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4864O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4864O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }

    public BuyOrderItem() {
    }

    protected BuyOrderItem(Parcel parcel) {
        this.f4864O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
    }
}
