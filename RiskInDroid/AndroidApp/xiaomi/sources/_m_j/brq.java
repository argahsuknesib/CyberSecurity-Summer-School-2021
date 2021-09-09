package _m_j;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

public final class brq {
    private static String O000000o() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            bsf.O00000Oo(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    public static java.net.Proxy O000000o(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? O000000o(context, new URI("http://restapi.amap.com")) : O00000Oo(context);
        } catch (Throwable th) {
            bsf.O00000Oo(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy O000000o(Context context, URI uri) {
        java.net.Proxy proxy;
        if (O00000o0(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                bsf.O00000Oo(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int O00000Oo() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            bsf.O00000Oo(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x015c A[SYNTHETIC, Splitter:B:119:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0167 A[SYNTHETIC, Splitter:B:124:0x0167] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0176 A[Catch:{ Throwable -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x018d A[SYNTHETIC, Splitter:B:136:0x018d] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd A[SYNTHETIC, Splitter:B:65:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ee A[SYNTHETIC, Splitter:B:80:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0104 A[Catch:{ all -> 0x00be }] */
    private static java.net.Proxy O00000Oo(Context context) {
        boolean z;
        Cursor cursor;
        Throwable th;
        String str;
        int i;
        String O0000oO;
        int i2;
        String str2;
        Throwable th2;
        int i3;
        String str3;
        boolean z2;
        boolean z3;
        String str4;
        String str5;
        int i4;
        boolean z4;
        String str6;
        boolean z5;
        String str7;
        if (O00000o0(context)) {
            z = false;
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
                                String O000000o2 = O000000o();
                                i = O00000Oo();
                                try {
                                    if (TextUtils.isEmpty(O000000o2) || O000000o2.equals("null")) {
                                        str = null;
                                        z5 = false;
                                    } else {
                                        str = O000000o2;
                                        z5 = true;
                                    }
                                    if (!z5) {
                                        try {
                                            str7 = brs.O00000o0("QMTAuMC4wLjIwMA==");
                                        } catch (SecurityException e) {
                                            e = e;
                                            bsf.O00000Oo(e, "pu", "ghp");
                                            O0000oO = bww.O0000oO(context);
                                            if (O0000oO == null) {
                                            }
                                            if (cursor != null) {
                                            }
                                            int i5 = i2;
                                            if (str2 != null) {
                                            }
                                            if (z) {
                                            }
                                            return null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            i4 = i;
                                            str5 = str;
                                            try {
                                                bsf.O00000Oo(th, "pu", "gPx1");
                                                th.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                int i52 = i2;
                                                if (str2 != null) {
                                                }
                                                if (z) {
                                                }
                                                return null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                if (cursor != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    } else {
                                        str7 = str;
                                    }
                                    i2 = i == -1 ? 80 : i;
                                    str2 = str7;
                                    if (cursor != null) {
                                    }
                                } catch (SecurityException e2) {
                                    e = e2;
                                    str = null;
                                    bsf.O00000Oo(e, "pu", "ghp");
                                    O0000oO = bww.O0000oO(context);
                                    if (O0000oO == null) {
                                        String lowerCase = O0000oO.toLowerCase(Locale.US);
                                        String O000000o3 = O000000o();
                                        int O00000Oo = O00000Oo();
                                        if (lowerCase.indexOf("ctwap") != -1) {
                                            if (TextUtils.isEmpty(O000000o3) || O000000o3.equals("null")) {
                                                O000000o3 = str;
                                                z3 = false;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                O000000o3 = brs.O00000o0("QMTAuMC4wLjIwMA==");
                                            }
                                            if (O00000Oo != -1) {
                                                str3 = O000000o3;
                                                i3 = O00000Oo;
                                            }
                                        } else if (lowerCase.indexOf("wap") != -1) {
                                            if (TextUtils.isEmpty(O000000o3) || O000000o3.equals("null")) {
                                                O000000o3 = str;
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            if (!z2) {
                                                O000000o3 = brs.O00000o0("QMTAuMC4wLjE3Mg==");
                                            }
                                        } else {
                                            str3 = str;
                                            i3 = O00000Oo;
                                        }
                                        str3 = O000000o3;
                                        i3 = 80;
                                    } else {
                                        i3 = i;
                                        str3 = str;
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                        }
                                    }
                                    int i522 = i2;
                                    if (str2 != null) {
                                    }
                                    if (z) {
                                    }
                                    return null;
                                } catch (Throwable th6) {
                                    th = th6;
                                    str5 = null;
                                    i4 = i;
                                    bsf.O00000Oo(th, "pu", "gPx1");
                                    th.printStackTrace();
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Throwable th7) {
                                            th2 = th7;
                                        }
                                    }
                                    int i5222 = i2;
                                    if (str2 != null) {
                                    }
                                    if (z) {
                                    }
                                    return null;
                                }
                                int i52222 = i2;
                                if (str2 != null) {
                                }
                                if (z) {
                                }
                            } else if (string != null) {
                                if (string.contains("wap")) {
                                    String O000000o4 = O000000o();
                                    i = O00000Oo();
                                    if (TextUtils.isEmpty(O000000o4) || O000000o4.equals("null")) {
                                        str6 = null;
                                        z4 = false;
                                    } else {
                                        str6 = O000000o4;
                                        z4 = true;
                                    }
                                    String O00000o0 = !z4 ? brs.O00000o0("QMTAuMC4wLjE3Mg==") : str;
                                    if (i == -1) {
                                        str2 = O00000o0;
                                        i2 = 80;
                                    } else {
                                        str2 = O00000o0;
                                        i2 = i;
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Throwable th8) {
                                            th2 = th8;
                                        }
                                    }
                                    int i522222 = i2;
                                    if (str2 != null) {
                                        try {
                                            if (str2.length() > 0 && i522222 != -1) {
                                                z = true;
                                            }
                                        } catch (Throwable th9) {
                                            bsc.O000000o(th9, "pu", "gp2");
                                            th9.printStackTrace();
                                        }
                                    }
                                    if (z) {
                                        return new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str2, i522222));
                                    }
                                }
                            }
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        str4 = null;
                        i = -1;
                        bsf.O00000Oo(e, "pu", "ghp");
                        O0000oO = bww.O0000oO(context);
                        if (O0000oO == null) {
                        }
                        if (cursor != null) {
                        }
                        int i5222222 = i2;
                        if (str2 != null) {
                        }
                        if (z) {
                        }
                        return null;
                    } catch (Throwable th10) {
                        th = th10;
                        str5 = null;
                        i4 = -1;
                        bsf.O00000Oo(th, "pu", "gPx1");
                        th.printStackTrace();
                        if (cursor != null) {
                        }
                        int i52222222 = i2;
                        if (str2 != null) {
                        }
                        if (z) {
                        }
                        return null;
                    }
                }
                str2 = null;
                i2 = -1;
                if (cursor != null) {
                }
            } catch (SecurityException e4) {
                e = e4;
                cursor = null;
                str4 = null;
                i = -1;
                bsf.O00000Oo(e, "pu", "ghp");
                O0000oO = bww.O0000oO(context);
                if (O0000oO == null) {
                }
                if (cursor != null) {
                }
                int i522222222 = i2;
                if (str2 != null) {
                }
                if (z) {
                }
                return null;
            } catch (Throwable th11) {
                th = th11;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th12) {
                        bsf.O00000Oo(th12, "pu", "gPx2");
                    }
                }
                throw th;
            }
            int i5222222222 = i2;
            if (str2 != null) {
            }
            if (z) {
            }
        }
        return null;
        bsf.O00000Oo(th2, "pu", "gPx2");
        int i52222222222 = i2;
        if (str2 != null) {
        }
        if (z) {
        }
        return null;
    }

    private static boolean O00000o0(Context context) {
        return bww.O0000o(context) == 0;
    }
}
