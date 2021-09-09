package com.xiaomi.smarthome.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

public class XmBluetoothDevice implements Parcelable {
    public static final Parcelable.Creator<XmBluetoothDevice> CREATOR = new Parcelable.Creator<XmBluetoothDevice>() {
        /* class com.xiaomi.smarthome.bluetooth.XmBluetoothDevice.AnonymousClass1 */

        public final XmBluetoothDevice createFromParcel(Parcel parcel) {
            return new XmBluetoothDevice(parcel);
        }

        public final XmBluetoothDevice[] newArray(int i) {
            return new XmBluetoothDevice[i];
        }
    };
    public BluetoothDevice device;
    public int deviceType;
    public boolean isConnected;
    public String name;
    public int rssi;
    public byte[] scanRecord;

    public int describeContents() {
        return 0;
    }

    public XmBluetoothDevice() {
    }

    public XmBluetoothDevice(BluetoothDevice bluetoothDevice, int i) {
        this.device = bluetoothDevice;
        this.deviceType = i;
    }

    public XmBluetoothDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr, int i2) {
        this.device = bluetoothDevice;
        this.rssi = i;
        this.scanRecord = bArr;
        this.deviceType = i2;
    }

    public String getAddress() {
        BluetoothDevice bluetoothDevice = this.device;
        return bluetoothDevice != null ? bluetoothDevice.getAddress() : "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = " + this.name);
        sb.append(", mac = " + this.device.getAddress());
        sb.append(", connected = " + this.isConnected);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.device, 0);
        parcel.writeInt(this.rssi);
        parcel.writeByte(this.isConnected ? (byte) 1 : 0);
        parcel.writeByteArray(this.scanRecord);
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.name);
    }

    public XmBluetoothDevice(Parcel parcel) {
        this.device = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.rssi = parcel.readInt();
        this.isConnected = parcel.readByte() != 0;
        this.scanRecord = parcel.createByteArray();
        this.deviceType = parcel.readInt();
        this.name = parcel.readString();
    }
}
