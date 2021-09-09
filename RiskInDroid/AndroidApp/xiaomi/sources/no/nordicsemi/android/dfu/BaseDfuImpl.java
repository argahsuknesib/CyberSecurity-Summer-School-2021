package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

abstract class BaseDfuImpl implements DfuService {
    protected static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    protected static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    protected static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    protected static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    protected boolean mAborted;
    protected byte[] mBuffer = new byte[20];
    protected boolean mConnected;
    public int mCurrentMtu;
    protected int mError;
    protected int mFileType;
    protected InputStream mFirmwareStream;
    protected BluetoothGatt mGatt;
    protected int mImageSizeInBytes;
    protected int mInitPacketSizeInBytes;
    protected InputStream mInitPacketStream;
    protected final Object mLock = new Object();
    protected boolean mPaused;
    protected DfuProgressInfo mProgressInfo;
    protected byte[] mReceivedData = null;
    protected boolean mRequestCompleted;
    protected boolean mResetRequestSent;
    protected DfuBaseService mService;

    public class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        protected BaseBluetoothGattCallback() {
        }

        public void onDisconnected() {
            BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
            baseDfuImpl.mConnected = false;
            baseDfuImpl.notifyLock();
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                BaseDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Characteristic read error: ".concat(String.valueOf(i)));
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i != 0) {
                BaseDfuImpl.this.loge("Descriptor read error: ".concat(String.valueOf(i)));
                BaseDfuImpl.this.mError = i | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Read Response received from descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    BaseDfuImpl.this.mRequestCompleted = true;
                } else {
                    BaseDfuImpl.this.loge("Unknown descriptor read");
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i != 0) {
                BaseDfuImpl.this.loge("Descriptor write error: ".concat(String.valueOf(i)));
                BaseDfuImpl.this.mError = i | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Data written to descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    DfuBaseService dfuBaseService2 = BaseDfuImpl.this.mService;
                    dfuBaseService2.sendLogBroadcast(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                } else {
                    DfuBaseService dfuBaseService3 = BaseDfuImpl.this.mService;
                    dfuBaseService3.sendLogBroadcast(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: ".concat(String.valueOf(i)));
                int i3 = i - 3;
                if (i3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[i3];
                }
                BaseDfuImpl.this.logi("MTU changed to: ".concat(String.valueOf(i)));
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + i2 + " (mtu: " + i + ")");
                if (i2 == 4 && BaseDfuImpl.this.mCurrentMtu > 23 && BaseDfuImpl.this.mCurrentMtu - 3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                    baseDfuImpl.mBuffer = new byte[(baseDfuImpl.mCurrentMtu - 3)];
                    BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                }
            }
            BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
            baseDfuImpl2.mRequestCompleted = true;
            baseDfuImpl2.notifyLock();
        }

        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.logi("PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                return;
            }
            BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
            baseDfuImpl2.logw("Updating PHY failed: " + i3 + " (txPhy: " + i + ", rxPhy: " + i2 + ")");
        }

        /* access modifiers changed from: protected */
        public String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return parse(bluetoothGattCharacteristic.getValue());
        }

        /* access modifiers changed from: protected */
        public String parse(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return parse(bluetoothGattDescriptor.getValue());
        }

        private String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[((length * 3) - 1)];
            for (int i = 0; i < length; i++) {
                byte b = bArr[i] & 255;
                int i2 = i * 3;
                cArr[i2] = BaseDfuImpl.HEX_ARRAY[b >>> 4];
                cArr[i2 + 1] = BaseDfuImpl.HEX_ARRAY[b & 15];
                if (i != length - 1) {
                    cArr[i2 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        private String phyToString(int i) {
            if (i == 1) {
                return "LE 1M";
            }
            if (i == 2) {
                return "LE 2M";
            }
            if (i == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + i + ")";
        }
    }

    BaseDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
        this.mConnected = true;
    }

    public void release() {
        this.mService = null;
    }

    public void pause() {
        this.mPaused = true;
    }

    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public void onBondStateChanged(int i) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        int i2;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.mGatt = bluetoothGatt;
        this.mFileType = i;
        this.mFirmwareStream = inputStream;
        this.mInitPacketStream = inputStream2;
        int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int intExtra2 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        this.mCurrentMtu = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU", 23);
        if (i > 4) {
            logw("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.mService.sendLogBroadcast(15, "Sending system components");
            this.mFileType &= -5;
            ((ArchiveInputStream) this.mFirmwareStream).setContentType(this.mFileType);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.mService.sendLogBroadcast(15, "Sending application");
        }
        int i3 = 0;
        try {
            inputStream2.reset();
            i2 = inputStream2.available();
        } catch (Exception unused) {
            i2 = 0;
        }
        this.mInitPacketSizeInBytes = i2;
        try {
            inputStream.reset();
            i3 = inputStream.available();
        } catch (Exception unused2) {
        }
        this.mImageSizeInBytes = i3;
        this.mProgressInfo.init(i3, intExtra, intExtra2);
        if (!(bluetoothGatt.getDevice().getBondState() != 12 || (service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID)) == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null)) {
            if (!isServiceChangedCCCDEnabled()) {
                enableCCCD(characteristic, 2);
            }
            this.mService.sendLogBroadcast(10, "Service Changed indications enabled");
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        if (r10.mError == 0) goto L_0x00d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0128  */
    public void enableCCCD(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGatt bluetoothGatt = this.mGatt;
        String str = i == 1 ? "notifications" : "indications";
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        } else if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
            boolean z = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
            if (!z) {
                logi("Enabling " + str + "...");
                DfuBaseService dfuBaseService = this.mService;
                dfuBaseService.sendLogBroadcast(1, "Enabling " + str + " for " + bluetoothGattCharacteristic.getUuid());
                DfuBaseService dfuBaseService2 = this.mService;
                dfuBaseService2.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                descriptor.setValue(i == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                DfuBaseService dfuBaseService3 = this.mService;
                StringBuilder sb = new StringBuilder("gatt.writeDescriptor(");
                sb.append(descriptor.getUuid());
                sb.append(i == 1 ? ", value=0x01-00)" : ", value=0x02-00)");
                dfuBaseService3.sendLogBroadcast(0, sb.toString());
                bluetoothGatt.writeDescriptor(descriptor);
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if (!z) {
                                if (this.mConnected) {
                                }
                            }
                            if (!this.mPaused) {
                            }
                            this.mLock.wait();
                            z = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                        }
                        if (this.mError == 0) {
                            throw new DfuException("Unable to set " + str + " state", this.mError);
                        } else if (!this.mConnected) {
                            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
                        } else {
                            return;
                        }
                    }
                    break;
                } catch (InterruptedException e) {
                    loge("Sleeping interrupted", e);
                }
                if (this.mError == 0) {
                }
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b2  */
    private boolean isServiceChangedCCCDEnabled() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        int i;
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        } else if (!this.mAborted) {
            BluetoothGatt bluetoothGatt = this.mGatt;
            BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
            if (service == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null || (descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG)) == null) {
                return false;
            }
            this.mRequestCompleted = false;
            this.mError = 0;
            logi("Reading Service Changed CCCD value...");
            this.mService.sendLogBroadcast(1, "Reading Service Changed CCCD value...");
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
            bluetoothGatt.readDescriptor(descriptor);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((!this.mRequestCompleted && this.mConnected && this.mError == 0) || this.mPaused) {
                            this.mLock.wait();
                        }
                    }
                    i = this.mError;
                    if (i == 0) {
                        throw new DfuException("Unable to read Service Changed CCCD", i);
                    } else if (!this.mConnected) {
                        throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
                    } else if (descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0] && descriptor.getValue()[1] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]) {
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            i = this.mError;
            if (i == 0) {
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* access modifiers changed from: protected */
    public void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            this.mRequestCompleted = false;
            this.mResetRequestSent = z;
            bluetoothGattCharacteristic.setWriteType(2);
            bluetoothGattCharacteristic.setValue(bArr);
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
            DfuBaseService dfuBaseService2 = this.mService;
            dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((!this.mRequestCompleted && this.mConnected && this.mError == 0) || this.mPaused) {
                            this.mLock.wait();
                        }
                    }
                    if (this.mResetRequestSent && this.mError != 0) {
                        throw new DfuException("Unable to write Op Code " + ((int) bArr[0]), this.mError);
                    } else if (!this.mResetRequestSent && !this.mConnected) {
                        throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) bArr[0]) + ": device disconnected");
                    } else {
                        return;
                    }
                }
                break;
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mResetRequestSent) {
            }
            if (!this.mResetRequestSent) {
                return;
            }
            return;
        }
        throw new UploadAbortedException();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean createBond() {
        boolean z;
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
            z = device.createBond();
        } else {
            z = createBondApi18(device);
        }
        try {
            synchronized (this.mLock) {
                while (!this.mRequestCompleted && !this.mAborted) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return z;
    }

    private boolean createBondApi18(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            if (method != null) {
                this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
                return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            Log.w("DfuImpl", "An exception occurred while creating bond", e);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        boolean z = true;
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            if (method != null) {
                this.mRequestCompleted = false;
                this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
                boolean booleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
                try {
                    synchronized (this.mLock) {
                        while (!this.mRequestCompleted && !this.mAborted) {
                            this.mLock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    try {
                        loge("Sleeping interrupted", e);
                    } catch (Exception e2) {
                        z = booleanValue;
                        e = e2;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            Log.w("DfuImpl", "An exception occurred while removing bond information", e);
            return z;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059  */
    public void requestMtu(int i) throws DeviceDisconnectedException, UploadAbortedException {
        if (!this.mAborted) {
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(1, "Requesting new MTU...");
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(0, "gatt.requestMtu(" + i + ")");
            if (this.mGatt.requestMtu(i)) {
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if ((!this.mRequestCompleted && this.mConnected && this.mError == 0) || this.mPaused) {
                                this.mLock.wait();
                            }
                        }
                        if (this.mConnected) {
                            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
                        }
                        return;
                    }
                    break;
                } catch (InterruptedException e) {
                    loge("Sleeping interrupted", e);
                }
                if (this.mConnected) {
                }
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047  */
    public byte[] readNotificationResponse() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData == null && this.mConnected && this.mError == 0 && !this.mAborted) || this.mPaused) {
                        this.mLock.wait();
                    }
                }
                if (this.mAborted) {
                    int i = this.mError;
                    if (i != 0) {
                        throw new DfuException("Unable to write Op Code", i);
                    } else if (this.mConnected) {
                        return this.mReceivedData;
                    } else {
                        throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
                    }
                } else {
                    throw new UploadAbortedException();
                }
            }
            break;
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
        }
    }

    /* access modifiers changed from: protected */
    public void restartService(Intent intent, boolean z) {
        String str;
        if (z) {
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader...");
            str = BootloaderScannerFactory.getScanner().searchFor(this.mGatt.getDevice().getAddress());
            logi("Scanning for new address finished with: ".concat(String.valueOf(str)));
            if (str != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address ".concat(String.valueOf(str)));
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            str = null;
        }
        if (str != null) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
        }
        this.mService.startService(intent);
    }

    /* access modifiers changed from: protected */
    public String parse(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[((length * 3) - 1)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            if (i != length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    /* access modifiers changed from: package-private */
    public void loge(String str) {
        Log.e("DfuImpl", str);
    }

    /* access modifiers changed from: package-private */
    public void loge(String str, Throwable th) {
        Log.e("DfuImpl", str, th);
    }

    /* access modifiers changed from: package-private */
    public void logw(String str) {
        if (DfuBaseService.DEBUG) {
            Log.w("DfuImpl", str);
        }
    }

    /* access modifiers changed from: package-private */
    public void logi(String str) {
        if (DfuBaseService.DEBUG) {
            Log.i("DfuImpl", str);
        }
    }
}
