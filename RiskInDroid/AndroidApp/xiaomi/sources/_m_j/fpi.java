package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fpi extends dcl {
    protected BleDevice O00000o;
    protected HashMap<String, BleDevice> O00000oO = new HashMap<>();
    protected List<String> O00000oo;

    public void O00000o0() {
    }

    private void O000000o(List<BleDevice> list) {
        this.O00000oO.clear();
        fte.O00000Oo(String.format("Matching Devices: ", new Object[0]));
        if (!gpn.O000000o(list)) {
            for (BleDevice next : list) {
                this.O00000oO.put(next.mac, next);
                fte.O00000Oo(String.format(">>> %s, name = %s, rssi = %d", fte.O000000o(next.mac), next.getName(), Integer.valueOf(next.rssi)));
            }
        }
    }

    public void O000000o(BleDevice bleDevice, List<String> list) {
        BleDeviceGroup O000000o2;
        this.O00000o = bleDevice;
        ArrayList arrayList = new ArrayList();
        if (bleDevice instanceof BleDeviceGroup) {
            arrayList.addAll(((BleDeviceGroup) bleDevice).O0000OoO());
        } else {
            arrayList.add(bleDevice);
        }
        if (list != null && list.size() > 0) {
            for (String next : list) {
                if (!TextUtils.equals(next, bleDevice.model) && (O000000o2 = fob.O000000o(next)) != null && O000000o2.O0000OoO().size() > 0) {
                    arrayList.addAll(O000000o2.O0000OoO());
                }
            }
        }
        O000000o(arrayList);
        this.O00000oo = list;
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        BleDevice bleDevice = this.O00000o;
        if (bleDevice == null) {
            return "";
        }
        String str = bleDevice.model;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        BleDevice bleDevice2 = this.O00000o;
        if (bleDevice2 instanceof BleDeviceGroup) {
            return ((BleDeviceGroup) bleDevice2).O0000o00().get(0);
        }
        gnk.O00000oO(String.format("BleMatchFragment.getModel return null", new Object[0]));
        return "";
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.O00000oo) == null || list.size() == 0) {
            return false;
        }
        return this.O00000oo.contains(str);
    }
}
