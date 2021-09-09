package _m_j;

import android.text.TextUtils;
import com.qti.location.sdk.IZatGeofenceService;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import java.util.regex.Pattern;

public final class hpe {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f463O000000o = (gfr.O0000O0o + "-geofence-\\w{16}-\\w+-\\w{16}");
    public static volatile Pattern O00000Oo = null;

    public static boolean O000000o(String str) {
        if (O00000Oo == null) {
            O00000Oo = Pattern.compile(f463O000000o);
        }
        if (!TextUtils.isEmpty(str) && O00000Oo.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String O000000o(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return gfr.O0000O0o + "-geofence-" + gpp.O00000Oo(str) + "-" + str2 + "-" + gpp.O00000Oo(str3);
    }

    public static IZatGeofenceService.O00000o O000000o(GeoFenceItem geoFenceItem) {
        IZatGeofenceService.O00000o0 o00000o0;
        if (geoFenceItem == null) {
            return null;
        }
        IZatGeofenceService.O00000o o00000o = new IZatGeofenceService.O00000o(geoFenceItem.f11139O000000o, geoFenceItem.O00000Oo, geoFenceItem.O00000o0);
        if (geoFenceItem.O00000oO == 1) {
            o00000o0 = new IZatGeofenceService.O00000o0(3, 1);
            o00000o.O000000o(IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_ONLY);
        } else if (geoFenceItem.O00000oO == 2) {
            o00000o0 = new IZatGeofenceService.O00000o0(3, 2);
            o00000o.O000000o(IZatGeofenceService.IzatGeofenceTransitionTypes.EXITED_ONLY);
        } else if (geoFenceItem.O00000oO == 3) {
            o00000o0 = new IZatGeofenceService.O00000o0(3, 3);
            o00000o.O000000o(IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_AND_EXITED);
        } else {
            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceHelper", "invalid GeoFenceItem type");
            return null;
        }
        o00000o.O000000o(o00000o0);
        o00000o.O000000o(IZatGeofenceService.IzatGeofenceConfidence.MEDIUM);
        o00000o.O000000o(30000);
        return o00000o;
    }
}
