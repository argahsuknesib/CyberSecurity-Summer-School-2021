package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class PluginDeveloperInfo implements Parcelable {
    public static final Parcelable.Creator<PluginDeveloperInfo> CREATOR = new Parcelable.Creator<PluginDeveloperInfo>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginDeveloperInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDeveloperInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginDeveloperInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private long f6736O000000o;
    private String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public PluginDeveloperInfo() {
    }

    protected PluginDeveloperInfo(Parcel parcel) {
        this.f6736O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6736O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
