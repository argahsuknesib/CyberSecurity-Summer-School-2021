package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class DownloadPluginResult implements Parcelable {
    public static final Parcelable.Creator<DownloadPluginResult> CREATOR = new Parcelable.Creator<DownloadPluginResult>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.DownloadPluginResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DownloadPluginResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DownloadPluginResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6733O000000o;
    public int O00000Oo;
    public ArrayList<PluginDownloadTask> O00000o;
    public String O00000o0;
    public float O00000oO;

    public int describeContents() {
        return 0;
    }

    public DownloadPluginResult() {
    }

    protected DownloadPluginResult(Parcel parcel) {
        this.f6733O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.createTypedArrayList(PluginDownloadTask.CREATOR);
        this.O00000oO = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6733O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeTypedList(this.O00000o);
        parcel.writeFloat(this.O00000oO);
    }
}
