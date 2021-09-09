package _m_j;

public final class agp extends xx<agq> {
    public agp(agq agq) {
        super(agq);
    }

    public final String O000000o(int i) {
        String str = "";
        if (i == 1) {
            Integer O00000o0 = ((agq) this.f2602O000000o).O00000o0(1);
            if (O00000o0 == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(O00000o0);
            sb.append(" channel");
            if (O00000o0.intValue() != 1) {
                str = "s";
            }
            sb.append(str);
            return sb.toString();
        } else if (i == 2) {
            Integer O00000o02 = ((agq) this.f2602O000000o).O00000o0(2);
            if (O00000o02 == null) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O00000o02);
            sb2.append(" pixel");
            if (O00000o02.intValue() != 1) {
                str = "s";
            }
            sb2.append(str);
            return sb2.toString();
        } else if (i == 3) {
            return O00000oo();
        } else {
            if (i == 4) {
                Integer O00000o03 = ((agq) this.f2602O000000o).O00000o0(4);
                if (O00000o03 == null) {
                    return null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(O00000o03);
                sb3.append(" bit");
                if (O00000o03.intValue() != 1) {
                    str = "s";
                }
                sb3.append(str);
                sb3.append(" per channel");
                return sb3.toString();
            } else if (i != 5) {
                return super.O000000o(i);
            } else {
                return O000000o(5, "Bitmap", "Grayscale", "Indexed", "RGB", "CMYK", null, null, "Multichannel", "Duotone", "Lab");
            }
        }
    }

    private String O00000oo() {
        try {
            Integer O00000o0 = ((agq) this.f2602O000000o).O00000o0(3);
            if (O00000o0 == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(O00000o0);
            sb.append(" pixel");
            sb.append(O00000o0.intValue() == 1 ? "" : "s");
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
