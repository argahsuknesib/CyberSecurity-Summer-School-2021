package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import java.util.Map;

class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f6089a;
    final /* synthetic */ f b;

    aa(f fVar, Map map) {
        this.b = fVar;
        this.f6089a = map;
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
            this.b.b.a("ot_profile_set", c.a(s.a((Map<String, Object>) this.f6089a, false), this.b.f, this.b.h, this.b.d("ot_profile_set")));
        } catch (Exception e) {
            q.b("OneTrackImp", "setUserProfile map error:" + e.toString());
        }
    }
}
