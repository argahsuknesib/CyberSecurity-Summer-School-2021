package com.autonavi.httpdns;

import _m_j.bun;
import _m_j.buo;
import android.content.Context;
import java.util.ArrayList;

public class HttpDnsManager {

    /* renamed from: O000000o  reason: collision with root package name */
    buo f3565O000000o = null;
    private ArrayList<String> O00000Oo = new ArrayList<>(12);

    public HttpDnsManager(Context context) {
        this.f3565O000000o = bun.O000000o(context, "154081");
        this.O00000Oo.add("apilocatesrc.amap.com");
        this.f3565O000000o.O000000o(this.O00000Oo);
        this.f3565O000000o.O000000o();
    }
}
