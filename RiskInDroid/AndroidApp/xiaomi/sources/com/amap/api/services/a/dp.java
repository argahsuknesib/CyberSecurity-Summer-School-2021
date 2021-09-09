package com.amap.api.services.a;

import _m_j.jdn;
import android.content.Context;
import com.amap.api.services.a.cw;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class dp {
    public static void a(Context context, dj djVar, String str, int i, int i2, String str2) {
        djVar.f3401a = cj.c(context, str);
        djVar.d = i;
        djVar.b = (long) i2;
        djVar.c = str2;
    }

    public static dj a(WeakReference<dj> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new dj());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0063 A[SYNTHETIC, Splitter:B:48:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x006d A[SYNTHETIC, Splitter:B:53:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0079 A[SYNTHETIC, Splitter:B:60:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0083 A[SYNTHETIC, Splitter:B:65:0x0083] */
    static byte[] a(cw cwVar, String str, boolean z) {
        cw.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = cwVar.a(str);
            if (bVar == null) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                inputStream = bVar.a(0);
                if (inputStream == null) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return bArr;
                }
                byte[] bArr2 = new byte[inputStream.available()];
                inputStream.read(bArr2);
                if (z) {
                    cwVar.c(str);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                return bArr2;
            } catch (Throwable th6) {
                th = th6;
                try {
                    cl.c(th, "sui", "rdS");
                    if (inputStream != null) {
                    }
                    if (bVar != null) {
                    }
                    return bArr;
                } catch (Throwable th7) {
                    th = th7;
                    if (inputStream != null) {
                    }
                    if (bVar != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            bVar = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String a() {
        return bz.a(System.currentTimeMillis());
    }

    public static String a(Context context, by byVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = bt.g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(byVar.c());
            sb.append("\",\"product\":\"");
            sb.append(byVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(byVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(bt.e(context));
            sb.append("\",\"np\":\"");
            sb.append(bt.c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(bt.d(context));
            sb.append("\",\"ant\":\"");
            sb.append(bt.f(context));
            sb.append(jdn.f1779O000000o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append(jdn.f1779O000000o);
        return stringBuffer.toString();
    }
}
