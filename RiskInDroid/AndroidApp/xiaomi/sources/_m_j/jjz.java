package _m_j;

import org.mp4parser.streaming.input.h264.spspps.SliceHeader;

class jjz implements jji {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1891O000000o;
    int O00000Oo;

    public jjz(SliceHeader sliceHeader, jjz jjz) {
        int i;
        int i2;
        if (jjz != null) {
            i2 = jjz.O00000Oo;
            i = jjz.f1891O000000o;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = 1 << (sliceHeader.O0000o0.O0000OoO + 4);
        this.O00000Oo = sliceHeader.O0000Oo0;
        this.f1891O000000o = 0;
        int i4 = this.O00000Oo;
        if (i4 >= i2 || i2 - i4 < i3 / 2) {
            int i5 = this.O00000Oo;
            if (i5 <= i2 || i5 - i2 <= i3 / 2) {
                this.f1891O000000o = i;
            } else {
                this.f1891O000000o = i - i3;
            }
        } else {
            this.f1891O000000o = i + i3;
        }
    }

    public final int O000000o() {
        return this.f1891O000000o + this.O00000Oo;
    }

    public String toString() {
        return "picOrderCntMsb=" + this.f1891O000000o + ", picOrderCountLsb=" + this.O00000Oo;
    }
}
