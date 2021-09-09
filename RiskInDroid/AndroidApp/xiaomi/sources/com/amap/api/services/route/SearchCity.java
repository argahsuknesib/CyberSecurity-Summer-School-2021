package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() {
        /* class com.amap.api.services.route.SearchCity.AnonymousClass1 */

        /* renamed from: a */
        public final SearchCity[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final SearchCity createFromParcel(Parcel parcel) {
            return new SearchCity(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3519a;
    private String b;
    private String c;

    public int describeContents() {
        return 0;
    }

    public String getSearchCityName() {
        return this.f3519a;
    }

    public void setSearchCityName(String str) {
        this.f3519a = str;
    }

    public String getSearchCitycode() {
        return this.b;
    }

    public void setSearchCitycode(String str) {
        this.b = str;
    }

    public String getSearchCityAdCode() {
        return this.c;
    }

    public void setSearchCityhAdCode(String str) {
        this.c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3519a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public SearchCity(Parcel parcel) {
        this.f3519a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public SearchCity() {
    }
}
