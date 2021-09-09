package _m_j;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class cbc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Location f13586O000000o;

    public static void O000000o(Activity activity) {
        if (f13586O000000o == null) {
            f13586O000000o = O000000o(activity, "gps");
        }
        if (f13586O000000o == null) {
            f13586O000000o = O000000o(activity, "network");
        }
    }

    private static Location O000000o(Activity activity, String str) {
        LocationManager locationManager = (LocationManager) activity.getSystemService("location");
        if (locationManager.isProviderEnabled(str) && cem.O000000o(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            return locationManager.getLastKnownLocation(str);
        }
        return null;
    }

    public static String O000000o() {
        if (f13586O000000o != null) {
            try {
                return URLEncoder.encode(cbm.O00000Oo(f13586O000000o.getLongitude() + "," + f13586O000000o.getLatitude()).trim(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String O00000Oo() {
        if (f13586O000000o == null) {
            return "";
        }
        return cbm.O00000Oo(f13586O000000o.getLongitude() + "," + f13586O000000o.getLatitude()).trim();
    }
}
