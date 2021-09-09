package com.qti.location.sdk.utils;

import android.util.Log;
import com.qti.location.sdk.IZatIllegalArgumentException;

public final class IZatValidationResults {
    private static final boolean O00000o = Log.isLoggable("IZatDataValidation", 3);
    private static String O00000o0 = "IZatDataValidation";
    private static final boolean O00000oO = Log.isLoggable(O00000o0, 2);

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f5455O000000o;
    public boolean O00000Oo;
    private StringBuilder O00000oo;

    public enum IZatDataTypes {
        LOCATION_TIME,
        LOCATION_LATITUDE,
        LOCATION_LONGITUDE,
        LOCATION_ALTITUDE,
        LOCATION_SPEED,
        LOCATION_BEARING,
        LOCATION_ACCURACY,
        FLP_STATUS,
        FLP_TIME_INTERVAL,
        FLP_DISTANCE_INTERVAL,
        FLP_TRIP_DISTANCE,
        FLP_POWER_MODE,
        FLP_TBM_MILLIS,
        GEO_RESPONSIVENESS,
        GEO_RADIUS,
        GEO_FIELDS_MASK,
        GEO_EVENT,
        GEO_REQUEST_TYPE,
        GEO_ERROR_CODE,
        GEO_ENGINE_STATUS,
        GEO_DWELL_TIME,
        WIFI_EXPIRE_DAYS,
        WIFI_DAYS_VALID,
        WIFI_MAC_ADDRESS,
        WIFI_MAX_ANTENARANGE,
        WIFI_RSSI,
        WIFI_DELTA_TIME,
        WIFI_CHANNEL_NUM,
        WWAN_CELL_REGIONID1,
        WWAN_CELL_REGIONID2_CDMA,
        WWAN_CELL_REGIONID2_OTHERS,
        WWAN_CELL_REGIONID3_CDMA_GSM,
        WWAN_CELL_REGIONID3_WCDMA_LTE,
        WWAN_CELL_REGIONID4_CDMA_GSM,
        WWAN_CELL_REGIONID4_WCDMA_LTE,
        WWAN_HORIZONTAL_COV_RADIUS
    }

    public IZatValidationResults() {
        this(true, "");
    }

    public IZatValidationResults(boolean z, String str) {
        this.O00000Oo = O00000oO;
        this.f5455O000000o = z;
        this.O00000oo = new StringBuilder(str);
    }

    public final void O000000o(String str) {
        this.O00000oo.setLength(0);
        this.O00000oo.append(str);
    }

    public final void O000000o() {
        if (!this.f5455O000000o) {
            if (this.O00000Oo) {
                throw new IZatIllegalArgumentException(this.O00000oo.toString());
            } else if (O00000o) {
                String str = O00000o0;
                String sb = this.O00000oo.toString();
                Log.d(str, "Fail Info: " + sb);
            }
        }
    }

    public final void O000000o(IZatValidationResults iZatValidationResults) {
        if (!iZatValidationResults.f5455O000000o) {
            this.f5455O000000o = false;
            this.O00000oo.append(10);
            this.O00000oo.append(iZatValidationResults.O00000oo.toString());
        }
    }
}
