package com.mi.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class UpdaterInfo implements Parcelable {
    public static final Parcelable.Creator<UpdaterInfo> CREATOR = new Parcelable.Creator<UpdaterInfo>() {
        /* class com.mi.model.UpdaterInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UpdaterInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            UpdaterInfo updaterInfo = new UpdaterInfo();
            updaterInfo.O00000Oo = parcel.readString();
            updaterInfo.O00000o0 = parcel.readString();
            updaterInfo.O00000o = parcel.readString();
            updaterInfo.O00000oO = parcel.readString();
            updaterInfo.O00000oo = parcel.readInt();
            updaterInfo.O0000O0o = parcel.readByte() != 0;
            updaterInfo.f5088O000000o = new ArrayList<>();
            parcel.readList(updaterInfo.f5088O000000o, DescType.class.getClassLoader());
            updaterInfo.O0000Oo0 = parcel.readString();
            updaterInfo.O0000OOo = new ArrayList<>();
            parcel.readList(updaterInfo.O0000OOo, Feature.class.getClassLoader());
            updaterInfo.O0000Oo = parcel.readString();
            return updaterInfo;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<DescType> f5088O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public int O00000oo;
    public boolean O0000O0o;
    public ArrayList<Feature> O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;

    public static class DescType implements Serializable {
        public String mDesc;
        public String mDescType;
    }

    public static class Feature implements Serializable {
        public String mFeatureDescription;
        public String mFeatureImage;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeByte(this.O0000O0o ? (byte) 1 : 0);
        parcel.writeList(this.f5088O000000o);
        parcel.writeString(this.O0000Oo0);
        parcel.writeList(this.O0000OOo);
        parcel.writeString(this.O0000Oo);
    }
}
