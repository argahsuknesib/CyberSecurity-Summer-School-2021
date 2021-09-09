package _m_j;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.library.log.LogType;

public final class fpe extends fpc {
    private static final String[] O00000o = {"android.bluetooth.device.action.ACL_CONNECTED", "android.bluetooth.device.action.ACL_DISCONNECTED", "android.bluetooth.device.action.BOND_STATE_CHANGED"};
    private static fpe O00000oO;

    private fpe() {
        O000000o(O00000o);
    }

    public static fpe O00000Oo() {
        if (O00000oO == null) {
            O00000oO = new fpe();
        }
        return O00000oO;
    }

    public final boolean O000000o(Context context, Intent intent) {
        String action = intent.getAction();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            return false;
        }
        XmBluetoothDevice xmBluetoothDevice = new XmBluetoothDevice();
        xmBluetoothDevice.device = bluetoothDevice;
        String O00000o2 = foc.O00000o(bluetoothDevice.getAddress());
        if (TextUtils.isEmpty(O00000o2)) {
            return false;
        }
        if ("android.bluetooth.device.action.ACL_CONNECTED".equalsIgnoreCase(action)) {
            if (CoreApi.O000000o().O0000Oo(O00000o2) != null) {
                PluginApi.getInstance().sendMessage(context, O00000o2, 6, intent, null, null, true, null);
            }
            return true;
        } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equalsIgnoreCase(action)) {
            if (CoreApi.O000000o().O0000Oo(O00000o2) != null) {
                PluginApi.getInstance().sendMessage(context, O00000o2, 7, intent, null, null, true, null);
            }
            return true;
        } else {
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equalsIgnoreCase(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                BleDevice O000000o2 = BleDevice.O000000o(xmBluetoothDevice);
                LogType logType = LogType.BLUETOOTH;
                gsy.O00000o0(logType, "BondStateReceiver ", "state =" + intExtra + ",ble device:" + O000000o2.getName());
                O000000o2.model = O00000o2;
                if (intExtra == 10) {
                    LogType logType2 = LogType.BLUETOOTH;
                    gsy.O00000o0(logType2, "BondStateReceiver", "ble device state is bond none, isLocalBoundDevice=" + ffs.O00000Oo(O000000o2.model));
                    if (ffs.O00000Oo(O000000o2.model)) {
                        fob.O000000o(O000000o2);
                    }
                    return true;
                } else if (intExtra == 12) {
                    if (O000000o2.O00000o0()) {
                        fno.O000000o().O0000Oo0(O000000o2.did);
                        fob.O000000o(true);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
