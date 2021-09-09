package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import java.lang.reflect.Method;

public final class bkz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static BluetoothManager f13029O000000o;
    private static BluetoothAdapter O00000Oo;

    public static boolean O000000o() {
        return Build.VERSION.SDK_INT >= 18 && bij.f13001O000000o != null && bij.f13001O000000o.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean O00000Oo() {
        return O00000o() == 12;
    }

    private static int O00000o() {
        BluetoothAdapter O00000o0 = O00000o0();
        if (O00000o0 != null) {
            return O00000o0.getState();
        }
        return 0;
    }

    public static BluetoothAdapter O00000o0() {
        if (O00000Oo == null) {
            O00000Oo = BluetoothAdapter.getDefaultAdapter();
        }
        return O00000Oo;
    }

    public static boolean O000000o(BluetoothGatt bluetoothGatt) {
        boolean z;
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    z = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    bky.O00000Oo(String.format("refreshDeviceCache return %b", Boolean.valueOf(z)));
                    return z;
                }
            } catch (Exception e) {
                bky.O000000o(e);
            }
        }
        z = false;
        bky.O00000Oo(String.format("refreshDeviceCache return %b", Boolean.valueOf(z)));
        return z;
    }

    public static void O000000o(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        bij.f13001O000000o.registerReceiver(broadcastReceiver, intentFilter);
    }
}
