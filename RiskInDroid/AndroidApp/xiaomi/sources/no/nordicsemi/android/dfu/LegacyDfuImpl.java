package no.nordicsemi.android.dfu;

import _m_j.jai;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class LegacyDfuImpl extends BaseCustomDfuImpl {
    protected static final UUID DEFAULT_DFU_CONTROL_POINT_UUID = new UUID(23300500811742L, 1523193452336828707L);
    protected static final UUID DEFAULT_DFU_PACKET_UUID = new UUID(23304795779038L, 1523193452336828707L);
    protected static final UUID DEFAULT_DFU_SERVICE_UUID = new UUID(23296205844446L, 1523193452336828707L);
    protected static final UUID DEFAULT_DFU_VERSION_UUID = new UUID(23313385713630L, 1523193452336828707L);
    protected static UUID DFU_CONTROL_POINT_UUID = DEFAULT_DFU_CONTROL_POINT_UUID;
    protected static UUID DFU_PACKET_UUID = DEFAULT_DFU_PACKET_UUID;
    protected static UUID DFU_SERVICE_UUID = DEFAULT_DFU_SERVICE_UUID;
    protected static UUID DFU_VERSION_UUID = DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET = {5};
    private static final byte[] OP_CODE_INIT_DFU_PARAMS = {2};
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE = {2, 1};
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START = {2, 0};
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {8, 0, 0};
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE = {3};
    private static final byte[] OP_CODE_RESET = {6};
    private static final byte[] OP_CODE_START_DFU = {1, 0};
    private static final byte[] OP_CODE_START_DFU_V1 = {1};
    private static final byte[] OP_CODE_VALIDATE = {4};
    private final LegacyBluetoothCallback mBluetoothCallback = new LegacyBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    public boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected LegacyBluetoothCallback() {
            super();
        }

        /* access modifiers changed from: protected */
        public void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                DfuBaseService dfuBaseService = LegacyDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }
    }

    LegacyDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
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

    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
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

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x05d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x05d8, code lost:
        r2 = r0;
        loge("Disconnected while sending data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x05de, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x05e4, code lost:
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException("Starting DFU failed", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x05e5, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x05e6, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x05e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x05e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x05ea, code lost:
        r3 = r0;
        r2 = "Sending Reset command (Op Code = 6)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x05ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x05ee, code lost:
        r3 = r0;
        r2 = "Sending Reset command (Op Code = 6)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x05f3, code lost:
        r19 = r4;
        r20 = "Sending Reset command (Op Code = 6)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x05f7, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02b1, code lost:
        r3 = r0;
        r4 = r19;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b9, code lost:
        r3 = r0;
        r4 = r19;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c1, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02c7, code lost:
        if (r4.getErrorNumber() == 3) goto L_0x02c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02ca, code lost:
        if (r14 == 4) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02cc, code lost:
        r1.mRemoteErrorOccurred = false;
        logw("DFU target does not support DFU v.2");
        r1.mService.sendLogBroadcast(15, "DFU target does not support DFU v.2");
        r1.mService.sendLogBroadcast(1, "Switching to DFU v.1");
        logi("Resending Start DFU command (Op Code = 1)");
        writeOpCode(r1.mControlPointCharacteristic, no.nordicsemi.android.dfu.LegacyDfuImpl.OP_CODE_START_DFU_V1);
        r1.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
        logi("Sending application image size to DFU Packet: " + r1.mImageSizeInBytes + " bytes");
        writeImageSize(r1.mPacketCharacteristic, r1.mImageSizeInBytes);
        r4 = r1.mService;
        r4.sendLogBroadcast(10, "Firmware image size sent (" + r1.mImageSizeInBytes + " bytes)");
        r4 = readNotificationResponse();
        r7 = getStatusCode(r4, 1);
        r11 = r1.mService;
        r11.sendLogBroadcast(10, "Response received (Op Code = " + ((int) r4[1]) + ", Status = " + r7 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x035d, code lost:
        if (r7 == 2) goto L_0x035f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x035f, code lost:
        resetAndRestart(r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0362, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0364, code lost:
        if (r7 == 1) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0366, code lost:
        r3 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x036b A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0416 A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0428 A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x04ec A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x05cf A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x05e9 A[ExcHandler: UnknownResponseException (r0v5 'e' no.nordicsemi.android.dfu.internal.exception.UnknownResponseException A[CUSTOM_DECLARE]), Splitter:B:9:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05ed A[ExcHandler: UploadAbortedException (r0v4 'e' no.nordicsemi.android.dfu.internal.exception.UploadAbortedException A[CUSTOM_DECLARE]), Splitter:B:9:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x05f2 A[ExcHandler: RemoteDfuException (e no.nordicsemi.android.dfu.internal.exception.RemoteDfuException), Splitter:B:7:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c7 A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02af A[Catch:{ DeviceDisconnectedException -> 0x05d7, RemoteDfuException -> 0x02c0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, UploadAbortedException -> 0x02b8, UnknownResponseException -> 0x02b0, RemoteDfuException -> 0x05e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b0 A[ExcHandler: UnknownResponseException (r0v9 'e' no.nordicsemi.android.dfu.internal.exception.UnknownResponseException A[CUSTOM_DECLARE]), PHI: r20 10  PHI: (r20v6 java.lang.String) = (r20v4 java.lang.String), (r20v4 java.lang.String), (r20v8 java.lang.String), (r20v8 java.lang.String), (r20v12 java.lang.String), (r20v12 java.lang.String), (r20v12 java.lang.String) binds: [B:122:0x0483, B:124:0x0494, B:64:0x01c0, B:87:0x02c2, B:41:0x00ed, B:42:?, B:44:0x010c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:41:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02b8 A[ExcHandler: UploadAbortedException (r0v8 'e' no.nordicsemi.android.dfu.internal.exception.UploadAbortedException A[CUSTOM_DECLARE]), PHI: r20 10  PHI: (r20v5 java.lang.String) = (r20v4 java.lang.String), (r20v4 java.lang.String), (r20v8 java.lang.String), (r20v8 java.lang.String), (r20v12 java.lang.String), (r20v12 java.lang.String), (r20v12 java.lang.String) binds: [B:122:0x0483, B:124:0x0494, B:64:0x01c0, B:87:0x02c2, B:41:0x00ed, B:42:?, B:44:0x010c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:41:0x00ed] */
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        UploadAbortedException uploadAbortedException;
        String str;
        UnknownResponseException unknownResponseException;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int statusCode;
        RemoteDfuException remoteDfuException;
        Intent intent2 = intent;
        String str5 = "Reset request sent";
        logw("Legacy DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        int readVersion = readVersion(bluetoothGatt.getService(DFU_SERVICE_UUID).getCharacteristic(DFU_VERSION_UUID));
        if (readVersion < 5 || this.mInitPacketStream != null) {
            try {
                try {
                    enableCCCD(this.mControlPointCharacteristic, 1);
                    this.mService.sendLogBroadcast(10, "Notifications enabled");
                    this.mService.waitFor(1000);
                    int i7 = this.mFileType;
                    int i8 = (i7 & 1) > 0 ? this.mImageSizeInBytes : 0;
                    int i9 = (i7 & 2) > 0 ? this.mImageSizeInBytes : 0;
                    int i10 = i7 & 4;
                    if (i10 > 0) {
                        i2 = this.mImageSizeInBytes;
                        i = i9;
                    } else {
                        i = i9;
                        i2 = 0;
                    }
                    if (this.mFirmwareStream instanceof ArchiveInputStream) {
                        ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                        if (archiveInputStream.isSecureDfuRequired()) {
                            loge("Secure DFU is required to upload selected firmware");
                            this.mService.sendLogBroadcast(20, "The device does not support given firmware.");
                            logi("Sending Reset command (Op Code = 6)");
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                            this.mService.sendLogBroadcast(10, str5);
                            this.mService.terminateConnection(bluetoothGatt, 4099);
                            return;
                        }
                        i8 = archiveInputStream.softDeviceImageSize();
                        i3 = archiveInputStream.bootloaderImageSize();
                        i4 = archiveInputStream.applicationImageSize();
                    } else {
                        i4 = i2;
                        i3 = i;
                    }
                    str4 = str5;
                    try {
                        OP_CODE_START_DFU[1] = (byte) i7;
                        str3 = "Sending Reset command (Op Code = 6)";
                        try {
                            logi("Sending Start DFU command (Op Code = 1, Upload Mode = " + i7 + ")");
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_START_DFU);
                            DfuBaseService dfuBaseService = this.mService;
                            i5 = readVersion;
                            dfuBaseService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i7 + ")");
                            logi("Sending image size array to DFU Packet (" + i8 + "b, " + i3 + "b, " + i4 + "b)");
                            writeImageSize(this.mPacketCharacteristic, i8, i3, i4);
                            DfuBaseService dfuBaseService2 = this.mService;
                            dfuBaseService2.sendLogBroadcast(10, "Firmware image size sent (" + i8 + "b, " + i3 + "b, " + i4 + "b)");
                            byte[] readNotificationResponse = readNotificationResponse();
                            int statusCode2 = getStatusCode(readNotificationResponse, 1);
                            DfuBaseService dfuBaseService3 = this.mService;
                            dfuBaseService3.sendLogBroadcast(10, "Response received (Op Code = " + ((int) readNotificationResponse[1]) + " Status = " + statusCode2 + ")");
                            if (statusCode2 == 2) {
                                resetAndRestart(bluetoothGatt, intent2);
                            } else if (statusCode2 == 1) {
                                z = true;
                                if (this.mInitPacketStream != null) {
                                    this.mService.sendLogBroadcast(10, "Writing Initialize DFU Parameters...");
                                    if (z) {
                                        logi("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_START);
                                        logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                        writeInitData(this.mPacketCharacteristic, null);
                                        logi("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_COMPLETE);
                                        this.mService.sendLogBroadcast(10, "Initialize DFU Parameters completed");
                                    } else {
                                        logi("Sending the Initialize DFU Parameters (Op Code = 2)");
                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS);
                                        logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                        writeInitData(this.mPacketCharacteristic, null);
                                    }
                                    byte[] readNotificationResponse2 = readNotificationResponse();
                                    int statusCode3 = getStatusCode(readNotificationResponse2, 2);
                                    DfuBaseService dfuBaseService4 = this.mService;
                                    dfuBaseService4.sendLogBroadcast(10, "Response received (Op Code = " + ((int) readNotificationResponse2[1]) + ", Status = " + statusCode3 + ")");
                                    if (statusCode3 != 1) {
                                        throw new RemoteDfuException("Device returned error after sending init packet", statusCode3);
                                    }
                                }
                                if (!z) {
                                    if (this.mPacketsBeforeNotification <= 0 || this.mPacketsBeforeNotification > 10) {
                                        i6 = 10;
                                        if (i6 > 0) {
                                            this.mPacketsBeforeNotification = i6;
                                            logi("Sending the number of packets before notifications (Op Code = 8, Value = " + i6 + ")");
                                            setNumberOfPackets(OP_CODE_PACKET_RECEIPT_NOTIF_REQ, i6);
                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_PACKET_RECEIPT_NOTIF_REQ);
                                            DfuBaseService dfuBaseService5 = this.mService;
                                            dfuBaseService5.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i6 + ")");
                                        }
                                        logi("Sending Receive Firmware Image request (Op Code = 3)");
                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                                        this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        this.mProgressInfo.setBytesSent(0);
                                        logi("Uploading firmware...");
                                        this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                        uploadFirmwareImage(this.mPacketCharacteristic);
                                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                        byte[] readNotificationResponse3 = readNotificationResponse();
                                        statusCode = getStatusCode(readNotificationResponse3, 3);
                                        logi("Response received (Op Code = " + ((int) readNotificationResponse3[0]) + ", Req Op Code = " + ((int) readNotificationResponse3[1]) + ", Status = " + ((int) readNotificationResponse3[2]) + ")");
                                        DfuBaseService dfuBaseService6 = this.mService;
                                        StringBuilder sb = new StringBuilder("Response received (Op Code = ");
                                        sb.append((int) readNotificationResponse3[1]);
                                        sb.append(", Status = ");
                                        sb.append(statusCode);
                                        sb.append(")");
                                        dfuBaseService6.sendLogBroadcast(10, sb.toString());
                                        if (statusCode == 1) {
                                            StringBuilder sb2 = new StringBuilder("Transfer of ");
                                            sb2.append(this.mProgressInfo.getBytesSent());
                                            sb2.append(" bytes has taken ");
                                            long j = elapsedRealtime2 - elapsedRealtime;
                                            sb2.append(j);
                                            sb2.append(" ms");
                                            logi(sb2.toString());
                                            DfuBaseService dfuBaseService7 = this.mService;
                                            dfuBaseService7.sendLogBroadcast(10, "Upload completed in " + j + " ms");
                                            logi("Sending Validate request (Op Code = 4)");
                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_VALIDATE);
                                            this.mService.sendLogBroadcast(10, "Validate request sent");
                                            byte[] readNotificationResponse4 = readNotificationResponse();
                                            int statusCode4 = getStatusCode(readNotificationResponse4, 4);
                                            logi("Response received (Op Code = " + ((int) readNotificationResponse4[0]) + ", Req Op Code = " + ((int) readNotificationResponse4[1]) + ", Status = " + ((int) readNotificationResponse4[2]) + ")");
                                            DfuBaseService dfuBaseService8 = this.mService;
                                            StringBuilder sb3 = new StringBuilder("Response received (Op Code = ");
                                            sb3.append((int) readNotificationResponse4[1]);
                                            sb3.append(", Status = ");
                                            sb3.append(statusCode4);
                                            sb3.append(")");
                                            dfuBaseService8.sendLogBroadcast(10, sb3.toString());
                                            if (statusCode4 == 1) {
                                                this.mProgressInfo.setProgress(-5);
                                                logi("Sending Activate and Reset request (Op Code = 5)");
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_ACTIVATE_AND_RESET);
                                                this.mService.sendLogBroadcast(10, "Activate and Reset request sent");
                                                this.mService.waitUntilDisconnected();
                                                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                                                finalize(intent2, i5 == 5);
                                                return;
                                            }
                                            throw new RemoteDfuException("Device returned validation error", statusCode4);
                                        }
                                        throw new RemoteDfuException("Device returned error after sending file", statusCode);
                                    }
                                }
                                i6 = this.mPacketsBeforeNotification;
                                if (i6 > 0) {
                                }
                                logi("Sending Receive Firmware Image request (Op Code = 3)");
                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                                this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                this.mProgressInfo.setBytesSent(0);
                                logi("Uploading firmware...");
                                this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                uploadFirmwareImage(this.mPacketCharacteristic);
                                long elapsedRealtime22 = SystemClock.elapsedRealtime();
                                byte[] readNotificationResponse32 = readNotificationResponse();
                                statusCode = getStatusCode(readNotificationResponse32, 3);
                                logi("Response received (Op Code = " + ((int) readNotificationResponse32[0]) + ", Req Op Code = " + ((int) readNotificationResponse32[1]) + ", Status = " + ((int) readNotificationResponse32[2]) + ")");
                                DfuBaseService dfuBaseService62 = this.mService;
                                StringBuilder sb4 = new StringBuilder("Response received (Op Code = ");
                                sb4.append((int) readNotificationResponse32[1]);
                                sb4.append(", Status = ");
                                sb4.append(statusCode);
                                sb4.append(")");
                                dfuBaseService62.sendLogBroadcast(10, sb4.toString());
                                if (statusCode == 1) {
                                }
                            } else {
                                throw new RemoteDfuException("Starting DFU failed", statusCode2);
                            }
                        } catch (RemoteDfuException e) {
                            e = e;
                            remoteDfuException = e;
                            if (remoteDfuException.getErrorNumber() != 3) {
                            }
                        } catch (UploadAbortedException e2) {
                        } catch (UnknownResponseException e3) {
                        }
                    } catch (RemoteDfuException e4) {
                        e = e4;
                        str3 = "Sending Reset command (Op Code = 6)";
                        i5 = readVersion;
                        remoteDfuException = e;
                        if (remoteDfuException.getErrorNumber() != 3) {
                            throw remoteDfuException;
                        } else if (i10 <= 0 || (i7 & 3) <= 0) {
                            throw remoteDfuException;
                        } else {
                            this.mRemoteErrorOccurred = false;
                            logw("DFU target does not support (SD/BL)+App update");
                            this.mService.sendLogBroadcast(15, "DFU target does not support (SD/BL)+App update");
                            int i11 = i7 & -5;
                            this.mFileType = i11;
                            OP_CODE_START_DFU[1] = (byte) i11;
                            this.mProgressInfo.setTotalPart(2);
                            ((ArchiveInputStream) this.mFirmwareStream).setContentType(i11);
                            this.mService.sendLogBroadcast(1, "Sending only SD/BL");
                            logi("Resending Start DFU command (Op Code = 1, Upload Mode = " + i11 + ")");
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_START_DFU);
                            DfuBaseService dfuBaseService9 = this.mService;
                            dfuBaseService9.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i11 + ")");
                            logi("Sending image size array to DFU Packet: [" + i8 + "b, " + i3 + "b, 0b]");
                            writeImageSize(this.mPacketCharacteristic, i8, i3, 0);
                            DfuBaseService dfuBaseService10 = this.mService;
                            dfuBaseService10.sendLogBroadcast(10, "Firmware image size sent [" + i8 + "b, " + i3 + "b, 0b]");
                            byte[] readNotificationResponse5 = readNotificationResponse();
                            int statusCode5 = getStatusCode(readNotificationResponse5, 1);
                            DfuBaseService dfuBaseService11 = this.mService;
                            dfuBaseService11.sendLogBroadcast(10, "Response received (Op Code = " + ((int) readNotificationResponse5[1]) + " Status = " + statusCode5 + ")");
                            if (statusCode5 == 2) {
                                resetAndRestart(bluetoothGatt, intent2);
                                return;
                            }
                            if (statusCode5 != 1) {
                                throw new RemoteDfuException("Starting DFU failed", statusCode5);
                            }
                            z = true;
                            if (this.mInitPacketStream != null) {
                            }
                            if (!z) {
                            }
                            i6 = this.mPacketsBeforeNotification;
                            if (i6 > 0) {
                            }
                            logi("Sending Receive Firmware Image request (Op Code = 3)");
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                            this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                            long elapsedRealtime32 = SystemClock.elapsedRealtime();
                            this.mProgressInfo.setBytesSent(0);
                            logi("Uploading firmware...");
                            this.mService.sendLogBroadcast(10, "Uploading firmware...");
                            uploadFirmwareImage(this.mPacketCharacteristic);
                            long elapsedRealtime222 = SystemClock.elapsedRealtime();
                            byte[] readNotificationResponse322 = readNotificationResponse();
                            statusCode = getStatusCode(readNotificationResponse322, 3);
                            logi("Response received (Op Code = " + ((int) readNotificationResponse322[0]) + ", Req Op Code = " + ((int) readNotificationResponse322[1]) + ", Status = " + ((int) readNotificationResponse322[2]) + ")");
                            DfuBaseService dfuBaseService622 = this.mService;
                            StringBuilder sb42 = new StringBuilder("Response received (Op Code = ");
                            sb42.append((int) readNotificationResponse322[1]);
                            sb42.append(", Status = ");
                            sb42.append(statusCode);
                            sb42.append(")");
                            dfuBaseService622.sendLogBroadcast(10, sb42.toString());
                            if (statusCode == 1) {
                            }
                        }
                    } catch (UploadAbortedException e5) {
                        uploadAbortedException = e5;
                        str = "Sending Reset command (Op Code = 6)";
                        str5 = str4;
                        logi(str);
                        this.mAborted = false;
                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                        this.mService.sendLogBroadcast(10, str5);
                        throw uploadAbortedException;
                    } catch (UnknownResponseException e6) {
                        unknownResponseException = e6;
                        str2 = "Sending Reset command (Op Code = 6)";
                        str5 = str4;
                        loge(unknownResponseException.getMessage());
                        this.mService.sendLogBroadcast(20, unknownResponseException.getMessage());
                        logi(str2);
                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                        this.mService.sendLogBroadcast(10, str5);
                        this.mService.terminateConnection(bluetoothGatt, 4104);
                    }
                } catch (UploadAbortedException e7) {
                } catch (UnknownResponseException e8) {
                } catch (RemoteDfuException e9) {
                    RemoteDfuException remoteDfuException2 = e9;
                    str4 = str5;
                    str3 = "Sending Reset command (Op Code = 6)";
                    int errorNumber = remoteDfuException2.getErrorNumber() | 256;
                    loge(remoteDfuException2.getMessage() + ": " + jai.O000000o(errorNumber));
                    this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", jai.O000000o(errorNumber)));
                    logi(str3);
                    writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                    this.mService.sendLogBroadcast(10, str4);
                    this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
                }
            } catch (UploadAbortedException e10) {
                str = "Sending Reset command (Op Code = 6)";
                uploadAbortedException = e10;
                logi(str);
                this.mAborted = false;
                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                this.mService.sendLogBroadcast(10, str5);
                throw uploadAbortedException;
            } catch (UnknownResponseException e11) {
                str2 = "Sending Reset command (Op Code = 6)";
                unknownResponseException = e11;
                loge(unknownResponseException.getMessage());
                this.mService.sendLogBroadcast(20, unknownResponseException.getMessage());
                logi(str2);
                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                this.mService.sendLogBroadcast(10, str5);
                this.mService.terminateConnection(bluetoothGatt, 4104);
            } catch (RemoteDfuException e12) {
            }
        } else {
            logw("Init packet not set for the DFU Bootloader version ".concat(String.valueOf(readVersion)));
            this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
            this.mService.terminateConnection(bluetoothGatt, 4107);
        }
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == i && bArr[2] > 0 && bArr[2] <= 6) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, i);
    }

    private int readVersion(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        if (bArr[0] == 6 || bArr[0] == 5) {
            z = true;
        }
        writeOpCode(bluetoothGattCharacteristic, bArr, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096  */
    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[4]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        DfuBaseService dfuBaseService = this.mService;
        dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        DfuBaseService dfuBaseService2 = this.mService;
        dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mImageSizeInProgress && this.mConnected && this.mError == 0 && !this.mAborted) || this.mPaused) {
                        this.mLock.wait();
                    }
                }
                if (!this.mAborted) {
                    throw new UploadAbortedException();
                } else if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Size", this.mError);
                } else if (!this.mConnected) {
                    throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
                } else {
                    return;
                }
            }
            break;
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        DfuBaseService dfuBaseService = this.mService;
        dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        DfuBaseService dfuBaseService2 = this.mService;
        dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mImageSizeInProgress && this.mConnected && this.mError == 0 && !this.mAborted) || this.mPaused) {
                        this.mLock.wait();
                    }
                }
                if (!this.mAborted) {
                    throw new UploadAbortedException();
                } else if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                } else if (!this.mConnected) {
                    throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
                } else {
                    return;
                }
            }
            break;
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
        }
    }

    private void resetAndRestart(BluetoothGatt bluetoothGatt, Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }
}
