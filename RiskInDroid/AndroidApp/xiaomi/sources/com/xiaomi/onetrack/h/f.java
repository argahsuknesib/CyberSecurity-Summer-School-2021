package com.xiaomi.onetrack.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.onetrack.f.a;

class f extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f6172a;

    f(d dVar) {
        this.f6172a = dVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("host");
            String stringExtra2 = intent.getStringExtra("packagename");
            String stringExtra3 = intent.getStringExtra("projectId");
            String stringExtra4 = intent.getStringExtra("user");
            boolean booleanExtra = intent.getBooleanExtra("logon", false);
            boolean booleanExtra2 = intent.getBooleanExtra("quickuploadon", false);
            String d = a.d();
            if (!TextUtils.isEmpty(stringExtra2) && !"".equals(stringExtra2)) {
                if (d.equals(stringExtra2)) {
                    q.f6178a = booleanExtra;
                    q.b = booleanExtra2;
                    if (booleanExtra2) {
                        this.f6172a.a(stringExtra, stringExtra3, stringExtra4);
                    }
                }
            }
        } catch (Exception e) {
            q.b(d.f6170a, e.getMessage());
        }
    }
}
