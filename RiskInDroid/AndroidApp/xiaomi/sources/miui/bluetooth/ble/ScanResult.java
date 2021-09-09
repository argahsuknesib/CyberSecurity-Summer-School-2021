package miui.bluetooth.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class ScanResult implements Parcelable {
    public static final Parcelable.Creator<ScanResult> CREATOR = new Parcelable.Creator<ScanResult>() {
        /* class miui.bluetooth.ble.ScanResult.AnonymousClass1 */

        public final ScanResult createFromParcel(Parcel parcel) {
            return new ScanResult(parcel);
        }

        public final ScanResult[] newArray(int i) {
            return new ScanResult[i];
        }
    };
    private BluetoothDevice mDevice;
    private int mRssi;
    private ScanRecord mScanRecord;
    private long mTimestampNanos;
    private int mType;

    public final int describeContents() {
        return 0;
    }

    public ScanResult(BluetoothDevice bluetoothDevice, ScanRecord scanRecord, int i, long j, int i2) {
        this.mType = 0;
        this.mDevice = bluetoothDevice;
        this.mScanRecord = scanRecord;
        this.mRssi = i;
        this.mTimestampNanos = j;
        this.mType = i2;
    }

    private ScanResult(Parcel parcel) {
        this.mType = 0;
        readFromParcel(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (this.mDevice != null) {
            parcel.writeInt(1);
            this.mDevice.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.mScanRecord != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.mScanRecord.getBytes());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mRssi);
        parcel.writeLong(this.mTimestampNanos);
    }

    private void readFromParcel(Parcel parcel) {
        if (parcel.readInt() == 1) {
            this.mDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.mScanRecord = ScanRecord.parseFromBytes(parcel.createByteArray());
        }
        this.mRssi = parcel.readInt();
        this.mTimestampNanos = parcel.readLong();
    }

    public final BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public final ScanRecord getScanRecord() {
        return this.mScanRecord;
    }

    public final int getRssi() {
        return this.mRssi;
    }

    public final long getTimestampNanos() {
        return this.mTimestampNanos;
    }

    public final int getDeviceType() {
        return this.mType;
    }

    public final int hashCode() {
        return hash(this.mDevice, Integer.valueOf(this.mRssi), this.mScanRecord, Long.valueOf(this.mTimestampNanos));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScanResult scanResult = (ScanResult) obj;
            return equals(this.mDevice, scanResult.mDevice) && this.mRssi == scanResult.mRssi && equals(this.mScanRecord, scanResult.mScanRecord) && this.mTimestampNanos == scanResult.mTimestampNanos;
        }
    }

    public final String toString() {
        return "ScanResult{mDevice=" + this.mDevice + ", mScanRecord=" + toString(this.mScanRecord) + ", mRssi=" + this.mRssi + ", mTimestampNanos=" + this.mTimestampNanos + '}';
    }

    private static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }
}
