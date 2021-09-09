package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.q;

class l extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f6131a;

    l(k kVar) {
        this.f6131a = kVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean a2 = c.a();
        q.a("UploadTimer", "UploadTimer netReceiver, 网络是否可用=".concat(String.valueOf(a2)));
        if (a2) {
            int[] iArr = {0, 1, 2};
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                int a3 = com.xiaomi.onetrack.b.l.a(i2);
                if (!this.f6131a.hasMessages(i2)) {
                    this.f6131a.sendEmptyMessageDelayed(i2, (long) a3);
                }
            }
        }
    }
}
