package _m_j;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.RemoteException;

public final class ffc extends ffb {
    public O000000o O0000O0o = null;

    public interface O000000o {
        void onConnectionStateChanged(String str, int i) throws RemoteException;

        void onReceiveData(String str, byte[] bArr) throws RemoteException;
    }

    public ffc(BluetoothManager bluetoothManager) {
        super(bluetoothManager);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        BluetoothDevice bluetoothDevice = this.f16208O000000o;
        if (bluetoothDevice != null) {
            O000000o o000000o = this.O0000O0o;
            if (o000000o != null) {
                try {
                    o000000o.onConnectionStateChanged(bluetoothDevice.getAddress(), i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                gnk.O00000oO("ClassicBtProvider onConnectionStateChanged listener is null");
            }
        } else {
            gnk.O00000o("ClassicBtProvider onConnectionStateChanged device is null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(byte[] bArr) {
        BluetoothDevice bluetoothDevice = this.f16208O000000o;
        O000000o o000000o = this.O0000O0o;
        if (o000000o == null || bluetoothDevice == null) {
            gnk.O00000o("ClassicBtProvider onConnectionStateChanged device is null");
            return;
        }
        try {
            o000000o.onReceiveData(bluetoothDevice.getAddress(), bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
