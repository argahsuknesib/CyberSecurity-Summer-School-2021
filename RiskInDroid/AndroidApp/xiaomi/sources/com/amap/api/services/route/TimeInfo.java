package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() {
        /* class com.amap.api.services.route.TimeInfo.AnonymousClass1 */

        /* renamed from: a */
        public final TimeInfo[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final TimeInfo createFromParcel(Parcel parcel) {
            return new TimeInfo(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f3522a;
    private List<TimeInfosElement> b = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public long getStartTime() {
        return this.f3522a;
    }

    public void setStartTime(long j) {
        this.f3522a = j;
    }

    public List<TimeInfosElement> getElements() {
        return this.b;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.b = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3522a);
        parcel.writeTypedList(this.b);
    }

    public TimeInfo(Parcel parcel) {
        this.f3522a = (long) parcel.readInt();
        this.b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    public TimeInfo() {
    }
}
