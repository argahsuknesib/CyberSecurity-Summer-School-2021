package miui.bluetooth.ble;

import android.os.ParcelUuid;
import android.support.v4.app.NotificationCompat;

public class MiServiceData {
    public static final ParcelUuid MI_SERVICE_UUID = ParcelUuid.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", "fe95"));
    private byte[] mData;
    private int mFrameControl;
    private int mVersion;

    public static MiServiceData fromScanRecord(ScanRecord scanRecord) {
        byte[] serviceData;
        if (scanRecord == null || scanRecord.getServiceData() == null || (serviceData = scanRecord.getServiceData(MI_SERVICE_UUID)) == null || serviceData.length < 5) {
            return null;
        }
        return new MiServiceData(serviceData);
    }

    public MiServiceData(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            throw new IllegalArgumentException("Mi Service data length must >= 5");
        }
        this.mData = bArr;
        byte[] bArr2 = this.mData;
        this.mFrameControl = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8);
        this.mVersion = (bArr2[1] & 240) >> 4;
    }

    public byte[] getData() {
        return this.mData;
    }

    public boolean isNewFactory() {
        return (this.mFrameControl & 1) != 0;
    }

    public boolean isConnected() {
        return (this.mFrameControl & 2) != 0;
    }

    public boolean isCentral() {
        return (this.mFrameControl & 4) != 0;
    }

    public boolean isEncrypted() {
        return (this.mFrameControl & 8) != 0;
    }

    public boolean hasMacAddress() {
        return (this.mFrameControl & 16) != 0;
    }

    public byte[] getMacAddress() {
        if (!hasMacAddress()) {
            return null;
        }
        byte[] bArr = this.mData;
        if (bArr.length < 11) {
            return null;
        }
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, 5, bArr2, 0, 6);
        return bArr2;
    }

    public boolean hasCapability() {
        return (this.mFrameControl & 32) != 0;
    }

    public byte getCapability() {
        if (!hasCapability()) {
            return 0;
        }
        int i = 5;
        if (hasMacAddress()) {
            i = 11;
        }
        byte[] bArr = this.mData;
        if (bArr.length >= i + 6) {
            return bArr[i];
        }
        return 0;
    }

    public boolean hasEvent() {
        return (this.mFrameControl & 64) != 0;
    }

    private int getEventDataIndex() {
        int i = hasMacAddress() ? 11 : 5;
        return hasCapability() ? i + 1 : i;
    }

    public int getEventID() {
        if (!hasEvent()) {
            return 0;
        }
        int eventDataIndex = getEventDataIndex();
        byte[] bArr = this.mData;
        return ((bArr[eventDataIndex + 1] & 255) << 8) | (bArr[eventDataIndex] & 255);
    }

    public byte getEvent() {
        if (!hasEvent()) {
            return 0;
        }
        int eventDataIndex = getEventDataIndex();
        byte[] bArr = this.mData;
        if (bArr.length >= eventDataIndex + 3) {
            return bArr[eventDataIndex + 2];
        }
        return 0;
    }

    public boolean hasCustomData() {
        return (this.mFrameControl & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
    }

    public byte[] getCustomData() {
        if (!hasCustomData()) {
            return null;
        }
        int i = 5;
        if (hasMacAddress()) {
            i = 11;
        }
        if (hasCapability()) {
            i++;
        }
        if (hasEvent()) {
            i += 3;
        }
        byte[] bArr = this.mData;
        if (bArr.length <= i) {
            return null;
        }
        byte b = bArr[i];
        byte[] bArr2 = new byte[b];
        System.arraycopy(bArr, i + 1, bArr2, 0, b);
        return bArr2;
    }

    public boolean hasSubTitle() {
        return (this.mFrameControl & 256) != 0;
    }

    public boolean isBindingFrame() {
        return (this.mFrameControl & 512) != 0;
    }

    public int getProductID() {
        byte[] bArr = this.mData;
        return ((bArr[3] & 255) << 8) | (bArr[2] & 255);
    }

    public int getFrameCounter() {
        return this.mData[4] & 255;
    }
}
