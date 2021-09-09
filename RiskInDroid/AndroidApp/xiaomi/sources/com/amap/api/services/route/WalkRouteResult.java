package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() {
        /* class com.amap.api.services.route.WalkRouteResult.AnonymousClass1 */

        /* renamed from: a */
        public final WalkRouteResult createFromParcel(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        /* renamed from: a */
        public final WalkRouteResult[] newArray(int i) {
            return new WalkRouteResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<WalkPath> f3528a = new ArrayList();
    private RouteSearch.WalkRouteQuery b;

    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f3528a;
    }

    public void setPaths(List<WalkPath> list) {
        this.f3528a = list;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.b;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.b = walkRouteQuery;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3528a);
        parcel.writeParcelable(this.b, i);
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f3528a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    public WalkRouteResult() {
    }
}
