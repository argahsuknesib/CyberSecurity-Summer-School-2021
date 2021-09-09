package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadPluginDebugPackageResult implements Parcelable {
    public static final Parcelable.Creator<DownloadPluginDebugPackageResult> CREATOR = new Parcelable.Creator<DownloadPluginDebugPackageResult>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.DownloadPluginDebugPackageResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DownloadPluginDebugPackageResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DownloadPluginDebugPackageResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6732O000000o;
    public String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public DownloadPluginDebugPackageResult() {
    }

    protected DownloadPluginDebugPackageResult(Parcel parcel) {
        this.f6732O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6732O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
