package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new Parcelable.Creator<RideStep>() {
        /* class com.amap.api.services.route.RideStep.AnonymousClass1 */

        /* renamed from: a */
        public final RideStep createFromParcel(Parcel parcel) {
            return new RideStep(parcel);
        }

        /* renamed from: a */
        public final RideStep[] newArray(int i) {
            return new RideStep[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3504a;
    private String b;
    private String c;
    private float d;
    private float e;
    private List<LatLonPoint> f = new ArrayList();
    private String g;
    private String h;

    public int describeContents() {
        return 0;
    }

    public RideStep() {
    }

    public String getInstruction() {
        return this.f3504a;
    }

    public void setInstruction(String str) {
        this.f3504a = str;
    }

    public String getOrientation() {
        return this.b;
    }

    public void setOrientation(String str) {
        this.b = str;
    }

    public String getRoad() {
        return this.c;
    }

    public void setRoad(String str) {
        this.c = str;
    }

    public float getDistance() {
        return this.d;
    }

    public void setDistance(float f2) {
        this.d = f2;
    }

    public float getDuration() {
        return this.e;
    }

    public void setDuration(float f2) {
        this.e = f2;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f = list;
    }

    public String getAction() {
        return this.g;
    }

    public void setAction(String str) {
        this.g = str;
    }

    public String getAssistantAction() {
        return this.h;
    }

    public void setAssistantAction(String str) {
        this.h = str;
    }

    protected RideStep(Parcel parcel) {
        this.f3504a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3504a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
