package com.xiaomi.smarthome.uwb.lib.idm;

import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import java.util.List;

public interface UwbScanListener {
    void onScanState(int i);

    void onScanning(List<UwbScanDevice> list);
}
