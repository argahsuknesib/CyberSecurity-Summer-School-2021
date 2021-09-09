package com.tiqiaa.remote.entity;

public enum AirTemp {
    T16(16),
    T17(17),
    T18(18),
    T19(19),
    T20(20),
    T21(21),
    T22(22),
    T23(23),
    T24(24),
    T25(25),
    T26(26),
    T27(27),
    T28(28),
    T29(29),
    T30(30),
    T31(31);
    
    private final int value;

    private AirTemp(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirTemp getAirTemp(int i) {
        switch (i) {
            case 16:
                return T16;
            case 17:
                return T17;
            case 18:
                return T18;
            case 19:
                return T19;
            case 20:
                return T20;
            case 21:
                return T21;
            case 22:
                return T22;
            case 23:
                return T23;
            case 24:
                return T24;
            case 25:
                return T25;
            case 26:
                return T26;
            case 27:
                return T27;
            case 28:
                return T28;
            case 29:
                return T29;
            case 30:
                return T30;
            case 31:
                return T31;
            default:
                return T17;
        }
    }
}
