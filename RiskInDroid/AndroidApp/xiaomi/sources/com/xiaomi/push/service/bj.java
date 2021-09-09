package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.erm;
import com.xiaomi.push.service.XMPushService;
import java.util.Objects;

class bj {
    private static int d = 300000;

    /* renamed from: a  reason: collision with root package name */
    private int f6526a;

    /* renamed from: a  reason: collision with other field name */
    private long f289a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f290a;
    private int b = 0;
    private int c = 0;

    public bj(XMPushService xMPushService) {
        this.f290a = xMPushService;
        this.f6526a = 500;
        this.f289a = 0;
    }

    private int a() {
        if (this.b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f289a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f289a < 310000) {
            int i2 = this.f6526a;
            int i3 = d;
            if (i2 >= i3) {
                return i2;
            }
            this.c++;
            if (this.c >= 4) {
                return i3;
            }
            double d2 = (double) i2;
            Double.isNaN(d2);
            this.f6526a = (int) (d2 * 1.5d);
            return i2;
        }
        this.f6526a = 1000;
        this.c = 0;
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m189a() {
        this.f289a = System.currentTimeMillis();
        this.f290a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f290a.m122a()) {
            duv.O00000o0("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f290a.m123a(1)) {
                this.b++;
            }
            this.f290a.a(1);
            XMPushService xMPushService = this.f290a;
            Objects.requireNonNull(xMPushService);
            xMPushService.a(new XMPushService.e());
        } else if (!this.f290a.m123a(1)) {
            int a2 = a();
            this.b++;
            duv.O000000o("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f290a;
            Objects.requireNonNull(xMPushService2);
            xMPushService2.a(new XMPushService.e(), (long) a2);
            if (this.b == 2 && erm.O000000o.f15749O000000o.f15748O000000o) {
                aj.b();
            }
            if (this.b == 3) {
                aj.a();
            }
        }
    }
}
