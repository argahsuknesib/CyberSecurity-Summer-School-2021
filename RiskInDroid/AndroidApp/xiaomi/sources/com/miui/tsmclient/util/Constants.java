package com.miui.tsmclient.util;

import android.content.Context;

public class Constants {

    public enum TrafficType {
        TRAFFIC_UNKNOWN("00", "trade_type_unknown"),
        SUBWAY("01", "trade_type_subway"),
        BUS("02", "trade_type_bus"),
        TRAIN("03", "trade_type_train"),
        MAGLEV("04", "trade_type_maglev"),
        LIGHT_RAIL("05", "trade_type_light_trail"),
        TAXI("06", "trade_type_taxi"),
        FERRYBOAT("07", "trade_type_ferry"),
        BRT("08", "trade_type_brt"),
        CONVENIENCE_STORE("09", "trade_type_convenience_store");
        
        private String mType;
        private String mTypeDescResId;

        private TrafficType(String str, String str2) {
            this.mType = str;
            this.mTypeDescResId = str2;
        }

        public static TrafficType getTrafficType(String str) {
            for (TrafficType trafficType : values()) {
                if (trafficType.mType.equals(str)) {
                    return trafficType;
                }
            }
            return TRAFFIC_UNKNOWN;
        }

        public final String getType() {
            return this.mType;
        }

        public final String getTypeDesc(Context context) {
            return ResUtils.getString(context, this.mTypeDescResId);
        }
    }

    public static class NfcEEStatus {
        private NfcEEStatus() {
        }
    }

    public static class Permission {
        private Permission() {
        }
    }

    private Constants() {
    }
}
