package _m_j;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.List;

/* renamed from: _m_j.int  reason: invalid class name */
final class Cint implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private LocationManager f1506O000000o;

    Cint(Context context) {
        this.f1506O000000o = (LocationManager) context.getSystemService("location");
    }

    public final boolean O000000o() throws Throwable {
        List<String> providers = this.f1506O000000o.getProviders(true);
        if (providers.contains("gps") || providers.contains("network")) {
            return true;
        }
        LocationManager locationManager = this.f1506O000000o;
        locationManager.requestLocationUpdates("gps", 0, 0.0f, new O000000o(locationManager));
        return true;
    }

    /* renamed from: _m_j.int$O000000o */
    static class O000000o implements LocationListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private LocationManager f1507O000000o;

        public O000000o(LocationManager locationManager) {
            this.f1507O000000o = locationManager;
        }

        public final void onLocationChanged(Location location) {
            this.f1507O000000o.removeUpdates(this);
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            this.f1507O000000o.removeUpdates(this);
        }

        public final void onProviderEnabled(String str) {
            this.f1507O000000o.removeUpdates(this);
        }

        public final void onProviderDisabled(String str) {
            this.f1507O000000o.removeUpdates(this);
        }
    }
}
