package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elo;
import _m_j.eru;
import com.xiaomi.push.hp;
import com.xiaomi.push.io;
import java.lang.ref.WeakReference;

public class b extends elo.O000000o {

    /* renamed from: a  reason: collision with root package name */
    private io f6517a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f283a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f284a = false;

    public b(io ioVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f6517a = ioVar;
        this.f283a = weakReference;
        this.f284a = z;
    }

    public String a() {
        return "22";
    }

    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f283a;
        if (weakReference != null && this.f6517a != null && (xMPushService = weakReference.get()) != null) {
            this.f6517a.b = aw.a();
            this.f6517a.O000000o(false);
            duv.O00000o0("MoleInfo aw_ping : send aw_Ping msg " + this.f6517a.b);
            try {
                String str = this.f6517a.f;
                xMPushService.a(str, eru.O000000o(ab.a(str, this.f6517a.c, this.f6517a, hp.i)), this.f284a);
            } catch (Exception e) {
                duv.O00000o("MoleInfo aw_ping : send help app ping error" + e.toString());
            }
        }
    }
}
