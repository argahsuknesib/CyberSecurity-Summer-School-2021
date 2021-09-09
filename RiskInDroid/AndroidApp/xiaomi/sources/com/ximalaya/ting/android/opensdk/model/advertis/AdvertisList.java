package com.ximalaya.ting.android.opensdk.model.advertis;

import _m_j.iix;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class AdvertisList extends iix implements Parcelable {
    public static final Parcelable.Creator<AdvertisList> CREATOR = new Parcelable.Creator<AdvertisList>() {
        /* class com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AdvertisList[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AdvertisList advertisList = new AdvertisList();
            advertisList.O00000oO = parcel.readLong();
            advertisList.O00000Oo = parcel.readInt();
            advertisList.O00000o = parcel.readInt();
            advertisList.O00000o0 = parcel.readString();
            if (parcel.readInt() > 0) {
                ArrayList arrayList = new ArrayList();
                parcel.readList(arrayList, Advertis.class.getClassLoader());
                advertisList.f12169O000000o = arrayList;
            }
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            advertisList.O00000oo = z;
            return advertisList;
        }
    };
    @SerializedName("data")

    /* renamed from: O000000o  reason: collision with root package name */
    public List<Advertis> f12169O000000o;
    public int O00000Oo = -2;
    int O00000o;
    String O00000o0;
    public long O00000oO;
    public boolean O00000oo;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.O00000oO);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000o0);
        List<Advertis> list = this.f12169O000000o;
        int size = list == null ? 0 : list.size();
        parcel.writeInt(size);
        if (size > 0) {
            parcel.writeList(this.f12169O000000o);
        }
        parcel.writeInt(this.O00000oo ? 1 : 0);
    }

    public String toString() {
        return "AdvertisList [advertisList=" + this.f12169O000000o + ", ret=" + this.O00000Oo + ", msg=" + this.O00000o0 + ", source=" + this.O00000o + ", responseId=" + this.O00000oO + "]";
    }
}
