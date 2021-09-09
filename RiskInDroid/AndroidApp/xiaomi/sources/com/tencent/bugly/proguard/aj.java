package com.tencent.bugly.proguard;

import _m_j.dhq;
import _m_j.dhr;

public final class aj extends k implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static byte[] f5821O000000o;

    /* renamed from: a  reason: collision with root package name */
    private byte f5822a = 0;
    private String b = "";
    private byte[] c = null;

    public final void O000000o(StringBuilder sb, int i) {
    }

    public aj() {
    }

    public aj(byte b2, String str, byte[] bArr) {
        this.f5822a = b2;
        this.b = str;
        this.c = bArr;
    }

    public final void O000000o(dhr dhr) {
        dhr.O000000o(this.f5822a, 0);
        dhr.O000000o(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            dhr.O000000o(bArr, 2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(byte, int, boolean):byte
     arg types: [byte, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(byte, int, boolean):byte */
    public final void O000000o(dhq dhq) {
        this.f5822a = dhq.O000000o(this.f5822a, 0, true);
        this.b = dhq.O00000Oo(1, true);
        if (f5821O000000o == null) {
            byte[] bArr = new byte[1];
            f5821O000000o = bArr;
            bArr[0] = 0;
        }
        this.c = dhq.O00000o0(2, false);
    }
}
