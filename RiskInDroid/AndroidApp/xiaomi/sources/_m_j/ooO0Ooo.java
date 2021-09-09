package _m_j;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public final class ooO0Ooo {
    private static ooO0Ooo O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f2359O000000o;
    public final O000000o O00000Oo = new O000000o();
    private final LocationManager O00000o;

    public static ooO0Ooo O000000o(Context context) {
        if (O00000o0 == null) {
            Context applicationContext = context.getApplicationContext();
            O00000o0 = new ooO0Ooo(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return O00000o0;
    }

    private ooO0Ooo(Context context, LocationManager locationManager) {
        this.f2359O000000o = context;
        this.O00000o = locationManager;
    }

    public final Location O000000o(String str) {
        try {
            if (this.O00000o.isProviderEnabled(str)) {
                return this.O00000o.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2360O000000o;
        public long O00000Oo;
        public long O00000o;
        public long O00000o0;
        public long O00000oO;
        public long O00000oo;

        O000000o() {
        }
    }
}
