package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() {
        /* class com.amap.api.services.route.RouteSearchCity.AnonymousClass1 */

        /* renamed from: a */
        public final RouteSearchCity[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final RouteSearchCity createFromParcel(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    List<District> f3518a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.f3518a;
    }

    public void setDistricts(List<District> list) {
        this.f3518a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3518a);
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f3518a = parcel.createTypedArrayList(District.CREATOR);
    }

    public RouteSearchCity() {
    }
}
