package _m_j;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class equ {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15733O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private List<eqo> O00000oo = null;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f15734O000000o = new O000000o("internal-server-error");
        public static final O000000o O00000Oo = new O000000o("forbidden");
        public static final O000000o O00000o = new O000000o("conflict");
        public static final O000000o O00000o0 = new O000000o("bad-request");
        public static final O000000o O00000oO = new O000000o("feature-not-implemented");
        public static final O000000o O00000oo = new O000000o("gone");
        public static final O000000o O0000O0o = new O000000o("item-not-found");
        public static final O000000o O0000OOo = new O000000o("jid-malformed");
        public static final O000000o O0000Oo = new O000000o("not-allowed");
        public static final O000000o O0000Oo0 = new O000000o("not-acceptable");
        public static final O000000o O0000OoO = new O000000o("not-authorized");
        public static final O000000o O0000Ooo = new O000000o("payment-required");
        public static final O000000o O0000o = new O000000o("remote-server-not-found");
        public static final O000000o O0000o0 = new O000000o("redirect");
        public static final O000000o O0000o00 = new O000000o("recipient-unavailable");
        public static final O000000o O0000o0O = new O000000o("registration-required");
        public static final O000000o O0000o0o = new O000000o("remote-server-error");
        public static final O000000o O0000oO = new O000000o("resource-constraint");
        public static final O000000o O0000oO0 = new O000000o("remote-server-timeout");
        public static final O000000o O0000oOO = new O000000o("service-unavailable");
        public static final O000000o O0000oOo = new O000000o("subscription-required");
        public static final O000000o O0000oo = new O000000o("unexpected-request");
        public static final O000000o O0000oo0 = new O000000o("undefined-condition");
        public static final O000000o O0000ooO = new O000000o("request-timeout");
        /* access modifiers changed from: private */
        public String O0000ooo;

        private O000000o(String str) {
            this.O0000ooo = str;
        }

        public final String toString() {
            return this.O0000ooo;
        }
    }

    public equ(int i, String str, String str2, String str3, String str4, List<eqo> list) {
        this.f15733O000000o = i;
        this.O00000Oo = str;
        this.O00000o = str2;
        this.O00000o0 = str3;
        this.O00000oO = str4;
        this.O00000oo = list;
    }

    public equ(Bundle bundle) {
        this.f15733O000000o = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.O00000Oo = bundle.getString("ext_err_type");
        }
        this.O00000o0 = bundle.getString("ext_err_cond");
        this.O00000o = bundle.getString("ext_err_reason");
        this.O00000oO = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.O00000oo = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                this.O00000oo.add(eqo.O000000o((Bundle) parcelable));
            }
        }
    }

    private synchronized List<eqo> O00000o0() {
        if (this.O00000oo == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.O00000oo);
    }

    public final Bundle O000000o() {
        Bundle bundle = new Bundle();
        String str = this.O00000Oo;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f15733O000000o);
        String str2 = this.O00000o;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.O00000o0;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.O00000oO;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<eqo> list = this.O00000oo;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (eqo O00000o02 : this.O00000oo) {
                bundleArr[i] = O00000o02.O00000o0();
                i++;
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f15733O000000o);
        sb.append(jdn.f1779O000000o);
        if (this.O00000Oo != null) {
            sb.append(" type=\"");
            sb.append(this.O00000Oo);
            sb.append(jdn.f1779O000000o);
        }
        if (this.O00000o != null) {
            sb.append(" reason=\"");
            sb.append(this.O00000o);
            sb.append(jdn.f1779O000000o);
        }
        sb.append(">");
        if (this.O00000o0 != null) {
            sb.append("<");
            sb.append(this.O00000o0);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.O00000oO != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.O00000oO);
            sb.append("</text>");
        }
        for (eqo O00000Oo2 : O00000o0()) {
            sb.append(O00000Oo2.O00000Oo());
        }
        sb.append("</error>");
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.O00000o0;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f15733O000000o);
        sb.append(")");
        if (this.O00000oO != null) {
            sb.append(" ");
            sb.append(this.O00000oO);
        }
        return sb.toString();
    }

    public equ(O000000o o000000o) {
        this.O00000o0 = o000000o.O0000ooo;
        this.O00000oO = null;
    }
}
