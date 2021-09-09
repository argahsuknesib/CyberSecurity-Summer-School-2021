package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.BaseDfuImpl;

abstract class BaseButtonlessDfuImpl extends BaseDfuImpl {
    private final ButtonlessBluetoothCallback mBluetoothCallback = new ButtonlessBluetoothCallback();

    public class ButtonlessBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        protected ButtonlessBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            DfuBaseService dfuBaseService = BaseButtonlessDfuImpl.this.mService;
            dfuBaseService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
            BaseButtonlessDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
            BaseButtonlessDfuImpl.this.notifyLock();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            BaseButtonlessDfuImpl baseButtonlessDfuImpl = BaseButtonlessDfuImpl.this;
            baseButtonlessDfuImpl.mRequestCompleted = true;
            baseButtonlessDfuImpl.notifyLock();
        }
    }

    BaseButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    /* access modifiers changed from: protected */
    public void finalize(Intent intent, boolean z, boolean z2) {
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.mService.refreshDeviceCache(this.mGatt, z || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12 && (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false) || !booleanExtra)) {
            removeBond();
            this.mService.waitFor(2000);
        }
        logi("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, z2);
    }
}
