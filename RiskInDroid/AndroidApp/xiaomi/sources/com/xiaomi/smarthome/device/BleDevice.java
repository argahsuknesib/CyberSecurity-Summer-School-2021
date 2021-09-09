package com.xiaomi.smarthome.device;

import _m_j.ffs;
import _m_j.fob;
import _m_j.foc;
import _m_j.gnk;
import _m_j.gnl;
import _m_j.gqb;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Comparator;

public class BleDevice extends Device {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Comparator<BleDevice> f6893O000000o = new Comparator<BleDevice>() {
        /* class com.xiaomi.smarthome.device.BleDevice.AnonymousClass1 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return foc.O00000o0(((BleDevice) obj2).mac) - foc.O00000o0(((BleDevice) obj).mac);
        }
    };
    public boolean debug;
    public boolean isNetGateConnected = true;
    protected MiotBleAdvPacket mPacket;
    public byte[] scanRecord;

    public boolean hasShortcut() {
        return true;
    }

    public boolean isOnlineAdvance() {
        return true;
    }

    public BleDevice() {
        this.pid = Device.PID_BLUETOOTH;
    }

    public static BleDevice O000000o(String str) {
        return DeviceRouterFactory.getBleManager().allocDevice(str);
    }

    public static BleDevice O000000o(BtDevice btDevice) {
        BleDevice O000000o2 = O000000o(btDevice.getMac());
        if (O000000o2 != null) {
            O000000o2.rssi = btDevice.getRssi();
            O000000o2.scanRecord = btDevice.scanRecord;
            O000000o2.mPacket = btDevice.O000000o();
        }
        return O000000o2;
    }

    public static BleDevice O000000o(XmBluetoothDevice xmBluetoothDevice) {
        BleDevice O000000o2 = O000000o(xmBluetoothDevice.getAddress());
        if (O000000o2 != null) {
            O000000o2.name = xmBluetoothDevice.device.getName();
            O000000o2.scanRecord = xmBluetoothDevice.scanRecord;
            O000000o2.rssi = xmBluetoothDevice.rssi;
        }
        return O000000o2;
    }

    public final XmBluetoothDevice O000000o() {
        XmBluetoothDevice xmBluetoothDevice = new XmBluetoothDevice();
        xmBluetoothDevice.device = gnl.O00000Oo(this.mac);
        xmBluetoothDevice.rssi = this.rssi;
        xmBluetoothDevice.scanRecord = this.scanRecord;
        return xmBluetoothDevice;
    }

    public final MiotBleAdvPacket O00000Oo() {
        return this.mPacket;
    }

    public void setDid(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.did = str;
        }
    }

    public final void O00000oo() {
        XmBluetoothManager.getInstance().disconnect(this.mac);
    }

    public final boolean O0000O0o() {
        return ffs.O000000o(this.model) == 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = " + gqb.O0000O0o(this.name));
        sb.append(", model = " + gqb.O0000O0o(this.model));
        if (!TextUtils.isEmpty(this.mac) && this.mac.length() > 2) {
            sb.append(", mac=...");
            sb.append(this.mac.substring(this.mac.length() - 2));
        }
        sb.append(", permit = " + this.permitLevel);
        sb.append(", rssi = " + this.rssi);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BleDevice) && super.equals(obj)) {
            return this.mac.equals(((BleDevice) obj).mac);
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.mac.hashCode();
    }

    public final String O0000OOo() {
        String[] split;
        int length;
        if (this instanceof BleDeviceGroup) {
            return O00000Oo(this.model);
        }
        String str = this.mac;
        return String.format("%s(%s)", getName(), (TextUtils.isEmpty(str) || (length = (split = str.split(":")).length) < 2) ? "" : String.format("%s%s", split[length - 2], split[length - 1]));
    }

    public int O0000Oo0() {
        if (!(this instanceof BleDeviceGroup) || "xiaomi.ble.v1".equalsIgnoreCase(this.model)) {
            return 1;
        }
        return ((BleDeviceGroup) this).mDeviceCount;
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("yeelink.light.ble1".equalsIgnoreCase(str)) {
            return gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.yeelight_name);
        }
        if ("zimi.powerbank.v1".equalsIgnoreCase(str)) {
            return gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.zimi_power_name);
        }
        if ("xiaomi.ble.v1".equalsIgnoreCase(str)) {
            return gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.xiaomi_bracelet);
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null) {
            return O00000oO.O0000Oo0();
        }
        gnk.O00000Oo(String.format("getDefaultName: there is no plugin record for model %s", str));
        return "";
    }

    public String getName() {
        if (TextUtils.isEmpty(this.name) || "null".equalsIgnoreCase(this.name)) {
            return O00000Oo(this.model);
        }
        return this.name;
    }

    public final int O0000Oo() {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.model);
        if (O00000oO != null) {
            return O00000oO.O0000oo0();
        }
        return 0;
    }

    public final void O000000o(boolean z) {
        this.isNew = z;
        fob.O000000o(this.mac, z);
    }

    public final boolean O00000o0() {
        if (!ffs.O00000Oo(this.model)) {
            return false;
        }
        if (!O00000oO()) {
            O000000o(true);
        }
        foc.O000000o(this.mac, 1);
        return true;
    }

    public final boolean O00000o() {
        return (!TextUtils.isEmpty(this.did) && !TextUtils.equals(this.did, this.mac)) && foc.O0000OOo(this.mac) == 2;
    }

    public final boolean O00000oO() {
        return ffs.O00000Oo(this.model) && foc.O0000OOo(this.mac) == 1;
    }

    public static int O00000o0(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null) {
            return O00000oO.O0000oo();
        }
        return 0;
    }

    public static String O00000o(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        return O00000oO != null ? O00000oO.O0000o00() : "";
    }
}
