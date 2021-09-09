package _m_j;

import java.io.IOException;

public final class jkh {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1901O000000o;
    public boolean O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public int O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public boolean O0000OOo;
    public int O0000Oo;
    public jkc O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public int O0000o;
    public int O0000o0;
    public int O0000o00;
    public int O0000o0O;
    public boolean O0000o0o;
    public boolean O0000oO;
    public long O0000oO0;
    public boolean O0000oOO;
    public boolean O0000oOo;
    public boolean O0000oo;
    public boolean O0000oo0;
    public boolean O0000ooO;
    public int O0000ooo;
    public int O000O00o;
    public int O000O0OO;
    public int O000O0Oo;
    public boolean O000O0o;
    public boolean O000O0o0;
    public int O000O0oO;
    public int O000O0oo;
    public int[] O000OO;
    public int O000OO00;
    public int O000OO0o;
    public jki O000OOOo;
    public int O000OOo;
    public jkg O000OOo0;
    public boolean O00oOoOo;
    public int O00oOooO;
    public boolean O00oOooo;

    public static jkd O000000o(jkb jkb) throws IOException {
        jkd jkd = new jkd();
        jkd.f1896O000000o = jkb.O00000Oo();
        jkd.O00000Oo = (int) jkb.O000000o(4);
        jkd.O00000o0 = (int) jkb.O000000o(4);
        jkd.O00000o = new int[(jkd.f1896O000000o + 1)];
        jkd.O00000oO = new int[(jkd.f1896O000000o + 1)];
        jkd.O00000oo = new boolean[(jkd.f1896O000000o + 1)];
        for (int i = 0; i <= jkd.f1896O000000o; i++) {
            jkd.O00000o[i] = jkb.O00000Oo();
            jkd.O00000oO[i] = jkb.O00000Oo();
            jkd.O00000oo[i] = jkb.O00000o0();
        }
        jkd.O0000O0o = (int) jkb.O000000o(5);
        jkd.O0000OOo = (int) jkb.O000000o(5);
        jkd.O0000Oo0 = (int) jkb.O000000o(5);
        jkd.O0000Oo = (int) jkb.O000000o(5);
        return jkd;
    }

    public final String toString() {
        return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.f1901O000000o + ", \n        field_pic_flag=" + this.O00000Oo + ", \n        delta_pic_order_always_zero_flag=" + this.O00000o0 + ", \n        weighted_pred_flag=" + this.O00000o + ", \n        weighted_bipred_idc=" + this.O00000oO + ", \n        entropy_coding_mode_flag=" + this.O00000oo + ", \n        mb_adaptive_frame_field_flag=" + this.O0000O0o + ", \n        direct_8x8_inference_flag=" + this.O0000OOo + ", \n        chroma_format_idc=" + this.O0000Oo0 + ", \n        log2_max_frame_num_minus4=" + this.O0000Oo + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.O0000OoO + ", \n        pic_height_in_map_units_minus1=" + this.O0000Ooo + ", \n        pic_width_in_mbs_minus1=" + this.O0000o00 + ", \n        bit_depth_luma_minus8=" + this.O0000o0 + ", \n        bit_depth_chroma_minus8=" + this.O0000o0O + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.O0000o0o + ", \n        profile_idc=" + this.O0000o + ", \n        constraint_set_0_flag=" + this.O0000oO + ", \n        constraint_set_1_flag=" + this.O0000oOO + ", \n        constraint_set_2_flag=" + this.O0000oOo + ", \n        constraint_set_3_flag=" + this.O0000oo0 + ", \n        constraint_set_4_flag=" + this.O0000oo + ", \n        constraint_set_5_flag=" + this.O0000ooO + ", \n        level_idc=" + this.O0000ooo + ", \n        seq_parameter_set_id=" + this.O00oOooO + ", \n        residual_color_transform_flag=" + this.O00oOooo + ", \n        offset_for_non_ref_pic=" + this.O000O00o + ", \n        offset_for_top_to_bottom_field=" + this.O000O0OO + ", \n        num_ref_frames=" + this.O000O0Oo + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.O00oOoOo + ", \n        frame_mbs_only_flag=" + this.O000O0o0 + ", \n        frame_cropping_flag=" + this.O000O0o + ", \n        frame_crop_left_offset=" + this.O000O0oO + ", \n        frame_crop_right_offset=" + this.O000O0oo + ", \n        frame_crop_top_offset=" + this.O000OO00 + ", \n        frame_crop_bottom_offset=" + this.O000OO0o + ", \n        offsetForRefFrame=" + this.O000OO + ", \n        vuiParams=" + this.O000OOOo + ", \n        scalingMatrix=" + this.O000OOo0 + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.O000OOo + '}';
    }
}
