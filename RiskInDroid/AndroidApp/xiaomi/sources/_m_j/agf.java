package _m_j;

public final class agf extends xx<agg> {
    public agf(agg agg) {
        super(agg);
    }

    public final String O000000o(int i) {
        if (i == 1) {
            return O000000o(1, "2.5 with fixed EGA palette information", null, "2.8 with modifiable EGA palette information", "2.8 without palette information (default palette)", "PC Paintbrush for Windows", "3.0 or better");
        }
        if (i == 10) {
            return O000000o(10, 3, "24-bit color", "16 colors");
        }
        if (i != 12) {
            return super.O000000o(i);
        }
        return O000000o(12, 1, "Color or B&W", "Grayscale");
    }
}
