package com.xiaomi.push.service;

import _m_j.duv;
import com.xiaomi.push.gg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ig;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.service.XMPushService;

class z extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6582a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ io f357a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f358a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(int i, io ioVar, il ilVar, XMPushService xMPushService) {
        super(i);
        this.f357a = ioVar;
        this.f6582a = ilVar;
        this.f358a = xMPushService;
    }

    public String a() {
        return "send ack message for clear push message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m235a() {
        try {
            ig igVar = new ig();
            igVar.d = hz.D.f70a;
            igVar.b = this.f357a.b;
            igVar.f106a = this.f357a.f129a;
            igVar.c = this.f357a.c;
            igVar.f = this.f357a.f;
            igVar.O000000o();
            igVar.e = "success clear push message.";
            ab.a(this.f358a, ab.b(this.f6582a.b, this.f6582a.f124a, igVar, hp.i));
        } catch (gg e) {
            duv.O00000o("clear push message. ".concat(String.valueOf(e)));
            this.f358a.a(10, e);
        }
    }
}
