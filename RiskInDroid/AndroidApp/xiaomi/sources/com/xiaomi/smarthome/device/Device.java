package com.xiaomi.smarthome.device;

import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        /* class com.xiaomi.smarthome.device.Device.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Device[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }
    };
    public static int HIDE_MODE_HIDE_MAIN_LIST = 1;
    public static int HIDE_MODE_SHOW_MAIN_LIST = 0;
    private static int PERMISSION_AGGREGATE = 64;
    private static int PERMISSION_FAMILY = 8;
    private static int PERMISSION_NONE = 65296;
    private static int PERMISSION_NONE_MASK = 30;
    private static int PERMISSION_OWNER = 16;
    private static int PERMISSION_SHARE = 4;
    private static int PERMISSION_SHARE_READONLY = 32;
    public static int PID_BLE_MESH = 16;
    public static int PID_BLUETOOTH = 6;
    public static int PID_CLOUD = 2;
    public static int PID_IR_CONTROL = 15;
    public static int PID_MIIO = 0;
    public static int PID_NBIOT = 13;
    public static int PID_SUBDEVICE = 3;
    public static int PID_VIRTUAL_DEVICE = 5;
    public static int PID_VIRTUAL_GROUP = 17;
    public static int PID_WEBSOCKET = 4;
    public static int PID_YUNYI = 1;
    public static int SHOW_HIDDEN;
    public String bssid;
    public boolean canAuth;
    public boolean canUseNotBind;
    public int comFlag;
    public String desc;
    public String descNew;
    public String descTimeJString;
    public String did;
    public String event;
    public String extra;
    public String extraToken;
    public boolean freqFlag;
    public int hideMode;
    public String ip;
    public boolean isConnected;
    public boolean isNew;
    public boolean isOnline;
    public int isSetPinCode;
    private String keyId;
    public long lastModified;
    public double latitude;
    private String localIP;
    public Location location;
    public double longitude;
    private String mPropInfo;
    public String mac;
    public JSONArray method;
    private String methodInfo;
    public String model;
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
    public ScanResult scanResult;
    public boolean scrollTo;
    @Deprecated
    public int showMode;
    public int sort;
    public String specUrn;
    public String ssid;
    public String token;
    public String userId;
    public String version;
    public byte voiceCtrl;

    public int describeContents() {
        return 0;
    }

    public boolean hasShortcut() {
        return true;
    }

    public boolean isOpen() {
        return true;
    }

    public void parseEvent(String str) {
    }

    public void parseExtra(String str) {
    }

    public void parseProp() {
    }

    public void setLaunchParams(Intent intent) {
    }

    public enum Location implements Parcelable {
        UNKNOWN,
        LOCAL,
        REMOTE;
        
        public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
            /* class com.xiaomi.smarthome.device.Device.Location.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Location[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return Location.values()[parcel.readInt()];
            }
        };

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }
    }

    public Device() {
        this.userId = "";
        this.isOnline = true;
        this.canAuth = true;
        this.canUseNotBind = false;
        this.isConnected = true;
        this.property = new Bundle();
        this.extraToken = "";
        this.scrollTo = false;
        this.orderTimeJString = "";
        this.keyId = "";
        this.freqFlag = true;
        this.comFlag = 0;
    }

    protected Device(String str, String str2) {
        this.userId = "";
        this.isOnline = true;
        this.canAuth = true;
        this.canUseNotBind = false;
        this.isConnected = true;
        this.property = new Bundle();
        this.extraToken = "";
        this.scrollTo = false;
        this.orderTimeJString = "";
        this.keyId = "";
        this.freqFlag = true;
        this.comFlag = 0;
        this.did = str;
        this.model = str2;
    }

    public void parseFromJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.did = jSONObject.optString("did");
            this.model = jSONObject.optString("model");
            this.name = jSONObject.optString("name");
            this.mac = jSONObject.optString("mac");
            this.isOnline = jSONObject.optBoolean("isOnline");
            this.pid = jSONObject.optInt("pid");
            this.permitLevel = jSONObject.optInt("permitLevel");
            this.resetFlag = jSONObject.optInt("resetFlag");
            this.rssi = jSONObject.optInt("rssi", 0);
            this.token = jSONObject.optString("token");
            this.localIP = jSONObject.optString("localip");
            this.longitude = jSONObject.optDouble("longitude");
            this.latitude = jSONObject.optDouble("latitude");
            this.ssid = jSONObject.optString("ssid");
            this.bssid = jSONObject.optString("bssid");
            this.showMode = jSONObject.optInt("show_mode");
            this.hideMode = jSONObject.optInt("hide_mode");
            this.desc = jSONObject.optString("desc");
            this.parentId = jSONObject.optString("parent_id");
            this.parentModel = jSONObject.optString("parent_model");
            JSONObject optJSONObject = jSONObject.optJSONObject("owner");
            if (optJSONObject != null) {
                this.ownerName = optJSONObject.optString("nickname");
                this.ownerId = optJSONObject.optString("userid");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("prop");
            if (optJSONObject2 != null) {
                this.propInfo = optJSONObject2;
                this.mPropInfo = optJSONObject2.toString();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("method");
            if (optJSONArray != null) {
                this.method = optJSONArray;
                this.methodInfo = optJSONArray.toString();
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("extra");
            if (optJSONObject3 != null) {
                this.extra = optJSONObject3.toString();
                this.isSetPinCode = optJSONObject3.optInt("isSetPincode");
                this.pinCodeType = optJSONObject3.optInt("pincodeType");
                this.keyId = optJSONObject3.optString("keyid");
                this.version = optJSONObject3.optString("fw_version");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("event");
            if (optJSONObject4 != null) {
                this.event = optJSONObject4.toString();
            }
            this.descNew = jSONObject.optString("desc_new");
            this.specUrn = jSONObject.optString("spec_type");
            this.voiceCtrl = (byte) jSONObject.optInt("voice_ctrl");
            this.freqFlag = jSONObject.optBoolean("freqFlag", true);
            this.comFlag = jSONObject.optInt("comFlag", 0);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("desc_time");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.descTimeJString = optJSONArray2.toString();
            }
            this.orderTimeJString = jSONObject.optString("orderTime", "");
        }
    }

    public void parseDBExtra() {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                JSONObject jSONObject = new JSONObject(this.extra);
                this.isSetPinCode = jSONObject.optInt("isSetPincode");
                this.pinCodeType = jSONObject.optInt("pincodeType");
                this.keyId = jSONObject.optString("keyid");
                this.version = jSONObject.optString("fw_version");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDBExtraInfo() {
        return this.extra;
    }

    public synchronized String getDid() {
        return this.did;
    }

    public synchronized void setDid(String str) {
        this.did = str;
    }

    public synchronized String getModel() {
        return this.model;
    }

    public synchronized void setModel(String str) {
        this.model = str;
    }

    public synchronized void setName(String str) {
        this.name = str;
    }

    public synchronized String getMac() {
        return this.mac;
    }

    public synchronized void setMac(String str) {
        this.mac = str;
    }

    public synchronized boolean isOnline() {
        return this.isOnline;
    }

    public synchronized void toggleOnline(boolean z) {
        this.isOnline = z;
    }

    public synchronized int getPid() {
        return this.pid;
    }

    public synchronized void setPid(int i) {
        this.pid = i;
    }

    public synchronized int getPermitLevel() {
        return this.permitLevel;
    }

    public synchronized void setPermitLevel(int i) {
        this.permitLevel = i;
    }

    public synchronized int getResetFlag() {
        return this.resetFlag;
    }

    public synchronized void setResetFlag(int i) {
        this.resetFlag = i;
    }

    public synchronized int getRssi() {
        return this.rssi;
    }

    public synchronized void setRssi(int i) {
        this.rssi = i;
    }

    public synchronized String getToken() {
        return this.token;
    }

    public synchronized void setToken(String str) {
        this.token = str;
    }

    public synchronized String getLocalIP() {
        return this.localIP;
    }

    public synchronized void setLocalIP(String str) {
        this.localIP = str;
    }

    public synchronized double getLongitude() {
        return this.longitude;
    }

    public synchronized void setLongitude(double d) {
        this.longitude = d;
    }

    public synchronized double getLatitude() {
        return this.latitude;
    }

    public synchronized void setLatitude(double d) {
        this.latitude = d;
    }

    public synchronized String getSsid() {
        return this.ssid;
    }

    public synchronized void setSsid(String str) {
        this.ssid = str;
    }

    public synchronized String getBssid() {
        return this.bssid;
    }

    public synchronized void setBssid(String str) {
        this.bssid = str;
    }

    public synchronized int getShowMode() {
        return this.showMode;
    }

    public synchronized void setShowMode(int i) {
        this.showMode = i;
    }

    public synchronized int getHideMode() {
        return this.hideMode;
    }

    public synchronized void setHideMode(int i) {
        this.hideMode = i;
    }

    public synchronized String getDesc() {
        return this.desc;
    }

    public synchronized void setDesc(String str) {
        this.desc = str;
    }

    public synchronized String getParentId() {
        return this.parentId;
    }

    public synchronized void setParentId(String str) {
        this.parentId = str;
    }

    public synchronized String getParentModel() {
        return this.parentModel;
    }

    public synchronized void setParentModel(String str) {
        this.parentModel = str;
    }

    public synchronized String getOwnerName() {
        return this.ownerName;
    }

    public synchronized void setOwnerName(String str) {
        this.ownerName = str;
    }

    public synchronized String getOwnerId() {
        return this.ownerId;
    }

    public synchronized void setOwnerId(String str) {
        this.ownerId = str;
    }

    public synchronized String getPropInfo() {
        return this.mPropInfo;
    }

    public synchronized void setPropInfo(String str) {
        this.mPropInfo = str;
    }

    public synchronized String getMethodInfo() {
        return this.methodInfo;
    }

    public synchronized void setMethodInfo(String str) {
        this.methodInfo = str;
    }

    public synchronized String getExtraInfo() {
        return this.extra;
    }

    public synchronized void setExtraInfo(String str) {
        this.extra = str;
    }

    public synchronized String getEventInfo() {
        return this.event;
    }

    public synchronized void setEventInfo(String str) {
        this.event = str;
    }

    public synchronized Location getLocation() {
        return this.location;
    }

    public synchronized void setLocation(Location location2) {
        this.location = location2;
    }

    public synchronized String getVersion() {
        return this.version;
    }

    public synchronized void setVersion(String str) {
        this.version = str;
    }

    public synchronized boolean canUseNotBind() {
        return this.canUseNotBind;
    }

    public synchronized void toggleCanUseNotBind(boolean z) {
        this.canUseNotBind = z;
    }

    public synchronized boolean canAuth() {
        return this.canAuth;
    }

    public synchronized void toggleCanAuth(boolean z) {
        this.canAuth = z;
    }

    public synchronized void setPinCodeOpen(int i) {
        this.isSetPinCode = i;
    }

    public synchronized int isSetPinCode() {
        return this.isSetPinCode;
    }

    public String getmDescTimeJString() {
        return this.descTimeJString;
    }

    public void setmDescTimeJString(String str) {
        this.descTimeJString = str;
    }

    public synchronized String getDescNew() {
        return this.descNew;
    }

    public synchronized void setDescNew(String str) {
        this.descNew = str;
    }

    public synchronized String getSpecUrn() {
        return this.specUrn;
    }

    public void setSpecUrn(String str) {
        this.specUrn = str;
    }

    public byte getVoiceCtrl() {
        return this.voiceCtrl;
    }

    public void setVoiceCtrl(byte b) {
        this.voiceCtrl = b;
    }

    public boolean getFreqFlag() {
        return this.freqFlag;
    }

    public void setFreqFlag(boolean z) {
        this.freqFlag = z;
    }

    public int getComFlag() {
        return this.comFlag;
    }

    public void setComFlag(int i) {
        this.comFlag = i;
    }

    public synchronized String getKeyId() {
        return this.keyId;
    }

    public synchronized void setKeyId(String str) {
        this.keyId = str;
    }

    public String getOrderTimeJString() {
        return this.orderTimeJString;
    }

    public void initialLocal() {
        this.location = Location.REMOTE;
    }

    public boolean isOwner() {
        return ((this.permitLevel & PERMISSION_NONE_MASK) & PERMISSION_OWNER) != 0;
    }

    public void setOwner(boolean z) {
        this.permitLevel &= PERMISSION_NONE_MASK ^ -1;
        if (z) {
            this.permitLevel |= PERMISSION_OWNER;
        } else {
            this.permitLevel &= PERMISSION_OWNER ^ -1;
        }
    }

    public boolean isFamily() {
        return ((this.permitLevel & PERMISSION_NONE_MASK) & PERMISSION_FAMILY) != 0;
    }

    public void setFamily(boolean z) {
        this.permitLevel &= PERMISSION_NONE_MASK ^ -1;
        if (z) {
            this.permitLevel |= PERMISSION_FAMILY;
        } else {
            this.permitLevel &= PERMISSION_FAMILY ^ -1;
        }
    }

    public void setShared(boolean z) {
        this.permitLevel &= PERMISSION_NONE_MASK ^ -1;
        if (!this.canAuth || !z || TextUtils.isEmpty(this.ownerName)) {
            this.permitLevel &= PERMISSION_SHARE ^ -1;
        } else {
            this.permitLevel |= PERMISSION_SHARE;
        }
    }

    public boolean isShared() {
        return this.canAuth && (this.permitLevel & PERMISSION_SHARE) != 0 && !TextUtils.isEmpty(this.ownerName);
    }

    public boolean isHomeShared() {
        int i = this.permitLevel;
        return ((PERMISSION_SHARE & i) == 0 || (i & PERMISSION_AGGREGATE) == 0) ? false : true;
    }

    public boolean isBinded() {
        return (this.permitLevel & PERMISSION_NONE_MASK) != 0;
    }

    public boolean isMiioBinded() {
        if (((this.permitLevel & PERMISSION_SHARE) == 0 || !TextUtils.isEmpty(this.ownerName)) && (this.permitLevel & PERMISSION_NONE_MASK) != 0) {
            return true;
        }
        return false;
    }

    public boolean isSharedReadOnly() {
        return this.canAuth && (this.permitLevel & PERMISSION_SHARE_READONLY) != 0 && !TextUtils.isEmpty(this.ownerName);
    }

    public void setUnbind() {
        this.permitLevel &= PERMISSION_NONE_MASK ^ -1;
    }

    public boolean isSubDevice() {
        return !TextUtils.isEmpty(this.parentId);
    }

    @Deprecated
    public boolean isShowMainList() {
        return this.showMode > SHOW_HIDDEN;
    }

    public boolean isHideMainList() {
        return this.hideMode != SHOW_HIDDEN;
    }

    public String getExtraToken() {
        return this.extraToken;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        String str = this.did;
        if (str == null || !str.equals(device.did)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return TextUtils.isEmpty(this.did) ? super.hashCode() : this.did.hashCode();
    }

    public String getName() {
        if (TextUtils.isEmpty(this.name)) {
            return this.did;
        }
        return this.name;
    }

    public boolean isVirtualDevice() {
        return this.pid == PID_VIRTUAL_DEVICE;
    }

    public boolean isOnlineAdvance() {
        return this.isOnline;
    }

    public boolean isSameDevice(Device device) {
        if (device != null) {
            return TextUtils.equals(getDid(), device.getDid());
        }
        return false;
    }

    public synchronized void setPinCodeType(int i) {
        this.pinCodeType = i;
    }

    public synchronized int getPinCodeType() {
        return this.pinCodeType;
    }

    public boolean isLocal() {
        return this.location == Location.LOCAL;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Device{did='");
        String str2 = this.did;
        if (str2 == null) {
            str = "";
        } else {
            str = Base64.encodeToString(str2.getBytes(), 0);
        }
        sb.append(str);
        sb.append('\'');
        sb.append(", model='");
        sb.append(this.model);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", mac='");
        sb.append(this.mac);
        sb.append('\'');
        sb.append(", isOnline=");
        sb.append(this.isOnline);
        sb.append(", pid=");
        sb.append(this.pid);
        sb.append(", permitLevel=");
        sb.append(this.permitLevel);
        sb.append(", resetFlag=");
        sb.append(this.resetFlag);
        sb.append(", rssi=");
        sb.append(this.rssi);
        sb.append(", token='");
        sb.append(this.token);
        sb.append('\'');
        sb.append(", localIP='");
        sb.append(this.localIP);
        sb.append('\'');
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", ssid='");
        sb.append(this.ssid);
        sb.append('\'');
        sb.append(", bssid='");
        sb.append(this.bssid);
        sb.append('\'');
        sb.append(", showMode=");
        sb.append(this.showMode);
        sb.append(", hideMode=");
        sb.append(this.hideMode);
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", parentId='");
        sb.append(this.parentId);
        sb.append('\'');
        sb.append(", parentModel='");
        sb.append(this.parentModel);
        sb.append('\'');
        sb.append(", ownerName='");
        sb.append(this.ownerName);
        sb.append('\'');
        sb.append(", ownerId='");
        sb.append(this.ownerId);
        sb.append('\'');
        sb.append(", propInfo='");
        sb.append(this.mPropInfo);
        sb.append('\'');
        sb.append(", methodInfo='");
        sb.append(this.methodInfo);
        sb.append('\'');
        sb.append(", extraInfo='");
        sb.append(this.extra);
        sb.append('\'');
        sb.append(", eventInfo='");
        sb.append(this.event);
        sb.append('\'');
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", isSetPinCode=");
        sb.append(this.isSetPinCode);
        sb.append(", mPinCodeType=");
        sb.append(this.pinCodeType);
        sb.append(", canUseNotBind=");
        sb.append(this.canUseNotBind);
        sb.append(", canAuth=");
        sb.append(this.canAuth);
        sb.append(", descNew='");
        sb.append(this.descNew);
        sb.append('\'');
        sb.append(", descTimeJString='");
        sb.append(this.descTimeJString);
        sb.append('\'');
        sb.append(", keyId='");
        sb.append(this.keyId);
        sb.append('\'');
        sb.append(", specUrn='");
        sb.append(this.specUrn);
        sb.append('\'');
        sb.append(", voiceCtrl='");
        sb.append((int) this.voiceCtrl);
        sb.append('\'');
        sb.append(", freqFlag='");
        sb.append(this.freqFlag);
        sb.append('\'');
        sb.append(", comFlag='");
        sb.append(this.comFlag);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.did);
        parcel.writeString(this.model);
        parcel.writeString(this.name);
        parcel.writeString(this.mac);
        parcel.writeByte(this.isOnline ? (byte) 1 : 0);
        parcel.writeInt(this.pid);
        parcel.writeInt(this.permitLevel);
        parcel.writeInt(this.resetFlag);
        parcel.writeInt(this.rssi);
        parcel.writeString(this.token);
        parcel.writeString(this.localIP);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.ssid);
        parcel.writeString(this.bssid);
        parcel.writeInt(this.showMode);
        parcel.writeInt(this.hideMode);
        parcel.writeString(this.desc);
        parcel.writeString(this.parentId);
        parcel.writeString(this.parentModel);
        parcel.writeString(this.ownerName);
        parcel.writeString(this.ownerId);
        parcel.writeString(this.mPropInfo);
        parcel.writeString(this.methodInfo);
        parcel.writeString(this.extra);
        parcel.writeString(this.event);
        Location location2 = this.location;
        parcel.writeInt(location2 == null ? -1 : location2.ordinal());
        parcel.writeString(this.version);
        parcel.writeInt(this.isSetPinCode);
        parcel.writeInt(this.pinCodeType);
        parcel.writeByte(this.canUseNotBind ? (byte) 1 : 0);
        parcel.writeByte(this.canAuth ? (byte) 1 : 0);
        parcel.writeString(this.descNew);
        parcel.writeString(this.descTimeJString);
        parcel.writeString(this.keyId);
        parcel.writeString(this.specUrn);
        parcel.writeByte(this.voiceCtrl);
        parcel.writeByte(this.freqFlag ? (byte) 1 : 0);
        parcel.writeInt(this.comFlag);
        parcel.writeString(this.orderTimeJString);
    }

    protected Device(Parcel parcel) {
        Location location2;
        this.userId = "";
        boolean z = true;
        this.isOnline = true;
        this.canAuth = true;
        this.canUseNotBind = false;
        this.isConnected = true;
        this.property = new Bundle();
        this.extraToken = "";
        this.scrollTo = false;
        this.orderTimeJString = "";
        this.keyId = "";
        this.freqFlag = true;
        this.comFlag = 0;
        this.did = parcel.readString();
        this.model = parcel.readString();
        this.name = parcel.readString();
        this.mac = parcel.readString();
        this.isOnline = parcel.readByte() != 0;
        this.pid = parcel.readInt();
        this.permitLevel = parcel.readInt();
        this.resetFlag = parcel.readInt();
        this.rssi = parcel.readInt();
        this.token = parcel.readString();
        this.localIP = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.ssid = parcel.readString();
        this.bssid = parcel.readString();
        this.showMode = parcel.readInt();
        this.hideMode = parcel.readInt();
        this.desc = parcel.readString();
        this.parentId = parcel.readString();
        this.parentModel = parcel.readString();
        this.ownerName = parcel.readString();
        this.ownerId = parcel.readString();
        this.mPropInfo = parcel.readString();
        this.methodInfo = parcel.readString();
        this.extra = parcel.readString();
        this.event = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            location2 = null;
        } else {
            location2 = Location.values()[readInt];
        }
        this.location = location2;
        this.version = parcel.readString();
        this.isSetPinCode = parcel.readInt();
        this.pinCodeType = parcel.readInt();
        this.canUseNotBind = parcel.readByte() != 0;
        this.canAuth = parcel.readByte() != 0;
        this.descNew = parcel.readString();
        this.descTimeJString = parcel.readString();
        this.keyId = parcel.readString();
        this.specUrn = parcel.readString();
        this.voiceCtrl = parcel.readByte();
        this.freqFlag = parcel.readByte() == 0 ? false : z;
        this.comFlag = parcel.readInt();
        this.orderTimeJString = parcel.readString();
    }

    public Device clone() {
        Device device = new Device();
        cloneTo(device);
        return device;
    }

    public void cloneTo(Device device) {
        device.did = this.did;
        device.token = this.token;
        device.name = this.name;
        device.userId = this.userId;
        device.model = this.model;
        device.location = this.location;
        device.latitude = this.latitude;
        device.longitude = this.longitude;
        device.bssid = this.bssid;
        device.ssid = this.ssid;
        device.showMode = this.showMode;
        device.hideMode = this.hideMode;
        device.pid = this.pid;
        device.rssi = this.rssi;
        device.resetFlag = this.resetFlag;
        device.permitLevel = this.permitLevel;
        device.isSetPinCode = this.isSetPinCode;
        device.pinCodeType = this.pinCodeType;
        device.sort = this.sort;
        device.lastModified = this.lastModified;
        device.parentId = this.parentId;
        device.parentModel = this.parentModel;
        device.ip = this.ip;
        device.mac = this.mac;
        device.ownerName = this.ownerName;
        device.ownerId = this.ownerId;
        device.extra = this.extra;
        device.event = this.event;
        device.extraToken = this.extraToken;
        device.desc = this.desc;
        device.version = this.version;
        device.descNew = this.descNew;
        device.descTimeJString = this.descTimeJString;
        device.isNew = this.isNew;
        device.isOnline = this.isOnline;
        device.scrollTo = this.scrollTo;
        device.canAuth = this.canAuth;
        device.canUseNotBind = this.canUseNotBind;
        device.isConnected = this.isConnected;
        device.propInfo = this.propInfo;
        device.method = this.method;
        device.scanResult = this.scanResult;
        device.specUrn = this.specUrn;
        device.voiceCtrl = this.voiceCtrl;
        device.freqFlag = this.freqFlag;
        device.comFlag = this.comFlag;
        device.property.clear();
        device.property.putAll(this.property);
    }

    public void set(Device device) {
        this.did = device.did;
        this.model = device.model;
        this.name = device.name;
        this.mac = device.mac;
        this.isOnline = device.isOnline;
        this.pid = device.pid;
        this.permitLevel = device.permitLevel;
        this.resetFlag = device.resetFlag;
        this.rssi = device.rssi;
        this.token = device.token;
        this.localIP = device.localIP;
        this.longitude = device.longitude;
        this.latitude = device.latitude;
        this.ssid = device.ssid;
        this.bssid = device.bssid;
        this.showMode = device.showMode;
        this.hideMode = device.hideMode;
        this.desc = device.desc;
        this.parentId = device.parentId;
        this.parentModel = device.parentModel;
        this.ownerName = device.ownerName;
        this.ownerId = device.ownerId;
        this.mPropInfo = device.mPropInfo;
        this.methodInfo = device.methodInfo;
        this.extra = device.extra;
        this.event = device.event;
        this.location = device.location;
        this.version = device.version;
        this.isSetPinCode = device.isSetPinCode;
        this.pinCodeType = device.pinCodeType;
        this.canUseNotBind = device.canUseNotBind;
        this.canAuth = device.canAuth;
        this.descNew = device.descNew;
        this.descTimeJString = device.descTimeJString;
        this.keyId = device.keyId;
        this.specUrn = device.specUrn;
        this.voiceCtrl = device.voiceCtrl;
        this.freqFlag = device.freqFlag;
        this.comFlag = device.comFlag;
    }
}
