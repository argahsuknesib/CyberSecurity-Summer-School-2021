package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import org.json.JSONObject;

class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f6090a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    ab(f fVar, Object obj, String str) {
        this.c = fVar;
        this.f6090a = obj;
        this.b = str;
    }

    public void run() {
        try {
            if (!s.b(this.f6090a)) {
                s.a("OneTrackImp", this.b);
                return;
            }
            this.c.b.a("ot_profile_set", c.a(new JSONObject().put(this.b, this.f6090a), this.c.f, this.c.h, this.c.d("ot_profile_set")));
        } catch (Exception e) {
            q.b("OneTrackImp", "setUserProfile single error:" + e.toString());
        }
    }
}
