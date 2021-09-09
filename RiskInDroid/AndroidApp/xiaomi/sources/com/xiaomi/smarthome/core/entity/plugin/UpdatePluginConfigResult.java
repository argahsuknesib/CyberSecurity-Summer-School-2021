package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdatePluginConfigResult implements Parcelable {
    public static final Parcelable.Creator<UpdatePluginConfigResult> CREATOR = new Parcelable.Creator<UpdatePluginConfigResult>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.UpdatePluginConfigResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UpdatePluginConfigResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UpdatePluginConfigResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f6740O000000o;
    public boolean O00000Oo;

    public int describeContents() {
        return 0;
    }

    public UpdatePluginConfigResult() {
    }

    protected UpdatePluginConfigResult(Parcel parcel) {
        boolean z = true;
        this.f6740O000000o = parcel.readByte() != 0;
        this.O00000Oo = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6740O000000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
    }
}
