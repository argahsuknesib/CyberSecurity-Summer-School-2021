package org.mp4parser.streaming.input.h264.spspps;

import _m_j.jkb;
import _m_j.jke;
import _m_j.jkh;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public final class SliceHeader {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15448O000000o;
    public SliceType O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    public int O0000OOo = -1;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public jkh O0000o0;
    public jke O0000o00;

    public enum SliceType {
        P,
        B,
        I,
        SP,
        SI
    }

    public SliceHeader(ByteBuffer byteBuffer, Map<Integer, jkh> map, Map<Integer, jke> map2, boolean z) {
        try {
            byteBuffer.position(1);
            jkb jkb = new jkb(byteBuffer);
            this.f15448O000000o = jkb.O00000Oo();
            switch (jkb.O00000Oo()) {
                case 0:
                case 5:
                    this.O00000Oo = SliceType.P;
                    break;
                case 1:
                case 6:
                    this.O00000Oo = SliceType.B;
                    break;
                case 2:
                case 7:
                    this.O00000Oo = SliceType.I;
                    break;
                case 3:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    this.O00000Oo = SliceType.SP;
                    break;
                case 4:
                case 9:
                    this.O00000Oo = SliceType.SI;
                    break;
            }
            this.O00000o0 = jkb.O00000Oo();
            this.O0000o00 = map2.get(Integer.valueOf(this.O00000o0));
            String str = "";
            if (this.O0000o00 == null) {
                for (Integer num : map2.keySet()) {
                    str = str + num + ", ";
                }
                throw new RuntimeException("PPS with ids " + str + " available but not " + this.O00000o0);
            }
            this.O0000o0 = map.get(Integer.valueOf(this.O0000o00.O00000oo));
            if (this.O0000o0 == null) {
                for (Integer num2 : map.keySet()) {
                    str = str + num2 + ", ";
                }
                throw new RuntimeException("SPS with ids " + str + " available but not " + this.O0000o00.O00000oo);
            }
            if (this.O0000o0.O00oOooo) {
                this.O00000o = (int) jkb.O000000o(2);
            }
            this.O00000oO = (int) jkb.O000000o(this.O0000o0.O0000Oo + 4);
            if (!this.O0000o0.O000O0o0) {
                this.O00000oo = jkb.O00000o0();
                if (this.O00000oo) {
                    this.O0000O0o = jkb.O00000o0();
                }
            }
            if (z) {
                this.O0000OOo = jkb.O00000Oo();
            }
            if (this.O0000o0.f1901O000000o == 0) {
                this.O0000Oo0 = (int) jkb.O000000o(this.O0000o0.O0000OoO + 4);
                if (this.O0000o00.O0000O0o && !this.O00000oo) {
                    this.O0000Oo = jkb.O00000o();
                }
            }
            if (this.O0000o0.f1901O000000o == 1 && !this.O0000o0.O00000o0) {
                this.O0000OoO = jkb.O00000o();
                if (this.O0000o00.O0000O0o && !this.O00000oo) {
                    this.O0000Ooo = jkb.O00000o();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final String toString() {
        return "SliceHeader{first_mb_in_slice=" + this.f15448O000000o + ", slice_type=" + this.O00000Oo + ", pic_parameter_set_id=" + this.O00000o0 + ", colour_plane_id=" + this.O00000o + ", frame_num=" + this.O00000oO + ", field_pic_flag=" + this.O00000oo + ", bottom_field_flag=" + this.O0000O0o + ", idr_pic_id=" + this.O0000OOo + ", pic_order_cnt_lsb=" + this.O0000Oo0 + ", delta_pic_order_cnt_bottom=" + this.O0000Oo + '}';
    }
}
