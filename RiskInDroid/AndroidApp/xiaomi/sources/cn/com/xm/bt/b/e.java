package cn.com.xm.bt.b;

import android.bluetooth.BluetoothDevice;

public interface e {
    void onDeviceConnected(BluetoothDevice bluetoothDevice, c cVar);

    void onDeviceConnecting(BluetoothDevice bluetoothDevice, c cVar);

    void onDeviceConnectingTimeout(BluetoothDevice bluetoothDevice, c cVar);

    void onDeviceDisconnected(BluetoothDevice bluetoothDevice, c cVar);
}
