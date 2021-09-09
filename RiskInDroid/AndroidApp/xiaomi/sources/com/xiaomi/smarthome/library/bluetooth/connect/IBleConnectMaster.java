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

public interface IBleConnectMaster {
    void connect(BleConnectOptions bleConnectOptions, BleConnectResponse bleConnectResponse);

    void disconnect();

    void indication(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse);

    void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse);

    void readRemoteRssi(BleReadRssiResponse bleReadRssiResponse);

    void refreshGattCache();

    void requestConnectionPriority(int i);

    void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse);

    void unindication(UUID uuid, UUID uuid2);

    void unnotify(UUID uuid, UUID uuid2);

    void write(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteResponse bleWriteResponse);

    void writeNoRsp(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);

    void writeNoRspFast(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse);
}
