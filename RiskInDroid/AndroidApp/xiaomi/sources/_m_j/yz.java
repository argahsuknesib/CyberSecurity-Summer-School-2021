package _m_j;

import com.drew.lang.Rational;

public final class yz extends xx<za> {
    public yz(za zaVar) {
        super(zaVar);
    }

    public final String O000000o(int i) {
        if (i == 2) {
            Integer O00000o0 = ((za) this.f2602O000000o).O00000o0(2);
            if (O00000o0 == null) {
                return null;
            }
            return new Rational((long) O00000o0.intValue(), 32678).toString();
        } else if (i == 11) {
            Integer O00000o02 = ((za) this.f2602O000000o).O00000o0(11);
            if (O00000o02 == null) {
                return null;
            }
            return new Rational((long) O00000o02.intValue(), 32678).toString();
        } else if (i == 4) {
            Integer O00000o03 = ((za) this.f2602O000000o).O00000o0(4);
            if (O00000o03 == null) {
                return null;
            }
            return new Rational((long) O00000o03.intValue(), 32678).toString();
        } else if (i == 5) {
            Integer O00000o04 = ((za) this.f2602O000000o).O00000o0(5);
            if (O00000o04 == null) {
                return null;
            }
            return Integer.toString(1 / ((O00000o04.intValue() / 32768) + 1));
        } else if (i == 7) {
            Integer O00000o05 = ((za) this.f2602O000000o).O00000o0(7);
            if (O00000o05 == null) {
                return null;
            }
            int intValue = O00000o05.intValue() & 15;
            if (intValue == 0) {
                return "Off";
            }
            if (intValue == 1) {
                return "On";
            }
            return "Unknown (" + O00000o05 + ")";
        } else if (i == 8) {
            Integer O00000o06 = ((za) this.f2602O000000o).O00000o0(8);
            if (O00000o06 == null) {
                return null;
            }
            return new Rational((long) O00000o06.intValue(), 32678).toString();
        } else if (i != 9) {
            return super.O000000o(i);
        } else {
            Integer O00000o07 = ((za) this.f2602O000000o).O00000o0(9);
            if (O00000o07 == null) {
                return null;
            }
            return new Rational((long) O00000o07.intValue(), 32678).toString();
        }
    }
}
