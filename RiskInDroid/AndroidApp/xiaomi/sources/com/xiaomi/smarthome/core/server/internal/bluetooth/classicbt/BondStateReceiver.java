package com.xiaomi.smarthome.core.server.internal.bluetooth.classicbt;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

public class BondStateReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o f6812O000000o;

    public interface O000000o {
        void onBondStateChange(BluetoothDevice bluetoothDevice, int i) throws RemoteException;
    }

    public BondStateReceiver(O000000o o000000o) {
        this.f6812O000000o = o000000o;
    }

    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice;
        if (intent.getAction().equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            if (bluetoothDevice2 != null && intExtra >= 0) {
                try {
                    if (this.f6812O000000o != null) {
                        this.f6812O000000o.onBondStateChange(bluetoothDevice2, intExtra);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else if (intent.getAction().equals("android.bluetooth.device.action.PAIRING_REQUEST") && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null) {
            try {
                if (this.f6812O000000o != null) {
                    this.f6812O000000o.onBondStateChange(bluetoothDevice, 11);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
