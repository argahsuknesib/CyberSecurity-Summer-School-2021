package _m_j;

import java.util.Arrays;

public final class jke {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f1897O000000o;
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

    public final int hashCode() {
        int i;
        int i2 = 1231;
        int hashCode = (((((((((Arrays.hashCode(this.O0000oO) + 31) * 31) + this.O0000o0) * 31) + (this.O0000o0o ? 1231 : 1237)) * 31) + (this.O0000o0O ? 1231 : 1237)) * 31) + (this.f1897O000000o ? 1231 : 1237)) * 31;
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
        jke jke = (jke) obj;
        if (!Arrays.equals(this.O0000oO, jke.O0000oO) || this.O0000o0 != jke.O0000o0 || this.O0000o0o != jke.O0000o0o || this.O0000o0O != jke.O0000o0O || this.f1897O000000o != jke.f1897O000000o) {
            return false;
        }
        O000000o o000000o = this.O0000oo;
        if (o000000o == null) {
            if (jke.O0000oo != null) {
                return false;
            }
        } else if (!o000000o.equals(jke.O0000oo)) {
            return false;
        }
        return this.O00000Oo == jke.O00000Oo && this.O00000o0 == jke.O00000o0 && this.O0000OOo == jke.O0000OOo && this.O0000Ooo == jke.O0000Ooo && this.O0000o00 == jke.O0000o00 && this.O0000O0o == jke.O0000O0o && this.O00000oO == jke.O00000oO && this.O0000o == jke.O0000o && Arrays.equals(this.O0000oOO, jke.O0000oOO) && this.O00000oo == jke.O00000oo && this.O0000oOo == jke.O0000oOo && this.O00000o == jke.O00000o && Arrays.equals(this.O0000oo0, jke.O0000oo0) && this.O0000Oo0 == jke.O0000Oo0 && Arrays.equals(this.O0000oO0, jke.O0000oO0) && this.O0000OoO == jke.O0000OoO && this.O0000Oo == jke.O0000Oo;
    }

    public final String toString() {
        return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.f1897O000000o + ",\n       num_ref_idx_l0_active_minus1=" + this.O00000Oo + ",\n       num_ref_idx_l1_active_minus1=" + this.O00000o0 + ",\n       slice_group_change_rate_minus1=" + this.O00000o + ",\n       pic_parameter_set_id=" + this.O00000oO + ",\n       seq_parameter_set_id=" + this.O00000oo + ",\n       pic_order_present_flag=" + this.O0000O0o + ",\n       num_slice_groups_minus1=" + this.O0000OOo + ",\n       slice_group_map_type=" + this.O0000Oo0 + ",\n       weighted_pred_flag=" + this.O0000Oo + ",\n       weighted_bipred_idc=" + this.O0000OoO + ",\n       pic_init_qp_minus26=" + this.O0000Ooo + ",\n       pic_init_qs_minus26=" + this.O0000o00 + ",\n       chroma_qp_index_offset=" + this.O0000o0 + ",\n       deblocking_filter_control_present_flag=" + this.O0000o0O + ",\n       constrained_intra_pred_flag=" + this.O0000o0o + ",\n       redundant_pic_cnt_present_flag=" + this.O0000o + ",\n       top_left=" + this.O0000oO0 + ",\n       bottom_right=" + this.O0000oO + ",\n       run_length_minus1=" + this.O0000oOO + ",\n       slice_group_change_direction_flag=" + this.O0000oOo + ",\n       slice_group_id=" + this.O0000oo0 + ",\n       extended=" + this.O0000oo + '}';
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f1898O000000o;
        public jkg O00000Oo = new jkg();
        public boolean[] O00000o;
        public int O00000o0;

        public final String toString() {
            return "PPSExt{transform_8x8_mode_flag=" + this.f1898O000000o + ", scalindMatrix=" + this.O00000Oo + ", second_chroma_qp_index_offset=" + this.O00000o0 + ", pic_scaling_list_present_flag=" + ((Object) this.O00000o) + '}';
        }
    }
}
