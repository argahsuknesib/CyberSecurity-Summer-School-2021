package _m_j;

import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class aax extends xx<aay> {
    public aax(aay aay) {
        super(aay);
    }

    public final String O000000o(int i) {
        if (i == 1) {
            return O000000o(1, "Auto", "Night-scene", "Manual", null, "Multiple");
        }
        if (i == 2) {
            return O000000o(2, "Good", "Better", "Best");
        }
        if (i == 3) {
            return O000000o(3, 2, "Custom", "Auto");
        }
        if (i == 4) {
            return O000000o(4, 1, "Auto", "Flash On", null, "Flash Off", null, "Red-eye Reduction");
        }
        if (i == 7) {
            return O000000o(7, "Auto", "Daylight", "Shade", "Tungsten", "Fluorescent", "Manual");
        }
        if (i == 20) {
            Integer O00000o0 = ((aay) this.f2602O000000o).O00000o0(20);
            if (O00000o0 == null) {
                return null;
            }
            int intValue = O00000o0.intValue();
            if (intValue == 10) {
                return "ISO 100";
            }
            if (intValue == 16) {
                return "ISO 200";
            }
            if (intValue == 100) {
                return "ISO 100";
            }
            if (intValue == 200) {
                return "ISO 200";
            }
            return "Unknown (" + O00000o0 + ")";
        } else if (i == 23) {
            return O000000o(23, 1, "Normal", "Black & White", "Sepia");
        } else {
            switch (i) {
                case 10:
                    Float O0000Oo0 = ((aay) this.f2602O000000o).O0000Oo0(10);
                    if (O0000Oo0 == null) {
                        return null;
                    }
                    if (O0000Oo0.floatValue() == 0.0f) {
                        return "Off";
                    }
                    return Float.toString(O0000Oo0.floatValue());
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
    }
}
