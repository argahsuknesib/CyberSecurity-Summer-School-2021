package _m_j;

import com.xiaomi.mijialog.CLoganProtocol;

class dxk implements dxl {
    private static volatile dxk O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    dxn f15031O000000o;
    private boolean O00000o;
    private dxl O00000o0;

    private dxk() {
    }

    static dxk O000000o() {
        if (O00000Oo == null) {
            synchronized (dxk.class) {
                if (O00000Oo == null) {
                    O00000Oo = new dxk();
                }
            }
        }
        return O00000Oo;
    }

    public final void O00000o0() {
        dxl dxl = this.O00000o0;
        if (dxl != null) {
            dxl.O00000o0();
        }
    }

    public final void O000000o(int i, String str, String str2, String str3, long j, String str4, long j2, boolean z) {
        dxl dxl = this.O00000o0;
        if (dxl != null) {
            dxl.O000000o(i, str, str2, str3, j, str4, j2, z);
        }
    }

    public final void O000000o(String str) {
        dxl dxl = this.O00000o0;
        if (dxl != null) {
            dxl.O000000o(str);
        }
    }

    public final void O000000o(String str, String str2, int i, String str3) {
        if (!this.O00000o) {
            if (CLoganProtocol.O000000o()) {
                this.O00000o0 = CLoganProtocol.O00000Oo();
                this.O00000o0.O000000o(this.f15031O000000o);
                this.O00000o0.O000000o(str, str2, i, str3);
                this.O00000o = true;
                return;
            }
            this.O00000o0 = null;
        }
    }

    public final void O000000o(boolean z) {
        dxl dxl = this.O00000o0;
        if (dxl != null) {
            dxl.O000000o(z);
        }
    }

    public final void O000000o(dxn dxn) {
        this.f15031O000000o = dxn;
    }
}
