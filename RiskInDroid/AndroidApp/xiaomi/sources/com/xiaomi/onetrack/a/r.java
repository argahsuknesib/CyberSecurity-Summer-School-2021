package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import java.util.Map;

class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6110a;
    final /* synthetic */ Map b;
    final /* synthetic */ String c;
    final /* synthetic */ f d;

    r(f fVar, String str, Map map, String str2) {
        this.d = fVar;
        this.f6110a = str;
        this.b = map;
        this.c = str2;
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
            if (!this.d.c(this.f6110a)) {
                this.d.b.a(this.f6110a, c.a(this.c, this.f6110a, s.a((Map<String, Object>) this.b, true), this.d.f, this.d.h, this.d.d(this.f6110a)));
            }
        } catch (Exception e) {
            q.b("OneTrackImp", "track json error:" + e.toString());
        }
    }
}
