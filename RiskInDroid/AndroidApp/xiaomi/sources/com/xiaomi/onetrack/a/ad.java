package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import java.util.Map;
import org.json.JSONObject;

class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f6092a;
    final /* synthetic */ f b;

    ad(f fVar, Map map) {
        this.b = fVar;
        this.f6092a = map;
    }

    public void run() {
        try {
            this.b.b.a("ot_profile_increment", c.b(new JSONObject((Map<?, ?>) this.f6092a), this.b.f, this.b.h, this.b.d("ot_profile_increment")));
        } catch (Exception e) {
            q.b("OneTrackImp", "userProfileIncrement map error:" + e.toString());
        }
    }
}
