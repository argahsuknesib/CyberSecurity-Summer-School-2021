package com.mi.global.shop.imageselector.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        /* class com.mi.global.shop.imageselector.bean.Image.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Image[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4887O000000o;
    public String O00000Oo;
    public long O00000o0;

    public int describeContents() {
        return 0;
    }

    public Image(String str, String str2, long j) {
        this.f4887O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = j;
    }

    public boolean equals(Object obj) {
        try {
            return TextUtils.equals(this.f4887O000000o, ((Image) obj).f4887O000000o);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4887O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
    }

    protected Image(Parcel parcel) {
        this.f4887O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readLong();
    }

    public String toString() {
        return "Image{path='" + this.f4887O000000o + '\'' + ", name='" + this.O00000Oo + '\'' + ", time=" + this.O00000o0 + '}';
    }
}
