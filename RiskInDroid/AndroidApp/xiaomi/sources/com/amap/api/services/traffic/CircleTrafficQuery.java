package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.s;
import com.amap.api.services.core.LatLonPoint;

public class CircleTrafficQuery extends a implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CircleTrafficQuery> CREATOR = new Parcelable.Creator<CircleTrafficQuery>() {
        /* class com.amap.api.services.traffic.CircleTrafficQuery.AnonymousClass1 */

        /* renamed from: a */
        public final CircleTrafficQuery createFromParcel(Parcel parcel) {
            return new CircleTrafficQuery(parcel);
        }

        /* renamed from: a */
        public final CircleTrafficQuery[] newArray(int i) {
            return new CircleTrafficQuery[i];
        }
    };
    private LatLonPoint b;
    private int c = 1000;

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ int getLevel() {
        return super.getLevel();
    }

    public /* bridge */ /* synthetic */ void setLevel(int i) {
        super.setLevel(i);
    }

    public LatLonPoint getCenterPoint() {
        return this.b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public int getRadius() {
        return this.c;
    }

    public void setRadius(int i) {
        this.c = i;
    }

    public CircleTrafficQuery(LatLonPoint latLonPoint, int i, int i2) {
        this.b = latLonPoint;
        this.c = i;
        this.f3545a = i2;
    }

    protected CircleTrafficQuery(Parcel parcel) {
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.c = parcel.readInt();
        this.f3545a = parcel.readInt();
    }

    public CircleTrafficQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            s.a(e, "CircleTrafficQuery", "CircleTrafficQueryClone");
        }
        return new CircleTrafficQuery(this.b, this.c, this.f3545a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c);
        parcel.writeInt(this.f3545a);
    }
}
