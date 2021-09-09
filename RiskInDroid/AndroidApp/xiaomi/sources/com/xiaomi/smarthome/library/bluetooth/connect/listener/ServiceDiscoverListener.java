package com.xiaomi.smarthome.library.bluetooth.connect.listener;

import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;

public interface ServiceDiscoverListener extends GattResponseListener {
    void onServicesDiscovered(int i, BleGattProfile bleGattProfile);
}
