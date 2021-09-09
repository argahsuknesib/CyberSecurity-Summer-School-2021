package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadRnSdkResult implements Parcelable {
    public static final Parcelable.Creator<DownloadRnSdkResult> CREATOR = new Parcelable.Creator<DownloadRnSdkResult>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.DownloadRnSdkResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DownloadRnSdkResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DownloadRnSdkResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6734O000000o;
    public String O00000Oo;
    public float O00000o0;

    public int describeContents() {
        return 0;
    }

    public DownloadRnSdkResult() {
    }

    public DownloadRnSdkResult(int i, String str) {
        this.f6734O000000o = i;
        this.O00000Oo = str;
    }

    protected DownloadRnSdkResult(Parcel parcel) {
        this.f6734O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6734O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeFloat(this.O00000o0);
    }
}
