package com.mi.mistatistic.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;

public class EventData implements Parcelable {
    public static final Parcelable.Creator<EventData> CREATOR = new Parcelable.Creator<EventData>() {
        /* class com.mi.mistatistic.sdk.data.EventData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EventData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new EventData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5063O000000o;
    public String O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public EventData(String str, String str2, String str3) {
        this.f5063O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
    }

    protected EventData(Parcel parcel) {
        this.f5063O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5063O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }
}
