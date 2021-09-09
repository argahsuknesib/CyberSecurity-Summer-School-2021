package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class bs {
    public static String a(Context context, String str, String str2) {
        try {
            String e = bp.e(context);
            return bw.a(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ci.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!bp.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            ci.a(th, "CI", "TS");
            return null;
        }
    }

    public static byte[] a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return bu.a(bArr);
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return b(context, b(context, z));
        } catch (Throwable th) {
            ci.a(th, "CI", "gz");
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bs.b(android.content.Context, boolean):com.amap.api.services.a.bs$a
     arg types: [android.content.Context, int]
     candidates:
      com.amap.api.services.a.bs.b(android.content.Context, com.amap.api.services.a.bs$a):byte[]
      com.amap.api.services.a.bs.b(android.content.Context, byte[]):byte[]
      com.amap.api.services.a.bs.b(android.content.Context, boolean):com.amap.api.services.a.bs$a */
    public static String a(Context context) {
        try {
            return a(context, b(context, false));
        } catch (Throwable th) {
            ci.a(th, "CI", "gCX");
            return null;
        }
    }

    public static byte[] b(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d = bz.d();
        if (bArr.length <= 117) {
            return bu.a(bArr, d);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = bu.a(bArr2, d);
        byte[] bArr3 = new byte[((bArr.length + NotificationCompat.FLAG_HIGH_PRIORITY) - 117)];
        System.arraycopy(a2, 0, bArr3, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
        System.arraycopy(bArr, 117, bArr3, NotificationCompat.FLAG_HIGH_PRIORITY, bArr.length - 117);
        return bArr3;
    }

    private static String a(Context context, a aVar) {
        return bu.b(b(context, aVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a0 A[SYNTHETIC, Splitter:B:19:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac A[SYNTHETIC, Splitter:B:26:0x00ac] */
    private static byte[] b(Context context, a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                a(byteArrayOutputStream, aVar.f3350a);
                a(byteArrayOutputStream, aVar.b);
                a(byteArrayOutputStream, aVar.c);
                a(byteArrayOutputStream, aVar.d);
                a(byteArrayOutputStream, aVar.e);
                a(byteArrayOutputStream, aVar.f);
                a(byteArrayOutputStream, aVar.g);
                a(byteArrayOutputStream, aVar.h);
                a(byteArrayOutputStream, aVar.i);
                a(byteArrayOutputStream, aVar.j);
                a(byteArrayOutputStream, aVar.k);
                a(byteArrayOutputStream, aVar.l);
                a(byteArrayOutputStream, aVar.m);
                a(byteArrayOutputStream, aVar.n);
                a(byteArrayOutputStream, aVar.o);
                a(byteArrayOutputStream, aVar.p);
                a(byteArrayOutputStream, aVar.q);
                a(byteArrayOutputStream, aVar.r);
                a(byteArrayOutputStream, aVar.s);
                a(byteArrayOutputStream, aVar.t);
                a(byteArrayOutputStream, aVar.u);
                a(byteArrayOutputStream, aVar.v);
                a(byteArrayOutputStream, aVar.w);
                a(byteArrayOutputStream, aVar.x);
                a(byteArrayOutputStream, aVar.y);
                byte[] a2 = a(context, byteArrayOutputStream);
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return a2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    ci.a(th, "CI", "gzx");
                    if (byteArrayOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static byte[] a(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return b(context, bz.b(byteArrayOutputStream.toByteArray()));
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                b = -1;
            } else {
                b = (byte) str.getBytes().length;
            }
            bz.a(byteArrayOutputStream, b, bz.a(str));
            return;
        }
        bz.a(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    private static a b(Context context, boolean z) {
        a aVar = new a();
        aVar.f3350a = bt.u(context);
        aVar.b = bt.m(context);
        String h = bt.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = bp.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = bp.b(context);
        aVar.i = bp.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = bt.w(context);
        aVar.l = bt.t(context);
        StringBuilder sb = new StringBuilder();
        sb.append(bt.q(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bt.p(context));
        aVar.n = sb2.toString();
        aVar.o = bt.y(context);
        aVar.p = bt.o(context);
        if (z) {
            aVar.q = "";
        } else {
            aVar.q = bt.l(context);
        }
        if (z) {
            aVar.r = "";
        } else {
            aVar.r = bt.k(context);
        }
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] n = bt.n(context);
            aVar.s = n[0];
            aVar.t = n[1];
        }
        aVar.w = bt.a();
        String b = bt.b(context);
        if (!TextUtils.isEmpty(b)) {
            aVar.x = b;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + bt.j(context) + "|serial=" + bt.i(context) + "|storage=" + bt.c() + "|ram=" + bt.x(context) + "|arch=" + bt.d();
        String a2 = bt.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.y += "|adiuExtras=" + a2;
        }
        String a3 = bt.a(context, ",", true);
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String v = bt.v(context);
        if (!TextUtils.isEmpty(v)) {
            aVar.y += "|meid=" + v;
        }
        return aVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        String f3350a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;

        private a() {
        }
    }
}
