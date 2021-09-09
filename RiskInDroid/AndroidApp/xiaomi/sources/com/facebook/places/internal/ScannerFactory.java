package com.facebook.places.internal;

import android.content.Context;
import android.os.Build;

public class ScannerFactory {
    public static BleScanner newBleScanner(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new BleScannerImpl(context, locationPackageRequestParams);
        }
        return new BleScannerLegacy();
    }

    public static WifiScanner newWifiScanner(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        return new WifiScannerImpl(context, locationPackageRequestParams);
    }

    public static LocationScanner newLocationScanner(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        return new LocationScannerImpl(context, locationPackageRequestParams);
    }
}
