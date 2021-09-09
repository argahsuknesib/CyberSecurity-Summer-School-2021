package _m_j;

public final class abr extends xx<abs> {
    public abr(abs abs) {
        super(abs);
    }

    public final String O000000o(int i) {
        if (i != 1) {
            return super.O000000o(i);
        }
        Integer O00000o0 = ((abs) this.f2602O000000o).O00000o0(1);
        if (O00000o0 == null) {
            return null;
        }
        if (O00000o0.intValue() == 0) {
            return "Infinite";
        }
        if (O00000o0.intValue() == 1) {
            return "Once";
        }
        if (O00000o0.intValue() == 2) {
            return "Twice";
        }
        return O00000o0.toString() + " times";
    }
}
