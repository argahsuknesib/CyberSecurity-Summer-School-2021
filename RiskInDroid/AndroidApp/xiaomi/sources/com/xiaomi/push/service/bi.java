package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emi;

public class bi {

    /* renamed from: a  reason: collision with root package name */
    private static int f6525a = 8;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f288a = new byte[256];
    private int b = 0;
    private int c = 0;
    private int d = -666;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a() {
        this.c = 0;
        this.b = 0;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f288a[i2] = (byte) i2;
        }
        this.c = 0;
        this.b = 0;
        while (true) {
            int i3 = this.b;
            if (i3 >= i) {
                break;
            }
            this.c = ((this.c + a(this.f288a[i3])) + a(bArr[this.b % length])) % 256;
            a(this.f288a, this.b, this.c);
            this.b++;
        }
        if (i != 256) {
            this.d = ((this.c + a(this.f288a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(a(this.f288a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append("=");
            sb.append(this.c);
            sb.append("   j_");
            sb.append(i);
            sb.append("=");
            sb.append(this.d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.f288a[this.c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f288a[this.d]));
            if (this.f288a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            duv.O000000o(sb.toString());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.bi.a(int, byte[], boolean):void
     arg types: [int, byte[], int]
     candidates:
      com.xiaomi.push.service.bi.a(byte[], int, int):void
      com.xiaomi.push.service.bi.a(int, byte[], boolean):void */
    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] O00000Oo = emi.O00000Oo(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(O00000Oo.length + 1 + bytes.length)];
        for (int i = 0; i < O00000Oo.length; i++) {
            bArr[i] = O00000Oo[i];
        }
        bArr[O00000Oo.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[O00000Oo.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, emi.O00000Oo(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        bi biVar = new bi();
        biVar.a(bArr);
        biVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ biVar.m188a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (!z) {
            bArr3 = new byte[i2];
            i3 = 0;
        } else {
            bArr3 = bArr2;
            i3 = i;
        }
        bi biVar = new bi();
        biVar.a(bArr);
        biVar.a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ biVar.m188a());
        }
        return bArr3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public byte m188a() {
        this.b = (this.b + 1) % 256;
        this.c = (this.c + a(this.f288a[this.b])) % 256;
        a(this.f288a, this.b, this.c);
        byte[] bArr = this.f288a;
        return bArr[(a(bArr[this.b]) + a(this.f288a[this.c])) % 256];
    }
}
