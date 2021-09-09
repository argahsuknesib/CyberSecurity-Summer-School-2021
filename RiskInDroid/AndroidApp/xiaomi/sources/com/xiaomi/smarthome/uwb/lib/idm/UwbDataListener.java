package com.xiaomi.smarthome.uwb.lib.idm;

import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;

public interface UwbDataListener {
    void onConnectionState(String str, int i);

    void onPayloadReceived(Payload payload);

    void onSendPayload(int i);
}
