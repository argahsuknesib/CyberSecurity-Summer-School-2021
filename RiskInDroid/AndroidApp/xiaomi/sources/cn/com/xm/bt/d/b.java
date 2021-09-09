package cn.com.xm.bt.d;

import cn.com.xm.bt.profile.b.g;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f3088a = null;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private c h = null;

    public b(c cVar) {
        this.h = cVar;
        this.f3088a = this.h.f3089a;
        this.f = g.a(this.h.c);
    }

    public b(String str, int i, int i2) {
        this.f3088a = str;
        this.b = Integer.decode("0x" + str.substring(8, 10)).intValue();
        this.c = Integer.decode("0x" + str.substring(10, 12)).intValue();
        this.d = Integer.decode("0x" + str.substring(12, 14)).intValue();
        this.e = i;
        this.f = i2;
    }

    public b(String str, int i, int i2, int i3) {
        this.f3088a = str;
        this.b = Integer.decode("0x" + str.substring(8, 10)).intValue();
        this.c = Integer.decode("0x" + str.substring(10, 12)).intValue();
        this.d = Integer.decode("0x" + str.substring(12, 14)).intValue();
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    private boolean b() {
        return (this.g == -1 || (this.d & 255) == 8) ? false : true;
    }

    private boolean c() {
        if ((this.b & 255) == 5 && (this.c & 255) == 0) {
            return true;
        }
        if ((this.b & 255) == 0 && (this.d & 255) == 208) {
            return true;
        }
        return ((this.b & 255) == 0 && (this.d & 255) == 8) || d();
    }

    private boolean d() {
        return (this.b & 255) == 4 && (this.d & 255) == 8;
    }

    private boolean e() {
        c cVar = this.h;
        if (cVar == null || !cVar.a()) {
            return false;
        }
        return this.h.d.c == 4 || this.h.d.c == 260;
    }

    private boolean f() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 11;
    }

    private boolean g() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 3;
    }

    private boolean h() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 5;
    }

    private boolean i() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 7;
    }

    private boolean j() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 8;
    }

    private boolean k() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 36897;
    }

    private boolean l() {
        c cVar = this.h;
        return cVar != null && cVar.a() && this.h.d.c == 6;
    }

    private boolean m() {
        if ((this.b & 255) != 0 || (this.c & 255) != 0) {
            return false;
        }
        int i = this.d;
        return (i & 255) == 2 || (i & 255) == 1 || (i & 255) == 49;
    }

    public final cn.com.xm.bt.b.b a() {
        if (b()) {
            return cn.com.xm.bt.b.b.MILI_1S;
        }
        if (c()) {
            return cn.com.xm.bt.b.b.MILI_1A;
        }
        if (e()) {
            return cn.com.xm.bt.b.b.MILI_PRO;
        }
        if (f()) {
            return cn.com.xm.bt.b.b.MILI_NFC;
        }
        if (g()) {
            return cn.com.xm.bt.b.b.SHOES;
        }
        if (h()) {
            return cn.com.xm.bt.b.b.SHOES_CHILD;
        }
        if (i()) {
            return cn.com.xm.bt.b.b.SHOES_LIGHT;
        }
        if (j()) {
            return cn.com.xm.bt.b.b.SHOES_SPRANDI;
        }
        if (k()) {
            return cn.com.xm.bt.b.b.WEIGHT;
        }
        if (l()) {
            return cn.com.xm.bt.b.b.WEIGHT_BODYFAT;
        }
        if (m()) {
            return cn.com.xm.bt.b.b.MILI;
        }
        return cn.com.xm.bt.b.b.VDEVICE;
    }

    private String n() {
        c cVar = this.h;
        if (cVar != null) {
            return cVar.c;
        }
        return q() + "." + r() + "." + s() + "." + p();
    }

    private String o() {
        return y() + "." + z() + "." + A() + "." + x();
    }

    private int p() {
        return this.f & 255;
    }

    private int q() {
        return (this.f >> 24) & 255;
    }

    private int r() {
        return (this.f >> 16) & 255;
    }

    private int s() {
        return (this.f >> 8) & 255;
    }

    private int t() {
        return this.e & 255;
    }

    private int u() {
        return (this.e >> 24) & 255;
    }

    private int v() {
        return (this.e >> 16) & 255;
    }

    private int w() {
        return (this.e >> 8) & 255;
    }

    private int x() {
        return this.g & 255;
    }

    private int y() {
        return (this.g >> 24) & 255;
    }

    private int z() {
        return (this.g >> 16) & 255;
    }

    private int A() {
        return (this.g >> 8) & 255;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("[[[ " + getClass().getSimpleName() + " ]]]");
        StringBuilder sb2 = new StringBuilder("\n         deviceID: ");
        sb2.append(this.f3088a);
        sb.append(sb2.toString());
        sb.append("\n          feature: " + Integer.toHexString(this.b));
        sb.append("\n       appearance: " + Integer.toHexString(this.c));
        sb.append("\n  hardwareVersion: " + Integer.toHexString(this.d));
        sb.append("\n   profileVersion: ".concat(String.valueOf(u() + "." + v() + "." + w() + "." + t())));
        sb.append("\n  firmwareVersion: " + n());
        sb.append("\n firmware2Version: " + o());
        sb.append("\n     deviceSource: " + a());
        if (this.h != null) {
            sb.append("\n generalInfo:" + this.h);
        }
        return sb.toString();
    }
}
