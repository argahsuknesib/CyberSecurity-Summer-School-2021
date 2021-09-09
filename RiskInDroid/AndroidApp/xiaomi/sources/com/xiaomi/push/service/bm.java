package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.epq;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;

class bm extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private epq f6528a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f292a = null;

    public bm(XMPushService xMPushService, epq epq) {
        super(4);
        this.f292a = xMPushService;
        this.f6528a = epq;
    }

    public String a() {
        return "send a message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m190a() {
        try {
            if (this.f6528a != null) {
                this.f292a.a(this.f6528a);
            }
        } catch (gg e) {
            duv.O000000o(e);
            this.f292a.a(10, e);
        }
    }
}
