package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() {
        /* class com.amap.api.services.route.RidePath.AnonymousClass1 */

        /* renamed from: a */
        public final RidePath[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<RideStep> f3502a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f3502a;
    }

    public void setSteps(List<RideStep> list) {
        this.f3502a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3502a);
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f3502a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    public RidePath() {
    }
}
