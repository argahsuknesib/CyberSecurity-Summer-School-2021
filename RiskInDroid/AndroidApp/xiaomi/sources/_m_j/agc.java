package _m_j;

public final class agc extends xx<agd> {
    public agc(agd agd) {
        super(agd);
    }

    public final String O000000o(int i) {
        if (i == 104 || i == 105) {
            String O0000o0 = ((agd) this.f2602O000000o).O0000o0(i);
            if (O0000o0 == null) {
                return null;
            }
            return O0000o0 + " pixels";
        } else if (i == 109) {
            Integer O00000o0 = ((agd) this.f2602O000000o).O00000o0(109);
            if (O00000o0 == null) {
                return null;
            }
            int intValue = O00000o0.intValue();
            if (intValue == 34 || intValue == 36 || intValue == 40) {
                return (O00000o0.intValue() - 32) + "-bit grayscale";
            }
            return "Unknown (" + O00000o0 + ")";
        } else if (i == 111) {
            Integer O00000o02 = ((agd) this.f2602O000000o).O00000o0(111);
            if (O00000o02 == null) {
                return null;
            }
            int intValue2 = O00000o02.intValue();
            if (intValue2 == 0) {
                return "Copy";
            }
            if (intValue2 == 32) {
                return "Blend";
            }
            if (intValue2 == 36) {
                return "Transparent";
            }
            if (intValue2 == 64) {
                return "Dither copy";
            }
            switch (intValue2) {
                case 256:
                    return "Straight alpha";
                case 257:
                    return "Premul white alpha";
                case 258:
                    return "Premul black alpha";
                case 259:
                    return "Composition (dither copy)";
                case 260:
                    return "Straight alpha blend";
                default:
                    return "Unknown (" + O00000o02 + ")";
            }
        } else if (i != 113) {
            return super.O000000o(i);
        } else {
            Integer O00000o03 = ((agd) this.f2602O000000o).O00000o0(113);
            if (O00000o03 == null) {
                return null;
            }
            int intValue3 = O00000o03.intValue();
            if (intValue3 == -1) {
                Integer O00000o04 = ((agd) this.f2602O000000o).O00000o0(109);
                if (O00000o04 != null && O00000o04.intValue() < 16) {
                    return "Default";
                }
                return "None";
            } else if (intValue3 == 0) {
                return "Color table within file";
            } else {
                return "Unknown (" + O00000o03 + ")";
            }
        }
    }
}
