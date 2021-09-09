package cn.com.xm.bt.c;

import android.bluetooth.BluetoothDevice;

public interface d {

    public interface a {
        void a(BluetoothDevice bluetoothDevice);

        void b(BluetoothDevice bluetoothDevice);

        void c(BluetoothDevice bluetoothDevice);

        void d(BluetoothDevice bluetoothDevice);

        void e(BluetoothDevice bluetoothDevice);
    }

    public interface b {
        void notify(byte[] bArr);
    }

    void b(boolean z);

    public enum c {
        DISCONNECTING(3),
        DISCONNECTED(0),
        CONNECTING(1),
        CONNECTED(2);

        private c(int i) {
        }
    }
}
