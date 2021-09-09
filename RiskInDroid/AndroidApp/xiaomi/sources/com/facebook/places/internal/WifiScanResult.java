package com.facebook.places.internal;

public class WifiScanResult {
    public String bssid;
    public int frequency;
    public int rssi;
    public String ssid;
    public long timestampMs;

    public WifiScanResult() {
    }

    public WifiScanResult(String str, String str2, int i, int i2, long j) {
        this.ssid = str;
        this.bssid = str2;
        this.rssi = i;
        this.frequency = i2;
        this.timestampMs = j;
    }
}
