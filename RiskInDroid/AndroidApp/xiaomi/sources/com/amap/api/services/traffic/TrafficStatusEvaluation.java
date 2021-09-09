package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;

public class TrafficStatusEvaluation implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusEvaluation> CREATOR = new Parcelable.Creator<TrafficStatusEvaluation>() {
        /* class com.amap.api.services.traffic.TrafficStatusEvaluation.AnonymousClass1 */

        /* renamed from: a */
        public final TrafficStatusEvaluation createFromParcel(Parcel parcel) {
            return new TrafficStatusEvaluation(parcel);
        }

        /* renamed from: a */
        public final TrafficStatusEvaluation[] newArray(int i) {
            return new TrafficStatusEvaluation[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3542a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public int describeContents() {
        return 0;
    }

    public String getExpedite() {
        return this.f3542a;
    }

    public void setExpedite(String str) {
        this.f3542a = str;
    }

    public String getCongested() {
        return this.b;
    }

    public void setCongested(String str) {
        this.b = str;
    }

    public String getBlocked() {
        return this.c;
    }

    public void setBlocked(String str) {
        this.c = str;
    }

    public String getUnknown() {
        return this.d;
    }

    public void setUnknown(String str) {
        this.d = str;
    }

    public String getStatus() {
        return this.e;
    }

    public void setStatus(String str) {
        this.e = str;
    }

    public String getDescription() {
        return this.f;
    }

    public void setDescription(String str) {
        this.f = str;
    }

    public TrafficStatusEvaluation() {
    }

    protected TrafficStatusEvaluation(Parcel parcel) {
        this.f3542a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3542a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
