package _m_j;

public final class aco extends xx<acp> {
    public aco(acp acp) {
        super(acp);
    }

    public final String O000000o(int i) {
        if (i != 5) {
            return super.O000000o(i);
        }
        Integer O00000o0 = ((acp) this.f2602O000000o).O00000o0(5);
        if (O00000o0 == null) {
            return null;
        }
        int intValue = O00000o0.intValue();
        if (intValue == 16) {
            return "Thumbnail coded using JPEG";
        }
        if (intValue != 17) {
            return intValue != 19 ? "Unknown extension code ".concat(String.valueOf(O00000o0)) : "Thumbnail stored using 3 bytes/pixel";
        }
        return "Thumbnail stored using 1 byte/pixel";
    }
}
