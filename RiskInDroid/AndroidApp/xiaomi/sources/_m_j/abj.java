package _m_j;

public final class abj extends xx<abk> {
    public abj(abk abk) {
        super(abk);
    }

    public final String O000000o(int i) {
        if (i == 8) {
            String O0000o0 = ((abk) this.f2602O000000o).O0000o0(8);
            if (O0000o0 == null || O0000o0.length() == 0) {
                return null;
            }
            char charAt = O0000o0.charAt(0);
            if (charAt == 'A') {
                return "Aperture Priority AE";
            }
            if (charAt == 'M') {
                return "Manual";
            }
            if (charAt != 'P') {
                return charAt != 'S' ? O0000o0 : "Shutter Speed Priority AE";
            }
            return "Program AE";
        } else if (i != 9) {
            return super.O000000o(i);
        } else {
            String O0000o02 = ((abk) this.f2602O000000o).O0000o0(9);
            if (O0000o02 == null || O0000o02.length() == 0) {
                return null;
            }
            char charAt2 = O0000o02.charAt(0);
            if (charAt2 == '8') {
                return "Multi Segment";
            }
            if (charAt2 != 'A') {
                return charAt2 != 'C' ? O0000o02 : "Center Weighted Average";
            }
            return "Average";
        }
    }
}
