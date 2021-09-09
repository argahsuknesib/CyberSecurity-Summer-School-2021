package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() {
        /* class com.amap.api.services.route.Path.AnonymousClass1 */

        /* renamed from: a */
        public final Path[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final Path createFromParcel(Parcel parcel) {
            return new Path(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f3498a;
    private long b;

    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f3498a;
    }

    public void setDistance(float f) {
        this.f3498a = f;
    }

    public long getDuration() {
        return this.b;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f3498a);
        parcel.writeLong(this.b);
    }

    public Path(Parcel parcel) {
        this.f3498a = parcel.readFloat();
        this.b = parcel.readLong();
    }

    public Path() {
    }
}
