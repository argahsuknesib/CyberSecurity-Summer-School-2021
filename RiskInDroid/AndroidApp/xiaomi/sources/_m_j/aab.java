package _m_j;

import com.drew.lang.Rational;
import com.google.android.exoplayer2.C;

public final class aab extends xx<aac> {
    public aab(aac aac) {
        super(aac);
    }

    public final String O000000o(int i) {
        switch (i) {
            case 3:
                return O000000o(3, 1, "VGA Basic", "VGA Normal", "VGA Fine", "SXGA Basic", "SXGA Normal", "SXGA Fine");
            case 4:
                return O000000o(4, 1, "Color", "Monochrome");
            case 5:
                return O000000o(5, "Normal", "Bright +", "Bright -", "Contrast +", "Contrast -");
            case 6:
                return O000000o(6, "ISO80", null, "ISO160", null, "ISO320", "ISO100");
            case 7:
                return O000000o(7, "Auto", "Preset", "Daylight", "Incandescence", "Florescence", "Cloudy", "SpeedLight");
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                Rational O0000Ooo = ((aac) this.f2602O000000o).O0000Ooo(8);
                if (O0000Ooo == null) {
                    return null;
                }
                return (O0000Ooo._numerator == 1 && O0000Ooo._denominator == 0) ? "Infinite" : O0000Ooo.O000000o(true);
            case 9:
            default:
                return super.O000000o(i);
            case 10:
                Rational O0000Ooo2 = ((aac) this.f2602O000000o).O0000Ooo(10);
                if (O0000Ooo2 == null) {
                    return null;
                }
                if (O0000Ooo2._numerator == 0) {
                    return "No digital zoom";
                }
                return O0000Ooo2.O000000o(true) + "x digital zoom";
            case 11:
                return O000000o(11, "None", "Fisheye converter");
        }
    }
}
