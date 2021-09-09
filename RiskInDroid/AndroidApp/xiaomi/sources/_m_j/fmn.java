package _m_j;

import android.net.wifi.ScanResult;
import java.util.List;

public interface fmn {
    void changeScanResultToOnline(ScanResult scanResult);

    ScanResult getDeviceScanResult(String str);

    List<ScanResult> getDiscoveredUnconnectDevice();

    void registerReceiver();

    void unregisterReceiver();
}
