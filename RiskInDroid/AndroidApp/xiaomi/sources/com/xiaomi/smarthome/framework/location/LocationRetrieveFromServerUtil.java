package com.xiaomi.smarthome.framework.location;

import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class LocationRetrieveFromServerUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Location f7554O000000o = null;
    public static long O00000Oo = 0;
    private static Set<String> O00000o = new HashSet();
    private static final String O00000o0 = "LocationRetrieveFromServerUtil";
    private static Object O00000oO = null;
    private static int O00000oo = -1;

    public static void O000000o(Location location, Address address, String str) {
        if (location != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("address", address);
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("address_str", str);
            }
            location.setExtras(bundle);
        }
    }

    static class LocationParamNotChangedException extends Exception {
        private LocationParamNotChangedException() {
        }
    }
}
