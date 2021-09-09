package com.xiaomi.router.miio.miioplugin;

import _m_j.fml;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.DeviceStat;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceStatus implements Parcelable {
    public static final Parcelable.Creator<DeviceStatus> CREATOR = new Parcelable.Creator<DeviceStatus>() {
        /* class com.xiaomi.router.miio.miioplugin.DeviceStatus.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceStatus[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceStatus(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6611O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo;
    public long O0000o;
    public double O0000o0;
    public int O0000o00;
    public double O0000o0O;
    public String O0000o0o;
    public int O0000oO;
    public int O0000oO0;
    public boolean O0000oOO;
    public int O0000oOo;
    public String O0000oo;
    public String O0000oo0;
    public String O0000ooO;
    public JSONObject O0000ooo;
    @Deprecated
    public int O000O00o;
    public int O000O0OO;
    public String O000O0Oo;
    public int O000O0o;
    public int O000O0o0;
    public String O000O0oO;
    public String O000O0oo;
    public boolean O000OO00;
    public int O000OO0o;
    public int O00oOoOo;
    public String O00oOooO;
    public Bundle O00oOooo;

    public int describeContents() {
        return 0;
    }

    public DeviceStatus() {
        this.f6611O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000Ooo = "";
        this.O00oOooo = new Bundle();
        this.O000OO00 = true;
        this.O000OO0o = 0;
        this.f6611O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O000O0Oo = "";
    }

    public DeviceStatus(Parcel parcel) {
        this.f6611O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000Ooo = "";
        this.O00oOooo = new Bundle();
        this.O000OO00 = true;
        this.O000OO0o = 0;
        O000000o(parcel);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        String str = this.f6611O000000o;
        if (str != null) {
            return str.equals(deviceStatus.f6611O000000o);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Parcel parcel) {
        this.f6611O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readInt();
        this.O0000o0 = parcel.readDouble();
        this.O0000o0O = parcel.readDouble();
        this.O0000o0o = parcel.readString();
        this.O0000o = parcel.readLong();
        this.O0000oO0 = parcel.readInt();
        this.O0000oO = parcel.readInt();
        boolean z = true;
        this.O0000oOO = parcel.readInt() != 0;
        this.O0000oOo = parcel.readInt();
        this.O0000oo0 = parcel.readString();
        this.O0000oo = parcel.readString();
        this.O0000ooO = parcel.readString();
        String readString = parcel.readString();
        this.O0000ooo = null;
        if (!TextUtils.isEmpty(readString)) {
            try {
                this.O0000ooo = new JSONObject(readString);
            } catch (JSONException unused) {
            }
        }
        this.O00oOooO = parcel.readString();
        this.O00oOooo = parcel.readBundle();
        this.O000O00o = parcel.readInt();
        this.O000O0OO = parcel.readInt();
        this.O000O0Oo = parcel.readString();
        this.O00oOoOo = parcel.readInt();
        this.O000O0o0 = parcel.readInt();
        this.O000O0o = parcel.readInt();
        this.O000O0oo = parcel.readString();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.O000OO00 = z;
        this.O000OO0o = parcel.readInt();
        this.O000O0oO = parcel.readString();
    }

    public int hashCode() {
        return this.f6611O000000o.hashCode();
    }

    private static void O000000o(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        O000000o(this.f6611O000000o, parcel);
        O000000o(this.O00000Oo, parcel);
        O000000o(this.O00000o0, parcel);
        O000000o(this.O00000o, parcel);
        O000000o(this.O00000oO, parcel);
        O000000o(this.O00000oo, parcel);
        O000000o(this.O0000O0o, parcel);
        O000000o(this.O0000OOo, parcel);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        O000000o(this.O0000OoO, parcel);
        O000000o(this.O0000Ooo, parcel);
        parcel.writeInt(this.O0000o00);
        parcel.writeDouble(this.O0000o0);
        parcel.writeDouble(this.O0000o0O);
        O000000o(this.O0000o0o, parcel);
        parcel.writeLong(this.O0000o);
        parcel.writeInt(this.O0000oO0);
        parcel.writeInt(this.O0000oO);
        parcel.writeInt(this.O0000oOO ? 1 : 0);
        parcel.writeInt(this.O0000oOo);
        O000000o(this.O0000oo0, parcel);
        O000000o(this.O0000oo, parcel);
        O000000o(this.O0000ooO, parcel);
        JSONObject jSONObject = this.O0000ooo;
        if (jSONObject == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(jSONObject.toString());
        }
        O000000o(this.O00oOooO, parcel);
        if (this.O00oOooo == null) {
            this.O00oOooo = new Bundle();
        }
        parcel.writeBundle(this.O00oOooo);
        parcel.writeInt(this.O000O00o);
        parcel.writeInt(this.O000O0OO);
        O000000o(this.O000O0Oo, parcel);
        parcel.writeInt(this.O00oOoOo);
        parcel.writeInt(this.O000O0o0);
        parcel.writeInt(this.O000O0o);
        O000000o(this.O000O0oo, parcel);
        parcel.writeInt(this.O000OO00 ? 1 : 0);
        parcel.writeInt(this.O000OO0o);
        O000000o(this.O000O0oO, parcel);
    }

    public final DeviceStat O000000o() {
        DeviceStat deviceStat = new DeviceStat();
        deviceStat.did = this.f6611O000000o;
        deviceStat.name = this.O00000Oo;
        deviceStat.mac = this.O00000o0;
        deviceStat.model = this.O00000o;
        deviceStat.extrainfo = this.O00000oO;
        deviceStat.ip = this.O00000oo;
        deviceStat.parentId = this.O0000O0o;
        deviceStat.parentModel = this.O0000OOo;
        deviceStat.bindFlag = this.O0000Oo0;
        deviceStat.authFlag = this.O0000Oo;
        deviceStat.token = this.O0000OoO;
        deviceStat.userId = this.O0000Ooo;
        deviceStat.location = this.O0000o00;
        deviceStat.latitude = this.O0000o0;
        deviceStat.longitude = this.O0000o0O;
        deviceStat.bssid = this.O0000o0o;
        deviceStat.lastModified = this.O0000o;
        deviceStat.pid = this.O0000oO0;
        deviceStat.rssi = this.O0000oO;
        deviceStat.isOnline = this.O0000oOO;
        deviceStat.resetFlag = this.O0000oOo;
        deviceStat.ssid = this.O0000oo0;
        deviceStat.ownerName = this.O0000oo;
        deviceStat.ownerId = this.O0000ooO;
        deviceStat.propInfo = this.O0000ooo;
        deviceStat.version = this.O00oOooO;
        deviceStat.property = new Bundle();
        deviceStat.property.putAll(this.O00oOooo);
        deviceStat.showMode = this.O000O00o;
        deviceStat.hideMode = this.O000O0OO;
        deviceStat.event = this.O000O0Oo;
        deviceStat.permitLevel = this.O00oOoOo;
        deviceStat.isSetPinCode = this.O000O0o0;
        deviceStat.pinCodeType = this.O000O0o;
        deviceStat.deviceIconReal = fml.O00000o0(this.O00000o);
        deviceStat.freqFlag = this.O000OO00;
        deviceStat.comFlag = this.O000OO0o;
        deviceStat.orderTimeJString = this.O000O0oO;
        return deviceStat;
    }

    public String toString() {
        return "did:" + this.f6611O000000o + " name:" + this.O00000Oo + " mac:" + this.O00000o0 + " model:" + this.O00000o + " extrainfo:" + this.O00000oO + " ip:" + this.O00000oo + " parentId:" + this.O0000O0o + " parentModel:" + this.O0000OOo + " property:" + this.O00oOooo + " ownerName:" + this.O0000oo + " event:" + this.O000O0Oo + " freqFlag:" + this.O000OO00 + " comFlag:" + this.O000OO0o;
    }
}
