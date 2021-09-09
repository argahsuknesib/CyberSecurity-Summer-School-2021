package com.xiaomi.push.service;

import _m_j.duv;
import com.xiaomi.push.service.bq;

class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bq f6534a;

    br(bq bqVar) {
        this.f6534a = bqVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.bq.a(com.xiaomi.push.service.bq, boolean):boolean
     arg types: [com.xiaomi.push.service.bq, int]
     candidates:
      com.xiaomi.push.service.bq.a(java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.push.service.bq.a(com.xiaomi.push.service.bq, boolean):boolean */
    public void run() {
        try {
            for (bq.a run : bq.a(this.f6534a).values()) {
                run.run();
            }
        } catch (Exception e) {
            duv.O000000o("Sync job exception :" + e.getMessage());
        }
        boolean unused = this.f6534a.f302a = false;
    }
}
