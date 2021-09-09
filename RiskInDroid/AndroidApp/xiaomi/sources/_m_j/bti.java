package _m_j;

import _m_j.bss;
import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class bti {
    public static btb O000000o(WeakReference<btb> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new btb());
        }
        return weakReference.get();
    }

    public static String O000000o(Context context, brr brr) {
        StringBuilder sb = new StringBuilder();
        try {
            String O00000oo = bww.O00000oo(context);
            sb.append("\"sim\":\"");
            sb.append(O00000oo);
            sb.append("\",\"sdkversion\":\"");
            sb.append(brr.O00000Oo());
            sb.append("\",\"product\":\"");
            sb.append(brr.O000000o());
            sb.append("\",\"ed\":\"");
            sb.append(brr.O00000o0());
            sb.append("\",\"nt\":\"");
            sb.append(bww.O00000o(context));
            sb.append("\",\"np\":\"");
            sb.append(bww.O00000Oo(context));
            sb.append("\",\"mnc\":\"");
            sb.append(bww.O00000o0(context));
            sb.append("\",\"ant\":\"");
            sb.append(bww.O00000oO(context));
            sb.append(jdn.f1779O000000o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static void O000000o(Context context, btb btb, String str, int i, int i2, String str2) {
        btb.f13260O000000o = bsd.O00000o0(context, str);
        btb.O00000o = i;
        btb.O00000Oo = (long) i2;
        btb.O00000o0 = str2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: _m_j.bss$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: _m_j.bss$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: _m_j.bss$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: _m_j.bss$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: _m_j.bss$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: _m_j.bss$O00000Oo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005e A[SYNTHETIC, Splitter:B:46:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0068 A[SYNTHETIC, Splitter:B:51:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0074 A[SYNTHETIC, Splitter:B:58:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x007e A[SYNTHETIC, Splitter:B:63:0x007e] */
    static byte[] O000000o(bss bss, String str) {
        bss.O00000Oo o00000Oo;
        bss.O00000Oo o00000Oo2;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bss.O00000Oo O000000o2 = bss.O000000o(str);
            if (O000000o2 == null) {
                if (O000000o2 != null) {
                    try {
                        O000000o2.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream inputStream2 = O000000o2.f13248O000000o[0];
                if (inputStream2 == null) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (O000000o2 != null) {
                        try {
                            O000000o2.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return bArr;
                }
                bArr = new byte[inputStream2.available()];
                inputStream2.read(bArr);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (O000000o2 != null) {
                    try {
                        O000000o2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                o00000Oo2 = O000000o2;
                try {
                    bsf.O00000Oo(th, "sui", "rdS");
                    if (inputStream != null) {
                    }
                    if (o00000Oo2 != 0) {
                    }
                    return bArr;
                } catch (Throwable th7) {
                    th = th7;
                    o00000Oo = o00000Oo2;
                    if (inputStream != null) {
                    }
                    if (o00000Oo != 0) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            o00000Oo = inputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
            }
            if (o00000Oo != 0) {
                try {
                    o00000Oo.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            throw th;
        }
    }
}
