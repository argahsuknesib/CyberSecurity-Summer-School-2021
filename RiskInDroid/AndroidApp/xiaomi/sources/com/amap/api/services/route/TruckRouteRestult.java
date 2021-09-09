package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() {
        /* class com.amap.api.services.route.TruckRouteRestult.AnonymousClass1 */

        /* renamed from: a */
        public final TruckRouteRestult createFromParcel(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        /* renamed from: a */
        public final TruckRouteRestult[] newArray(int i) {
            return new TruckRouteRestult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f3525a;
    private List<TruckPath> b;
    private LatLonPoint c;
    private LatLonPoint d;

    public int describeContents() {
        return 0;
    }

    public TruckRouteRestult() {
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f3525a = truckRouteQuery;
    }

    public void setPaths(List<TruckPath> list) {
        this.b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f3525a;
    }

    public List<TruckPath> getPaths() {
        return this.b;
    }

    public LatLonPoint getStartPos() {
        return this.c;
    }

    public LatLonPoint getTargetPos() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
