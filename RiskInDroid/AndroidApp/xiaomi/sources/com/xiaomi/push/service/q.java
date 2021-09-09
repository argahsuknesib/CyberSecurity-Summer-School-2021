package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import java.util.Collection;
import java.util.Objects;

public class q extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f6572a;

    /* renamed from: a  reason: collision with other field name */
    private String f345a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f346a;
    private String b;
    private String c;

    public q(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f6572a = xMPushService;
        this.f345a = str;
        this.f346a = bArr;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return "register app";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m228a() {
        az.b bVar;
        n a2 = o.m222a((Context) this.f6572a);
        if (a2 == null) {
            try {
                a2 = o.a(this.f6572a, this.f345a, this.b, this.c);
            } catch (Exception e) {
                duv.O00000o("fail to register push account. ".concat(String.valueOf(e)));
            }
        }
        if (a2 == null) {
            duv.O00000o("no account for mipush");
            r.a(this.f6572a, 70000002, "no account.");
            return;
        }
        Collection<az.b> a3 = az.a().m177a("5");
        if (a3.isEmpty()) {
            bVar = a2.a(this.f6572a);
            ab.a(this.f6572a, bVar);
            az.a().a(bVar);
        } else {
            bVar = a3.iterator().next();
        }
        if (this.f6572a.m127c()) {
            try {
                if (bVar.f272a == az.c.c) {
                    ab.a(this.f6572a, this.f345a, this.f346a);
                } else if (bVar.f272a == az.c.f6516a) {
                    XMPushService xMPushService = this.f6572a;
                    XMPushService xMPushService2 = this.f6572a;
                    Objects.requireNonNull(xMPushService2);
                    xMPushService.a(new XMPushService.b(bVar));
                }
            } catch (gg e2) {
                duv.O00000o("meet error, disconnect connection. ".concat(String.valueOf(e2)));
                this.f6572a.a(10, e2);
            }
        } else {
            this.f6572a.a(true);
        }
    }
}
