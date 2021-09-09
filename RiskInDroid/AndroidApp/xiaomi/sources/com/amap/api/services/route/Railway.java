package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() {
        /* class com.amap.api.services.route.Railway.AnonymousClass1 */

        /* renamed from: a */
        public final Railway createFromParcel(Parcel parcel) {
            return new Railway(parcel);
        }

        /* renamed from: a */
        public final Railway[] newArray(int i) {
            return new Railway[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3499a;
    private String b;

    public int describeContents() {
        return 0;
    }

    public Railway() {
    }

    public String getID() {
        return this.f3499a;
    }

    public String getName() {
        return this.b;
    }

    public void setID(String str) {
        this.f3499a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3499a);
        parcel.writeString(this.b);
    }

    protected Railway(Parcel parcel) {
        this.f3499a = parcel.readString();
        this.b = parcel.readString();
    }
}
