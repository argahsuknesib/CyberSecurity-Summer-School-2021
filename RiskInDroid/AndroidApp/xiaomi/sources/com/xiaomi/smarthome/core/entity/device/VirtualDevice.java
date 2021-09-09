package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;
import org.json.JSONObject;

public class VirtualDevice extends Device {
    public static final Parcelable.Creator<VirtualDevice> CREATOR = new Parcelable.Creator<VirtualDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.VirtualDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VirtualDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VirtualDevice(parcel);
        }
    };
    private int mState;
    private String mUrl;

    protected VirtualDevice(Parcel parcel) {
        super(parcel);
        this.mState = parcel.readInt();
        this.mUrl = parcel.readString();
    }

    private VirtualDevice() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mState);
        parcel.writeString(this.mUrl);
    }

    public void parseFromJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            super.parseFromJSONObject(jSONObject);
            this.mState = jSONObject.optInt("state");
            this.mUrl = jSONObject.optString("url");
            toggleCanUseNotBind(true);
            toggleOnline(true);
        }
    }

    public final synchronized String O000000o() {
        return this.mUrl;
    }
}
