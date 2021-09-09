package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cm {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<dj> f3370a = null;
    private static boolean b = true;
    private static WeakReference<ec> c;
    private static WeakReference<ec> d;
    private static String[] e = new String[10];
    private static int f = 0;
    private static boolean g = false;
    private static int h = 0;
    private static by i;

    private static boolean a(by byVar) {
        return byVar != null && byVar.e();
    }

    private static void a(Context context, by byVar, int i2, String str, String str2) {
        String str3;
        String a2 = dp.a();
        String a3 = dp.a(bp.a(context), dp.a(context, byVar), a2, i2, str, str2);
        if (a3 != null && !"".equals(a3)) {
            String b2 = bw.b(str2);
            if (i2 == 1) {
                str3 = cj.b;
            } else if (i2 == 2) {
                str3 = cj.d;
            } else if (i2 == 0) {
                str3 = cj.c;
            } else {
                return;
            }
            a(context, b2, str3, a3);
        }
    }

    static void a(Context context) {
        String a2;
        by byVar;
        List<by> c2 = cj.c(context);
        if (c2 != null && c2.size() != 0 && (a2 = a(c2)) != null && !"".equals(a2) && (byVar = i) != null) {
            a(context, byVar, 2, "ANR", a2);
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = bz.a(th);
        by a3 = a(context, a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String a4 = a(th);
            if (a4 != null && !"".equals(a4)) {
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
                a(context, a3, i2, a4, sb.toString());
            }
        }
    }

    static void a(by byVar, Context context, String str, String str2) {
        if (a(byVar) && str != null && !"".equals(str)) {
            a(context, byVar, 0, str, str2);
        }
    }

    static void b(by byVar, Context context, String str, String str2) {
        if (a(byVar) && str != null && !"".equals(str)) {
            a(context, byVar, 1, str, str2);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        dj a2 = dp.a(f3370a);
        dp.a(context, a2, str2, 1000, 40960, "1");
        if (a2.e == null) {
            a2.e = new ca(new cb(new cd(new cf())));
        }
        try {
            dk.a(str, bz.a(str3.replaceAll("\n", "<br/>")), a2);
        } catch (Throwable unused) {
        }
    }

    static void b(Context context) {
        ea eaVar = new ea(b);
        b = false;
        a(context, eaVar, cj.c);
    }

    static void c(Context context) {
        WeakReference<ec> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new eb(context, 3600000, "hKey", new ed(context, false)));
        }
        a(context, c.get(), cj.d);
    }

    static void d(Context context) {
        WeakReference<ec> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new eb(context, 3600000, "gKey", new ed(context, false)));
        }
        a(context, d.get(), cj.b);
    }

    private static void a(final Context context, final ec ecVar, final String str) {
        cl.c().submit(new Runnable() {
            /* class com.amap.api.services.a.cm.AnonymousClass1 */

            public final void run() {
                try {
                    synchronized (cm.class) {
                        dj a2 = dp.a(cm.f3370a);
                        dp.a(context, a2, str, 1000, 40960, "1");
                        a2.f = ecVar;
                        if (a2.g == null) {
                            a2.g = new dt(new ds(context, new dx(), new cb(new cd(new cf())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", bp.f(context), bt.u(context), bp.c(context), Build.MODEL, bp.b(context), bp.d(context), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        dk.a(a2);
                    }
                } catch (Throwable th) {
                    cl.c(th, "lg", "pul");
                }
            }
        });
    }

    static by a(Context context, String str) {
        List<by> c2 = cj.c(context);
        if (c2 == null) {
            c2 = new ArrayList<>();
        }
        if (str != null && !"".equals(str)) {
            for (by byVar : c2) {
                if (cj.a(byVar.f(), str)) {
                    return byVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return bz.a();
                } catch (bo e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    by b2 = bz.b();
                    b2.a(true);
                    return b2;
                } catch (bo e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String a(Throwable th) {
        return th.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b3 A[SYNTHETIC, Splitter:B:58:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bd A[SYNTHETIC, Splitter:B:63:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4 A[SYNTHETIC, Splitter:B:67:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ce A[SYNTHETIC, Splitter:B:72:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00db A[SYNTHETIC, Splitter:B:81:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00e5 A[SYNTHETIC, Splitter:B:86:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00f1 A[RETURN] */
    static String a(List<by> list) {
        FileInputStream fileInputStream;
        cy cyVar;
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
                cyVar = new cy(fileInputStream, cz.f3388a);
                boolean z = false;
                while (true) {
                    try {
                        String trim = cyVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = cyVar.a();
                            }
                            z = true;
                        }
                        if (trim.equals("") && z) {
                            break;
                        } else if (z) {
                            a(trim);
                            if (h == 5) {
                                break;
                            } else if (!g) {
                                Iterator<by> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    by next = it.next();
                                    boolean b2 = cj.b(next.f(), trim);
                                    g = b2;
                                    if (b2) {
                                        i = next;
                                        break;
                                    }
                                }
                            } else {
                                h++;
                            }
                        }
                    } catch (EOFException ) {
                        try {
                            cyVar.close();
                        } catch (Throwable th) {
                            cl.c(th, "alg", "getA");
                        }
                        try {
                            fileInputStream.close();
                            break;
                        } catch (Throwable th2) {
                            cl.c(th2, "alg", "getA");
                        }
                    } catch (FileNotFoundException unused) {
                        if (cyVar != null) {
                            try {
                                cyVar.close();
                            } catch (Throwable th3) {
                                cl.c(th3, "alg", "getA");
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (g) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            cl.c(th, "alg", "getA");
                            if (cyVar != null) {
                                try {
                                    cyVar.close();
                                } catch (Throwable th5) {
                                    cl.c(th5, "alg", "getA");
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (g) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (cyVar != null) {
                                try {
                                    cyVar.close();
                                } catch (Throwable th7) {
                                    cl.c(th7, "alg", "getA");
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th8) {
                                    cl.c(th8, "alg", "getA");
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (FileNotFoundException unused2) {
                cyVar = null;
                if (cyVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th9) {
                th = th9;
                cyVar = null;
                if (cyVar != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            if (g) {
                return b();
            }
            return null;
        } catch (FileNotFoundException unused3) {
            cyVar = null;
            fileInputStream = null;
            if (cyVar != null) {
            }
            if (fileInputStream != null) {
            }
            if (g) {
            }
        } catch (Throwable th10) {
            th = th10;
            cyVar = null;
            fileInputStream = null;
            if (cyVar != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    private static void a(String str) {
        try {
            if (f > 9) {
                f = 0;
            }
            e[f] = str;
            f++;
        } catch (Throwable th) {
            cl.c(th, "alg", "aDa");
        }
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (i2 < 10 && i2 <= 9) {
                sb.append(e[i2]);
                i2++;
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            cl.c(th, "alg", "gLI");
        }
        return sb.toString();
    }
}
