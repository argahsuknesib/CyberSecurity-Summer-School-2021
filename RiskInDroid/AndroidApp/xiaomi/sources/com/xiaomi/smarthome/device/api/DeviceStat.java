package com.xiaomi.smarthome.device.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceStat implements Parcelable {
    public static final Parcelable.Creator<DeviceStat> CREATOR = new Parcelable.Creator<DeviceStat>() {
        /* class com.xiaomi.smarthome.device.api.DeviceStat.AnonymousClass1 */

        public final DeviceStat createFromParcel(Parcel parcel) {
            return new DeviceStat(parcel);
        }

        public final DeviceStat[] newArray(int i) {
            return new DeviceStat[i];
        }
    };
    public int authFlag;
    public int bindFlag;
    public String bssid;
    public int comFlag;
    public String deviceIconReal;
    public String did;
    public String event;
    public String extrainfo;
    public boolean freqFlag;
    public int hideMode;
    public String ip;
    public boolean isGrouped;
    public boolean isOnline;
    public int isSetPinCode;
    public long lastModified;
    public double latitude;
    public int location;
    public double longitude;
    public String mac;
    public String model;
    public int mtu;
    public String name;
    public String orderTimeJString;
    public String ownerId;
    public String ownerName;
    public String parentId;
    public String parentModel;
    public int permitLevel;
    public int pid;
    public int pinCodeType;
    public JSONObject propInfo;
    public Bundle property;
    public int resetFlag;
    public int rssi;
    @Deprecated
    public int showMode;
    public String ssid;
    public String token;
    public String userId;
    public String version;

    public int describeContents() {
        return 0;
    }

    public DeviceStat() {
        this.did = "";
        this.name = "";
        this.mac = "";
        this.model = "";
        this.extrainfo = "";
        this.ip = "";
        this.userId = "";
        this.property = new Bundle();
        this.mtu = 23;
        this.isGrouped = false;
        this.freqFlag = true;
        this.comFlag = 0;
        this.did = "";
        this.name = "";
        this.mac = "";
        this.model = "";
        this.extrainfo = "";
        this.event = "";
    }

    public DeviceStat(Parcel parcel) {
        this.did = "";
        this.name = "";
        this.mac = "";
        this.model = "";
        this.extrainfo = "";
        this.ip = "";
        this.userId = "";
        this.property = new Bundle();
        this.mtu = 23;
        this.isGrouped = false;
        this.freqFlag = true;
        this.comFlag = 0;
        readFromParcel(parcel);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeviceStat)) {
            return false;
        }
        DeviceStat deviceStat = (DeviceStat) obj;
        String str = this.did;
        if (str != null) {
            return str.equals(deviceStat.did);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        this.did = parcel.readString();
        this.name = parcel.readString();
        this.mac = parcel.readString();
        this.model = parcel.readString();
        this.extrainfo = parcel.readString();
        this.ip = parcel.readString();
        this.parentId = parcel.readString();
        this.parentModel = parcel.readString();
        this.bindFlag = parcel.readInt();
        this.authFlag = parcel.readInt();
        this.token = parcel.readString();
        this.userId = parcel.readString();
        this.location = parcel.readInt();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.bssid = parcel.readString();
        this.lastModified = parcel.readLong();
        this.pid = parcel.readInt();
        this.rssi = parcel.readInt();
        boolean z = true;
        this.isOnline = parcel.readInt() != 0;
        this.resetFlag = parcel.readInt();
        this.ssid = parcel.readString();
        this.ownerName = parcel.readString();
        this.ownerId = parcel.readString();
        String readString = parcel.readString();
        this.propInfo = null;
        if (!TextUtils.isEmpty(readString)) {
            try {
                this.propInfo = new JSONObject(readString);
            } catch (JSONException unused) {
            }
        }
        this.version = parcel.readString();
        this.property = parcel.readBundle();
        this.showMode = parcel.readInt();
        this.hideMode = parcel.readInt();
        this.event = parcel.readString();
        this.permitLevel = parcel.readInt();
        this.isSetPinCode = parcel.readInt();
        this.pinCodeType = parcel.readInt();
        this.deviceIconReal = parcel.readString();
        this.mtu = parcel.readInt();
        this.isGrouped = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.freqFlag = z;
        this.comFlag = parcel.readInt();
        this.orderTimeJString = parcel.readString();
    }

    public int hashCode() {
        return this.did.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void writeString(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeString(this.did, parcel);
        writeString(this.name, parcel);
        writeString(this.mac, parcel);
        writeString(this.model, parcel);
        writeString(this.extrainfo, parcel);
        writeString(this.ip, parcel);
        writeString(this.parentId, parcel);
        writeString(this.parentModel, parcel);
        parcel.writeInt(this.bindFlag);
        parcel.writeInt(this.authFlag);
        writeString(this.token, parcel);
        writeString(this.userId, parcel);
        parcel.writeInt(this.location);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        writeString(this.bssid, parcel);
        parcel.writeLong(this.lastModified);
        parcel.writeInt(this.pid);
        parcel.writeInt(this.rssi);
        parcel.writeInt(this.isOnline ? 1 : 0);
        parcel.writeInt(this.resetFlag);
        writeString(this.ssid, parcel);
        writeString(this.ownerName, parcel);
        writeString(this.ownerId, parcel);
        JSONObject jSONObject = this.propInfo;
        if (jSONObject == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(jSONObject.toString());
        }
        writeString(this.version, parcel);
        if (this.property == null) {
            this.property = new Bundle();
        }
        parcel.writeBundle(this.property);
        parcel.writeInt(this.showMode);
        parcel.writeInt(this.hideMode);
        writeString(this.event, parcel);
        parcel.writeInt(this.permitLevel);
        parcel.writeInt(this.isSetPinCode);
        parcel.writeInt(this.pinCodeType);
        writeString(this.deviceIconReal, parcel);
        parcel.writeInt(this.mtu);
        parcel.writeInt(this.isGrouped ? 1 : 0);
        parcel.writeInt(this.freqFlag ? 1 : 0);
        parcel.writeInt(this.comFlag);
        writeString(this.orderTimeJString, parcel);
    }

    public String toString() {
        return "did:" + this.did + " " + "extrainfo:" + this.extrainfo + " " + "version:" + this.version;
    }
}
