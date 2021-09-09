package com.xiaomi.push.service;

import _m_j.ers;
import com.xiaomi.push.ht;
import java.util.List;

public class l implements ers {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final XMPushService f6567a;

    public l(XMPushService xMPushService) {
        this.f6567a = xMPushService;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f6567a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    public void a(List<ht> list, String str, String str2) {
        this.f6567a.a(new m(this, 4, str, list, str2));
    }
}
