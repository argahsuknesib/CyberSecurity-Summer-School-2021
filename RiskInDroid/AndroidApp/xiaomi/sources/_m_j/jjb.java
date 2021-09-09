package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class jjb extends jiy {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f1874O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public boolean O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public boolean O0000o;
    public int O0000o0;
    public int O0000o00;
    public boolean O0000o0O;
    public boolean O0000o0o;
    public int[] O0000oO;
    public int[] O0000oO0;
    public int[] O0000oOO;
    public boolean O0000oOo;
    public O000000o O0000oo;
    public int[] O0000oo0;

    public static jjb O000000o(InputStream inputStream) throws IOException {
        jjh jjh = new jjh(inputStream);
        jjb jjb = new jjb();
        jjb.O00000oO = jjh.O000000o("PPS: pic_parameter_set_id");
        jjb.O00000oo = jjh.O000000o("PPS: seq_parameter_set_id");
        jjb.f1874O000000o = jjh.O00000o0("PPS: entropy_coding_mode_flag");
        jjb.O0000O0o = jjh.O00000o0("PPS: pic_order_present_flag");
        jjb.O0000OOo = jjh.O000000o("PPS: num_slice_groups_minus1");
        boolean z = true;
        if (jjb.O0000OOo > 0) {
            jjb.O0000Oo0 = jjh.O000000o("PPS: slice_group_map_type");
            int i = jjb.O0000OOo;
            jjb.O0000oO0 = new int[(i + 1)];
            jjb.O0000oO = new int[(i + 1)];
            jjb.O0000oOO = new int[(i + 1)];
            int i2 = jjb.O0000Oo0;
            if (i2 == 0) {
                for (int i3 = 0; i3 <= jjb.O0000OOo; i3++) {
                    jjb.O0000oOO[i3] = jjh.O000000o("PPS: run_length_minus1");
                }
            } else if (i2 == 2) {
                for (int i4 = 0; i4 < jjb.O0000OOo; i4++) {
                    jjb.O0000oO0[i4] = jjh.O000000o("PPS: top_left");
                    jjb.O0000oO[i4] = jjh.O000000o("PPS: bottom_right");
                }
            } else {
                int i5 = 3;
                if (i2 == 3 || i2 == 4 || i2 == 5) {
                    jjb.O0000oOo = jjh.O00000o0("PPS: slice_group_change_direction_flag");
                    jjb.O00000o = jjh.O000000o("PPS: slice_group_change_rate_minus1");
                } else if (i2 == 6) {
                    if (i + 1 <= 4) {
                        i5 = i + 1 > 2 ? 2 : 1;
                    }
                    int O000000o2 = jjh.O000000o("PPS: pic_size_in_map_units_minus1");
                    jjb.O0000oo0 = new int[(O000000o2 + 1)];
                    for (int i6 = 0; i6 <= O000000o2; i6++) {
                        int[] iArr = jjb.O0000oo0;
                        iArr[i6] = jjh.O00000Oo(i5, "PPS: slice_group_id [" + i6 + "]f");
                    }
                }
            }
        }
        jjb.O00000Oo = jjh.O000000o("PPS: num_ref_idx_l0_active_minus1");
        jjb.O00000o0 = jjh.O000000o("PPS: num_ref_idx_l1_active_minus1");
        jjb.O0000Oo = jjh.O00000o0("PPS: weighted_pred_flag");
        jjb.O0000OoO = (int) jjh.O000000o(2, "PPS: weighted_bipred_idc");
        jjb.O0000Ooo = jjh.O00000Oo("PPS: pic_init_qp_minus26");
        jjb.O0000o00 = jjh.O00000Oo("PPS: pic_init_qs_minus26");
        jjb.O0000o0 = jjh.O00000Oo("PPS: chroma_qp_index_offset");
        jjb.O0000o0O = jjh.O00000o0("PPS: deblocking_filter_control_present_flag");
        jjb.O0000o0o = jjh.O00000o0("PPS: constrained_intra_pred_flag");
        jjb.O0000o = jjh.O00000o0("PPS: redundant_pic_cnt_present_flag");
        if (jjh.O00000o0 == 8) {
            jjh.O00000Oo();
        }
        int i7 = 1 << ((8 - jjh.O00000o0) - 1);
        boolean z2 = (((i7 << 1) - 1) & jjh.O00000o) == i7;
        if (jjh.O00000o == -1 || (jjh.O00000oO == -1 && z2)) {
            z = false;
        }
        if (z) {
            jjb.O0000oo = new O000000o();
            jjb.O0000oo.f1875O000000o = jjh.O00000o0("PPS: transform_8x8_mode_flag");
            if (jjh.O00000o0("PPS: pic_scaling_matrix_present_flag")) {
                for (int i8 = 0; i8 < ((jjb.O0000oo.f1875O000000o ? 1 : 0) * true) + 6; i8++) {
                    if (jjh.O00000o0("PPS: pic_scaling_list_present_flag")) {
                        jjb.O0000oo.O00000Oo.f1877O000000o = new jjc[8];
                        jjb.O0000oo.O00000Oo.O00000Oo = new jjc[8];
                        if (i8 < 6) {
                            jjb.O0000oo.O00000Oo.f1877O000000o[i8] = jjc.O000000o(jjh, 16);
                        } else {
                            jjb.O0000oo.O00000Oo.O00000Oo[i8 - 6] = jjc.O000000o(jjh, 64);
                        }
                    }
                }
            }
            jjb.O0000oo.O00000o0 = jjh.O00000Oo("PPS: second_chroma_qp_index_offset");
        }
        jjh.O00000o();
        return jjb;
    }

    public final int hashCode() {
        int i;
        int i2 = 1231;
        int hashCode = (((((((((Arrays.hashCode(this.O0000oO) + 31) * 31) + this.O0000o0) * 31) + (this.O0000o0o ? 1231 : 1237)) * 31) + (this.O0000o0O ? 1231 : 1237)) * 31) + (this.f1874O000000o ? 1231 : 1237)) * 31;
        O000000o o000000o = this.O0000oo;
        if (o000000o == null) {
            i = 0;
        } else {
            i = o000000o.hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((hashCode + i) * 31) + this.O00000Oo) * 31) + this.O00000o0) * 31) + this.O0000OOo) * 31) + this.O0000Ooo) * 31) + this.O0000o00) * 31) + (this.O0000O0o ? 1231 : 1237)) * 31) + this.O00000oO) * 31) + (this.O0000o ? 1231 : 1237)) * 31) + Arrays.hashCode(this.O0000oOO)) * 31) + this.O00000oo) * 31) + (this.O0000oOo ? 1231 : 1237)) * 31) + this.O00000o) * 31) + Arrays.hashCode(this.O0000oo0)) * 31) + this.O0000Oo0) * 31) + Arrays.hashCode(this.O0000oO0)) * 31) + this.O0000OoO) * 31;
        if (!this.O0000Oo) {
            i2 = 1237;
        }
        return hashCode2 + i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        jjb jjb = (jjb) obj;
        if (!Arrays.equals(this.O0000oO, jjb.O0000oO) || this.O0000o0 != jjb.O0000o0 || this.O0000o0o != jjb.O0000o0o || this.O0000o0O != jjb.O0000o0O || this.f1874O000000o != jjb.f1874O000000o) {
            return false;
        }
        O000000o o000000o = this.O0000oo;
        if (o000000o == null) {
            if (jjb.O0000oo != null) {
                return false;
            }
        } else if (!o000000o.equals(jjb.O0000oo)) {
            return false;
        }
        return this.O00000Oo == jjb.O00000Oo && this.O00000o0 == jjb.O00000o0 && this.O0000OOo == jjb.O0000OOo && this.O0000Ooo == jjb.O0000Ooo && this.O0000o00 == jjb.O0000o00 && this.O0000O0o == jjb.O0000O0o && this.O00000oO == jjb.O00000oO && this.O0000o == jjb.O0000o && Arrays.equals(this.O0000oOO, jjb.O0000oOO) && this.O00000oo == jjb.O00000oo && this.O0000oOo == jjb.O0000oOo && this.O00000o == jjb.O00000o && Arrays.equals(this.O0000oo0, jjb.O0000oo0) && this.O0000Oo0 == jjb.O0000Oo0 && Arrays.equals(this.O0000oO0, jjb.O0000oO0) && this.O0000OoO == jjb.O0000OoO && this.O0000Oo == jjb.O0000Oo;
    }

    public final String toString() {
        return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.f1874O000000o + ",\n       num_ref_idx_l0_active_minus1=" + this.O00000Oo + ",\n       num_ref_idx_l1_active_minus1=" + this.O00000o0 + ",\n       slice_group_change_rate_minus1=" + this.O00000o + ",\n       pic_parameter_set_id=" + this.O00000oO + ",\n       seq_parameter_set_id=" + this.O00000oo + ",\n       pic_order_present_flag=" + this.O0000O0o + ",\n       num_slice_groups_minus1=" + this.O0000OOo + ",\n       slice_group_map_type=" + this.O0000Oo0 + ",\n       weighted_pred_flag=" + this.O0000Oo + ",\n       weighted_bipred_idc=" + this.O0000OoO + ",\n       pic_init_qp_minus26=" + this.O0000Ooo + ",\n       pic_init_qs_minus26=" + this.O0000o00 + ",\n       chroma_qp_index_offset=" + this.O0000o0 + ",\n       deblocking_filter_control_present_flag=" + this.O0000o0O + ",\n       constrained_intra_pred_flag=" + this.O0000o0o + ",\n       redundant_pic_cnt_present_flag=" + this.O0000o + ",\n       top_left=" + this.O0000oO0 + ",\n       bottom_right=" + this.O0000oO + ",\n       run_length_minus1=" + this.O0000oOO + ",\n       slice_group_change_direction_flag=" + this.O0000oOo + ",\n       slice_group_id=" + this.O0000oo0 + ",\n       extended=" + this.O0000oo + '}';
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f1875O000000o;
        public jjd O00000Oo = new jjd();
        public boolean[] O00000o;
        public int O00000o0;

        public final String toString() {
            return "PPSExt{transform_8x8_mode_flag=" + this.f1875O000000o + ", scalindMatrix=" + this.O00000Oo + ", second_chroma_qp_index_offset=" + this.O00000o0 + ", pic_scaling_list_present_flag=" + ((Object) this.O00000o) + '}';
        }
    }
}
