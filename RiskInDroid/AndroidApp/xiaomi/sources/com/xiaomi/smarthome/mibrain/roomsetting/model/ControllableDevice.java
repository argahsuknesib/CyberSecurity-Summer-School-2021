package com.xiaomi.smarthome.mibrain.roomsetting.model;

import _m_j.fno;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import org.json.JSONObject;

public class ControllableDevice implements Parcelable {
    public static final Parcelable.Creator<ControllableDevice> CREATOR = new Parcelable.Creator<ControllableDevice>() {
        /* class com.xiaomi.smarthome.mibrain.roomsetting.model.ControllableDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ControllableDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ControllableDevice(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9511O000000o;
    public String O00000Oo;
    private String O00000o0;

    public int describeContents() {
        return 0;
    }

    public ControllableDevice() {
    }

    public static ControllableDevice O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ControllableDevice controllableDevice = new ControllableDevice();
        controllableDevice.f9511O000000o = jSONObject.optString("did");
        controllableDevice.O00000Oo = jSONObject.optString("desc");
        controllableDevice.O00000o0 = jSONObject.optString("name");
        return controllableDevice;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ControllableDevice controllableDevice = (ControllableDevice) obj;
        return TextUtils.equals(this.f9511O000000o, controllableDevice.f9511O000000o) && TextUtils.equals(this.O00000Oo, controllableDevice.O00000Oo);
    }

    public int hashCode() {
        String str = this.f9511O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9511O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }

    protected ControllableDevice(Parcel parcel) {
        this.f9511O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public static String O000000o(ControllableDevice controllableDevice) {
        if (controllableDevice == null) {
            return "";
        }
        if (!TextUtils.isEmpty(controllableDevice.O00000o0)) {
            return controllableDevice.O00000o0;
        }
        Device O000000o2 = fno.O000000o().O000000o(controllableDevice.f9511O000000o);
        if (O000000o2 == null) {
            return "";
        }
        return O000000o2.getName();
    }
}
