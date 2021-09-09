package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() {
        /* class com.amap.api.services.route.DrivePlanStep.AnonymousClass1 */

        /* renamed from: a */
        public final DrivePlanStep[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final DrivePlanStep createFromParcel(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3494a;
    private String b;
    private float c;
    private boolean d;
    private List<LatLonPoint> e = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public String getRoad() {
        return this.f3494a;
    }

    public void setAdCode(String str) {
        this.b = str;
    }

    public String getAdCode() {
        return this.b;
    }

    public void setRoad(String str) {
        this.f3494a = str;
    }

    public float getDistance() {
        return this.c;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public boolean getToll() {
        return this.d;
    }

    public void setToll(boolean z) {
        this.d = z;
    }

    public List<LatLonPoint> getPolyline() {
        return this.e;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.e = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3494a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
    }

    public DrivePlanStep(Parcel parcel) {
        this.f3494a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readInt() != 1 ? false : true;
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public DrivePlanStep() {
    }
}
