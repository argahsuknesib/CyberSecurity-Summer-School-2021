package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() {
        /* class com.amap.api.services.route.RouteResult.AnonymousClass1 */

        /* renamed from: a */
        public final RouteResult createFromParcel(Parcel parcel) {
            return new RouteResult(parcel);
        }

        /* renamed from: a */
        public final RouteResult[] newArray(int i) {
            return new RouteResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f3509a;
    private LatLonPoint b;

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f3509a;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f3509a = latLonPoint;
    }

    public LatLonPoint getTargetPos() {
        return this.b;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3509a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RouteResult(Parcel parcel) {
        this.f3509a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public RouteResult() {
    }
}
