package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() {
        /* class com.amap.api.services.route.WalkStep.AnonymousClass1 */

        /* renamed from: a */
        public final WalkStep[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final WalkStep createFromParcel(Parcel parcel) {
            return new WalkStep(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3529a;
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

    public String getInstruction() {
        return this.f3529a;
    }

    public void setInstruction(String str) {
        this.f3529a = str;
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

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3529a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public WalkStep(Parcel parcel) {
        this.f3529a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public WalkStep() {
    }
}
