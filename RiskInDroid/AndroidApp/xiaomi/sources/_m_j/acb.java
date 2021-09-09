package _m_j;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.text.DecimalFormat;

public final class acb extends xx<acc> {
    public acb(acc acc) {
        super(acc);
    }

    public final String O000000o(int i) {
        if (i == 8) {
            Integer O00000o0 = ((acc) this.f2602O000000o).O00000o0(8);
            if (O00000o0 == null) {
                return null;
            }
            return String.format("%d.%d.%d", Integer.valueOf((O00000o0.intValue() & -16777216) >> 24), Integer.valueOf((O00000o0.intValue() & 15728640) >> 20), Integer.valueOf((O00000o0.intValue() & 983040) >> 16));
        } else if (i == 12) {
            return O0000O0o();
        } else {
            if (i == 40) {
                return O00000oo();
            }
            if (i == 64) {
                return O000000o(64, "Perceptual", "Media-Relative Colorimetric", "Saturation", "ICC-Absolute Colorimetric");
            }
            if (i <= 538976288 || i >= 2054847098) {
                return super.O000000o(i);
            }
            return O00000oo(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return new java.lang.String(r0, 8, (r0.length - 8) - 1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007d */
    private String O00000oo(int i) {
        String str;
        String str2;
        try {
            byte[] O0000O0o = ((acc) this.f2602O000000o).O0000O0o(i);
            if (O0000O0o == null) {
                return ((acc) this.f2602O000000o).O0000o0(i);
            }
            xc xcVar = new xc(O0000O0o);
            int i2 = 0;
            int O0000Oo0 = xcVar.O0000Oo0(0);
            switch (O0000Oo0) {
                case 1482250784:
                    StringBuilder sb = new StringBuilder();
                    DecimalFormat decimalFormat = new DecimalFormat("0.####");
                    int length = (O0000O0o.length - 8) / 12;
                    while (i2 < length) {
                        int i3 = (i2 * 12) + 8;
                        float O0000OoO = xcVar.O0000OoO(i3);
                        float O0000OoO2 = xcVar.O0000OoO(i3 + 4);
                        float O0000OoO3 = xcVar.O0000OoO(i3 + 8);
                        if (i2 > 0) {
                            sb.append(", ");
                        }
                        sb.append("(");
                        sb.append(decimalFormat.format((double) O0000OoO));
                        sb.append(", ");
                        sb.append(decimalFormat.format((double) O0000OoO2));
                        sb.append(", ");
                        sb.append(decimalFormat.format((double) O0000OoO3));
                        sb.append(")");
                        i2++;
                    }
                    return sb.toString();
                case 1668641398:
                    int O0000Oo02 = xcVar.O0000Oo0(8);
                    StringBuilder sb2 = new StringBuilder();
                    while (i2 < O0000Oo02) {
                        if (i2 != 0) {
                            sb2.append(", ");
                        }
                        double O00000oO = (double) ((float) xcVar.O00000oO((i2 * 2) + 12));
                        Double.isNaN(O00000oO);
                        sb2.append(O00000o0(O00000oO / 65535.0d));
                        i2++;
                    }
                    return sb2.toString();
                case 1684370275:
                    return new String(O0000O0o, 12, xcVar.O0000Oo0(8) - 1);
                case 1835360627:
                    int O0000Oo03 = xcVar.O0000Oo0(8);
                    float O0000OoO4 = xcVar.O0000OoO(12);
                    float O0000OoO5 = xcVar.O0000OoO(16);
                    float O0000OoO6 = xcVar.O0000OoO(20);
                    int O0000Oo04 = xcVar.O0000Oo0(24);
                    float O0000OoO7 = xcVar.O0000OoO(28);
                    int O0000Oo05 = xcVar.O0000Oo0(32);
                    String str3 = "Unknown";
                    if (O0000Oo03 == 0) {
                        str = str3;
                    } else if (O0000Oo03 == 1) {
                        str = "1931 2°";
                    } else if (O0000Oo03 != 2) {
                        str = String.format("Unknown %d", Integer.valueOf(O0000Oo03));
                    } else {
                        str = "1964 10°";
                    }
                    if (O0000Oo04 != 0) {
                        if (O0000Oo04 == 1) {
                            str3 = "0/45 or 45/0";
                        } else if (O0000Oo04 != 2) {
                            str3 = String.format("Unknown %d", Integer.valueOf(O0000Oo03));
                        } else {
                            str3 = "0/d or d/0";
                        }
                    }
                    switch (O0000Oo05) {
                        case 0:
                            str2 = "unknown";
                            break;
                        case 1:
                            str2 = "D50";
                            break;
                        case 2:
                            str2 = "D65";
                            break;
                        case 3:
                            str2 = "D93";
                            break;
                        case 4:
                            str2 = "F2";
                            break;
                        case 5:
                            str2 = "D55";
                            break;
                        case 6:
                            str2 = "A";
                            break;
                        case 7:
                            str2 = "Equi-Power (E)";
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            str2 = "F8";
                            break;
                        default:
                            str2 = String.format("Unknown %d", Integer.valueOf(O0000Oo05));
                            break;
                    }
                    DecimalFormat decimalFormat2 = new DecimalFormat("0.###");
                    return String.format("%s Observer, Backing (%s, %s, %s), Geometry %s, Flare %d%%, Illuminant %s", str, decimalFormat2.format((double) O0000OoO4), decimalFormat2.format((double) O0000OoO5), decimalFormat2.format((double) O0000OoO6), str3, Integer.valueOf(Math.round(O0000OoO7 * 100.0f)), str2);
                case 1835824483:
                    int O0000Oo06 = xcVar.O0000Oo0(8);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(O0000Oo06);
                    while (i2 < O0000Oo06) {
                        int i4 = (i2 * 12) + 16;
                        String O000000o2 = acd.O000000o(xcVar.O0000Oo0(i4));
                        int O0000Oo07 = xcVar.O0000Oo0(i4 + 4);
                        int O0000Oo08 = xcVar.O0000Oo0(i4 + 8);
                        String str4 = new String(O0000O0o, O0000Oo08, O0000Oo07, "UTF-16BE");
                        str4 = new String(O0000O0o, O0000Oo08, O0000Oo07);
                        sb3.append(" ");
                        sb3.append(O000000o2);
                        sb3.append("(");
                        sb3.append(str4);
                        sb3.append(")");
                        i2++;
                        break;
                    }
                    return sb3.toString();
                case 1936287520:
                    return acd.O000000o(xcVar.O0000Oo0(8));
                case 1952807028:
                    return new String(O0000O0o, 8, (O0000O0o.length - 8) - 1, "ASCII");
                default:
                    return String.format("%s (0x%08X): %d bytes", acd.O000000o(O0000Oo0), Integer.valueOf(O0000Oo0), Integer.valueOf(O0000O0o.length));
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    private static String O00000o0(double d) {
        boolean z;
        long abs = Math.abs((long) d);
        double abs2 = Math.abs(d);
        double d2 = (double) abs;
        Double.isNaN(d2);
        long round = (long) ((int) Math.round((abs2 - d2) * Math.pow(10.0d, 7.0d)));
        String str = "";
        int i = 7;
        long j = round;
        String str2 = str;
        while (true) {
            z = true;
            if (i <= 0) {
                break;
            }
            byte abs3 = (byte) ((int) Math.abs(j % 10));
            j /= 10;
            if (str2.length() > 0 || abs3 != 0 || i == 1) {
                str2 = ((int) abs3) + str2;
            }
            i--;
        }
        long j2 = abs + j;
        if (d >= 0.0d || (j2 == 0 && round == 0)) {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            str = "-";
        }
        sb.append(str);
        sb.append(j2);
        sb.append(".");
        sb.append(str2);
        return sb.toString();
    }

    private String O00000oo() {
        String O0000o0 = ((acc) this.f2602O000000o).O0000o0(40);
        if (O0000o0 == null) {
            return null;
        }
        try {
            switch (O00000Oo(O0000o0)) {
                case 1095782476:
                    return "Apple Computer, Inc.";
                case 1297303124:
                    return "Microsoft Corporation";
                case 1397180704:
                    return "Silicon Graphics, Inc.";
                case 1398099543:
                    return "Sun Microsystems, Inc.";
                case 1413959252:
                    return "Taligent, Inc.";
                default:
                    return String.format("Unknown (%s)", O0000o0);
            }
        } catch (IOException unused) {
            return O0000o0;
        }
    }

    private String O0000O0o() {
        String O0000o0 = ((acc) this.f2602O000000o).O0000o0(12);
        if (O0000o0 == null) {
            return null;
        }
        try {
            switch (O00000Oo(O0000o0)) {
                case 1633842036:
                    return "Abstract";
                case 1818848875:
                    return "DeviceLink";
                case 1835955314:
                    return "Display Device";
                case 1852662636:
                    return "Named Color";
                case 1886549106:
                    return "Output Device";
                case 1935896178:
                    return "Input Device";
                case 1936744803:
                    return "ColorSpace Conversion";
                default:
                    return String.format("Unknown (%s)", O0000o0);
            }
        } catch (IOException unused) {
            return O0000o0;
        }
    }

    private static int O00000Oo(String str) throws IOException {
        return new xc(str.getBytes()).O0000Oo0(0);
    }
}
