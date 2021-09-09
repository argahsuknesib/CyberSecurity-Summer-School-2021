package com.tencent.bugly.proguard;

import _m_j.dhq;
import _m_j.dhr;
import java.util.ArrayList;
import java.util.Collection;

public final class al extends k implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ArrayList<ak> f5825O000000o;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ak> f5826a = null;

    public final void O000000o(StringBuilder sb, int i) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Collection, int):void
     arg types: [java.util.ArrayList<com.tencent.bugly.proguard.ak>, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Map, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void */
    public final void O000000o(dhr dhr) {
        dhr.O000000o((Collection) this.f5826a, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
     arg types: [java.util.ArrayList<com.tencent.bugly.proguard.ak>, int, int]
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
    public final void O000000o(dhq dhq) {
        if (f5825O000000o == null) {
            f5825O000000o = new ArrayList<>();
            f5825O000000o.add(new ak());
        }
        this.f5826a = (ArrayList) dhq.O000000o((Object) f5825O000000o, 0, true);
    }
}
