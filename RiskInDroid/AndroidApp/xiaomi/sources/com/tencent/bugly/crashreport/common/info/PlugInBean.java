package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() {
        /* class com.tencent.bugly.crashreport.common.info.PlugInBean.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f5811O000000o;
    public final String O00000Oo;
    public final String O00000o0;

    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f5811O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
    }

    public String toString() {
        return "plid:" + this.f5811O000000o + " plV:" + this.O00000Oo + " plUUID:" + this.O00000o0;
    }

    public PlugInBean(Parcel parcel) {
        this.f5811O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5811O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }
}
