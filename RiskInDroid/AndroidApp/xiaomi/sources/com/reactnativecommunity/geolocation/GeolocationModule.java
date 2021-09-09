package com.reactnativecommunity.geolocation;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.permissions.PermissionsModule;

@SuppressLint({"MissingPermission"})
@ReactModule(name = "RNCGeolocation")
public class GeolocationModule extends ReactContextBaseJavaModule {
    private final LocationListener mLocationListener = new LocationListener() {
        /* class com.reactnativecommunity.geolocation.GeolocationModule.AnonymousClass1 */

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onLocationChanged(Location location) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) GeolocationModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", GeolocationModule.locationToMap(location));
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                GeolocationModule geolocationModule = GeolocationModule.this;
                int i2 = PositionError.POSITION_UNAVAILABLE;
                geolocationModule.emitError(i2, "Provider " + str + " is out of service.");
            } else if (i == 1) {
                GeolocationModule geolocationModule2 = GeolocationModule.this;
                int i3 = PositionError.TIMEOUT;
                geolocationModule2.emitError(i3, "Provider " + str + " is temporarily unavailable.");
            }
        }
    };
    private String mWatchedProvider;

    public String getName() {
        return "RNCGeolocation";
    }

    public GeolocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f5492O000000o;
        public final double O00000Oo;
        public final float O00000o;
        public final boolean O00000o0;

        private O000000o(long j, double d, boolean z, float f) {
            this.f5492O000000o = j;
            this.O00000Oo = d;
            this.O00000o0 = z;
            this.O00000o = f;
        }

        public static O000000o O000000o(ReadableMap readableMap) {
            return new O000000o(readableMap.hasKey("timeout") ? (long) readableMap.getDouble("timeout") : Long.MAX_VALUE, readableMap.hasKey("maximumAge") ? readableMap.getDouble("maximumAge") : Double.POSITIVE_INFINITY, readableMap.hasKey("enableHighAccuracy") && readableMap.getBoolean("enableHighAccuracy"), readableMap.hasKey("distanceFilter") ? (float) readableMap.getDouble("distanceFilter") : 100.0f);
        }
    }

    @ReactMethod
    public void getCurrentPosition(final ReadableMap readableMap, final Callback callback, final Callback callback2) {
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionsModule permissionsModule = (PermissionsModule) getReactApplicationContext().getNativeModule(PermissionsModule.class);
            final AnonymousClass2 r4 = new Callback() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.AnonymousClass2 */

                public final void invoke(Object... objArr) {
                    if (((String) objArr[0]) == "granted") {
                        GeolocationModule.this.getCurrentLocationData(readableMap, callback, callback2);
                        return;
                    }
                    callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Location permission was not granted."));
                }
            };
            final AnonymousClass3 r5 = new Callback() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.AnonymousClass3 */

                public final void invoke(Object... objArr) {
                    callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Failed to request location permission."));
                }
            };
            final PermissionsModule permissionsModule2 = permissionsModule;
            final ReadableMap readableMap2 = readableMap;
            final Callback callback3 = callback;
            final Callback callback4 = callback2;
            permissionsModule.checkPermission("android.permission.ACCESS_FINE_LOCATION", new PromiseImpl(new Callback() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.AnonymousClass5 */

                public final void invoke(Object... objArr) {
                    if (!((Boolean) objArr[0]).booleanValue()) {
                        permissionsModule2.requestPermission("android.permission.ACCESS_FINE_LOCATION", new PromiseImpl(r4, r5));
                    } else {
                        GeolocationModule.this.getCurrentLocationData(readableMap2, callback3, callback4);
                    }
                }
            }, new Callback() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.AnonymousClass4 */

                public final void invoke(Object... objArr) {
                    callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Failed to check location permission."));
                }
            }));
            return;
        }
        getCurrentLocationData(readableMap, callback, callback2);
    }

    public void getCurrentLocationData(ReadableMap readableMap, Callback callback, Callback callback2) {
        O000000o O000000o2 = O000000o.O000000o(readableMap);
        try {
            LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService("location");
            try {
                String validProvider = getValidProvider(locationManager, O000000o2.O00000o0);
                if (validProvider == null) {
                    callback2.invoke(PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "No location provider available."));
                    return;
                }
                Callback callback3 = callback2;
                Location lastKnownLocation = locationManager.getLastKnownLocation(validProvider);
                if (lastKnownLocation == null || ((double) (SystemClock.currentTimeMillis() - lastKnownLocation.getTime())) >= O000000o2.O00000Oo) {
                    Callback callback4 = callback;
                    O00000Oo o00000Oo = new O00000Oo(locationManager, validProvider, O000000o2.f5492O000000o, callback, callback2, (byte) 0);
                    o00000Oo.O00000oo = lastKnownLocation;
                    o00000Oo.O00000o0.requestLocationUpdates(o00000Oo.O00000o, 100, 1.0f, o00000Oo.O0000Oo0);
                    o00000Oo.O0000O0o.postDelayed(o00000Oo.O0000OOo, o00000Oo.O00000oO);
                    return;
                }
                callback.invoke(locationToMap(lastKnownLocation));
            } catch (SecurityException e) {
                e = e;
                throwLocationPermissionMissing(e);
            }
        } catch (SecurityException e2) {
            e = e2;
            throwLocationPermissionMissing(e);
        }
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if (!"gps".equals(this.mWatchedProvider)) {
            O000000o O000000o2 = O000000o.O000000o(readableMap);
            try {
                LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService("location");
                String validProvider = getValidProvider(locationManager, O000000o2.O00000o0);
                if (validProvider == null) {
                    emitError(PositionError.POSITION_UNAVAILABLE, "No location provider available.");
                    return;
                }
                if (!validProvider.equals(this.mWatchedProvider)) {
                    locationManager.removeUpdates(this.mLocationListener);
                    locationManager.requestLocationUpdates(validProvider, 1000, O000000o2.O00000o, this.mLocationListener);
                }
                this.mWatchedProvider = validProvider;
            } catch (SecurityException e) {
                throwLocationPermissionMissing(e);
            }
        }
    }

    @ReactMethod
    public void stopObserving() {
        ((LocationManager) getReactApplicationContext().getSystemService("location")).removeUpdates(this.mLocationListener);
        this.mWatchedProvider = null;
    }

    private String getValidProvider(LocationManager locationManager, boolean z) {
        String str = z ? "gps" : "network";
        if (!locationManager.isProviderEnabled(str)) {
            str = str.equals("gps") ? "network" : "gps";
            if (!locationManager.isProviderEnabled(str)) {
                return null;
            }
        }
        int O000000o2 = ContextCompat.O000000o(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
        if (!str.equals("gps") || O000000o2 == 0) {
            return str;
        }
        return null;
    }

    public static WritableMap locationToMap(Location location) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("latitude", location.getLatitude());
        createMap2.putDouble("longitude", location.getLongitude());
        createMap2.putDouble("altitude", location.getAltitude());
        createMap2.putDouble("accuracy", (double) location.getAccuracy());
        createMap2.putDouble("heading", (double) location.getBearing());
        createMap2.putDouble("speed", (double) location.getSpeed());
        createMap.putMap("coords", createMap2);
        createMap.putDouble("timestamp", (double) location.getTime());
        if (Build.VERSION.SDK_INT >= 18) {
            createMap.putBoolean("mocked", location.isFromMockProvider());
        }
        return createMap;
    }

    public void emitError(int i, String str) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(i, str));
    }

    private static void throwLocationPermissionMissing(SecurityException securityException) {
        throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", securityException);
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Callback f5493O000000o;
        public final Callback O00000Oo;
        final String O00000o;
        public final LocationManager O00000o0;
        final long O00000oO;
        public Location O00000oo;
        public final Handler O0000O0o;
        public final Runnable O0000OOo;
        public boolean O0000Oo;
        public final LocationListener O0000Oo0;

        /* synthetic */ O00000Oo(LocationManager locationManager, String str, long j, Callback callback, Callback callback2, byte b) {
            this(locationManager, str, j, callback, callback2);
        }

        private O00000Oo(LocationManager locationManager, String str, long j, Callback callback, Callback callback2) {
            this.O0000O0o = new Handler();
            this.O0000OOo = new Runnable() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.O00000Oo.AnonymousClass1 */

                public final void run() {
                    synchronized (O00000Oo.this) {
                        if (!O00000Oo.this.O0000Oo) {
                            O00000Oo.this.O00000Oo.invoke(PositionError.buildError(PositionError.TIMEOUT, "Location request timed out"));
                            O00000Oo.this.O00000o0.removeUpdates(O00000Oo.this.O0000Oo0);
                            FLog.i("ReactNative", "LocationModule: Location request timed out");
                            O00000Oo.this.O0000Oo = true;
                        }
                    }
                }
            };
            this.O0000Oo0 = new LocationListener() {
                /* class com.reactnativecommunity.geolocation.GeolocationModule.O00000Oo.AnonymousClass2 */

                public final void onProviderDisabled(String str) {
                }

                public final void onProviderEnabled(String str) {
                }

                public final void onStatusChanged(String str, int i, Bundle bundle) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:51:0x0080  */
                public final void onLocationChanged(Location location) {
                    boolean z;
                    synchronized (O00000Oo.this) {
                        if (!O00000Oo.this.O0000Oo) {
                            Location location2 = O00000Oo.this.O00000oo;
                            if (location2 != null) {
                                long time = location.getTime() - location2.getTime();
                                boolean z2 = time > 120000;
                                boolean z3 = time < -120000;
                                boolean z4 = time > 0;
                                if (!z2) {
                                    if (!z3) {
                                        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
                                        boolean z5 = accuracy > 0;
                                        boolean z6 = accuracy < 0;
                                        boolean z7 = accuracy > 200;
                                        String provider = location.getProvider();
                                        String provider2 = location2.getProvider();
                                        boolean equals = provider == null ? provider2 == null : provider.equals(provider2);
                                        if (!z6) {
                                            if (!z4 || z5) {
                                                if (z4 && !z7 && equals) {
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                        O00000Oo.this.f5493O000000o.invoke(GeolocationModule.locationToMap(location));
                                        O00000Oo.this.O0000O0o.removeCallbacks(O00000Oo.this.O0000OOo);
                                        O00000Oo.this.O0000Oo = true;
                                        O00000Oo.this.O00000o0.removeUpdates(O00000Oo.this.O0000Oo0);
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        }
                        O00000Oo.this.O00000oo = location;
                    }
                }
            };
            this.O00000o0 = locationManager;
            this.O00000o = str;
            this.O00000oO = j;
            this.f5493O000000o = callback;
            this.O00000Oo = callback2;
        }
    }
}
