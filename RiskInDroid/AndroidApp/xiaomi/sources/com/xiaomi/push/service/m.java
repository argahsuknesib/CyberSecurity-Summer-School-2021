package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eru;
import android.text.TextUtils;
import com.xiaomi.push.hp;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class m extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f6568a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f339a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f340a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(l lVar, int i, String str, List list, String str2) {
        super(i);
        this.f6568a = lVar;
        this.f339a = str;
        this.f340a = list;
        this.b = str2;
    }

    public String a() {
        return "Send tiny data.";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void
     arg types: [java.lang.String, byte[], int]
     candidates:
      com.xiaomi.push.service.XMPushService.a(_m_j.eqr, java.lang.String, java.lang.String):_m_j.eqr
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, int, java.lang.Exception):void
      _m_j.eqe.a(_m_j.eqb, int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void */
    /* renamed from: a  reason: collision with other method in class */
    public void m220a() {
        String a2 = this.f6568a.a(this.f339a);
        ArrayList<io> a3 = bs.a(this.f340a, this.f339a, a2, 32768);
        if (a3 != null) {
            Iterator<io> it = a3.iterator();
            while (it.hasNext()) {
                io next = it.next();
                next.O000000o("uploadWay", "longXMPushService");
                il a4 = ab.a(this.f339a, a2, next, hp.i);
                if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f339a, this.b)) {
                    if (a4.f122a == null) {
                        ic icVar = new ic();
                        icVar.f84a = "-1";
                        a4.f122a = icVar;
                    }
                    ic icVar2 = a4.f122a;
                    String str = this.b;
                    if (icVar2.f89b == null) {
                        icVar2.f89b = new HashMap();
                    }
                    icVar2.f89b.put("ext_traffic_source_pkg", str);
                }
                this.f6568a.f6567a.a(this.f339a, eru.O000000o(a4), true);
            }
            return;
        }
        duv.O00000o("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
    }
}
