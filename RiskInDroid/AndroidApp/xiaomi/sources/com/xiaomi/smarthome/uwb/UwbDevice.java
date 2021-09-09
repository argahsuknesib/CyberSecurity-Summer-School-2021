package com.xiaomi.smarthome.uwb;

import _m_j.ixc;
import _m_j.ixe;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbDevice;", "Lcom/xiaomi/smarthome/device/Device;", "Landroid/os/Parcelable;", "uwbDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "base", "(Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;Lcom/xiaomi/smarthome/device/Device;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "baseDevice", "getBaseDevice", "()Lcom/xiaomi/smarthome/device/Device;", "setBaseDevice", "(Lcom/xiaomi/smarthome/device/Device;)V", "getUwbDevice", "()Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "setUwbDevice", "(Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;)V", "attachBaseDevice", "", "describeContents", "", "toString", "", "writeToParcel", "flags", "CREATOR", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbDevice extends Device implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private Device baseDevice;
    private UwbScanDevice uwbDevice;

    public final int describeContents() {
        return 0;
    }

    public final UwbScanDevice getUwbDevice() {
        return this.uwbDevice;
    }

    public final void setUwbDevice(UwbScanDevice uwbScanDevice) {
        this.uwbDevice = uwbScanDevice;
    }

    public final Device getBaseDevice() {
        return this.baseDevice;
    }

    public final void setBaseDevice(Device device) {
        this.baseDevice = device;
    }

    public UwbDevice(UwbScanDevice uwbScanDevice, Device device) {
        this.uwbDevice = uwbScanDevice;
        attachBaseDevice(device);
    }

    public final void attachBaseDevice(Device device) {
        this.baseDevice = device;
        if (device == null) {
            PluginDeviceManager pluginDeviceManager = PluginDeviceManager.instance;
            UwbScanDevice uwbScanDevice = this.uwbDevice;
            String str = null;
            Long valueOf = uwbScanDevice == null ? null : Long.valueOf(uwbScanDevice.getPid());
            this.model = pluginDeviceManager.getModelByProductId(valueOf == null ? 0 : (int) valueOf.longValue());
            PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(this.model);
            if (pluginInfo != null) {
                str = pluginInfo.O0000Oo0();
            }
            this.name = str;
            return;
        }
        set(device);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UwbDevice(Parcel parcel) {
        super(parcel);
        ixe.O00000o(parcel, "parcel");
        this.uwbDevice = (UwbScanDevice) parcel.readParcelable(UwbScanDevice.class.getClassLoader());
        this.baseDevice = (Device) parcel.readParcelable(UwbScanDevice.class.getClassLoader());
        attachBaseDevice(this.baseDevice);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "parcel");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.uwbDevice, i);
        parcel.writeParcelable(this.baseDevice, i);
    }

    public final String toString() {
        return "UwbDevice(model=" + ((Object) this.model) + ", did=" + ((Object) this.did) + ", pdid=" + this.pid + ", specUrn=" + ((Object) this.specUrn) + ')';
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbDevice$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/uwb/UwbDevice;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/uwb/UwbDevice;", "uwb-resource_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<UwbDevice> {
        public /* synthetic */ CREATOR(ixc ixc) {
            this();
        }

        private CREATOR() {
        }

        public final UwbDevice createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new UwbDevice(parcel);
        }

        public final UwbDevice[] newArray(int i) {
            return new UwbDevice[i];
        }
    }
}
