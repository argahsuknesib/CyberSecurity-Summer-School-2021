package _m_j;

import com.drew.imaging.png.PngColorType;
import java.io.IOException;
import java.util.List;

public final class agu extends xx<agv> {
    public agu(agv agv) {
        super(agv);
    }

    public final String O000000o(int i) {
        PngColorType fromNumericValue;
        if (i == 4) {
            Integer O00000o0 = ((agv) this.f2602O000000o).O00000o0(4);
            if (O00000o0 == null || (fromNumericValue = PngColorType.fromNumericValue(O00000o0.intValue())) == null) {
                return null;
            }
            return fromNumericValue.getDescription();
        } else if (i == 5) {
            return O000000o(5, "Deflate");
        } else {
            if (i == 6) {
                return O000000o(6, "Adaptive");
            }
            if (i == 7) {
                return O000000o(7, "No Interlace", "Adam7 Interlace");
            }
            if (i == 9) {
                return O000000o(9, null, "Yes");
            }
            if (i == 10) {
                return O000000o(10, "Perceptual", "Relative Colorimetric", "Saturation", "Absolute Colorimetric");
            }
            if (i == 13) {
                Object O0000o0o = ((agv) this.f2602O000000o).O0000o0o(13);
                if (O0000o0o == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (xi xiVar : (List) O0000o0o) {
                    if (sb.length() != 0) {
                        sb.append(10);
                    }
                    sb.append(String.format("%s: %s", xiVar.f2593O000000o, xiVar.O00000Oo));
                }
                return sb.toString();
            } else if (i == 15) {
                return O00000oo();
            } else {
                if (i != 18) {
                    return super.O000000o(i);
                }
                return O000000o(18, "Unspecified", "Metres");
            }
        }
    }

    private String O00000oo() {
        byte[] O0000O0o = ((agv) this.f2602O000000o).O0000O0o(15);
        Integer O00000o0 = ((agv) this.f2602O000000o).O00000o0(4);
        if (!(O0000O0o == null || O00000o0 == null)) {
            xl xlVar = new xl(O0000O0o);
            try {
                int intValue = O00000o0.intValue();
                if (intValue != 0) {
                    if (intValue == 6 || intValue == 2) {
                        return String.format("R %d, G %d, B %d", Integer.valueOf(xlVar.O00000oO()), Integer.valueOf(xlVar.O00000oO()), Integer.valueOf(xlVar.O00000oO()));
                    } else if (intValue == 3) {
                        return String.format("Palette Index %d", Short.valueOf(xlVar.O00000o()));
                    } else if (intValue != 4) {
                        return null;
                    }
                }
                return String.format("Greyscale Level %d", Integer.valueOf(xlVar.O00000oO()));
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
