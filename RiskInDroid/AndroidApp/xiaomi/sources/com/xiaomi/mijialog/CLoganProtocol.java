package com.xiaomi.mijialog;

import _m_j.dxh;
import _m_j.dxl;
import _m_j.dxn;
import _m_j.dxo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CLoganProtocol implements dxl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile CLoganProtocol f6028O000000o;
    private static boolean O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private DateFormat O00000oO = new SimpleDateFormat("HH:mm:ss:SSS");
    private dxn O00000oo;
    private Set<Integer> O0000O0o = Collections.synchronizedSet(new HashSet());

    private native void clogan_debug(boolean z);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i, String str3);

    private native int clogan_open(String str);

    private native int clogan_write(int i, String str, String str2, String str3, long j, String str4, long j2, int i2);

    CLoganProtocol() {
    }

    static {
        try {
            if (!dxo.O000000o("smarthome_log", CLoganProtocol.class)) {
                System.loadLibrary("smarthome_log");
            }
            O00000Oo = true;
        } catch (Throwable th) {
            th.printStackTrace();
            O00000Oo = false;
        }
    }

    public static boolean O000000o() {
        return O00000Oo;
    }

    public static CLoganProtocol O00000Oo() {
        if (f6028O000000o == null) {
            synchronized (CLoganProtocol.class) {
                if (f6028O000000o == null) {
                    f6028O000000o = new CLoganProtocol();
                }
            }
        }
        return f6028O000000o;
    }

    public final void O000000o(String str, String str2, int i, String str3) {
        if (!this.O00000o0) {
            if (!O00000Oo) {
                O000000o("logan_loadso", -5020);
                return;
            }
            try {
                int clogan_init = clogan_init(str, str2, i, str3);
                this.O00000o0 = true;
                O000000o("clogan_init", clogan_init);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                O000000o("clogan_init", -1060);
            }
        }
    }

    public final void O000000o(boolean z) {
        if (this.O00000o0 && O00000Oo) {
            try {
                clogan_debug(z);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(dxn dxn) {
        this.O00000oo = dxn;
    }

    public final void O000000o(String str) {
        if (this.O00000o0 && O00000Oo) {
            try {
                int clogan_open = clogan_open(str);
                this.O00000o = true;
                O000000o("clogan_open", clogan_open);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                O000000o("clogan_open", -2070);
            }
        }
    }

    public final void O00000o0() {
        if (this.O00000o && O00000Oo) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(int i, String str, String str2, String str3, long j, String str4, long j2, boolean z) {
        if (this.O00000o && O00000Oo) {
            try {
                int clogan_write = clogan_write(i, str == null ? "" : str, str2 == null ? "" : str2, str3, j, str4, j2, z ? 1 : 0);
                if (clogan_write != -4010 || dxh.f15027O000000o) {
                    O000000o("clogan_write", clogan_write);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                O000000o("clogan_write", -4060);
            }
        }
    }

    private void O000000o(String str, int i) {
        if (i < 0) {
            if ("clogan_write".endsWith(str) && i != -4060) {
                if (!this.O0000O0o.contains(Integer.valueOf(i))) {
                    this.O0000O0o.add(Integer.valueOf(i));
                } else {
                    return;
                }
            }
            dxn dxn = this.O00000oo;
            if (dxn != null) {
                dxn.O000000o(str, i);
            }
        }
    }
}
