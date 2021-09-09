package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class InstallPluginResult implements Parcelable {
    public static final Parcelable.Creator<InstallPluginResult> CREATOR = new Parcelable.Creator<InstallPluginResult>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.InstallPluginResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new InstallPluginResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new InstallPluginResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6735O000000o;
    public String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public InstallPluginResult() {
    }

    protected InstallPluginResult(Parcel parcel) {
        this.f6735O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6735O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
