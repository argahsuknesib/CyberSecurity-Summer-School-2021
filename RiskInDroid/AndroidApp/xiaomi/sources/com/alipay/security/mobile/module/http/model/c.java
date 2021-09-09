package com.alipay.security.mobile.module.http.model;

import com.alipay.security.mobile.module.a.a;

public class c extends a {
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p = "";

    public int a() {
        return this.f3244a ? a.a(this.h) ? 2 : 1 : "APPKEY_ERROR".equals(this.b) ? 3 : 2;
    }

    public boolean b() {
        return "1".equals(this.j);
    }

    public String c() {
        String str = this.k;
        return str == null ? "0" : str;
    }
}
