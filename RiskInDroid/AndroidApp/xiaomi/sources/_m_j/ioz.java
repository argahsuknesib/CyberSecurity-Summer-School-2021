package _m_j;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

final class ioz implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1529O000000o;

    ioz(Context context) {
        this.f1529O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f1529O000000o.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        boolean contains = providers.contains("gps");
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f1529O000000o.getPackageManager().hasSystemFeature("android.hardware.location.gps") || !locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }
}
