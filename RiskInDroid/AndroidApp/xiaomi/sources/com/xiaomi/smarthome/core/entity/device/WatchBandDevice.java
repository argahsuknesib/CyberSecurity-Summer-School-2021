package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;
import org.json.JSONObject;

public class WatchBandDevice extends Device {
    public static final Parcelable.Creator<WatchBandDevice> CREATOR = new Parcelable.Creator<WatchBandDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.WatchBandDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WatchBandDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WatchBandDevice(parcel);
        }
    };

    protected WatchBandDevice(Parcel parcel) {
        super(parcel);
    }

    public WatchBandDevice() {
    }

    public int describeContents() {
        return super.describeContents();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public void parseFromJSONObject(JSONObject jSONObject) {
        super.parseFromJSONObject(jSONObject);
        toggleOnline(true);
        toggleCanUseNotBind(true);
        setPid(0);
        setOwner(true);
    }
}
