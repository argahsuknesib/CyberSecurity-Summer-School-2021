package _m_j;

public final class dvx {

    /* renamed from: O000000o  reason: collision with root package name */
    int f14990O000000o = 50000;
    int O00000Oo = 50000;
    public int O00000o = 5242880;
    int O00000o0 = 3;
    int O00000oO = 4;
    int O00000oo = 10;
    int O0000O0o = 30;
    int O0000OOo = 10240;
    public boolean O0000Oo = true;
    public dwa O0000Oo0;
    public boolean O0000OoO = false;
    public String O0000Ooo;
    private boolean O0000o = false;
    private int O0000o0 = 0;
    private int O0000o00 = 0;
    private String O0000o0O = "cnbj0";
    private boolean O0000o0o = true;
    private String O0000oO0 = "";

    public final int[] O000000o() {
        return new int[]{this.O0000o00, this.O0000o0};
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo() {
        return O000000o(this.O0000OoO);
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(boolean z) {
        if (this.O0000o) {
            return this.O0000oO0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000Oo ? "https://" : "http://");
        String str = this.O0000Ooo;
        if (str != null && !str.isEmpty()) {
            sb.append(this.O0000Ooo);
        } else if (z) {
            sb.append("cdn." + this.O0000o0O + ".fds.api.mi-img.com");
        } else {
            sb.append(this.O0000o0O + ".fds.api.xiaomi.com");
        }
        return sb.toString();
    }
}
