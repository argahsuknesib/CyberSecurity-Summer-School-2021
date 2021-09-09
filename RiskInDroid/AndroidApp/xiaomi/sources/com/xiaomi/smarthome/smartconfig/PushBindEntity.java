package com.xiaomi.smarthome.smartconfig;

import _m_j.fml;
import _m_j.gsy;
import _m_j.hhc;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PushBindEntity implements Parcelable {
    public static final Parcelable.Creator<PushBindEntity> CREATOR = new Parcelable.Creator<PushBindEntity>() {
        /* class com.xiaomi.smarthome.smartconfig.PushBindEntity.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PushBindEntity[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PushBindEntity(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final PluginDeviceInfo f11457O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public final String O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public boolean O0000OoO;
    public final String O0000Ooo;
    private byte O0000o0;
    private final String O0000o00;

    public int describeContents() {
        return 0;
    }

    private PushBindEntity(PluginDeviceInfo pluginDeviceInfo, JSONObject jSONObject) {
        this.f11457O000000o = pluginDeviceInfo;
        this.O00000Oo = jSONObject.optString("router_did");
        this.O00000o0 = jSONObject.optString("ssid");
        if (jSONObject.has("bssid")) {
            this.O00000o = jSONObject.optString("bssid");
        } else {
            this.O00000o = jSONObject.optString("mac");
        }
        this.O00000oo = jSONObject.optString("router_bssid");
        this.O00000oO = jSONObject.optString("router_ssid");
        this.O0000o00 = jSONObject.optString("rssi");
        this.O0000O0o = jSONObject.optString("did");
        this.O0000OOo = jSONObject.optString("model");
        this.O0000Oo0 = jSONObject.optString("public_key");
        this.O0000Oo = jSONObject.optString("token");
        String optString = jSONObject.optString("sn");
        if (TextUtils.isEmpty(optString) || optString.length() <= 4) {
            this.O0000Ooo = "";
        } else {
            this.O0000Ooo = optString.substring(optString.length() - 4);
        }
    }

    protected PushBindEntity(Parcel parcel) {
        this.f11457O000000o = (PluginDeviceInfo) parcel.readParcelable(PluginDeviceInfo.class.getClassLoader());
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readByte();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readInt() != 1 ? false : true;
        this.O0000Ooo = parcel.readString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if ((r1 != null && r1.O00000o() == 3) != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        if (r7 == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        _m_j.gsy.O00000Oo(com.xiaomi.smarthome.library.log.LogType.PUSH, "DevicePushBindManager", "PushBindEntity.create null pluginrecord json:".concat(java.lang.String.valueOf(r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        return null;
     */
    public static PushBindEntity O000000o(JSONObject jSONObject, boolean z) {
        String optString = jSONObject.optString("model");
        if (TextUtils.isEmpty(optString)) {
            optString = DeviceFactory.O0000Ooo(jSONObject.optString("ssid"));
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(optString);
        if (z) {
            return new PushBindEntity(O00000oO2, jSONObject).O000000o(true).O00000oo();
        }
        if (!fml.O000000o(O00000oO2)) {
            boolean z2 = false;
            if (!(O00000oO2 != null && O00000oO2.O00000o() == 0)) {
            }
            if (!TextUtils.isEmpty(optString)) {
                z2 = Pattern.matches(".+\\.camera\\..+", optString);
            }
        }
        gsy.O000000o(4, "DevicePushBindManager", "PushBindEntity.create pluginrecord model:".concat(String.valueOf(optString)));
        return new PushBindEntity(O00000oO2, jSONObject).O000000o(true).O00000oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    private PushBindEntity O00000oo() {
        int O000000o2 = hhc.O000000o((Object) this.O0000o00, 0);
        if (O000000o2 > -60) {
            return this;
        }
        gsy.O00000Oo(LogType.PUSH, "DevicePushBindManager", "PushBindEntity checkRssi rssi:".concat(String.valueOf(O000000o2)));
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11457O000000o, i);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000o00);
        parcel.writeByte(this.O0000o0);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeInt(this.O0000OoO ? 1 : 0);
        parcel.writeString(this.O0000Ooo);
    }

    public final void O000000o() {
        this.O0000o0 = (byte) (this.O0000o0 | 1);
    }

    public final void O00000Oo() {
        this.O0000o0 = (byte) (this.O0000o0 | 2);
    }

    public final PushBindEntity O000000o(boolean z) {
        if (z) {
            this.O0000o0 = (byte) (this.O0000o0 & -5);
        } else {
            this.O0000o0 = (byte) (this.O0000o0 | 4);
        }
        return this;
    }

    public final boolean O00000o0() {
        return (this.O0000o0 & 1) != 0;
    }

    public final boolean O00000o() {
        return (this.O0000o0 & 2) != 0;
    }

    public final boolean O00000oO() {
        return (this.O0000o0 & 4) != 4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PushBindEntity) {
            PushBindEntity pushBindEntity = (PushBindEntity) obj;
            if (!TextUtils.equals(this.O00000o0, pushBindEntity.O00000o0) || !TextUtils.equals(this.O00000o, pushBindEntity.O00000o) || !TextUtils.equals(this.O00000oO, pushBindEntity.O00000oO) || !TextUtils.equals(this.O00000oo, pushBindEntity.O00000oo)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return "PushBindEntity{routerDid='" + this.O00000Oo + '\'' + ", ssid='" + this.O00000o0 + '\'' + ", bssid='" + this.O00000o + '\'' + ", model='" + this.f11457O000000o.O00000Oo() + '\'' + ", routerSsid='" + this.O00000oO + '\'' + ", routerBssid='" + this.O00000oo + '\'' + ", rssi='" + this.O0000o00 + '\'' + ", sn='" + this.O0000Ooo + '\'' + ", isHideSsid=" + this.O0000OoO + '\'' + '}';
    }
}
