package com.qti.location.sdk;

import java.util.HashMap;
import java.util.Map;

public interface IZatGnssConfigService {

    public enum IzatGnssSvType {
        UNKNOWN(0),
        GPS(1),
        SBAS(2),
        GLONASS(3),
        QZSS(4),
        BEIDOU(5),
        GALILEO(6);
        
        private static final Map<Integer, IzatGnssSvType> valueMap = new HashMap();
        private final int value;

        static {
            for (IzatGnssSvType izatGnssSvType : values()) {
                valueMap.put(Integer.valueOf(izatGnssSvType.value), izatGnssSvType);
            }
        }

        private IzatGnssSvType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        protected static IzatGnssSvType fromInt(int i) {
            return valueMap.get(Integer.valueOf(i));
        }
    }
}
