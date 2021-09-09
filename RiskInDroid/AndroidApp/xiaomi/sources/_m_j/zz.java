package _m_j;

public final class zz extends xx<aaa> {
    public zz(aaa aaa) {
        super(aaa);
    }

    public final String O000000o(int i) {
        if (i != 1037) {
            return super.O000000o(i);
        }
        byte[] O0000O0o = ((aaa) this.f2602O000000o).O0000O0o(1037);
        if (O0000O0o == null || O0000O0o.length < 4) {
            return null;
        }
        String format = String.format("%d %d %d %d", Byte.valueOf(O0000O0o[0]), Byte.valueOf(O0000O0o[1]), Byte.valueOf(O0000O0o[2]), Byte.valueOf(O0000O0o[3]));
        if (format.equals("0 0 0 0")) {
            return "Program AE";
        }
        if (format.equals("1 0 0 0")) {
            return "Aperture-priority AE";
        }
        if (format.equals("1 1 0 0")) {
            return "Aperture-priority AE (1)";
        }
        if (format.equals("2 0 0 0")) {
            return "Shutter speed priority AE";
        }
        if (format.equals("3 0 0 0")) {
            return "Manual";
        }
        return String.format("Unknown (%s)", format);
    }
}
