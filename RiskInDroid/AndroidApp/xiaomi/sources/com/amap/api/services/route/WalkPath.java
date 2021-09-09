package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
    public static final Parcelable.Creator<WalkPath> CREATOR = new Parcelable.Creator<WalkPath>() {
        /* class com.amap.api.services.route.WalkPath.AnonymousClass1 */

        /* renamed from: a */
        public final WalkPath[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final WalkPath createFromParcel(Parcel parcel) {
            return new WalkPath(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<WalkStep> f3527a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.f3527a;
    }

    public void setSteps(List<WalkStep> list) {
        this.f3527a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3527a);
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f3527a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    public WalkPath() {
    }
}
