package _m_j;

import _m_j.jjf;
import java.io.IOException;
import java.io.InputStream;

public final class jje extends jiy {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1878O000000o;
    public boolean O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public int O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public boolean O0000OOo;
    public int O0000Oo;
    public jiz O0000Oo0;
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
    public jjf O000OOOo;
    public int O000OOo;
    public jjd O000OOo0;
    public boolean O00oOoOo;
    public int O00oOooO;
    public boolean O00oOooo;

    public static jje O000000o(InputStream inputStream) throws IOException {
        jjh jjh = new jjh(inputStream);
        jje jje = new jje();
        jje.O0000o = (int) jjh.O000000o(8, "SPS: profile_idc");
        jje.O0000oO = jjh.O00000o0("SPS: constraint_set_0_flag");
        jje.O0000oOO = jjh.O00000o0("SPS: constraint_set_1_flag");
        jje.O0000oOo = jjh.O00000o0("SPS: constraint_set_2_flag");
        jje.O0000oo0 = jjh.O00000o0("SPS: constraint_set_3_flag");
        jje.O0000oo = jjh.O00000o0("SPS: constraint_set_4_flag");
        jje.O0000ooO = jjh.O00000o0("SPS: constraint_set_5_flag");
        jje.O0000oO0 = jjh.O000000o(2, "SPS: reserved_zero_2bits");
        jje.O0000ooo = (int) jjh.O000000o(8, "SPS: level_idc");
        jje.O00oOooO = jjh.O000000o("SPS: seq_parameter_set_id");
        int i = jje.O0000o;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            jje.O0000Oo0 = jiz.O000000o(jjh.O000000o("SPS: chroma_format_idc"));
            if (jje.O0000Oo0 == jiz.O00000o) {
                jje.O00oOooo = jjh.O00000o0("SPS: residual_color_transform_flag");
            }
            jje.O0000o0 = jjh.O000000o("SPS: bit_depth_luma_minus8");
            jje.O0000o0O = jjh.O000000o("SPS: bit_depth_chroma_minus8");
            jje.O0000o0o = jjh.O00000o0("SPS: qpprime_y_zero_transform_bypass_flag");
            if (jjh.O00000o0("SPS: seq_scaling_matrix_present_lag")) {
                jje.O000OOo0 = new jjd();
                for (int i2 = 0; i2 < 8; i2++) {
                    if (jjh.O00000o0("SPS: seqScalingListPresentFlag")) {
                        jjd jjd = jje.O000OOo0;
                        jjd.f1877O000000o = new jjc[8];
                        jjd.O00000Oo = new jjc[8];
                        if (i2 < 6) {
                            jjd.f1877O000000o[i2] = jjc.O000000o(jjh, 16);
                        } else {
                            jjd.O00000Oo[i2 - 6] = jjc.O000000o(jjh, 64);
                        }
                    }
                }
            }
        } else {
            jje.O0000Oo0 = jiz.O00000Oo;
        }
        jje.O0000Oo = jjh.O000000o("SPS: log2_max_frame_num_minus4");
        jje.f1878O000000o = jjh.O000000o("SPS: pic_order_cnt_type");
        int i3 = jje.f1878O000000o;
        if (i3 == 0) {
            jje.O0000OoO = jjh.O000000o("SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (i3 == 1) {
            jje.O00000o0 = jjh.O00000o0("SPS: delta_pic_order_always_zero_flag");
            jje.O000O00o = jjh.O00000Oo("SPS: offset_for_non_ref_pic");
            jje.O000O0OO = jjh.O00000Oo("SPS: offset_for_top_to_bottom_field");
            jje.O000OOo = jjh.O000000o("SPS: num_ref_frames_in_pic_order_cnt_cycle");
            jje.O000OO = new int[jje.O000OOo];
            for (int i4 = 0; i4 < jje.O000OOo; i4++) {
                int[] iArr = jje.O000OO;
                iArr[i4] = jjh.O00000Oo("SPS: offsetForRefFrame [" + i4 + "]");
            }
        }
        jje.O000O0Oo = jjh.O000000o("SPS: num_ref_frames");
        jje.O00oOoOo = jjh.O00000o0("SPS: gaps_in_frame_num_value_allowed_flag");
        jje.O0000o00 = jjh.O000000o("SPS: pic_width_in_mbs_minus1");
        jje.O0000Ooo = jjh.O000000o("SPS: pic_height_in_map_units_minus1");
        jje.O000O0o0 = jjh.O00000o0("SPS: frame_mbs_only_flag");
        if (!jje.O000O0o0) {
            jje.O0000O0o = jjh.O00000o0("SPS: mb_adaptive_frame_field_flag");
        }
        jje.O0000OOo = jjh.O00000o0("SPS: direct_8x8_inference_flag");
        jje.O000O0o = jjh.O00000o0("SPS: frame_cropping_flag");
        if (jje.O000O0o) {
            jje.O000O0oO = jjh.O000000o("SPS: frame_crop_left_offset");
            jje.O000O0oo = jjh.O000000o("SPS: frame_crop_right_offset");
            jje.O000OO00 = jjh.O000000o("SPS: frame_crop_top_offset");
            jje.O000OO0o = jjh.O000000o("SPS: frame_crop_bottom_offset");
        }
        if (jjh.O00000o0("SPS: vui_parameters_present_flag")) {
            jjf jjf = new jjf();
            jjf.f1879O000000o = jjh.O00000o0("VUI: aspect_ratio_info_present_flag");
            if (jjf.f1879O000000o) {
                jjf.O0000ooo = jix.O000000o((int) jjh.O000000o(8, "VUI: aspect_ratio"));
                if (jjf.O0000ooo == jix.f1870O000000o) {
                    jjf.O00000Oo = (int) jjh.O000000o(16, "VUI: sar_width");
                    jjf.O00000o0 = (int) jjh.O000000o(16, "VUI: sar_height");
                }
            }
            jjf.O00000o = jjh.O00000o0("VUI: overscan_info_present_flag");
            if (jjf.O00000o) {
                jjf.O00000oO = jjh.O00000o0("VUI: overscan_appropriate_flag");
            }
            jjf.O00000oo = jjh.O00000o0("VUI: video_signal_type_present_flag");
            if (jjf.O00000oo) {
                jjf.O0000O0o = (int) jjh.O000000o(3, "VUI: video_format");
                jjf.O0000OOo = jjh.O00000o0("VUI: video_full_range_flag");
                jjf.O0000Oo0 = jjh.O00000o0("VUI: colour_description_present_flag");
                if (jjf.O0000Oo0) {
                    jjf.O0000Oo = (int) jjh.O000000o(8, "VUI: colour_primaries");
                    jjf.O0000OoO = (int) jjh.O000000o(8, "VUI: transfer_characteristics");
                    jjf.O0000Ooo = (int) jjh.O000000o(8, "VUI: matrix_coefficients");
                }
            }
            jjf.O0000o00 = jjh.O00000o0("VUI: chroma_loc_info_present_flag");
            if (jjf.O0000o00) {
                jjf.O0000o0 = jjh.O000000o("VUI chroma_sample_loc_type_top_field");
                jjf.O0000o0O = jjh.O000000o("VUI chroma_sample_loc_type_bottom_field");
            }
            jjf.O0000o0o = jjh.O00000o0("VUI: timing_info_present_flag");
            if (jjf.O0000o0o) {
                jjf.O0000o = (int) jjh.O000000o(32, "VUI: num_units_in_tick");
                jjf.O0000oO0 = (int) jjh.O000000o(32, "VUI: time_scale");
                jjf.O0000oO = jjh.O00000o0("VUI: fixed_frame_rate_flag");
            }
            boolean O00000o02 = jjh.O00000o0("VUI: nal_hrd_parameters_present_flag");
            if (O00000o02) {
                jjf.O0000oo0 = O000000o(jjh);
            }
            boolean O00000o03 = jjh.O00000o0("VUI: vcl_hrd_parameters_present_flag");
            if (O00000o03) {
                jjf.O0000oo = O000000o(jjh);
            }
            if (O00000o02 || O00000o03) {
                jjf.O0000oOO = jjh.O00000o0("VUI: low_delay_hrd_flag");
            }
            jjf.O0000oOo = jjh.O00000o0("VUI: pic_struct_present_flag");
            if (jjh.O00000o0("VUI: bitstream_restriction_flag")) {
                jjf.O0000ooO = new jjf.O000000o();
                jjf.O0000ooO.f1880O000000o = jjh.O00000o0("VUI: motion_vectors_over_pic_boundaries_flag");
                jjf.O0000ooO.O00000Oo = jjh.O000000o("VUI max_bytes_per_pic_denom");
                jjf.O0000ooO.O00000o0 = jjh.O000000o("VUI max_bits_per_mb_denom");
                jjf.O0000ooO.O00000o = jjh.O000000o("VUI log2_max_mv_length_horizontal");
                jjf.O0000ooO.O00000oO = jjh.O000000o("VUI log2_max_mv_length_vertical");
                jjf.O0000ooO.O00000oo = jjh.O000000o("VUI num_reorder_frames");
                jjf.O0000ooO.O0000O0o = jjh.O000000o("VUI max_dec_frame_buffering");
            }
            jje.O000OOOo = jjf;
        }
        jjh.O00000o();
        return jje;
    }

    private static jja O000000o(jjh jjh) throws IOException {
        jja jja = new jja();
        jja.f1873O000000o = jjh.O000000o("SPS: cpb_cnt_minus1");
        jja.O00000Oo = (int) jjh.O000000o(4, "HRD: bit_rate_scale");
        jja.O00000o0 = (int) jjh.O000000o(4, "HRD: cpb_size_scale");
        jja.O00000o = new int[(jja.f1873O000000o + 1)];
        jja.O00000oO = new int[(jja.f1873O000000o + 1)];
        jja.O00000oo = new boolean[(jja.f1873O000000o + 1)];
        for (int i = 0; i <= jja.f1873O000000o; i++) {
            jja.O00000o[i] = jjh.O000000o("HRD: bit_rate_value_minus1");
            jja.O00000oO[i] = jjh.O000000o("HRD: cpb_size_value_minus1");
            jja.O00000oo[i] = jjh.O00000o0("HRD: cbr_flag");
        }
        jja.O0000O0o = (int) jjh.O000000o(5, "HRD: initial_cpb_removal_delay_length_minus1");
        jja.O0000OOo = (int) jjh.O000000o(5, "HRD: cpb_removal_delay_length_minus1");
        jja.O0000Oo0 = (int) jjh.O000000o(5, "HRD: dpb_output_delay_length_minus1");
        jja.O0000Oo = (int) jjh.O000000o(5, "HRD: time_offset_length");
        return jja;
    }

    public final String toString() {
        return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.f1878O000000o + ", \n        field_pic_flag=" + this.O00000Oo + ", \n        delta_pic_order_always_zero_flag=" + this.O00000o0 + ", \n        weighted_pred_flag=" + this.O00000o + ", \n        weighted_bipred_idc=" + this.O00000oO + ", \n        entropy_coding_mode_flag=" + this.O00000oo + ", \n        mb_adaptive_frame_field_flag=" + this.O0000O0o + ", \n        direct_8x8_inference_flag=" + this.O0000OOo + ", \n        chroma_format_idc=" + this.O0000Oo0 + ", \n        log2_max_frame_num_minus4=" + this.O0000Oo + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.O0000OoO + ", \n        pic_height_in_map_units_minus1=" + this.O0000Ooo + ", \n        pic_width_in_mbs_minus1=" + this.O0000o00 + ", \n        bit_depth_luma_minus8=" + this.O0000o0 + ", \n        bit_depth_chroma_minus8=" + this.O0000o0O + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.O0000o0o + ", \n        profile_idc=" + this.O0000o + ", \n        constraint_set_0_flag=" + this.O0000oO + ", \n        constraint_set_1_flag=" + this.O0000oOO + ", \n        constraint_set_2_flag=" + this.O0000oOo + ", \n        constraint_set_3_flag=" + this.O0000oo0 + ", \n        constraint_set_4_flag=" + this.O0000oo + ", \n        constraint_set_5_flag=" + this.O0000ooO + ", \n        level_idc=" + this.O0000ooo + ", \n        seq_parameter_set_id=" + this.O00oOooO + ", \n        residual_color_transform_flag=" + this.O00oOooo + ", \n        offset_for_non_ref_pic=" + this.O000O00o + ", \n        offset_for_top_to_bottom_field=" + this.O000O0OO + ", \n        num_ref_frames=" + this.O000O0Oo + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.O00oOoOo + ", \n        frame_mbs_only_flag=" + this.O000O0o0 + ", \n        frame_cropping_flag=" + this.O000O0o + ", \n        frame_crop_left_offset=" + this.O000O0oO + ", \n        frame_crop_right_offset=" + this.O000O0oo + ", \n        frame_crop_top_offset=" + this.O000OO00 + ", \n        frame_crop_bottom_offset=" + this.O000OO0o + ", \n        offsetForRefFrame=" + this.O000OO + ", \n        vuiParams=" + this.O000OOOo + ", \n        scalingMatrix=" + this.O000OOo0 + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.O000OOo + '}';
    }
}
