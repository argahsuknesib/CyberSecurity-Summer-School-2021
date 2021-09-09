package _m_j;

import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class wz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final wz f2587O000000o = new wz("BYTE", 1, 1);
    public static final wz O00000Oo = new wz("STRING", 2, 1);
    public static final wz O00000o = new wz("ULONG", 4, 4);
    public static final wz O00000o0 = new wz("USHORT", 3, 2);
    public static final wz O00000oO = new wz("URATIONAL", 5, 8);
    public static final wz O00000oo = new wz("SBYTE", 6, 1);
    public static final wz O0000O0o = new wz("UNDEFINED", 7, 1);
    public static final wz O0000OOo = new wz("SSHORT", 8, 2);
    public static final wz O0000Oo = new wz("SRATIONAL", 10, 8);
    public static final wz O0000Oo0 = new wz("SLONG", 9, 4);
    public static final wz O0000OoO = new wz("SINGLE", 11, 4);
    public static final wz O0000Ooo = new wz("DOUBLE", 12, 8);
    private final String O0000o0;
    final int O0000o00;
    private final int O0000o0O;

    public static wz O000000o(int i) {
        switch (i) {
            case 1:
                return f2587O000000o;
            case 2:
                return O00000Oo;
            case 3:
                return O00000o0;
            case 4:
                return O00000o;
            case 5:
                return O00000oO;
            case 6:
                return O00000oo;
            case 7:
                return O0000O0o;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return O0000OOo;
            case 9:
                return O0000Oo0;
            case 10:
                return O0000Oo;
            case 11:
                return O0000OoO;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return O0000Ooo;
            default:
                return null;
        }
    }

    private wz(String str, int i, int i2) {
        this.O0000o0 = str;
        this.O0000o0O = i;
        this.O0000o00 = i2;
    }

    public final String toString() {
        return this.O0000o0;
    }
}
