package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import com.xiaomi.onetrack.h.z;
import java.util.Map;
import org.json.JSONObject;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f6101a;
    final /* synthetic */ Map b;
    final /* synthetic */ f c;

    i(f fVar, boolean z, Map map) {
        this.c = fVar;
        this.f6101a = z;
        this.b = map;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject
     arg types: [java.util.Map, int]
     candidates:
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, com.xiaomi.onetrack.h.s$a):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(org.json.JSONObject, org.json.JSONObject):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(java.lang.String, java.lang.String):void
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject */
    public void run() {
        try {
            if (!this.f6101a) {
                JSONObject a2 = s.a((Map<String, Object>) this.b, false);
                String u = z.u();
                String w = z.w();
                a2.put("uid", u);
                a2.put("uid_type", w);
                this.c.b.a("ot_logout", c.d(a2, this.c.f, this.c.h, this.c.d("ot_logout")));
            }
            z.v();
            z.x();
        } catch (Exception e) {
            q.b("OneTrackImp", "logout error:" + e.toString());
        }
    }
}
