package com.mi.global.shop.model.user;

import android.os.Parcel;
import android.os.Parcelable;

public class RegionItem implements Parcelable {
    public static final Parcelable.Creator<RegionItem> CREATOR = new Parcelable.Creator<RegionItem>() {
        /* class com.mi.global.shop.model.user.RegionItem.AnonymousClass1 */

        public final RegionItem createFromParcel(Parcel parcel) {
            return new RegionItem(parcel);
        }

        public final RegionItem[] newArray(int i) {
            return new RegionItem[i];
        }
    };
    public String can_cod;
    public String region_id;
    public String region_name;
    public String zipcode;

    public int describeContents() {
        return 0;
    }

    public RegionItem(String str, String str2, String str3, String str4) {
        this.region_id = str;
        this.region_name = str2;
        this.zipcode = str3;
        this.can_cod = str4;
    }

    public RegionItem() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.region_id);
        parcel.writeString(this.region_name);
        parcel.writeString(this.zipcode);
        parcel.writeString(this.can_cod);
    }

    protected RegionItem(Parcel parcel) {
        this.region_id = parcel.readString();
        this.region_name = parcel.readString();
        this.zipcode = parcel.readString();
        this.can_cod = parcel.readString();
    }
}
