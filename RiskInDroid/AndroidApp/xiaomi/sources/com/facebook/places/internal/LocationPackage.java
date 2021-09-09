package com.facebook.places.internal;

import android.location.Location;
import com.facebook.places.internal.ScannerException;
import java.util.List;

public class LocationPackage {
    public List<BluetoothScanResult> ambientBluetoothLe;
    public List<WifiScanResult> ambientWifi;
    public WifiScanResult connectedWifi;
    public boolean isBluetoothScanningEnabled;
    public boolean isWifiScanningEnabled;
    public Location location;
    public ScannerException.Type locationError;
}
