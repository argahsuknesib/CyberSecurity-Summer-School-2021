package com.miui.tsmclient.util;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TSMLocationService {
    private static volatile TSMLocationService INSTANCE;
    private static final Location sDefaultLocation = new Location("network");
    public Runnable mCancelUpdatesTask = new Runnable() {
        /* class com.miui.tsmclient.util.TSMLocationService.AnonymousClass2 */

        public void run() {
            TSMLocationService.this.cancelUpdates();
        }
    };
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public Location mLocation;
    public List<WeakReference<LocationChangedListener>> mLocationChangedListeners = new ArrayList();
    public LocationListener mLocationListener = new LocationListener() {
        /* class com.miui.tsmclient.util.TSMLocationService.AnonymousClass1 */

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onLocationChanged(Location location) {
            if (location == null) {
                LogUtils.d("onLocationChanged() called. location is null");
                return;
            }
            TSMLocationService.this.mLocation = location;
            LogUtils.t("onLocationChanged() called. longitude is " + TSMLocationService.this.mLocation.getLongitude() + ", latitude is " + TSMLocationService.this.mLocation.getLatitude() + ", accuracy is " + TSMLocationService.this.mLocation.getAccuracy());
            for (WeakReference<LocationChangedListener> weakReference : TSMLocationService.this.mLocationChangedListeners) {
                LocationChangedListener locationChangedListener = (LocationChangedListener) weakReference.get();
                if (locationChangedListener != null) {
                    locationChangedListener.onLocationChanged(TSMLocationService.this.mLocation, true);
                }
            }
            TSMLocationService.this.mHandler.removeCallbacks(TSMLocationService.this.mCancelUpdatesTask);
            TSMLocationService.this.cancelUpdates();
        }
    };
    public LocationManager mLocationManager;
    public boolean mOnGoing = false;

    public interface LocationChangedListener {
        void onLocationChanged(Location location, boolean z);
    }

    class RequestLocationUpdateTask implements Runnable {
        private WeakReference<LocationChangedListener> mLocationChangedListenerRef;

        public RequestLocationUpdateTask(WeakReference<LocationChangedListener> weakReference) {
            this.mLocationChangedListenerRef = weakReference;
        }

        public void run() {
            LocationChangedListener locationChangedListener = this.mLocationChangedListenerRef.get();
            if (locationChangedListener != null) {
                if (TSMLocationService.this.mLocation != null) {
                    locationChangedListener.onLocationChanged(TSMLocationService.this.mLocation, true);
                    return;
                }
                locationChangedListener.onLocationChanged(TSMLocationService.this.getLastLocation(), false);
                TSMLocationService.this.mLocationChangedListeners.add(this.mLocationChangedListenerRef);
                String bestProvider = TSMLocationService.this.getBestProvider();
                if (bestProvider != null && !TSMLocationService.this.mOnGoing) {
                    try {
                        TSMLocationService.this.mLocationManager.requestSingleUpdate(bestProvider, TSMLocationService.this.mLocationListener, (Looper) null);
                    } catch (SecurityException e) {
                        LogUtils.e("location failed with an security exception.", e);
                    }
                    TSMLocationService.this.mOnGoing = true;
                    LogUtils.d("RequestLocationUpdateTask requestSingleUpdate called");
                }
            }
        }
    }

    private TSMLocationService(Context context) {
        this.mLocationManager = (LocationManager) context.getSystemService("location");
    }

    public static TSMLocationService getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TSMLocationService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TSMLocationService(context);
                }
            }
        }
        return INSTANCE;
    }

    public void requestLocationUpdate(LocationChangedListener locationChangedListener, long j) {
        if (locationChangedListener != null) {
            this.mHandler.post(new RequestLocationUpdateTask(new WeakReference(locationChangedListener)));
            this.mHandler.removeCallbacks(this.mCancelUpdatesTask);
            Handler handler = this.mHandler;
            Runnable runnable = this.mCancelUpdatesTask;
            if (j <= 0) {
                j = 20000;
            }
            handler.postDelayed(runnable, j);
        }
    }

    public Location getLastLocation() {
        Location location = this.mLocation;
        if (location != null) {
            return location;
        }
        String bestProvider = getBestProvider();
        if (bestProvider == null) {
            return sDefaultLocation;
        }
        Location location2 = null;
        try {
            location2 = this.mLocationManager.getLastKnownLocation(bestProvider);
        } catch (SecurityException e) {
            LogUtils.e("location failed with an security exception.", e);
        }
        if (location2 != null) {
            return location2;
        }
        return sDefaultLocation;
    }

    public boolean isLocationServiceEnabled(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            LogUtils.e("get location mode fail.", e);
            return false;
        }
    }

    public void cancelUpdates() {
        if (this.mOnGoing) {
            this.mOnGoing = false;
            List<WeakReference<LocationChangedListener>> list = this.mLocationChangedListeners;
            if (list != null) {
                list.clear();
            }
            LocationManager locationManager = this.mLocationManager;
            if (locationManager != null) {
                locationManager.removeUpdates(this.mLocationListener);
                LogUtils.d("cancelUpdates called!");
            }
            this.mLocation = null;
        }
    }

    public String getBestProvider() {
        if (this.mLocationManager.isProviderEnabled("network")) {
            return "network";
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        return this.mLocationManager.getBestProvider(criteria, true);
    }
}
