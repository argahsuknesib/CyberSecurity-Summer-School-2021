package com.xiaomi.smarthome.uwb.lib.processor.engine;

import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;

public interface IEngineSpecificKeyRetriever {
    void clearCacheKey(UwbScanDevice uwbScanDevice);

    void destroy();

    void startRetrieveSpecificKey(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener, boolean z);
}
