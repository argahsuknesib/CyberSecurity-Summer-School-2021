package no.nordicsemi.android.dfu;

import _m_j.jaj;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class SecureDfuImpl extends BaseCustomDfuImpl {
    protected static final UUID DEFAULT_DFU_CONTROL_POINT_UUID = new UUID(-8157989241631715488L, -6937650605005804976L);
    protected static final UUID DEFAULT_DFU_PACKET_UUID = new UUID(-8157989237336748192L, -6937650605005804976L);
    protected static final UUID DEFAULT_DFU_SERVICE_UUID = new UUID(279658205548544L, -9223371485494954757L);
    protected static UUID DFU_CONTROL_POINT_UUID = DEFAULT_DFU_CONTROL_POINT_UUID;
    protected static UUID DFU_PACKET_UUID = DEFAULT_DFU_PACKET_UUID;
    protected static UUID DFU_SERVICE_UUID = DEFAULT_DFU_SERVICE_UUID;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM = {3};
    private static final byte[] OP_CODE_CREATE_COMMAND = {1, 1, 0, 0, 0, 0};
    private static final byte[] OP_CODE_CREATE_DATA = {1, 2, 0, 0, 0, 0};
    private static final byte[] OP_CODE_EXECUTE = {4};
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {2, 0, 0};
    private static final byte[] OP_CODE_SELECT_OBJECT = {6, 0};
    private final SecureBluetoothCallback mBluetoothCallback = new SecureBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected SecureBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.loge("Empty response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                secureDfuImpl2.mError = 4104;
                secureDfuImpl2.notifyLock();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() != 96) {
                SecureDfuImpl secureDfuImpl3 = SecureDfuImpl.this;
                secureDfuImpl3.loge("Invalid response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl.this.mError = 4104;
            } else if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(intValue);
                } else if (SecureDfuImpl.this.mFirmwareUploadInProgress) {
                    SecureDfuImpl secureDfuImpl4 = SecureDfuImpl.this;
                    secureDfuImpl4.mFirmwareUploadInProgress = false;
                    secureDfuImpl4.notifyLock();
                    return;
                }
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    SecureDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    SecureDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (!(service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null)) {
            this.mControlPointCharacteristic = characteristic;
            this.mPacketCharacteristic = service.getCharacteristic(DFU_PACKET_UUID);
            if (this.mPacketCharacteristic != null) {
                return true;
            }
        }
        return false;
    }

    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 != null) {
            return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(bluetoothGatt, 4107);
        return false;
    }

    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    /* access modifiers changed from: protected */
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    /* access modifiers changed from: protected */
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    /* access modifiers changed from: protected */
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x015f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0160, code lost:
        loge(r10.getMessage());
        r9.mService.sendLogBroadcast(20, r10.getMessage());
        r9.mService.terminateConnection(r1, 4104);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0177, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0178, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0179, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063 A[Catch:{ RemoteDfuException -> 0x006c, UploadAbortedException -> 0x0178, UnknownResponseException -> 0x015f, UploadAbortedException -> 0x0178, UnknownResponseException -> 0x015f, RemoteDfuException -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015f A[ExcHandler: UnknownResponseException (r10v2 'e' no.nordicsemi.android.dfu.internal.exception.UnknownResponseException A[CUSTOM_DECLARE]), Splitter:B:6:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0178 A[ExcHandler: UploadAbortedException (r10v1 'e' no.nordicsemi.android.dfu.internal.exception.UploadAbortedException A[CUSTOM_DECLARE]), Splitter:B:6:0x003e] */
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        boolean z;
        logw("Secure DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU") && Build.VERSION.SDK_INT >= 21) {
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU", 517);
            logi("Requesting MTU = ".concat(String.valueOf(intExtra)));
            requestMtu(intExtra);
        }
        try {
            enableCCCD(this.mControlPointCharacteristic, 1);
            this.mService.sendLogBroadcast(10, "Notifications enabled");
            this.mService.waitFor(1000);
            if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME")) {
                if (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME", false)) {
                    z = false;
                    if (!z) {
                        logi("Resume feature disabled. Performing fresh DFU");
                    }
                    sendInitPacket(bluetoothGatt, z);
                    sendFirmware(bluetoothGatt);
                    this.mProgressInfo.setProgress(-5);
                    this.mService.waitUntilDisconnected();
                    this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                    finalize(intent, false);
                }
            }
            z = true;
            if (!z) {
            }
            sendInitPacket(bluetoothGatt, z);
        } catch (RemoteDfuException e) {
            if (!this.mProgressInfo.isLastPart()) {
                this.mRemoteErrorOccurred = false;
                logw("Sending SD+BL failed. Trying to send App only");
                this.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
                this.mFileType = 4;
                ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                archiveInputStream.setContentType(this.mFileType);
                byte[] applicationInit = archiveInputStream.getApplicationInit();
                this.mInitPacketStream = new ByteArrayInputStream(applicationInit);
                this.mInitPacketSizeInBytes = applicationInit.length;
                this.mImageSizeInBytes = archiveInputStream.applicationImageSize();
                this.mProgressInfo.init(this.mImageSizeInBytes, 2, 2);
                sendInitPacket(bluetoothGatt, false);
            } else {
                throw e;
            }
        } catch (UploadAbortedException e2) {
        } catch (UnknownResponseException e3) {
        } catch (RemoteDfuException e4) {
            int errorNumber = e4.getErrorNumber() | 512;
            loge(e4.getMessage() + ": " + jaj.O000000o(errorNumber));
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", jaj.O000000o(errorNumber)));
            if (e4 instanceof RemoteDfuExtendedErrorException) {
                RemoteDfuExtendedErrorException remoteDfuExtendedErrorException = (RemoteDfuExtendedErrorException) e4;
                int extendedErrorNumber = remoteDfuExtendedErrorException.getExtendedErrorNumber() | 1024;
                loge("Extended Error details: " + jaj.O00000Oo(extendedErrorNumber));
                DfuBaseService dfuBaseService = this.mService;
                dfuBaseService.sendLogBroadcast(20, "Details: " + jaj.O00000Oo(extendedErrorNumber) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + ")");
                this.mService.terminateConnection(bluetoothGatt, extendedErrorNumber | 8192);
                return;
            }
            this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
            return;
        }
        sendFirmware(bluetoothGatt);
        this.mProgressInfo.setProgress(-5);
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        finalize(intent, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x010e  */
    private void sendInitPacket(BluetoothGatt bluetoothGatt, boolean z) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        boolean z2;
        boolean z3;
        boolean z4;
        BluetoothGatt bluetoothGatt2 = bluetoothGatt;
        CRC32 crc32 = new CRC32();
        logi("Setting object to Command (Op Code = 6, Type = 1)");
        ObjectInfo selectObject = selectObject(1);
        int i = 3;
        logi(String.format(Locale.US, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(Locale.US, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        if (z && selectObject.offset > 0 && selectObject.offset <= this.mInitPacketSizeInBytes) {
            try {
                byte[] bArr = new byte[selectObject.offset];
                this.mInitPacketStream.read(bArr);
                crc32.update(bArr);
                if (selectObject.CRC32 == ((int) (crc32.getValue() & 4294967295L))) {
                    logi("Init packet CRC is the same");
                    if (selectObject.offset == this.mInitPacketSizeInBytes) {
                        logi("-> Whole Init packet was sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Received CRC match Init packet");
                            z4 = true;
                            z2 = false;
                        } catch (IOException e) {
                            e = e;
                            z3 = true;
                            z2 = false;
                            loge("Error while reading " + selectObject.offset + " bytes from the init packet stream", e);
                            try {
                                this.mInitPacketStream.reset();
                                crc32.reset();
                                selectObject.offset = 0;
                                if (!z3) {
                                }
                                logi("Executing init packet (Op Code = 4)");
                                writeExecute();
                                this.mService.sendLogBroadcast(10, "Command object executed");
                            } catch (IOException e2) {
                                loge("Error while resetting the init packet stream", e2);
                                this.mService.terminateConnection(bluetoothGatt2, 4100);
                                return;
                            }
                        }
                        if (!z3) {
                            setPacketReceiptNotifications(0);
                            this.mService.sendLogBroadcast(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
                            int i2 = 1;
                            while (i2 <= i) {
                                if (!z2) {
                                    logi("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.mInitPacketSizeInBytes + ")");
                                    writeCreateRequest(1, this.mInitPacketSizeInBytes);
                                    this.mService.sendLogBroadcast(10, "Command object created");
                                }
                                logi("Sending " + (this.mInitPacketSizeInBytes - selectObject.offset) + " bytes of init packet...");
                                writeInitData(this.mPacketCharacteristic, crc32);
                                int value = (int) (crc32.getValue() & 4294967295L);
                                this.mService.sendLogBroadcast(10, String.format(Locale.US, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                                logi("Sending Calculate Checksum command (Op Code = 3)");
                                ObjectChecksum readChecksum = readChecksum();
                                this.mService.sendLogBroadcast(10, String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                                logi(String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                                if (value == readChecksum.CRC32) {
                                    break;
                                }
                                i = 3;
                                if (i2 < 3) {
                                    i2++;
                                    logi("CRC does not match! Retrying...(" + i2 + "/3)");
                                    DfuBaseService dfuBaseService = this.mService;
                                    dfuBaseService.sendLogBroadcast(15, "CRC does not match! Retrying...(" + i2 + "/3)");
                                    try {
                                        selectObject.offset = 0;
                                        selectObject.CRC32 = 0;
                                        this.mInitPacketStream.reset();
                                        crc32.reset();
                                        z2 = false;
                                    } catch (IOException e3) {
                                        loge("Error while resetting the init packet stream", e3);
                                        this.mService.terminateConnection(bluetoothGatt2, 4100);
                                        return;
                                    }
                                } else {
                                    loge("CRC does not match!");
                                    this.mService.sendLogBroadcast(20, "CRC does not match!");
                                    this.mService.terminateConnection(bluetoothGatt2, 4109);
                                    return;
                                }
                            }
                        }
                        logi("Executing init packet (Op Code = 4)");
                        writeExecute();
                        this.mService.sendLogBroadcast(10, "Command object executed");
                    }
                    logi("-> " + selectObject.offset + " bytes of Init packet were sent before");
                    try {
                        this.mService.sendLogBroadcast(10, "Resuming sending Init packet...");
                        z3 = false;
                        z2 = true;
                    } catch (IOException e4) {
                        e = e4;
                        z3 = false;
                        z2 = true;
                        loge("Error while reading " + selectObject.offset + " bytes from the init packet stream", e);
                        this.mInitPacketStream.reset();
                        crc32.reset();
                        selectObject.offset = 0;
                        if (!z3) {
                        }
                        logi("Executing init packet (Op Code = 4)");
                        writeExecute();
                        this.mService.sendLogBroadcast(10, "Command object executed");
                    }
                    if (!z3) {
                    }
                    logi("Executing init packet (Op Code = 4)");
                    writeExecute();
                    this.mService.sendLogBroadcast(10, "Command object executed");
                }
                this.mInitPacketStream.reset();
                crc32.reset();
                selectObject.offset = 0;
            } catch (IOException e5) {
                e = e5;
                z3 = false;
            }
        }
        z4 = false;
        z2 = false;
        if (!z3) {
        }
        logi("Executing init packet (Op Code = 4)");
        writeExecute();
        this.mService.sendLogBroadcast(10, "Command object executed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x01c1 A[LOOP:0: B:27:0x01c1->B:50:0x0321, LOOP_LABEL: LOOP:0: B:27:0x01c1->B:50:0x0321, LOOP_START, PHI: r3 r7 r8 r11 10  PHI: (r3v2 java.lang.String) = (r3v0 java.lang.String), (r3v3 java.lang.String) binds: [B:26:0x01bf, B:50:0x0321] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:26:0x01bf, B:50:0x0321] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r8v8 boolean) = (r8v7 boolean), (r8v10 boolean) binds: [B:26:0x01bf, B:50:0x0321] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r11v2 long) = (r11v1 long), (r11v20 long) binds: [B:26:0x01bf, B:50:0x0321] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x03dc  */
    private void sendFirmware(BluetoothGatt bluetoothGatt) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        boolean z;
        int i;
        long j;
        long j2;
        long j3;
        boolean z2;
        BluetoothGatt bluetoothGatt2 = bluetoothGatt;
        int i2 = this.mPacketsBeforeNotification;
        String str = ")";
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + str);
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo selectObject = selectObject(2);
        logi(String.format(Locale.US, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(Locale.US, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(selectObject.maxSize);
        int i3 = ((this.mImageSizeInBytes + selectObject.maxSize) - 1) / selectObject.maxSize;
        if (selectObject.offset > 0) {
            try {
                i = selectObject.offset / selectObject.maxSize;
                int i4 = selectObject.maxSize * i;
                int i5 = selectObject.offset - i4;
                if (i5 == 0) {
                    i4 -= selectObject.maxSize;
                    i5 = selectObject.maxSize;
                }
                if (i4 > 0) {
                    this.mFirmwareStream.read(new byte[i4]);
                    this.mFirmwareStream.mark(selectObject.maxSize);
                }
                this.mFirmwareStream.read(new byte[i5]);
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L)) == selectObject.CRC32) {
                    logi(selectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, selectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(selectObject.offset);
                    this.mProgressInfo.setBytesReceived(selectObject.offset);
                    if (i5 != selectObject.maxSize || selectObject.offset >= this.mImageSizeInBytes) {
                        z = true;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (selectObject.offset >= this.mImageSizeInBytes) {
                            loop0:
                            while (true) {
                                int i6 = 1;
                                while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                                    if (!z) {
                                        int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                        boolean z3 = z;
                                        StringBuilder sb = new StringBuilder("Creating Data object (Op Code = 1, Type = 2, Size = ");
                                        sb.append(availableObjectSizeIsBytes);
                                        sb.append(") (");
                                        int i7 = i + 1;
                                        sb.append(i7);
                                        j3 = j2;
                                        sb.append("/");
                                        sb.append(i3);
                                        sb.append(str);
                                        logi(sb.toString());
                                        writeCreateRequest(2, availableObjectSizeIsBytes);
                                        this.mService.sendLogBroadcast(10, "Data object (" + i7 + "/" + i3 + ") created");
                                        this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                        z2 = z3;
                                    } else {
                                        j3 = j2;
                                        this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                                        z2 = false;
                                    }
                                    try {
                                        logi("Uploading firmware...");
                                        uploadFirmwareImage(this.mPacketCharacteristic);
                                        logi("Sending Calculate Checksum command (Op Code = 3)");
                                        ObjectChecksum readChecksum = readChecksum();
                                        logi(String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                                        this.mService.sendLogBroadcast(10, String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                                        int bytesSent = this.mProgressInfo.getBytesSent() - readChecksum.offset;
                                        if (bytesSent > 0) {
                                            logw(bytesSent + " bytes were lost!");
                                            this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                                            try {
                                                this.mFirmwareStream.reset();
                                                this.mFirmwareStream.read(new byte[(selectObject.maxSize - bytesSent)]);
                                                this.mProgressInfo.setBytesSent(readChecksum.offset);
                                                this.mPacketsBeforeNotification = 1;
                                                setPacketReceiptNotifications(1);
                                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1" + str);
                                            } catch (IOException e) {
                                                loge("Error while reading firmware stream", e);
                                                this.mService.terminateConnection(bluetoothGatt2, 4100);
                                                return;
                                            }
                                        }
                                        int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                                        if (crc32 != readChecksum.CRC32) {
                                            String str2 = str;
                                            String format = String.format(Locale.US, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(readChecksum.CRC32));
                                            if (i6 < 3) {
                                                i6++;
                                                String str3 = format + String.format(Locale.US, " Retrying...(%d/%d)", Integer.valueOf(i6), 3);
                                                logi(str3);
                                                this.mService.sendLogBroadcast(15, str3);
                                                try {
                                                    this.mFirmwareStream.reset();
                                                    this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                                                    str = str2;
                                                    j2 = j3;
                                                } catch (IOException e2) {
                                                    loge("Error while resetting the firmware stream", e2);
                                                    this.mService.terminateConnection(bluetoothGatt2, 4100);
                                                    return;
                                                }
                                            } else {
                                                loge(format);
                                                this.mService.sendLogBroadcast(20, format);
                                                this.mService.terminateConnection(bluetoothGatt2, 4109);
                                                return;
                                            }
                                        } else if (bytesSent > 0) {
                                            j2 = j3;
                                            z = true;
                                        } else {
                                            logi("Executing data object (Op Code = 4)");
                                            writeExecute(this.mProgressInfo.isComplete());
                                            this.mService.sendLogBroadcast(10, "Data object executed");
                                            i++;
                                            this.mFirmwareStream.mark(0);
                                            elapsedRealtime = j3;
                                        }
                                    } catch (DeviceDisconnectedException e3) {
                                        loge("Disconnected while sending data");
                                        throw e3;
                                    }
                                }
                                j = j2;
                                break loop0;
                            }
                        } else {
                            j = elapsedRealtime;
                            logi("Executing data object (Op Code = 4)");
                            writeExecute(true);
                            this.mService.sendLogBroadcast(10, "Data object executed");
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        StringBuilder sb2 = new StringBuilder("Transfer of ");
                        sb2.append(this.mProgressInfo.getBytesSent() - selectObject.offset);
                        sb2.append(" bytes has taken ");
                        long j4 = elapsedRealtime2 - j;
                        sb2.append(j4);
                        sb2.append(" ms");
                        logi(sb2.toString());
                        this.mService.sendLogBroadcast(10, "Upload completed in " + j4 + " ms");
                    }
                    logi("Executing data object (Op Code = 4)");
                    writeExecute();
                    this.mService.sendLogBroadcast(10, "Data object executed");
                } else {
                    logi(selectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, selectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i4);
                    this.mProgressInfo.setBytesReceived(i4);
                    selectObject.offset = selectObject.offset - i5;
                    selectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + selectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + selectObject.offset + "...");
                }
            } catch (IOException e4) {
                loge("Error while reading firmware stream", e4);
                this.mService.terminateConnection(bluetoothGatt2, 4100);
                return;
            }
        } else {
            this.mProgressInfo.setBytesSent(0);
            i = 0;
        }
        z = false;
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        if (selectObject.offset >= this.mImageSizeInBytes) {
        }
        long elapsedRealtime22 = SystemClock.elapsedRealtime();
        StringBuilder sb22 = new StringBuilder("Transfer of ");
        sb22.append(this.mProgressInfo.getBytesSent() - selectObject.offset);
        sb22.append(" bytes has taken ");
        long j42 = elapsedRealtime22 - j;
        sb22.append(j42);
        sb22.append(" ms");
        logi(sb22.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j42 + " ms");
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && (bArr[2] == 1 || bArr[2] == 2 || bArr[2] == 3 || bArr[2] == 4 || bArr[2] == 5 || bArr[2] == 7 || bArr[2] == 8 || bArr[2] == 10 || bArr[2] == 11)) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
            setNumberOfPackets(OP_CODE_PACKET_RECEIPT_NOTIF_REQ, i);
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_PACKET_RECEIPT_NOTIF_REQ);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 2);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Sending the number of packets failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
    }

    private void writeCreateRequest(int i, int i2) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
            setObjectSize(bArr, i2);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 1);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Creating Command object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Creating Command object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
    }

    private ObjectInfo selectObject(int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = OP_CODE_SELECT_OBJECT;
            bArr[1] = (byte) i;
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 6);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Selecting object failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectInfo objectInfo = new ObjectInfo();
                objectInfo.maxSize = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
                objectInfo.offset = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
                objectInfo.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 11).intValue();
                return objectInfo;
            } else {
                throw new RemoteDfuException("Selecting object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
    }

    private ObjectChecksum readChecksum() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 3);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectChecksum objectChecksum = new ObjectChecksum();
                objectChecksum.offset = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
                objectChecksum.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
                return objectChecksum;
            } else {
                throw new RemoteDfuException("Receiving Checksum failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeExecute() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 4);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Executing object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeExecute(boolean z) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (!z || e.getErrorNumber() != 5) {
                throw e;
            }
            logw(e.getMessage() + ": " + jaj.O000000o(517));
            if (this.mFileType == 1) {
                logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
            }
            this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", jaj.O000000o(517)));
            logi("SD busy? Retrying...");
            logi("Executing data object (Op Code = 4)");
            writeExecute();
        }
    }

    class ObjectInfo extends ObjectChecksum {
        protected int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    class ObjectChecksum {
        protected int CRC32;
        protected int offset;

        private ObjectChecksum() {
        }
    }
}
