package _m_j;

import android.net.wifi.ScanResult;
import java.util.ArrayList;

public interface htw {
    void cleanScrollToDid();

    int getTimeLen();

    ArrayList<ScanResult> getWifiScanResult();

    void init();

    boolean isFindingNew();

    void resetFinder();

    boolean scanNewDevice(htl htl, String str, String str2, String str3, String str4, String str5, long j);

    void setCurrentScrollToDid(String str);

    void startScan();

    void startScan(int i);

    void stopScanNewDevice();
}
