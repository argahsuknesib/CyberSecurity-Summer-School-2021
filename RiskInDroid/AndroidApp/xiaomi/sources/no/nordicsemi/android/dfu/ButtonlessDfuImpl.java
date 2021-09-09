package no.nordicsemi.android.dfu;

import _m_j.jaj;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};

    /* access modifiers changed from: protected */
    public abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    /* access modifiers changed from: protected */
    public abstract int getResponseType();

    /* access modifiers changed from: protected */
    public abstract boolean shouldScanForBootloader();

    ButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r5 = r12.mReceivedData;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0079 */
    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic buttonlessDfuCharacteristic = getButtonlessDfuCharacteristic();
        int responseType = getResponseType();
        enableCCCD(buttonlessDfuCharacteristic, getResponseType());
        DfuBaseService dfuBaseService = this.mService;
        StringBuilder sb = new StringBuilder();
        sb.append(responseType == 2 ? "Indications" : "Notifications");
        sb.append(" enabled");
        dfuBaseService.sendLogBroadcast(10, sb.toString());
        this.mService.waitFor(1000);
        try {
            this.mProgressInfo.setProgress(-3);
            logi("Sending Enter Bootloader (Op Code = 1)");
            writeOpCode(buttonlessDfuCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
            this.mService.sendLogBroadcast(10, "Enter bootloader sent (Op Code = 1)");
            byte[] bArr = readNotificationResponse();
            if (bArr != null) {
                int statusCode = getStatusCode(bArr, 1);
                logi("Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + statusCode + ")");
                DfuBaseService dfuBaseService2 = this.mService;
                dfuBaseService2.sendLogBroadcast(10, "Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + statusCode + ")");
                if (statusCode == 1) {
                    this.mService.waitUntilDisconnected();
                } else {
                    throw new RemoteDfuException("Device returned error after sending Enter Bootloader", statusCode);
                }
            } else {
                logi("Device disconnected before receiving notification");
            }
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
            finalize(intent, false, shouldScanForBootloader());
        } catch (UnknownResponseException e) {
            loge(e.getMessage());
            this.mService.sendLogBroadcast(20, e.getMessage());
            this.mService.terminateConnection(bluetoothGatt, 4104);
        } catch (RemoteDfuException e2) {
            int errorNumber = e2.getErrorNumber() | 2048;
            loge(e2.getMessage());
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", jaj.O00000o0(errorNumber)));
            this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
        }
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        if (bArr != null && bArr.length >= 3 && bArr[0] == 32 && bArr[1] == i && (bArr[2] == 1 || bArr[2] == 2 || bArr[2] == 4)) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 32, i);
    }
}
