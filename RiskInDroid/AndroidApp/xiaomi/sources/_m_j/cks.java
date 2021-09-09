package _m_j;

public final class cks {
    public static String O000000o(long j) {
        if (j <= 0) {
            return "00:00";
        }
        int i = (int) j;
        int i2 = i / 3600;
        int i3 = i2 * 3600;
        int i4 = ((int) (j - ((long) i3))) / 60;
        int i5 = (i - (i4 * 60)) - i3;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            if (i2 < 10) {
                sb.append("0".concat(String.valueOf(i2)));
            } else {
                sb.append(i2);
            }
            sb.append(":");
        }
        if (i4 < 10) {
            sb.append("0".concat(String.valueOf(i4)));
        } else {
            sb.append(i4);
        }
        sb.append(":");
        if (i5 < 10) {
            sb.append("0".concat(String.valueOf(i5)));
        } else {
            sb.append(i5);
        }
        return sb.toString();
    }
}
