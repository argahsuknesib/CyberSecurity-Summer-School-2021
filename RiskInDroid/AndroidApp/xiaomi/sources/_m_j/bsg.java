package _m_j;

import android.content.Context;
import android.os.Build;
import com.loc.cg;
import com.loc.t;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bsg {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public static WeakReference<btb> f13234O000000o = null;
    private static boolean O00000Oo = true;
    private static WeakReference<btw> O00000o;
    private static WeakReference<btw> O00000o0;
    private static String[] O00000oO = new String[10];
    private static int O00000oo = 0;
    private static boolean O0000O0o = false;
    private static int O0000OOo = 0;
    private static brr O0000Oo0;

    private static brr O000000o(Context context, String str) {
        List<brr> O00000o02 = bsd.O00000o0(context);
        if (O00000o02 == null) {
            O00000o02 = new ArrayList<>();
        }
        if (str != null && !"".equals(str)) {
            for (brr brr : O00000o02) {
                if (bsd.O000000o(brr.O00000o(), str)) {
                    return brr;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return brs.O000000o();
                } catch (t e) {
                    e.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    brr O00000Oo2 = brs.O00000Oo();
                    O00000Oo2.O000000o(true);
                    return O00000Oo2;
                } catch (t e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        _m_j.bsf.O00000Oo(r8, "alg", "aDa");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00f7, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00f8, code lost:
        _m_j.bsf.O00000Oo(r11, "alg", "getA");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a6 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0109 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6 A[EDGE_INSN: B:45:0x00a6->B:46:? ?: BREAK  
    EDGE_INSN: B:34:0x007a->B:45:0x00a6 ?: BREAK  , SYNTHETIC, Splitter:B:45:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb A[SYNTHETIC, Splitter:B:66:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d5 A[SYNTHETIC, Splitter:B:71:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dc A[SYNTHETIC, Splitter:B:75:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e6 A[SYNTHETIC, Splitter:B:80:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:12:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f3 A[SYNTHETIC, Splitter:B:89:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00fd A[SYNTHETIC, Splitter:B:94:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0104  */
    private static String O000000o(List<brr> list) {
        FileInputStream fileInputStream;
        bst bst;
        try {
            File file = new File("/data/anr/traces.txt");
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                int available = fileInputStream.available();
                if (available > 1024000) {
                    fileInputStream.skip((long) (available - 1024000));
                }
                bst = new bst(fileInputStream, bsu.f13252O000000o);
                boolean z = false;
                while (true) {
                    try {
                        String trim = bst.O000000o().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = bst.O000000o();
                            }
                            z = true;
                        }
                        if (!trim.equals("") || !z) {
                            if (z) {
                                if (O00000oo > 9) {
                                    O00000oo = 0;
                                }
                                O00000oO[O00000oo] = trim;
                                O00000oo++;
                                if (O0000OOo == 5) {
                                    break;
                                } else if (!O0000O0o) {
                                    Iterator<brr> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        brr next = it.next();
                                        boolean O00000Oo2 = bsd.O00000Oo(next.O00000o(), trim);
                                        O0000O0o = O00000Oo2;
                                        if (O00000Oo2) {
                                            O0000Oo0 = next;
                                            break;
                                        }
                                    }
                                } else {
                                    O0000OOo++;
                                }
                            }
                        }
                    } catch (EOFException ) {
                    } catch (FileNotFoundException unused) {
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bsf.O00000Oo(th, "alg", "getA");
                            if (bst != null) {
                                try {
                                    bst.close();
                                } catch (Throwable th2) {
                                    bsf.O00000Oo(th2, "alg", "getA");
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (O0000O0o) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (bst != null) {
                                try {
                                    bst.close();
                                } catch (Throwable th4) {
                                    bsf.O00000Oo(th4, "alg", "getA");
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th5) {
                                    bsf.O00000Oo(th5, "alg", "getA");
                                }
                            }
                            throw th;
                        }
                    }
                }
                try {
                    bst.close();
                } catch (Throwable th6) {
                    bsf.O00000Oo(th6, "alg", "getA");
                }
                try {
                    fileInputStream.close();
                    break;
                } catch (Throwable th7) {
                    bsf.O00000Oo(th7, "alg", "getA");
                }
            } catch (FileNotFoundException unused2) {
                bst = null;
                if (bst != null) {
                }
                if (fileInputStream != null) {
                }
                if (O0000O0o) {
                }
            } catch (Throwable th8) {
                th = th8;
                bst = null;
                if (bst != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            if (O0000O0o) {
                return O00000Oo();
            }
            return null;
        } catch (FileNotFoundException unused3) {
            bst = null;
            fileInputStream = null;
            if (bst != null) {
            }
            if (fileInputStream != null) {
            }
            if (O0000O0o) {
            }
        } catch (Throwable th9) {
            th = th9;
            bst = null;
            fileInputStream = null;
            if (bst != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    static void O000000o(brr brr, Context context, String str, String str2) {
        if (O000000o(brr) && str != null && !"".equals(str)) {
            O000000o(context, brr, 0, str, str2);
        }
    }

    static void O000000o(Context context) {
        String O000000o2;
        brr brr;
        List<brr> O00000o02 = bsd.O00000o0(context);
        if (O00000o02 != null && O00000o02.size() != 0 && (O000000o2 = O000000o(O00000o02)) != null && !"".equals(O000000o2) && (brr = O0000Oo0) != null) {
            O000000o(context, brr, 2, "ANR", O000000o2);
        }
    }

    private static void O000000o(final Context context, final btw btw, final String str) {
        bsf.O00000o().submit(new Runnable() {
            /* class _m_j.bsg.AnonymousClass1 */

            public final void run() {
                try {
                    synchronized (bsg.class) {
                        btb O000000o2 = bti.O000000o(bsg.f13234O000000o);
                        bti.O000000o(context, O000000o2, str, 1000, 40960, "1");
                        O000000o2.O00000oo = btw;
                        if (O000000o2.O0000O0o == null) {
                            O000000o2.O0000O0o = new btm(new btl(context, new btr(), new brv(new brx(new brz())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", bwt.O00000oo(context), bww.O0000oOo(context), bwt.O00000o0(context), Build.MODEL, bwt.O00000Oo(context), bwt.O00000o(context), Build.VERSION.RELEASE));
                        }
                        O000000o2.O0000OOo = 3600000;
                        btc.O000000o(O000000o2);
                    }
                } catch (Throwable th) {
                    bsf.O00000Oo(th, "lg", "pul");
                }
            }
        });
    }

    public static void O000000o(Context context, Throwable th, int i, String str, String str2) {
        String O000000o2 = brs.O000000o(th);
        brr O000000o3 = O000000o(context, O000000o2);
        if (O000000o(O000000o3)) {
            String replaceAll = O000000o2.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                O000000o(context, O000000o3, i, th2, sb.toString());
            }
        }
    }

    private static String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = O00000oo;
            while (i < 10 && i <= 9) {
                sb.append(O00000oO[i]);
                i++;
            }
            for (int i2 = 0; i2 < O00000oo; i2++) {
                sb.append(O00000oO[i2]);
            }
        } catch (Throwable th) {
            bsf.O00000Oo(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void O00000Oo(brr brr, Context context, String str, String str2) {
        if (O000000o(brr) && str != null && !"".equals(str)) {
            O000000o(context, brr, 1, str, str2);
        }
    }

    static void O00000Oo(Context context) {
        btu btu = new btu(O00000Oo);
        O00000Oo = false;
        O000000o(context, btu, bsd.O00000o0);
    }

    static void O00000o(Context context) {
        WeakReference<btw> weakReference = O00000o;
        if (weakReference == null || weakReference.get() == null) {
            O00000o = new WeakReference<>(new btv(context, 3600000, "gKey", new cg(context)));
        }
        O000000o(context, O00000o.get(), bsd.O00000Oo);
    }

    static void O00000o0(Context context) {
        WeakReference<btw> weakReference = O00000o0;
        if (weakReference == null || weakReference.get() == null) {
            O00000o0 = new WeakReference<>(new btv(context, 3600000, "hKey", new cg(context)));
        }
        O000000o(context, O00000o0.get(), bsd.O00000o);
    }

    private static boolean O000000o(brr brr) {
        if (brr != null) {
            if (brr.f13222O000000o == 1) {
                return true;
            }
        }
        return false;
    }

    private static void O000000o(Context context, brr brr, int i, String str, String str2) {
        String str3;
        String O000000o2 = brs.O000000o(System.currentTimeMillis());
        String O000000o3 = bti.O000000o(context, brr);
        bwt.O000000o(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(O000000o3);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(O000000o2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append(jdn.f1779O000000o);
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !"".equals(stringBuffer2)) {
            String O00000oo2 = brs.O00000oo(brp.O00000Oo(str2));
            if (i == 1) {
                str3 = bsd.O00000Oo;
            } else if (i == 2) {
                str3 = bsd.O00000o;
            } else if (i == 0) {
                str3 = bsd.O00000o0;
            } else {
                return;
            }
            String str4 = str3;
            btb O000000o4 = bti.O000000o(f13234O000000o);
            bti.O000000o(context, O000000o4, str4, 1000, 40960, "1");
            if (O000000o4.O00000oO == null) {
                O000000o4.O00000oO = new bru(new brv(new brx(new brz())));
            }
            try {
                btc.O000000o(O00000oo2, brs.O000000o(stringBuffer2.replaceAll("\n", "<br/>")), O000000o4);
            } catch (Throwable unused) {
            }
        }
    }
}
