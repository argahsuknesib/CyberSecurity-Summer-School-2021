package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.push.jf;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ese {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f15767O000000o = Integer.MAX_VALUE;

    public static void O000000o(esd esd, byte b) {
        O000000o(esd, b, f15767O000000o);
    }

    private static void O000000o(esd esd, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    esd.O00000oo();
                    return;
                case 3:
                    esd.O0000O0o();
                    return;
                case 4:
                    esd.O0000OoO();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    esd.O0000OOo();
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    esd.O0000Oo0();
                    return;
                case 10:
                    esd.O0000Oo();
                    return;
                case 11:
                    esd.O0000o00();
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                    break;
                case 13:
                    esc O00000o0 = esd.O00000o0();
                    while (i2 < O00000o0.O00000o0) {
                        int i3 = i - 1;
                        O000000o(esd, O00000o0.f15766O000000o, i3);
                        O000000o(esd, O00000o0.O00000Oo, i3);
                        i2++;
                    }
                    return;
                case 14:
                    esf O00000oO = esd.O00000oO();
                    while (i2 < O00000oO.O00000Oo) {
                        O000000o(esd, O00000oO.f15768O000000o, i - 1);
                        i2++;
                    }
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    esb O00000o = esd.O00000o();
                    while (i2 < O00000o.O00000Oo) {
                        O000000o(esd, O00000o.f15765O000000o, i - 1);
                        i2++;
                    }
                    return;
            }
            while (true) {
                esa O00000Oo = esd.O00000Oo();
                if (O00000Oo.O00000Oo != 0) {
                    O000000o(esd, O00000Oo.O00000Oo, i - 1);
                } else {
                    return;
                }
            }
        } else {
            throw new jf("Maximum skip depth exceeded");
        }
    }
}
