package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.esl;
import com.xiaomi.push.gg;
import com.xiaomi.push.il;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

class u extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6577a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f350a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(int i, XMPushService xMPushService, il ilVar) {
        super(i);
        this.f350a = xMPushService;
        this.f6577a = ilVar;
    }

    public String a() {
        return "send ack message for message.";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* renamed from: a  reason: collision with other method in class */
    public void m230a() {
        Map<String, String> map = null;
        try {
            if (esl.O000000o(this.f350a)) {
                map = aa.a(this.f350a, this.f6577a);
            }
            ab.a(this.f350a, s.a(this.f350a, this.f6577a, map));
        } catch (gg e) {
            duv.O000000o(e);
            this.f350a.a(10, e);
        }
    }
}
