package _m_j;

import com.drew.lang.Rational;

public final class aat extends xx<aau> {
    public aat(aau aau) {
        super(aau);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        if (i == 512) {
            int[] O00000oo = ((aau) this.f2602O000000o).O00000oo(512);
            if (O00000oo == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < O00000oo.length; i2++) {
                sb.append((int) ((short) O00000oo[i2]));
                if (i2 < O00000oo.length - 1) {
                    sb.append(" ");
                }
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        } else if (i == 1537) {
            return O00000oo();
        } else {
            if (i != 4096) {
                return super.O000000o(i);
            }
            Integer O00000o0 = ((aau) this.f2602O000000o).O00000o0(4096);
            if (O00000o0 == null) {
                return null;
            }
            short shortValue = O00000o0.shortValue();
            if (shortValue == 0) {
                return "Unknown";
            }
            if (shortValue == 20) {
                return "Tungsten (Incandescent)";
            }
            if (shortValue == 22) {
                return "Evening Sunlight";
            }
            if (shortValue == 256) {
                return "One Touch White Balance";
            }
            if (shortValue == 512) {
                return "Custom 1-4";
            }
            switch (shortValue) {
                case 16:
                    return "Shade";
                case 17:
                    return "Cloudy";
                case 18:
                    return "Fine Weather";
                default:
                    switch (shortValue) {
                        case 33:
                            return "Daylight Fluorescent";
                        case 34:
                            return "Day White Fluorescent";
                        case 35:
                            return "Cool White Fluorescent";
                        case 36:
                            return "White Fluorescent";
                        default:
                            return "Unknown (" + O00000o0 + ")";
                    }
            }
        }
    }

    private String O00000oo() {
        int[] O00000oo = ((aau) this.f2602O000000o).O00000oo(1537);
        if (O00000oo == null) {
            return null;
        }
        Rational[] rationalArr = new Rational[(O00000oo.length / 2)];
        for (int i = 0; i < O00000oo.length / 2; i++) {
            int i2 = i * 2;
            rationalArr[i] = new Rational((long) ((short) O00000oo[i2]), (long) ((short) O00000oo[i2 + 1]));
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < rationalArr.length; i3++) {
            sb.append(rationalArr[i3].doubleValue());
            if (i3 < rationalArr.length - 1) {
                sb.append(" ");
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
}
