package _m_j;

import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zn extends xx<zo> {
    public zn(zo zoVar) {
        super(zoVar);
    }

    public final String O000000o(int i) {
        if (i != 20) {
            switch (i) {
                case 1:
                    return O000000o(1, 1, "Single shutter", "Panorama", "Night scene", "Portrait", "Landscape");
                case 2:
                    return O000000o(2, 1, "Economy", "Normal", "Fine");
                case 3:
                    return O000000o(3, 2, "Macro", "Auto focus", "Manual focus", "Infinity");
                case 4:
                    return O000000o(4, 1, "Auto", "On", "Off", "Red eye reduction");
                case 5:
                    Integer O00000o0 = ((zo) this.f2602O000000o).O00000o0(5);
                    if (O00000o0 == null) {
                        return null;
                    }
                    int intValue = O00000o0.intValue();
                    if (intValue == 11) {
                        return "Weak";
                    }
                    if (intValue == 13) {
                        return "Normal";
                    }
                    if (intValue == 15) {
                        return "Strong";
                    }
                    return "Unknown (" + O00000o0 + ")";
                case 6:
                    Integer O00000o02 = ((zo) this.f2602O000000o).O00000o0(6);
                    if (O00000o02 == null) {
                        return null;
                    }
                    return O00000Oo((double) O00000o02.intValue());
                case 7:
                    Integer O00000o03 = ((zo) this.f2602O000000o).O00000o0(7);
                    if (O00000o03 == null) {
                        return null;
                    }
                    int intValue2 = O00000o03.intValue();
                    if (intValue2 == 1) {
                        return "Auto";
                    }
                    if (intValue2 == 2) {
                        return "Tungsten";
                    }
                    if (intValue2 == 3) {
                        return "Daylight";
                    }
                    if (intValue2 == 4) {
                        return "Florescent";
                    }
                    if (intValue2 == 5) {
                        return "Shade";
                    }
                    if (intValue2 == 129) {
                        return "Manual";
                    }
                    return "Unknown (" + O00000o03 + ")";
                default:
                    switch (i) {
                        case 10:
                            Integer O00000o04 = ((zo) this.f2602O000000o).O00000o0(10);
                            if (O00000o04 == null) {
                                return null;
                            }
                            int intValue3 = O00000o04.intValue();
                            if (intValue3 == 65536) {
                                return "No digital zoom";
                            }
                            if (intValue3 == 65537 || intValue3 == 131072) {
                                return "2x digital zoom";
                            }
                            if (intValue3 == 262144) {
                                return "4x digital zoom";
                            }
                            return "Unknown (" + O00000o04 + ")";
                        case 11:
                            return O000000o(11, "Normal", "Soft", "Hard");
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            return O000000o(12, "Normal", "Low", "High");
                        case 13:
                            return O000000o(13, "Normal", "Low", "High");
                        default:
                            return super.O000000o(i);
                    }
            }
        } else {
            Integer O00000o05 = ((zo) this.f2602O000000o).O00000o0(20);
            if (O00000o05 == null) {
                return null;
            }
            int intValue4 = O00000o05.intValue();
            if (intValue4 == 64) {
                return "Normal";
            }
            if (intValue4 == 80) {
                return "Normal (ISO 80 equivalent)";
            }
            if (intValue4 == 100) {
                return "High";
            }
            if (intValue4 == 125) {
                return "+1.0";
            }
            if (intValue4 == 244) {
                return "+3.0";
            }
            if (intValue4 == 250) {
                return "+2.0";
            }
            return "Unknown (" + O00000o05 + ")";
        }
    }
}
