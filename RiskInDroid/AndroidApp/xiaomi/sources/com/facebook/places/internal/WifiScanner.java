package com.facebook.places.internal;

import java.util.List;

public interface WifiScanner {
    WifiScanResult getConnectedWifi() throws ScannerException;

    List<WifiScanResult> getWifiScans() throws ScannerException;

    void initAndCheckEligibility() throws ScannerException;

    boolean isWifiScanningEnabled();
}
