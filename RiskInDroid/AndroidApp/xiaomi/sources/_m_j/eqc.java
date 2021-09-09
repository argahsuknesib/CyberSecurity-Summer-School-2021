package _m_j;

import java.util.Map;

public class eqc implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f15722a = "wcc-ml-test10.bj";
    public static final String b = elk.O00000o0;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f371a;

    /* renamed from: a  reason: collision with other field name */
    private eqf f372a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f373a = eqb.f15720O000000o;

    /* renamed from: b  reason: collision with other field name */
    private boolean f374b = true;
    private String d;
    private String e;
    private String f;

    public eqc(Map<String, Integer> map, int i, String str, eqf eqf) {
        a(map, i, str, eqf);
    }

    public static final String a() {
        String str = c;
        return str != null ? str : elh.O000000o() ? "sandbox.xmpush.xiaomi.com" : elh.O00000Oo() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, eqf eqf) {
        this.f371a = i;
        this.d = str;
        this.f372a = eqf;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m604a() {
        return this.f371a;
    }

    public void a(boolean z) {
        this.f373a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m605a() {
        return this.f373a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m606a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }
}
