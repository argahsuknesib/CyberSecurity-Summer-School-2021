package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.epq;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;

class c extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f6542a = null;

    /* renamed from: a  reason: collision with other field name */
    private epq[] f309a;

    public c(XMPushService xMPushService, epq[] epqArr) {
        super(4);
        this.f6542a = xMPushService;
        this.f309a = epqArr;
    }

    public String a() {
        return "batch send message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m195a() {
        try {
            if (this.f309a != null) {
                this.f6542a.a(this.f309a);
            }
        } catch (gg e) {
            duv.O000000o(e);
            this.f6542a.a(10, e);
        }
    }
}
