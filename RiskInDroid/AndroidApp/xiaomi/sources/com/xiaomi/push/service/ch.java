package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eov;
import _m_j.eqc;
import _m_j.eqf;
import java.util.Map;

class ch extends eqc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6550a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ch(XMPushService xMPushService, Map map, int i, String str, eqf eqf) {
        super(map, i, str, eqf);
        this.f6550a = xMPushService;
    }

    public byte[] a() {
        try {
            eov.O00000Oo o00000Oo = new eov.O00000Oo();
            o00000Oo.O000000o(bo.a().m192a());
            return o00000Oo.O00000o0();
        } catch (Exception e) {
            duv.O000000o("getOBBString err: " + e.toString());
            return null;
        }
    }
}
