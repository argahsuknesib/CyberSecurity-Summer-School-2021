package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() {
        /* class com.amap.api.services.geocoder.BusinessArea.AnonymousClass1 */

        /* renamed from: a */
        public final BusinessArea createFromParcel(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        /* renamed from: a */
        public final BusinessArea[] newArray(int i) {
            return new BusinessArea[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f3453a;
    private String b;

    public int describeContents() {
        return 0;
    }

    public BusinessArea() {
    }

    public LatLonPoint getCenterPoint() {
        return this.f3453a;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f3453a = latLonPoint;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3453a, i);
        parcel.writeString(this.b);
    }

    public BusinessArea(Parcel parcel) {
        this.f3453a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = parcel.readString();
    }
}
