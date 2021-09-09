package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public class BtDevice extends Device {
    public static final Parcelable.Creator<BtDevice> CREATOR = new Parcelable.Creator<BtDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.BtDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BtDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BtDevice(parcel);
        }
    };
    private int deviceType;
    protected MiotBleAdvPacket packet;
    public byte[] scanRecord;

    public int getPid() {
        return 6;
    }

    public BtDevice(String str) {
        setMac(str);
        setDid(str);
        setPid(6);
    }

    public BtDevice(Device device) {
        setMac(device.getMac());
        setDid(device.getDid());
        setPid(6);
        setName(device.getName());
        setToken(device.getToken());
        setModel(device.getModel());
        setOwner(device.isOwner());
        setOwnerId(device.getOwnerId());
        setPermitLevel(device.getPermitLevel());
        setOwnerName(device.getOwnerName());
        setPropInfo(device.getPropInfo());
        setKeyId(device.getKeyId());
    }

    public BtDevice(BluetoothSearchResult bluetoothSearchResult) {
        setName(bluetoothSearchResult.O00000oO);
        setMac(bluetoothSearchResult.O000000o());
        setDid(bluetoothSearchResult.O000000o());
        setRssi(bluetoothSearchResult.O00000Oo);
        this.scanRecord = bluetoothSearchResult.O00000o0;
        setPid(6);
        this.deviceType = bluetoothSearchResult.O00000o;
    }

    public final MiotBleAdvPacket O000000o() {
        return this.packet;
    }

    public final void O000000o(MiotBleAdvPacket miotBleAdvPacket) {
        this.packet = miotBleAdvPacket;
    }

    public BtDevice(Parcel parcel) {
        super(parcel);
        this.scanRecord = parcel.createByteArray();
        this.deviceType = parcel.readInt();
        this.packet = (MiotBleAdvPacket) parcel.readParcelable(MiotBleAdvPacket.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByteArray(this.scanRecord);
        parcel.writeInt(this.deviceType);
        parcel.writeParcelable(this.packet, 0);
    }

    public String toString() {
        return "BtDevice{name=" + getName() + ", mac=" + getMac() + ", model=" + getModel() + ", did=" + getDid() + ", prop=" + getPropInfo() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BtDevice)) {
            return false;
        }
        return getMac().equals(((BtDevice) obj).getMac());
    }

    public int hashCode() {
        return getMac().hashCode();
    }

    public boolean isSameDevice(Device device) {
        return equals(device);
    }
}
