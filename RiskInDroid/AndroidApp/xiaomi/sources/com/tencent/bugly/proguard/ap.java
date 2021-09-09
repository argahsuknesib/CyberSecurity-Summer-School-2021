package com.tencent.bugly.proguard;

import _m_j.dhp;
import _m_j.dhq;
import _m_j.dhr;
import _m_j.dhs;
import java.util.HashMap;
import java.util.Map;

public final class ap extends k implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ao f5832O000000o = new ao();
    private static Map<String, String> O00000Oo = new HashMap();
    private static /* synthetic */ boolean O00000o0 = (!ap.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public boolean f5833a = true;
    public boolean b = true;
    public boolean c = true;
    public String d = "";
    public String e = "";
    public ao f = null;
    public Map<String, String> g = null;
    public long h = 0;
    public int i = 0;
    private String j = "";
    private String k = "";
    private int l = 0;

    static {
        O00000Oo.put("", "");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ap apVar = (ap) obj;
        if (!dhs.O000000o(this.f5833a, apVar.f5833a) || !dhs.O000000o(this.b, apVar.b) || !dhs.O000000o(this.c, apVar.c) || !dhs.O000000o(this.d, apVar.d) || !dhs.O000000o(this.e, apVar.e) || !dhs.O000000o(this.f, apVar.f) || !dhs.O000000o(this.g, apVar.g) || !dhs.O000000o(this.h, apVar.h) || !dhs.O000000o(this.j, apVar.j) || !dhs.O000000o(this.k, apVar.k) || !dhs.O000000o(this.l, apVar.l) || !dhs.O000000o(this.i, apVar.i)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (O00000o0) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
     arg types: [com.tencent.bugly.proguard.ao, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void
      _m_j.dhr.O000000o(java.util.Map, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Map, int):void
     arg types: [java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(java.util.Map, int):void */
    public final void O000000o(dhr dhr) {
        dhr.O000000o(this.f5833a, 0);
        dhr.O000000o(this.b, 1);
        dhr.O000000o(this.c, 2);
        String str = this.d;
        if (str != null) {
            dhr.O000000o(str, 3);
        }
        String str2 = this.e;
        if (str2 != null) {
            dhr.O000000o(str2, 4);
        }
        ao aoVar = this.f;
        if (aoVar != null) {
            dhr.O000000o((k) aoVar, 5);
        }
        Map<String, String> map = this.g;
        if (map != null) {
            dhr.O000000o((Map) map, 6);
        }
        dhr.O000000o(this.h, 7);
        String str3 = this.j;
        if (str3 != null) {
            dhr.O000000o(str3, 8);
        }
        String str4 = this.k;
        if (str4 != null) {
            dhr.O000000o(str4, 9);
        }
        dhr.O000000o(this.l, 10);
        dhr.O000000o(this.i, 11);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.dhq.O000000o(_m_j.dhq$O000000o, java.nio.ByteBuffer):int
      _m_j.dhq.O000000o(int, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
     arg types: [com.tencent.bugly.proguard.ao, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k */
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
    public final void O000000o(dhq dhq) {
        this.f5833a = dhq.O000000o(0, true);
        this.b = dhq.O000000o(1, true);
        this.c = dhq.O000000o(2, true);
        this.d = dhq.O00000Oo(3, false);
        this.e = dhq.O00000Oo(4, false);
        this.f = (ao) dhq.O000000o((k) f5832O000000o, 5, false);
        this.g = (Map) dhq.O000000o((Object) O00000Oo, 6, false);
        this.h = dhq.O000000o(this.h, 7, false);
        this.j = dhq.O00000Oo(8, false);
        this.k = dhq.O00000Oo(9, false);
        this.l = dhq.O000000o(this.l, 10, false);
        this.i = dhq.O000000o(this.i, 11, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhp.O000000o(com.tencent.bugly.proguard.k, java.lang.String):_m_j.dhp
     arg types: [com.tencent.bugly.proguard.ao, java.lang.String]
     candidates:
      _m_j.dhp.O000000o(java.lang.Object, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.Object[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(int, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.String, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.util.Map, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(boolean, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(byte[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(com.tencent.bugly.proguard.k, java.lang.String):_m_j.dhp */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhp.O000000o(java.util.Map, java.lang.String):_m_j.dhp
     arg types: [java.util.Map<java.lang.String, java.lang.String>, java.lang.String]
     candidates:
      _m_j.dhp.O000000o(java.lang.Object, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.Object[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(int, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(com.tencent.bugly.proguard.k, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.String, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(boolean, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(byte[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.util.Map, java.lang.String):_m_j.dhp */
    public final void O000000o(StringBuilder sb, int i2) {
        dhp dhp = new dhp(sb, i2);
        dhp.O000000o(this.f5833a, "enable");
        dhp.O000000o(this.b, "enableUserInfo");
        dhp.O000000o(this.c, "enableQuery");
        dhp.O000000o(this.d, "url");
        dhp.O000000o(this.e, "expUrl");
        dhp.O000000o((k) this.f, "security");
        dhp.O000000o((Map) this.g, "valueMap");
        long j2 = this.h;
        dhp.O000000o("strategylastUpdateTime");
        StringBuilder sb2 = dhp.f14642O000000o;
        sb2.append(j2);
        sb2.append(10);
        dhp.O000000o(this.j, "httpsUrl");
        dhp.O000000o(this.k, "httpsExpUrl");
        dhp.O000000o(this.l, "eventRecordCount");
        dhp.O000000o(this.i, "eventTimeInterval");
    }
}
