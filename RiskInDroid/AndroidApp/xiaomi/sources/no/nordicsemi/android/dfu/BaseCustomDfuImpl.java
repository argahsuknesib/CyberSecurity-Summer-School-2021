package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    protected boolean mFirmwareUploadInProgress;
    public boolean mInitPacketInProgress;
    protected int mPacketsBeforeNotification;
    protected int mPacketsSentSinceNotification;
    protected boolean mRemoteErrorOccurred;

    /* access modifiers changed from: protected */
    public abstract UUID getControlPointCharacteristicUUID();

    /* access modifiers changed from: protected */
    public abstract UUID getDfuServiceUUID();

    /* access modifiers changed from: protected */
    public abstract UUID getPacketCharacteristicUUID();

    public class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        /* access modifiers changed from: protected */
        public void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        }

        protected BaseCustomBluetoothCallback() {
            super();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            boolean z = true;
            if (i == 0) {
                if (!bluetoothGattCharacteristic.getUuid().equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                    BaseCustomDfuImpl.this.mRequestCompleted = true;
                } else if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                    BaseCustomDfuImpl.this.mInitPacketInProgress = false;
                } else if (BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                    BaseCustomDfuImpl.this.mProgressInfo.addBytesSent(bluetoothGattCharacteristic.getValue().length);
                    BaseCustomDfuImpl.this.mPacketsSentSinceNotification++;
                    if (BaseCustomDfuImpl.this.mPacketsBeforeNotification <= 0 || BaseCustomDfuImpl.this.mPacketsSentSinceNotification < BaseCustomDfuImpl.this.mPacketsBeforeNotification) {
                        z = false;
                    }
                    boolean isComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                    boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!z) {
                        if (isComplete || isObjectComplete) {
                            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                            baseCustomDfuImpl.mFirmwareUploadInProgress = false;
                            baseCustomDfuImpl.notifyLock();
                            return;
                        }
                        try {
                            BaseCustomDfuImpl.this.waitIfPaused();
                            if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred) {
                                if (!BaseCustomDfuImpl.this.mResetRequestSent) {
                                    int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                    byte[] bArr = BaseCustomDfuImpl.this.mBuffer;
                                    if (availableObjectSizeIsBytes < bArr.length) {
                                        bArr = new byte[availableObjectSizeIsBytes];
                                    }
                                    BaseCustomDfuImpl.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr));
                                    return;
                                }
                            }
                            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                            BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        } catch (HexFileValidationException unused) {
                            BaseCustomDfuImpl.this.loge("Invalid HEX file");
                            BaseCustomDfuImpl.this.mError = 4099;
                        } catch (IOException e) {
                            BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                            BaseCustomDfuImpl.this.mError = 4100;
                        }
                    } else {
                        return;
                    }
                } else {
                    onPacketCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            } else if (BaseCustomDfuImpl.this.mResetRequestSent) {
                BaseCustomDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseCustomDfuImpl.this.loge("Characteristic write error: ".concat(String.valueOf(i)));
                BaseCustomDfuImpl.this.mError = i | 16384;
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        /* access modifiers changed from: protected */
        public void handlePacketReceiptNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (!BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(BaseCustomDfuImpl.this.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred) {
                    if (!BaseCustomDfuImpl.this.mResetRequestSent) {
                        boolean isComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                        boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                        if (!isComplete) {
                            if (!isObjectComplete) {
                                int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                byte[] bArr = BaseCustomDfuImpl.this.mBuffer;
                                if (availableObjectSizeIsBytes < bArr.length) {
                                    bArr = new byte[availableObjectSizeIsBytes];
                                }
                                BaseCustomDfuImpl.this.writePacket(bluetoothGatt, characteristic, bArr, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr));
                                return;
                            }
                        }
                        BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                        BaseCustomDfuImpl.this.notifyLock();
                        return;
                    }
                }
                BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        /* access modifiers changed from: protected */
        public void handleNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            DfuBaseService dfuBaseService = BaseCustomDfuImpl.this.mService;
            dfuBaseService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
            BaseCustomDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
        }
    }

    BaseCustomDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        boolean z = true;
        int i = 12;
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED")) {
            boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED", Build.VERSION.SDK_INT >= 23 ? false : z);
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE", 12);
            this.mPacketsBeforeNotification = !booleanExtra ? 0 : (intExtra < 0 || intExtra > 65535) ? 12 : intExtra;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
        boolean z2 = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, Build.VERSION.SDK_INT >= 23 ? false : z);
        try {
            int parseInt = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, "12"));
            if (parseInt >= 0 && parseInt <= 65535) {
                i = parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = !z2 ? 0 : i;
    }

    /* access modifiers changed from: protected */
    public void writeInitData(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int read = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    writeInitPacket(bluetoothGattCharacteristic, bArr, read);
                    if (crc32 != null) {
                        crc32.update(bArr, 0, read);
                    }
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    private void writeInitPacket(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            if (bArr.length != i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            }
            this.mReceivedData = null;
            this.mError = 0;
            this.mInitPacketInProgress = true;
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            logi("Sending init packet (Value = " + parse(bArr) + ")");
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
            DfuBaseService dfuBaseService2 = this.mService;
            dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mInitPacketInProgress && this.mConnected && this.mError == 0) || this.mPaused) {
                            this.mLock.wait();
                        }
                    }
                    if (this.mError == 0) {
                        throw new DfuException("Unable to write Init DFU Parameters", this.mError);
                    } else if (!this.mConnected) {
                        throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
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
        } else {
            throw new UploadAbortedException();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    public void uploadFirmwareImage(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            this.mFirmwareUploadInProgress = true;
            this.mPacketsSentSinceNotification = 0;
            byte[] bArr = this.mBuffer;
            try {
                int read = this.mFirmwareStream.read(bArr);
                DfuBaseService dfuBaseService = this.mService;
                dfuBaseService.sendLogBroadcast(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
                writePacket(this.mGatt, bluetoothGattCharacteristic, bArr, read);
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if ((this.mFirmwareUploadInProgress && this.mReceivedData == null && this.mConnected && this.mError == 0) || this.mPaused) {
                                this.mLock.wait();
                            }
                        }
                        if (this.mError == 0) {
                            throw new DfuException("Uploading Firmware Image failed", this.mError);
                        } else if (!this.mConnected) {
                            throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
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
            } catch (HexFileValidationException unused) {
                throw new DfuException("HEX file not valid", 4099);
            } catch (IOException unused2) {
                throw new DfuException("Error while reading file", 4100);
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    public void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i > 0) {
            if (bArr.length != i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            }
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize(Intent intent, boolean z) {
        boolean z2;
        boolean z3 = false;
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.mService.refreshDeviceCache(this.mGatt, z || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(2000);
                z2 = true;
            } else {
                z2 = false;
            }
            if (!booleanExtra2 || (this.mFileType & 4) <= 0) {
                z3 = z2;
            } else {
                createBond();
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            if (!z3) {
                this.mService.waitFor(1400);
            }
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", "application/zip");
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", 4);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }
}
