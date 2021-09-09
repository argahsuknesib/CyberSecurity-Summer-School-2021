package com.ximalaya.ting.android.opensdk.model.xdcs;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class CdnConfigModel implements Parcelable {
    public static final Parcelable.Creator<CdnConfigModel> CREATOR = new Parcelable.Creator<CdnConfigModel>() {
        /* class com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CdnConfigModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CdnConfigModel(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12180O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public HashMap<String, String> O0000Oo;
    public String O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12180O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeMap(this.O0000Oo);
    }

    public CdnConfigModel() {
    }

    public CdnConfigModel(Parcel parcel) {
        this.f12180O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
