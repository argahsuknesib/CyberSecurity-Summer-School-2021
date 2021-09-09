package com.facebook.places.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.places.internal.ScannerException;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LocationPackageManager {

    public interface Listener {
        void onLocationPackage(LocationPackage locationPackage);
    }

    public static void requestLocationPackage(final LocationPackageRequestParams locationPackageRequestParams, final Listener listener) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.places.internal.LocationPackageManager.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                com.facebook.places.internal.LocationPackageManager.logException("Exception scanning for bluetooth beacons", r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                com.facebook.places.internal.LocationPackageManager.logException("Exception scanning for wifi access points", r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                com.facebook.places.internal.LocationPackageManager.logException("Exception getting location", r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a7, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a8, code lost:
                com.facebook.places.internal.LocationPackageManager.logException("Exception scanning for locations", r1);
                r0.locationError = r1.type;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[ExcHandler: ScannerException (r1v1 'e' com.facebook.places.internal.ScannerException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
            public final void run() {
                FutureTask<LocationPackage> futureTask;
                FutureTask<LocationPackage> futureTask2;
                LocationPackage locationPackage = new LocationPackage();
                try {
                    FutureTask<LocationPackage> futureTask3 = null;
                    if (locationPackageRequestParams.isLocationScanEnabled()) {
                        LocationScanner newLocationScanner = ScannerFactory.newLocationScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                        newLocationScanner.initAndCheckEligibility();
                        futureTask = LocationPackageManager.newLocationScanFuture(newLocationScanner, locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask);
                    } else {
                        futureTask = null;
                    }
                    if (locationPackageRequestParams.isWifiScanEnabled()) {
                        futureTask2 = LocationPackageManager.newWifiScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask2);
                    } else {
                        futureTask2 = null;
                    }
                    if (locationPackageRequestParams.isBluetoothScanEnabled()) {
                        futureTask3 = LocationPackageManager.newBluetoothScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask3);
                    }
                    if (futureTask3 != null) {
                        LocationPackage locationPackage2 = futureTask3.get();
                        locationPackage.ambientBluetoothLe = locationPackage2.ambientBluetoothLe;
                        locationPackage.isBluetoothScanningEnabled = locationPackage2.isBluetoothScanningEnabled;
                    }
                    if (futureTask2 != null) {
                        LocationPackage locationPackage3 = (LocationPackage) futureTask2.get();
                        locationPackage.isWifiScanningEnabled = locationPackage3.isWifiScanningEnabled;
                        locationPackage.connectedWifi = locationPackage3.connectedWifi;
                        locationPackage.ambientWifi = locationPackage3.ambientWifi;
                    }
                    if (futureTask != null) {
                        LocationPackage locationPackage4 = (LocationPackage) futureTask.get();
                        locationPackage.locationError = locationPackage4.locationError;
                        locationPackage.location = locationPackage4.location;
                    }
                } catch (ScannerException e) {
                } catch (Exception e2) {
                    LocationPackageManager.logException("Exception requesting a location package", e2);
                }
                listener.onLocationPackage(locationPackage);
            }
        });
    }

    public static FutureTask<LocationPackage> newLocationScanFuture(final LocationScanner locationScanner, LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            /* class com.facebook.places.internal.LocationPackageManager.AnonymousClass2 */

            public final LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    locationPackage.location = locationScanner.getLocation();
                } catch (ScannerException e) {
                    locationPackage.locationError = e.type;
                    LocationPackageManager.logException("Exception while getting location", e);
                } catch (Exception unused) {
                    locationPackage.locationError = ScannerException.Type.UNKNOWN_ERROR;
                }
                return locationPackage;
            }
        });
    }

    public static FutureTask<LocationPackage> newBluetoothScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            /* class com.facebook.places.internal.LocationPackageManager.AnonymousClass3 */

            /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|7|8|(1:10)(3:11|(1:13)|14)) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x0029 A[Catch:{ all -> 0x0052, Exception -> 0x0057 }] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[Catch:{ all -> 0x0052, Exception -> 0x0057 }] */
            public final LocationPackage call() throws Exception {
                BleScanner newBleScanner;
                LocationPackage locationPackage = new LocationPackage();
                try {
                    newBleScanner = ScannerFactory.newBleScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                    newBleScanner.initAndCheckEligibility();
                    newBleScanner.startScanning();
                    Thread.sleep(locationPackageRequestParams.getBluetoothScanDurationMs());
                    newBleScanner.stopScanning();
                    int errorCode = newBleScanner.getErrorCode();
                    if (errorCode != 0) {
                        locationPackage.ambientBluetoothLe = newBleScanner.getScanResults();
                        locationPackage.isBluetoothScanningEnabled = true;
                    } else {
                        if (FacebookSdk.isDebugEnabled()) {
                            Utility.logd("LocationPackageManager", String.format(Locale.getDefault(), "Bluetooth LE scan failed with error: %d", Integer.valueOf(errorCode)));
                        }
                        locationPackage.isBluetoothScanningEnabled = false;
                    }
                } catch (Exception e) {
                    LocationPackageManager.logException("Exception scanning for bluetooth beacons", e);
                    locationPackage.isBluetoothScanningEnabled = false;
                } catch (Throwable th) {
                    newBleScanner.stopScanning();
                    throw th;
                }
                return locationPackage;
            }
        });
    }

    public static FutureTask<LocationPackage> newWifiScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            /* class com.facebook.places.internal.LocationPackageManager.AnonymousClass4 */

            public final LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    WifiScanner newWifiScanner = ScannerFactory.newWifiScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                    newWifiScanner.initAndCheckEligibility();
                    locationPackage.connectedWifi = newWifiScanner.getConnectedWifi();
                    locationPackage.isWifiScanningEnabled = newWifiScanner.isWifiScanningEnabled();
                    if (locationPackage.isWifiScanningEnabled) {
                        locationPackage.ambientWifi = newWifiScanner.getWifiScans();
                    }
                } catch (Exception e) {
                    LocationPackageManager.logException("Exception scanning for wifi access points", e);
                    locationPackage.isWifiScanningEnabled = false;
                }
                return locationPackage;
            }
        });
    }

    public static void logException(String str, Throwable th) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e("LocationPackageManager", str, th);
        }
    }
}
