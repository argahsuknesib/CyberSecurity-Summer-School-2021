package com.xiaomi.router.miio.miioplugin;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceTagInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceTagInfo> CREATOR = new Parcelable.Creator<DeviceTagInfo>() {
        /* class com.xiaomi.router.miio.miioplugin.DeviceTagInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceTagInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceTagInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6612O000000o;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ DeviceTagInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public DeviceTagInfo() {
    }

    private DeviceTagInfo(Parcel parcel) {
        this.f6612O000000o = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = this.f6612O000000o;
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }
}
