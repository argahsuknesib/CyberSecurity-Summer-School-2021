package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    protected static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    protected static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    protected static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;

    private String getVersionFeatures(int i) {
        return i != 0 ? i != 1 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported" : "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet" : "Bootloader from SDK 8.0 or newer. Bond sharing supported" : "Bootloader from SDK 7.0 or newer. No bond sharing" : "Application with Legacy buttonless update from SDK 7.0 or newer" : "Bootloader from SDK 6.1 or older";
    }

    LegacyButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        int i;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            i = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = i;
            int i2 = i & 15;
            int i3 = i >> 8;
            logi("Version number read: " + i3 + "." + i2 + " -> " + getVersionFeatures(i));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb = new StringBuilder("Version number read: ");
            sb.append(i3);
            sb.append(".");
            sb.append(i2);
            dfuBaseService.sendLogBroadcast(10, sb.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            i = 0;
        }
        boolean z = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU")) {
            z = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU", false);
        }
        boolean z2 = bluetoothGatt.getServices().size() > 3;
        if (i == 0 && z2) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        if (i == 1 || (!z && i == 0 && z2)) {
            return true;
        }
        return false;
    }

    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mService.waitFor(1000);
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGatt bluetoothGatt = this.mGatt;
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Starting service that will connect to the DFU bootloader");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        if (this.mVersion != 0) {
            z = false;
        }
        restartService(intent2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
    private int readVersion(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        } else if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (bluetoothGattCharacteristic == null) {
            return 0;
        } else {
            this.mReceivedData = null;
            this.mError = 0;
            logi("Reading DFU version number...");
            this.mService.sendLogBroadcast(1, "Reading DFU version number...");
            bluetoothGattCharacteristic.setValue((byte[]) null);
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if (((!this.mRequestCompleted || bluetoothGattCharacteristic.getValue() == null) && this.mConnected && this.mError == 0 && !this.mAborted) || this.mPaused) {
                            this.mRequestCompleted = false;
                            this.mLock.wait();
                        }
                    }
                    if (this.mError == 0) {
                        throw new DfuException("Unable to read version number", this.mError);
                    } else if (this.mConnected) {
                        return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
                    } else {
                        throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
                    }
                }
                break;
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mError == 0) {
            }
        }
    }
}
