package com.mi.global.shop.buy.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderItem implements Parcelable {
    public static final Parcelable.Creator<OrderItem> CREATOR = new Parcelable.Creator<OrderItem>() {
        /* class com.mi.global.shop.buy.model.OrderItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OrderItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OrderItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4865O000000o;
    public String O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4865O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }

    public OrderItem() {
    }

    protected OrderItem(Parcel parcel) {
        this.f4865O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }
}
