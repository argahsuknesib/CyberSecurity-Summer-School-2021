package org.mp4parser.muxer.tracks.h264;

import _m_j.jjb;
import _m_j.jje;
import _m_j.jjh;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class SliceHeader {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15446O000000o;
    public SliceType O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public jje O0000o0;
    public jjb O0000o00;

    public enum SliceType {
        P,
        B,
        I,
        SP,
        SI
    }

    public SliceHeader(InputStream inputStream, Map<Integer, jje> map, Map<Integer, jjb> map2, boolean z) {
        try {
            inputStream.read();
            jjh jjh = new jjh(inputStream);
            this.f15446O000000o = jjh.O000000o("SliceHeader: first_mb_in_slice");
            switch (jjh.O000000o("SliceHeader: slice_type")) {
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
            this.O00000o0 = jjh.O000000o("SliceHeader: pic_parameter_set_id");
            this.O0000o00 = map2.get(Integer.valueOf(this.O00000o0));
            if (this.O0000o00 == null) {
                String str = "";
                for (Integer num : map.keySet()) {
                    str = str + num + ", ";
                }
                throw new RuntimeException("PPS with ids " + str + " available but not " + this.O00000o0);
            }
            this.O0000o0 = map.get(Integer.valueOf(this.O0000o00.O00000oo));
            if (this.O0000o0.O00oOooo) {
                this.O00000o = jjh.O00000Oo(2, "SliceHeader: colour_plane_id");
            }
            this.O00000oO = jjh.O00000Oo(this.O0000o0.O0000Oo + 4, "SliceHeader: frame_num");
            if (!this.O0000o0.O000O0o0) {
                this.O00000oo = jjh.O00000o0("SliceHeader: field_pic_flag");
                if (this.O00000oo) {
                    this.O0000O0o = jjh.O00000o0("SliceHeader: bottom_field_flag");
                }
            }
            if (z) {
                this.O0000OOo = jjh.O000000o("SliceHeader: idr_pic_id");
            }
            if (this.O0000o0.f1878O000000o == 0) {
                this.O0000Oo0 = jjh.O00000Oo(this.O0000o0.O0000OoO + 4, "SliceHeader: pic_order_cnt_lsb");
                if (this.O0000o00.O0000O0o && !this.O00000oo) {
                    this.O0000Oo = jjh.O00000Oo("SliceHeader: delta_pic_order_cnt_bottom");
                }
            }
            if (this.O0000o0.f1878O000000o == 1 && !this.O0000o0.O00000o0) {
                this.O0000OoO = jjh.O00000Oo("delta_pic_order_cnt_0");
                if (this.O0000o00.O0000O0o && !this.O00000oo) {
                    this.O0000Ooo = jjh.O00000Oo("delta_pic_order_cnt_1");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final String toString() {
        return "SliceHeader{first_mb_in_slice=" + this.f15446O000000o + ", slice_type=" + this.O00000Oo + ", pic_parameter_set_id=" + this.O00000o0 + ", colour_plane_id=" + this.O00000o + ", frame_num=" + this.O00000oO + ", field_pic_flag=" + this.O00000oo + ", bottom_field_flag=" + this.O0000O0o + ", idr_pic_id=" + this.O0000OOo + ", pic_order_cnt_lsb=" + this.O0000Oo0 + ", delta_pic_order_cnt_bottom=" + this.O0000Oo + '}';
    }
}
