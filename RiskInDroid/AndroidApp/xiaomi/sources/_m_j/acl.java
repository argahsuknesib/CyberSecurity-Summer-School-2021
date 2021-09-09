package _m_j;

public final class acl extends xx<acm> {
    public acl(acm acm) {
        super(acm);
    }

    public final String O000000o(int i) {
        if (i != 5) {
            String str = "";
            if (i == 10) {
                Integer O00000o0 = ((acm) this.f2602O000000o).O00000o0(10);
                if (O00000o0 == null) {
                    return null;
                }
                Object[] objArr = new Object[2];
                objArr[0] = O00000o0;
                if (O00000o0.intValue() != 1) {
                    str = "s";
                }
                objArr[1] = str;
                return String.format("%d dot%s", objArr);
            } else if (i == 7) {
                Integer O00000o02 = ((acm) this.f2602O000000o).O00000o0(7);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue = O00000o02.intValue();
                if (intValue == 0) {
                    return "none";
                }
                if (intValue != 1) {
                    return intValue != 2 ? "unit" : "centimetre";
                }
                return "inch";
            } else if (i != 8) {
                return super.O000000o(i);
            } else {
                Integer O00000o03 = ((acm) this.f2602O000000o).O00000o0(8);
                if (O00000o03 == null) {
                    return null;
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = O00000o03;
                if (O00000o03.intValue() != 1) {
                    str = "s";
                }
                objArr2[1] = str;
                return String.format("%d dot%s", objArr2);
            }
        } else {
            Integer O00000o04 = ((acm) this.f2602O000000o).O00000o0(5);
            if (O00000o04 == null) {
                return null;
            }
            return String.format("%d.%d", Integer.valueOf((O00000o04.intValue() & 65280) >> 8), Integer.valueOf(O00000o04.intValue() & 255));
        }
    }
}
