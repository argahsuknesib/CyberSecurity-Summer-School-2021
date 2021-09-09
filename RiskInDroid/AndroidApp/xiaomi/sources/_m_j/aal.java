package _m_j;

public final class aal extends xx<aam> {
    public aal(aam aam) {
        super(aam);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        if (i == 512) {
            int[] O00000oo = ((aam) this.f2602O000000o).O00000oo(512);
            if (O00000oo == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < O00000oo.length; i2++) {
                if (i2 != 0) {
                    sb.append(" ");
                }
                sb.append((int) ((short) O00000oo[i2]));
            }
            return sb.toString();
        } else if (i == 4124) {
            int[] O00000oo2 = ((aam) this.f2602O000000o).O00000oo(4124);
            if (O00000oo2 == null) {
                Integer O00000o0 = ((aam) this.f2602O000000o).O00000o0(4124);
                if (O00000o0 == null) {
                    return null;
                }
                O00000oo2 = new int[]{O00000o0.intValue()};
            }
            if (O00000oo2.length == 0) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            short s = (short) O00000oo2[0];
            if (s == 0) {
                sb2.append("Off");
            } else if (s == 2) {
                sb2.append("On (2 frames)");
            } else if (s != 3) {
                sb2.append("Unknown (");
                sb2.append((int) ((short) O00000oo2[0]));
                sb2.append(")");
            } else {
                sb2.append("On (3 frames)");
            }
            if (O00000oo2.length > 1) {
                sb2.append("; ");
                sb2.append((int) ((short) O00000oo2[1]));
            }
            return sb2.toString();
        } else if (i == 4370) {
            byte[] O0000O0o = ((aam) this.f2602O000000o).O0000O0o(4370);
            if (O0000O0o == null || O0000O0o.length < 2) {
                return null;
            }
            String format = String.format("%d %d", Byte.valueOf(O0000O0o[0]), Byte.valueOf(O0000O0o[1]));
            if (format.equals("1 1")) {
                return "4:3";
            }
            if (format.equals("1 4")) {
                return "1:1";
            }
            if (format.equals("2 1")) {
                return "3:2 (RAW)";
            }
            if (format.equals("2 2")) {
                return "3:2";
            }
            if (format.equals("3 1")) {
                return "16:9 (RAW)";
            }
            if (format.equals("3 3")) {
                return "16:9";
            }
            if (format.equals("4 1")) {
                return "1:1 (RAW)";
            }
            if (format.equals("4 4")) {
                return "6:6";
            }
            if (format.equals("5 5")) {
                return "5:4";
            }
            if (format.equals("6 6")) {
                return "7:6";
            }
            if (format.equals("7 7")) {
                return "6:5";
            }
            if (format.equals("8 8")) {
                return "7:5";
            }
            if (format.equals("9 1")) {
                return "3:4 (RAW)";
            }
            if (format.equals("9 9")) {
                return "3:4";
            }
            return "Unknown (" + format + ")";
        } else if (i == 6400) {
            byte[] O0000O0o2 = ((aam) this.f2602O000000o).O0000O0o(6400);
            if (O0000O0o2 == null || O0000O0o2.length < 2) {
                return null;
            }
            String format2 = String.format("%d %d", Byte.valueOf(O0000O0o2[0]), Byte.valueOf(O0000O0o2[1]));
            if (format2.equals("0 0")) {
                return "Off";
            }
            if (format2.equals("0 1")) {
                return "On";
            }
            return "Unknown (" + format2 + ")";
        } else if (i == 6401) {
            return O000000o(6401, "Vertical", "Horizontal");
        } else {
            switch (i) {
                case 4112:
                    Integer O00000o02 = ((aam) this.f2602O000000o).O00000o0(4112);
                    if (O00000o02 == null) {
                        return null;
                    }
                    if (O00000o02.intValue() == 0) {
                        return "(none)";
                    }
                    StringBuilder sb3 = new StringBuilder();
                    short shortValue = O00000o02.shortValue();
                    if ((shortValue & 1) != 0) {
                        sb3.append("Noise Reduction, ");
                    }
                    if (((shortValue >> 1) & 1) != 0) {
                        sb3.append("Noise Filter, ");
                    }
                    if (((shortValue >> 2) & 1) != 0) {
                        sb3.append("Noise Filter (ISO Boost), ");
                    }
                    return sb3.substring(0, sb3.length() - 2);
                case 4113:
                    return O000000o(4113, "Off", "On");
                case 4114:
                    return O000000o(4114, "Off", "On");
                default:
                    return super.O000000o(i);
            }
        }
    }
}
