package _m_j;

public final class aar extends xx<aas> {
    public aar(aas aas) {
        super(aas);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        switch (i) {
            case 264:
                return O000000o(264, "sRGB", "Adobe RGB", "Pro Photo RGB");
            case 265:
                return O000000o(265, "High Speed", "High Function", "Advanced High Speed", "Advanced High Function");
            case 266:
                Integer O00000o0 = ((aas) this.f2602O000000o).O00000o0(266);
                if (O00000o0 == null) {
                    return null;
                }
                if (O00000o0.intValue() == 0) {
                    return "(none)";
                }
                StringBuilder sb = new StringBuilder();
                int intValue = O00000o0.intValue();
                if ((intValue & 1) != 0) {
                    sb.append("Noise Reduction, ");
                }
                if (((intValue >> 1) & 1) != 0) {
                    sb.append("Noise Filter, ");
                }
                if (((intValue >> 2) & 1) != 0) {
                    sb.append("Noise Filter (ISO Boost), ");
                }
                return sb.substring(0, sb.length() - 2);
            case 267:
                Integer O00000o02 = ((aas) this.f2602O000000o).O00000o0(267);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue2 = O00000o02.intValue();
                if (intValue2 == 0) {
                    return "Original";
                }
                if (intValue2 == 1) {
                    return "Edited (Landscape)";
                }
                if (intValue2 == 6 || intValue2 == 8) {
                    return "Edited (Portrait)";
                }
                return "Unknown (" + O00000o02 + ")";
            case 268:
                Integer O00000o03 = ((aas) this.f2602O000000o).O00000o0(268);
                if (O00000o03 == null) {
                    return null;
                }
                if (O00000o03.intValue() == 0) {
                    return "(none)";
                }
                StringBuilder sb2 = new StringBuilder();
                int intValue3 = O00000o03.intValue();
                if ((intValue3 & 1) != 0) {
                    sb2.append("WB Color Temp, ");
                }
                if (((intValue3 >> 1) & 1) != 0) {
                    sb2.append("WB Gray Point, ");
                }
                if (((intValue3 >> 2) & 1) != 0) {
                    sb2.append("Saturation, ");
                }
                if (((intValue3 >> 3) & 1) != 0) {
                    sb2.append("Contrast, ");
                }
                if (((intValue3 >> 4) & 1) != 0) {
                    sb2.append("Sharpness, ");
                }
                if (((intValue3 >> 5) & 1) != 0) {
                    sb2.append("Color Space, ");
                }
                if (((intValue3 >> 6) & 1) != 0) {
                    sb2.append("High Function, ");
                }
                if (((intValue3 >> 7) & 1) != 0) {
                    sb2.append("Noise Reduction, ");
                }
                return sb2.substring(0, sb2.length() - 2);
            default:
                return super.O000000o(i);
        }
    }
}
