package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() {
        /* class com.amap.api.services.route.RoutePlanResult.AnonymousClass1 */

        /* renamed from: a */
        public final RoutePlanResult createFromParcel(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        /* renamed from: a */
        public final RoutePlanResult[] newArray(int i) {
            return new RoutePlanResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f3507a;
    private LatLonPoint b;

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f3507a;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f3507a = latLonPoint;
    }

    public LatLonPoint getTargetPos() {
        return this.b;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3507a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RoutePlanResult(Parcel parcel) {
        this.f3507a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public RoutePlanResult() {
    }
}
