package com.xiaomi.smarthome.uwb.lib.processor;

import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;

public interface ProcessorCallback {
    void handleIotDeviceType(UwbScanDevice uwbScanDevice);

    void handleThirdTagType(UwbScanDevice uwbScanDevice);

    void handleTvType(UwbScanDevice uwbScanDevice);

    void onBindBuiltin(UwbScanDevice uwbScanDevice, DeviceBindHelper.BindDeviceListener bindDeviceListener);

    void onBindTag(UwbScanDevice uwbScanDevice, DeviceBindHelper.BindDeviceListener bindDeviceListener);

    void onDownloadMijia(int i);

    void onRetrieveMemberSpecificKey(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener);

    void startKeyRetrieve(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener);
}
