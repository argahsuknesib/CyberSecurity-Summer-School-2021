package com.miui.tsmclient.sesdk;

import com.miui.tsmclient.entity.TravelInfo;

public class SiteInfo {
    private TravelInfo mTravelInfo;

    public enum ConsumptionType {
        UNKNOWN("FF"),
        INBOUNT("00"),
        OUTBOUUND("01"),
        ONEWAY("02");
        
        private String mType;

        private ConsumptionType(String str) {
            this.mType = str;
        }

        public static ConsumptionType getConsumptionType(String str) {
            for (ConsumptionType consumptionType : values()) {
                if (consumptionType.mType.equals(str)) {
                    return consumptionType;
                }
            }
            return UNKNOWN;
        }

        public final String getType() {
            return this.mType;
        }
    }

    public enum TrafficType {
        UNKNOWN("00"),
        SUBWAY("01"),
        BUS("02"),
        TRAIN("03"),
        MAGLEV("04"),
        LIGHT_RAIL("05"),
        TAXI("06"),
        FERRYBOAT("07"),
        BRT("08"),
        CONVENIENCE_STORE("09");
        
        private String mType;

        private TrafficType(String str) {
            this.mType = str;
        }

        public static TrafficType getTrafficType(String str) {
            for (TrafficType trafficType : values()) {
                if (trafficType.mType.equals(str)) {
                    return trafficType;
                }
            }
            return UNKNOWN;
        }

        public final String getType() {
            return this.mType;
        }
    }

    SiteInfo(TravelInfo travelInfo) {
        this.mTravelInfo = travelInfo;
    }

    public ConsumptionType getConsumptionType() {
        return ConsumptionType.getConsumptionType(this.mTravelInfo.getConsumptionType());
    }

    public String getInboundSite() {
        return this.mTravelInfo.getStartSiteName();
    }

    public String getLineNo() {
        return this.mTravelInfo.getLineNo();
    }

    public String getOutBoundSite() {
        return this.mTravelInfo.getEndSiteName();
    }

    public TrafficType getTrafficType() {
        return TrafficType.getTrafficType(this.mTravelInfo.getTrafficType());
    }
}
