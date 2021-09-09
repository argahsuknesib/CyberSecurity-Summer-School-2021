package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.l;
import org.json.JSONObject;

class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6109a;
    final /* synthetic */ f b;

    q(f fVar, String str) {
        this.b = fVar;
        this.f6109a = str;
    }

    public void run() {
        try {
            String a2 = l.a(this.b.i());
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                jSONObject.remove(this.f6109a);
                l.a(this.b.i(), jSONObject.toString());
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.h.q.b("OneTrackImp", "removeCommonProperty error:" + e.toString());
        }
    }
}
