package _m_j;

import com.drew.lang.Rational;

public final class aaj extends xx<aak> {
    public aaj(aak aak) {
        super(aak);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        if (i == 521) {
            return O000000o(521, "Off", "On");
        }
        if (i == 773) {
            Rational O0000Ooo = ((aak) this.f2602O000000o).O0000Ooo(773);
            if (O0000Ooo == null || O0000Ooo._numerator == 4294967295L || O0000Ooo._numerator == 0) {
                return "inf";
            }
            StringBuilder sb = new StringBuilder();
            double d = (double) O0000Ooo._numerator;
            Double.isNaN(d);
            sb.append(d / 1000.0d);
            sb.append(" m");
            return sb.toString();
        } else if (i == 776) {
            Integer O00000o0 = ((aak) this.f2602O000000o).O00000o0(776);
            if (O00000o0 == null) {
                return null;
            }
            return O00000o0.toString();
        } else if (i == 4609) {
            int[] O00000oo = ((aak) this.f2602O000000o).O00000oo(4609);
            if (O00000oo == null || O00000oo.length < 2) {
                return null;
            }
            String format = String.format("%d %d", Short.valueOf((short) O00000oo[0]), Short.valueOf((short) O00000oo[1]));
            if (format.equals("0 0")) {
                return "Off";
            }
            if (format.equals("1 0")) {
                return "On";
            }
            return "Unknown (" + format + ")";
        } else if (i == 5376) {
            return ((aak) this.f2602O000000o).O0000o0(5376);
        } else {
            if (i == 5632) {
                byte[] O0000O0o = ((aak) this.f2602O000000o).O0000O0o(5632);
                if (O0000O0o == null) {
                    return null;
                }
                if ((O0000O0o[0] | O0000O0o[1] | O0000O0o[2] | O0000O0o[3]) == 0) {
                    return "Off";
                }
                StringBuilder sb2 = new StringBuilder("On, ");
                sb2.append((O0000O0o[43] & 1) > 0 ? "Mode 1" : "Mode 2");
                return sb2.toString();
            } else if (i == 4612) {
                return O000000o(4612, "Bounce or Off", "Direct");
            } else {
                if (i == 4613) {
                    int[] O00000oo2 = ((aak) this.f2602O000000o).O00000oo(4613);
                    if (O00000oo2 == null) {
                        Integer O00000o02 = ((aak) this.f2602O000000o).O00000o0(4613);
                        if (O00000o02 == null) {
                            return null;
                        }
                        O00000oo2 = new int[]{O00000o02.intValue()};
                    }
                    if (O00000oo2.length == 0) {
                        return null;
                    }
                    String format2 = String.format("%d", Short.valueOf((short) O00000oo2[0]));
                    if (O00000oo2.length > 1) {
                        format2 = format2 + " " + String.format("%d", Short.valueOf((short) O00000oo2[1]));
                    }
                    if (format2.equals("0")) {
                        return "Off";
                    }
                    if (format2.equals("1")) {
                        return "On";
                    }
                    if (format2.equals("0 0")) {
                        return "Off";
                    }
                    if (format2.equals("1 0")) {
                        return "On";
                    }
                    return "Unknown (" + format2 + ")";
                } else if (i == 4617) {
                    int[] O00000oo3 = ((aak) this.f2602O000000o).O00000oo(4617);
                    if (O00000oo3 == null) {
                        return null;
                    }
                    if (((short) O00000oo3[0]) == 0) {
                        return "Off";
                    }
                    if (((short) O00000oo3[1]) == 1) {
                        return "Full";
                    }
                    return "On (1/" + ((int) ((short) O00000oo3[1])) + " strength)";
                } else if (i != 4618) {
                    return super.O000000o(i);
                } else {
                    return O000000o(4618, "Off", "On");
                }
            }
        }
    }
}
