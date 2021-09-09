package com.xiaomi.smarthome.config.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MultimediaConfig implements Parcelable {
    public static final Parcelable.Creator<MultimediaConfig> CREATOR = new Parcelable.Creator<MultimediaConfig>() {
        /* class com.xiaomi.smarthome.config.model.MultimediaConfig.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultimediaConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MultimediaConfig(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6717O000000o;
    public String O00000Oo;
    public boolean O00000o0;

    public int describeContents() {
        return 0;
    }

    public MultimediaConfig() {
    }

    protected MultimediaConfig(Parcel parcel) {
        this.f6717O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6717O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MultimediaConfig");
        sb.append(":" + this.f6717O000000o);
        sb.append(":" + this.O00000Oo);
        sb.append(":" + this.O00000o0);
        return sb.toString();
    }
}
