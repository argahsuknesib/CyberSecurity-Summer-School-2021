package _m_j;

import _m_j.cst;
import _m_j.csu;
import android.location.Location;
import android.util.Log;
import com.qti.location.sdk.IZatDBCommon;
import com.qti.location.sdk.IZatGeofenceService;
import com.qti.location.sdk.IZatStaleDataException;
import com.qti.location.sdk.IZatWWANDBReceiver;
import com.qti.location.sdk.IZatWiFiDBReceiver;
import com.qti.location.sdk.utils.IZatValidationResults;

public final class csv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14319O000000o = "IZatDataValidation";
    private static final boolean O00000Oo = Log.isLoggable("IZatDataValidation", 3);

    public static IZatValidationResults O000000o(int i, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        if (!O00000Oo) {
            return new IZatValidationResults();
        }
        return csx.O000000o(i, iZatDataTypes);
    }

    private static IZatValidationResults O000000o(long j, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        if (!O00000Oo) {
            return new IZatValidationResults();
        }
        return csx.O000000o(j, iZatDataTypes);
    }

    private static IZatValidationResults O000000o(float f, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        if (!O00000Oo) {
            return new IZatValidationResults();
        }
        return csw.O000000o(f, iZatDataTypes);
    }

    private static IZatValidationResults O000000o(String str, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        if (!O00000Oo) {
            return new IZatValidationResults();
        }
        return csy.O000000o(str, iZatDataTypes);
    }

    public static IZatValidationResults O000000o(Location location) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (location == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("location object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o((float) location.getLatitude(), IZatValidationResults.IZatDataTypes.LOCATION_LATITUDE));
        iZatValidationResults.O000000o(O000000o((float) location.getLongitude(), IZatValidationResults.IZatDataTypes.LOCATION_LONGITUDE));
        if (location.hasSpeed()) {
            iZatValidationResults.O000000o(O000000o(location.getSpeed(), IZatValidationResults.IZatDataTypes.LOCATION_SPEED));
        }
        if (location.hasBearing()) {
            iZatValidationResults.O000000o(O000000o(location.getBearing(), IZatValidationResults.IZatDataTypes.LOCATION_BEARING));
        }
        if (location.hasAccuracy()) {
            iZatValidationResults.O000000o(O000000o(location.getAccuracy(), IZatValidationResults.IZatDataTypes.LOCATION_ACCURACY));
        }
        iZatValidationResults.O000000o(O000000o(location.getTime(), IZatValidationResults.IZatDataTypes.LOCATION_TIME));
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(Location[] locationArr) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        for (Location O000000o2 : locationArr) {
            iZatValidationResults.O000000o(O000000o(O000000o2));
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(IZatGeofenceService.O00000o o00000o) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (o00000o == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("geofence object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o((float) o00000o.O00000Oo, IZatValidationResults.IZatDataTypes.LOCATION_LATITUDE));
        iZatValidationResults.O000000o(O000000o((float) o00000o.O00000o0, IZatValidationResults.IZatDataTypes.LOCATION_LONGITUDE));
        iZatValidationResults.O000000o(O000000o((float) o00000o.O00000o, IZatValidationResults.IZatDataTypes.GEO_RADIUS));
        if ((o00000o.O0000OOo & 64) != 0) {
            iZatValidationResults.O000000o(O000000o(o00000o.f5440O000000o, IZatValidationResults.IZatDataTypes.GEO_RESPONSIVENESS));
        }
        if ((o00000o.O0000OOo & 32) != 0) {
            iZatValidationResults.O000000o(O000000o(o00000o.O0000O0o.f5441O000000o, IZatValidationResults.IZatDataTypes.GEO_DWELL_TIME));
        }
        if (!iZatValidationResults.f5455O000000o) {
            iZatValidationResults.O00000Oo = true;
            iZatValidationResults.O000000o();
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(IZatDBCommon.O00000Oo o00000Oo) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (o00000Oo == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("cellInfo object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o(o00000Oo.O00000Oo(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID1));
        if (o00000Oo.O00000oo() == IZatDBCommon.IZatCellTypes.CDMA) {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000o0(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID2_CDMA));
        } else {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000o0(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID2_OTHERS));
        }
        if (o00000Oo.O00000oo() == IZatDBCommon.IZatCellTypes.CDMA || o00000Oo.O00000oo() == IZatDBCommon.IZatCellTypes.GSM) {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000o(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID3_CDMA_GSM));
        } else {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000o(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID3_WCDMA_LTE));
        }
        if (o00000Oo.O00000oo() == IZatDBCommon.IZatCellTypes.CDMA || o00000Oo.O00000oo() == IZatDBCommon.IZatCellTypes.GSM) {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000oO(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID4_CDMA_GSM));
        } else {
            iZatValidationResults.O000000o(O000000o(o00000Oo.O00000oO(), IZatValidationResults.IZatDataTypes.WWAN_CELL_REGIONID4_WCDMA_LTE));
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(IZatWiFiDBReceiver.IZatAPInfo iZatAPInfo) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (iZatAPInfo == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("apInfo object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o(iZatAPInfo.f5453O000000o, IZatValidationResults.IZatDataTypes.WIFI_MAC_ADDRESS));
        iZatValidationResults.O000000o(O000000o((long) iZatAPInfo.O000000o(), IZatValidationResults.IZatDataTypes.LOCATION_TIME));
        if (iZatAPInfo.O00000Oo()) {
            iZatValidationResults.O000000o(O000000o(iZatAPInfo.O00000Oo.f5454O000000o));
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(csu.O000000o o000000o) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (o000000o == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("apObsLocData object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o(o000000o.f14317O000000o));
        iZatValidationResults.O000000o(O000000o(o000000o.O00000Oo));
        iZatValidationResults.O000000o(O000000o(o000000o.O00000o0, IZatValidationResults.IZatDataTypes.LOCATION_TIME));
        for (csu.O00000Oo next : o000000o.O00000o) {
            IZatValidationResults iZatValidationResults2 = new IZatValidationResults();
            if (O00000Oo) {
                if (next == null) {
                    iZatValidationResults2.f5455O000000o = false;
                    iZatValidationResults2.O000000o("apScan object is null");
                } else {
                    iZatValidationResults2.O000000o(O000000o(next.f14318O000000o, IZatValidationResults.IZatDataTypes.WIFI_MAC_ADDRESS));
                    iZatValidationResults2.O000000o(O000000o(next.O00000Oo, IZatValidationResults.IZatDataTypes.WIFI_RSSI));
                    iZatValidationResults2.O000000o(O000000o(next.O00000o0, IZatValidationResults.IZatDataTypes.WIFI_DELTA_TIME));
                    iZatValidationResults2.O000000o(O000000o(next.O00000oO, IZatValidationResults.IZatDataTypes.WIFI_CHANNEL_NUM));
                }
            }
            iZatValidationResults.O000000o(iZatValidationResults2);
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(cst.O000000o o000000o) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (o000000o == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("bsObsLocData object is null");
            return iZatValidationResults;
        }
        try {
            iZatValidationResults.O000000o(O000000o(o000000o.O00000Oo()));
        } catch (IZatStaleDataException unused) {
            Log.w(f14319O000000o, "LOCATION exception");
        }
        try {
            iZatValidationResults.O000000o(O000000o(o000000o.O00000o0()));
        } catch (IZatStaleDataException unused2) {
            Log.w(f14319O000000o, "CELL INFO exception");
        }
        try {
            iZatValidationResults.O000000o(O000000o(o000000o.O000000o(), IZatValidationResults.IZatDataTypes.LOCATION_TIME));
        } catch (IZatStaleDataException unused3) {
            Log.w(f14319O000000o, "TIME exception");
        }
        return iZatValidationResults;
    }

    public static IZatValidationResults O000000o(IZatWWANDBReceiver.O00000Oo o00000Oo) {
        IZatValidationResults iZatValidationResults = new IZatValidationResults();
        if (!O00000Oo) {
            return iZatValidationResults;
        }
        if (o00000Oo == null) {
            iZatValidationResults.f5455O000000o = false;
            iZatValidationResults.O000000o("bsInfo object is null");
            return iZatValidationResults;
        }
        iZatValidationResults.O000000o(O000000o(o00000Oo.f5451O000000o));
        return iZatValidationResults;
    }
}
