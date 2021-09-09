package _m_j;

import com.drew.lang.Rational;
import com.google.android.gms.common.internal.GmsLogger;
import java.text.DecimalFormat;

public final class yx extends xx<yy> {
    public yx(yy yyVar) {
        super(yyVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bb  */
    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 1);
        }
        if (i == 2) {
            xh O00000oo = ((yy) this.f2602O000000o).O00000oo();
            if (O00000oo == null) {
                return null;
            }
            return xh.O000000o(O00000oo.f2592O000000o);
        } else if (i == 12) {
            String O0000o0 = ((yy) this.f2602O000000o).O0000o0(12);
            if (O0000o0 == null) {
                return null;
            }
            String trim = O0000o0.trim();
            if ("K".equalsIgnoreCase(trim)) {
                return "kph";
            }
            if ("M".equalsIgnoreCase(trim)) {
                return "mph";
            }
            if ("N".equalsIgnoreCase(trim)) {
                return "knots";
            }
            return "Unknown (" + trim + ")";
        } else if (i == 30) {
            return O000000o(30, "No Correction", "Differential Corrected");
        } else {
            if (i == 4) {
                xh O00000oo2 = ((yy) this.f2602O000000o).O00000oo();
                if (O00000oo2 == null) {
                    return null;
                }
                return xh.O000000o(O00000oo2.O00000Oo);
            } else if (i == 5) {
                return O000000o(5, "Sea level", "Below sea level");
            } else {
                if (i == 6) {
                    Rational O0000Ooo = ((yy) this.f2602O000000o).O0000Ooo(6);
                    if (O0000Ooo == null) {
                        return null;
                    }
                    return O0000Ooo.intValue() + " metres";
                } else if (i == 7) {
                    Rational[] O0000o00 = ((yy) this.f2602O000000o).O0000o00(7);
                    DecimalFormat decimalFormat = new DecimalFormat("00.000");
                    if (O0000o00 == null) {
                        return null;
                    }
                    return String.format("%02d:%02d:%s UTC", Integer.valueOf(O0000o00[0].intValue()), Integer.valueOf(O0000o00[1].intValue()), decimalFormat.format(O0000o00[2].doubleValue()));
                } else if (i == 9) {
                    String O0000o02 = ((yy) this.f2602O000000o).O0000o0(9);
                    if (O0000o02 == null) {
                        return null;
                    }
                    String trim2 = O0000o02.trim();
                    if ("A".equalsIgnoreCase(trim2)) {
                        return "Active (Measurement in progress)";
                    }
                    if ("V".equalsIgnoreCase(trim2)) {
                        return "Void (Measurement Interoperability)";
                    }
                    return "Unknown (" + trim2 + ")";
                } else if (i != 10) {
                    switch (i) {
                        case 14:
                        case 16:
                            String O0000o03 = ((yy) this.f2602O000000o).O0000o0(i);
                            if (O0000o03 == null) {
                                return null;
                            }
                            String trim3 = O0000o03.trim();
                            if ("T".equalsIgnoreCase(trim3)) {
                                return "True direction";
                            }
                            if ("M".equalsIgnoreCase(trim3)) {
                                return "Magnetic direction";
                            }
                            return "Unknown (" + trim3 + ")";
                        case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        case 17:
                            Rational O0000Ooo2 = ((yy) this.f2602O000000o).O0000Ooo(i);
                            String format = O0000Ooo2 != null ? new DecimalFormat("0.##").format(O0000Ooo2.doubleValue()) : ((yy) this.f2602O000000o).O0000o0(i);
                            if (format == null || format.trim().length() == 0) {
                                return null;
                            }
                            return format.trim() + " degrees";
                        default:
                            switch (i) {
                                case 23:
                                    break;
                                case 24:
                                    break;
                                case 25:
                                    String O0000o04 = ((yy) this.f2602O000000o).O0000o0(25);
                                    if (O0000o04 == null) {
                                        return null;
                                    }
                                    String trim4 = O0000o04.trim();
                                    if ("K".equalsIgnoreCase(trim4)) {
                                        return "kilometers";
                                    }
                                    if ("M".equalsIgnoreCase(trim4)) {
                                        return "miles";
                                    }
                                    if ("N".equalsIgnoreCase(trim4)) {
                                        return "knots";
                                    }
                                    return "Unknown (" + trim4 + ")";
                                default:
                                    return super.O000000o(i);
                            }
                    }
                } else {
                    String O0000o05 = ((yy) this.f2602O000000o).O0000o0(10);
                    if (O0000o05 == null) {
                        return null;
                    }
                    String trim5 = O0000o05.trim();
                    if ("2".equalsIgnoreCase(trim5)) {
                        return "2-dimensional measurement";
                    }
                    if ("3".equalsIgnoreCase(trim5)) {
                        return "3-dimensional measurement";
                    }
                    return "Unknown (" + trim5 + ")";
                }
            }
        }
    }
}
