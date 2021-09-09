package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class ExperimentalButtonlessDfuImpl extends ButtonlessDfuImpl {
    protected static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = new UUID(-8196551313441075360L, -6937650605005804976L);
    protected static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID = new UUID(-8196551313441075360L, -6937650605005804976L);
    protected static UUID EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
    protected static UUID EXPERIMENTAL_BUTTONLESS_DFU_UUID = DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
    private BluetoothGattCharacteristic mButtonlessDfuCharacteristic;

    /* access modifiers changed from: protected */
    public int getResponseType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean shouldScanForBootloader() {
        return true;
    }

    ExperimentalButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(EXPERIMENTAL_BUTTONLESS_DFU_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mButtonlessDfuCharacteristic = characteristic;
        return true;
    }

    /* access modifiers changed from: protected */
    public BluetoothGattCharacteristic getButtonlessDfuCharacteristic() {
        return this.mButtonlessDfuCharacteristic;
    }

    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logi("Experimental buttonless service found -> SDK 12.x");
        super.performDfu(intent);
    }
}
