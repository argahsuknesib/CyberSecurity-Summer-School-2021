package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() {
        /* class com.amap.api.services.route.TMC.AnonymousClass1 */

        /* renamed from: a */
        public final TMC[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final TMC createFromParcel(Parcel parcel) {
            return new TMC(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f3520a;
    private String b;
    private List<LatLonPoint> c = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f3520a;
    }

    public String getStatus() {
        return this.b;
    }

    public void setDistance(int i) {
        this.f3520a = i;
    }

    public void setStatus(String str) {
        this.b = str;
    }

    public List<LatLonPoint> getPolyline() {
        return this.c;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3520a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
    }

    public TMC(Parcel parcel) {
        this.f3520a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public TMC() {
    }
}
