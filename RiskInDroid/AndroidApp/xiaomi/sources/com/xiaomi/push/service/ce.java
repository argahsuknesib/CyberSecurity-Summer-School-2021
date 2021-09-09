package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;

class ce implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6547a;

    ce(XMPushService xMPushService) {
        this.f6547a = xMPushService;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean
     arg types: [com.xiaomi.push.service.XMPushService, int]
     candidates:
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, _m_j.eqb):_m_j.eqb
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):com.xiaomi.push.service.az$b
      com.xiaomi.push.service.XMPushService.a(android.content.Intent, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Intent):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Context):boolean
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):boolean
      com.xiaomi.push.service.XMPushService.a(int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService$j, long):void
      com.xiaomi.push.service.XMPushService.a(byte[], java.lang.String):void
      _m_j.eqe.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean */
    public void run() {
        boolean unused = this.f6547a.f212a = true;
        try {
            duv.O000000o("try to trigger the wifi digest broadcast.");
            Object systemService = this.f6547a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                emg.O00000Oo(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable unused2) {
        }
    }
}
