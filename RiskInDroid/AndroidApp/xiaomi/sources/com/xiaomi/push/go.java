package com.xiaomi.push;

import _m_j.eqr;
import _m_j.equ;
import _m_j.erb;
import _m_j.jdn;
import android.os.Bundle;

public final class go extends eqr {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6385O000000o = null;
    public a O00000Oo = null;
    private int O00000o = Integer.MIN_VALUE;
    private b O00000o0 = b.f6387a;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6386a = new a("chat", 0);

        /* renamed from: a  reason: collision with other field name */
        private static final /* synthetic */ a[] f44a = a();
        public static final a b = new a("available", 1);
        public static final a c = new a("away", 2);
        public static final a d = new a("xa", 3);
        public static final a e = new a("dnd", 4);

        private a(String str, int i) {
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f6386a, b, c, d, e};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f44a.clone();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class b extends Enum<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f6387a = new b("available", 0);

        /* renamed from: a  reason: collision with other field name */
        private static final /* synthetic */ b[] f45a = a();
        public static final b b = new b("unavailable", 1);
        public static final b c = new b("subscribe", 2);
        public static final b d = new b("subscribed", 3);
        public static final b e = new b("unsubscribe", 4);
        public static final b f = new b("unsubscribed", 5);
        public static final b g = new b("error", 6);
        public static final b h = new b("probe", 7);

        private b(String str, int i) {
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f6387a, b, c, d, e, f, g, h};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f45a.clone();
        }
    }

    public go(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.O00000o0 = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f6385O000000o = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.O00000o = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.O00000Oo = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public final Bundle O000000o() {
        Bundle O000000o2 = super.O000000o();
        b bVar = this.O00000o0;
        if (bVar != null) {
            O000000o2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f6385O000000o;
        if (str != null) {
            O000000o2.putString("ext_pres_status", str);
        }
        int i = this.O00000o;
        if (i != Integer.MIN_VALUE) {
            O000000o2.putInt("ext_pres_prio", i);
        }
        a aVar = this.O00000Oo;
        if (!(aVar == null || aVar == a.b)) {
            O000000o2.putString("ext_pres_mode", this.O00000Oo.toString());
        }
        return O000000o2;
    }

    public final void O000000o(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.O00000o = i;
    }

    public go(b bVar) {
        if (bVar != null) {
            this.O00000o0 = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (this.O0000o0o != null) {
            sb.append(" xmlns=\"");
            sb.append(this.O0000o0o);
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
        if (this.O00000o0 != null) {
            sb.append(" type=\"");
            sb.append(this.O00000o0);
            sb.append(jdn.f1779O000000o);
        }
        sb.append(">");
        if (this.f6385O000000o != null) {
            sb.append("<status>");
            sb.append(erb.O000000o(this.f6385O000000o));
            sb.append("</status>");
        }
        if (this.O00000o != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.O00000o);
            sb.append("</priority>");
        }
        a aVar = this.O00000Oo;
        if (!(aVar == null || aVar == a.b)) {
            sb.append("<show>");
            sb.append(this.O00000Oo);
            sb.append("</show>");
        }
        sb.append(O00000oO());
        equ equ = this.O0000oo0;
        if (equ != null) {
            sb.append(equ.O00000Oo());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
