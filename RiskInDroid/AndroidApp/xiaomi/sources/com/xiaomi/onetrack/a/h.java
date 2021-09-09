package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import org.json.JSONObject;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6100a;
    final /* synthetic */ Number b;
    final /* synthetic */ f c;

    h(f fVar, String str, Number number) {
        this.c = fVar;
        this.f6100a = str;
        this.b = number;
    }

    public void run() {
        try {
            this.c.b.a("ot_profile_increment", c.b(new JSONObject().put(this.f6100a, this.b), this.c.f, this.c.h, this.c.d("ot_profile_increment")));
        } catch (Exception e) {
            q.b("OneTrackImp", "userProfileIncrement single error:" + e.toString());
        }
    }
}
