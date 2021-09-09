package com.xiaomi.onetrack.h;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.h.a.a;
import java.util.HashMap;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6173a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ d d;

    g(d dVar, String str, String str2, String str3) {
        this.d = dVar;
        this.f6173a = str;
        this.b = str2;
        this.c = str3;
    }

    public void run() {
        String str;
        try {
            if (this.f6173a.contains("http://")) {
                str = this.f6173a + "/api/open/device/writeBack";
            } else {
                str = "http://" + this.f6173a + "/api/open/device/writeBack";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("instanceId", p.a().b());
            hashMap.put("imei", h.b(this.d.g));
            hashMap.put("oaid", a.a().a(this.d.g));
            hashMap.put("projectId", this.b);
            hashMap.put("user", this.c);
            String b2 = b.b(str, hashMap, false);
            if (!TextUtils.isEmpty(b2)) {
                if (!"".equals(b2)) {
                    this.d.a(b2);
                    return;
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("hint", "注册信息失败，请检查是网络环境是否在内网");
            obtain.setData(bundle);
            this.d.h.sendMessage(obtain);
        } catch (Exception e) {
            q.b(d.f6170a, e.getMessage());
        }
    }
}
