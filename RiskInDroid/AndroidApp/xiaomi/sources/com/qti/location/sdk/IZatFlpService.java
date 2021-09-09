package com.qti.location.sdk;

public interface IZatFlpService {

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public enum IzatFlpStatus {
        OUTDOOR_TRIP_COMPLETED(0),
        POSITION_AVAILABLE(1),
        POSITION_NOT_AVAILABLE(2);
        
        private final int value;

        private IzatFlpStatus(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
