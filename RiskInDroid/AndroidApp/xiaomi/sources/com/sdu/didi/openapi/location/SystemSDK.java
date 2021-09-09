package com.sdu.didi.openapi.location;

import _m_j.gsy;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.sdu.didi.openapi.location.LocationHelper;

public class SystemSDK extends SdkHub {
    private Context context;
    private LocationListener locationListener;
    private LocationManager manager;

    class TListener implements LocationListener {
        private LocationHelper.LocationListener locationListener;

        public TListener(LocationHelper.LocationListener locationListener2) {
            this.locationListener = locationListener2;
        }

        public void onLocationChanged(Location location) {
            LocationHelper.LocationListener locationListener2 = this.locationListener;
            if (locationListener2 != null) {
                locationListener2.location(SystemSDK.this.parseLocation(location));
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public SystemSDK(Context context2) {
        gsy.O000000o(6, "LocationSDK", "System");
        this.context = context2;
        this.manager = (LocationManager) context2.getSystemService("location");
    }

    /* access modifiers changed from: protected */
    public Location parseLocation(Object obj) {
        Location location = (Location) obj;
        Location location2 = new Location();
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        location2.setLat(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(location.getLongitude());
        location2.setLng(sb2.toString());
        location2.setMapType("wgs84");
        return location2;
    }

    public void registListener(Looper looper, LocationHelper.LocationListener locationListener2) {
        this.locationListener = new TListener(locationListener2);
        for (String next : this.manager.getProviders(true)) {
            if (!next.equals("passive") && this.manager.isProviderEnabled(next)) {
                this.manager.requestLocationUpdates(next, 1000, 10.0f, this.locationListener);
            }
        }
    }

    public void unRegistListener() {
        LocationListener locationListener2;
        LocationManager locationManager = this.manager;
        if (locationManager != null && (locationListener2 = this.locationListener) != null) {
            locationManager.removeUpdates(locationListener2);
        }
    }
}
