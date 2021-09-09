package _m_j;

public final class ace extends xx<acf> {
    public ace(acf acf) {
        super(acf);
    }

    public final String O000000o(int i) {
        if (i == 1) {
            return O000000o(1, 1, "Icon", "Cursor");
        }
        int i2 = 256;
        if (i == 2) {
            Integer O00000o0 = ((acf) this.f2602O000000o).O00000o0(2);
            if (O00000o0 == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (O00000o0.intValue() != 0) {
                i2 = O00000o0.intValue();
            }
            sb.append(i2);
            sb.append(" pixels");
            return sb.toString();
        } else if (i == 3) {
            Integer O00000o02 = ((acf) this.f2602O000000o).O00000o0(3);
            if (O00000o02 == null) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            if (O00000o02.intValue() != 0) {
                i2 = O00000o02.intValue();
            }
            sb2.append(i2);
            sb2.append(" pixels");
            return sb2.toString();
        } else if (i != 4) {
            return super.O000000o(i);
        } else {
            Integer O00000o03 = ((acf) this.f2602O000000o).O00000o0(4);
            if (O00000o03 == null) {
                return null;
            }
            if (O00000o03.intValue() == 0) {
                return "No palette";
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(O00000o03);
            sb3.append(" colour");
            sb3.append(O00000o03.intValue() == 1 ? "" : "s");
            return sb3.toString();
        }
    }
}
