package com.xiaomi.mico.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mico.api.model.MultiRoomData;

public class DeviceState implements Parcelable {
    public static final Parcelable.Creator<DeviceState> CREATOR = new Parcelable.Creator<DeviceState>() {
        /* class com.xiaomi.mico.api.model.DeviceState.AnonymousClass1 */

        public final DeviceState createFromParcel(Parcel parcel) {
            return new DeviceState(parcel);
        }

        public final DeviceState[] newArray(int i) {
            return new DeviceState[i];
        }
    };
    public String deviceId;
    public String deviceName;
    public String hardware;
    public boolean isEnable;
    public int nearbyStatus;
    public int onlineStatus;
    public String resource;
    public transient boolean select;
    public transient String stereoJson;
    public transient boolean unKnownError;

    public int describeContents() {
        return 0;
    }

    public boolean isOn() {
        return this.nearbyStatus == 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeInt(this.nearbyStatus);
        parcel.writeInt(this.onlineStatus);
        parcel.writeString(this.resource);
        parcel.writeString(this.hardware);
        parcel.writeByte(this.select ? (byte) 1 : 0);
        parcel.writeByte(this.unKnownError ? (byte) 1 : 0);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.stereoJson);
    }

    public DeviceState() {
        this.hardware = "";
        this.deviceName = "";
        this.isEnable = true;
    }

    protected DeviceState(Parcel parcel) {
        this.hardware = "";
        this.deviceName = "";
        boolean z = true;
        this.isEnable = true;
        this.deviceId = parcel.readString();
        this.nearbyStatus = parcel.readInt();
        this.onlineStatus = parcel.readInt();
        this.resource = parcel.readString();
        this.hardware = parcel.readString();
        this.select = parcel.readByte() != 0;
        this.unKnownError = parcel.readByte() == 0 ? false : z;
        this.deviceName = parcel.readString();
        this.stereoJson = parcel.readString();
    }

    public static DeviceState convert(MultiRoomData.MultiRoomMember multiRoomMember) {
        DeviceState deviceState = new DeviceState();
        deviceState.deviceId = multiRoomMember.deviceId;
        deviceState.resource = multiRoomMember.resource;
        deviceState.hardware = multiRoomMember.hardWare;
        deviceState.deviceName = multiRoomMember.name;
        deviceState.unKnownError = multiRoomMember.unKnownError;
        deviceState.select = true;
        return deviceState;
    }
}
