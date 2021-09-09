package _m_j;

import com.drew.metadata.jpeg.JpegComponent;
import com.google.android.exoplayer2.C;

public final class acv extends xx<acx> {
    public acv(acx acx) {
        super(acx);
    }

    public final String O000000o(int i) {
        int i2 = i;
        if (i2 == -3) {
            return O000000o(-3, "Baseline", "Extended sequential, Huffman", "Progressive, Huffman", "Lossless, Huffman", null, "Differential sequential, Huffman", "Differential progressive, Huffman", "Differential lossless, Huffman", "Reserved for JPEG extensions", "Extended sequential, arithmetic", "Progressive, arithmetic", "Lossless, arithmetic", null, "Differential sequential, arithmetic", "Differential progressive, arithmetic", "Differential lossless, arithmetic");
        }
        if (i2 == 3) {
            String O0000o0 = ((acx) this.f2602O000000o).O0000o0(3);
            if (O0000o0 == null) {
                return null;
            }
            return O0000o0 + " pixels";
        } else if (i2 == 0) {
            String O0000o02 = ((acx) this.f2602O000000o).O0000o0(0);
            if (O0000o02 == null) {
                return null;
            }
            return O0000o02 + " bits";
        } else if (i2 != 1) {
            switch (i2) {
                case 6:
                    return O00000oo(0);
                case 7:
                    return O00000oo(1);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return O00000oo(2);
                case 9:
                    return O00000oo(3);
                default:
                    return super.O000000o(i);
            }
        } else {
            String O0000o03 = ((acx) this.f2602O000000o).O0000o0(1);
            if (O0000o03 == null) {
                return null;
            }
            return O0000o03 + " pixels";
        }
    }

    private String O00000oo(int i) {
        JpegComponent O0000oOO = ((acx) this.f2602O000000o).O0000oOO(i);
        if (O0000oOO == null) {
            return null;
        }
        return O0000oOO.O000000o() + " component: " + O0000oOO;
    }
}
