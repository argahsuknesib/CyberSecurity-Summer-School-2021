package com.xiaomi.smarthome.library.bluetooth.connect;

import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadRssiResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.List;
import java.util.UUID;

public interface IBleConnectManager {
    void connect(String str, BleConnectOptions bleConnectOptions, BleConnectResponse bleConnectResponse);

    void disconnect(String str);

    void disconnectAllDevices();

    void indication(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse);

    void readRemoteRssi(String str, BleReadRssiResponse bleReadRssiResponse);

    void refreshGattCache(String str);

    void requestConnectionPriority(String str, int i);

    void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse);

    void unindication(String str, UUID uuid, UUID uuid2);

    void unnotify(String str, UUID uuid, UUID uuid2);

    void write(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteResponse bleWriteResponse);

    void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeNoRspFast(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);
}
