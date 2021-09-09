package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;

public class ag extends a {
    public static ag b = null;
    public static String c = "getProgramData";

    public static ag c() {
        if (b == null) {
            b = new ag();
        }
        return b;
    }

    public void a(int i, String str, a.c cVar) {
        new ah(this, cVar, c, i, str).a();
    }
}
