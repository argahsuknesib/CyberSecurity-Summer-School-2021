package com.tencent.bugly.proguard;

import _m_j.dhq;
import _m_j.dhr;

public final class ah extends k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f5818a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    private String e = "";

    public final void O000000o(StringBuilder sb, int i) {
    }

    public final void O000000o(dhr dhr) {
        dhr.O000000o(this.f5818a, 0);
        String str = this.b;
        if (str != null) {
            dhr.O000000o(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            dhr.O000000o(str2, 2);
        }
        String str3 = this.e;
        if (str3 != null) {
            dhr.O000000o(str3, 3);
        }
        String str4 = this.d;
        if (str4 != null) {
            dhr.O000000o(str4, 4);
        }
    }

    public final void O000000o(dhq dhq) {
        this.f5818a = dhq.O00000Oo(0, true);
        this.b = dhq.O00000Oo(1, false);
        this.c = dhq.O00000Oo(2, false);
        this.e = dhq.O00000Oo(3, false);
        this.d = dhq.O00000Oo(4, false);
    }
}
