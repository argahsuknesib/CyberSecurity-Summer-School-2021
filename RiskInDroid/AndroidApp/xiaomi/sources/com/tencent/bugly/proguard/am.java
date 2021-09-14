package com.tencent.bugly.proguard;

import _m_j.dhq;
import java.util.HashMap;
import java.util.Map;

public final class am extends k {

    /* renamed from: O000000o  reason: collision with root package name */
    private static byte[] f5827O000000o;
    private static Map<String, String> O00000Oo = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f5828a = 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public int g = 0;
    public byte[] h = null;
    public String i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    private String x = "";

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: _m_j.dhr.O000000o(int, int):void in method: com.tencent.bugly.proguard.am.O000000o(_m_j.dhr):void, dex: classes4.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: _m_j.dhr.O000000o(int, int):void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:540)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public final void O000000o(_m_j.dhr r1) {
        /*
            r3 = this;
            int r0 = r3.f5828a
            r1 = 0
            r4.O000000o(r0, r1)
            java.lang.String r0 = r3.b
            r1 = 1
            r4.O000000o(r0, r1)
            java.lang.String r0 = r3.c
            r1 = 2
            r4.O000000o(r0, r1)
            java.lang.String r0 = r3.d
            r1 = 3
            r4.O000000o(r0, r1)
            java.lang.String r0 = r3.e
            if (r0 == 0) goto L_0x0020
            r1 = 4
            r4.O000000o(r0, r1)
        L_0x0020:
            java.lang.String r0 = r3.f
            r1 = 5
            r4.O000000o(r0, r1)
            int r0 = r3.g
            r1 = 6
            r4.O000000o(r0, r1)
            byte[] r0 = r3.h
            r1 = 7
            r4.O000000o(r0, r1)
            java.lang.String r0 = r3.i
            if (r0 == 0) goto L_0x003b
            r1 = 8
            r4.O000000o(r0, r1)
        L_0x003b:
            java.lang.String r0 = r3.j
            if (r0 == 0) goto L_0x0044
            r1 = 9
            r4.O000000o(r0, r1)
        L_0x0044:
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.k
            if (r0 == 0) goto L_0x004d
            r1 = 10
            r4.O000000o(r0, r1)
        L_0x004d:
            java.lang.String r0 = r3.l
            if (r0 == 0) goto L_0x0056
            r1 = 11
            r4.O000000o(r0, r1)
        L_0x0056:
            long r0 = r3.m
            r2 = 12
            r4.O000000o(r0, r2)
            java.lang.String r0 = r3.n
            if (r0 == 0) goto L_0x0066
            r1 = 13
            r4.O000000o(r0, r1)
        L_0x0066:
            java.lang.String r0 = r3.o
            if (r0 == 0) goto L_0x006f
            r1 = 14
            r4.O000000o(r0, r1)
        L_0x006f:
            java.lang.String r0 = r3.p
            if (r0 == 0) goto L_0x0078
            r1 = 15
            r4.O000000o(r0, r1)
        L_0x0078:
            long r0 = r3.q
            r2 = 16
            r4.O000000o(r0, r2)
            java.lang.String r0 = r3.r
            if (r0 == 0) goto L_0x0088
            r1 = 17
            r4.O000000o(r0, r1)
        L_0x0088:
            java.lang.String r0 = r3.s
            if (r0 == 0) goto L_0x0091
            r1 = 18
            r4.O000000o(r0, r1)
        L_0x0091:
            java.lang.String r0 = r3.t
            if (r0 == 0) goto L_0x009a
            r1 = 19
            r4.O000000o(r0, r1)
        L_0x009a:
            java.lang.String r0 = r3.u
            if (r0 == 0) goto L_0x00a3
            r1 = 20
            r4.O000000o(r0, r1)
        L_0x00a3:
            java.lang.String r0 = r3.v
            if (r0 == 0) goto L_0x00ac
            r1 = 21
            r4.O000000o(r0, r1)
        L_0x00ac:
            java.lang.String r0 = r3.w
            if (r0 == 0) goto L_0x00b5
            r1 = 22
            r4.O000000o(r0, r1)
        L_0x00b5:
            java.lang.String r0 = r3.x
            if (r0 == 0) goto L_0x00be
            r1 = 23
            r4.O000000o(r0, r1)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.am.O000000o(_m_j.dhr):void");
    }

    static {
        byte[] bArr = new byte[1];
        f5827O000000o = bArr;
        bArr[0] = 0;
        O00000Oo.put("", "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
     arg types: [java.util.Map<java.lang.String, java.lang.String>, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(long, int, boolean):long
     arg types: [long, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(long, int, boolean):long */
    public final void O000000o(dhq dhq) {
        this.f5828a = dhq.O000000o(this.f5828a, 0, true);
        this.b = dhq.O00000Oo(1, true);
        this.c = dhq.O00000Oo(2, true);
        this.d = dhq.O00000Oo(3, true);
        this.e = dhq.O00000Oo(4, false);
        this.f = dhq.O00000Oo(5, true);
        this.g = dhq.O000000o(this.g, 6, true);
        this.h = dhq.O00000o0(7, true);
        this.i = dhq.O00000Oo(8, false);
        this.j = dhq.O00000Oo(9, false);
        this.k = (Map) dhq.O000000o((Object) O00000Oo, 10, false);
        this.l = dhq.O00000Oo(11, false);
        this.m = dhq.O000000o(this.m, 12, false);
        this.n = dhq.O00000Oo(13, false);
        this.o = dhq.O00000Oo(14, false);
        this.p = dhq.O00000Oo(15, false);
        this.q = dhq.O000000o(this.q, 16, false);
        this.r = dhq.O00000Oo(17, false);
        this.s = dhq.O00000Oo(18, false);
        this.t = dhq.O00000Oo(19, false);
        this.u = dhq.O00000Oo(20, false);
        this.v = dhq.O00000Oo(21, false);
        this.w = dhq.O00000Oo(22, false);
        this.x = dhq.O00000Oo(23, false);
    }
}
