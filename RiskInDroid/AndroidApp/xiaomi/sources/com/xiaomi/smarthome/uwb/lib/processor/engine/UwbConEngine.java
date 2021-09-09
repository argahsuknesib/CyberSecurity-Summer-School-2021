package com.xiaomi.smarthome.uwb.lib.processor.engine;

import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;

public interface UwbConEngine {

    public interface IEngineStateCallback {
        void onConnEstablished();

        void onConnectionError(int i, String str);

        void onEstablishSecurityError(int i, String str);

        void onRetryKeyRetrieve();

        void onSwitchCommunication(int i, String str);
    }

    void destroy(boolean z);

    void establishSecurityLine(String str, int i, String str2);

    UwbScanDevice getUwbDevice();

    boolean isDestroyed();

    boolean isSameUwbAddress(UwbScanDevice uwbScanDevice);

    boolean isUwbSetup();

    void retrieveKey();

    int sendPayload(Payload payload);

    int sendPayload(Payload payload, boolean z);

    void setupUwb();

    void startConnect();

    void switchCommunicationType();
}
