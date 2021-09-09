package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.s;

public class RoadTrafficQuery extends a implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RoadTrafficQuery> CREATOR = new Parcelable.Creator<RoadTrafficQuery>() {
        /* class com.amap.api.services.traffic.RoadTrafficQuery.AnonymousClass1 */

        /* renamed from: a */
        public final RoadTrafficQuery createFromParcel(Parcel parcel) {
            return new RoadTrafficQuery(parcel);
        }

        /* renamed from: a */
        public final RoadTrafficQuery[] newArray(int i) {
            return new RoadTrafficQuery[i];
        }
    };
    private String b;
    private String c;

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ int getLevel() {
        return super.getLevel();
    }

    public /* bridge */ /* synthetic */ void setLevel(int i) {
        super.setLevel(i);
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
    }

    public String getAdCode() {
        return this.c;
    }

    public void setAdCode(String str) {
        this.c = str;
    }

    public RoadTrafficQuery(String str, String str2, int i) {
        this.b = str;
        this.c = str2;
        this.f3545a = i;
    }

    protected RoadTrafficQuery(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.f3545a = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f3545a);
    }

    public RoadTrafficQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            s.a(e, "RoadTrafficQuery", "RoadTrafficQueryClone");
        }
        return new RoadTrafficQuery(this.b, this.c, this.f3545a);
    }
}
