package com.amap.api.services.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

public class bx {
    public static Proxy a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return a(context, new URI("http://restapi.amap.com"));
            }
            return b(context);
        } catch (Throwable th) {
            cl.c(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x014f A[SYNTHETIC, Splitter:B:114:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0158 A[Catch:{ Throwable -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0170 A[SYNTHETIC, Splitter:B:124:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c7 A[SYNTHETIC, Splitter:B:65:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A[SYNTHETIC, Splitter:B:77:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f9 A[Catch:{ all -> 0x00ba }] */
    private static Proxy b(Context context) {
        Cursor cursor;
        Throwable th;
        String str;
        String str2;
        int i;
        String s;
        int i2;
        String str3;
        String str4;
        String str5;
        boolean z;
        String str6;
        String str7;
        boolean z2;
        String str8;
        if (c(context)) {
            boolean z3 = false;
            int i3 = -1;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("apn"));
                            if (string != null) {
                                string = string.toLowerCase(Locale.US);
                            }
                            if (string != null && string.contains("ctwap")) {
                                String a2 = a();
                                i = b();
                                try {
                                    if (TextUtils.isEmpty(a2) || a2.equals("null")) {
                                        str2 = null;
                                        z2 = false;
                                    } else {
                                        str2 = a2;
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        try {
                                            str8 = a("QMTAuMC4wLjIwMA==");
                                        } catch (SecurityException e) {
                                            e = e;
                                            cl.c(e, "pu", "ghp");
                                            s = bt.s(context);
                                            if (s == null) {
                                            }
                                            if (cursor != null) {
                                            }
                                            if (a(str, i3)) {
                                            }
                                            return null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i3 = i;
                                            str5 = str2;
                                            try {
                                                cl.c(th, "pu", "gPx1");
                                                th.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                if (a(str, i3)) {
                                                }
                                                return null;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (cursor != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    } else {
                                        str8 = str2;
                                    }
                                    i3 = i == -1 ? 80 : i;
                                    str = str8;
                                    if (cursor != null) {
                                    }
                                } catch (SecurityException e2) {
                                    e = e2;
                                    str2 = null;
                                    cl.c(e, "pu", "ghp");
                                    s = bt.s(context);
                                    if (s == null) {
                                        String lowerCase = s.toLowerCase(Locale.US);
                                        String a3 = a();
                                        int b = b();
                                        if (lowerCase.indexOf("ctwap") != -1) {
                                            if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                                                a3 = str2;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                a3 = a("QMTAuMC4wLjIwMA==");
                                            }
                                            if (b != -1) {
                                                str3 = a3;
                                                i2 = b;
                                            }
                                        } else if (lowerCase.indexOf("wap") != -1) {
                                            if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                                                a3 = str2;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                a3 = a("QMTAuMC4wLjE3Mg==");
                                            }
                                        } else {
                                            str3 = str2;
                                            i2 = b;
                                        }
                                        str3 = a3;
                                        i2 = 80;
                                    } else {
                                        i2 = i;
                                        str3 = str2;
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (a(str, i3)) {
                                    }
                                    return null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str5 = null;
                                    i3 = i;
                                    cl.c(th, "pu", "gPx1");
                                    th.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (a(str, i3)) {
                                    }
                                    return null;
                                }
                                if (a(str, i3)) {
                                }
                            } else if (string != null) {
                                if (string.contains("wap")) {
                                    String a4 = a();
                                    i = b();
                                    if (TextUtils.isEmpty(a4) || a4.equals("null")) {
                                        str7 = null;
                                        z = false;
                                    } else {
                                        str7 = a4;
                                        z = true;
                                    }
                                    if (!z) {
                                        str6 = a("QMTAuMC4wLjE3Mg==");
                                    } else {
                                        str6 = str2;
                                    }
                                    if (i == -1) {
                                        str = str6;
                                        i3 = 80;
                                    } else {
                                        str = str6;
                                        i3 = i;
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Throwable th5) {
                                            cl.c(th5, "pu", "gPx2");
                                        }
                                    }
                                    if (a(str, i3)) {
                                        return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i3));
                                    }
                                }
                            }
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        str4 = null;
                        i = -1;
                        cl.c(e, "pu", "ghp");
                        s = bt.s(context);
                        if (s == null) {
                        }
                        if (cursor != null) {
                        }
                        if (a(str, i3)) {
                        }
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        str5 = null;
                        cl.c(th, "pu", "gPx1");
                        th.printStackTrace();
                        if (cursor != null) {
                        }
                        if (a(str, i3)) {
                        }
                        return null;
                    }
                }
                str = null;
                if (cursor != null) {
                }
            } catch (SecurityException e4) {
                e = e4;
                cursor = null;
                str4 = null;
                i = -1;
                cl.c(e, "pu", "ghp");
                s = bt.s(context);
                if (s == null) {
                }
                if (cursor != null) {
                }
                if (a(str, i3)) {
                }
                return null;
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        cl.c(th8, "pu", "gPx2");
                    }
                }
                throw th;
            }
            try {
                if (a(str, i3)) {
                }
            } catch (Throwable th9) {
                ci.a(th9, "pu", "gp2");
                th9.printStackTrace();
            }
        }
        return null;
    }

    public static String a(String str) {
        return bz.c(str);
    }

    private static boolean a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            cl.c(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                cl.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static boolean c(Context context) {
        return bt.q(context) == 0;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            cl.c(th, "pu", "gdp");
            return -1;
        }
    }
}
