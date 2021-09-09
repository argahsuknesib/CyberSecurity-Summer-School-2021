package com.xiaomi.smarthome.uwb.lib.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.proto.UwbData;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class UwbScanDevice implements Parcelable {
    public static final Parcelable.Creator<UwbScanDevice> CREATOR = new Parcelable.Creator<UwbScanDevice>() {
        /* class com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice.AnonymousClass1 */

        public final UwbScanDevice createFromParcel(Parcel parcel) {
            return new UwbScanDevice(parcel);
        }

        public final UwbScanDevice[] newArray(int i) {
            return new UwbScanDevice[i];
        }
    };
    private String accountInfo;
    private String accountInfoPlain;
    private int altitudeAoa;
    private int authorization;
    private int azimuthAoa;
    private String bleAddress;
    private DeviceState deviceState;
    private int deviceType;
    private DidInfo didInfo;
    private long distance;
    private boolean hasTagState;
    private String idmIdHash;
    private int idmSupport;
    private String macAddress;
    private int miLinkSupport;
    private long pid;
    private int rssi;
    private int sessionHandle;
    private TagState tagState;
    private String tvMacInfo;
    private String uwbAddress;

    public int describeContents() {
        return 0;
    }

    public void setModel(String str) {
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionHandle", this.sessionHandle);
            jSONObject.put("distance", this.distance);
            jSONObject.put("altitudeAoa", this.altitudeAoa);
            jSONObject.put("azimuthAoa", this.azimuthAoa);
            jSONObject.put("authorization", this.authorization);
            jSONObject.put("rssi", this.rssi);
            jSONObject.put("deviceType", this.deviceType);
            jSONObject.put("pid", this.pid);
            jSONObject.put("hasTagState", this.hasTagState);
            jSONObject.put("tagState", this.tagState.toJSON());
            jSONObject.put("idmIdHash", this.idmIdHash);
            jSONObject.put("didInfo", this.didInfo.getDid());
            jSONObject.put("accountInfo", this.accountInfo);
            jSONObject.put("accountInfoPlain", this.accountInfoPlain);
            jSONObject.put("macAddress", this.macAddress);
            jSONObject.put("uwbAddress", this.uwbAddress);
            jSONObject.put("deviceState", this.deviceState.toJSON());
            jSONObject.put("miLinkSupport", this.miLinkSupport);
            jSONObject.put("idmSupport", this.idmSupport);
            jSONObject.put("bleAddress", this.bleAddress);
            jSONObject.put("tvMacInfo", this.tvMacInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static UwbScanDevice parse(JSONObject jSONObject) {
        UwbScanDevice uwbScanDevice = new UwbScanDevice();
        uwbScanDevice.setDidInfo(DidInfo.parse(jSONObject.optString("didInfo")));
        uwbScanDevice.setDistance(jSONObject.optLong("distance"));
        uwbScanDevice.setSessionHandle(jSONObject.optInt("sessionHandle"));
        uwbScanDevice.setAltitudeAoa(jSONObject.optInt("altitudeAoa"));
        uwbScanDevice.setAzimuthAoa(jSONObject.optInt("azimuthAoa"));
        uwbScanDevice.setRssi(jSONObject.optInt("rssi"));
        uwbScanDevice.setDeviceType(jSONObject.optInt("deviceType"));
        uwbScanDevice.setPid(jSONObject.optLong("pid"));
        uwbScanDevice.setHasTagState(jSONObject.optBoolean("hasTagState"));
        uwbScanDevice.setTagState(TagState.parse(jSONObject.optJSONObject("tagState")));
        uwbScanDevice.setIdmIdHash(jSONObject.optString("idmIdHash"));
        uwbScanDevice.setAuthorization(jSONObject.optInt("authorization"));
        uwbScanDevice.setAccountInfo(jSONObject.optString("accountInfo"));
        uwbScanDevice.setAccountInfoPlain(jSONObject.optString("accountInfoPlain"));
        uwbScanDevice.setMacAddress(jSONObject.optString("macAddress"));
        uwbScanDevice.setUwbAddress(jSONObject.optString("uwbAddress"));
        uwbScanDevice.setDeviceState(DeviceState.parse(jSONObject.optJSONObject("deviceState")));
        uwbScanDevice.setMiLinkSupport(jSONObject.optInt("miLinkSupport"));
        uwbScanDevice.setIdmIdHash(jSONObject.optString("idmSupport"));
        uwbScanDevice.setBleAddress(jSONObject.optString("bleAddress"));
        uwbScanDevice.setTvMacInfo(jSONObject.optString("tvMacInfo"));
        return uwbScanDevice;
    }

    public static UwbScanDevice convert(IDMUwbDevice iDMUwbDevice) {
        if (iDMUwbDevice == null || iDMUwbDevice.measurementData == null) {
            return null;
        }
        UwbData.MeasurementData measurementData = iDMUwbDevice.measurementData;
        UwbScanDevice uwbScanDevice = new UwbScanDevice();
        uwbScanDevice.setUwbAddress(iDMUwbDevice.uwbAddress);
        uwbScanDevice.setDeviceType(measurementData.getDeviceType());
        uwbScanDevice.setBleAddress(measurementData.getBleAddress());
        if (measurementData.getIdmIdHash() != null) {
            uwbScanDevice.setIdmIdHash(ByteUtils.byteToString(measurementData.getIdmIdHash().toByteArray()));
        }
        if (measurementData.getAccountInfo() != null) {
            uwbScanDevice.setAccountInfo(ByteUtils.byteToString(measurementData.getAccountInfo().toByteArray()));
        }
        uwbScanDevice.setAltitudeAoa(measurementData.getAltitudeAoa());
        uwbScanDevice.setAzimuthAoa(measurementData.getAzimuthAoa());
        uwbScanDevice.setDeviceType(measurementData.getDeviceType());
        uwbScanDevice.setDistance(measurementData.getDistance());
        if (measurementData.getMacAddress() != null) {
            uwbScanDevice.setMacAddress(ByteUtils.byteToString(measurementData.getMacAddress().toByteArray()));
        }
        uwbScanDevice.setPid(measurementData.getPid());
        uwbScanDevice.setRssi(measurementData.getRssi());
        uwbScanDevice.setHasTagState(measurementData.hasTagState());
        if (measurementData.getDidInfo() != null) {
            uwbScanDevice.setDidInfo(DidInfo.parse(ByteUtils.byteToString(measurementData.getDidInfo().toByteArray())));
        }
        uwbScanDevice.setTagState(TagState.parse(measurementData.getTagState()));
        uwbScanDevice.setDeviceState(DeviceState.parse(measurementData.getDeviceState()));
        uwbScanDevice.setTvMacInfo(ByteUtils.byteToString(measurementData.getTvMacInfo().toByteArray()));
        return uwbScanDevice;
    }

    public int getSessionHandle() {
        return this.sessionHandle;
    }

    public void setSessionHandle(int i) {
        this.sessionHandle = i;
    }

    public long getDistance() {
        return this.distance;
    }

    public void setDistance(long j) {
        this.distance = j;
    }

    public int getAltitudeAoa() {
        return this.altitudeAoa;
    }

    public void setAltitudeAoa(int i) {
        this.altitudeAoa = i;
    }

    public int getAzimuthAoa() {
        return this.azimuthAoa;
    }

    public void setAzimuthAoa(int i) {
        this.azimuthAoa = i;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public long getPid() {
        return this.pid;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public void setAuthorization(int i) {
        this.authorization = i;
    }

    public TagState getTagState() {
        return this.tagState;
    }

    public void setTagState(TagState tagState2) {
        this.tagState = tagState2;
    }

    public String getIdmIdHash() {
        return this.idmIdHash;
    }

    public void setIdmIdHash(String str) {
        this.idmIdHash = str;
    }

    public DidInfo getDidInfo() {
        return this.didInfo;
    }

    public String getDid() {
        if (getDidInfo() == null) {
            return null;
        }
        return getDidInfo().getDid();
    }

    public void setDidInfo(DidInfo didInfo2) {
        this.didInfo = didInfo2;
    }

    public String getAccountInfo() {
        if (TextUtils.equals("000000", this.accountInfo)) {
            return "";
        }
        return this.accountInfo;
    }

    public void setAccountInfo(String str) {
        this.accountInfo = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getUwbAddress() {
        return this.uwbAddress;
    }

    public void setUwbAddress(String str) {
        this.uwbAddress = str;
    }

    public DeviceState getDeviceState() {
        return this.deviceState;
    }

    public void setDeviceState(DeviceState deviceState2) {
        this.deviceState = deviceState2;
    }

    public void setMiLinkSupport(int i) {
        this.miLinkSupport = i;
    }

    public UwbScanDevice() {
    }

    public boolean isHasTagState() {
        return this.hasTagState;
    }

    public void setHasTagState(boolean z) {
        this.hasTagState = z;
    }

    public String getAccountInfoPlain() {
        return this.accountInfoPlain;
    }

    public void setAccountInfoPlain(String str) {
        this.accountInfoPlain = str;
    }

    public void setIdmSupport(int i) {
        this.idmSupport = i;
    }

    public String getTvMacInfo() {
        return this.tvMacInfo;
    }

    public void setTvMacInfo(String str) {
        this.tvMacInfo = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sessionHandle);
        parcel.writeLong(this.distance);
        parcel.writeInt(this.altitudeAoa);
        parcel.writeInt(this.azimuthAoa);
        parcel.writeInt(this.rssi);
        parcel.writeInt(this.deviceType);
        parcel.writeLong(this.pid);
        parcel.writeInt(this.authorization);
        parcel.writeByte(this.hasTagState ? (byte) 1 : 0);
        parcel.writeParcelable(this.tagState, i);
        parcel.writeString(this.idmIdHash);
        parcel.writeParcelable(this.didInfo, i);
        parcel.writeString(this.accountInfo);
        parcel.writeString(this.accountInfoPlain);
        parcel.writeString(this.macAddress);
        parcel.writeString(this.uwbAddress);
        parcel.writeParcelable(this.deviceState, i);
        parcel.writeInt(this.miLinkSupport);
        parcel.writeInt(this.idmSupport);
        parcel.writeString(this.bleAddress);
        parcel.writeString(this.tvMacInfo);
    }

    public void readFromParcel(Parcel parcel) {
        this.sessionHandle = parcel.readInt();
        this.distance = parcel.readLong();
        this.altitudeAoa = parcel.readInt();
        this.azimuthAoa = parcel.readInt();
        this.rssi = parcel.readInt();
        this.deviceType = parcel.readInt();
        this.pid = parcel.readLong();
        this.authorization = parcel.readInt();
        this.hasTagState = parcel.readByte() != 0;
        this.tagState = (TagState) parcel.readParcelable(TagState.class.getClassLoader());
        this.idmIdHash = parcel.readString();
        this.didInfo = (DidInfo) parcel.readParcelable(DidInfo.class.getClassLoader());
        this.accountInfo = parcel.readString();
        this.accountInfoPlain = parcel.readString();
        this.macAddress = parcel.readString();
        this.uwbAddress = parcel.readString();
        this.deviceState = (DeviceState) parcel.readParcelable(DeviceState.class.getClassLoader());
        this.miLinkSupport = parcel.readInt();
        this.idmSupport = parcel.readInt();
        this.bleAddress = parcel.readString();
        this.tvMacInfo = parcel.readString();
    }

    protected UwbScanDevice(Parcel parcel) {
        this.sessionHandle = parcel.readInt();
        this.distance = parcel.readLong();
        this.altitudeAoa = parcel.readInt();
        this.azimuthAoa = parcel.readInt();
        this.rssi = parcel.readInt();
        this.deviceType = parcel.readInt();
        this.pid = parcel.readLong();
        this.authorization = parcel.readInt();
        this.hasTagState = parcel.readByte() != 0;
        this.tagState = (TagState) parcel.readParcelable(TagState.class.getClassLoader());
        this.idmIdHash = parcel.readString();
        this.didInfo = (DidInfo) parcel.readParcelable(DidInfo.class.getClassLoader());
        this.accountInfo = parcel.readString();
        this.accountInfoPlain = parcel.readString();
        this.macAddress = parcel.readString();
        this.uwbAddress = parcel.readString();
        this.deviceState = (DeviceState) parcel.readParcelable(DeviceState.class.getClassLoader());
        this.miLinkSupport = parcel.readInt();
        this.idmSupport = parcel.readInt();
        this.bleAddress = parcel.readString();
        this.tvMacInfo = parcel.readString();
    }

    public String getBleAddress() {
        return this.bleAddress;
    }

    public void setBleAddress(String str) {
        this.bleAddress = str;
    }

    public String toString() {
        return "UwbScanDevice{sessionHandle=" + this.sessionHandle + ", distance=" + this.distance + ", altitudeAoa=" + this.altitudeAoa + ", azimuthAoa=" + this.azimuthAoa + ", rssi=" + this.rssi + ", deviceType=" + this.deviceType + ", pid=" + this.pid + ", authorization=" + this.authorization + ", hasTagState=" + this.hasTagState + ", tagState=" + this.tagState + ", idmIdHash='" + this.idmIdHash + '\'' + ", didInfo=" + this.didInfo + ", accountInfo='" + this.accountInfo + '\'' + ", accountInfoPlain='" + this.accountInfoPlain + '\'' + ", macAddress='" + this.macAddress + '\'' + ", uwbAddress='" + this.uwbAddress + '\'' + ", deviceState=" + this.deviceState + ", miLinkSupport=" + this.miLinkSupport + ", idmSupport=" + this.idmSupport + ", bleAddress='" + this.bleAddress + '\'' + ", tvMacInfo='" + this.tvMacInfo + '\'' + "}\n\n";
    }
}
