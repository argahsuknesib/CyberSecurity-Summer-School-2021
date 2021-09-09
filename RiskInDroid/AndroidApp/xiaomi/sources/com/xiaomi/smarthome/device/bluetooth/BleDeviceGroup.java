package com.xiaomi.smarthome.device.bluetooth;

import _m_j.fpo;
import _m_j.gpn;
import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.device.BleDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BleDeviceGroup extends BleDevice {
    public int mDeviceCount;
    public HashMap<String, List<BleDevice>> mDevices;

    public BleDeviceGroup() {
        if (this.mDevices == null) {
            this.mDevices = new HashMap<>();
        }
    }

    public final int O0000Oo0() {
        return this.mDeviceCount;
    }

    public final boolean O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String O00000Oo : this.mDevices.keySet()) {
            if (fpo.O00000Oo(O00000Oo, str)) {
                return true;
            }
        }
        return false;
    }

    public final List<BleDevice> O0000OoO() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<BleDevice>> value : this.mDevices.entrySet()) {
            arrayList.addAll((List) value.getValue());
        }
        if (!gpn.O000000o(arrayList)) {
            Collections.sort(arrayList, BleDevice.f6893O000000o);
        }
        return arrayList;
    }

    public final ArrayList<XmBluetoothDevice> O0000Ooo() {
        ArrayList<XmBluetoothDevice> arrayList = new ArrayList<>();
        for (BleDevice O000000o2 : O0000OoO()) {
            arrayList.add(O000000o2.O000000o());
        }
        return arrayList;
    }

    public final void O000000o(BleDevice bleDevice) {
        if (bleDevice != null && !TextUtils.isEmpty(bleDevice.model)) {
            if (this.mDevices.isEmpty()) {
                this.model = bleDevice.model;
                this.mac = bleDevice.mac;
                this.did = bleDevice.did;
                this.canAuth = false;
                this.mPacket = bleDevice.O00000Oo();
                setOwner(true);
            }
            List list = this.mDevices.get(bleDevice.model);
            if (list == null) {
                list = new ArrayList();
                this.mDevices.put(bleDevice.model, list);
            }
            if (!list.contains(bleDevice)) {
                list.add(bleDevice);
                this.mDeviceCount++;
            }
        }
    }

    public final ArrayList<String> O0000o00() {
        return new ArrayList<>(this.mDevices.keySet());
    }
}
