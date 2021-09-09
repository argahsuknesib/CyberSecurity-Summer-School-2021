package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public class dn {

    /* renamed from: a  reason: collision with root package name */
    private Context f3406a;
    private String b;
    private String c;
    private String d;
    private String e;

    public dn(Context context, String str, String str2, String str3) throws bo {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new bo("无效的参数 - IllegalArgumentException");
        }
        this.f3406a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public void a(String str) throws bo {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new bo("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] a2 = bz.a(this.e);
        if (a2 == null) {
            return new byte[]{0, 0};
        }
        int length = a2.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[SYNTHETIC, Splitter:B:24:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A[SYNTHETIC, Splitter:B:28:0x006b] */
    public byte[] a() {
        int i;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        i = 0;
        bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bz.a(byteArrayOutputStream, this.c);
                bz.a(byteArrayOutputStream, this.d);
                bz.a(byteArrayOutputStream, this.b);
                bz.a(byteArrayOutputStream, String.valueOf(bt.q(this.f3406a)));
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable th) {
            }
            byteArrayOutputStream.write(a(i));
            byteArrayOutputStream.write(b(this.e));
            byteArrayOutputStream.write(bz.a(this.e));
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                cl.c(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                }
                return bArr;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        }
        return bArr;
    }
}
