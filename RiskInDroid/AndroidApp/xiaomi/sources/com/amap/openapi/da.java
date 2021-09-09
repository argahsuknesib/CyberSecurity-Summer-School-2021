package com.amap.openapi;

import _m_j.om;
import _m_j.sl;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Looper;
import java.util.List;

public class da implements sl {

    /* renamed from: O000000o  reason: collision with root package name */
    private LocationManager f3558O000000o;

    public da(Context context) {
        this.f3558O000000o = (LocationManager) context.getSystemService("location");
    }

    public final GpsStatus O000000o(GpsStatus gpsStatus) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager == null) {
            return null;
        }
        try {
            return locationManager.getGpsStatus(gpsStatus);
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_1_@", "@_24_1_5_@");
            return null;
        }
    }

    public final List<String> O000000o() {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager == null) {
            return null;
        }
        return locationManager.getAllProviders();
    }

    public final void O000000o(LocationListener locationListener) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(locationListener);
            } catch (Exception unused) {
                om.O00000Oo("@_24_1_@", "@_24_1_6_@");
            }
        }
    }

    public final void O000000o(String str, long j, float f, LocationListener locationListener, Looper looper) {
        try {
            if (this.f3558O000000o != null) {
                this.f3558O000000o.requestLocationUpdates(str, j, f, locationListener, looper);
            }
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_1_@", "@_24_2_1_@");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
     arg types: [java.lang.String, java.lang.String, java.lang.SecurityException]
     candidates:
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void */
    public final boolean O000000o(GnssStatus.Callback callback) {
        if (this.f3558O000000o != null && Build.VERSION.SDK_INT >= 24) {
            try {
                return this.f3558O000000o.registerGnssStatusCallback(callback);
            } catch (SecurityException e) {
                om.O000000o("@_24_1_@", "@_24_1_7_@", (Exception) e);
            }
        }
        return false;
    }

    public final boolean O000000o(GpsStatus.Listener listener) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.addGpsStatusListener(listener);
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_1_@", "@_24_1_3_@");
            return false;
        }
    }

    public final boolean O000000o(GpsStatus.NmeaListener nmeaListener) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.addNmeaListener(nmeaListener);
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_1_@", "@_24_1_2_@");
            return false;
        }
    }

    public final boolean O000000o(OnNmeaMessageListener onNmeaMessageListener) {
        if (this.f3558O000000o == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.f3558O000000o.addNmeaListener(onNmeaMessageListener);
            }
            return false;
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_1_@", "@_24_1_2_@");
            return false;
        }
    }

    public final boolean O000000o(String str) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.isProviderEnabled(str);
        } catch (Exception e) {
            om.O000000o("@_24_1_@", "@_24_1_4_@", e);
            return false;
        }
    }

    public final void O00000Oo(GnssStatus.Callback callback) {
        if (this.f3558O000000o != null && Build.VERSION.SDK_INT >= 24) {
            this.f3558O000000o.unregisterGnssStatusCallback(callback);
        }
    }

    public final void O00000Oo(GpsStatus.Listener listener) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager != null) {
            locationManager.removeGpsStatusListener(listener);
        }
    }

    public final void O00000Oo(GpsStatus.NmeaListener nmeaListener) {
        LocationManager locationManager = this.f3558O000000o;
        if (locationManager != null) {
            locationManager.removeNmeaListener(nmeaListener);
        }
    }

    public final void O00000Oo(OnNmeaMessageListener onNmeaMessageListener) {
        LocationManager locationManager;
        if (Build.VERSION.SDK_INT >= 24 && (locationManager = this.f3558O000000o) != null) {
            locationManager.removeNmeaListener(onNmeaMessageListener);
        }
    }
}
