package _m_j;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class gnl extends glc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static BluetoothManager f18046O000000o;
    private static BluetoothAdapter O00000Oo;

    public static boolean O000000o() {
        return Build.VERSION.SDK_INT >= 18 && glc.O0000O0o != null && glc.O0000O0o.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean O00000Oo() {
        BluetoothAdapter O00000o = O00000o();
        return O00000o != null && O00000o.isEnabled();
    }

    public static void O000000o(String str) {
        glc.O0000O0o.sendBroadcast(new Intent(str));
    }

    public static BluetoothManager O00000o0() {
        if (!O000000o()) {
            return null;
        }
        if (f18046O000000o == null) {
            f18046O000000o = (BluetoothManager) glc.O0000O0o.getSystemService("bluetooth");
        }
        return f18046O000000o;
    }

    public static BluetoothAdapter O00000o() {
        if (O00000Oo == null) {
            O00000Oo = BluetoothAdapter.getDefaultAdapter();
        }
        return O00000Oo;
    }

    public static BluetoothDevice O00000Oo(String str) {
        BluetoothAdapter O00000o;
        if (!TextUtils.isEmpty(str) && (O00000o = O00000o()) != null) {
            try {
                return O00000o.getRemoteDevice(str);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static List<BluetoothDevice> O0000OOo() {
        if (Build.VERSION.SDK_INT < 18) {
            return gpn.O000000o();
        }
        BluetoothManager O00000o0 = O00000o0();
        if (O00000o0 != null) {
            return O00000o0.getConnectedDevices(7);
        }
        return gpn.O000000o();
    }

    public static List<BluetoothSearchResult> O00000oO() {
        ArrayList arrayList = new ArrayList();
        List<BluetoothDevice> O0000OOo = O0000OOo();
        if (!gpn.O000000o(O0000OOo)) {
            for (BluetoothDevice next : O0000OOo) {
                BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(next);
                bluetoothSearchResult.O00000o = 2;
                bluetoothSearchResult.O00000oO = next.getName();
                arrayList.add(bluetoothSearchResult);
            }
        }
        return arrayList;
    }

    private static List<BluetoothDevice> O0000Oo0() {
        Set<BluetoothDevice> bondedDevices;
        BluetoothAdapter O00000o = O00000o();
        ArrayList arrayList = new ArrayList();
        if (!(O00000o == null || (bondedDevices = O00000o.getBondedDevices()) == null)) {
            arrayList.addAll(bondedDevices);
        }
        return arrayList;
    }

    public static List<BluetoothSearchResult> O00000oo() {
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice next : O0000Oo0()) {
            BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(next);
            bluetoothSearchResult.O00000o = 1;
            bluetoothSearchResult.O00000oO = next.getName();
            arrayList.add(bluetoothSearchResult);
        }
        return arrayList;
    }

    @TargetApi(18)
    public static boolean O00000o0(String str) {
        if (!TextUtils.isEmpty(str) && O000000o()) {
            if (O00000o0().getConnectionState(O00000Oo(str), 7) == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !O000000o() || Build.VERSION.SDK_INT < 18 || O00000o0().getConnectionState(bluetoothDevice, 7) != 2) {
            return false;
        }
        return true;
    }

    private static boolean O00000Oo(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && bluetoothDevice.getBondState() == 12;
    }

    public static boolean O00000o(String str) {
        BluetoothDevice O00000Oo2 = O00000Oo(str);
        if (Build.VERSION.SDK_INT < 18 || O00000Oo2.getType() == 1) {
            return O00000Oo(O00000Oo2);
        }
        return O000000o(O00000Oo2);
    }

    public static boolean O00000oO(String str) {
        BluetoothDevice O00000Oo2;
        Method method;
        try {
            if (!(TextUtils.isEmpty(str) || (O00000Oo2 = O00000Oo(str)) == null || (method = O00000Oo2.getClass().getMethod("removeBond", new Class[0])) == null)) {
                return ((Boolean) method.invoke(O00000Oo2, new Object[0])).booleanValue();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean O0000O0o() {
        BluetoothAdapter O00000o;
        if (O00000Oo() || (O00000o = O00000o()) == null) {
            return false;
        }
        return O00000o.enable();
    }

    public static boolean O000000o(BluetoothGatt bluetoothGatt) {
        boolean z;
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    z = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    gnk.O00000o0(String.format("refreshDeviceCache return %b", Boolean.valueOf(z)));
                    return z;
                }
            } catch (Exception e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
            }
        }
        z = false;
        gnk.O00000o0(String.format("refreshDeviceCache return %b", Boolean.valueOf(z)));
        return z;
    }

    public static void O000000o(BroadcastReceiver broadcastReceiver) {
        try {
            glc.O0000O0o.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
        }
    }

    public static void O000000o(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        glc.O0000O0o.registerReceiver(broadcastReceiver, intentFilter);
    }
}
