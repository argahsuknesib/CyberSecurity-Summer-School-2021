package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class TrafficStatusResult implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusResult> CREATOR = new Parcelable.Creator<TrafficStatusResult>() {
        /* class com.amap.api.services.traffic.TrafficStatusResult.AnonymousClass1 */

        /* renamed from: a */
        public final TrafficStatusResult createFromParcel(Parcel parcel) {
            return new TrafficStatusResult(parcel);
        }

        /* renamed from: a */
        public final TrafficStatusResult[] newArray(int i) {
            return new TrafficStatusResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3544a;
    private TrafficStatusEvaluation b;
    private List<TrafficStatusInfo> c;

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.f3544a;
    }

    public void setDescription(String str) {
        this.f3544a = str;
    }

    public TrafficStatusEvaluation getEvaluation() {
        return this.b;
    }

    public void setEvaluation(TrafficStatusEvaluation trafficStatusEvaluation) {
        this.b = trafficStatusEvaluation;
    }

    public List<TrafficStatusInfo> getRoads() {
        return this.c;
    }

    public void setRoads(List<TrafficStatusInfo> list) {
        this.c = list;
    }

    public TrafficStatusResult() {
    }

    protected TrafficStatusResult(Parcel parcel) {
        this.f3544a = parcel.readString();
        this.b = (TrafficStatusEvaluation) parcel.readParcelable(TrafficStatusEvaluation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(TrafficStatusInfo.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3544a);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
    }
}
