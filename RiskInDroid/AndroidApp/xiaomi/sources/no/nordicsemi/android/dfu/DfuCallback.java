package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGattCallback;

interface DfuCallback extends DfuController {

    public static class DfuGattCallback extends BluetoothGattCallback {
        public void onDisconnected() {
        }
    }

    DfuGattCallback getGattCallback();

    void onBondStateChanged(int i);
}
