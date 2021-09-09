package _m_j;

import android.content.Context;
import android.location.LocationManager;

final class ioy implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1528O000000o;

    ioy(Context context) {
        this.f1528O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f1528O000000o.getSystemService("location");
        if (!locationManager.getProviders(true).contains("network") && this.f1528O000000o.getPackageManager().hasSystemFeature("android.hardware.location.network") && locationManager.isProviderEnabled("network")) {
            return false;
        }
        return true;
    }
}
