package com.sdu.didi.openapi.location;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

public class LocationHelper {
    private static LocationHelper instance;
    private static HandlerThread thread;
    public Context activity;
    private Handler handler;
    public Location lastLocation = new Location();
    public volatile int locationCount = 0;
    private TLocationListener locationListener;
    public final byte[] lock = new byte[1];
    public LocationManage manage;
    public boolean shouldFire = true;

    public interface LocationListener {
        void location(Location location);
    }

    class TLocationListener implements LocationListener {
        TLocationListener() {
        }

        public void location(Location location) {
            LocationHelper.this.locationCount++;
            if (location.isAvail()) {
                LocationHelper locationHelper = LocationHelper.this;
                locationHelper.lastLocation = location;
                if (locationHelper.shouldFire) {
                    synchronized (LocationHelper.this.lock) {
                        LocationHelper.this.lock.notifyAll();
                        LocationHelper.this.shouldFire = false;
                    }
                }
            }
            if (!LocationHelper.this.lastLocation.isAvail() && LocationHelper.this.locationCount >= 3 && LocationHelper.this.shouldFire) {
                synchronized (LocationHelper.this.lock) {
                    LocationHelper.this.lock.notifyAll();
                    LocationHelper.this.shouldFire = false;
                }
            }
            if (LocationHelper.this.locationCount >= 8) {
                LocationHelper.this.onDestroy();
            }
        }
    }

    private LocationHelper(Context context) {
        this.activity = context.getApplicationContext();
        this.manage = new LocationManage();
    }

    public static synchronized LocationHelper getInstance(Context context) {
        LocationHelper locationHelper;
        synchronized (LocationHelper.class) {
            if (instance == null) {
                instance = new LocationHelper(context);
            }
            locationHelper = instance;
        }
        return locationHelper;
    }

    public Location getLocation() {
        Location location;
        this.locationCount = 0;
        synchronized (this.lock) {
            if (thread == null) {
                HandlerThread handlerThread = new HandlerThread(getClass().getName());
                thread = handlerThread;
                handlerThread.start();
                this.handler = new Handler(thread.getLooper());
                this.handler.post(new Runnable() {
                    /* class com.sdu.didi.openapi.location.LocationHelper.AnonymousClass1 */

                    public void run() {
                        LocationHelper.this.manage.init(LocationHelper.this.activity);
                        LocationHelper.this.location();
                    }
                });
            }
            while (!this.lastLocation.isAvail() && this.locationCount <= 3) {
                try {
                    this.shouldFire = true;
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            location = this.lastLocation;
        }
        return location;
    }

    public void location() {
        if (this.locationListener == null) {
            this.locationListener = new TLocationListener();
            this.manage.registListener(thread.getLooper(), new TLocationListener());
        }
    }

    public void onDestroy() {
        LocationManage locationManage = this.manage;
        if (locationManage != null) {
            locationManage.unRegistListener();
        }
        this.locationListener = null;
        this.lastLocation.reset();
        if (thread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                thread.getLooper().quitSafely();
            } else {
                thread.getLooper().quit();
            }
        }
        thread = null;
        this.locationCount = 0;
    }
}
