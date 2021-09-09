package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceTag implements Parcelable {
    public static final Parcelable.Creator<DeviceTag> CREATOR = new Parcelable.Creator<DeviceTag>() {
        /* class com.xiaomi.smarthome.device.api.DeviceTag.AnonymousClass1 */

        public final DeviceTag createFromParcel(Parcel parcel) {
            return new DeviceTag(parcel);
        }

        public final DeviceTag[] newArray(int i) {
            return new DeviceTag[i];
        }
    };
    public String infoJson;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeString(this.infoJson, parcel);
    }

    public DeviceTag() {
    }

    private DeviceTag(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        this.infoJson = parcel.readString();
    }

    /* access modifiers changed from: package-private */
    public void writeString(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }
}
