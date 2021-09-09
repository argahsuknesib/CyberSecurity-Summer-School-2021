package _m_j;

import java.util.HashMap;

public final class aap extends xx<aaq> {
    private static final HashMap<Integer, String> O00000o0;

    public aap(aaq aaq) {
        super(aaq);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        if (i == 256) {
            return O000000o(256, 1, "Color Temperature", "Gray Point");
        }
        if (i == 289) {
            return O00000oo();
        }
        if (i == 272) {
            return O000000o(272, "Neutral", "Yellow", "Orange", "Red", "Green");
        }
        if (i == 273) {
            return O000000o(273, "Neutral", "Sepia", "Blue", "Purple", "Green");
        }
        switch (i) {
            case 265:
                return O000000o(265, "sRGB", "Adobe RGB", "Pro Photo RGB");
            case 266:
                Integer O00000o02 = ((aaq) this.f2602O000000o).O00000o0(266);
                if (O00000o02 == null) {
                    return null;
                }
                if (O00000o02.intValue() == 0) {
                    return "(none)";
                }
                StringBuilder sb = new StringBuilder();
                int intValue = O00000o02.intValue();
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
                return O000000o(267, "High Speed", "High Function", "Advanced High Speed", "Advanced High Function");
            case 268:
                Integer O00000o03 = ((aaq) this.f2602O000000o).O00000o0(268);
                if (O00000o03 == null) {
                    return null;
                }
                int intValue2 = O00000o03.intValue();
                if (intValue2 == 1) {
                    return "Vivid";
                }
                if (intValue2 == 2) {
                    return "Natural";
                }
                if (intValue2 == 3) {
                    return "Muted";
                }
                if (intValue2 == 256) {
                    return "Monotone";
                }
                if (intValue2 == 512) {
                    return "Sepia";
                }
                return "Unknown (" + O00000o03 + ")";
            default:
                return super.O000000o(i);
        }
    }

    private String O00000oo() {
        int[] O00000oo = ((aaq) this.f2602O000000o).O00000oo(289);
        if (O00000oo == null || O00000oo.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O00000oo.length; i++) {
            if (i == 0) {
                sb.append(O00000o0.containsKey(Integer.valueOf(O00000oo[i])) ? O00000o0.get(Integer.valueOf(O00000oo[i])) : "[unknown]");
            } else {
                sb.append(O00000oo[i]);
                sb.append("; ");
            }
            sb.append("; ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O00000o0 = hashMap;
        hashMap.put(0, "Off");
        O00000o0.put(1, "Soft Focus");
        O00000o0.put(2, "Pop Art");
        O00000o0.put(3, "Pale & Light Color");
        O00000o0.put(4, "Light Tone");
        O00000o0.put(5, "Pin Hole");
        O00000o0.put(6, "Grainy Film");
        O00000o0.put(9, "Diorama");
        O00000o0.put(10, "Cross Process");
        O00000o0.put(12, "Fish Eye");
        O00000o0.put(13, "Drawing");
        O00000o0.put(14, "Gentle Sepia");
        O00000o0.put(15, "Pale & Light Color II");
        O00000o0.put(16, "Pop Art II");
        O00000o0.put(17, "Pin Hole II");
        O00000o0.put(18, "Pin Hole III");
        O00000o0.put(19, "Grainy Film II");
        O00000o0.put(20, "Dramatic Tone");
        O00000o0.put(21, "Punk");
        O00000o0.put(22, "Soft Focus 2");
        O00000o0.put(23, "Sparkle");
        O00000o0.put(24, "Watercolor");
        O00000o0.put(25, "Key Line");
        O00000o0.put(26, "Key Line II");
        O00000o0.put(27, "Miniature");
        O00000o0.put(28, "Reflection");
        O00000o0.put(29, "Fragmented");
        O00000o0.put(31, "Cross Process II");
        O00000o0.put(32, "Dramatic Tone II");
        O00000o0.put(33, "Watercolor I");
        O00000o0.put(34, "Watercolor II");
        O00000o0.put(35, "Diorama II");
        O00000o0.put(36, "Vintage");
        O00000o0.put(37, "Vintage II");
        O00000o0.put(38, "Vintage III");
        O00000o0.put(39, "Partial Color");
        O00000o0.put(40, "Partial Color II");
        O00000o0.put(41, "Partial Color III");
    }
}
