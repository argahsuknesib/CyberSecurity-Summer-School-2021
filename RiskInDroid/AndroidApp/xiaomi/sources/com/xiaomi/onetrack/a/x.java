package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import java.util.Map;

class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6116a;
    final /* synthetic */ Map b;
    final /* synthetic */ f c;

    x(f fVar, String str, Map map) {
        this.c = fVar;
        this.f6116a = str;
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
            if (!this.c.c(this.f6116a)) {
                this.c.b.a(this.f6116a, c.a(this.f6116a, s.a((Map<String, Object>) this.b, true), this.c.f, this.c.h, this.c.d(this.f6116a)));
            }
        } catch (Exception e) {
            q.b("OneTrackImp", "track map error: " + e.toString());
        }
    }
}
