package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.List;

public class DeviceListResult implements Parcelable {
    public static final Parcelable.Creator<DeviceListResult> CREATOR = new Parcelable.Creator<DeviceListResult>() {
        /* class com.xiaomi.smarthome.core.entity.device.DeviceListResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceListResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceListResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Device> f6726O000000o = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public DeviceListResult() {
    }

    protected DeviceListResult(Parcel parcel) {
        this.f6726O000000o = parcel.createTypedArrayList(Device.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f6726O000000o);
    }
}
