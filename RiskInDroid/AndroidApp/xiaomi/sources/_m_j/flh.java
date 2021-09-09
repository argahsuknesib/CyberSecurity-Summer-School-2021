package _m_j;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import java.lang.reflect.Method;

public final class flh {
    public static boolean O000000o(BluetoothDevice bluetoothDevice, BluetoothProfile bluetoothProfile) {
        if (bluetoothDevice == null || bluetoothProfile == null) {
            return false;
        }
        if (bluetoothDevice.getBondState() != 12) {
            gnk.O00000oO("ClassicBtUtil connectBluetoothProfile ,device is un bonded ");
            return false;
        }
        O000000o(bluetoothDevice, bluetoothProfile, 100);
        try {
            Method declaredMethod = bluetoothProfile.getClass().getDeclaredMethod("connect", BluetoothDevice.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(bluetoothProfile, bluetoothDevice);
            return true;
        } catch (Exception e) {
            gnk.O00000Oo("ClassBtUtil connect exception:" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean O00000Oo(BluetoothDevice bluetoothDevice, BluetoothProfile bluetoothProfile) {
        if (bluetoothDevice == null || bluetoothProfile == null) {
            gnk.O00000oO("ClassicBtUtil disconnectBluetoothProfile ,device or profile is null! ");
            return false;
        } else if (bluetoothDevice.getBondState() != 12) {
            gnk.O00000oO("ClassicBtUtil disconnectBluetoothProfile ,device is un bonded ");
            return false;
        } else {
            O000000o(bluetoothDevice, bluetoothProfile, 0);
            try {
                Method declaredMethod = bluetoothProfile.getClass().getDeclaredMethod("disconnect", BluetoothDevice.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bluetoothProfile, bluetoothDevice);
                return true;
            } catch (Exception e) {
                gnk.O00000Oo("ClassBtUtil disconnect exception:" + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private static void O000000o(BluetoothDevice bluetoothDevice, BluetoothProfile bluetoothProfile, int i) {
        if (bluetoothProfile != null) {
            try {
                bluetoothProfile.getClass().getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
