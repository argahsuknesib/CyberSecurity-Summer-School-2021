package _m_j;

import android.os.Bundle;
import android.text.TextUtils;

public final class eqq extends eqr {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f15730O000000o = null;
    String O00000Oo = null;
    String O00000o;
    String O00000o0;
    String O00000oO;
    String O00000oo;
    boolean O0000O0o = false;
    String O0000OOo;
    String O0000Oo = "";
    String O0000Oo0 = "";
    String O0000OoO = "";
    String O0000Ooo = "";
    boolean O0000o00 = false;

    public eqq() {
    }

    public eqq(Bundle bundle) {
        super(bundle);
        this.f15730O000000o = bundle.getString("ext_msg_type");
        this.O00000o0 = bundle.getString("ext_msg_lang");
        this.O00000Oo = bundle.getString("ext_msg_thread");
        this.O00000o = bundle.getString("ext_msg_sub");
        this.O00000oO = bundle.getString("ext_msg_body");
        this.O00000oo = bundle.getString("ext_body_encode");
        this.O0000OOo = bundle.getString("ext_msg_appid");
        this.O0000O0o = bundle.getBoolean("ext_msg_trans", false);
        this.O0000o00 = bundle.getBoolean("ext_msg_encrypt", false);
        this.O0000Oo0 = bundle.getString("ext_msg_seq");
        this.O0000Oo = bundle.getString("ext_msg_mseq");
        this.O0000OoO = bundle.getString("ext_msg_fseq");
        this.O0000Ooo = bundle.getString("ext_msg_status");
    }

    public final Bundle O000000o() {
        Bundle O000000o2 = super.O000000o();
        if (!TextUtils.isEmpty(this.f15730O000000o)) {
            O000000o2.putString("ext_msg_type", this.f15730O000000o);
        }
        String str = this.O00000o0;
        if (str != null) {
            O000000o2.putString("ext_msg_lang", str);
        }
        String str2 = this.O00000o;
        if (str2 != null) {
            O000000o2.putString("ext_msg_sub", str2);
        }
        String str3 = this.O00000oO;
        if (str3 != null) {
            O000000o2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.O00000oo)) {
            O000000o2.putString("ext_body_encode", this.O00000oo);
        }
        String str4 = this.O00000Oo;
        if (str4 != null) {
            O000000o2.putString("ext_msg_thread", str4);
        }
        String str5 = this.O0000OOo;
        if (str5 != null) {
            O000000o2.putString("ext_msg_appid", str5);
        }
        if (this.O0000O0o) {
            O000000o2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.O0000Oo0)) {
            O000000o2.putString("ext_msg_seq", this.O0000Oo0);
        }
        if (!TextUtils.isEmpty(this.O0000Oo)) {
            O000000o2.putString("ext_msg_mseq", this.O0000Oo);
        }
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            O000000o2.putString("ext_msg_fseq", this.O0000OoO);
        }
        if (this.O0000o00) {
            O000000o2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            O000000o2.putString("ext_msg_status", this.O0000Ooo);
        }
        return O000000o2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            eqq eqq = (eqq) obj;
            if (!super.equals(eqq)) {
                return false;
            }
            String str = this.O00000oO;
            if (str == null ? eqq.O00000oO != null : !str.equals(eqq.O00000oO)) {
                return false;
            }
            String str2 = this.O00000o0;
            if (str2 == null ? eqq.O00000o0 != null : !str2.equals(eqq.O00000o0)) {
                return false;
            }
            String str3 = this.O00000o;
            if (str3 == null ? eqq.O00000o != null : !str3.equals(eqq.O00000o)) {
                return false;
            }
            String str4 = this.O00000Oo;
            if (str4 == null ? eqq.O00000Oo != null : !str4.equals(eqq.O00000Oo)) {
                return false;
            }
            if (this.f15730O000000o == eqq.f15730O000000o) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f15730O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000oO;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O00000Oo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.O00000o0;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.O00000o;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public final String O00000Oo() {
        equ equ;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (this.O0000o0o != null) {
            sb.append(" xmlns=\"");
            sb.append(this.O0000o0o);
            sb.append(jdn.f1779O000000o);
        }
        if (this.O00000o0 != null) {
            sb.append(" xml:lang=\"");
            sb.append(this.O00000o0);
            sb.append(jdn.f1779O000000o);
        }
        if (O00000o() != null) {
            sb.append(" id=\"");
            sb.append(O00000o());
            sb.append(jdn.f1779O000000o);
        }
        if (this.O0000oO0 != null) {
            sb.append(" to=\"");
            sb.append(erb.O000000o(this.O0000oO0));
            sb.append(jdn.f1779O000000o);
        }
        if (!TextUtils.isEmpty(this.O0000Oo0)) {
            sb.append(" seq=\"");
            sb.append(this.O0000Oo0);
            sb.append(jdn.f1779O000000o);
        }
        if (!TextUtils.isEmpty(this.O0000Oo)) {
            sb.append(" mseq=\"");
            sb.append(this.O0000Oo);
            sb.append(jdn.f1779O000000o);
        }
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            sb.append(" fseq=\"");
            sb.append(this.O0000OoO);
            sb.append(jdn.f1779O000000o);
        }
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            sb.append(" status=\"");
            sb.append(this.O0000Ooo);
            sb.append(jdn.f1779O000000o);
        }
        if (this.O0000oO != null) {
            sb.append(" from=\"");
            sb.append(erb.O000000o(this.O0000oO));
            sb.append(jdn.f1779O000000o);
        }
        if (this.O0000oOO != null) {
            sb.append(" chid=\"");
            sb.append(erb.O000000o(this.O0000oOO));
            sb.append(jdn.f1779O000000o);
        }
        if (this.O0000O0o) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.O0000OOo)) {
            sb.append(" appid=\"");
            sb.append(this.O0000OOo);
            sb.append(jdn.f1779O000000o);
        }
        if (!TextUtils.isEmpty(this.f15730O000000o)) {
            sb.append(" type=\"");
            sb.append(this.f15730O000000o);
            sb.append(jdn.f1779O000000o);
        }
        if (this.O0000o00) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.O00000o != null) {
            sb.append("<subject>");
            sb.append(erb.O000000o(this.O00000o));
            sb.append("</subject>");
        }
        if (this.O00000oO != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.O00000oo)) {
                sb.append(" encode=\"");
                sb.append(this.O00000oo);
                sb.append(jdn.f1779O000000o);
            }
            sb.append(">");
            sb.append(erb.O000000o(this.O00000oO));
            sb.append("</body>");
        }
        if (this.O00000Oo != null) {
            sb.append("<thread>");
            sb.append(this.O00000Oo);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f15730O000000o) && (equ = this.O0000oo0) != null) {
            sb.append(equ.O00000Oo());
        }
        sb.append(O00000oO());
        sb.append("</message>");
        return sb.toString();
    }
}
