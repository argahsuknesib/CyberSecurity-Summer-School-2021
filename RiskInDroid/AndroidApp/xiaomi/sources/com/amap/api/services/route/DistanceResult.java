package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() {
        /* class com.amap.api.services.route.DistanceResult.AnonymousClass1 */

        /* renamed from: a */
        public final DistanceResult createFromParcel(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        /* renamed from: a */
        public final DistanceResult[] newArray(int i) {
            return new DistanceResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private DistanceSearch.DistanceQuery f3487a;
    private List<DistanceItem> b = null;

    public int describeContents() {
        return 0;
    }

    public DistanceResult() {
    }

    protected DistanceResult(Parcel parcel) {
        this.b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f3487a = distanceQuery;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f3487a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.b;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.b = list;
    }
}
