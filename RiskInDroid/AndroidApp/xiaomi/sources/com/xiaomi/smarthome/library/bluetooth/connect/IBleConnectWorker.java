package com.xiaomi.smarthome.library.bluetooth.connect;

import com.xiaomi.smarthome.library.bluetooth.connect.listener.GattResponseListener;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.UUID;

public interface IBleConnectWorker {
    void clearGattResponseListener(GattResponseListener gattResponseListener);

    void closeGatt();

    boolean discoverService();

    int getCurrentStatus();

    BleGattProfile getGattProfile();

    void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    boolean openGatt();

    boolean readCharacteristic(UUID uuid, UUID uuid2);

    boolean readRemoteRssi();

    boolean refreshDeviceCache();

    void registerGattResponseListener(GattResponseListener gattResponseListener);

    boolean requestConnectionPriority(int i);

    boolean requestMtu(int i);

    boolean setCharacteristicIndication(UUID uuid, UUID uuid2, boolean z);

    boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z);

    boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr);

    boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr);
}
