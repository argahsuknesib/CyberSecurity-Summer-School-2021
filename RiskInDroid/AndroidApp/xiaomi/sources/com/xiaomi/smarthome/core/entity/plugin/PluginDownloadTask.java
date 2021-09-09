package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class PluginDownloadTask implements Parcelable {
    public static final Parcelable.Creator<PluginDownloadTask> CREATOR = new Parcelable.Creator<PluginDownloadTask>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDownloadTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginDownloadTask(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6738O000000o;
    public int O00000Oo;
    public long O00000o;
    public String O00000o0;
    public long O00000oO;
    public int O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public PluginDownloadTask() {
    }

    protected PluginDownloadTask(Parcel parcel) {
        this.O00000o = parcel.readLong();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readString();
        this.f6738O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
        this.O00000oO = parcel.readLong();
    }

    public final void O000000o(PluginDownloadTask pluginDownloadTask) {
        pluginDownloadTask.O00000o = this.O00000o;
        pluginDownloadTask.O00000oo = this.O00000oo;
        pluginDownloadTask.O0000O0o = this.O0000O0o;
        pluginDownloadTask.f6738O000000o = this.f6738O000000o;
        pluginDownloadTask.O00000Oo = this.O00000Oo;
        pluginDownloadTask.O00000o0 = this.O00000o0;
        pluginDownloadTask.O00000oO = this.O00000oO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.O00000o);
        parcel.writeInt(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.f6738O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeLong(this.O00000oO);
    }
}
